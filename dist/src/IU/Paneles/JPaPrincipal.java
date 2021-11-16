package IU.Paneles;

import Controladores.Principal;
import IU.JDiGeneral;
import IU.JFrPrincipal;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import rojeru_san.RSMTextFull;
import rojerusan.RSButtonMetro;
import rojerusan.RSPopuMenu;
import rojerusan.RSTableMetro;

/**
 * @author Carlos Daniel
 */
public class JPaPrincipal extends javax.swing.JPanel implements ActionListener {

    // ========================== Variables =============================
    private static JPaPrincipal jPaPrincipal;
    private static final RSPopuMenu popupMenu = new RSPopuMenu();
    private static final JMenuItem itemCopiarTodo = new JMenuItem("Copiar Todo");
    private static final JMenuItem itemCopiarUsuario = new JMenuItem("Copiar Usuario");
    private static final JMenuItem itemCopiarContra = new JMenuItem("Copiar Contraseña");
    private static final JMenuItem itemEditar = new JMenuItem("Editar");
    private static final JMenuItem itemEliminar = new JMenuItem("Eliminar");
    // ================================================================== 

    // ========================== Métodos =============================
    public static JPaPrincipal getJPaPrincipal() {
        if (jPaPrincipal == null) {
            jPaPrincipal = new JPaPrincipal();
        }
        txtBusqueda.requestFocus();
        return jPaPrincipal;
    }

    public JPaPrincipal() {
        initComponents();
        this.jlbBienvenida.setText("Bienvenido de vuelta, " + Globales.Variables.getUSUARIO() + "!");
        JPaPrincipal.txtBusqueda.requestFocus();
        this.jlbError.setText("");
        this.btnLimpiar.setVisible(false);
        Principal.rellenarTabla(tabPrincipal, jlbTotalRegistros);
        Principal.formatearItem(itemCopiarTodo, this, "copiar");
        Principal.formatearItem(itemCopiarUsuario, this, "usuario");
        Principal.formatearItem(itemCopiarContra, this, "contrasenia");
        Principal.formatearItem(itemEditar, this, "editar");
        Principal.formatearItem(itemEliminar, this, "eliminar");
        popupMenu.add(itemCopiarUsuario);
        popupMenu.add(itemCopiarContra);
        popupMenu.add(itemCopiarTodo);
        popupMenu.add(itemEditar);
        popupMenu.add(itemEliminar);
        tabPrincipal.setComponentPopupMenu(popupMenu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBusqueda = new rojeru_san.RSMTextFull();
        jPaCabecera = new javax.swing.JPanel();
        jlbIcono = new rojerusan.RSLabelImage();
        jlbBienvenida = new javax.swing.JLabel();
        btnCerrarSesion = new rojerusan.RSButtonRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPrincipal = new rojerusan.RSTableMetro();
        jlbInfo3 = new javax.swing.JLabel();
        jlbInfo2 = new javax.swing.JLabel();
        jlbInfo1 = new javax.swing.JLabel();
        btnNuevaContra = new rojerusan.RSButtonRound();
        jlbError = new javax.swing.JLabel();
        btnBuscar = new rojerusan.RSButtonMetro();
        btnLimpiar = new rojerusan.RSButtonMetro();
        jlbTotalRegistros = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 248, 248));

