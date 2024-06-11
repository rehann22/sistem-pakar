package com.user.controler;

import com.user.main.MainDashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import koneksi.db.ConnectionDb;

public class LoginUser {
      
      public boolean isLogin(String username, String password) {
            boolean x = false;
            String query = "SELECT * FROM tbl_users WHERE username = ? AND password = ?";
            try {
                  Connection conn = new ConnectionDb().connect();
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, username);
                  ps.setString(2, password);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            x = true;
                            SessionUser.setLoggedInUser(rs.getString("id"), rs.getString("nama"), rs.getString("username"), rs.getString("password"));
                              MainDashboard dash = new MainDashboard();
                              dash.setVisible(true);
                        }
                        
                    } catch (Exception ex) {
                          System.out.println("Eror Login");
                    }
                    
            } catch (Exception ex) {
                // Lakukan penanganan eksepsi sesuai kebutuhan, misalnya mencatat dalam log
                ex.printStackTrace();
                  System.out.println("Eror di isLogin");
            }
            return x;
      }

      
}
