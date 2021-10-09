package Controladores;

import IU.JFrLogin;
import IU.JFrPrincipal;
import IU.Paneles.JPaLogin;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * @author Carlos Daniel
 */
public class Principal {

    /**
     * Muestra un mensaje de confirmación de salida y en caso afirmativo cierra
     * la ventana actual y muestra la pantalla de ingreso.
     */
    public static void cerrarSesion() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "¿Realmente desea salir?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (JOptionPane.YES_OPTION == respuesta) {
            JFrPrincipal.getJFrPrincipal().dispose();
            JFrLogin.getJFrLogin().setVisible(true);
            JPaLogin.getJPaLogin().getTxtContrasenia().requestFocus();
        }
    }

    public static void eliminarArchivo(String urlArchivo) {
        try {
            File archivo = new File(urlArchivo);
            archivo.delete();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el archivo", "¡Alerta!", JOptionPane.ERROR_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        }

    }

    /**
     * Modifica el parámetro del archivo recibido para ocultarlo en el sistema.
     *
     * @param url Ubicación del archivo; excluye el nombre y extensión del
     * archivo.
     * @param archivo Nombre y extensión del archivo.
     */
    public static void ocultarArchivo(String url, String archivo) {
        try {
            Path ruta = Paths.get(url, archivo);
            Boolean oculto = (Boolean) Files.getAttribute(ruta, "dos:hidden", LinkOption.NOFOLLOW_LINKS);
            if (oculto != null && !oculto) {
                Files.setAttribute(ruta, "dos:hidden", Boolean.TRUE, LinkOption.NOFOLLOW_LINKS);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar ocultar el archivo", "¡Alerta!", JOptionPane.ERROR_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Rellena el frame con la licencia contenida en el archivo.
     *
     * @param tabla JTable a rellenar con la información.
     */
    public static void rellenarTabla(JTable tabla) {
        File archivo = null;
        BufferedReader buffered = null;
        FileReader lector = null;
        try {
            String linea;

            archivo = new File(".\\" + Globales.Variables.getNOMBRE_ARCHIVO());
            lector = new FileReader(archivo);
            buffered = new BufferedReader(lector);

            Vector<Vector> datos = new Vector<>();
            int contador = 0;
            while ((linea = buffered.readLine()) != null) {
                String valores[] = linea.split(" ");
                Vector registro = new Vector();
                for (String valore : valores) {
                    if (contador < 3) {
                        String descifrado = Globales.Metodos.descifrar(valore);
                        registro.add(descifrado);
                    } else {
                        registro.add(valore);
                    }
                    contador++;
                }
                datos.add(registro);
                contador = 0;
            }

            Vector<String> columnas = new Vector<>();
            columnas.add("Sitio Web");
            columnas.add("Nombre de Usuario");
            columnas.add("Contraseña");
            columnas.add("Fecha de Creación");

            tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
            tabla.setDefaultEditor(Object.class, null);


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar leer el archivo", "¡Alerta!", JOptionPane.ERROR_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        } finally {
            try {
                if (null != lector) {
                    lector.close();
                }
            } catch (IOException e2) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar cerrar el archivo", "¡Alerta!", JOptionPane.ERROR_MESSAGE);
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

}
