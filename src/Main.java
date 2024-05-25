import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {

    public static String url = "jdbc:mysql://localhost:3306/restaurant_menu";
    public static String user = "root";
    public static String pass = "aso123456";
    public static Connection conn;

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        try {
             conn= DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");
        }catch (Exception e){
            e.printStackTrace();
        }

            new Login_in();

    }
}