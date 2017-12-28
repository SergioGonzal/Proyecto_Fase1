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

@WebService(serviceName = "IniciarSesion")
public class IniciarSesion {

   @WebMethod(operationName = "BuscarCorreo")
    public boolean BuscarCorreo(@WebParam(name = "Correo") String Correo) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        int filas = 0;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select Contraseña From USUARIO Where Correo =?");
            ps.setString(1, Correo);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()) {
                filas++;
            }
            
            if(filas == 1){
                respuesta = true;
            }else{
                respuesta = false;
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
    
    @WebMethod(operationName = "CompararContrasena")
    public boolean CompararContrasena(@WebParam(name = "Correo") String Correo, @WebParam(name = "Contrasena") String Contrasena) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        String Contraseña ="";
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select Contraseña From USUARIO Where Correo =?");
            ps.setString(1, Correo);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
               Contraseña = res.getString("Contraseña");
            }
            
            if(Contraseña.equals(Contrasena)){
                respuesta = true;
            }else{
                respuesta = false;
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
    @WebMethod(operationName = "ObtenerID")
    public String ObtenerID(@WebParam(name = "Correo") String Correo) throws SQLException {
        //TODO write your implementation code here:
        String ID = "";
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Usuario From USUARIO Where Correo =?");
            ps.setString(1, Correo);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
               ID = res.getString("ID_Usuario");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return ID;
    }
}
