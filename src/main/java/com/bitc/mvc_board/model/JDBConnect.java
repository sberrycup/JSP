package com.bitc.mvc_board.model;

import java.sql.*;

public class JDBConnect {
    protected Connection conn;
    protected Statement stmt;
    protected PreparedStatement psmt;
    protected ResultSet rs;

    private String dbDriver;
    private String dbUrl;
    private String dbUserID;
    private String dbUserPW;


    public JDBConnect() {
        this("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/testdb", "root", "987817");

        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String dbUserID = "root";
        String dbUserPW = "987817";
    }

    public JDBConnect(String driver, String url, String id, String pw) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("***DB Open***");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dbClose() {
        try {
            if (rs != null) {rs.close();}
            if (psmt != null) {psmt.close();}
            if (stmt != null) {stmt.close();}
            if (conn != null) {conn.close();}
            System.out.println("***DB Close***");
        }
        catch (Exception e) {

        }
    }
}
