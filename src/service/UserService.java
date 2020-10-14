package service;

import link.KetNoi;
import model.User;

import java.util.List;

public class UserService {
    private KetNoi ketNoi;


    public UserService() {
        ketNoi = new KetNoi();
    }

    public List<User> getAllUsers() {
        return ketNoi.getAllUsers();
    }
    public void addUser(User user){
        KetNoi.addUser(user);
    }
    public void deleteUser(int id){
        ketNoi.deleteUser(id);
    }
    public User getUserById(int id){
        return KetNoi.getUserById(id);
    }
    public void updateUser (User user){
        ketNoi.updateUser(user);

    }
    public List<User> getSortScore(){

        return ketNoi.getSortScore();
    }
    public List<User> getSortClass(){

        return ketNoi.getSortClasss();
    }
   public List<User> searchUser(String name){
        return ketNoi.searchUser(name);
   }
    public List<User> getSort3(){

        return ketNoi.getSort3();
    }

}

