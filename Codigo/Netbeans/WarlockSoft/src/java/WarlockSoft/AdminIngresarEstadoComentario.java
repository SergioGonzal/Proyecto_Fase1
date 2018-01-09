package WarlockSoft;

import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author S;G
 */
@WebService(serviceName = "AdminIngresarEstadoComentario")
public class AdminIngresarEstadoComentario {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarEyC")
    public boolean AgregarEyC(@WebParam(name = "Comando") String Comando) throws SQLException {
        //TODO write your implementation code here:
        Comando = Comando + "$";
        char[] listado;
        listado = Comando.toCharArray();
        int cont = 0;
        int estado = 0;
        
        String Nombre = "";
        String Dato = "";
        
        String Usuario = "";
        String Estado = "";
        String Comentario = "";
        String[] DatosC = new String [2];
        int contE = 0;
        
        
        while(listado[cont] != '$'){
            switch (estado) {
                //--------------------------------------------------------------
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
                        Nombre = "";
                        Nombre += String.valueOf(listado[cont]);
                        estado = 3;
                    }else{
                        estado = 2;
                    }
                break;
                //-------------------------------------------------------------- 3-FIN
                case 3:
                    if(Character.isLetter(listado[cont])){
                        Nombre += String.valueOf(listado[cont]);
                        estado = 3;
                    }else if (listado[cont] == '"'){
                        estado = 4;
                        System.out.println(Nombre.toLowerCase());
                    }
                break;
                //--------------------------------------------------------------
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
                        Dato = "";
                        Dato += String.valueOf(listado[cont]);
                        estado = 9;
                    }else{
                        estado = 8;
                    }
                break;
                //-------------------------------------------------------------- 9-FIN
                case 9:
                    if(Character.isLetter(listado[cont])){
                        Dato += String.valueOf(listado[cont]);
                        estado = 9;
                    }else if (listado[cont] == '"'){
                        estado = 10;
                        System.out.println(Dato);
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
                        estado = 16;
                        contE = 0;
                    }else{
                        estado = 11;
                    }
                break;
                //--------------------------------------------------------------
                case 12:
                    if(Character.isLetter(listado[cont])| Character.isDigit(listado[cont])){
                        Dato = "";
                        Dato += String.valueOf(listado[cont]);
                        estado = 13;
                    }else{
                        estado = 12;
                    }
                break;
                //-------------------------------------------------------------- 13-FIN
                case 13:
                    if(listado[cont] == '"'){
                        estado = 14;
                        System.out.println(Dato);
                        Usuario = Dato;
                    }else{
                        Dato += String.valueOf(listado[cont]);
                        estado = 13;
                    }
                break;
                //-------------------------------------------------------------- 14-FIN
                case 14:
                    if(listado[cont] == ','){
                        estado = 7;
                    }else{
                        estado = 14;
                    }
                break;
                //--------------------------------------------------------------
                
                //-------------------------------------------------------------- 16-FIN
                case 16:
                    if(listado[cont] == '{'){
                        estado = 17;
                    }else{
                        estado = 16;
                    }
                break;
                //-------------------------------------------------------------- 17-FIN
                case 17:
                    if(listado[cont] == '"'){
                        estado = 18;
                    }else{
                        estado = 17;
                    }
                break;
                //-------------------------------------------------------------- 18-FIN
                case 18:
                    if(Character.isLetter(listado[cont])){
                        Dato = "";
                        Dato += String.valueOf(listado[cont]);
                        estado = 19;
                    }else{
                        estado = 18;
                    }
                break;
                //-------------------------------------------------------------- 19- FIN
                case 19:
                    if(listado[cont] == '"'){
                        estado = 20;
                        System.out.println(Dato);
                    }else{
                        Dato += String.valueOf(listado[cont]);
                        estado = 19;
                    }
                break;
                //-------------------------------------------------------------- 20- FIN
                case 20:
                    if(listado[cont] == ':'){
                        estado = 21;
                    }else{
                        estado = 20;
                    }
                break;
                //-------------------------------------------------------------- 21-
                case 21:
                    if(listado[cont] == '"'){
                        estado = 22;
                    }else if(listado[cont] == '['){
                        estado = 25;
                    }else{
                        estado = 21;
                    }
                break;
                //-------------------------------------------------------------- 22-FIN
                case 22:
                    if(Character.isLetter(listado[cont])| Character.isDigit(listado[cont])){
                        Estado = "";
                        Estado += String.valueOf(listado[cont]);
                        estado = 23;
                    }else{
                        estado = 22;
                    }
                break;
                //-------------------------------------------------------------- 23-FIN
                case 23:
                    if(listado[cont] == '"'){
                        estado = 24;
                        System.out.println(Estado);
                    }else{
                        Estado += String.valueOf(listado[cont]);
                        estado = 23;
                    }
                break;
                //-------------------------------------------------------------- 24-FIN
                case 24:
                    if(listado[cont] == ','){
                        estado = 17;
                        CrearEstados2 CE2 = new CrearEstados2();
                        CE2.CrearEstado2(Usuario, Estado);
                    }else{
                        estado = 24;
                    }
                break;
                //-------------------------------------------------------------- 25-FIN
                case 25:
                    if(listado[cont] == '{'){
                        estado = 26;
                    }else if (listado[cont] == ']'){
                        estado = 35;
                    }else{
                        estado = 25;
                    }
                break;
                //-------------------------------------------------------------- 26-FIN
                case 26:
                    if(listado[cont] == '"'){
                        estado = 27;
                    }else{
                        estado = 26;
                    }
                break;
                //-------------------------------------------------------------- 27-FIN
                case 27:
                    if(Character.isLetter(listado[cont])){
                        Dato = "";
                        Dato += String.valueOf(listado[cont]);
                        estado = 28;
                    }else{
                        estado = 27;
                    }
                break;
                //-------------------------------------------------------------- 28- FIN
                case 28:
                    if(Character.isLetter(listado[cont])){
                        Dato += String.valueOf(listado[cont]);
                        estado = 28;
                    }else if (listado[cont] == '"'){
                        estado = 29;
                        System.out.println(Dato);
                    }
                break;
                //-------------------------------------------------------------- 29-FIN
                case 29:
                    if(listado[cont] == ':'){
                        estado = 30;
                    }else{
                        estado = 29;
                    }
                break;
                //-------------------------------------------------------------- 30-FIN
                case 30:
                    if(listado[cont] == '"'){
                        estado = 31;
                    }else{
                        estado = 30;
                    }
                break;
                //-------------------------------------------------------------- 31-FIN
                case 31:
                    if(Character.isLetter(listado[cont])| Character.isDigit(listado[cont])){
                        Comentario = "";
                        Comentario += String.valueOf(listado[cont]);
                        estado = 32;
                    }else{
                        estado = 31;
                    }
                break;
                //-------------------------------------------------------------- 32-FIN
                case 32:
                    if(listado[cont] == '"'){
                        estado = 33;
                        System.out.println(Comentario);
                        
                        if(Dato.toLowerCase().equals("usuario")){
                            DatosC[0]= Comentario;
                        }
                        else if(Dato.toLowerCase().equals("texto")){
                            DatosC[1] = Comentario;
                        }
                    }else{
                        Comentario += String.valueOf(listado[cont]);
                        estado = 32;
                    }
                break;
                //--------------------------------------------------------------  33-FIN
                case 33:
                    if(listado[cont] == ','){
                        estado = 26;
                    }else if(listado[cont] == '}'){
                        estado = 34;
                        
                        CrearEstados2 CE2 = new CrearEstados2();
                        CE2.CrearComentario2(DatosC[0], DatosC[1]);
                    }else{
                        estado = 33;
                    }
                break;
                //-------------------------------------------------------------- 34-FIN
                case 34:
                    if(listado[cont] == '{'){
                        estado = 26;
                    }else if(listado[cont] == ']'){
                        estado = 35;
                    }else{
                        estado = 34;
                    }
                break;
                //-------------------------------------------------------------- 35-FIN
                case 35:
                    if(listado[cont] == '}'){
                        estado = 36;
                    }else{
                        estado = 35;
                    }
                break;
                //-------------------------------------------------------------- 36-FIN
                case 36:
                    if(listado[cont] == ']'){
                        estado = 37;
                    }else if(listado[cont] == '{'){
                        estado = 17;
                    }else{
                        estado = 36;
                    }
                break;
                //-------------------------------------------------------------- 37-FIN
                case 37:
                    if(listado[cont] == '}'){
                        estado = 38;
                    }else{
                        estado = 36;
                    }
                break;
                //-------------------------------------------------------------- 38-FIN
                case 38:
                    if(listado[cont] == ']'){
                        estado = 39;
                    }else if(listado[cont] == '{'){
                        estado = 7;
                    }else{
                        estado = 38;
                    }
                break;
                //-------------------------------------------------------------- 39-FIN
                case 39:
                    if(listado[cont] == '}'){
                        estado = 40;
                    }else{
                        estado = 39;
                    }
                break;
                //-------------------------------------------------------------- 40-FIN
                case 40:
                    estado = 40;
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
        
        AdminIngresarEstadoComentario AdminEC = new AdminIngresarEstadoComentario();
        
        AdminEC.AgregarEyC("");
        
    }*/
}
