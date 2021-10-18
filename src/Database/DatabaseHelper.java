/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sangt
 */
public class DatabaseHelper {

    private static String user = "sa";
    private static String pass = "111111";
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=";

    public static Connection getConnection(String databaseName) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url + databaseName, user, pass);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conn = getConnection("");
        if (conn == null) {
            System.out.println("fail");
        }
    }
}
