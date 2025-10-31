package cat.itacademy.s04.t01.userapi.repositories;

import cat.itacademy.s04.t01.userapi.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryUserRepositoryTest {

    private InMemoryUserRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryUserRepository();
    }

    @Test
    void save_and_findAll_shouldStoreUser() {
        User user = new User(UUID.randomUUID(), "Ada Lovelace", "ada@example.com");

        repository.save(user);

        List<User> users = repository.findAll();
        assertEquals(1, users.size());
        assertEquals("Ada Lovelace", users.getFirst().name());
    }



}
