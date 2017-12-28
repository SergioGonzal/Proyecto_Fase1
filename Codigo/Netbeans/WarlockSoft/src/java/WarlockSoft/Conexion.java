package WarlockSoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author S;G
 */

public class Conexion {
    
    private static final String BD_Driver ="org.mariadb.jdbc.Driver";
    private static final String cURL ="jdbc:mariadb://localhost:3306/WarlockSoft";
    private static final String cUser ="root";
    private static final String cPass ="adminSG";
    
    public Conexion(){
    
    }
    
    public static Connection getConexion(){
        
        Connection cx = null;
        
        try {
            Class.forName(BD_Driver);
            cx=(Connection)DriverManager.getConnection(cURL, cUser, cPass);
            System.out.println("Conexion exitosa!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al Conectar!");
        }
            
        return cx;
    } 
    
}
