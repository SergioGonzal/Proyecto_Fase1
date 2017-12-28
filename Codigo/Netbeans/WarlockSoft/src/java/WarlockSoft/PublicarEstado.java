package WarlockSoft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author S;G
 */
@WebService(serviceName = "PublicarEstado")
public class PublicarEstado {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GuardarEstado")
    public boolean GuardarEstado(@WebParam(name = "Texto") String Texto, @WebParam(name = "ID_Usuario") String ID_Usuario) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Insert Into ESTADO(Texto, ID_Usuario) Values(?,?)");
            ps.setString(1, Texto);
            ps.setString(2, ID_Usuario);
            
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
