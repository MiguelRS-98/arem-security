package edu.escuelaing.arem.user;

/**
 * Clase para obtener los datos del usuario
 * @author Miguel Angel Rodriguez Siachoque
 */
public class User 
{
    private String email;
    private String password;
    /**
     * Metodo que establece los datos del usuario.
     * @param email 
     * @param password 
     */
    public User (String email, String password) 
    {
        this.email = email;
        this.password = password;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * 
     * @return 
     */
    public String getEmail () 
    {
        return email;
    }
    /**
     * 
     * @param email 
     */
    public void setEmail (String email) 
    {
        this.email = email;
    }
    /**
     * 
     * @return 
     */
    public String getPassword () 
    {
        return password;
    }
    /**
     * 
     * @param password 
     */
    public void setPassword (String password) 
    {
        this.password = password;
    }
}