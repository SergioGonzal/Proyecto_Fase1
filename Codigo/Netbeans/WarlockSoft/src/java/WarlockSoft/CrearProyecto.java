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
@WebService(serviceName = "CrearProyecto")
public class CrearProyecto {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GuardarProyecto")
    public boolean GuardarProyecto(@WebParam(name = "Nombre") String Nombre, @WebParam(name = "FechaInicio") String FechaInicio, @WebParam(name = "FechaFin") String FechaFin, @WebParam(name = "IDUsuario") String IDUsuario) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        Connection cx2 = Conexion.getConexion();
        String NombreP ="";
        String IDP ="";
        NombreP=Nombre;
        
        try {
            PreparedStatement ps = cx.prepareStatement("Insert Into PROYECTO(Nombre_Proyecto, Fecha_Inicio, Fecha_Fin, Estado) Values(?,?,?,?)");
            ps.setString(1, Nombre);
            ps.setString(2, FechaInicio);
            ps.setString(3, FechaFin);
            ps.setString(4, "En Espera");
           
            int res = ps.executeUpdate();
            
            if(res>0){
                respuesta = true;
            }
            //------------------------------------------------------------------
            PreparedStatement ps1 = cx1.prepareStatement("Select ID_Proyecto From PROYECTO Where Nombre_Proyecto =?");
            ps1.setString(1, NombreP);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                IDP = res1.getString("ID_Proyecto");
            }
            //------------------------------------------------------------------
            PreparedStatement ps2 = cx2.prepareStatement("Insert Into PROYECTO_USUARIO(Rol, ID_Proyecto, ID_Usuario) Values(?,?,?)");
            ps2.setString(1, "Administrador");
            ps2.setString(2, IDP);
            ps2.setString(3, IDUsuario);
           
            int res2 = ps2.executeUpdate();
            
            if(res2>0){
                respuesta = true;
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
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerIDProyecto")
    public String ObtenerIDProyecto(@WebParam(name = "NombreProyecto") String NombreProyecto) throws SQLException {
        //TODO write your implementation code here:
        String ID = "";
        Connection cx = Conexion.getConexion();
        
        try {
            
            PreparedStatement ps = cx.prepareStatement("Select ID_Proyecto From PROYECTO Where Nombre_Proyecto =?");
            ps.setString(1, NombreProyecto);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                ID = res.getString("ID_Proyecto");
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
    @WebMethod(operationName = "ObtenerProyectos")
    public String[] ObtenerProyectos(@WebParam(name = "IDUsuario") String IDUsuario) throws SQLException {
        //TODO write your implementation code here:
        String[] IDs = new String [100];
        String[] Proyectos = new String [100];
        int contIDs = 0;
        int contP = 0;
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        
        try {
            
            PreparedStatement ps = cx.prepareStatement("Select ID_Proyecto From PROYECTO_USUARIO Where ID_Usuario =?");
            ps.setString(1, IDUsuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDs[contIDs] = res.getString("ID_Proyecto");
                contIDs++;
            }
            //------------------------------------------------------------------
            contIDs= 0;
            while(IDs[contIDs] != null){
                PreparedStatement ps1 = cx1.prepareStatement("Select Nombre_Proyecto From PROYECTO Where ID_Proyecto =?");
                ps1.setString(1, IDs[contIDs]);

                ResultSet res1;
                res1 = ps1.executeQuery();

                while (res1.next()){
                    Proyectos[contIDs] = res1.getString("Nombre_Proyecto");
                }
                contIDs++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return Proyectos;
    }
}
