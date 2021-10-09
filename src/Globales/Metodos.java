package Globales;

import Controladores.Principal;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Carlos Daniel
 */
public class Metodos {

    /**
     * Establece en un panel receptor un nuevo panel con contenido.
     *
     * @param contenedor Panel de la ventana que contendrá el panel con
     * contenido.
     * @param contenido Panel con el contenido.
     */
    public static void agregarPanel(JPanel contenedor, JPanel contenido) {
        contenedor.removeAll();
        contenedor.revalidate();
        contenedor.repaint();
        contenedor.revalidate();
        contenedor.add(contenido).setSize(contenedor.getWidth(), contenedor.getHeight());
        contenedor.repaint();
    }

    /**
     * Oculta el panel recibido para que no se muestre en pantalla.
     *
     * @param panelAOcultar objeto del tipo JPanel a ocultar.
     */
    public static void ocultarPaneles(JPanel panelAOcultar) {
        panelAOcultar.setVisible(false);
    }

    /**
     * Cambia los paneles para visualizar un panel y ocultar el otro.
     *
     * @param panelAOcultar objeto del tipo JPanel a ocultar.
     * @param panelVisible objeto del tipo JPanel a mostrar.
     */
    public static void ocultarPaneles(JPanel panelVisible, JPanel panelAOcultar) {
        panelVisible.setVisible(true);
        panelAOcultar.setVisible(false);
    }

    /**
     * Convierte el valor recibido en una cadena de texto encriptada en SHA-256.
     *
     * @param palabraAEncriptar texto que se desea encriptar.
     * @return String con el texto encriptado en SHA-256.
     */
    public static String convertirSHA256(String palabraAEncriptar) {
        try {
            MessageDigest mensaje = MessageDigest.getInstance("SHA-256");
            byte[] hash = mensaje.digest(palabraAEncriptar.getBytes());
            StringBuilder stringBuilder = new StringBuilder();

            for (byte _byte : hash) {
                stringBuilder.append(String.format("%02x", _byte));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * Muestra un cuadro de diálogo de confirmación de salida del sistema, En
     * caso afirmativo cierra la aplicación.
     */
    public static void mostrarMensajeCierre() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", "¿Realmente desea salir?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (JOptionPane.YES_OPTION == respuesta) {
            int SALIDA_EXITOSA = 0;
            System.exit(SALIDA_EXITOSA);
        }
    }

    /**
     * Comprueba si un archivo existe, y en caso negativo lo crea.
     */
    public static void comprobarArchivo() {
        try {
            String ruta_Archivo = ".\\" + Globales.Variables.getNOMBRE_ARCHIVO();
            File archivo = new File(ruta_Archivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Cifra la variable recibida.
     *
     * @param sinCifrar Cadena de texto a cifrar.
     * @return Frase cifrada.
     * @see RSA
     */
    public static String cifrar(String sinCifrar) {
        try {
            RSA rsa = RSA.getRSA();
            rsa.openFromDiskPrivateKey(".\\rsa.pri");
            rsa.openFromDiskPublicKey(".\\rsa.pub");
            return rsa.Encrypt(sinCifrar);
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al cifrar la cadena.\n " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al cifrar la cadena.\n " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Descifra la variable recibida.
     *
     * @param cifrado Cadena de texto a cifrada a descifrar.
     * @return Frase descifrada.
     * @see RSA
     */
    public static String descifrar(String cifrado) {
        try {
            RSA rsa = RSA.getRSA();
            rsa.openFromDiskPrivateKey(".\\rsa.pri");
            rsa.openFromDiskPublicKey(".\\rsa.pub");
            return rsa.Decrypt(cifrado);

        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al cifrar la cadena.\n " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al cifrar la cadena.\n " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    /**
     * Genera los archivos necesarios para el funcionamiento del cifrado.
     */
    public static void prepararArchivosCifrado() {

        try {
            RSA rsa = RSA.getRSA();

            //Admite claves de 512, 1024, 2048 y 4096 bits
            rsa.genKeyPair(512);

            String file_private = ".\\rsa.pri";
            String file_public = ".\\rsa.pub";
            //Las guardamos asi podemos usarlas despues
            //a lo largo del tiempo
            rsa.saveToDiskPrivateKey(file_private);
            rsa.saveToDiskPublicKey(file_public);

            Principal.ocultarArchivo(".\\", "rsa.pri");
            Principal.ocultarArchivo(".\\", "rsa.pub");

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar los archivos de cifrado.\n " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
