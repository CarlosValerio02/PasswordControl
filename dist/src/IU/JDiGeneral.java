package IU;

import Controladores.Registro;
import IU.Paneles.JPaNuevo;
import javax.swing.JFrame;

/**
 * @author Carlos Daniel
 */
public class JDiGeneral extends javax.swing.JDialog {

    // ========================== Variables =============================
    private static JDiGeneral jDiGeneral;
    private static boolean esExistente = false;
    private static boolean esEdicion = false;
    private static String contraseniaEdicion = "";

    // ==================================================================   
    // ========================== Métodos =============================
    public static JDiGeneral getJDiGeneral(JFrame parent) {
        if (jDiGeneral == null) {
            jDiGeneral = new JDiGeneral(parent, true);
        }
        JPaNuevo panelContenido = JPaNuevo.getJPaNuevo(jDiGeneral);
        if (!esEdicion) {
            JPaNuevo.setEsEdicion(false);
            panelContenido.getTxtContrasenia().setText(Registro.generarContrasenia());
            contraseniaEdicion = "";
        } else {
            JPaNuevo.setEsEdicion(true);
            panelContenido.getTxtContrasenia().setText(contraseniaEdicion);
            panelContenido.getTxtContrasenia().setEditable(true);

        }

        Globales.Metodos.agregarPanel(jPaContenedor, panelContenido);
        return jDiGeneral;
    }

    private JDiGeneral(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Nueva Contraseña - " + Globales.Variables.getTITULO());
        this.setIconImage(Globales.Variables.getICONO());
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPaContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(370, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout jPaContenedorLayout = new javax.swing.GroupLayout(jPaContenedor);
        jPaContenedor.setLayout(jPaContenedorLayout);
        jPaContenedorLayout.setHorizontalGroup(
            jPaContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );
        jPaContenedorLayout.setVerticalGroup(
            jPaContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(jPaContenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JPaNuevo panelContenido = JPaNuevo.getJPaNuevo(jDiGeneral);
        panelContenido.getTxtSitioWeb().setText("");
        panelContenido.getTxtUsuario().setText("");
        panelContenido.getCbxExistente().setSelected(false);
        panelContenido.getTxtContrasenia().setText("");
        panelContenido.getJlbError().setText("");
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDiGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDiGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDiGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDiGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDiGeneral dialog = new JDiGeneral(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    //<--- Getters && Setters --->
    public static boolean isEsExistente() {
        return esExistente;
    }

    public static boolean isEsEdicion() {
        return esEdicion;
    }

    public static void setEsExistente(boolean esExistente) {
        JDiGeneral.esExistente = esExistente;
    }

    public static void setEsEdicion(boolean esEdicion) {
        JDiGeneral.esEdicion = esEdicion;
    }

    public static String getContraseniaEdicion() {
        return contraseniaEdicion;
    }

    public static void setContraseniaEdicion(String contraseniaEdicion) {
        JDiGeneral.contraseniaEdicion = contraseniaEdicion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel jPaContenedor;
    // End of variables declaration//GEN-END:variables
}