        txtBusqueda.setBackground(new java.awt.Color(248, 248, 248));
        txtBusqueda.setBordeColorFocus(new java.awt.Color(0, 41, 57));
        txtBusqueda.setBotonColor(new java.awt.Color(0, 41, 57));
        txtBusqueda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBusqueda.setMargin(new java.awt.Insets(3, 15, 3, 15));
        txtBusqueda.setModoMaterial(true);
        txtBusqueda.setNextFocusableComponent(btnBuscar);
        txtBusqueda.setPlaceholder("Ingresa un sitio web, usuario o contraseña a buscar");
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
        });

        jPaCabecera.setBackground(new java.awt.Color(0, 41, 57));

        jlbIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Usuarios/mexican.png"))); // NOI18N
        jlbIcono.setText("");

        jlbBienvenida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        jlbBienvenida.setText("Mensaje de bienvenida");

        btnCerrarSesion.setBackground(new java.awt.Color(0, 41, 57));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setNextFocusableComponent(txtBusqueda);
        btnCerrarSesion.setRequestFocusEnabled(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaCabeceraLayout = new javax.swing.GroupLayout(jPaCabecera);
        jPaCabecera.setLayout(jPaCabeceraLayout);
        jPaCabeceraLayout.setHorizontalGroup(
            jPaCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaCabeceraLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlbBienvenida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPaCabeceraLayout.setVerticalGroup(
            jPaCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaCabeceraLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPaCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbBienvenida))
                .addGap(22, 22, 22))
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
        tabPrincipal.setColorBackgoundHead(new java.awt.Color(0, 41, 57));
        tabPrincipal.setColorBordeHead(new java.awt.Color(0, 41, 57));
        tabPrincipal.setFocusable(false);
        tabPrincipal.setMultipleSeleccion(false);
        tabPrincipal.setRowHeight(30);
        tabPrincipal.setSelectionBackground(new java.awt.Color(67, 150, 209));
        tabPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
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

        jlbInfo3.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jlbInfo3.setText(" por Carlos Valerio");

        jlbInfo2.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jlbInfo2.setForeground(new java.awt.Color(204, 51, 0));
        jlbInfo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbInfo2.setText("♥");

        jlbInfo1.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jlbInfo1.setText("Desarrollado con ");

        btnNuevaContra.setBackground(new java.awt.Color(67, 150, 209));
        btnNuevaContra.setText("Nueva Contraseña");
        btnNuevaContra.setColorHover(new java.awt.Color(0, 41, 57));
        btnNuevaContra.setNextFocusableComponent(btnCerrarSesion);
        btnNuevaContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaContraActionPerformed(evt);
            }
        });

        jlbError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbError.setForeground(new java.awt.Color(204, 0, 51));
        jlbError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbError.setText("Campo de error");

        btnBuscar.setBackground(new java.awt.Color(0, 41, 57));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(67, 150, 209));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jlbTotalRegistros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTotalRegistros.setText("Mostrando un total de: registros.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlbInfo1)
                        .addGap(0, 0, 0)
                        .addComponent(jlbInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jlbInfo3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                        .addComponent(btnNuevaContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlbError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlbTotalRegistros)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPaCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btnNuevaContra, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbError, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTotalRegistros)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbInfo1)
                    .addComponent(jlbInfo2)
                    .addComponent(jlbInfo3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Controladores.Principal.cerrarSesion();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnNuevaContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaContraActionPerformed
        JDiGeneral.setEsEdicion(false);
        JDiGeneral.getJDiGeneral(JFrPrincipal.getJFrPrincipal()).setTitle("Nueva Contraseña - " + Globales.Variables.getTITULO());
        JDiGeneral.getJDiGeneral(JFrPrincipal.getJFrPrincipal()).setVisible(true);
        Principal.rellenarTabla(tabPrincipal, jlbTotalRegistros);
    }//GEN-LAST:event_btnNuevaContraActionPerformed

    private void tabPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPrincipalMousePressed
        Point punto = evt.getPoint();
        int filaActual = tabPrincipal.rowAtPoint(punto);
        tabPrincipal.setRowSelectionInterval(filaActual, filaActual);
    }//GEN-LAST:event_tabPrincipalMousePressed

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Principal.buscarValor(txtBusqueda.getText(), tabPrincipal, jlbError, btnLimpiar, jlbTotalRegistros);
        }
    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Principal.buscarValor(txtBusqueda.getText(), tabPrincipal, jlbError, btnLimpiar, jlbTotalRegistros);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Principal.restablecerTabla(tabPrincipal, btnLimpiar, jlbError);
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro btnBuscar;
    private rojerusan.RSButtonRound btnCerrarSesion;
    private rojerusan.RSButtonMetro btnLimpiar;
    private rojerusan.RSButtonRound btnNuevaContra;
    private javax.swing.JPanel jPaCabecera;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbBienvenida;
    private javax.swing.JLabel jlbError;
    private rojerusan.RSLabelImage jlbIcono;
    private javax.swing.JLabel jlbInfo1;
    private javax.swing.JLabel jlbInfo2;
    private javax.swing.JLabel jlbInfo3;
    private javax.swing.JLabel jlbTotalRegistros;
    private rojerusan.RSTableMetro tabPrincipal;
    private static rojeru_san.RSMTextFull txtBusqueda;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menu = (JMenuItem) e.getSource();

        if (menu == itemCopiarTodo) {
            Principal.copiarAlPortapapeles(tabPrincipal, -1);
        }
        if (menu == itemCopiarUsuario) {
            Principal.copiarAlPortapapeles(tabPrincipal, 1);
        }
        if (menu == itemCopiarContra) {
            Principal.copiarAlPortapapeles(tabPrincipal, 2);
        }
        if (menu == itemEditar) {
            Principal.editarElemento(tabPrincipal, JFrPrincipal.getJFrPrincipal());
        }
        if (menu == itemEliminar) {
            Principal.eliminarElemento(tabPrincipal);
        }
    }

    //<---- Getters && Setters -----> 
    public RSMTextFull getTxtBusqueda() {
        return txtBusqueda;
    }

    public RSButtonMetro getBtnLimpiar() {
        return btnLimpiar;
    }

    public JLabel getJlbError() {
        return jlbError;
    }

    public JLabel getJlbTotalRegistros() {
        return jlbTotalRegistros;
    }

    public RSTableMetro getTabPrincipal() {
        return tabPrincipal;
    }
}
