import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class User2 {

    private String name;

    public User2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface UserRepository2 {
    User2 findById(Long id);
}

class UserService2 {

    private UserRepository2 repository;

    public UserService2(UserRepository2 repository) {
        this.repository = repository;
    }

    public User2 getUserById(Long id) {
        return repository.findById(id);
    }
}

public class Exercise2RepositoryMockitoTest {

    @Test
    void testService() {

        UserRepository2 repository =
                mock(UserRepository2.class);

        when(repository.findById(1L))
                .thenReturn(
                        new User2("Rujula")
                );

        UserService2 service =
                new UserService2(repository);

        User2 result =
                service.getUserById(1L);

        assertEquals(
                "Rujula",
                result.getName()
        );
    }
}
