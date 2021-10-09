package Globales;

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

    private static final String USUARIO = "Carlos Daniel";
    private static final String CONTRASENIA = "6208aed8610c53c960e3e99ac96bdb790059292750cdc7460076456dba6a8bb8";
    private static final String NOMBRE_ARCHIVO = "Datos_" + Globales.Variables.getTITULO().replace(" ", "_") + ".txt";
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
    
    
}
