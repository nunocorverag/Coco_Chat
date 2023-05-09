/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;
import db_conection_package.Usuario;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nancy
 */
public class RegistroSinRecuperarCuenta extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public RegistroSinRecuperarCuenta() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        TextUsuario = new javax.swing.JLabel();
        NameBox = new javax.swing.JTextField();
        passText = new javax.swing.JLabel();
        IngresarButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        TextUsuario1 = new javax.swing.JLabel();
        NameBox1 = new javax.swing.JTextField();
        passText1 = new javax.swing.JLabel();
        IngresarButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ContrasenaRegistro = new javax.swing.JPasswordField();
        TextUsuario2 = new javax.swing.JLabel();
        AnimalRegistro = new javax.swing.JTextField();
        passText2 = new javax.swing.JLabel();
        TextUsuario3 = new javax.swing.JLabel();
        ApellidoMRegistro = new javax.swing.JTextField();
        TextUsuario4 = new javax.swing.JLabel();
        ApellidoPRegistro = new javax.swing.JTextField();
        passText3 = new javax.swing.JLabel();
        IngresarButton3 = new javax.swing.JButton();
        NameBoxRegistro = new javax.swing.JTextField();
        VentanaInicioSesionButton = new javax.swing.JButton();
        passText4 = new javax.swing.JLabel();
        CorreoRegistro = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Registrarse");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Inicio de sesión");

        TextUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TextUsuario.setText("Usuario");

        NameBox.setToolTipText("Nanvy");
        NameBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameBoxActionPerformed(evt);
            }
        });

        passText.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        passText.setText("Contraseña");

        IngresarButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarButton.setText("Ingresar");
        IngresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registrarse");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Inicio de sesión");

        TextUsuario1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TextUsuario1.setText("Usuario");

        NameBox1.setToolTipText("Nanvy");
        NameBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameBox1ActionPerformed(evt);
            }
        });

        passText1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        passText1.setText("Contraseña");

        IngresarButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarButton1.setText("Ingresar");
        IngresarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Registro");

        ContrasenaRegistro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ContrasenaRegistro.setToolTipText("Ingrese la contraseña para su cuenta");

        TextUsuario2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TextUsuario2.setText("Nombre");

        AnimalRegistro.setToolTipText("Ingrese su animal favorito para la prueba de seguridad");
        AnimalRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimalRegistroActionPerformed(evt);
            }
        });

        passText2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        passText2.setText("Contraseña");

        TextUsuario3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TextUsuario3.setText("Apellido materno");

        ApellidoMRegistro.setToolTipText("Ingrese su segundo apellido");
        ApellidoMRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidoMRegistroActionPerformed(evt);
            }
        });

        TextUsuario4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TextUsuario4.setText("Apellido paterno");

        ApellidoPRegistro.setToolTipText("Ingrese su primer apellido");
        ApellidoPRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidoPRegistroActionPerformed(evt);
            }
        });

        passText3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        passText3.setText("¿Cuál es tu animal favorito?");

        IngresarButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        IngresarButton3.setText("Ingresar");
        IngresarButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarButton3ActionPerformed(evt);
            }
        });

        NameBoxRegistro.setToolTipText("Ingrese su primer nombre");
        NameBoxRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameBoxRegistroActionPerformed(evt);
            }
        });

        VentanaInicioSesionButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        VentanaInicioSesionButton.setText("Iniciar sesión");
        VentanaInicioSesionButton.setToolTipText("Lo enviara de regreso a la ventana de inicio de sesión");
        VentanaInicioSesionButton.setActionCommand("");
        VentanaInicioSesionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaInicioSesionButtonActionPerformed(evt);
            }
        });

        passText4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        passText4.setText("Correo");

        CorreoRegistro.setToolTipText("Ingresa tu correo electrónico");
        CorreoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(441, Short.MAX_VALUE)
                        .addComponent(VentanaInicioSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(302, 302, 302))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NameBoxRegistro)
                            .addComponent(TextUsuario2)
                            .addComponent(TextUsuario4)
                            .addComponent(ApellidoPRegistro)
                            .addComponent(TextUsuario3)
                            .addComponent(ApellidoMRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passText3)
                            .addComponent(AnimalRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passText4)
                            .addComponent(CorreoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passText2)
                            .addComponent(ContrasenaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(107, 107, 107))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(435, 435, 435))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(IngresarButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(425, 425, 425))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(passText4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passText3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AnimalRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(CorreoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(passText2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ContrasenaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextUsuario2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NameBoxRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(TextUsuario4)
                        .addGap(12, 12, 12)
                        .addComponent(ApellidoPRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(TextUsuario3)
                        .addGap(8, 8, 8)
                        .addComponent(ApellidoMRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(IngresarButton3)
                .addGap(29, 29, 29)
                .addComponent(VentanaInicioSesionButton)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameBoxActionPerformed

    private void IngresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarButtonActionPerformed
       
    }//GEN-LAST:event_IngresarButtonActionPerformed

    private void NameBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameBox1ActionPerformed

    private void IngresarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarButton1ActionPerformed
        
    }//GEN-LAST:event_IngresarButton1ActionPerformed

    private void AnimalRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimalRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnimalRegistroActionPerformed

    private void ApellidoMRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidoMRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidoMRegistroActionPerformed

    private void ApellidoPRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidoPRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidoPRegistroActionPerformed

    private void IngresarButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarButton3ActionPerformed
        //Jala los datos ingresados en el formulario del registro        
        String nombre = NameBoxRegistro.getText();
        String apellidoM = ApellidoMRegistro.getText(); 
        String apellidoP = ApellidoPRegistro.getText();
        String animal = AnimalRegistro.getText();
        String correo = CorreoRegistro.getText();
        
        char[] obtenerContrasena = ContrasenaRegistro.getPassword();
        String contrasena = new String(obtenerContrasena);
        
        //Genera nombre de usuario
        String usuario = nombre + " " + apellidoM + " " + apellidoP;
        
        //Asigna el objeto usuario con los campos ingresados
        Usuario userRegister = new Usuario(nombre, usuario, contrasena, correo, animal);
        Socket s;
        try {
            String direccionServidor = "10.147.17.147";
            InetAddress direccion = InetAddress.getByName(direccionServidor);
            s = new Socket(direccion, 1234);
            
            ObjectOutputStream salidaObjeto = new ObjectOutputStream(s.getOutputStream());
            salidaObjeto.writeObject(userRegister);
            
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(RegistroSinRecuperarCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        //Muestra en la consola los datos del formulario
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido paterno: " + apellidoP);
        System.out.println("Apellido materno: " + apellidoM);
        System.out.println("Animal favorito: " + animal);   
        System.out.println("Correo: " + correo);
        System.out.println("Contrasena: " + contrasena);
        System.out.println("Usuario: " + usuario);

    }//GEN-LAST:event_IngresarButton3ActionPerformed

    private void NameBoxRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameBoxRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameBoxRegistroActionPerformed

    private void VentanaInicioSesionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentanaInicioSesionButtonActionPerformed
        InicioSesion a = new InicioSesion();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VentanaInicioSesionButtonActionPerformed

    private void CorreoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoRegistroActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CorreoRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroSinRecuperarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroSinRecuperarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroSinRecuperarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroSinRecuperarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroSinRecuperarCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnimalRegistro;
    private javax.swing.JTextField ApellidoMRegistro;
    private javax.swing.JTextField ApellidoPRegistro;
    private javax.swing.JPasswordField ContrasenaRegistro;
    private javax.swing.JTextField CorreoRegistro;
    private javax.swing.JButton IngresarButton;
    private javax.swing.JButton IngresarButton1;
    private javax.swing.JButton IngresarButton3;
    private javax.swing.JTextField NameBox;
    private javax.swing.JTextField NameBox1;
    private javax.swing.JTextField NameBoxRegistro;
    private javax.swing.JLabel TextUsuario;
    private javax.swing.JLabel TextUsuario1;
    private javax.swing.JLabel TextUsuario2;
    private javax.swing.JLabel TextUsuario3;
    private javax.swing.JLabel TextUsuario4;
    private javax.swing.JButton VentanaInicioSesionButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JLabel passText;
    private javax.swing.JLabel passText1;
    private javax.swing.JLabel passText2;
    private javax.swing.JLabel passText3;
    private javax.swing.JLabel passText4;
    // End of variables declaration//GEN-END:variables
}