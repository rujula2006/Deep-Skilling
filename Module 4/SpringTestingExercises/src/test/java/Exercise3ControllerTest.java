import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class User3 {

    private Long id;
    private String name;

    public User3(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface UserService3 {

    User3 getUserById(Long id);
}

class UserController3 {

    private UserService3 service;

    public UserController3(UserService3 service) {
        this.service = service;
    }

    public User3 getUser(Long id) {
        return service.getUserById(id);
    }
}

public class Exercise3ControllerTest {

    @Test
    void testGetUser() {

        UserService3 mockService =
                mock(UserService3.class);

        when(mockService.getUserById(1L))
                .thenReturn(
                        new User3(1L, "Rujula")
                );

        UserController3 controller =
                new UserController3(mockService);

        User3 result =
                controller.getUser(1L);

        assertEquals(
                "Rujula",
                result.getName()
        );
    }
}