package edu.escuelaing.arem.keys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import jdk.nashorn.api.scripting.URLReader;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;

/**
 * Clase que verifica los archivos de URL, KeyStores.
 * @author Miguel Angel Rodriguez Siachoque
 */
    public class ReaderURL 
{
    /**
     * Mertodo encargado de administrar la carpeta de Keys.
     * @throws FileNotFoundException Excepcion de archivo no encontrado.
     * @throws IOException Excepcion de accion no justificada.
     */
    public static void Keys () throws FileNotFoundException, IOException 
    {
        try {
            File trustStoreFile = new File("keystores/myTrustStore");
            char[] trustStorePassword = "123456".toCharArray(); 
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);
            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(trustStore);
            for (TrustManager i: trustFactory.getTrustManagers()){
                System.out.println(i);
            }
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustFactory.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException | KeyManagementException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Metodo encargado de generar respuesta de la URL.
     * @param webSite Sitio a realizar la lectura.
     * @return Respuesta del sitio Web.
     */
    public static String URL (String webSite) 
    {
        try {
            URL siteURL = new URL(webSite);
            URLConnection urlConnection = siteURL.openConnection();
            System.out.println("---message-body---");
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
            return response.toString();
        } catch (IOException x) {
            return x.toString();
        }
    }    
}
