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
@WebService(serviceName = "EliminarMiembro")
public class EliminarMiembro {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "EliminarMiembroA")
    public boolean EliminarMiembroA(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "IDAsociacion") String IDAsociacion) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        String IDU = "";
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps1 = cx1.prepareStatement("Select ID_Usuario From USUARIO Where NickName = ?");
            ps1.setString(1, Usuario);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                IDU = res1.getString("Karma");
            }
            
            //------------------------------------------------------------------
            PreparedStatement ps = cx.prepareStatement("Delete From ASOCIACION_USUARIO Where ID_Asociacion = ? AND ID_Usuario = ?");
            ps.setString(1, IDAsociacion);
            ps.setString(2, IDU);
            
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
    @WebMethod(operationName = "SalirAsociacion")
    public boolean SalirAsociacion(@WebParam(name = "IDUsuario") String IDUsuario, @WebParam(name = "IDAsociacion") String IDAsociacion) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            //------------------------------------------------------------------
            PreparedStatement ps = cx.prepareStatement("Delete From ASOCIACION_USUARIO Where ID_Asociacion = ? AND ID_Usuario = ?");
            ps.setString(1, IDAsociacion);
            ps.setString(2, IDUsuario);
            
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
