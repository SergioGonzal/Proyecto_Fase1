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
@WebService(serviceName = "CrearProyecto2")
public class CrearProyecto2 {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarProyecto")
    public boolean AgregarProyecto(@WebParam(name = "Nombre") String Nombre, @WebParam(name = "FechaInicio") String FechaInicio, @WebParam(name = "FechaFin") String FechaFin, @WebParam(name = "Estado") String Estado, @WebParam(name = "Costo") String Costo, @WebParam(name = "Creador") String Creador) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        Connection cx2 = Conexion.getConexion();
        Connection cx3 = Conexion.getConexion();
        String IDU = "";
        String IDP = "";
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Usuario From USUARIO Where NickName = ?");
            ps.setString(1, Creador);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDU = res.getString("ID_Usuario");
            }
            //------------------------------------------------------------------
            PreparedStatement ps1 = cx1.prepareStatement("Insert Into PROYECTO(Nombre_Proyecto, Fecha_Inicio, Fecha_Fin, Estado, Costo) Values(?,?,?,?,?)");
            ps1.setString(1, Nombre);
            ps1.setString(2, FechaInicio);
            ps1.setString(3, FechaFin);
            ps1.setString(4, Estado);
            ps1.setString(5, Costo);
            
            int res1 = ps1.executeUpdate();
            
            if(res1>0){
                respuesta = true;
            }
            //------------------------------------------------------------------
            PreparedStatement ps2 = cx2.prepareStatement("Select ID_Proyecto From PROYECTO Where Nombre_Proyecto = ?");
            ps2.setString(1, Nombre);
            
            ResultSet res2;
            res2 = ps2.executeQuery();
            
            while (res2.next()){
                IDP = res2.getString("ID_Proyecto");
            }
            //------------------------------------------------------------------
            PreparedStatement ps3 = cx3.prepareStatement("Insert Into PROYECTO_USUARIO(Rol, ID_Proyecto, ID_Usuario) Values(?,?,?)");
            ps3.setString(1, "Administrador");
            ps3.setString(2, IDP);
            ps3.setString(3, IDU);
            
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
    @WebMethod(operationName = "AgregarTareaProyecto2")
    public boolean AgregarTareaProyecto2(@WebParam(name = "Nombre") String Nombre, @WebParam(name = "Descripcion") String Descripcion, @WebParam(name = "FechaInicio") String FechaInicio, @WebParam(name = "Estado") String Estado, @WebParam(name = "Proyecto") String Proyecto, @WebParam(name = "Conocimiento") String Conocimiento, @WebParam(name = "Usuario") String Usuario) throws SQLException {
        //TODO write your implementation code here:
         boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        Connection cx2 = Conexion.getConexion();
        Connection cx3 = Conexion.getConexion();
        Connection cx4 = Conexion.getConexion();
        Connection cx5 = Conexion.getConexion();
        String IDU = "";
        String IDP = "";
        String IDC = "";
        String IDT = "";
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Usuario From USUARIO Where NickName = ?");
            ps.setString(1, Usuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDU = res.getString("ID_Usuario");
            }
            //------------------------------------------------------------------
            PreparedStatement ps2 = cx2.prepareStatement("Select ID_Proyecto From PROYECTO Where Nombre_Proyecto = ?");
            ps2.setString(1, Proyecto);
            
            ResultSet res2;
            res2 = ps2.executeQuery();
            
            while (res2.next()){
                IDP = res2.getString("ID_Proyecto");
            }
            //------------------------------------------------------------------
            PreparedStatement ps4 = cx4.prepareStatement("Select ID_Conocimiento From CONOCIMIENTO Where Nombre_Conocimiento = ?");
            ps4.setString(1, Conocimiento);
            
            ResultSet res4;
            res4 = ps4.executeQuery();
            
            while (res4.next()){
                IDC = res4.getString("ID_Conocimiento");
            }
            //------------------------------------------------------------------
            PreparedStatement ps1 = cx1.prepareStatement("Insert Into TAREA(Nombre_Tarea, Descripcion, Fecha_Inicio, Estado ,ID_Proyecto, ID_Conocimiento) Values(?,?,?,?,?,?)");
            ps1.setString(1, Nombre);
            ps1.setString(2, Descripcion);
            ps1.setString(3, FechaInicio);
            ps1.setString(4, Estado);
            ps1.setString(5, IDP);
            ps1.setString(6, IDC);
            
            int res1 = ps1.executeUpdate();
            
            if(res1>0){
                respuesta = true;
            }
            //------------------------------------------------------------------
            PreparedStatement ps5 = cx5.prepareStatement("Select ID_Tarea From TAREA Where Nombre_Tarea = ?");
            ps5.setString(1, Nombre);
            
            ResultSet res5;
            res5 = ps5.executeQuery();
            
            while (res5.next()){
                IDT = res5.getString("ID_Tarea");
            }
            //------------------------------------------------------------------
            PreparedStatement ps3 = cx3.prepareStatement("Insert Into TAREA_USUARIO(ID_Tarea, ID_Usuario) Values(?,?)");
            ps3.setString(1, IDT);
            ps3.setString(2, IDU);
            
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
            cx4.close();
            cx5.close();
            System.out.println("Conexion Cerrada!");
        }
        return respuesta;
    }
}
