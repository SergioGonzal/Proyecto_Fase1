package WarlockSoft;

import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author S;G
 */
@WebService(serviceName = "AdminIngresarProyecto")
public class AdminIngresarProyecto {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarP")
    public boolean AgregarP(@WebParam(name = "Comando") String Comando) throws SQLException {
        //TODO write your implementation code here:
        Comando = Comando + "$";
        char[] listado;
        listado = Comando.toCharArray();
        int cont = 0;
        int estado = 0;
        
        String Tabla = "";
        String Campo = "";
        String Valor = "";
        
        String[] DatosP = new String [6];
        String[] DatosT = new String [6];
        
        
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
                //-------------------------------------------------------------- 11----------------------------------------
                case 11:
                    if(listado[cont] == '"'){
                        estado = 12;
                    }else if(listado[cont] == '['){
                        estado = 15; 
                        
                        CrearProyecto2 CP2 = new CrearProyecto2();
                        //CP2.AgregarProyecto(DatosP[0], DatosP[1], DatosP[2], DatosP[3], DatosP[4], DatosP[5]);
                        
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
                        if(Campo.toLowerCase().equals("nombre")){
                            DatosP[0] = Valor;
                        }else if(Campo.toLowerCase().equals("fechainicio")){
                            DatosP[1] = Valor;
                        }else if(Campo.toLowerCase().equals("fechacierre")){
                            DatosP[2] = Valor;
                        }else if(Campo.toLowerCase().equals("estado")){
                            DatosP[3] = Valor;
                        }else if(Campo.toLowerCase().equals("sueldo")){
                            DatosP[4] = Valor;
                        }else if(Campo.toLowerCase().equals("creador")){
                            DatosP[5] = Valor;
                        }
                        
                    }else{
                        estado = 14;
                    }
                break;
                //-------------------------------------------------------------- 15-FIN
                case 15:
                    if(listado[cont] == '{'){
                        estado = 16;
                    }else{
                        estado = 15;
                    }
                break;
                //-------------------------------------------------------------- 16-FIN
                case 16:
                    if(listado[cont] == '"'){
                        estado = 17;
                    }else{
                        estado = 16;
                    }
                break;
                //-------------------------------------------------------------- 17-FIN
                case 17:
                    if(Character.isLetter(listado[cont])){
                        Campo = "";
                        Campo += String.valueOf(listado[cont]);
                        estado = 18;
                    }else{
                        estado = 17;
                    }
                break;
                //-------------------------------------------------------------- 18-FIN
                case 18:
                    if(Character.isLetter(listado[cont])| listado[cont] == '_'){
                        Campo += String.valueOf(listado[cont]);
                        estado = 18;
                    }else if (listado[cont] == '"'){
                        estado = 19;
                        System.out.println(Campo);
                    }
                break;
                //-------------------------------------------------------------- 19-FIN
                case 19:
                    if(listado[cont] == ':'){
                        estado = 20;
                    }else{
                        estado = 19;
                    }
                break;
                //-------------------------------------------------------------- 20-FIN
                case 20:
                    if(listado[cont] == '"'){
                        estado = 21;
                    }else{
                        estado = 20;
                    }
                break;
                //-------------------------------------------------------------- 21-FIN
                case 21:
                    if(Character.isLetter(listado[cont])| Character.isDigit(listado[cont])){
                        Valor = "";
                        Valor += String.valueOf(listado[cont]);
                        estado = 22;
                    }else{
                        estado = 21;
                    }
                break;
                //-------------------------------------------------------------- 22-FIN
                case 22:
                    if(listado[cont] == '"'){
                        estado = 23;
                        System.out.println(Valor);
                    }else{
                        Valor += String.valueOf(listado[cont]);
                        estado = 22;
                    }
                break;
                //-------------------------------------------------------------- 23----------------------------------------
                case 23:
                    if(listado[cont] == ','){
                        estado = 16;
                        //INSERCCION A LISTA
                        if(Campo.toLowerCase().equals("nombre")){
                            DatosT[0] = Valor;
                        }else if(Campo.toLowerCase().equals("descripcion")){
                            DatosT[1] = Valor;
                        }else if(Campo.toLowerCase().equals("fechainicio")){
                            DatosT[2] = Valor;
                        }else if(Campo.toLowerCase().equals("estadoactual")){
                            DatosT[3] = Valor;
                        }else if(Campo.toLowerCase().equals("conocimiento")){
                            DatosT[4] = Valor;
                        }else if(Campo.toLowerCase().equals("asignado")){
                            DatosT[5] = Valor;
                        }
                        
                    }else if(listado[cont] == '}'){
                        estado = 24; 
                        //INSERCCION A LISTA
                        if(Campo.toLowerCase().equals("nombre")){
                            DatosT[0] = Valor;
                        }else if(Campo.toLowerCase().equals("descripcion")){
                            DatosT[1] = Valor;
                        }else if(Campo.toLowerCase().equals("fechainicio")){
                            DatosT[2] = Valor;
                        }else if(Campo.toLowerCase().equals("estadoactual")){
                            DatosT[3] = Valor;
                        }else if(Campo.toLowerCase().equals("conocimiento")){
                            DatosT[4] = Valor;
                        }else if(Campo.toLowerCase().equals("asignado")){
                            DatosT[5] = Valor;
                        }
                        //INSERCCION A BD
                        CrearProyecto2 CP2 = new CrearProyecto2();
                        CP2.AgregarTareaProyecto2(DatosT[0], DatosT[1], DatosT[2], DatosT[3], DatosP[0], DatosT[4], DatosT[5]);
                    }else{
                        estado = 23;
                    }
                break;
                //-------------------------------------------------------------- 24-FIN
                case 24:
                    if(listado[cont] == '{'){
                        estado = 16;
                    }else if (listado[cont] == ']'){
                        estado = 25;
                    }else{
                        estado = 24;
                    }
                break;
                //-------------------------------------------------------------- 25-FIN
                case 25:
                    if(listado[cont] == '}'){
                        estado = 26;
                    }else{
                        estado = 25;
                    }
                break;
                //-------------------------------------------------------------- 26-FIN
                case 26:
                    if(listado[cont] == '{'){
                        estado = 7;
                    }else if (listado[cont] == ']'){
                        estado = 27;
                    }else{
                        estado = 26;
                    }
                break;
                //-------------------------------------------------------------- 27-FIN
                case 27:
                    if(listado[cont] == '}'){
                        estado = 28;
                    }else{
                        estado = 27;
                    }
                break;
                //-------------------------------------------------------------- 28-FIN
                case 28:
                    estado = 28;
                break;
                //--------------------------------------------------------------
                default:
                    System.out.println("muri");
                break;
            }
            cont++;
        }
        return false;
    }
    
    
    public static void main(String[] args) throws SQLException {
        
        AdminIngresarProyecto IP = new AdminIngresarProyecto();
        
        IP.AgregarP("{ \n" +
"	\"Proyectos\": [\n" +
"		{ \n" +
"			\"creador\": \"A;F\", \n" +
"			\"nombre\" : \"Ingeniero Espacial\",\n" +
"			\"fechainicio\": \"2017-12-01\", \n" +
"			\"fechacierre\": \"2018-01-01\", \n" +
"			\"sueldo\": \"9900.00\", \n" +
"			\"estado\": \"activo\", \n" +
"			\"Tareas\": [ \n" +
"				{ \n" +
"					\"nombre\": \"Crear BD\", \n" +
"					\"descripcion\": \"crear la BD del software\", \n" +
"					\"fechainicio\": \"2017-12-12\", \n" +
"					\"fechacierre\": \"2017-12-15\", \n" +
"					\"estadoactual\": \"iniciado\", \n" +
"					\"conocimiento\" : \"MariaDB\",\n" +
"					\"Asignado\": \"I;G\"\n" +
"				}\n" +
"				{\n" +
"					\"nombre\": \"Diseñar interface\", \n" +
"					\"descripcion\": \"crear la inteface del software\", \n" +
"					\"fechainicio\": \"2017-12-15\", \n" +
"					\"fechacierre\": \"2017-12-20\", \n" +
"					\"estadoactual\": \"finalizado\", \n" +
"					\"conocimiento\" : \"C\",\n" +
"					\"Asignado\": \"I;G\"\n" +
"				}\n" +
"				{\n" +
"					\"nombre\": \"Programacion\", \n" +
"					\"descripcion\": \"programar todo\", \n" +
"					\"fechainicio\": \"2017-12-15\", \n" +
"					\"fechacierre\": \"2017-12-20\", \n" +
"					\"estadoactual\": \"borrador\", \n" +
"					\"conocimiento\" : \"JAVA\",\n" +
"					\"Asignado\": \"A;G\"\n" +
"				}\n" +
"			] \n" +
"		}\n" +
"	]\n" +
"}");
        
    }
}
