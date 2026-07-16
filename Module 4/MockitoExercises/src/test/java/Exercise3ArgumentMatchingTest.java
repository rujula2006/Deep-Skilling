import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

interface UserApi {
    void save(String name);
}

public class Exercise3ArgumentMatchingTest {

    @Test
    void testArgumentMatching() {

        UserApi mockApi = mock(UserApi.class);

        mockApi.save("Rujula");

        verify(mockApi).save(anyString());
    }
}
