package Controladores;

import IU.Paneles.JPaNuevo;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import rojeru_san.RSMPassView;

/**
 * @author Carlos Daniel
 */
public class Registro {

    /**
     * Genera la nueva contraseña con un valor aleatorio
     *
     * @return contraseña aleatoria generada.
     */
    public static String generarContrasenia() {
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String especiales = "!@#$%&/()=?°|¿'";
        String numeros = "0123456789";
        String valores = mayusculas + minusculas + numeros + especiales;

        StringBuilder constructor = new StringBuilder();
        Random random = new Random();

        int tamanio = 16;
        for (int repeticion = 0; repeticion < tamanio; repeticion++) {

            int index = random.nextInt(valores.length());
            char aleatorio = valores.charAt(index);
            constructor.append(aleatorio);
        }

        return constructor.toString();
    }

    /**
     * Comprueba que los campos de registro no se encuentren vacíos
     *
     * @param panel JPanel que contendrá todos los campos a evaluar.
     * @return cadena de texto con los valores contenidos en los campos.
     */
    public static String comprobarCampos(JPaNuevo panel) {
        panel.getJlbError().setForeground(new Color(204, 0, 51));
        if (panel.getTxtSitioWeb().getText().trim().equals("") || null == panel.getTxtSitioWeb().getText().trim()) {
            panel.getJlbError().setText("¡El campo 'Sitio Web' está vacío!");
            panel.getJlbError().setVisible(true);
            Toolkit.getDefaultToolkit().beep();
            panel.getTxtSitioWeb().requestFocus();
        } else {
            if (panel.getTxtUsuario().getText().trim().equals("") || null == panel.getTxtUsuario().getText().trim()) {
                panel.getJlbError().setText("¡El campo 'Usuario' está vacío!");
                panel.getJlbError().setVisible(true);
                Toolkit.getDefaultToolkit().beep();
                panel.getTxtUsuario().requestFocus();
            } else {
                panel.getJlbError().setVisible(false);
                String sitioWeb = Globales.Metodos.cifrar(panel.getTxtSitioWeb().getText().trim());
                String usuario = Globales.Metodos.cifrar(panel.getTxtUsuario().getText().trim());
                String contrasenia = Globales.Metodos.cifrar(new String(panel.getTxtContrasenia().getPassword()));
                String valorObtenido = sitioWeb + " " + usuario + " " + contrasenia;
                return valorObtenido;
            }
        }
        return "";
    }

    /**
     * Guarda en el archivo especificado la información recibida como parámetro.
     *
     * @param contenidoPorGuardar el contenido a guardar almacenado en una
     * variable.
     */
    public static void guardarRegistro(String contenidoPorGuardar) {
        File archivo = new File(".\\" + Globales.Variables.getNOMBRE_ARCHIVO());

        try (FileWriter escribir = new FileWriter(archivo, true)) {
            if (comprobarArchivoVacio()) {
                escribir.write(contenidoPorGuardar + " " + LocalDateTime.now());
            } else {
                escribir.write("\n" + contenidoPorGuardar + " " + LocalDateTime.now());
            }
            escribir.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el registro", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Copia el valor establecido en el campo txtContrasenia al portapapeles del
     * sistema y después de 4 segundos oculta el mensaje.
     *
     * @param jlbError Label en el que mostrará el mensaje de éxito.
     * @param txtContrasenia Campo del cuál obtendrá el valor a copiar.
     */
    public static void copiarContraseña(JLabel jlbError, RSMPassView txtContrasenia) {
        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(
                        new StringSelection(new String(txtContrasenia.getPassword())),
                        null
                );
        jlbError.setForeground(new Color(0, 102, 51));
        jlbError.setText("¡Contraseña copiada al portapapeles!");
        jlbError.setVisible(true);
        Toolkit.getDefaultToolkit().beep();
    }

    /**
     * Lee la información del archivo contenedor y determina si está vacío.
     *
     * @return true si el archivo se encuentra vacío.
     */
    private static boolean comprobarArchivoVacio() {
        File archivo = new File(".\\" + Globales.Variables.getNOMBRE_ARCHIVO());
        return archivo.length() == 0;
    }
}