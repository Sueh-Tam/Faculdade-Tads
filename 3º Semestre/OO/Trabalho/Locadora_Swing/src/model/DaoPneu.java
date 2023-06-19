package model;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kirit
 */
public class DaoPneu {
        private Connection conn;
    private Statement st;

    private void conectar(){
        try {

            this.conn = GerenciadorConexao.pegarConexao();
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

    public boolean inserir(Pneu p){
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO pneu VALUES (NULL,"+ "'"+ p.getSeriePneu()+"', '"+ p.getCorPneu()+"','"+p.getCodPneu()+"','"+ p.getEstadoPneu() +"','"+ p.getDataLocacao() + "', "+p.getPreco()+");";  
            System.out.println("Comando SQL");
            System.out.println(comando);
            st.executeUpdate(comando);
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro na inserção. erro: "+e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    public ArrayList<Pneu> buscarTodosPneus(){
        ArrayList<Pneu> resultados = new ArrayList<Pneu>();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM pneu ORDER BY serie");
            while (rs.next()) {
                Pneu p = new Pneu();

                p.setId(rs.getInt("id"));
                p.setSeriePneu(rs.getString("serie"));
                p.setCorPneu(rs.getString("cor"));
                p.setCodPneu(rs.getInt("cod"));
                p.setEstadoPneu(rs.getString("estado"));//String
                p.setDataLocacao(rs.getString("dataLocacao"));//String
                p.setPreco(rs.getFloat("preco"));//Float

                resultados.add(p);
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta - Erro: "+e.getMessage());

        }finally{
            this.desconectar();
        }
        return resultados;
    }
    public Pneu buscarPneu(int codigo){
        Pneu p = new Pneu();
        try {
            this.conectar();
            
            String comando = "SELECT * FROM pneu WHERE id = "+codigo;
            ResultSet rs = st.executeQuery(comando);
            if(rs.next()){
                p.setId(rs.getInt("id"));
                p.setSeriePneu(rs.getString("serie"));
                p.setCorPneu(rs.getString("cor"));
                p.setCodPneu(rs.getInt("cod"));
                p.setEstadoPneu(rs.getString("estado"));//String
                p.setDataLocacao(rs.getString("dataLocacao"));//String
                p.setPreco(rs.getFloat("preco"));//Float
            }else{
                System.out.println("Pneu não foi encontrado");
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta única. Erro:"+e.getMessage());
        }finally{
            this.desconectar();
        }

        return p;

    }

    public int atualziarPneu(Pneu p){
        Integer qtde = 0;
        try {
            this.conectar();
            String comando = "UPDATE pneu SET"
            + " serie = '"+ p.getSeriePneu() +"',"
            + " cor = '"+ p.getCorPneu() + "',"
            + " cod = '"+ p.getCodPneu() + "',"
            + " estado = '"+ p.getEstadoPneu() + "',"
            + " dataLocacao = '"+ p.getDataLocacao() + "',"
            + " preco ="+ p.getPreco()
            + " WHERE id = "+p.getId() + ";";
            System.out.println(comando);
            st.executeUpdate(comando);
            
            qtde = st.getUpdateCount();
            
        } catch (Exception e) {
            System.out.println("Erro na edição do Pneu. Erro: "+e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }

    public int deletarPneu(Integer codigo){
        Integer qtde = 0;
        try {
            this.conectar();

            String comando = "DELETE FROM pneu where id = "+codigo;
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro na exclusão do elemento. Erro: "+e.getMessage());
        }finally{
            this.desconectar();
        }

        return qtde;
    }
}
