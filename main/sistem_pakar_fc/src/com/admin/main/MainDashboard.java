package com.admin.main;
import com.admin.controler.AdminProfile;
import com.admin.controler.Dashboard;
import com.admin.controler.MasterDataGejala;
import com.admin.controler.MasterDataKonsultasiUsers;
import com.admin.controler.MasterDataPenyakit;
import com.admin.controler.MasterDataRelasi;
import com.event.EventMenuSelected;
import com.admin.view.Form_A;
import com.admin.view.Form_B;
import com.admin.view.Form_C;
import com.admin.view.Form_D;
import com.admin.view.Form_E;
import com.admin.view.Form_F;
import com.admin.view.Form_M;
import com.admin.view.dashboard;
import com.form.Form_Home;
import com.user.controler.TabelHasilKonsultasi;
import java.awt.Color;
import javaswingdev.chart.PieChart;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class MainDashboard extends javax.swing.JFrame {

    private dashboard admin_dashboard;
    private Form_A form_a;
    private Form_B form_b;
    private Form_C form_c;
    private Form_D form_d;
    private Form_E form_e;
    private Form_F form_f;

    public MainDashboard() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        admin_dashboard = new dashboard();
        form_a = new Form_A();
        form_b = new Form_B();
        form_c = new Form_C();
        form_d = new Form_D();
        form_e = new Form_E();
        form_f = new Form_F();        
        menu.initMoving(MainDashboard.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                  
                  if (index == 0) {
                  setForm(admin_dashboard);
                  } else if (index == 1) {
                         setForm(form_a);
                  } else if (index == 2) {
                         setForm(form_b);
                  } else if (index == 3) {
                         setForm(form_c);
                  } else if (index == 4) {
                         setForm(form_d);
                  } else if (index == 5) {
                        setForm(form_e);
                  } else if (index == 6) {
                         setForm(form_f);
                  } else if (index == 8) {
                        refreshAll();
                        System.out.println("refresh");
                  }else if (index == 9) {  //profile  
                        Form_M form = new Form_M();
                        AdminProfile data = new AdminProfile();
                        data.TampilData(form.txt_id, form.txt_nama, form.txt_email, form.txt_password);
                        form.setVisible(true);
                  } else if (index == 12) { //logout
                        int jawaban = JOptionPane.showConfirmDialog(null, "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                        if (jawaban == JOptionPane.YES_OPTION) {
                             System.exit(0);
                        }
                  }
            }
        });

        setForm(new dashboard());
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    private void refreshAll () {
          Dashboard dashboard = new Dashboard();
          dashboard.totalPenyakit();
          dashboard.totalGejala();
          dashboard.totalRule();
          dashboard.totalUser();
          dashboard.tabelDashboard(admin_dashboard.tabel_dashboard);
          
          MasterDataPenyakit mdp = new MasterDataPenyakit();
          mdp.showTable(form_a.tabel_penyakit);
          
          MasterDataGejala mdg = new MasterDataGejala();
          mdg.showTable(form_b.tabel_gejala);
          
          MasterDataKonsultasiUsers dku = new MasterDataKonsultasiUsers();
          dku.TampilIdUsers(form_f. cbb_filter);
          dku.tampilDataFilterUser(form_f.tabel_laporan, form_f.cbb_filter.getSelectedItem().toString());
          dku.tampilDataKonsultasiUsers(form_f.tabel_laporan);
          
          MasterDataRelasi dRelasi = new MasterDataRelasi();
          dRelasi.TampilKodePenyakit(form_d.cbb_kodepenyakit);
          dRelasi.TampilNamaPenyakit(form_d.cbb_kodepenyakit, form_d.txt_namapenyakit);
                  
          admin_dashboard.refreshDashboard();
    }


    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder1 = new com.swing.PanelBorder();
            menu = new com.component.Menu();
            header2 = new com.component.Header();
            mainPanel = new javax.swing.JPanel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);

            panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

            header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

            mainPanel.setOpaque(false);
            mainPanel.setLayout(new java.awt.BorderLayout());

            javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
            panelBorder1.setLayout(panelBorder1Layout);
            panelBorder1Layout.setHorizontalGroup(
                  panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                              .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())))
            );
            panelBorder1Layout.setVerticalGroup(
                  panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                  .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDashboard().setVisible(true);
            }
        });
    }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private com.component.Header header2;
      private javax.swing.JPanel mainPanel;
      private com.component.Menu menu;
      private com.swing.PanelBorder panelBorder1;
      // End of variables declaration//GEN-END:variables
}
