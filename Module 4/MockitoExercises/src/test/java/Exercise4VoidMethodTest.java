import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

interface LoggerService {
    void log(String message);
}

public class Exercise4VoidMethodTest {

    @Test
    void testVoidMethod() {

        LoggerService mockLogger =
                mock(LoggerService.class);

        doNothing()
                .when(mockLogger)
                .log(anyString());

        mockLogger.log("Hello");

        verify(mockLogger)
                .log("Hello");
    }
}
