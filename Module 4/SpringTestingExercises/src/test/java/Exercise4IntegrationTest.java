import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class User4 {

    private Long id;
    private String name;

    public User4(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class UserRepository4 {

    public User4 findById(Long id) {
        return new User4(1L, "Rujula");
    }
}

class UserService4 {

    private UserRepository4 repository;

    public UserService4(UserRepository4 repository) {
        this.repository = repository;
    }

    public User4 getUser(Long id) {
        return repository.findById(id);
    }
}

class UserController4 {

    private UserService4 service;

    public UserController4(UserService4 service) {
        this.service = service;
    }

    public User4 getUser(Long id) {
        return service.getUser(id);
    }
}

public class Exercise4IntegrationTest {

    @Test
    void testFullFlow() {

        UserRepository4 repository =
                new UserRepository4();

        UserService4 service =
                new UserService4(repository);

        UserController4 controller =
                new UserController4(service);

        User4 result =
                controller.getUser(1L);

        assertEquals(
                "Rujula",
                result.getName()
        );
    }
}