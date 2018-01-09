/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebService(serviceName = "CrearEstados2")
public class CrearEstados2 {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CrearEstado2")
    public boolean CrearEstado2(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "Texto") String Texto) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        String IDU = "";
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Usuario From USUARIO Where NickName = ?");
            ps.setString(1, Usuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDU = res.getString("ID_Usuario");
            }
            //------------------------------------------------------------------
            PreparedStatement ps1 = cx1.prepareStatement("Insert Into ESTADO(Texto, ID_Usuario) Values(?,?)");
            ps1.setString(1, Texto);
            ps1.setString(2, IDU);
            
            int res1 = ps1.executeUpdate();
            
            if(res1>0){
                respuesta = true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error!");
        } finally {
            cx.close();
            cx1.close();
            System.out.println("Conexion Cerrada!");
        }
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CrearComentario2")
    public boolean CrearComentario2(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "Texto") String Texto) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        Connection cx1 = Conexion.getConexion();
        Connection cx2 = Conexion.getConexion();
        String IDU = "";
        String IDC = "";
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Estado From Estado Order By ID_Estado");
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                IDC = res.getString("ID_Estado");
            }
            //------------------------------------------------------------------
            PreparedStatement ps2 = cx2.prepareStatement("Select ID_Usuario From USUARIO Where NickName = ?");
            ps2.setString(1, Usuario);
            
            ResultSet res2;
            res2 = ps2.executeQuery();
            
            while (res2.next()){
                IDU = res2.getString("ID_Usuario");
            }
            
            //------------------------------------------------------------------
            PreparedStatement ps1 = cx1.prepareStatement("Insert Into COMENTARIO(Texto, ID_Usuario, ID_Estado) Values(?,?,?)");
            ps1.setString(1, Texto);
            ps1.setString(2, IDU);
            ps1.setString(3, IDC);
            
            int res1 = ps1.executeUpdate();
            
            if(res1>0){
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
}
