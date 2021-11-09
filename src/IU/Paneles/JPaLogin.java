package IU.Paneles;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import rojeru_san.RSMPassView;
import rojeru_san.RSMTextFull;

/**
 * @author Carlos Daniel
 */
public class JPaLogin extends javax.swing.JPanel {

    // ========================== Variables =============================
    private static JPaLogin jPaLogin;
    // ================================================================== 

    // ========================== Métodos =============================
    public static JPaLogin getJPaLogin() {
        if (jPaLogin == null) {
            jPaLogin = new JPaLogin();
        }
        return jPaLogin;
    }

    private JPaLogin() {
        initComponents();
        this.jlbError.setVisible(false);
    }

    public JLabel getJlbError() {
        return jlbError;
    }

    public RSMPassView getTxtContrasenia() {
        return txtContrasenia;
    }

    public RSMTextFull getTxtUsuario() {
        return txtUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIngresar = new rojerusan.RSButtonRound();
        jlbIconoUsuario = new rojerusan.RSLabelCircleImage();
        jlbError = new javax.swing.JLabel();
        txtUsuario = new rojeru_san.RSMTextFull();
        txtContrasenia = new rojeru_san.RSMPassView();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 248, 248));

        btnIngresar.setBackground(new java.awt.Color(0, 41, 57));
        btnIngresar.setText("Ingresar");
        btnIngresar.setNextFocusableComponent(txtContrasenia);
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jlbIconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Usuarios/mexican.png"))); // NOI18N

        jlbError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbError.setForeground(new java.awt.Color(204, 0, 51));
        jlbError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbError.setText("Mensaje de error");
        jlbError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtUsuario.setEditable(false);
        txtUsuario.setBordeColorFocus(new java.awt.Color(0, 41, 57));
        txtUsuario.setBotonColor(new java.awt.Color(0, 41, 57));
        txtUsuario.setFocusable(false);
        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsuario.setMargin(new java.awt.Insets(3, 15, 3, 15));
        txtUsuario.setPlaceholder("Usuario");
        txtUsuario.setSoloLetras(true);

        txtContrasenia.setBordeColorFocus(new java.awt.Color(0, 41, 57));
        txtContrasenia.setBordeColorNoFocus(new java.awt.Color(255, 255, 255));
        txtContrasenia.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtContrasenia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtContrasenia.setMargin(new java.awt.Insets(3, 15, 3, 15));
        txtContrasenia.setNextFocusableComponent(btnIngresar);
        txtContrasenia.setPlaceholder("Contraseña");
        txtContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel1.setText("Desarrollado con ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("♥");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel3.setText(" por Carlos Valerio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbIconoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jlbIconoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jlbError, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Controladores.Ingreso.comprobarCampos(jPaLogin);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        Controladores.Ingreso.comprobarCampos(jPaLogin);
    }//GEN-LAST:event_btnIngresarMouseClicked

    private void txtContraseniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Controladores.Ingreso.comprobarCampos(jPaLogin);
        }
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            this.txtContrasenia.setText("");
        }
    }//GEN-LAST:event_txtContraseniaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonRound btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jlbError;
    private rojerusan.RSLabelCircleImage jlbIconoUsuario;
    private rojeru_san.RSMPassView txtContrasenia;
    private rojeru_san.RSMTextFull txtUsuario;
    // End of variables declaration//GEN-END:variables
}
