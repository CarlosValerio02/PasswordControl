package Controladores;

import IU.JFrLogin;
import IU.JFrPrincipal;
import IU.Paneles.JPaLogin;
import java.awt.Toolkit;
import java.util.Arrays;
import javax.swing.JLabel;

/**
 * @author Carlos Daniel
 */
public class Ingreso {

// ========================== Métodos ===============================
    /**
     * Rellena los campos de ingreso con la información requerida.
     *
     * @param jPanel Panel del cual obtendrá los elementos con los que trabajará
     * el método.
     */
    public static void rellenarCampos(JPaLogin jPanel) {
        jPanel.getJlbError().setVisible(false);
        jPanel.getTxtUsuario().setText(Globales.Variables.getUSUARIO());
    }

    /**
     * Comprueba que los campos contengan algún valor.
     *
     * @param jPanel Panel del cual obtendrá los elementos con los que trabajará
     * el método.
     */
    public static void comprobarCampos(JPaLogin jPanel) {
        JLabel jlbError = jPanel.getJlbError();
        try {
            String contrasenia = Arrays.toString(jPanel.getTxtContrasenia().getPassword()).replace("[", "").replace("]", "");
            if (contrasenia.length() == 0 || "".equals(contrasenia) || null == contrasenia) {
                jlbError.setText("¡El campo contraseña está vacío!");
                jlbError.setVisible(true);
                jPanel.getTxtContrasenia().requestFocus();
                Toolkit.getDefaultToolkit().beep();
            } else {
                jlbError.setVisible(false);
                if (comprobarContrasenia(contrasenia)) {
                    Globales.Metodos.comprobarArchivo();
                    Principal.ocultarArchivo(".\\Requeridos\\", Globales.Variables.getNOMBRE_ARCHIVO());
                    jlbError.setVisible(false);
                    jPanel.getTxtContrasenia().setText("");
                    JFrLogin.getJFrLogin().dispose();
                    JFrPrincipal.getJFrPrincipal().setVisible(true);
                } else {
                    jlbError.setText("¡Contraseña incorrecta!");
                    jlbError.setVisible(true);
                    jPanel.getTxtContrasenia().requestFocus();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        } catch (NullPointerException ex) {
            jlbError.setText("¡El campo contraseña está vacío!");
            jlbError.setVisible(true);
            jPanel.getTxtContrasenia().requestFocus();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Comprueba que el valor ingresado sea igual a la contraseña guardada.
     *
     * @param contraseniaAEvaluar Texto que se comparará.
     */
    private static boolean comprobarContrasenia(String contraseniaAEvaluar) {
        String contraseniaConvertida = Globales.Metodos.convertirSHA256(contraseniaAEvaluar);
        return Globales.Variables.getCONTRASENIA().equals(contraseniaConvertida);
    }

}
