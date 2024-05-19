
package com.user.controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import koneksi.db.ConnectionDb;

public class DebugCode {
      public static void main(String[] args) {

    try {
        Connection conn = new ConnectionDb().connect();
        String query = "SELECT COUNT(*) AS total_data FROM tbl_penyakit";
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery(); // Menghapus parameter query, karena query sudah diatur sebelumnya
        
        String kodePenyakit  = "P";
        if (rs.next()) {
            int totalData = rs.getInt("total_data");
            System.out.println("Total data: " + totalData);  // Debug
            int kode = totalData + 1;
            // kodePenyakit = "P0" + kode;
            kodePenyakit = String.format("P%02d", kode); // Mengubah format String.format()
            System.out.println("kode baru: " + kodePenyakit);  // Debug
        }

        //kodePeny.setText(kodePenyakit);

    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }

}

}
