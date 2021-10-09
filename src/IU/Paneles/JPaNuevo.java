package IU.Paneles;

import Controladores.Registro;
import IU.JDiGeneral;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import rojeru_san.RSMPassView;
import rojeru_san.RSMTextFull;

/**
 * @author Carlos Daniel
 */
public class JPaNuevo extends javax.swing.JPanel {

    // ========================== Variables =============================
    private static JPaNuevo jPaNuevo;
    private static JDiGeneral jDiGeneral;
    // ==================================================================   

// ========================== Métodos =============================
    public static JPaNuevo getJPaNuevo(JDiGeneral _jDiGeneral) {
        if (jPaNuevo == null) {
            jPaNuevo = new JPaNuevo();
        }
        jDiGeneral = _jDiGeneral;
        txtContrasenia.setText(Registro.generarContrasenia());
        return jPaNuevo;
    }

    private JPaNuevo() {
        initComponents();
        this.txtSitioWeb.requestFocus();
        this.jlbError.setVisible(false);
        txtContrasenia.setText(Registro.generarContrasenia());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new rojerusan.RSButtonRound();
        txtSitioWeb = new rojeru_san.RSMTextFull();
        btnCancelar = new rojerusan.RSButtonRound();
        jlbTitulo = new javax.swing.JLabel();
        jlbSitioWeb = new javax.swing.JLabel();
        txtUsuario = new rojeru_san.RSMTextFull();
        jlbUsuario = new javax.swing.JLabel();
        jlbContrasenia = new javax.swing.JLabel();
        txtContrasenia = new rojeru_san.RSMPassView();
        jlbError = new javax.swing.JLabel();
        jlbCopiar = new rojerusan.RSLabelImage();

        btnRegistrar.setText("Registrar");
        btnRegistrar.setNextFocusableComponent(txtSitioWeb);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtSitioWeb.setNextFocusableComponent(txtUsuario);
        txtSitioWeb.setPlaceholder("Ej. www.google.com");
        txtSitioWeb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSitioWebKeyPressed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(67, 150, 209));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(0, 112, 192));
        btnCancelar.setNextFocusableComponent(btnRegistrar);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jlbTitulo.setBackground(new java.awt.Color(0, 112, 192));
        jlbTitulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTitulo.setText("Registrar Contraseña");
        jlbTitulo.setToolTipText("");
        jlbTitulo.setOpaque(true);

        jlbSitioWeb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbSitioWeb.setText("Sitio Web:");
        jlbSitioWeb.setFocusable(false);

        txtUsuario.setNextFocusableComponent(jlbCopiar);
        txtUsuario.setPlaceholder("Ej. correo@correo.com");
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        jlbUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbUsuario.setText("Nombre de Usuario:");
        jlbUsuario.setFocusable(false);

        jlbContrasenia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbContrasenia.setText("Contraseña:");
        jlbContrasenia.setFocusable(false);

        txtContrasenia.setEditable(false);
        txtContrasenia.setNextFocusableComponent(btnCancelar);
        txtContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyPressed(evt);
            }
        });

        jlbError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbError.setForeground(new java.awt.Color(204, 0, 51));
        jlbError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbError.setText("Campo de error");

        jlbCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Iconos/copy.png"))); // NOI18N
        jlbCopiar.setToolTipText("Copiar al portapapeles");
        jlbCopiar.setNextFocusableComponent(btnCancelar);
        jlbCopiar.setPreferredSize(new java.awt.Dimension(30, 30));
        jlbCopiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCopiarMouseClicked(evt);
            }
        });
        jlbCopiar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jlbCopiarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSitioWeb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlbSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jlbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jlbContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlbError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        jDiGeneral.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtSitioWebKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSitioWebKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            this.txtSitioWeb.setText("");
        }
    }//GEN-LAST:event_txtSitioWebKeyPressed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            this.txtUsuario.setText("");
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtContraseniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            this.txtContrasenia.setText("");
        }
    }//GEN-LAST:event_txtContraseniaKeyPressed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String contenido = Registro.comprobarCampos(this);
        if (!"".equals(contenido)) {
            Registro.guardarRegistro(contenido);
            txtSitioWeb.setText("");
            txtUsuario.setText("");
            txtContrasenia.setText("");
            jDiGeneral.dispose();
            JOptionPane.showMessageDialog(null, "¡Elemento guardado con éxito en el registro!", "Tarea realizada con éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jlbCopiarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlbCopiarKeyPressed
        Registro.copiarContraseña(jlbError, txtContrasenia);
    }//GEN-LAST:event_jlbCopiarKeyPressed

    private void jlbCopiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCopiarMouseClicked
        Registro.copiarContraseña(jlbError, txtContrasenia);
    }//GEN-LAST:event_jlbCopiarMouseClicked

    public RSMPassView getTxtContrasenia() {
        return txtContrasenia;
    }

    public RSMTextFull getTxtSitioWeb() {
        return txtSitioWeb;
    }

    public RSMTextFull getTxtUsuario() {
        return txtUsuario;
    }

    public JLabel getJlbError() {
        return jlbError;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonRound btnCancelar;
    private rojerusan.RSButtonRound btnRegistrar;
    private javax.swing.JLabel jlbContrasenia;
    private rojerusan.RSLabelImage jlbCopiar;
    private javax.swing.JLabel jlbError;
    private javax.swing.JLabel jlbSitioWeb;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JLabel jlbUsuario;
    private static rojeru_san.RSMPassView txtContrasenia;
    private rojeru_san.RSMTextFull txtSitioWeb;
    private rojeru_san.RSMTextFull txtUsuario;
    // End of variables declaration//GEN-END:variables
}