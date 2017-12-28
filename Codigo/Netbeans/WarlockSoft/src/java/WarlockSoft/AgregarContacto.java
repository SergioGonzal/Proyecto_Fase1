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
@WebService(serviceName = "AgregarContacto")
public class AgregarContacto {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerNombreUsuario")
    public String ObtenerNombreUsuario(@WebParam(name = "IDUsuarioV") String IDUsuarioV) throws SQLException {
        //TODO write your implementation code here:
        String Nombre = "";
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select NickName From USUARIO Where ID_Usuario =?");
            ps.setString(1, IDUsuarioV);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                Nombre= res.getString("NickName");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return Nombre;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ComprobarAmistad")
    public boolean ComprobarAmistad(@WebParam(name = "IDUsuario") String IDUsuario, @WebParam(name = "NombreUsuario") String NombreUsuario) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        int filas = 0;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Contacto From CONTACTO Where NickName_Contacto = ? AND ID_Usuario= ?");
            ps.setString(1, NombreUsuario);
            ps.setString(2, IDUsuario);
            
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
    @WebMethod(operationName = "GuardarAmigo")
    public boolean GuardarAmigo(@WebParam(name = "IDUsuario") String IDUsuario, @WebParam(name = "NombreContacto") String NombreContacto) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Insert Into CONTACTO(NickName_Contacto, ID_Usuario) Values(?,?)");
            ps.setString(1, NombreContacto);
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
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerListaContactos")
    public String[] ObtenerListaContactos(@WebParam(name = "IDUsuario") String IDUsuario, @WebParam(name = "NombreUsuario") String NombreUsuario) throws SQLException {
        //TODO write your implementation code here:
        String [] Contactos = new String[100];
        String [] IDs = new String[100];
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        Connection cx2 = Conexion.getConexion();
        int cont = 0, cont1 = 0;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select NickName_Contacto From CONTACTO Where ID_Usuario =?");
            ps.setString(1, IDUsuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                Contactos[cont]= res.getString("NickName_Contacto");
                cont++;
            }
            //-----------------------------------------------------------------
            PreparedStatement ps1 = cx1.prepareStatement("Select ID_Usuario From CONTACTO Where NickName_Contacto = ?");
            ps1.setString(1, NombreUsuario);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                IDs[cont1]= res1.getString("ID_Usuario");
                cont1++;
            }
            //-----------------------------------------------------------------
            cont1 = 0;
            while(IDs[cont1] != null){
                PreparedStatement ps2 = cx2.prepareStatement("Select NickName From USUARIO Where ID_Usuario =?");
                ps2.setString(1, IDs[cont1]);
            
                ResultSet res2;
                res2 = ps2.executeQuery();
            
                while (res2.next()){
                    Contactos[cont]= res2.getString("NickName");
                    cont++;
                }
                cont1++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            cx1.close();
            cx2.close();
            System.out.println("Conexion Cerrada!");
        }
        return Contactos;
    }
    
   /* public static void main(String[] args) throws SQLException{
        
        AgregarContacto AC = new AgregarContacto();
        String[] cont = new String[100];
        cont= AC.ObtenerListaContactos("1", "S;G");
        
        for(int i=0; i<100; i++){
            System.out.println(cont[i]);
        }
    }*/
}
