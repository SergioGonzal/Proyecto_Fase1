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
@WebService(serviceName = "AgregarConocimiento")
public class AgregarConocimiento {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerIDConocimiento")
    public String ObtenerIDConocimiento(@WebParam(name = "Conocimiento") String Conocimiento) throws SQLException {
        //TODO write your implementation code here:
        String ID = "";
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Conocimiento From CONOCIMIENTO Where Nombre_Conocimiento =?");
            ps.setString(1, Conocimiento);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                ID= res.getString("ID_Conocimiento");
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
    /**
     * Web service operation
     */
    @WebMethod(operationName = "GuardarConocimiento")
    public boolean GuardarConocimiento(@WebParam(name = "Conocimiento") String Conocimiento, @WebParam(name = "Usuario") String Usuario) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Insert Into CONOCIMIENTO_USUARIO(Karma, ID_Conocimiento, ID_Usuario) Values(?,?,?)");
            ps.setString(1, "0");
            ps.setString(2, Conocimiento);
            ps.setString(3, Usuario);
            
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
    @WebMethod(operationName = "ObtenerIDHabilidad")
    public String ObtenerIDHabilidad(@WebParam(name = "Conocimiento") String Conocimiento) throws SQLException {
        //TODO write your implementation code here:
        String ID = "";
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Habilidad From CONOCIMIENTO Where Nombre_Conocimiento =?");
            ps.setString(1, Conocimiento);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                ID= res.getString("ID_Habilidad");
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GuardarHabilidad")
    public boolean GuardarHabilidad(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "Habilidad") String Habilidad) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Insert Into HABILIDAD_USUARIO(ID_Habilidad, ID_Usuario) Values(?,?)");
            ps.setString(1, Habilidad);
            ps.setString(2, Usuario);
            
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
    @WebMethod(operationName = "VerificarHabilidad")
    public boolean VerificarHabilidad(@WebParam(name = "Habilidad") String Habilidad, @WebParam(name = "Usuario") String Usuario) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        int filas = 0;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Usuario From HABILIDAD_USUARIO Where ID_Usuario =? AND ID_Habilidad= ?");
            ps.setString(1, Usuario);
            ps.setString(2, Habilidad);
            
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
    @WebMethod(operationName = "VerificarConocimiento")
    public boolean VerificarConocimiento(@WebParam(name = "Conocimiento") String Conocimiento, @WebParam(name = "Usuario") String Usuario) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        int filas = 0;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Usuario From CONOCIMIENTO_USUARIO Where ID_Usuario =? AND ID_Conocimiento= ?");
            ps.setString(1, Usuario);
            ps.setString(2, Conocimiento);
            
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
    @WebMethod(operationName = "ObtenerConocimientos")
    public String[] ObtenerConocimientos() throws SQLException {
        //TODO write your implementation code here:
        String[] Conocimientos = new String [200];
        Connection cx = Conexion.getConexion();
        int cont = 0;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select Nombre_Conocimiento From CONOCIMIENTO");
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                Conocimientos[cont]= res.getString("Nombre_Conocimiento");
                cont++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return Conocimientos;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerIDConocimientosUsuario")
    public String[] ObtenerIDConocimientosUsuario(@WebParam(name = "Usuario") String Usuario) throws SQLException {
        //TODO write your implementation code here:
        String[] Conocimientos = new String [200];
        Connection cx = Conexion.getConexion();
        int cont = 0;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Conocimiento From CONOCIMIENTO_USUARIO Where ID_Usuario = ?");
            ps.setString(1, Usuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                Conocimientos[cont]= res.getString("ID_Conocimiento");
                cont++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return Conocimientos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerConocimientosUsuario")
    public String[] ObtenerConocimientosUsuario(@WebParam(name = "IDConocimientos") String[] IDConocimientos) throws SQLException {
        //TODO write your implementation code here:
        String[] Conocimientos = new String [200];
        Connection cx = Conexion.getConexion();
        int cont = 0;
        
        while(IDConocimientos[cont]!= null){
            try {
                PreparedStatement ps = cx.prepareStatement("Select Nombre_Conocimiento From CONOCIMIENTO Where ID_Conocimiento = ?");
                ps.setString(1, IDConocimientos[cont]);

                ResultSet res;
                res = ps.executeQuery();

                while (res.next()){
                    Conocimientos[cont]= res.getString("Nombre_Conocimiento");
                }
            
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Error!");
            } finally {
                
                System.out.println("Conexion Cerrada!");
            }
            cont ++;
        }
        cx.close();
        return Conocimientos;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerKarmaConocimientosUsuario")
    public String[] ObtenerKarmaConocimientosUsuario(@WebParam(name = "Usuario") String Usuario) throws SQLException {
        //TODO write your implementation code here:
        String[] Karma = new String [200];
        Connection cx = Conexion.getConexion();
        int cont = 0;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select Karma From CONOCIMIENTO_USUARIO Where ID_Usuario = ?");
            ps.setString(1, Usuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                Karma[cont]= res.getString("Karma");
                cont++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return Karma;
    }
    


   /* public static void main(String[] args) throws SQLException{
        
        AgregarConocimiento AC = new AgregarConocimiento();
        String IDC=AC.ObtenerIDConocimiento("Pixel Art");
        String IDH= AC.ObtenerIDHabilidad("Pixel Art");
        AC.GuardarConocimiento(IDC, "1");
        AC.GuardarHabilidad("1", IDH);
        //System.out.println( AC.VerificarHabilidad("2", "2"));//condicional para guardar
        String [] caca = new String [200];
        caca =AC.ObtenerConocimientos();
        for (int i =0; i<200; i++){
            System.out.println(caca[i]);
        }
        String [] IDS = new String [200];
        String [] Cono = new String [200];
        IDS = AC.ObtenerIDConocimientosUsuario("1");
        Cono= AC.ObtenerConocimientosUsuario(IDS);
        
        for(int i =0; i<200; i++)
        {
            System.out.println(Cono[i]);
        }
    }*/

}
