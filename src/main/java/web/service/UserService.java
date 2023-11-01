package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void deleteUserById(int id);

    void updateUserById(int id, User user);

    User getUserById(int id);

    void addUser(User user);
}
