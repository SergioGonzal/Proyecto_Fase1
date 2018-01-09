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
@WebService(serviceName = "CrearAsociacion")
public class CrearAsociacion {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CreaAsociacion")
    public boolean CreaAsociacion(@WebParam(name = "NombreAs") String NombreAs, @WebParam(name = "Objetivo") String Objetivo, @WebParam(name = "IDUsuario") String IDUsuario) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        String ID = "";
        String NombreU = "";
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        Connection cx2 = Conexion.getConexion();
        Connection cx3 = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Insert Into ASOCIACION(Nombre_Asociacion, Objetivo) Values(?,?)");
            ps.setString(1, NombreAs);
            ps.setString(2, Objetivo);
            
            int res = ps.executeUpdate();
            
            if(res>0){
                respuesta = true;
            }
            //------------------------------------------------------------------
            PreparedStatement ps1 = cx1.prepareStatement("Select ID_Asociacion From ASOCIACION Where Nombre_Asociacion = ?");
            ps1.setString(1, NombreAs);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                ID= res1.getString("ID_Asociacion");
            }
            //------------------------------------------------------------------ no hace nada
            PreparedStatement ps2 = cx2.prepareStatement("Select NickName From USUARIO Where ID_Usuario = ?");
            ps2.setString(1, IDUsuario);
            
            ResultSet res2;
            res2 = ps2.executeQuery();
            
            while (res2.next()){
                NombreU= res2.getString("NickName");
            }
            //------------------------------------------------------------------
            PreparedStatement ps3 = cx3.prepareStatement("Insert Into ASOCIACION_USUARIO (Administrador, ID_Asociacion, ID_Usuario) Values(?,?,?)");
            ps3.setString(1, "Administrador");
            ps3.setString(2, ID);
            ps3.setString(3, IDUsuario);
            
            int res3 = ps3.executeUpdate();
            
            if(res3>0){
                respuesta = true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            cx1.close();
            cx2.close();
            cx3.close();
            System.out.println("Conexion Cerrada!");
        }
     
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerAsociaciones")
    public String[] ObtenerAsociaciones(@WebParam(name = "IDUsuario") String IDUsuario) throws SQLException {
        //TODO write your implementation code here:
        String[] IDAsociaciones = new String[50];
        String[] Asociaciones = new String[50];
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        int cont = 0;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Asociacion From ASOCIACION_USUARIO Where ID_Usuario =?");
            ps.setString(1, IDUsuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDAsociaciones[cont]= res.getString("ID_Asociacion");
                cont++;
            }
            //------------------------------------------------------------------
            cont = 0;
            while(IDAsociaciones[cont]!= null){
                PreparedStatement ps1 = cx1.prepareStatement("Select Nombre_Asociacion From ASOCIACION Where ID_Asociacion =?");
                ps1.setString(1, IDAsociaciones[cont]);

                ResultSet res1;
                res1 = ps1.executeQuery();

                while (res1.next()){
                    Asociaciones[cont]= res1.getString("Nombre_Asociacion");
                }
                cont++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return Asociaciones;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerIDAsociacion")
    public String ObtenerIDAsociacion(@WebParam(name = "NombreProy") String NombreProy) throws SQLException {
        //TODO write your implementation code here:
        String IDProy = "";
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Asociacion From ASOCIACION Where Nombre_Asociacion = ?");
            ps.setString(1, NombreProy);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDProy= res.getString("ID_Asociacion");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return IDProy;
    }
}
