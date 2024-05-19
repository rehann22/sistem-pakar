package com.user.main;
import com.raven.event.EventMenuSelected;
import com.user.controler.EditProfile;
import com.user.controler.SessionUser;
import com.user.view.Dashboard;
import com.user.view.Form_A;
import com.user.view.Form_B;
import com.user.view.Form_C;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import com.user.view.Form_F;

public class MainDashboard extends javax.swing.JFrame {
      String LogId = new SessionUser().log_idPengguna();
      
      private Dashboard user_dashboard;
      private Form_A form_a;
      private Form_B form_b;
      private Form_C form_c;

      public MainDashboard() {
            initComponents();
            setBackground(new Color(0, 0, 0, 0));
            user_dashboard = new Dashboard();
            form_a = new Form_A();
            form_b = new Form_B();
            form_c = new Form_C();
            
            Form_F form_f = new Form_F();
            EditProfile data = new EditProfile();
            form_f.txt_id.setText(LogId);
            
            menu.initMoving(MainDashboard.this);
            menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                  if (index == 0) {
                      setForm(user_dashboard);
                  } else if (index == 1) {
                      setForm(form_a);
                  } else if (index == 2) {
                      setForm(form_b);
                  } else if (index == 3) {
                      setForm(form_c);
                  } else if (index == 7) {
                        data.tampiDataUser(form_f.txt_id, form_f.txt_nama, form_f.txt_username, form_f.txt_password);
                        form_f.setVisible(true);
                  } else if (index == 8) {
                      int jawaban = JOptionPane.showConfirmDialog(null, "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                      if (jawaban == JOptionPane.YES_OPTION) {
                          System.exit(0);
                      }
                  }
            }
        });
        
        setForm(new Dashboard());
    }
                        

      private void setForm(JComponent com) {
          mainPanel.removeAll();
          mainPanel.add(com);
          mainPanel.repaint();
          mainPanel.revalidate();
      }


    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder = new com.raven.swing.PanelBorder();
            mainPanel = new javax.swing.JPanel();
            menu = new com.user.component.Menu();
            header = new com.user.component.Header();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);
            setPreferredSize(new java.awt.Dimension(1180, 657));

            panelBorder.setBackground(new java.awt.Color(242, 242, 242));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            mainPanel.setOpaque(false);
            mainPanel.setLayout(new java.awt.BorderLayout());
            panelBorder.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 1030, 580));
            panelBorder.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 657));

            javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
            header.setLayout(headerLayout);
            headerLayout.setHorizontalGroup(
                  headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGap(0, 1050, Short.MAX_VALUE)
            );
            headerLayout.setVerticalGroup(
                  headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGap(0, 45, Short.MAX_VALUE)
            );

            panelBorder.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 0, 1050, -1));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(panelBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(panelBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDashboard().setVisible(true);
            }
        });
    }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private com.user.component.Header header;
      private javax.swing.JPanel mainPanel;
      private com.user.component.Menu menu;
      private com.raven.swing.PanelBorder panelBorder;
      // End of variables declaration//GEN-END:variables
}
                    
