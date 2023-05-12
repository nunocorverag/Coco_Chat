/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import db_conection_package.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import returned_models.InfoSolicitudAmistad;
import user_session.SessionManager;

/**
 *
 * @author Nancy
 */
public class SolicitudesAmistad extends javax.swing.JFrame {

    /**
     * Creates new form AgregarAmigos
     */
    public SolicitudesAmistad() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        Socket s;      
                        try {
                            String direccionServidor = "10.147.17.147";
                            InetAddress direccion = InetAddress.getByName(direccionServidor);
                            s = new Socket(direccion, 1234);
                            
                            DataOutputStream funcion = new DataOutputStream(s.getOutputStream());
                            funcion.writeUTF("cerrar_sesion");
                            
                            String username = SessionManager.getUsername();
                            DataOutputStream objectOS = new DataOutputStream(s.getOutputStream());
                            objectOS.writeUTF(username);
                           
                            s.close();
                        } catch (IOException ex) {
                            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaUsuarios = new javax.swing.JList<>();
        AceptarSolicitudButton = new javax.swing.JButton();
        RechazarSolicitudButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setText("Solicitudes de amistad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weighty = 0.05;
        getContentPane().add(jLabel1, gridBagConstraints);

        ListaUsuarios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ListaSolicitudes SoliList = new ListaSolicitudes();
        ArrayList<InfoSolicitudAmistad> sol = SoliList.obtenerAmigos();

        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for(InfoSolicitudAmistad amigo: sol)
        {
            modeloLista.addElement(amigo.remitente_solicitud_amistad);
        }
        ListaUsuarios.setModel(modeloLista);
        ListaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaUsuarios);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        AceptarSolicitudButton.setText("Aceptar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        getContentPane().add(AceptarSolicitudButton, gridBagConstraints);

        RechazarSolicitudButton.setText("Rechazar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 50);
        getContentPane().add(RechazarSolicitudButton, gridBagConstraints);

        jMenuBar1.setToolTipText("k");
        jMenuBar1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(30, 30));

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/PaAtras.png"))); // NOI18N
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu2MenuSelected(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public class ListaSolicitudes{
        private ArrayList<InfoSolicitudAmistad> Amigos;
        
        public ListaSolicitudes()
        {
            this.Amigos = new ArrayList<InfoSolicitudAmistad>();
            
            Socket s;
            try {
                    String direccionServidor = "10.147.17.147";
                    InetAddress direccion = InetAddress.getByName(direccionServidor);
                    s = new Socket(direccion, 1234);
                    
                    DataOutputStream funcion = new DataOutputStream(s.getOutputStream());
                    funcion.writeUTF("ver_solicitudes_amistad");
                    
                    String UserLogged = SessionManager.getUsername();
                    DataOutputStream mandarUsername = new DataOutputStream(s.getOutputStream());
                    mandarUsername.writeUTF(UserLogged);
                    
                    System.out.println("Se mando el user: " + UserLogged);
                    
                    ObjectInputStream SoliObject = new ObjectInputStream(s.getInputStream());
                    
                    try {
                        ArrayList<InfoSolicitudAmistad> Solicitudes = (ArrayList<InfoSolicitudAmistad>)SoliObject.readObject();
                        s.close();
                        for(InfoSolicitudAmistad soli: Solicitudes)
                        {
                            this.Amigos.add(soli);
                            System.out.println(soli.remitente_solicitud_amistad);
                        }
                  
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            catch (IOException ex) 
            {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public ArrayList<InfoSolicitudAmistad> obtenerAmigos()
        {
            return this.Amigos;
        }
    }
    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        Amigos a = new Amigos();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu2MenuSelected

    private void ListaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaUsuariosMouseClicked
        String nombreSeleccionado = ListaUsuarios.getSelectedValue();
        
    }//GEN-LAST:event_ListaUsuariosMouseClicked

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
            java.util.logging.Logger.getLogger(SolicitudesAmistad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitudesAmistad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitudesAmistad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitudesAmistad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitudesAmistad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarSolicitudButton;
    private javax.swing.JList<String> ListaUsuarios;
    private javax.swing.JButton RechazarSolicitudButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
