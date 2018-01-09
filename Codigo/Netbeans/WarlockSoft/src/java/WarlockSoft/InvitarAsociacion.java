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
@WebService(serviceName = "InvitarAsociacion")
public class InvitarAsociacion {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "EnviarInvitacion")
    public boolean EnviarInvitacion(@WebParam(name = "IDAsociacion") String IDAsociacion, @WebParam(name = "Usuario") String Usuario) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        String IDU = "";
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Usuario From USUARIO Where NickName = ?");
            ps.setString(1, Usuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDU = res.getString("ID_Usuario");
            }
            //------------------------------------------------------------------
            PreparedStatement ps1 = cx1.prepareStatement("Insert Into ASOCIACION_USUARIO(Administrador, ID_Asociacion, ID_Usuario) Values(?,?,?)");
            ps1.setString(1, "Miembro");
            ps1.setString(2, IDAsociacion);
            ps1.setString(3, IDU);
            
            int res1 = ps1.executeUpdate();
            
            if(res1>0){
                respuesta = true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerRolAsociacion")
    public String ObtenerRolAsociacion(@WebParam(name = "IDUsuario") String IDUsuario, @WebParam(name = "IDAsociacion") String IDAsociacion) throws SQLException {
        //TODO write your implementation code here:
        String Rol = "";
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select Administrador From ASOCIACION_USUARIO Where ID_Usuario = ? AND ID_Asociacion = ?");
            ps.setString(1, IDUsuario);
            ps.setString(2, IDAsociacion);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                Rol= res.getString("Administrador");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return Rol;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerMiembrosAsociacion")
    public String[] ObtenerMiembrosAsociacion(@WebParam(name = "IDAsociacion") String IDAsociacion) throws SQLException {
        //TODO write your implementation code here:
        String[] Datos = new String [200];
        String IDU = "";
        int cont =0;
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select Administrador , ID_Usuario From ASOCIACION_USUARIO Where ID_Asociacion = ?");
            ps.setString(1, IDAsociacion);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDU = res.getString("ID_Usuario");
                //--------------------------------------------------------------
                PreparedStatement ps1 = cx1.prepareStatement("Select NickName From USUARIO Where ID_Usuario = ?");
                ps1.setString(1, IDU);

                ResultSet res1;
                res1 = ps1.executeQuery();

                while (res1.next()){
                    Datos[cont]= res1.getString("NickName");
                }
                cont++;
                //--------------------------------------------------------------
                Datos[cont]= res.getString("Administrador");
                cont++;
            }
            //------------------------------------------------------------------
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return Datos;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "VerificarMiembro")
    public boolean VerificarMiembro(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "IDAsociacion") String IDAsociacion) throws SQLException {
        //TODO write your implementation code here:
        String IDU = "";
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        boolean respuesta = false;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Usuario From USUARIO Where NickName =?");
            ps.setString(1, Usuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDU= res.getString("ID_Usuario");
            }
            //------------------------------------------------------------------
            int filas = 0;
            PreparedStatement ps1 = cx1.prepareStatement("Select Administrador From ASOCIACION_USUARIO Where ID_Usuario = ? AND ID_Asociacion = ?");
            
            ps1.setString(1, IDU);
            ps1.setString(2, IDAsociacion);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()) {
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
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return respuesta;
    }
}
