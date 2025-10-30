package cat.itacademy.s04.t01.userapi.controllers;

import cat.itacademy.s04.t01.userapi.exceptions.UserNotFoundException;
import cat.itacademy.s04.t01.userapi.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private static final List<User> users = new ArrayList<>();

    @GetMapping("/users")
    public List<User> getAllUsers(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            return users;
        }

        String lowerCaseName = name.toLowerCase();

        return users.stream()
                .filter(u -> u.name().toLowerCase().contains(lowerCaseName))
                .toList();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User userRequest) {

        UUID newId = UUID.randomUUID();

        User newUser = new User(newId, userRequest.name(), userRequest.email());

        users.add(newUser);

        return newUser;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable UUID id) {
    return users.stream()
            .filter(u -> u.id().equals(id))
            .findFirst()
            .orElseThrow(() -> new UserNotFoundException(id));
    }
}
