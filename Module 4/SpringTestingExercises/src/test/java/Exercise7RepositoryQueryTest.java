import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class User7 {

    private String name;

    public User7(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class UserRepository7 {

    public List<User7> findByName(String name) {

        List<User7> users =
                new ArrayList<>();

        users.add(
                new User7(name)
        );

        return users;
    }
}

public class Exercise7RepositoryQueryTest {

    @Test
    void testFindByName() {

        UserRepository7 repository =
                new UserRepository7();

        List<User7> users =
                repository.findByName("Rujula");

        assertEquals(
                "Rujula",
                users.get(0).getName()
        );
    }
}