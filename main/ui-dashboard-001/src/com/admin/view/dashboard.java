package com.admin.view;

import com.admin.controler.Dashboard;
import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaswingdev.chart.ModelPieChart;
import javaswingdev.chart.PieChart;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import koneksi.db.ConnectionDb;

public class dashboard extends javax.swing.JPanel {

    public dashboard() {
     
        Dashboard data = new Dashboard();         
        initComponents();
        
        data.tabelDashboard(tabel_dashboard);
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/icons8-virus-64.png")), "Penyakit",  data.totalPenyakit()));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/icons8-virus-64 (1).png")), "Gejala", data.totalGejala()));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/icons8-algorithm-50 (1).png")), "Rule", data.totalRule()));
        card4.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/icons8-person-64.png")), "Pengguna", data.totalUser()));
        
        //  add row table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        pieChart();
    }
    
         public void pieChart () {
            pie_chart.setChartType(PieChart.PeiChartType.DONUT_CHART);
            // Ambil data dari database
            try {
                // Koneksi ke database
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT YEAR(tbl_hasil_diagnosa.tanggal) AS tahun, " +
                        "MONTH(tbl_hasil_diagnosa.tanggal) AS bulan, " +
                        "COUNT(DISTINCT tbl_hasil_diagnosa.id_konsultasi) AS total_ikan_terjangkit " +
                        "FROM tbl_hasil_diagnosa " +
                        "INNER JOIN tbl_penyakit ON tbl_hasil_diagnosa.kode_penyakit = tbl_penyakit.kode_penyakit " +
                        "GROUP BY YEAR(tbl_hasil_diagnosa.tanggal), MONTH(tbl_hasil_diagnosa.tanggal)";

                PreparedStatement st = conn.prepareStatement(query);
                ResultSet rs = st.executeQuery();

                // Tambahkan data dari query ke grafik pie
                while (rs.next()) {
                    int tahun = rs.getInt("tahun");
                    int bulan = rs.getInt("bulan");
                    int total_ikan_terjangkit = rs.getInt("total_ikan_terjangkit");
                    String label = "Bulan " + bulan + " Tahun " + tahun;
                    Color warna = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
                    pie_chart.addData(new ModelPieChart(label, total_ikan_terjangkit, warna));
                }

                conn.close(); // Tutup koneksi setelah selesai
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
      }


    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panel = new javax.swing.JLayeredPane();
            card1 = new com.raven.component.Card();
            card2 = new com.raven.component.Card();
            card3 = new com.raven.component.Card();
            card4 = new com.raven.component.Card();
            panelBorder1 = new com.raven.swing.PanelBorder();
            pie_chart = new javaswingdev.chart.PieChart();
            jLabel3 = new javax.swing.JLabel();
            panelBorder2 = new com.raven.swing.PanelBorder();
            jLabel2 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tabel_dashboard = new com.raven.swing.Table();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

            card1.setColor1(new java.awt.Color(142, 142, 250));
            card1.setColor2(new java.awt.Color(0, 153, 0));
            panel.add(card1);

            card2.setColor1(new java.awt.Color(186, 107, 24));
            card2.setColor2(new java.awt.Color(167, 94, 236));
            panel.add(card2);

            card3.setColor1(new java.awt.Color(241, 208, 62));
            card3.setColor2(new java.awt.Color(0, 0, 255));
            panel.add(card3);

            card4.setColor1(new java.awt.Color(153, 0, 153));
            card4.setColor2(new java.awt.Color(211, 184, 61));
            panel.add(card4);

            add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 915, -1));

            panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            panelBorder1.add(pie_chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 430, 310));

            jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(127, 127, 127));
            jLabel3.setText("Persentase Konsultasi Perbulan");
            panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

            add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 450, 350));

            panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(127, 127, 127));
            jLabel2.setText("Data Penyakit Terbanyak");
            panelBorder2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

            spTable.setBorder(null);

            tabel_dashboard.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "Name", "Email", "User Type", "Joined", "Status"
                  }
            ) {
                  boolean[] canEdit = new boolean [] {
                        false, false, false, false, false
                  };

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            spTable.setViewportView(tabel_dashboard);

            panelBorder2.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 410, 280));

            add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 231, 450, 350));
      }// </editor-fold>//GEN-END:initComponents


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private com.raven.component.Card card1;
      private com.raven.component.Card card2;
      private com.raven.component.Card card3;
      private com.raven.component.Card card4;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLayeredPane panel;
      private com.raven.swing.PanelBorder panelBorder1;
      private com.raven.swing.PanelBorder panelBorder2;
      private javaswingdev.chart.PieChart pie_chart;
      private javax.swing.JScrollPane spTable;
      private com.raven.swing.Table tabel_dashboard;
      // End of variables declaration//GEN-END:variables
}
