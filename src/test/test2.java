package test;

import java.sql.*;

public class test2 {

    private static String DB_URL = "jdbc:mysql://localhost:3306/hello";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    private static String EMAIL = "";

    public static void main(String args[]) {
        try {

            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD, EMAIL);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from user");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3) + "  " + rs.getString(4));
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(String dbURL, String userName, String password, String email) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, email);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;

    }
}
