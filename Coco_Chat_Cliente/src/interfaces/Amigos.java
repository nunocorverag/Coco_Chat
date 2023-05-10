
package interfaces;

/**
 *
 * @author Nancy
 */
public class Amigos extends javax.swing.JFrame {

    /**
     * Creates new form UsuariosConectados
     */
    public Amigos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    /*
    public Chat(String usuario){
        initComponents();
        this.setLocationRelativeTo(null);
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaAmigosConectados = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaAmigosNoConectados = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        UsuariosMenu = new javax.swing.JMenu();
        AmigosMenu = new javax.swing.JMenu();
        GruposMenu = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(426, 462));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setText("Conectados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weighty = 0.05;
        getContentPane().add(jLabel1, gridBagConstraints);

        ListaAmigosConectados.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ListaAmigosOnline listaAmigosOn = new ListaAmigosOnline();
        String[] amigosOn = listaAmigosOn.obtenerAmigos();
        ListaAmigosConectados.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return amigosOn.length; }
            public String getElementAt(int i) { return amigosOn[i]; }
        });
        ListaAmigosConectados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaAmigosConectadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaAmigosConectados);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        ListaAmigosNoConectados.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ListaAmigosOffline listaAmigosOffline = new ListaAmigosOffline();
        String[] amigosOff = listaAmigosOffline.obtenerAmigos();
        ListaAmigosNoConectados.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return amigosOff.length; }
            public String getElementAt(int i) { return amigosOff[i]; }
        });
        ListaAmigosNoConectados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaAmigosNoConectadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListaAmigosNoConectados);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane2, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel2.setText("Desconectados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weighty = 0.05;
        getContentPane().add(jLabel2, gridBagConstraints);

        UsuariosMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/usuario.png"))); // NOI18N
        UsuariosMenu.setText("Usuarios");
        UsuariosMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuariosMenu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        UsuariosMenu.setIconTextGap(5);
        UsuariosMenu.setMargin(new java.awt.Insets(2, 10, 2, 10));
        UsuariosMenu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                UsuariosMenuMenuSelected(evt);
            }
        });
        jMenuBar1.add(UsuariosMenu);

        AmigosMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/amigos.png"))); // NOI18N
        AmigosMenu.setText("Amigos");
        AmigosMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AmigosMenu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AmigosMenu.setIconTextGap(5);
        AmigosMenu.setMargin(new java.awt.Insets(2, 10, 2, 10));
        AmigosMenu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                AmigosMenuMenuSelected(evt);
            }
        });
        jMenuBar1.add(AmigosMenu);

        GruposMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/grupos.png"))); // NOI18N
        GruposMenu.setText("Grupos");
        GruposMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GruposMenu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        GruposMenu.setIconTextGap(5);
        GruposMenu.setMargin(new java.awt.Insets(2, 10, 2, 10));
        GruposMenu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                GruposMenuMenuSelected(evt);
            }
        });
        jMenuBar1.add(GruposMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public class ListaAmigosOnline{
        private String[] amigosOn;
        
        public ListaAmigosOnline(){
            amigosOn = new String[]{"Marta", "Jose", "Felipe", "Manuel"};
        }
        
        public String[] obtenerAmigos(){
            return amigosOn;
        }
    }
    
    public class ListaAmigosOffline{
        private String[] amigosOff;
        
        public ListaAmigosOffline(){
            amigosOff = new String[]{"Pedro", "Cosa", "kkita", ":P"};
        }
        
        public String[] obtenerAmigos(){
            return amigosOff;
        }
    }
     
    private void UsuariosMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_UsuariosMenuMenuSelected
        Usuarios a = new Usuarios();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_UsuariosMenuMenuSelected

    private void AmigosMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_AmigosMenuMenuSelected
        Amigos a = new Amigos();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AmigosMenuMenuSelected

    private void GruposMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_GruposMenuMenuSelected
        Grupos a = new Grupos();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_GruposMenuMenuSelected

    private void ListaAmigosConectadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaAmigosConectadosMouseClicked
        Chat a = new Chat();
        a.setVisible(true);
    }//GEN-LAST:event_ListaAmigosConectadosMouseClicked

    private void ListaAmigosNoConectadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaAmigosNoConectadosMouseClicked
        Chat a = new Chat();
        a.setVisible(true);
    }//GEN-LAST:event_ListaAmigosNoConectadosMouseClicked

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
            java.util.logging.Logger.getLogger(Amigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Amigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Amigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Amigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Amigos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AmigosMenu;
    private javax.swing.JMenu GruposMenu;
    private javax.swing.JList<String> ListaAmigosConectados;
    private javax.swing.JList<String> ListaAmigosNoConectados;
    private javax.swing.JMenu UsuariosMenu;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
