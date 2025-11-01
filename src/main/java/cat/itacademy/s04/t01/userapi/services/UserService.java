package cat.itacademy.s04.t01.userapi.services;

import cat.itacademy.s04.t01.userapi.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers(String name);
    User getUserById(UUID id);

}
