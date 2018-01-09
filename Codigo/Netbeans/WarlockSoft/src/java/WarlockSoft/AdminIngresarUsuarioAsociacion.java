package WarlockSoft;

import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author serg_
 */
@WebService(serviceName = "AdminIngresarUsuarioAsociacion")
public class AdminIngresarUsuarioAsociacion {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarUyA")
    public boolean AgregarUyA(@WebParam(name = "Comando") String Comando) throws SQLException {
        //TODO write your implementation code here:
        
        Comando = Comando + "$";
        char[] listado;
        listado = Comando.toCharArray();
        int cont = 0;
        int estado = 0;
        
        String Tabla = "";
        String Campo = "";
        String Valor = "";
        
        String[] Datos = new String [10];
        
        String Miembro = "";
        int contM = 0;
        
        String[] Miembros = new String [10];
        
        
        //----------------------------------------------------------------------
        while(listado[cont] != '$'){
            switch (estado) {
                //-------------------------------------------------------------- 0-FIN
                case 0:
                    if(listado[cont] == '{'){
                        estado = 1;
                    }else{
                        estado = 0;
                    }
                break;
                //-------------------------------------------------------------- 1-FIN
                case 1:
                    if(listado[cont] == '"'){
                        estado = 2;
                    }else{
                        estado = 1;
                    }
                break;
                //-------------------------------------------------------------- 2-FIN
                case 2:
                    if(Character.isLetter(listado[cont])){
                        Tabla = "";
                        Tabla += String.valueOf(listado[cont]);
                        estado = 3;
                    }else{
                        estado = 2;
                    }
                break;
                //-------------------------------------------------------------- 3-FIN
                case 3:
                    if(Character.isLetter(listado[cont])){
                        Tabla += String.valueOf(listado[cont]);
                        estado = 3;
                    }else if (listado[cont] == '"'){
                        estado = 4;
                        System.out.println(Tabla);
                    }
                break;
                //-------------------------------------------------------------- 4-FIN
                case 4:
                    if(listado[cont] == ':'){
                        estado = 5;
                    }else{
                        estado = 4;
                    }
                break;
                //-------------------------------------------------------------- 5-FIN
                case 5:
                    if(listado[cont] == '['){
                        estado = 6;
                    }else{
                        estado = 5;
                    }
                break;
                //-------------------------------------------------------------- 6-FIN
                case 6:
                    if(listado[cont] == '{'){
                        estado = 7;
                    }else{
                        estado = 6;
                    }
                break;
                //-------------------------------------------------------------- 7-FIN
                case 7:
                    if(listado[cont] == '"'){
                        estado = 8;
                    }else{
                        estado = 7;
                    }
                break;
                //-------------------------------------------------------------- 8-FIN
                case 8:
                    if(Character.isLetter(listado[cont])){
                        Campo = "";
                        Campo += String.valueOf(listado[cont]);
                        estado = 9;
                    }else{
                        estado = 8;
                    }
                break;
                //-------------------------------------------------------------- 9-FIN
                case 9:
                    if(Character.isLetter(listado[cont])| listado[cont] == '_'){
                        Campo += String.valueOf(listado[cont]);
                        estado = 9;
                    }else if (listado[cont] == '"'){
                        estado = 10;
                        System.out.println(Campo);
                    }
                break;
                //-------------------------------------------------------------- 10-FIN
                case 10:
                    if(listado[cont] == ':'){
                        estado = 11;
                    }else{
                        estado = 10;
                    }
                break;
                //-------------------------------------------------------------- 11-FIN
                case 11:
                    if(listado[cont] == '"'){
                        estado = 12;
                    }else if(listado[cont] == '['){
                        estado = 17;
                        contM = 0;
                    }else{
                        estado = 11;
                    }
                break;
                //-------------------------------------------------------------- 12-FIN
                case 12:
                    if(Character.isLetter(listado[cont])| Character.isDigit(listado[cont])){
                        Valor = "";
                        Valor += String.valueOf(listado[cont]);
                        estado = 13;
                    }else{
                        estado = 12;
                    }
                break;
                //-------------------------------------------------------------- 13-FIN
                case 13:
                    if(listado[cont] == '"'){
                        estado = 14;
                        System.out.println(Valor);
                    }else{
                        Valor += String.valueOf(listado[cont]);
                        estado = 13;
                    }
                break;
                //-------------------------------------------------------------- 14-FIN
                case 14:
                    if(listado[cont] == ','){
                        estado = 7;
                        
                        //INSERCCION A LISTA DE DATOS
                        if(Tabla.toLowerCase().equals("usuarios")){
                            if(Campo.toLowerCase().equals("nombre_completo")){
                                Datos[0] = Valor;
                            }else if(Campo.toLowerCase().equals("correo")){
                                Datos[1] = Valor;
                            }else if(Campo.toLowerCase().equals("fecha_nacimiento")){
                                Datos[2] = Valor;
                            }else if(Campo.toLowerCase().equals("contraseña")){
                                Datos[3] = Valor;
                            }else if(Campo.toLowerCase().equals("nickname")){
                                Datos[4] = Valor;
                            }
                        }else if(Tabla.toLowerCase().equals("asociaciones")){
                            if(Campo.toLowerCase().equals("nombre_asociacion")){
                                Datos[0] = Valor;
                            }else if(Campo.toLowerCase().equals("objetivo")){
                                Datos[1] = Valor;
                            }
                        }
                        
                    }else if(listado[cont] == '}'){
                        estado = 15;
                        //INSERCCION A LISTA DE DATOS
                        if(Tabla.toLowerCase().equals("usuarios")){
                            if(Campo.toLowerCase().equals("nombre_completo")){
                                Datos[0] = Valor;
                            }else if(Campo.toLowerCase().equals("correo")){
                                Datos[1] = Valor;
                            }else if(Campo.toLowerCase().equals("fecha_nacimiento")){
                                Datos[2] = Valor;
                            }else if(Campo.toLowerCase().equals("contraseña")){
                                Datos[3] = Valor;
                            }else if(Campo.toLowerCase().equals("nickname")){
                                Datos[4] = Valor;
                            }
                        }else if(Tabla.toLowerCase().equals("asociaciones")){
                            if(Campo.toLowerCase().equals("nombre_asociacion")){
                                Datos[0] = Valor;
                            }else if(Campo.toLowerCase().equals("objetivo")){
                                Datos[1] = Valor;
                            }
                        }
                        
                        //INSERCCION A BD
                        if(Tabla.toLowerCase().equals("usuarios")){
                            CrearCuenta CC = new CrearCuenta();
                            CC.AgregarCuenta(Datos[0], Datos[4], Datos[1], Datos[3], Datos[2]);
                        }else if(Tabla.toLowerCase().equals("asociaciones")){
                            CrearAsociacion2 CA2 = new CrearAsociacion2();
                            CA2.AgregarAsociacion2(Datos[0], Datos[1]);
                            CA2.AgregarMiembros2(Miembros, contM, Datos[0]);
                        }
                        
                    }else{
                        estado = 14;
                    }
                break;
                //-------------------------------------------------------------- 15-FIN
                case 15:
                    if(listado[cont] == ']'){
                        estado = 16;
                    }else if(listado[cont] == '{'){
                        estado = 7;
                    }else{
                        estado = 15;
                    }
                break;
                //-------------------------------------------------------------- 16-FIN
                case 16:
                    if(listado[cont] == '}'){
                        estado = 21; 
                    }else if(listado[cont] == ','){
                        estado = 1;
                    }else{
                        estado = 16;
                    }
                break;
                //-------------------------------------------------------------- 17-FIN
                case 17:
                    if(listado[cont] == '"'){
                        estado = 18;
                        contM++;
                    }else{
                        estado = 17;
                    }
                break;
                //-------------------------------------------------------------- 18-FIN
                case 18:
                    if(Character.isLetter(listado[cont])){
                        Miembro = "";
                        Miembro += String.valueOf(listado[cont]);
                        estado = 19;
                    }else{
                        estado = 18;
                    }
                break;
                //-------------------------------------------------------------- 19-FIN
                case 19:
                    if(listado[cont] == '"'){
                        estado = 20;
                        System.out.println(Miembro);
                        Miembros[contM-1] = Miembro;
                        
                    }else {
                        Miembro += String.valueOf(listado[cont]);
                        estado = 19;
                    }
                break;
                //-------------------------------------------------------------- 20-FIN
                case 20:
                    if(listado[cont] == ','){
                        estado = 17;
                    }else if (listado[cont] == ']'){
                        estado = 14;
                    }else{
                        estado = 20;
                    }
                break;
                //--------------------------------------------------------------
                case 21:
                    estado = 21;
                break;
                
                default:
                    System.out.println("muri");
                break;
            }
            cont++;
        }
        return false;
    }
    
   /* public static void main(String[] args) throws SQLException {
        
        AdminIngresarUsuarioAsociacion AdminUA = new AdminIngresarUsuarioAsociacion();
        
        AdminUA.AgregarUyA("");
        
    }*/
}
