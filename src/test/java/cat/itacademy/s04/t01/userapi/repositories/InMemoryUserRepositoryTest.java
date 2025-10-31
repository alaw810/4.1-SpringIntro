package cat.itacademy.s04.t01.userapi.repositories;

import cat.itacademy.s04.t01.userapi.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
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

    @Test
    void findById_shouldReturnUserIfExists() {
        UUID id = UUID.randomUUID();
        User user = new User(id, "Alan Turing", "alan@example.com");
        repository.save(user);

        Optional<User> result = repository.findById(id);

        assertTrue(result.isPresent());
        assertEquals("Alan Turing", result.get().name());
    }

    @Test
    void findById_shouldReturnEmptyIfNotExists() {
        Optional<User> result = repository.findById(UUID.randomUUID());
        assertTrue(result.isEmpty());
    }

    @Test
    void searchByName_shouldReturnMatchingUsers() {
        repository.save(new User(UUID.randomUUID(), "John Doe", "john@example.com"));
        repository.save(new User(UUID.randomUUID(), "Jane Doe", "jane@example.com"));

        List<User> result = repository.searchByName("john");

        assertEquals(1, result.size());
        assertEquals("John Doe", result.getFirst().name());
    }

    @Test
    void existsByEmail_shouldReturnTrueIfEmailExists() {
        repository.save(new User(UUID.randomUUID(), "Ada Lovelace", "ada@example.com"));
        assertTrue(repository.existsByEmail("ada@example.com"));
    }

}
