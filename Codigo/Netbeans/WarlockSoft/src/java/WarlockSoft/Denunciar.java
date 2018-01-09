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
 * @author serg_
 */
@WebService(serviceName = "Denunciar")
public class Denunciar {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "DenunciarCC")
    public boolean DenunciarCC(@WebParam(name = "Elemento") String Elemento, @WebParam(name = "NombreElemento") String NombreElemento, @WebParam(name = "Motivo") String Motivo, @WebParam(name = "Denunciante") String Denunciante) throws SQLException {
        //TODO write your implementation code here:
         boolean respuesta = false;
        String ID = "";
        String NombreU = "";
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Insert Into DENUNCIA(Elemento, Nombre_Elemento, Motivo, Denunciante) Values(?,?,?,?)");
            ps.setString(1, Elemento);
            ps.setString(2, NombreElemento);
            ps.setString(3, Motivo);
            ps.setString(4, Denunciante);
            
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
    @WebMethod(operationName = "ObtenerPerfilD")
    public String ObtenerPerfilD(@WebParam(name = "IDU") String IDU) throws SQLException {
        //TODO write your implementation code here:
        String NombreUsuario = "";
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps1 = cx1.prepareStatement("Select NickName From USUARIO Where ID_Usuario = ?");
            ps1.setString(1, IDU);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                NombreUsuario = res1.getString("NickName");
            }
            
            
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
    @WebMethod(operationName = "ObtenerAsociacionD")
    public String ObtenerAsociacionD(@WebParam(name = "IDA") String IDA) throws SQLException {
        //TODO write your implementation code here:
        String NombreAsociacion = "";
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps1 = cx1.prepareStatement("Select Nombre_Asociacion From ASOCIACION Where ID_Asociacion = ?");
            ps1.setString(1, IDA);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                NombreAsociacion = res1.getString("Nombre_Asociacion");
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return NombreAsociacion;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerProyectoD")
    public String ObtenerProyectoD(@WebParam(name = "IDP") String IDP) throws SQLException {
        //TODO write your implementation code here:
        String NombreProyecto = "";
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps1 = cx1.prepareStatement("Select Nombre_Proyecto From PROYECTO Where ID_Proyecto = ?");
            ps1.setString(1, IDP);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                NombreProyecto = res1.getString("Nombre_Proyecto");
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return NombreProyecto;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerDenuncias")
    public String[] ObtenerDenuncias() throws SQLException {
        //TODO write your implementation code here:
        String[] Denuncias = new String [200];
        int contD = 0;
        Connection cx1 = Conexion.getConexion();
        
        try {
            PreparedStatement ps1 = cx1.prepareStatement("Select * From DENUNCIA");
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                Denuncias[contD] = res1.getString("Elemento"); contD++;
                Denuncias[contD] = res1.getString("Nombre_Elemento"); contD++;
                Denuncias[contD] = res1.getString("Motivo"); contD++;
                //--------------------------------------------------------------
                Denuncias[contD] = ObtenerPerfilD(res1.getString("Denunciante")); contD++;
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return Denuncias;
    }
}
