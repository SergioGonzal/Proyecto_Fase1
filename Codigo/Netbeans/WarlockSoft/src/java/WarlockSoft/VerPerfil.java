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
@WebService(serviceName = "VerPerfil")
public class VerPerfil {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerEstados")
    public String[] ObtenerEstados(@WebParam(name = "ID_Usuario") String ID_Usuario) throws SQLException {
        //TODO write your implementation code here:
        String[] estados = new String[100];
        int cont=0;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select Texto From ESTADO Where ID_Usuario =?");
            ps.setString(1, ID_Usuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                estados[cont]= res.getString("Texto");
                cont++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return estados;
    }
    
   /* public static void main(String[] args) throws SQLException{
        
        VerPerfil VP = new VerPerfil();
        int cont =0;
        String[] estados = new String[100];
        estados = VP.ObtenerEstados("1");
        while(estados[cont]!= null)
        {
            cont++;
            System.out.println(cont);
        }
        for(int i =0; i<cont; i++)
        {
            System.out.println(estados[i]);
        }
    }*/
}
