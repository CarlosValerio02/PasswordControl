package Main;

import IU.JFrLogin;

/**
 * @author Carlos Daniel
 */
public class Generador_Contrasenias {

    /**
     * Clase principal que llama a la clase necesaria con los métodos
     * específicos para lanzar la ventana de inicio de sesión.
     *
     * @param args ?
     */
    public static void main(String[] args) {
        Globales.Metodos.prepararArchivosCifrado();
        Globales.Metodos.establecerEstilo();
        JFrLogin.getJFrLogin().setVisible(true);
    }
    
    /*==========================  Disclaimer ========================= 
        -> Los elementos gráficos son obtenidos de la
            librería del usuario 'RojeruSan', todos los
            créditos son para él.
            *Visita su perfil de github: https://github.com/RojeruSan
    
        -> La clase para cifrar y descifrar son obra 
            del usuario Alvaro De León, todos los
            créditos son para él.
            * Visita su página:
            https://www.alvarodeleon.net/encriptar-y-desencriptar-con-rsa-en-java/
    
        -> Los iconos e imágenes son utilizados bajo la licencia de 
            Flaticon, todos los créditos son para su respectivo creador.
            *Visita la página web: https://www.flaticon.com/
    
    
                    Carlos Valerio - Octubre 2021 - V.1.0
    
      ========================== ********** ========================= */
}
