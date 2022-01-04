package com.panda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 学习jdbc
 */
public class LearnJdbcMain {
    public static final String URL = "jdbc:mysql://localhost:3306/learn";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        //ConnectionImpl
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        // StatementImpl
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
        while(rs.next()){
            System.out.println(rs.getString("name")+" : "+rs.getInt("num"));
        }
    }
}
