package Globales;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author Carlos Daniel
 */
public class Variables {

// ========================== Variables =============================
    private static final String TITULO = "Password Control";
    private static final Image ICONO = new ImageIcon(("./src/Recursos/Iconos/key.png")).getImage();
    private static final Image LOGO = new ImageIcon(("./src/Recursos/Logos/Logo.png")).getImage();

    private static final String USUARIO = "Carlos Valerio";
    private static final String CONTRASENIA = "14d1b6b35e634742a41b3cb660059e07ed47eb3e3645d8bb1a3a2aaa6adbcda4";
    private static final String NOMBRE_ARCHIVO = "Datos_" + Globales.Variables.getTITULO().replace(" ", "_") + ".dll";

    private static final Color COLOR_AZUL = new Color(0, 41, 57);
    private static final Color COLOR_AZUL_CIELO = new Color(67, 150, 209);
// ==================================================================

// ========================== Métodos ===============================
    public static String getTITULO() {
        return TITULO;
    }

    public static Image getICONO() {
        return ICONO;
    }

    public static Image getLOGO() {
        return LOGO;
    }

    public static String getUSUARIO() {
        return USUARIO;
    }

    public static String getCONTRASENIA() {
        return CONTRASENIA;
    }

    public static String getNOMBRE_ARCHIVO() {
        return NOMBRE_ARCHIVO;
    }

    public static Color getCOLOR_AZUL() {
        return COLOR_AZUL;
    }

    public static Color getCOLOR_AZUL_CIELO() {
        return COLOR_AZUL_CIELO;
    }
}
