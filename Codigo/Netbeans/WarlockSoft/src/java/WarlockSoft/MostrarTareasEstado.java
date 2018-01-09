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
@WebService(serviceName = "MostrarTareasEstado")
public class MostrarTareasEstado {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TareasEstado")
    public String[] TareasEstado(@WebParam(name = "IDProyecto") String IDProyecto, @WebParam(name = "Estado") String Estado) throws SQLException {
        //TODO write your implementation code here:
        String[] Proyectos = new String [100];
        int contP = 0;
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps1 = cx1.prepareStatement("Select Nombre_Tarea From TAREA Where ID_Proyecto = ? AND Estado = ?");
            ps1.setString(1, IDProyecto);
            ps1.setString(2, Estado);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                Proyectos[contP] = res1.getString("Nombre_Tarea");
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "MoverTarea")
    public boolean MoverTarea(@WebParam(name = "NombreTarea") String NombreTarea, @WebParam(name = "EstadoMov") String EstadoMov, @WebParam(name = "IDProyecto") String IDProyecto) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Update TAREA set Estado = ? Where Nombre_Tarea = ? AND ID_Proyecto = ?");
            ps.setString(1, EstadoMov);
            ps.setString(2, NombreTarea);
            ps.setString(3, IDProyecto);
            
            int res = ps.executeUpdate();
            
            if(res>0){
                respuesta = true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return respuesta;
    }
}
