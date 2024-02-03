package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        
        // データベースのURL
        final String URL = "jdbc:postgresql://localhost:5432/tododb";
        // データベースにアクセスするユーザー
        final String USER = "sampleUser";
        // パスワード
        final String PASSWORD = "samplePass";

        Class.forName("org.postgresql.Driver");
        // データベースへ接続する
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;
    }

}
    
