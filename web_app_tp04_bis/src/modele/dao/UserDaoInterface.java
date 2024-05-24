package modele.dao;

import java.util.List;

import modele.domaine.User;

public interface UserDaoInterface {
    User getUserById(int userId);
    List<User> getAllUsers();
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
}
