package Repository;

import Connection.ConnectionFacture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SellerRepository {
    private Connection conn;
    public void  SellerRepository(){
        ConnectionFacture connectionFacture = new ConnectionFacture();
        conn = connectionFacture.getConnection();
    }
    public void getSellers(){
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();
            statement.executeQuery("SELECT * FROM seller");
            while(resultSet.next()){
                System.out.println(resultSet.getString("Id")+ "" +
                        resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
