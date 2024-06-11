package com.user.main;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.user.controler.LoginUser;
import com.user.controler.RegisterUser;
import javax.swing.JOptionPane;

public class MainLogin extends javax.swing.JFrame {

      public MainLogin() {
            initComponents();
            txt_username_login.requestFocusInWindow();
            icon.setIcon(new FlatSVGIcon("com/raven/icon/fishing with net-rafiki.svg", icon.getWidth(), icon.getHeight()));
            icon_regist.setIcon(new FlatSVGIcon("com/raven/icon/instagram.svg", icon_regist.getWidth(), icon_regist.getHeight()));
      }
      
      private void btnRegisterOnClick () {
            String nama = txt_nama_regist.getText();
            String username = txt_username_regist.getText();
            String password = String.valueOf(txt_password_regist.getPassword());
            RegisterUser reg = new RegisterUser();

            boolean registrationSuccess = reg.clickRegister(nama, username, password);
            
            if (registrationSuccess) {
                clearFormregister();
                jTabbedPane1.setSelectedIndex(0); // Jika registrasi berhasil, pindah ke tab login
            } else {
                // Jika registrasi gagal, biarkan tetap di tab register
                
            }
      }
      
     private void btnLoginOnClick () {
            String username = txt_username_login.getText();
            char[] passwordChars = txt_password_login.getPassword();
            String password = new String(passwordChars);

            if (username.trim().isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Username & password tidak boleh kosong");
            } else {
                LoginUser lu = new LoginUser();
                boolean loginSuccessful = lu.isLogin(username, password);

                if (loginSuccessful) {
                    dispose(); // Hanya dispose jika login berhasil
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Username atau password salah");
                }
            }
            
     }
     
      private void clearFormregister () {
            txt_nama_regist.setText("");
            txt_username_regist.setText("");
            txt_password_login.setText("");
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jTabbedPane1 = new javax.swing.JTabbedPane();
            login = new javax.swing.JPanel();
            btn_login = new swing.ButtonGradient();
            txt_username_login = new textfield.TextField();
            txt_password_login = new textfield.PasswordField();
            icon = new javax.swing.JLabel();
            register = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            daftar = new javax.swing.JPanel();
            jLabel4 = new javax.swing.JLabel();
            txt_username_regist = new textfield.TextField();
            txt_password_regist = new textfield.PasswordField();
            btn_register = new swing.ButtonGradient();
            txt_nama_regist = new textfield.TextField();
            icon_regist = new javax.swing.JLabel();
            register1 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

            login.setBackground(new java.awt.Color(255, 255, 255));
            login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            btn_login.setText("Login");
            btn_login.setColor1(new java.awt.Color(40, 26, 220));
            btn_login.setColor2(new java.awt.Color(0, 255, 25));
            btn_login.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_loginActionPerformed(evt);
                  }
            });
            login.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 240, 30));

            txt_username_login.setBackground(new java.awt.Color(255, 255, 255));
            txt_username_login.setForeground(new java.awt.Color(97, 103, 122));
            txt_username_login.setLabelText("Username");
            txt_username_login.setLineColor(new java.awt.Color(0, 255, 25));
            login.add(txt_username_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 240, -1));

            txt_password_login.setBackground(new java.awt.Color(255, 255, 255));
            txt_password_login.setForeground(new java.awt.Color(97, 103, 122));
            txt_password_login.setLabelText("Password");
            txt_password_login.setLineColor(new java.awt.Color(0, 255, 25));
            txt_password_login.setShowAndHide(true);
            login.add(txt_password_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 240, -1));
            login.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 310, 330));

            register.setBackground(new java.awt.Color(255, 255, 255));
            register.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
            register.setForeground(new java.awt.Color(40, 26, 220));
            register.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            register.setText("Saya belum punya akun");
            register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            register.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        registerMouseClicked(evt);
                  }
            });
            login.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 130, 20));

            jLabel3.setBackground(new java.awt.Color(255, 255, 255));
            jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(97, 103, 122));
            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel3.setText("Login Yukk ");
            login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 240, 30));

            jTabbedPane1.addTab("tab1", login);
            login.getAccessibleContext().setAccessibleParent(jTabbedPane1);

            daftar.setBackground(new java.awt.Color(255, 255, 255));
            daftar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel4.setBackground(new java.awt.Color(255, 255, 255));
            jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(97, 103, 122));
            jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel4.setText("Daftar Dulu Yahh");
            daftar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 240, 30));

            txt_username_regist.setBackground(new java.awt.Color(255, 255, 255));
            txt_username_regist.setForeground(new java.awt.Color(97, 103, 122));
            txt_username_regist.setLabelText("Username");
            txt_username_regist.setLineColor(new java.awt.Color(0, 255, 25));
            daftar.add(txt_username_regist, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 240, -1));

            txt_password_regist.setBackground(new java.awt.Color(255, 255, 255));
            txt_password_regist.setForeground(new java.awt.Color(97, 103, 122));
            txt_password_regist.setLabelText("Password");
            txt_password_regist.setLineColor(new java.awt.Color(0, 255, 25));
            txt_password_regist.setShowAndHide(true);
            daftar.add(txt_password_regist, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 240, -1));

            btn_register.setText("Daftar Sekarang");
            btn_register.setColor1(new java.awt.Color(40, 26, 220));
            btn_register.setColor2(new java.awt.Color(0, 255, 25));
            btn_register.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_registerActionPerformed(evt);
                  }
            });
            daftar.add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 240, 30));

            txt_nama_regist.setBackground(new java.awt.Color(255, 255, 255));
            txt_nama_regist.setForeground(new java.awt.Color(97, 103, 122));
            txt_nama_regist.setLabelText("Nama");
            txt_nama_regist.setLineColor(new java.awt.Color(0, 255, 25));
            daftar.add(txt_nama_regist, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 240, -1));
            daftar.add(icon_regist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 310, 330));

            register1.setBackground(new java.awt.Color(255, 255, 255));
            register1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
            register1.setForeground(new java.awt.Color(40, 26, 220));
            register1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            register1.setText("Kembali ke login");
            register1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            register1.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        register1MouseClicked(evt);
                  }
            });
            daftar.add(register1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 90, 20));

            jTabbedPane1.addTab("tab2", daftar);

            getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 710, 450));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
           btnLoginOnClick();
      }//GEN-LAST:event_btn_loginActionPerformed

      private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
            jTabbedPane1.setSelectedIndex(1);
      }//GEN-LAST:event_registerMouseClicked

      private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
            btnRegisterOnClick();
      }//GEN-LAST:event_btn_registerActionPerformed

      private void register1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register1MouseClicked
            jTabbedPane1.setSelectedIndex(0);
      }//GEN-LAST:event_register1MouseClicked

      /**
       * @param args the command line arguments
       */
      public static void main(String args[]) {
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
                  java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new MainLogin().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_login;
      private swing.ButtonGradient btn_register;
      private javax.swing.JPanel daftar;
      private javax.swing.JLabel icon;
      private javax.swing.JLabel icon_regist;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JTabbedPane jTabbedPane1;
      private javax.swing.JPanel login;
      private javax.swing.JLabel register;
      private javax.swing.JLabel register1;
      private textfield.TextField txt_nama_regist;
      private textfield.PasswordField txt_password_login;
      private textfield.PasswordField txt_password_regist;
      private textfield.TextField txt_username_login;
      private textfield.TextField txt_username_regist;
      // End of variables declaration//GEN-END:variables
}
