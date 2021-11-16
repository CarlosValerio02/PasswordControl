package Controladores;

import IU.JDiGeneral;
import IU.JFrLogin;
import IU.JFrPrincipal;
import IU.Paneles.JPaLogin;
import IU.Paneles.JPaNuevo;
import IU.Paneles.JPaPrincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import rojerusan.RSTableMetro;

/**
 * @author Carlos Daniel
 */
public class Principal {

    // ========================== Variables =============================
    private static Vector<Vector> datos = new Vector<>();
    private static boolean esBusqueda = false;
    private static Vector<String> columnas = new Vector<>();

    // ================================================================== 
    // ========================== Métodos ===============================
    /**
     * Muestra un mensaje de confirmación de salida y en caso afirmativo cierra
     * la ventana actual y muestra la pantalla de ingreso.
     */
    public static void cerrarSesion() {
        Toolkit.getDefaultToolkit().beep();
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Desea cerrar sesión?",
                "¿Realmente desea salir?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (JOptionPane.YES_OPTION == respuesta) {
            JFrPrincipal.getJFrPrincipal().dispose();
            JFrLogin.getJFrLogin().setVisible(true);
            JPaLogin.getJPaLogin().getTxtContrasenia().requestFocus();
        }
    }

    /**
     * Elimina el archivo ubicado en la url recibida.
     *
     * @param urlArchivo ubicación del archivo a eliminar.
     */
    public static void eliminarArchivo(String urlArchivo) {
        try {
            File archivo = new File(urlArchivo);
            archivo.delete();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocurrió un error al eliminar el archivo",
                    "¡Alerta!",
                    JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(
                    null,
                    "Ocurrió un error al intentar ocultar el archivo",
                    "¡Alerta!",
                    JOptionPane.ERROR_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Rellena el Vector con las columnas de la cabecera de la tabla
     */
    private static void llenarCabecera() {
        if (columnas.isEmpty()) {
            columnas.add("Sitio Web");
            columnas.add("Nombre de Usuario");
            columnas.add("Contraseña");
            columnas.add("Fecha de Creación");
        }
    }

    /**
     * Obtiene la información contenida en el archivo.
     */
    private static void leerArchivoContenedor() {
        File archivo = null;
        BufferedReader buffered = null;
        FileReader lector = null;
        try {
            String linea;
            archivo = new File(".\\Requeridos\\" + Globales.Variables.getNOMBRE_ARCHIVO());
            lector = new FileReader(archivo);
            buffered = new BufferedReader(lector);
            datos.clear();
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

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocurrió un error al intentar leer el archivo",
                    "¡Alerta!",
                    JOptionPane.ERROR_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        } finally {
            try {
                if (null != lector) {
                    lector.close();
                }
            } catch (IOException e2) {
                JOptionPane.showMessageDialog(
                        null,
                        "Ocurrió un error al intentar cerrar el archivo",
                        "¡Alerta!",
                        JOptionPane.ERROR_MESSAGE);
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    /**
     * Rellena la tabla con los datos contenidos en el archivo.
     *
     * @param tabla JTable a rellenar con la información.
     * @param jlbTotalRegistros Label para mostrar el total de registros de la
     * tabla.
     */
    public static void rellenarTabla(JTable tabla, JLabel jlbTotalRegistros) {
        leerArchivoContenedor();
        llenarCabecera();
        tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        // <-- Para evitar que se editen los valores -->
        tabla.setDefaultEditor(Object.class, null);
        jlbTotalRegistros.setText("Mostrando un total de: " + tabla.getModel().getRowCount() + " registros.");
        if (esBusqueda) {
            JPaPrincipal.getJPaPrincipal().getTxtBusqueda().setText("");
            JPaPrincipal.getJPaPrincipal().getTxtBusqueda().requestFocus();
            JPaPrincipal.getJPaPrincipal().getJlbError().setText("");
            if (JPaPrincipal.getJPaPrincipal().getBtnLimpiar().isVisible()) {
                JPaPrincipal.getJPaPrincipal().getBtnLimpiar().setVisible(false);
            }
        }
    }

    /**
     * Establece el formato estético del menú del clic derecho.
     *
     * @param itemAFormatear JMenuItem a modificar.
     * @param listener Listener activo a agregar al item.
     * @param nombreIcono Nombre del icono del item.
     */
    public static void formatearItem(JMenuItem itemAFormatear, ActionListener listener, String nombreIcono) {
        try {
            Image imagen = ImageIO.read(new File("./src/Recursos/Iconos/menu_" + nombreIcono + ".png"));
            Icon icono = new ImageIcon(imagen);
            Integer distanciaTexto = 2;
            Font fuente = new Font("Tahoma", Font.PLAIN, 14);
            Insets margen = new Insets(1, 6, 1, 5);
            itemAFormatear.setMargin(margen);
            itemAFormatear.addActionListener(listener);
            itemAFormatear.setForeground(Color.BLACK);
            itemAFormatear.setIcon(icono);
            itemAFormatear.setIconTextGap(distanciaTexto);
            itemAFormatear.setFont(fuente);
            itemAFormatear.setPreferredSize(new Dimension(190, 30));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocurrió un error al establecer el estilo \n del menú contextual",
                    "¡Alerta!",
                    JOptionPane.ERROR_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Busca dentro de los valores registrados el parámetro recibido
     *
     * @param valorABuscar valor a buscar dentro de los valores registrados
     * @param tabla tabla a mostrar con los valores obtenidos.
     * @param jlbError label para mostrar los errores.
     * @param btnLimpiar botón para restablecer la tabla.
     * @param jlbTotalRegistros label para mostrar el total de registros.
     */
    public static void buscarValor(String valorABuscar, JTable tabla, JLabel jlbError, JButton btnLimpiar, JLabel jlbTotalRegistros) {
        int elementoVacio = 0;
        llenarCabecera();

        jlbError.setForeground(new Color(204, 0, 51));
        if (datos.isEmpty() || null == datos || datos.size() == elementoVacio) {
            Toolkit.getDefaultToolkit().beep();
            jlbError.setText("¡No se encuentran registros en el sistema!");
            restablecerTabla(tabla, columnas, btnLimpiar);
        } else {

            jlbError.setText("");
            if (valorABuscar.trim().equalsIgnoreCase("") || valorABuscar.isEmpty()) {
                Toolkit.getDefaultToolkit().beep();
                jlbError.setText("¡El campo de búsqueda está vacío!");
                restablecerTabla(tabla, columnas, btnLimpiar);
            } else {

                jlbError.setText("");
                Vector<Vector> datosEncontrados = new Vector();
                for (Vector dato : datos) {
                    if (dato.contains(valorABuscar)) {
                        datosEncontrados.add(dato);
                    }
                }

                if (datosEncontrados.size() > elementoVacio) {
                    jlbError.setForeground(new Color(0, 102, 51));
                    jlbError.setText("Búsqueda realizada con éxito, se encontraron: " + datosEncontrados.size() + " elementos.");
                    btnLimpiar.setVisible(true);
                    esBusqueda = true;
                    tabla.setModel(new javax.swing.table.DefaultTableModel(datosEncontrados, columnas));
                    // <-- Para evitar que se editen los valores -->
                    tabla.setDefaultEditor(Object.class, null);
                    jlbTotalRegistros.setText("Mostrando un total de: " + tabla.getModel().getRowCount() + " registros.");
                } else {

                    Toolkit.getDefaultToolkit().beep();
                    jlbError.setText("¡No se encuentra el elemento \"" + valorABuscar + "\" en los registros!");
                    restablecerTabla(tabla, columnas, btnLimpiar);
                }
            }
        }
    }

    /**
     * Restablece los valores de la tabla recibida a su estado inicial.
     *
     * @param tabla Tabla a restablecer
     * @param columnas Cabeceras de la tabla
     * @param btnLimpiar botón para restablecer la tabla.
     */
    private static void restablecerTabla(JTable tabla, Vector<String> columnas, JButton btnLimpiar) {
        tabla.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        // <-- Para evitar que se editen los valores -->
        tabla.setDefaultEditor(Object.class, null);
        btnLimpiar.setVisible(false);
        JPaPrincipal.getJPaPrincipal().getTxtBusqueda().requestFocus();
        JPaPrincipal.getJPaPrincipal().getJlbTotalRegistros().setText("Mostrando un total de: " + tabla.getModel().getRowCount() + " registros.");
        esBusqueda = false;
    }

    /**
     * Restablece los valores de la tabla a su estado inicial. Nota: Este método
     * es para acceder de manera externa.
     *
     * @param tabla Tabla a restablecer.
     * @param btnLimpiar Botón para restablecer la tabla.
     * @param jlbError Label con los mensajes de error
     */
    public static void restablecerTabla(JTable tabla, JButton btnLimpiar, JLabel jlbError) {
        llenarCabecera();
        restablecerTabla(tabla, columnas, btnLimpiar);
        jlbError.setText("");
        JPaPrincipal.getJPaPrincipal().getTxtBusqueda().setText("");
    }

    /**
     * Copia el elemeto seleccionado al portapapeles de windows
     *
     * @param tabPrincipal Tabla de la cual se obtendrá el elemento.
     * @param posicionACopiar Posicion de la fila a copiar.
     */
    public static void copiarAlPortapapeles(RSTableMetro tabPrincipal, int posicionACopiar) {
        int copiarTodo = -1;

        int filaSeleccionada = tabPrincipal.getSelectedRow();
        if (posicionACopiar == copiarTodo) {
            String valores = "";
            valores += tabPrincipal.getModel().getValueAt(filaSeleccionada, 0);
            valores += " - " + tabPrincipal.getModel().getValueAt(filaSeleccionada, 1);
            valores += " - " + tabPrincipal.getModel().getValueAt(filaSeleccionada, 2);
            valores += " - " + tabPrincipal.getModel().getValueAt(filaSeleccionada, 3);

            Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(
                            new StringSelection(valores),
                            null
                    );
        } else {
            Object valor = tabPrincipal.getModel().getValueAt(filaSeleccionada, posicionACopiar);
            Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(
                            new StringSelection((String) valor),
                            null
                    );
        }

        Toolkit.getDefaultToolkit().beep();
    }

    /**
     * Modifica la fila seleccionada en la tabla
     *
     * @param tabPrincipal Tabla de la cual se obtendrá el elemento.
     * @param parent JFrame padre para la ventana emergente.
     */
    public static void editarElemento(RSTableMetro tabPrincipal, JFrame parent) {
        JPaNuevo panelNuevo = JPaNuevo.getJPaNuevo();
        int filaSeleccionada = tabPrincipal.getSelectedRow();
        leerArchivoContenedor();
        JPaNuevo.setEsExistente(false);
        JPaNuevo.setEsEdicion(true);
        Vector<String> valoresAEditar = new Vector<>();
        String sitioWeb = String.valueOf(tabPrincipal.getModel().getValueAt(filaSeleccionada, 0));
        String usuario = String.valueOf(tabPrincipal.getModel().getValueAt(filaSeleccionada, 1));
        String contrasenia = String.valueOf(tabPrincipal.getModel().getValueAt(filaSeleccionada, 2));
        valoresAEditar.add(sitioWeb);
        valoresAEditar.add(usuario);
        valoresAEditar.add(contrasenia);
        valoresAEditar.add(String.valueOf(tabPrincipal.getModel().getValueAt(filaSeleccionada, 3)));

        JPaNuevo.setValoresAEditar(valoresAEditar);

        JDiGeneral.setEsEdicion(true);
        JDiGeneral.setEsExistente(false);

        panelNuevo.getTxtSitioWeb().setText(sitioWeb);
        panelNuevo.getTxtUsuario().setText(usuario);
        panelNuevo.getTxtContrasenia().setText(contrasenia);
        JDiGeneral.setContraseniaEdicion(contrasenia);

        JDiGeneral.getJDiGeneral(parent).setTitle("Editar Contraseña - " + Globales.Variables.getTITULO());
        JDiGeneral.getJDiGeneral(parent).setVisible(true);
    }

    /**
     * Elimina la fila seleccionada en la tabla
     *
     * @param tabPrincipal Tabla de la cual se obtendrá el elemento.
     */
    public static void eliminarElemento(RSTableMetro tabPrincipal) {
        Toolkit.getDefaultToolkit().beep();
        int filaSeleccionada = tabPrincipal.getSelectedRow();
        String sitioWeb = String.valueOf(tabPrincipal.getModel().getValueAt(filaSeleccionada, 0));
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Desea eliminar el registro del sitio: \n \"" + sitioWeb + "\"?",
                "Esta acción no se puede deshacer",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (JOptionPane.YES_OPTION == respuesta) {
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
                int indice = Registro.obtenerIndiceVector(datos, generarVectorAEliminar(tabPrincipal));
                if (indice != indiceVacio) {
                    datos.removeElementAt(indice);
                    try (FileWriter escritor = new FileWriter(archivo, true)) {
                        for (Vector<String> dato : datos) {
                            escritor.write(
                                    Globales.Metodos.cifrar(dato.get(0)) + " "
                                    + Globales.Metodos.cifrar(dato.get(1)) + " "
                                    + Globales.Metodos.cifrar(dato.get(2)) + " "
                                    + dato.get(3)
                                    + "\n"
                            );
                        }
                        escritor.close();
                        JOptionPane.showMessageDialog(
                                null,
                                "¡Elemento eliminado con éxito del registro!",
                                "Tarea realizada con éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                        rellenarTabla(tabPrincipal, JPaPrincipal.getJPaPrincipal().getJlbTotalRegistros());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Ocurrió un error al guardar los registros\n " + e.getMessage(),
                                "Advertencia",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    /**
     * Genera la Colección necesaria a partir del elemento seleccionado en la
     * tabla.
     *
     * @param tabPrincipal Tabla de la cual obtendrá el elemento seleccionado.
     */
    public static Vector<String> generarVectorAEliminar(RSTableMetro tabPrincipal) {
        int filaSeleccionada = tabPrincipal.getSelectedRow();
        Vector<String> valoresAEditar = new Vector<>();
        String sitioWeb = String.valueOf(tabPrincipal.getModel().getValueAt(filaSeleccionada, 0));
        String usuario = String.valueOf(tabPrincipal.getModel().getValueAt(filaSeleccionada, 1));
        String contrasenia = String.valueOf(tabPrincipal.getModel().getValueAt(filaSeleccionada, 2));
        valoresAEditar.add(sitioWeb);
        valoresAEditar.add(usuario);
        valoresAEditar.add(contrasenia);
        valoresAEditar.add(String.valueOf(tabPrincipal.getModel().getValueAt(filaSeleccionada, 3)));

        return valoresAEditar;
    }

    //**** Getters ****
    public static Vector<Vector> getDatos() {
        return datos;
    }

}
