package Controladores;

import IU.Paneles.JPaNuevo;
import IU.Paneles.JPaPrincipal;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Vector;
import javax.swing.JCheckBox;
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
        String especiales = "!@#$%&/()=?|¿'";
        String numeros = "0123456789";
        String valores = mayusculas + minusculas + numeros + especiales;

        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        int tamanio = 16;
        for (int repeticion = 0; repeticion < tamanio; repeticion++) {
            int index = random.nextInt(valores.length());
            char aleatorio = valores.charAt(index);
            stringBuilder.append(aleatorio);
        }

        return stringBuilder.toString();
    }

    /**
     * Comprueba que los campos de registro no se encuentren vacíos
     *
     * @param panel JPanel que contendrá todos los campos a evaluar.
     * @param esExistente Define si es una contraseña existente.
     * @param esEdicion Define si es una edición.
     * @return cadena de texto con los valores contenidos en los campos.
     */
    public static String comprobarCampos(JPaNuevo panel, boolean esExistente, boolean esEdicion) {
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
                if (esExistente) {
                    if (new String(panel.getTxtContrasenia().getPassword()).trim().equals("")
                            || null == new String(panel.getTxtContrasenia().getPassword()).trim()) {
                        panel.getJlbError().setText("¡El campo 'Contraseña' está vacío!");
                        panel.getJlbError().setVisible(true);
                        Toolkit.getDefaultToolkit().beep();
                        panel.getTxtContrasenia().requestFocus();
                    } else {
                        panel.getJlbError().setText("");
                        String sitioWeb = Globales.Metodos.cifrar(panel.getTxtSitioWeb().getText().trim());
                        String usuario = Globales.Metodos.cifrar(panel.getTxtUsuario().getText().trim());
                        String contrasenia = Globales.Metodos.cifrar(new String(panel.getTxtContrasenia().getPassword()));
                        String valorObtenido = sitioWeb + " " + usuario + " " + contrasenia;
                        return valorObtenido;
                    }
                } else {
                    panel.getJlbError().setText("");
                    String sitioWeb = Globales.Metodos.cifrar(panel.getTxtSitioWeb().getText().trim());
                    String usuario = Globales.Metodos.cifrar(panel.getTxtUsuario().getText().trim());
                    String contrasenia = Globales.Metodos.cifrar(new String(panel.getTxtContrasenia().getPassword()));
                    String valorObtenido = sitioWeb + " " + usuario + " " + contrasenia;
                    return valorObtenido;
                }
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
        File archivo = new File(".\\Requeridos\\" + Globales.Variables.getNOMBRE_ARCHIVO());

        try (FileWriter escritor = new FileWriter(archivo, true)) {
            if (comprobarArchivoVacio()) {
                escritor.write(contenidoPorGuardar + " " + LocalDateTime.now() + "\n");
            } else {
                escritor.write(contenidoPorGuardar + " " + LocalDateTime.now() + "\n");
            }
            escritor.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocurrió un error al guardar el registro",
                    "Advertencia",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Guarda en el archivo especificado la información recibida como parámetro.
     *
     * @param contenidoPorGuardar el contenido a guardar almacenado en una
     * variable.
     * @param valoresAEditar Colección con los valores que se van a modificar
     */
    public static void guardarRegistros(String contenidoPorGuardar, Vector<String> valoresAEditar) {

        File archivo = new File(".\\Requeridos\\" + Globales.Variables.getNOMBRE_ARCHIVO());

        //TODO: Cambiar el método para actualizar los registros,
        //          esta es una versión propensa a fallar.
        // <------
        archivo.delete();
        Globales.Metodos.comprobarArchivo();
        // -------->
        Vector<Vector> datos = Principal.getDatos();
        if (!datos.isEmpty()) {
            int indiceVacio = -1;
            int indice = obtenerIndiceVector(datos, valoresAEditar);
            if (indice != indiceVacio) {
                datos.removeElementAt(indice);
                datos.add(generarVectorAGuardar(contenidoPorGuardar));

                try (FileWriter escritor = new FileWriter(archivo, true)) {
                    int contador = 1;
                    for (Vector<String> dato : datos) {
                        if (contador < datos.size()) {
                            escritor.write(
                                    Globales.Metodos.cifrar(dato.get(0)) + " "
                                    + Globales.Metodos.cifrar(dato.get(1)) + " "
                                    + Globales.Metodos.cifrar(dato.get(2)) + " "
                                    + dato.get(3)
                                    + "\n"
                            );
                        } else {
                            escritor.write(contenidoPorGuardar + " " + LocalDateTime.now() + "\n");
                        }
                        contador++;
                    }
                    escritor.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ocurrió un error al guardar los registros\n " + e.getMessage(),
                            "Advertencia",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            Principal.rellenarTabla(JPaPrincipal.getJPaPrincipal().getTabPrincipal(),
                    JPaPrincipal.getJPaPrincipal().getJlbTotalRegistros());
        }
    }

    /**
     * Copia el valor establecido en el campo txtContrasenia al portapapeles del
     * sistema.
     *
     * @param jlbError Label en el que mostrará el mensaje de éxito.
     * @param txtContrasenia Campo del cuál obtendrá el valor a copiar.
     */
    public static void copiarContraseña(JLabel jlbError, RSMPassView txtContrasenia) {
        String contrasenia = new String(txtContrasenia.getPassword());
        if (contrasenia.isEmpty() || contrasenia.trim().equalsIgnoreCase("")) {
            jlbError.setForeground(new Color(204, 0, 51));
            jlbError.setText("¡Campo de contraseña vacío!");
            jlbError.setVisible(true);
            Toolkit.getDefaultToolkit().beep();
        } else {
            Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(
                            new StringSelection(contrasenia),
                            null
                    );
            jlbError.setForeground(new Color(0, 102, 51));
            jlbError.setText("¡Contraseña copiada al portapapeles!");
            jlbError.setVisible(true);
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Lee la información del archivo contenedor y determina si está vacío.
     *
     * @return true si el archivo se encuentra vacío.
     */
    private static boolean comprobarArchivoVacio() {
        File archivo = new File(".\\Requeridos\\" + Globales.Variables.getNOMBRE_ARCHIVO());
        return archivo.length() == 0;
    }

    /**
     * Comprueba si es una contraseña existente y realiza las acciones
     * necesarias en caso afirmativo.
     *
     * @param cbxExistente CheckBox a comprobar
     * @param txtContrasenia Campo de texto del cual se obtendrá la contraseña
     */
    public static void comprobarExistente(JCheckBox cbxExistente, RSMPassView txtContrasenia) {
        if (cbxExistente.isSelected()) {
            txtContrasenia.setText("");
            txtContrasenia.setEditable(true);
            txtContrasenia.requestFocus();
        } else {
            txtContrasenia.setText(generarContrasenia());
            txtContrasenia.setEditable(false);
        }
    }

    /**
     * Obtiene la posición del elemento recibido en la colección recibida.
     *
     * @param datos Colección con los valores a evaluar.
     * @param valoresAEditar Colección con los valores a buscar.
     * @return Posición en la colección "datos", en caso de no existir regresa
     * el valor -1.
     */
    public static int obtenerIndiceVector(Vector<Vector> datos, Vector<String> valoresAEditar) {
        int valorNoEncontrado = -1;
        for (Vector datoTemporal : datos) {
            if (datoTemporal.contains(valoresAEditar.get(0)) && datoTemporal.contains(valoresAEditar.get(1))
                    && datoTemporal.contains(valoresAEditar.get(2))
                    && datoTemporal.contains(valoresAEditar.get(3))) {
                return datos.indexOf(datoTemporal);
            }
        }
        return valorNoEncontrado;
    }

    /**
     * Genera la colección a guardar con el elemento recibido.
     *
     * @param contenidoPorGuardar Elemento a guardar.
     */
    private static Vector<String> generarVectorAGuardar(String contenidoPorGuardar) {
        Vector<String> valoresAGuardar = new Vector<>();
        String[] valores = contenidoPorGuardar.split(" ");
        for (String valore : valores) {
            valoresAGuardar.add(valore);
        }
        valoresAGuardar.add("" + LocalDateTime.now());
        return valoresAGuardar;
    }
}
