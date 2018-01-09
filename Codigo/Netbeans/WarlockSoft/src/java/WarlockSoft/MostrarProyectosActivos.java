package WarlockSoft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author S;G
 */
@WebService(serviceName = "MostrarProyectosActivos")
public class MostrarProyectosActivos {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerProyectosActivos")
    public String[] ObtenerProyectosActivos() throws SQLException {
        //TODO write your implementation code here:
        String[] Proyectos = new String [100];
        int contP = 0;
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps1 = cx1.prepareStatement("Select Nombre_Proyecto From PROYECTO Where Estado = ?");
            ps1.setString(1, "activo");
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                Proyectos[contP] = res1.getString("Nombre_Proyecto");
                contP++;
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return Proyectos;
    }
}
