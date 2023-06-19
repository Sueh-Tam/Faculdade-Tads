import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoClientePJ {
    private Connection conn;
    private Statement st;

    private void conectar(){
        try {

            this.conn = GerenciarConexao.pegarConexao();
            st = conn.createStatement();

        } catch (ClassNotFoundException e1) {
            System.out.println(e1);
        } catch (Exception e2) {
            System.out.println(e2);
        }
    }

    private void desconectar(){
        try {
            
            st.close();
            conn.close();
        
        } catch (SQLException e1) {
            System.out.println(e1);
        } 
    }

    public boolean inserir(ClientePj cli){
        boolean resultado = false;
        try {
            this.conectar();

            PreparedStatement pst = conn.prepareStatement(
                "INSERT INTO tb_clientes_pj (cod_cli_pj, nome, cnpj)"
                + "VALUES (null, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            pst.setString(1, cli.getNome());
            pst.setString(2, cli.getCnpj());
            pst.executeUpdate();
 
            ResultSet rs = pst.getGeneratedKeys();
            int idCliente = 0;
            if(rs.next()){
                idCliente = rs.getInt(1);
                PreparedStatement pstEnd = conn.prepareStatement(
                    "INSERT INTO tb_enderecos_pj (cod_end, cod_cli_pj, rua, numero, bairro, cep)"
                    +"VALUES(NULL, ?, ?, ?, ?, ?)"
                );
                pstEnd.setInt(1, idCliente);
                pstEnd.setString(2, cli.getEnderecoPJ().getRua());
                pstEnd.setInt(3, cli.getEnderecoPJ().getNumero());
                pstEnd.setString(4, cli.getEnderecoPJ().getBairro());
                pstEnd.setString(5, cli.getEnderecoPJ().getCep());
                pstEnd.executeUpdate();
                
                resultado = true;

            }
            
            
        } catch (Exception e) {
            System.out.println("Erro na inserção, erro: "+ e.getMessage());
        }finally{
            this.desconectar();
        }

        return resultado;
    }
    public ClientePj consultar(int cod){
        ClientePj cli = null;
        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM tb_clientes_pj AS c, tb_enderecos_pj AS e" + 
                " WHERE c.cod_cli_pj = e.cod_cli_pj " +
                "AND c.cod_cli_pj = " + cod + ";"
                );
            if(rs.next()){
                cli = new ClientePj();
                cli.setCodigoClientePJ(rs.getInt("cod_cli_pj"));
                cli.setCnpj(rs.getString("cnpj"));
                cli.setNome(rs.getString("nome"));

                EnderecoPj end = new EnderecoPj();

                end.setCodigo(rs.getInt("cod_end"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                end.setBairro(rs.getString("bairro"));
                end.setCep(rs.getString("cep"));

                cli.setEnderecoPJ(end);
            
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta: "+ e.getMessage());
        }finally{
            this.desconectar();
        }
        return cli;
    }

    public int alterar(ClientePj cli){
        int qtde = 0;

        try {
            this.conectar();

            PreparedStatement pst = conn.prepareStatement(
                "UPDATE tb_clientes_pj SET nome = ?, cnpj = ?"
                + " WHERE cod_cli_pj = ?;"
            );
            pst.setString(1, cli.getNome());
            pst.setString(2, cli.getCnpj());
            pst.setInt(3, cli.getCodigoClientePJ());
            pst.executeUpdate();

            qtde = pst.getUpdateCount();
            System.out.println("usuario afetados: "+qtde);
            if(qtde > 0){
                PreparedStatement pstEnd = conn.prepareStatement(
                    "UPDATE tb_enderecos_pj SET rua = ?, numero = ?, bairro = ?, cep = ? WHERE cod_cli_pj = ?;"
                );
                pstEnd.setString(1, cli.getEnderecoPJ().getRua());
                pstEnd.setInt(2, cli.getEnderecoPJ().getNumero());
                pstEnd.setString(3, cli.getEnderecoPJ().getBairro());
                pstEnd.setString(4, cli.getEnderecoPJ().getCep());
                pstEnd.setInt(5, cli.getCodigoClientePJ());
                pstEnd.executeUpdate();
            }else{
                System.out.println("Não foi encontrado nenhum endereço cadastrado para o usuário: "+cli.getNome());
            }
            
        } catch (Exception e) {
            System.out.println("Erro na alteração: "+e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }
}
