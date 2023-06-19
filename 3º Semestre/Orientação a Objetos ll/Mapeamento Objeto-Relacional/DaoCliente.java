import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


import java.sql.SQLException;

 
public class DaoCliente {
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

    public boolean InserirCliente(Cliente c){
        boolean resultado = false;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date data_atual = new Date();  
        try {
            this.conectar();
            String comando = "INSERT INTO  clientes VALUES(NULL,"+"'"+ c.getNome() + "','" + c.getEndereco() + "','" + c.getData_aniversaio() + "','" + formatter.format(data_atual) + "', '"+ formatter.format(data_atual)+"');";
            System.out.println(comando);
            st.executeUpdate(comando);
            
            resultado = true;
            
        } catch (Exception e) {
            System.out.println("Erro na inserção do cliente, Erro: "+ e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    public Cliente consultarCliente(int cod){
        Cliente c = new Cliente();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE codigo = "+cod);
            if(rs.next()){
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setData_aniversaio(rs.getString("data_aniversario"));
                c.setData_insercao(rs.getString("data_insercao"));
                c.setData_atualizacao(rs.getString("data_atualizacao"));
            }else{
                System.out.println("Nada encontrado");
            }
        } catch (Exception e) {
           System.out.println("Erro desconhecido: "+ e.getMessage());
        }finally{
            this.desconectar();
        }

        return c;
    }

    public ArrayList<Cliente> buscarTodos(){
        ArrayList<Cliente> resultados = new ArrayList<Cliente>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes ORDER BY codigo;");
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setData_aniversaio("data_aniversario");
                c.setData_insercao(rs.getString("data_insercao"));
                c.setData_atualizacao(rs.getString("data_atualizacao"));

                resultados.add(c);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro: "+ e.getMessage());
        }finally{
            this.desconectar();
        }

        return resultados;
    }

    public int alterarCadastroCliente(Cliente c){
        Integer qtde = 0;
        try {
            
            this.conectar();
            String comando = "UPDATE clientes SET "
            +"nome = '"+c.getNome()+ "',"
            +"endereco = '"+c.getEndereco()+ "',"
            +"data_aniversario = '"+c.getData_aniversaio()+ "',"
            +"data_insercao = '"+c.getData_insercao()+ "',"
            +"data_atualizacao = '"+c.getData_atualizacao()+"' "
            +"WHERE codigo = "+c.getCodigo()+";";
            System.out.println("Comando SQL"+ comando);
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro ao atualizar cliente: "+ e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }
    public int deletarCliente(int cod){
        Integer qtde = 0;
        try {
            this.conectar();

            String comando = "DELETE  FROM clientes WHERE codigo = "+cod+";";
            System.out.println(comando);
            st.executeUpdate(comando);
            
            qtde = st.getUpdateCount();
            System.out.println("Clientes deletados: "+qtde);
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            this.desconectar();
        }
        return qtde;
    }
}
