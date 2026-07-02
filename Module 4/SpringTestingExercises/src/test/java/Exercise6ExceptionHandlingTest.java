import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserService6 {

    public String getUser(Long id) {

        throw new NoSuchElementException(
                "User not found"
        );
    }
}

public class Exercise6ExceptionHandlingTest {

    @Test
    void testMissingUser() {

        UserService6 service =
                new UserService6();

        assertThrows(
                NoSuchElementException.class,
                () -> service.getUser(100L)
        );
    }
}
