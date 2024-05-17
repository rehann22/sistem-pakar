package com.admin.controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import koneksi.db.ConnectionDb;

public class TabelPertanyaan {
      
      public void TampilDataPertanyaan(JTable tabelPertanyaan) {
            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT * FROM tbl_gejala ORDER BY kode_gejala";
                PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = ps.executeQuery();

                rs.last();
                int jumbaris = rs.getRow();
                rs.beforeFirst();

                  DefaultTableModel model = new DefaultTableModel() {
                      @Override
                      public boolean isCellEditable(int rowIndex, int mColIndex) {
                          return mColIndex == 3; // Hanya kolom "Jawaban (ya/tidak)" yang dapat diedit
                      }

                      @Override
                      public Class<?> getColumnClass(int column) {
                          switch (column) {
                              case 0:
                                  return Integer.class; // Mengubah tipe data kolom "No" menjadi Integer
                              case 1:
                                  return String.class; // Tipe data kolom "kode gejala" tetap String
                              case 2:
                                    return String.class;
                              case 3:
                                  return Boolean.class; // Tipe data kolom "Jawaban (ya/tidak)" tetap Boolean
                              default:
                                  return String.class;
                          }
                      }
                  };

                  tabelPertanyaan.setModel(model);
                  model.addColumn("No");
                  model.addColumn("Kode Gejala");
                  model.addColumn("Pertanyaan");
                  model.addColumn("Ya/Tidak");

                  int counter = 1;
                  while (rs.next()) {
                      String kodeGejala = rs.getString("kode_gejala"); // Ambil nilai kode gejala dari database
                      String pertanyaan = "Apakah Organ " + rs.getString("organ").toLowerCase() + " pada ikan memiliki ciri-ciri " + rs.getString("gejala").toLowerCase() + " ?";
                      model.addRow(new Object[]{counter, kodeGejala, pertanyaan, false}); // Tambahkan kode gejala ke dalam baris
                      counter++;
                  }


                  tabelPertanyaan.getColumnModel().getColumn(0).setPreferredWidth(50); // Kolom "No"
                  tabelPertanyaan.getColumnModel().getColumn(2).setPreferredWidth(700); // Kolom "Pertanyaan"
                  tabelPertanyaan.getColumnModel().getColumn(3).setPreferredWidth(200); // Kolom "Jawaban (ya/tidak)"

                  tabelPertanyaan.getColumnModel().getColumn(1).setMaxWidth(0);
                  tabelPertanyaan.getColumnModel().getColumn(1).setMinWidth(0);
                  tabelPertanyaan.getColumnModel().getColumn(1).setWidth(0);
                  tabelPertanyaan.getColumnModel().getColumn(1).setPreferredWidth(0);
                  conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
      }

      
      String [] data = new String[5];
      public String [] getDetailPenyakit (String kode) {
            
            String query = "SELECT * FROM tbl_penyakit WHERE kode_penyakit = '"+kode+"' ";
            
            try {
                  Connection conn = new ConnectionDb().connect();
                  PreparedStatement st = conn.prepareStatement(query);
                  ResultSet rs = st.executeQuery();
                  
                  int index = 0;
                  String kodepenyakit = "";
                  
                        while (rs.next()) {

                              data [0] = rs.getString("kode_penyakit");
                              data [1] = rs.getString("nama_penyakit");
                              data [2] = rs.getString("deskripsi");
                              data [3] = rs.getString("pencegahan");
                              data [4] = rs.getString("obat");

                        }
                        rs.close();
                        conn.close();
                  
            } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage());
                  System.out.println("eror get detail penyakit");
            }
            return data;
      }  
      
      
      public void DiagnosaPenyakit(JFrame frame,int selectedCount, JTable tabelPertanyaan, JTextField kPenyakit, JTextField namaPenyakit, JTextArea pencegahan, JTextField obat) {
            selectedCount = 0;
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT kode_penyakit FROM tbl_gejalapenyakit WHERE ";
                  String kode = "";
                  PreparedStatement ps = conn.prepareStatement(query);

                  // Mendapatkan model tabel
                  javax.swing.table.TableModel model = tabelPertanyaan.getModel();

                  // Iterasi melalui setiap baris dalam tabel
//                  for (int i = 0; i < model.getRowCount(); i++) {
//                        // Memeriksa nilai centang di kolom 3
//                        Boolean isSelected = (Boolean) model.getValueAt(i, 3);
//                        if (isSelected) {
//                            // Jika dipilih, ambil nilai kode gejala dari kolom 1
//                            String kodeGejala = (String) model.getValueAt(i, 1);
//                            kode += "kode_gejala LIKE '%" + kodeGejala + "%' AND ";
//
//                              System.out.println(kodeGejala);
//                              System.out.println(kode);
//                        }
//                  }

//                  int selectedCount = 0;
                  for (int i = 0; i < model.getRowCount(); i++) {
                      Boolean isSelected = (Boolean) model.getValueAt(i, 3); // Asumsi kolom ke-3 adalah kolom centang
                      if (isSelected != null && isSelected) {
                          selectedCount++;
                          String kodeGejala = (String) model.getValueAt(i, 1);
                          kode += "kode_gejala LIKE '%" + kodeGejala + "%' AND ";
                      }
                  }
                  
                  // Memeriksa apakah minimal 2 pertanyaan dipilih
                  if (selectedCount < 2) {
                      JOptionPane.showMessageDialog(null, "Pilih minimal 2 pertanyaan yahh", "Peringatan", JOptionPane.WARNING_MESSAGE);
                  } else {
                      System.out.println("Kode Gejala: " + kode);
                      // Lanjutkan dengan logika lainnya
                  }

                  if (!kode.isEmpty()) {
                      kode = kode.substring(0, kode.length() - 4); // Menghapus ' OR ' terakhir
                      query += kode;

                      ResultSet rs = ps.executeQuery(query);
                      String kodePenyakit = "";

                        while (rs.next()) {
                            kodePenyakit = rs.getString("kode_penyakit");
                            // Lakukan sesuatu dengan kodePenyakit yang didapatkan (tampilkan informasi penyakit, lakukan tindakan tertentu, dll.)
                            System.out.println("Kode Penyakit: " + kodePenyakit);
                        }

                        if (!kodePenyakit.isEmpty()) {
                            // Lakukan tindakan lebih lanjut sesuai dengan kodePenyakit yang didapatkan
                            getDetailPenyakit(kodePenyakit);

                            kPenyakit.setText(data[0]);
                            namaPenyakit.setText(data[1]);
                            pencegahan.setText(data[3]);
                            obat.setText(data[4]);
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Tidak ada penyakit yang sesuai dengan gejala yang dipilih");
                        }

                      rs.close();
                  } else {

                      JOptionPane.showMessageDialog(null, "Kamu belum memilih pertanyaan:(");
                  }

                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Eror Diagnosa Penyakit");
            }
      }
      
      public void refreshCheckbox (JTable tabelPertanyaan) {
            javax.swing.table.TableModel model = tabelPertanyaan.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(false, i, 3); // Mengatur nilai boolean di kolom "Jawaban (ya/tidak)" menjadi false
            }

      }
}