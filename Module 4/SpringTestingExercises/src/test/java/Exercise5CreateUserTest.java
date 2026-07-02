import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class User5 {

    private String name;

    public User5(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class UserService5 {

    public User5 saveUser(User5 user) {
        return user;
    }
}

class UserController5 {

    private UserService5 service;

    public UserController5(UserService5 service) {
        this.service = service;
    }

    public User5 createUser(User5 user) {
        return service.saveUser(user);
    }
}

public class Exercise5CreateUserTest {

    @Test
    void testCreateUser() {

        UserController5 controller =
                new UserController5(
                        new UserService5()
                );

        User5 user =
                new User5("Rujula");

        User5 result =
                controller.createUser(user);

        assertEquals(
                "Rujula",
                result.getName()
        );
    }
}
