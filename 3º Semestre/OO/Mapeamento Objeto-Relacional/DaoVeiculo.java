import java.sql.Statement;
import java.util.ArrayList;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoVeiculo {
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

    public boolean inserir(Veiculo v){
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO tb_veiculos VALUES(NULL," + "'" + v.getMarca() + "', '" + v.getModelo() + "', '" 
            + v.getChassi() + "', " + v.getAno() + ");";
            System.out.println(comando);
            st.executeUpdate(comando);
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir o registro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    public ArrayList<Veiculo> buscarTodos(){
        ArrayList<Veiculo> resultados = new ArrayList<Veiculo>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_veiculos ORDER BY modelo;");

            while (rs.next()) {
                Veiculo v = new Veiculo();

                v.setCodigo(rs.getInt("codigo"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setChassi(rs.getString("chassi"));
                v.setAno(rs.getInt("ano"));

                resultados.add(v);
            }
            
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }finally{
            desconectar();
        }
        return resultados;
    }

    public int excluir(int cod){
        int qtd = 0;
        try {
            this.conectar();
            String comando = "DELETE FROM tb_veiculos where codigo = "+cod;
            //System.out.println(comando);
            st.executeUpdate(comando);
            qtd = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro ao remover o registro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtd;
    }

    public Veiculo consultar(int cod){
        Veiculo v = new Veiculo();
        try {
            
            this.conectar();
            
            ResultSet rs = st.executeQuery("SELECT * FROM tb_veiculos where codigo = "+cod);
            if(rs.next()){
                v.setCodigo(rs.getInt("codigo"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setChassi(rs.getString("chassi"));
                v.setAno(rs.getInt("ano"));
            }else{
                System.out.println("Nenhum pneu encontrado");
            }
            
            

        } catch (Exception e) {
            System.out.println("Erro ao consultar registro: "+e.getMessage());
        }finally{
            this.desconectar();
        }
        return v;
    }

    public int atualizarVeiculo(Veiculo v){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "UPDATE tb_veiculos SET "
            +"marca = '"+v.getMarca()+ "',"
            +"modelo = '"+v.getModelo()+ "',"
            +"chassi = '"+v.getChassi()+ "',"
            +"ano =" +v.getAno()
            + " WHERE codigo = "+v.getCodigo()+ ";";
            
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar elemento: "+ e.getMessage());
        }

        return qtde;
    }

}
