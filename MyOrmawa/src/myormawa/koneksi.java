package myormawa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ariputraaa
 */
public class koneksi {
        public static Connection getKoneksi(){
        Connection cnn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3308/daftar_maba","root","");
        }catch( ClassNotFoundException | SQLException e){
            System.out.println("Koneksi ke DBMS MySQL gagal");
        }
        return cnn;
    }
}
