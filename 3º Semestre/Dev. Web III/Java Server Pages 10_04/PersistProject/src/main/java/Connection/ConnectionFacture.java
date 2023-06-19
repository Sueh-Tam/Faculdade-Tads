package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFacture {
    public Connection getConnection(){
        try{
            DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/",
                    "root",
                    "root");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
