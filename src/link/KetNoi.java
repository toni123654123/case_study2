package link;

import model.User;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KetNoi {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = LienKet.getJDBC();
        String sql = "SELECT ID, NAME, GENDER, PHONE, EMAIL, CLASS, MAJOR, SCORE FROM user  ";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
//                user.setCode(rs.getString("CODE"));
                user.setName(rs.getString("NAME"));
                user.setGender(rs.getString("GENDER"));
                user.setPhone(rs.getInt("PHONE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setClasss(rs.getString("CLASS"));
                user.setMajor(rs.getString("MAJOR"));
                user.setScore(rs.getDouble("SCORE"));

                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public static User getUserById(int id) {

        Connection connection = LienKet.getJDBC();
        String sql = "SELECT ID, NAME, GENDER, PHONE, EMAIL, CLASS, MAJOR, SCORE FROM user WHERE ID = ?";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
//                user.setCode(rs.getString("CODE"));
                user.setName(rs.getString("NAME"));
                user.setGender(rs.getString("GENDER"));
                user.setPhone(rs.getInt("PHONE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setClasss(rs.getString("CLASS"));
                user.setMajor(rs.getString("MAJOR"));
                user.setScore(rs.getDouble("SCORE"));

                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public static void addUser(User user) {
        Connection connection = LienKet.getJDBC();
        String sql = "INSERT INTO user (ID ,NAME , GENDER, PHONE, EMAIL, CLASS, MAJOR, SCORE) VALUE (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(2, user.getCode());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setInt(4, user.getPhone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getClasss());
            preparedStatement.setString(7, user.getMajor());
            preparedStatement.setDouble(8, user.getScore());
            preparedStatement.setInt(1, user.getId());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        }catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public void updateUser(User user) {
        Connection connection = LienKet.getJDBC();
        String sql = "UPDATE  user SET   NAME = ?, GENDER = ? ,PHONE = ?, EMAIL = ?, CLASS = ?, MAJOR = ?, SCORE = ? WHERE ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

//            preparedStatement.setString(1, user.getCode());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setInt(3, user.getPhone());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getClasss());
            preparedStatement.setString(6, user.getMajor());
            preparedStatement.setDouble(7, user.getScore());
            preparedStatement.setInt(8,user.getId());

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
    public List<User> getSortScore() {
        List<User> users = new ArrayList<>();
        Connection connection = LienKet.getJDBC();
        String sql = "SELECT ID, NAME, GENDER, PHONE, EMAIL, CLASS, MAJOR, SCORE FROM user ORDER BY SCORE DESC";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
//                user.setCode(rs.getString("CODE"));
                user.setName(rs.getString("NAME"));
                user.setGender(rs.getString("GENDER"));
                user.setPhone(rs.getInt("PHONE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setClasss(rs.getString("CLASS"));
                user.setMajor(rs.getString("MAJOR"));
                user.setScore(rs.getDouble("SCORE"));

                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return users;
    }
    public List<User> getSortClasss() {
        List<User> users = new ArrayList<>();
        Connection connection = LienKet.getJDBC();
        String sql = "SELECT ID, NAME, GENDER, PHONE, EMAIL, CLASS, MAJOR, SCORE FROM user ORDER BY CLASS ASC ";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
//                user.setCode(rs.getString("CODE"));
                user.setName(rs.getString("NAME"));
                user.setGender(rs.getString("GENDER"));
                user.setPhone(rs.getInt("PHONE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setClasss(rs.getString("CLASS"));
                user.setMajor(rs.getString("MAJOR"));
                user.setScore(rs.getDouble("SCORE"));

                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
    public List<User> searchUser(String name){
        List<User> users = new ArrayList<>();
        Connection connection = LienKet.getJDBC();
        String sql = "SELECT ID, NAME, GENDER, PHONE, EMAIL, CLASS, MAJOR, SCORE FROM user WHERE NAME LIKE '%"+name+"%'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("NAME"));
                user.setGender(rs.getString("GENDER"));
                user.setPhone(rs.getInt("PHONE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setClasss(rs.getString("CLASS"));
                user.setMajor(rs.getString("MAJOR"));
                user.setScore(rs.getDouble("SCORE"));

                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
    public List<User> getSort3() {
        List<User> users = new ArrayList<>();
        Connection connection = LienKet.getJDBC();
        String sql = "SELECT * FROM user ORDER BY SCORE DESC LIMIT 3 ";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
//                user.setCode(rs.getString("CODE"));
                user.setName(rs.getString("NAME"));
                user.setGender(rs.getString("GENDER"));
                user.setPhone(rs.getInt("PHONE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setClasss(rs.getString("CLASS"));
                user.setMajor(rs.getString("MAJOR"));
                user.setScore(rs.getDouble("SCORE"));

                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}

