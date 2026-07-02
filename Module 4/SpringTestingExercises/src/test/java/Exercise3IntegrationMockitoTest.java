import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserC {

    private String name;

    public UserC(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface UserServiceC {
    UserC getUserById(Long id);
}

class UserControllerC {

    private UserServiceC service;

    public UserControllerC(UserServiceC service) {
        this.service = service;
    }

    public UserC getUser(Long id) {
        return service.getUserById(id);
    }
}

public class Exercise3IntegrationMockitoTest {

    @Test
    void testIntegration() {

        UserServiceC service =
                mock(UserServiceC.class);

        when(service.getUserById(1L))
                .thenReturn(
                        new UserC("Rujula")
                );

        UserControllerC controller =
                new UserControllerC(service);

        UserC result =
                controller.getUser(1L);

        assertEquals(
                "Rujula",
                result.getName()
        );
    }
}