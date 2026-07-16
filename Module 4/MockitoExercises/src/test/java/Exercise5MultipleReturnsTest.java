import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

interface ExternalApi5 {
    String getData();
}

public class Exercise5MultipleReturnsTest {

    @Test
    void testMultipleReturns() {

        ExternalApi5 mockApi =
                mock(ExternalApi5.class);

        when(mockApi.getData())
                .thenReturn("First")
                .thenReturn("Second");

        assertEquals("First", mockApi.getData());

        assertEquals("Second", mockApi.getData());
    }
}