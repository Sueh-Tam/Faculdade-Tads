import java.beans.Statement;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DaoGenerico {


    private Connection conn;
    private Statement st;
    private final String TB_PREFIX = "tb_";
    private final String TB_SUFFIX = "s";

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

    public void inserir (Object o) throws Exception{
        Class c = o.getClass();
        Field fields[] = c.getDeclaredFields();

        //Montar a query para o pst
        String query = "INSERT INTO " + TB_PREFIX +
        c.getSimpleName().toLowerCase() + TB_SUFFIX;

        String campos = "(";
        String aliases = "VALUES(";
        boolean separar = false;
        for (Field field : fields) {
            campos = campos + field.getName();
            aliases = aliases + "?";
        }
        System.out.println(campos);
        System.out.println(aliases);
        //criar o pst e setar os valores
        
    }
}
