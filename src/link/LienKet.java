package link;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LienKet {
    public static Connection getJDBC(){
        final  String url = "jdbc:mysql://localhost:3306/quanly";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        Connection connection = getJDBC();
//        if (connection != null){
//            System.out.println("thanh cong");
//        }else {
//            System.out.println("that bai");
//        }
//    }

}
