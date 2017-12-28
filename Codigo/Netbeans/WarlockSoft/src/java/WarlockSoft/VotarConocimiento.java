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
@WebService(serviceName = "VotarConocimiento")
public class VotarConocimiento {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerKarmaConocimiento")
    public String ObtenerKarmaConocimiento(@WebParam(name = "IDConocimiento") String IDConocimiento, @WebParam(name = "IDUsuario") String IDUsuario) throws SQLException {
        //TODO write your implementation code here:
        String Karma = "";
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select Karma From CONOCIMIENTO_USUARIO Where ID_Conocimiento = ? AND ID_Usuario = ?");
            ps.setString(1, IDConocimiento);
            ps.setString(2, IDUsuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                Karma = res.getString("Karma");
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Votar")
    public boolean Votar(@WebParam(name = "IDConocimiento") String IDConocimiento, @WebParam(name = "IDUsuario") String IDUsuario, @WebParam(name = "Karma") String Karma) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Update CONOCIMIENTO_USUARIO set Karma = ? Where ID_Conocimiento = ? AND ID_Usuario = ?");
            
            ps.setString(1, Karma);
            ps.setString(2, IDConocimiento);
            ps.setString(3, IDUsuario);
            
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
