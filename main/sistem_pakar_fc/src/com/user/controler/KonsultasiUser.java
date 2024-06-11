package com.user.controler;
import com.user.controler.SessionUser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import koneksi.db.ConnectionDb;

public class KonsultasiUser {
      String logName = SessionUser.log_nama();
      String logId = SessionUser.log_idPengguna();
      
      public void TampilDataPertanyaan(JPanel panelDataPertanyaan) {
            
          String query = "SELECT * FROM tbl_gejala ORDER BY kode_gejala";
            
          try {
                
              Connection conn = new ConnectionDb().connect();
              PreparedStatement st = conn.prepareStatement(query);
              ResultSet rs = st.executeQuery(query);
              
              panelDataPertanyaan.setLayout(new GridLayout(0, 1)); // Set layout panel menjadi GridLayout
              
              int counter = 1; // Counter untuk nomor urutan pertanyaan
              
              while (rs.next()) {
                  String kodeGejala = rs.getString("kode_gejala");
                  String pertanyaan = counter +"   Apakah " + rs.getString("organ").toLowerCase() +
                          " pada ikan memiliki ciri-ciri " + rs.getString("gejala").toLowerCase() + " ? ";

                  JPanel panelQuestion = new JPanel(new GridBagLayout());
                  GridBagConstraints gbc = new GridBagConstraints();

                  // Label untuk pertanyaan
                  JLabel labelPertanyaan = new JLabel(pertanyaan);
                  labelPertanyaan.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            labelPertanyaan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            labelPertanyaan.setCursor(Cursor.getDefaultCursor());
                        }
                    });
                  labelPertanyaan.setFont(new Font("Lucida Bright", Font.PLAIN, 13)); // Mengatur font dan ukuran font
                  labelPertanyaan.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // Menambahkan margin atas bawah
                  labelPertanyaan.setForeground(new Color(51, 51, 51)); // Mengatur warna font
                  //panelQuestion.setBackground(new Color(225, 209, 209)); // Nilai RGB sesuai rentang yang valid
                  panelQuestion.setBackground(Color.white); // Nilai RGB sesuai rentang yang valid
                  gbc.insets = new Insets(30, 30, 30, 30); // Menentukan ruang (padding) di sekitar label
                  gbc.anchor = GridBagConstraints.CENTER; // Mengatur agar label berada di tengah

                  gbc.gridx = 0;
                  gbc.gridy = 0;
                  gbc.anchor = GridBagConstraints.WEST;
                  gbc.weightx = 1.0;
                  panelQuestion.add(labelPertanyaan, gbc);

