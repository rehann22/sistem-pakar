package com.user.view;

import com.raven.model.Model_Card;
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

public class Dashboard extends javax.swing.JPanel {

    public Dashboard() {         
        initComponents();
 
    }
    
     


    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder = new com.raven.swing.PanelBorder();
            jLabel1 = new javax.swing.JLabel();

            setBackground(new java.awt.Color(242, 242, 242));
            setForeground(new java.awt.Color(150, 150, 150));
            setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            setPreferredSize(new java.awt.Dimension(935, 580));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(127, 127, 127));
            jLabel1.setText("Dashboard");
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel jLabel1;
      private com.raven.swing.PanelBorder panelBorder;
      // End of variables declaration//GEN-END:variables
}
