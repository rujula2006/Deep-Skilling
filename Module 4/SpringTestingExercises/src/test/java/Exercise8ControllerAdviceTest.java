import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandler8 {

    public String handleNotFound(
            NoSuchElementException ex) {

        return "User not found";
    }
}

public class Exercise8ControllerAdviceTest {

    @Test
    void testExceptionHandler() {

        GlobalExceptionHandler8 handler =
                new GlobalExceptionHandler8();

        String result =
                handler.handleNotFound(
                        new NoSuchElementException()
                );

        assertEquals(
                "User not found",
                result
        );
    }
}