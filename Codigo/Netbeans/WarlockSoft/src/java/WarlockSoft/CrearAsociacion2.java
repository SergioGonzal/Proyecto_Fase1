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
@WebService(serviceName = "CrearAsociacion2")
public class CrearAsociacion2 {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarAsociacion2")
    public boolean AgregarAsociacion2(@WebParam(name = "NombreAs") String NombreAs, @WebParam(name = "Objetivo") String Objetivo) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Insert Into ASOCIACION(Nombre_Asociacion, Objetivo) Values(?,?)");
            ps.setString(1, NombreAs);
            ps.setString(2, Objetivo);
            
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
    @WebMethod(operationName = "AgregarMiembros2")
    public boolean AgregarMiembros2(@WebParam(name = "Miembros") String[] Miembros, @WebParam(name = "Contador") int Contador, @WebParam(name = "Asociacion") String Asociacion) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        String IDAs ="";
        String IDU ="";
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        Connection cx2 = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Asociacion From ASOCIACION Where Nombre_Asociacion = ?");
            ps.setString(1, Asociacion);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDAs= res.getString("ID_Asociacion");
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        
        for(int i =0; i<Contador; i++){
            try {
                PreparedStatement ps1 = cx1.prepareStatement("Select ID_Usuario From USUARIO Where NickName = ?");
                ps1.setString(1, Miembros[i]);

                ResultSet res1;
                res1 = ps1.executeQuery();

                while (res1.next()){
                    IDU= res1.getString("ID_Usuario");
                }
                //--------------------------------------------------------------
                PreparedStatement ps2 = cx2.prepareStatement("Insert Into ASOCIACION_USUARIO(Administrador, ID_Asociacion, ID_Usuario) Values(?,?,?)");
                if(i == 0){
                    ps2.setString(1, "Administrador");
                }else{
                    ps2.setString(1, "Miembro");
                }
                ps2.setString(2, IDAs);
                ps2.setString(3, IDU);

                int res2 = ps2.executeUpdate();

                if(res2>0){
                    respuesta = true;
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Error!");
            } finally {
                cx.close();
                System.out.println("Conexion Cerrada!");
            }
        }
        return respuesta;
    }
}
