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
@WebService(serviceName = "SolicitarUnionTarea")
public class SolicitarUnionTarea {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TerminarTarea")
    public boolean TerminarTarea(@WebParam(name = "Tarea") String Tarea, @WebParam(name = "IDProyecto") String IDProyecto) throws SQLException {
        //TODO write your implementation code here:
         boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Update TAREA set Estado = ? Where Nombre_Tarea = ? AND ID_Proyecto = ?");
            
            ps.setString(1, "Finalizada");
            ps.setString(2, Tarea);
            ps.setString(3, IDProyecto);
            
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
    @WebMethod(operationName = "SolicitarTrabajarTarea")
    public boolean SolicitarTrabajarTarea(@WebParam(name = "Tarea") String Tarea, @WebParam(name = "IDUsuario") String IDUsuario, @WebParam(name = "IDProyecto") String IDProyecto) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        String IDCN = "";
        String IDT = "";
        
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        Connection cx2 = Conexion.getConexion();
        Connection cx3 = Conexion.getConexion();
        Connection cx4 = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Conocimiento From TAREA Where Nombre_Tarea =?");
            ps.setString(1, Tarea);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDCN = res.getString("ID_Conocimiento");
            }
            //------------------------------------------------------------------
            PreparedStatement ps1 = cx1.prepareStatement("Select ID_Conocimiento From CONOCIMIENTO_USUARIO Where ID_Usuario =?");
            ps1.setString(1, IDUsuario);
            
            ResultSet res1;
            res1 = ps1.executeQuery();
            
            while (res1.next()){
                if(res1.getString("ID_Conocimiento").equals(IDCN)){
                    respuesta = true;
                }
            }
            
            //------------------------------------------------------------------
            if(respuesta == true){
                PreparedStatement ps2 = cx2.prepareStatement("Select ID_Tarea From TAREA Where Nombre_Tarea =?");
                ps2.setString(1, Tarea);

                ResultSet res2;
                res2 = ps2.executeQuery();

                while (res2.next()){
                    IDT = res2.getString("ID_Tarea");
                }
                
                //--------------------------------------------------------------
                PreparedStatement ps3 = cx3.prepareStatement("Insert Into TAREA_USUARIO(ID_Tarea, ID_Usuario) Values(?,?)");
                ps3.setString(1, IDT);
                ps3.setString(2, IDUsuario);

                int res3 = ps3.executeUpdate();

                if(res3>0){
                    respuesta = true;
                }
                //--------------------------------------------------------------
                PreparedStatement ps4 = cx4.prepareStatement("Insert Into PROYECTO_USUARIO(Rol, ID_Proyecto, ID_Usuario) Values(?,?,?)");
                ps4.setString(1, "Miembro");
                ps4.setString(2, IDProyecto);
                ps4.setString(3, IDUsuario);
                
                int res4 = ps4.executeUpdate();

                if(res4>0){
                    respuesta = true;
                }
                
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
            System.out.println("Conexion Cerrada!");
        }
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerDatosTarea")
    public String[] ObtenerDatosTarea(@WebParam(name = "IDProyecto") String IDProyecto, @WebParam(name = "Tarea") String Tarea) throws SQLException {
        //TODO write your implementation code here:
        String[] Tareas = new String [4];
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select Nombre_Tarea, Descripcion, Fecha_Inicio, Estado From TAREA Where ID_Proyecto =? AND Nombre_Tarea = ?");
            ps.setString(1, IDProyecto);
            ps.setString(2, Tarea);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                Tareas[0]= res.getString("Nombre_Tarea");
                Tareas[1]= res.getString("Descripcion");
                Tareas[2]= res.getString("Fecha_Inicio");
                Tareas[3]= res.getString("Estado");
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            System.out.println("Conexion Cerrada!");
        }
        return Tareas;
    }

    /*public static void main(String[] args) throws SQLException{
        
        SolicitarUnionTarea SUT = new SolicitarUnionTarea();
        String[] Datos = new String [4];
        
        Datos = SUT.ObtenerDatosTarea("3", "Poker");
        
        System.out.println(Datos[0]+Datos[1]+Datos[2]+ Datos[3]);
    }*/
}
