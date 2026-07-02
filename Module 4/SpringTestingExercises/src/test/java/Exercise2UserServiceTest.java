import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class User {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface UserRepository {
    User findById(Long id);
}

class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(Long id) {
        return repository.findById(id);
    }
}

public class Exercise2UserServiceTest {

    @Test
    void testGetUser() {

        UserRepository mockRepository =
                mock(UserRepository.class);

        User user = new User();
        user.setId(1L);
        user.setName("Rujula");

        when(mockRepository.findById(1L))
                .thenReturn(user);

        UserService service =
                new UserService(mockRepository);

        User result =
                service.getUserById(1L);

        assertEquals(
                "Rujula",
                result.getName()
        );
    }
}
