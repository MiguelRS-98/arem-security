package edu.escuelaing.arem.app;

import edu.escuelaing.arem.service.Service;
import edu.escuelaing.arem.login.Login;
import static spark.Spark.*;

/**
 * Clase principal que da inicio al servicio web.
 * @author Miguel Angel Rodriguez Siachoque
 */
public class App 
{
    /**
     * Metodo principal que conecta la parte logica con la pagina web.
     * @param args Argumentos de conexion.
     */
    public static void main (String[] args) 
    {
        secure("keystores/ecikeystore.p12", "123456", null, null);
        staticFiles.location("/public");
        port(getPort());
	new Service (new Login()); 
    }
    /**
     * Metodo encargado de generar el puerto propuesto para el funcionamiento.
     * @return Puerto del servidor.
     */
    public static int getPort () 
    {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}