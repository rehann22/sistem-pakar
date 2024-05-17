package com.admin.controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import koneksi.db.ConnectionDb;

public class MasterDataGejala {
      
      private DefaultTableModel tabMode;

      public void autoNumber (JTextField kodeGej) {
            try {
              Connection conn = new ConnectionDb().connect();
              Statement st = conn.createStatement();
              String query = "SELECT kode_gejala FROM tbl_gejala ORDER BY kode_gejala DESC LIMIT 1";
              ResultSet rs = st.executeQuery(query);

              String kodeGejala = "G01";

              if (rs.next()) {
                  kodeGejala = rs.getString("kode_gejala");
                  int kode = Integer.parseInt(kodeGejala.substring(1)) + 1;
                  kodeGejala = String.format("G%02d", kode);
              }

              kodeGej.setText(kodeGejala);
            } catch (Exception ex) {
                  System.out.println(ex.getMessage());
            }

      }

      public void clearForm (JTextField kodeGejala, JComboBox organ, JTextField gejala) {
            kodeGejala.setText("");
            organ.setSelectedIndex(0);
            gejala.setText("");
      }

      public void addDataGejala (JTable tabel, JTextField kodeGejala, JComboBox organ, JTextField gejala) {
            if (!kodeGejala.getText().isEmpty() && !organ.getSelectedItem().toString().isEmpty() && !gejala.getText().isEmpty()) {

                    try {
                          Connection conn = new ConnectionDb().connect();
                          String query = "INSERT INTO tbl_gejala VALUES (?,?,?)";
                          PreparedStatement st = conn.prepareStatement(query);

                          st.setString(1, kodeGejala.getText());
                          st.setString(2, organ.getSelectedItem().toString());
                          st.setString(3, gejala.getText());

                          st.executeUpdate();
                          JOptionPane.showMessageDialog(null, "Data Tersimpan");
                          clearForm(kodeGejala, organ, gejala);
                          autoNumber(kodeGejala);
                          conn.close();
                          st.close();
                    } catch (SQLException ex) {
                          System.out.println(ex);
                          System.out.println("Eror Tambah Data Gejala");
                    }
            }else {
                  JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            }
      }

      public void editDataGejala (JTable tabel, JTextField kodeGejala, JComboBox organ, JTextField gejala) {

              try {
                    Connection conn = new ConnectionDb().connect();
                    String query = "UPDATE tbl_gejala SET organ = ?, gejala = ? where kode_gejala = ?";
                    PreparedStatement st = conn.prepareStatement(query);
                    st.setString(1, organ.getSelectedItem().toString());
                    st.setString(2, gejala.getText());
                    st.setString(3, kodeGejala.getText());

                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Terupdate");
                    clearForm(kodeGejala, organ, gejala);
                    kodeGejala.requestFocus();
                    autoNumber(kodeGejala);

              }catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Data gagal diubah");
              }
      }



      public void hapusGejala (JTable clickTable, JTextField kodeGejala){
              int selectedRow = clickTable.getSelectedRow();
              String getKodeGejala = clickTable.getValueAt(selectedRow, 0).toString();
              System.out.println(getKodeGejala);

              int ok = JOptionPane.showConfirmDialog(null, "Hapus Data Gejala", "Konfirmasi dialog",
                    JOptionPane.YES_NO_CANCEL_OPTION);
              if (ok==0) {
                    try {
                          Connection conn = new ConnectionDb().connect();
                          String query = "DELETE FROM `tbl_gejala` WHERE `kode_gejala`= ?";
                          PreparedStatement st = conn.prepareStatement(query);

                          st.setString(1, getKodeGejala);

                          st.executeUpdate();
                          JOptionPane.showMessageDialog(null, "Data Terhapus");
                          autoNumber(kodeGejala);

                    } catch (Exception e) {
                          JOptionPane.showMessageDialog(null, "Data gagal dihapus");
                    }
              }
      }

      public void tampilFormEditGejala (JTable clickTable, JTextField kodeGejala, JComboBox organ, JTextField gejala) {

              try {
                    int selectedRow = clickTable.getSelectedRow();
                    String selectKodeGejala = clickTable.getValueAt(selectedRow, 0).toString();
                    System.out.println(selectKodeGejala);

                    Connection conn = new ConnectionDb().connect();
                    String query = "SELECT * FROM `tbl_gejala` WHERE `kode_gejala` = ? ";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setString(1, selectKodeGejala);
                    ResultSet rs = ps.executeQuery();

                    String[] data = new String[3];
                    if (rs.next()) {
                        data[0] = rs.getString("kode_gejala");
                        data[1] = rs.getString("organ");
                        data[2] = rs.getString("gejala");
                    }

                    kodeGejala.setText(data[0]);
                    organ.setSelectedItem(data[1]);
                    gejala.setText(data[2]);
      
                    conn.close();
                    rs.close();

              } catch (SQLException ex) {
                    System.out.println(ex);
              }
      } 


      public void showTable(JTable tabel) {
                Object[] rows = {"Kode Gejala", "Organ", "Gejala"};
                tabMode = new DefaultTableModel(null, rows);
                tabel.setModel(tabMode);

                try {
                    Connection conn = new ConnectionDb().connect();
                    String query = "SELECT * FROM tbl_gejala";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        String a = rs.getString("kode_gejala");
                        String b = rs.getString("organ");
                        String c = rs.getString("gejala");

                        String[] data = {a, b, c};
                        tabMode.addRow(data);
                    }
                    conn.close();

                } catch (SQLException e) {
                    System.out.println("Error dataTabel: " + e.getMessage());
                }
      }
}
