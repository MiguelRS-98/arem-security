package edu.escuelaing.arem.login;

import edu.escuelaing.arem.user.User;
import java.net.URI;
import org.eclipse.jetty.client.api.Authentication;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.util.Attributes;
import spark.*;

/**
 * Clase encargada del servico de logueo del usuario.
 * @author Miguel Angel Rodriguez Siachoque
 */
public class Login 
{
    private final String URL = "ec2-18-236-102-219.us-west-2.compute.amazonaws.com:42000";
    private static final User user = new User();
    /**
     * Metodo encargada de dar los datos suministrados por el usuario para el logueo.
     * @param req Datos del usuario.
     * @param res Respuesta.
     * @return Confirmacion de autenticacion.
     */
    public String login (Request req, Response res) 
    {
        String autentication = "";
        if (checkUser(user)) {
            autentication = "OK, Next";
        } else {
            autentication = "STOP, Back";
        }
        return autentication;
    }
    /**
     * Metodos que verifica que los datos del usuario sean correctos.
     * @param user Usuario a verificar.
     * @return Confirmacon de validacion.
     */
    public boolean checkUser(User user) 
    {
        boolean checkUser = false;
        if (user.getEmail().equals(user) && user.getPassword().equals(user)) {
            checkUser = true;
        }
        return checkUser;
    }
    private static final Authentication authentication = new Authentication() 
    {
        /**
         * Booleano autenticador de usuario.
         */
        @Override
        public boolean matches(String string, URI uri, String string1) 
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        /**
         * Autenticador de usuario.
         */
        @Override
        public Authentication.Result authenticate (Request rqst, ContentResponse cr, Authentication.HeaderInfo hi, Attributes atrbts) 
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };
}