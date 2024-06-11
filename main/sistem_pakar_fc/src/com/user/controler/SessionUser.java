package com.user.controler;

public class SessionUser {
    private static String log_idPengguna;
    private static String log_nama;
    private static String log_namaPengguna;
    private static String log_passWord;
    
    public static void setLoggedInUser(String idPengguna, String nama, String namaPengguna, String passWord) {
        log_idPengguna = idPengguna;
        log_nama = nama;
        log_namaPengguna = namaPengguna;
        log_passWord = passWord;
    }

    public static String log_idPengguna() {
        return log_idPengguna;
    }

    public static String log_nama() {
        return log_nama;
    }
    
    public static String log_namaPengguna() {
        return log_namaPengguna;
    }
    
    public static String log_passWord() {
        return log_passWord;
    }
    
}
