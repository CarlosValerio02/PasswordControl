package IU.Paneles;

import Controladores.Principal;
import IU.JDiGeneral;
import IU.JFrPrincipal;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import rojerusan.RSPopuMenu;

/**
 * @author Carlos Daniel
 */
public class JPaPrincipal extends javax.swing.JPanel implements ActionListener {

    // ========================== Variables =============================
    private static JPaPrincipal jPaPrincipal;
    RSPopuMenu popupMenu = new RSPopuMenu();
    JMenuItem itemCopiar = new JMenuItem("Copiar Contraseña");

    // ================================================================== 
    // ========================== Métodos =============================
    public static JPaPrincipal getJPaPrincipal() {
        if (jPaPrincipal == null) {
            jPaPrincipal = new JPaPrincipal();
        }
        return jPaPrincipal;
    }

    public JPaPrincipal() {
        initComponents();
        this.jlbBienvenida.setText(Globales.Variables.getUSUARIO() + ", Bienvenido de vuelta!");
        this.btnNuevaContra.requestFocus();
        Principal.rellenarTabla(tabPrincipal);
        itemCopiar.addActionListener(this);
        popupMenu.add(itemCopiar);
        tabPrincipal.setComponentPopupMenu(popupMenu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUpMenu = new rojerusan.RSPopuMenu();
        rSPopuMenu1 = new rojerusan.RSPopuMenu();
        jPaCabecera = new javax.swing.JPanel();
        jlbIcono = new rojerusan.RSLabelImage();
        jlbBienvenida = new javax.swing.JLabel();
        btnCerrarSesion = new rojerusan.RSButtonRound();
        btnNuevaContra = new rojerusan.RSButtonRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPrincipal = new rojerusan.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        popUpMenu.setBackground(new java.awt.Color(0, 112, 192));
        popUpMenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPaCabecera.setBackground(new java.awt.Color(0, 112, 192));

        jlbIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Usuarios/mexican.png"))); // NOI18N
        jlbIcono.setText("");

        jlbBienvenida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        jlbBienvenida.setText("Mensaje de bienvenida");

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setNextFocusableComponent(tabPrincipal);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnNuevaContra.setBackground(new java.awt.Color(67, 150, 209));
        btnNuevaContra.setText("Nueva Contraseña");
        btnNuevaContra.setNextFocusableComponent(btnCerrarSesion);
        btnNuevaContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaContraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaCabeceraLayout = new javax.swing.GroupLayout(jPaCabecera);
        jPaCabecera.setLayout(jPaCabeceraLayout);
        jPaCabeceraLayout.setHorizontalGroup(
            jPaCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlbBienvenida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevaContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPaCabeceraLayout.setVerticalGroup(
            jPaCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaCabeceraLayout.createSequentialGroup()
                .addGroup(jPaCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaCabeceraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPaCabeceraLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPaCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbBienvenida)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevaContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);

        tabPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Titulo 1", "Titulo 2", "Titulo 3", "Titulo 4", "Titulo 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabPrincipal.setMultipleSeleccion(false);
        tabPrincipal.setRowHeight(30);
        tabPrincipal.setSelectionBackground(new java.awt.Color(67, 150, 209));
        tabPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPrincipalMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabPrincipalMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabPrincipal);
        if (tabPrincipal.getColumnModel().getColumnCount() > 0) {
            tabPrincipal.getColumnModel().getColumn(0).setResizable(false);
            tabPrincipal.getColumnModel().getColumn(1).setResizable(false);
            tabPrincipal.getColumnModel().getColumn(2).setResizable(false);
            tabPrincipal.getColumnModel().getColumn(3).setResizable(false);
            tabPrincipal.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Contraseñas Registradas en el sistema");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel3.setText("por Carlos Valerio");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 0));
        jLabel2.setText("♥");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel4.setText("Desarrollado con ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPaCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Controladores.Principal.cerrarSesion();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnNuevaContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaContraActionPerformed
        JDiGeneral.getJDiGeneral(JFrPrincipal.getJFrPrincipal()).setVisible(true);
        Principal.rellenarTabla(tabPrincipal);
    }//GEN-LAST:event_btnNuevaContraActionPerformed

    private void tabPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPrincipalMouseClicked

    }//GEN-LAST:event_tabPrincipalMouseClicked

    private void tabPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPrincipalMousePressed
        Point punto = evt.getPoint();
        int filaActual = tabPrincipal.rowAtPoint(punto);
        tabPrincipal.setRowSelectionInterval(filaActual, filaActual);
    }//GEN-LAST:event_tabPrincipalMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonRound btnCerrarSesion;
    private rojerusan.RSButtonRound btnNuevaContra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPaCabecera;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbBienvenida;
    private rojerusan.RSLabelImage jlbIcono;
    private rojerusan.RSPopuMenu popUpMenu;
    private rojerusan.RSPopuMenu rSPopuMenu1;
    private rojerusan.RSTableMetro tabPrincipal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menu = (JMenuItem) e.getSource();
        if (menu == itemCopiar) {
            int filaSeleccionada = tabPrincipal.getSelectedRow();
            Object valor = tabPrincipal.getModel().getValueAt(filaSeleccionada, 2);
            Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(
                        new StringSelection((String) valor),
                        null
            );
        }
    }
}
