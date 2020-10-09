package link;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KetNoi {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = LienKet.getJDBC();
        String sql = "SELECT * FROM user ";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setCode(rs.getString("CODE"));
                user.setName(rs.getString("NAME"));
                user.setGender(rs.getString("GENDER"));
                user.setPhone(rs.getInt("PHONE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setClasss(rs.getString("CLASS"));
                user.setMajor(rs.getString("MAJOR"));
                user.setScore(rs.getInt("SCORE"));

                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public static User getUserById(int id) {

        Connection connection = LienKet.getJDBC();
        String sql = "SELECT * FROM user WHERE ID = ?";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setCode(rs.getString("CODE"));
                user.setName(rs.getString("NAME"));
                user.setGender(rs.getString("GENDER"));
                user.setPhone(rs.getInt("PHONE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setClasss(rs.getString("CLASS"));
                user.setMajor(rs.getString("MAJOR"));
                user.setScore(rs.getInt("SCORE"));

                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public static void addUser(User user) {
        Connection connection = LienKet.getJDBC();
        String sql = "INSERT INTO user (ID, CODE ,NAME , GENDER, PHONE, EMAIL, CLASS, MAJOR, SCORE) VALUE (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, user.getCode());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setInt(5, user.getPhone());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getClasss());
            preparedStatement.setString(8, user.getMajor());
            preparedStatement.setInt(9, user.getScore());
            preparedStatement.setInt(1, user.getId());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateUser(User user) {
        Connection connection = LienKet.getJDBC();
        String sql = "UPDATE  user SET  CODE = ?, NAME = ?, GENDER = ? ,PHONE = ?, EMAIL = ?, CLASS = ?, MAJOR = ?, SCORE = ? WHERE ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getCode());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setInt(4, user.getPhone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getClasss());
            preparedStatement.setString(7, user.getMajor());
            preparedStatement.setInt(8, user.getScore());
            preparedStatement.setInt(9,user.getId());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void deleteUser(int id) {
        Connection connection = LienKet.getJDBC();

        String sql = "delete FROM user where ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
