package cl.multiverso.spring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Clase de utileria que permite generar passwords encriptadas
 *
 * @author saturno
 */
public class EncriptarPassword {

    public static void main(String[] args) {
        var password = "12345";
        System.out.println("Password sin encriptar: " + password);
        System.out.println("Password encriptada: " + encriptarPassword(password));
        
    }

    /**
     * Metodo que utiliza BCrypt para codificar la password
     *
     * @param password
     * @return
     */
    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    
   
}//fin clase
