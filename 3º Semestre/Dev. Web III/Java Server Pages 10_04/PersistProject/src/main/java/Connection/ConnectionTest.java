package Connection;
import Repository.SellerRepository;

import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args){
        SellerRepository repository = new SellerRepository();
        repository.getSellers();

    }
}