                  // Checkbox
                  JCheckBox checkBox = new JCheckBox();
                  checkBox.setActionCommand(kodeGejala);
                  checkBox.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        }
                    });
                  gbc.gridx = 1;
                  gbc.gridy = 0;
                  gbc.anchor = GridBagConstraints.EAST;
                  gbc.weightx = 0.0;
                  panelQuestion.add(checkBox, gbc);
                  
                 panelDataPertanyaan.add(panelQuestion);

                  // Menambahkan action listener ke JLabel untuk mengatur status checkbox
                  labelPertanyaan.addMouseListener(new MouseAdapter() {
                      @Override
                      public void mouseClicked(MouseEvent e) {
                          checkBox.setSelected(!checkBox.isSelected()); // Mengubah status checkbox saat label diklik
                          handleCheckBoxChange(checkBox.getActionCommand(), checkBox.isSelected()); // Menangani perubahan nilai checkbox
                      }
                  });

                  checkBox.addActionListener(e -> {
                      JCheckBox source = (JCheckBox) e.getSource();
                      handleCheckBoxChange(source.getActionCommand(), source.isSelected()); // Menangani perubahan nilai checkbox
                      String kode = source.getActionCommand();
                      System.out.println("CheckBox with code " + kodeGejala + " is checked: " + source.isSelected());
                  });
                  
                  counter ++;
              }

              rs.close();
              conn.close();

          } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());
              System.out.println("eror tampil data pertanyaan");
          }
      }
      
      public void refreshCheckbox (JPanel panelDataPertanyaan) {
            Component[] components = panelDataPertanyaan.getComponents();
            for (Component component : components) {
                if (component instanceof JPanel) {
                    JPanel panelQuestion = (JPanel) component;
                    Component[] innerComponents = panelQuestion.getComponents();
                    for (Component innerComponent : innerComponents) {
                        if (innerComponent instanceof JCheckBox) {
                            JCheckBox checkBox = (JCheckBox) innerComponent;
                            checkBox.setSelected(false); // Set semua checkbox menjadi tidak tercentang
                             System.out.println("Checkbox false ");
                        }
                    }
                }
            } 
      }
      
      
      // Method untuk menangani perubahan nilai checkbox
      private void handleCheckBoxChange(String kodeGejala, boolean isSelected) {
          System.out.println("Kode Gejala: " + kodeGejala + " is selected: " + isSelected);
          // Lakukan apa yang Anda perlukan dengan nilai kode dan isSelected di sini (misalnya, menyimpan nilai ke variabel, melakukan proses, dll.)
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
      
      
      public void DiagnosaPenyakit(int index, JPanel panelDataPertanyaan, JTabbedPane jTabbedPane1, JLabel kPenyakit, JLabel namaPenyakit, JLabel pencegahan, JLabel obat) {
            
            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT kode_penyakit FROM tbl_gejalapenyakit WHERE ";
                String kode = ""; 
                PreparedStatement ps = conn.prepareStatement(query);

                  for (Component component : panelDataPertanyaan.getComponents()) {
                        if (component instanceof JPanel) {
                            JPanel panelQuestion = (JPanel) component;
                            for (Component comp : panelQuestion.getComponents()) {
                                if (comp instanceof JCheckBox) {
                                    JCheckBox checkBox = (JCheckBox) comp;
                                    if (checkBox.isSelected()) {
                                        String kodeGejala = checkBox.getActionCommand();
                                        kode += "kode_gejala LIKE '%" + kodeGejala + "%' AND ";
                                          System.out.println(kode);
                                    }
                                }
                            }
                        }
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
                                // Set teks pencegahan dengan line wrap menggunakan HTML
                                String pencegahanText = "<html>" + data[3].replace("\n", "<br>") + "</html>";
                                pencegahan.setText(pencegahanText);
                                obat.setText(data[4]);
                                jTabbedPane1.setSelectedIndex(index);
                                refreshCheckbox(panelDataPertanyaan);
                                
                          } else {
                              JOptionPane.showMessageDialog(null, "Tidak ada penyakit yang sesuai dengan gejala yang dipilih.");
                          }

                      rs.close();
                  } else {
                      JOptionPane.showMessageDialog(null, "Silakan pilih setidaknya satu gejala.");
                  }

                  conn.close();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.out.println("Error: " + ex.getMessage());
                System.out.println("Eror Diagnosa Penyakit");
            }
      }     
            
      private String autoNumber() {
         String idKonsultasi = "K01";
           try {
               Connection conn = new ConnectionDb().connect();
               Statement st = conn.createStatement();
               String query = "SELECT id_konsultasi FROM tbl_hasil_diagnosa ORDER BY id_konsultasi DESC LIMIT 1";
               ResultSet rs = st.executeQuery(query);

               if (rs.next()) {
                   idKonsultasi = rs.getString("id_konsultasi");
                   int kode = Integer.parseInt(idKonsultasi.substring(1)) + 1;
                   idKonsultasi = String.format("K%02d", kode);
               }

               conn.close();
               rs.close();
           } catch (Exception ex) {
               System.out.println(ex.getMessage());
           }
           return idKonsultasi;
      }

      public void simpanHasilKonsultasi (String id, JLabel kodePenyakit) {
            
            String idKonsultasi = autoNumber();
            
            try {
                 
                  Connection conn = new ConnectionDb().connect();
                  String query = "INSERT INTO tbl_hasil_diagnosa VALUES (?,?,?,NOW())";
                  PreparedStatement st = conn.prepareStatement(query);
                               
                        st.setString(1, id);
                        st.setString(2, idKonsultasi);                        
                        st.setString(3, kodePenyakit.getText());
                        st.executeUpdate();
                        
                  JOptionPane.showMessageDialog(null, "Data Konsultasi Berhasil Disimpan");
                  conn.close();
                  st.close();
            }catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage());
                  
            } 
      }
}