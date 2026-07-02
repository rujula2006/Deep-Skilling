import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise4ExceptionTest {

    @Test
    void testException(){

        ArithmeticException exception =
                assertThrows(
                        ArithmeticException.class,
                        () -> {
                            throw new ArithmeticException("Divide by Zero");
                        });

        assertEquals(
                "Divide by Zero",
                exception.getMessage()
        );
    }
}
