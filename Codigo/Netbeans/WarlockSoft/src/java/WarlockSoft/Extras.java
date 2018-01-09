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
@WebService(serviceName = "Extras")
public class Extras {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerCosto")
    public String ObtenerCosto(@WebParam(name = "IDProyecto") String IDProyecto) throws SQLException {
        //TODO write your implementation code here:
        String Costo = "";
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps1 = cx1.prepareStatement("Select Costo From PROYECTO Where ID_Proyecto = ?");
            ps1.setString(1, IDProyecto);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                Costo = res1.getString("Costo");
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return Costo;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerEncargado")
    public String ObtenerEncargado(@WebParam(name = "IDProyecto") String IDProyecto, @WebParam(name = "Tarea") String Tarea) throws SQLException {
        //TODO write your implementation code here:
        String NombreUsuario = "";
        String IDT = "";
        String IDU = "";
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Tarea From TAREA Where ID_Proyecto = ? AND Nombre_Tarea = ?");
            ps.setString(1, IDProyecto);
            ps.setString(2, Tarea);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDT = res.getString("ID_Tarea");
            }
            
            //------------------------------------------------------------------
            PreparedStatement ps1 = cx1.prepareStatement("Select ID_Usuario From TAREA_USUARIO Where ID_Tarea = ?");
            ps1.setString(1, IDT);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                IDU = res1.getString("ID_Usuario");
            }
            //------------------------------------------------------------------
            
            Denunciar N = new Denunciar();
            NombreUsuario = N.ObtenerPerfilD(IDU);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return NombreUsuario;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TerminarProyecto")
    public boolean TerminarProyecto(@WebParam(name = "IDProyecto") String IDProyecto) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Update PROYECTO set Estado = ? Where ID_Proyecto = ?");
            ps.setString(1, "Finalizado");
            ps.setString(2, IDProyecto);
            
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerEstadoProyecto")
    public String ObtenerEstadoProyecto(@WebParam(name = "IDProyecto") String IDProyecto) throws SQLException {
        //TODO write your implementation code here:
        String Estado = "";
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps1 = cx1.prepareStatement("Select Estado From PROYECTO Where ID_Proyecto = ?");
            ps1.setString(1, IDProyecto);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                Estado = res1.getString("Estado");
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return Estado;
    }
    
}
