package cat.itacademy.s04.t01.userapi.services;

import cat.itacademy.s04.t01.userapi.exceptions.UserNotFoundException;
import cat.itacademy.s04.t01.userapi.models.User;
import cat.itacademy.s04.t01.userapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User userRequest) {
        UUID newId = UUID.randomUUID();
        User newUser = new User(newId, userRequest.name(), userRequest.email());
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getAllUsers(String name) {
        if (name == null || name.isBlank()) {
            return userRepository.findAll();
        }
        return userRepository.searchByName(name);
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
