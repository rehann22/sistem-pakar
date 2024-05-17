package com.admin.controler;

import java.sql.ResultSet;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import koneksi.db.ConnectionDb;

public class MasterDataRelasi {
      private DefaultTableModel tabMode;

      //menampilkan kode penyakit ke combobox
      public void TampilKodePenyakit(JComboBox kodePenyakit) {
            try {
                kodePenyakit.removeAllItems(); // Hapus semua item sebelum menambahkan yang baru
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT * FROM `tbl_penyakit` ORDER BY kode_penyakit";
                PreparedStatement st = conn.prepareStatement(query);
                ResultSet rs = st.executeQuery();

                kodePenyakit.addItem(" "); // Item kosong jika diperlukan

                while (rs.next()) {
                    kodePenyakit.addItem(rs.getString("kode_penyakit"));
                }
                rs.close();
                conn.close();

                kodePenyakit.setSelectedIndex(1); // Set ComboBox ke indeks ke-1 (setelah item ditambahkan)
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("Eror tampil kode penyakit");
            }
      }

      
      //menampilkan nama penyakit di jtextfield
      public void TampilNamaPenyakit(JComboBox cbb_KodePenyakit, JTextField txt_NamaPenyakit) {
            if (cbb_KodePenyakit.getSelectedItem() != null) {
                String kodePenyakit = cbb_KodePenyakit.getSelectedItem().toString();

                  try {
                      Connection conn = new ConnectionDb().connect();
                      String query = "SELECT nama_penyakit FROM `tbl_penyakit` WHERE `kode_penyakit` = ?";
                      PreparedStatement st = conn.prepareStatement(query);
                      st.setString(1, kodePenyakit);
                      ResultSet rs = st.executeQuery();

                      if (rs.next()) {
                          String namaPenyakit = rs.getString("nama_penyakit");
                          txt_NamaPenyakit.setText(namaPenyakit);
                      } else {
                          txt_NamaPenyakit.setText("Pilih Kode Penyakit");
                      }

                      conn.close();
                  } catch (SQLException ex) {
                      System.out.println(ex);
                      System.out.println("Error tampil nama penyakit");
                  }
            } else {
                txt_NamaPenyakit.setText("Pilih Kode Penyakit");
            }
      }

      
      public void pilihKodePenyakit(JTable tabelDataGejala, JTable tabelDataRelasi, JComboBox cbb_KodePenyakit, JTextField txt_NamaPenyakit) {
            int index = cbb_KodePenyakit.getSelectedIndex();

            TampilNamaPenyakit(cbb_KodePenyakit, txt_NamaPenyakit); // Operasi yang sama dilakukan di semua case

            switch (index) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                      TampilDataRelasi(cbb_KodePenyakit.getSelectedItem().toString(), tabelDataGejala, tabelDataRelasi);
                    break;
                default:
                    // Operasi default jika diperlukan
                    break;
            }
      }    
      
      public void TambahDataRelasi (JComboBox cbb_KodePenyakit, JTextField txt_KodePenyakit, JTextField txt_NamaPenyakit, JTable tabel) {
            //set teks kode penyakit
            String kodePenyakit = cbb_KodePenyakit.getSelectedItem().toString();
            txt_KodePenyakit.setText(kodePenyakit);

            //set teks nama penyakit
            TampilNamaPenyakit(cbb_KodePenyakit, txt_NamaPenyakit);

            //tampilkan tabel gejala
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
      
      public void SimpanDataRelasi(JTable clickTable, JTextField kodePenyakit) {
            int[] selectedRows = clickTable.getSelectedRows();
            String kodeGejalaConcat = ""; // String untuk menggabungkan kode gejala dipisahkan dengan koma

            for (int i = 0; i < selectedRows.length; i++) {
                String getKodeGejala = clickTable.getValueAt(selectedRows[i], 0).toString();
                System.out.println(getKodeGejala);

                // Menggabungkan kode gejala dengan koma
                if (i == 0) {
                    kodeGejalaConcat = getKodeGejala;
                } else {
                    kodeGejalaConcat += "," + getKodeGejala;
                }
            }

            try {
                Connection conn = new ConnectionDb().connect();
                String query = "INSERT INTO tbl_gejalapenyakit (kode_gejala, kode_penyakit) VALUES (?,?)";
                PreparedStatement st = conn.prepareStatement(query);

                st.setString(1, kodeGejalaConcat); // Menggunakan string yang berisi semua kode gejala yang dipilih
                st.setString(2, kodePenyakit.getText());

                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data relasi berhasil disimpan");

                st.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Kode Penyakit " + kodePenyakit.getText() + " Sudah ada, Silahkan gunakan tombol ubah untuk mengubah data gejala");
                System.out.println("Eror simpan data relasi" + ex);
            }
      }
      
      //start update data relasi
      public void UpdateDataRelasi(JTable clickTable, JTextField kodePenyakit) {
            int[] selectedRows = clickTable.getSelectedRows();
            String kodeGejalaConcat = ""; // String untuk menggabungkan kode gejala dipisahkan dengan koma

            for (int i = 0; i < selectedRows.length; i++) {
              String getKodeGejala = clickTable.getValueAt(selectedRows[i], 0).toString();
              System.out.println(getKodeGejala);

              // Menggabungkan kode gejala dengan koma
              if (i == 0) {
                  kodeGejalaConcat = getKodeGejala;
              } else {
                  kodeGejalaConcat += "," + getKodeGejala;
              }
            }

            try {
                  Connection conn = new ConnectionDb().connect();
                  // Ambil kode_gejala yang sudah ada dari basis data
                  String existingKodeGejala = getExistingKodeGejalaFromDatabase(kodePenyakit.getText(), conn);

                  // Gabungkan kode_gejala yang sudah ada dengan kode gejala yang baru
                  String updatedKodeGejala = existingKodeGejala + "," + kodeGejalaConcat;

                  // Update kode_gejala yang sudah ada dengan yang baru
                  updateKodeGejalaInDatabase(updatedKodeGejala, kodePenyakit.getText(), conn);

                  javax.swing.JOptionPane.showMessageDialog(null, "Data Relasi Terupdate");
                  conn.close();
            } catch (Exception ex) {
                  javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
                  System.out.println("eror saat update");
            }
      }

      // Fungsi untuk mendapatkan kode_gejala yang sudah ada dari basis data
      private String getExistingKodeGejalaFromDatabase(String kodePenyakit, Connection conn) throws SQLException {
            String query = "SELECT kode_gejala FROM tbl_gejalapenyakit WHERE kode_penyakit = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, kodePenyakit);
            ResultSet rs = st.executeQuery();

            String existingKodeGejala = "";
            if (rs.next()) {
              existingKodeGejala = rs.getString("kode_gejala");
            }
            rs.close();
            return existingKodeGejala;
      }

      //Fungsi untuk memperbarui kode_gejala di basis data
      private void updateKodeGejalaInDatabase(String updatedKodeGejala, String kodePenyakit, Connection conn) throws SQLException {
            String query = "UPDATE tbl_gejalapenyakit SET kode_gejala = ? WHERE kode_penyakit = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, updatedKodeGejala);
            st.setString(2, kodePenyakit);
            st.executeUpdate();
      }
      //end update data relasi
      
      //hapus data relasi
      public void deleteRelasi (String kodePenyakit) {
            int ok = JOptionPane.showConfirmDialog(null, "Hapus Data Relasi ?", "Konfirmasi",
            JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok==0) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "DELETE FROM `tbl_gejalapenyakit` WHERE `kode_penyakit`= ?";
                        PreparedStatement st = conn.prepareStatement(query);
                        
                        st.setString(1, kodePenyakit);
                        
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                        conn.close();
                  } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                  }
            }
      }
      
      //Button action simpan form data relasi
      public void handleDataRelasi(JTable clickTable, JTextField kodePenyakit) {
            int[] selectedRows = clickTable.getSelectedRows();
            String kodeGejalaConcat = "";

            for (int i = 0; i < selectedRows.length; i++) {
                String getKodeGejala = clickTable.getValueAt(selectedRows[i], 0).toString();
                System.out.println(getKodeGejala);

                if (i == 0) {
                    kodeGejalaConcat = getKodeGejala;
                } else {
                    kodeGejalaConcat += "," + getKodeGejala;
                }
            }

            try {
                Connection conn = new ConnectionDb().connect();
                // Cek apakah kode penyakit sudah ada di basis data
                if (isKodePenyakitExists(kodePenyakit.getText(), conn)) {
                    // Jika sudah ada, jalankan metode UpdateDataRelasi
                    UpdateDataRelasi(clickTable, kodePenyakit);
                } else {
                    // Jika belum ada, jalankan metode SimpanDataRelasi
                    SimpanDataRelasi(clickTable, kodePenyakit);
                }

                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.out.println("Error saat menangani data relasi");
            }
      }
      
      private boolean isKodePenyakitExists(String kodePenyakit, Connection conn) throws SQLException {
            String query = "SELECT COUNT(*) FROM tbl_gejalapenyakit WHERE kode_penyakit = ?";
            try (PreparedStatement st = conn.prepareStatement(query)) {
                st.setString(1, kodePenyakit);
                try (ResultSet rs = st.executeQuery()) {
                    rs.next();
                    return rs.getInt(1) > 0;
                }
            }
      }
      //end Button action simpan form data relasi
      
      
      //untuk mendapatkan detail gejala berdasarkan kode gejala
      public String [] getDetailGejala (String kode){
            String [] data = new String [2];
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT * FROM tbl_gejala WHERE kode_gejala = ?";
                  PreparedStatement st = conn.prepareStatement(query);
                  st.setString(1, kode);
                  ResultSet rs = st.executeQuery();
                  
                  while (rs.next()) {
                        
                        data [0] = rs.getString ("organ");
                        data [1] = rs.getString("gejala");
                        
                  }
                  rs.close();
                  conn.close();   
                  
            } catch (SQLException ex) {
                  System.out.println(ex);
                  System.out.println("eror getDetailGejala");
            }
            
            return data;
      }
      
      public void TampilDataRelasi(String kodePenyakit, JTable tabelDataGejala, JTable tabelDataRelasi) {
            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT * FROM tbl_gejalapenyakit WHERE kode_penyakit = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, kodePenyakit);
                ResultSet rs = st.executeQuery();

                DefaultTableModel model = createTableModel();
                tabelDataRelasi.setModel(model);

                  while (rs.next()) {
                      String kodeGejala = rs.getString("kode_gejala");
                      processGejalaData(kodeGejala, model);
                  }

                rs.close();
                conn.close();

                  // Menambahkan MouseListener ke tabelDataRelasi
                  tabelDataRelasi.addMouseListener(new MouseAdapter() {
                      @Override
                        public void mouseReleased(MouseEvent e) {
                              if (SwingUtilities.isRightMouseButton(e)) {
                                  int row = tabelDataRelasi.rowAtPoint(e.getPoint());
                                  if (row >= 0 && row < tabelDataRelasi.getRowCount()) {
                                      tabelDataRelasi.setRowSelectionInterval(row, row);
                                      showPopupMenu(e, tabelDataRelasi, kodePenyakit);
                                  } else {
                                      tabelDataRelasi.clearSelection();
                                  }
                              }
                        }
                  });
            }
            catch (SQLException ex) {
                  System.out.println("Eror tampil data relasi" + ex);
            }
      }

      private DefaultTableModel createTableModel() {
            String[] columnTitles = {"Kode", "Organ", "Gejala"};
            return new DefaultTableModel(columnTitles, 0) {
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            };
      }

      private void processGejalaData(String kodeGejala, DefaultTableModel model) {
            String[] detailGejala;
            int index = model.getRowCount();

            for (String gejala : kodeGejala.split(",")) {
                detailGejala = getDetailGejala(gejala);
                model.addRow(new Object[]{gejala, detailGejala[0], detailGejala[1]});
            }
      }
      //end
      
      
      //Start      
      private void showPopupMenu(MouseEvent e, JTable tabelDataRelasi, String kodePenyakit) {
            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem deleteItem = new JMenuItem("Hapus Kode Gejala?");
            deleteItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
            deleteItem.addActionListener(actionEvent -> {
                  int selectedRow = tabelDataRelasi.getSelectedRow();
                  if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) tabelDataRelasi.getModel();
                        
                        // Hapus data dari tabel
                        model.removeRow(selectedRow);
                        SimpanPerubahan(tabelDataRelasi, kodePenyakit);
                  }
            });

            popupMenu.add(deleteItem);
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
      }
      //end
      
      public void SimpanPerubahan (JTable tabel, String kodePenyakit) {
            tabMode = (DefaultTableModel) tabel.getModel();
            int rowCount = tabel.getRowCount();
            String kodeGejalaConcat = "";

            for (int i = 0; i < rowCount; i++) {
                String getKodeGejala = tabel.getValueAt(i, 0).toString();
                System.out.println(getKodeGejala);

                if (i > 0) {
                    kodeGejalaConcat += ",";
                }
                kodeGejalaConcat += getKodeGejala;
            }

            System.out.println("Kode Gejala : " + kodeGejalaConcat);
            
            try {
                  Connection conn = new ConnectionDb().connect();
                  updateKodeGejalaInDatabase(kodeGejalaConcat, kodePenyakit, conn);
                  JOptionPane.showMessageDialog(null, "Kode gejala berhasil terhapus");
            } catch (SQLException ex) {
                  System.out.println("Eror void simpan perubahan\n" + ex);
            }
      }
 }
