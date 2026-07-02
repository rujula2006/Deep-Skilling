import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class User1 {

    private String name;

    public User1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface UserService1 {
    User1 getUserById(Long id);
}

class UserController1 {

    private UserService1 service;

    public UserController1(UserService1 service) {
        this.service = service;
    }

    public User1 getUser(Long id) {
        return service.getUserById(id);
    }
}

public class Exercise1ControllerMockitoTest {

    @Test
    void testController() {

        UserService1 mockService =
                mock(UserService1.class);

        when(mockService.getUserById(1L))
                .thenReturn(
                        new User1("Rujula")
                );

        UserController1 controller =
                new UserController1(mockService);

        User1 result =
                controller.getUser(1L);

        assertEquals(
                "Rujula",
                result.getName()
        );
    }
}
