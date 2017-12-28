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
@WebService(serviceName = "CrearCuenta")
public class CrearCuenta {

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
    /**
     * Web service operation
     */
    public boolean BuscarNick(@WebParam(name = "NickName") String NickName) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        int filas = 0;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select Correo From USUARIO Where NickName =?");
            ps.setString(1, NickName);
            
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
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarCuenta")
    public boolean AgregarCuenta(@WebParam(name = "Nombre") String Nombre, @WebParam(name = "NickName") String NickName, @WebParam(name = "Correo") String Correo, @WebParam(name = "Contrasena") String Contrasena, @WebParam(name = "FechaN") String FechaN) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Insert Into USUARIO(Nombre_Completo, NickName, Correo, Contraseña, Fecha_Nacimineto) Values(?,?,?,?,?)");
            ps.setString(1, Nombre);
            ps.setString(2, NickName);
            ps.setString(3, Correo);
            ps.setString(4, Contrasena);
            ps.setString(5, FechaN);
            
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
    /*public static void main(String[] args) throws SQLException{
        
        CrearCuenta CC = new CrearCuenta();
        System.out.println(CC.BuscarNick("L;S"));
        
    }*/
}
