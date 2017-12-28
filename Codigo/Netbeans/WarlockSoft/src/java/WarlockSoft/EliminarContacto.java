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
@WebService(serviceName = "EliminarContacto")
public class EliminarContacto {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "EliminarAmigo")
    public boolean EliminarAmigo(@WebParam(name = "IDUsuario") String IDUsuario, @WebParam(name = "NickAmigo") String NickAmigo) throws SQLException {
        //TODO write your implementation code here:
        boolean respuesta = false;
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Delete From CONTACTO Where NickName_COntacto = ? AND ID_Usuario = ?");
            ps.setString(1, NickAmigo);
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
    @WebMethod(operationName = "ObtenerIDUsuario")
    public String ObtenerIDUsuario(@WebParam(name = "NombreUsuario") String NombreUsuario) throws SQLException {
        //TODO write your implementation code here:
        String ID = "";
        Connection cx = Conexion.getConexion();
        
        try {
            PreparedStatement ps = cx.prepareStatement("Select ID_Usuario From USUARIO Where NickName =?");
            ps.setString(1, NombreUsuario);
            
            ResultSet res;
            res = ps.executeQuery();
            
            while (res.next()){
                ID= res.getString("ID_Usuario");
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
}
