package edu.escuelaing.arem.service;

import edu.escuelaing.arem.login.Login;
import static spark.Spark.*;
import org.eclipse.jetty.client.api.Request;

/**
 * Clase que se encargar de distribuir los servicio de la web.
 * @author Miguel Angel Rodriguez Siachoque
 */
public class Service 
{
    /**
     * Este metodo se encarga de establecer el logueo para el usuario.
     * @param login servicio del usuario.
     */
    public Service (Login login) 
    {
        get("/hello", (req,res) -> "Hello world!");
        post("/login", (req, res) -> login.login((Request) req, res));
    }
}