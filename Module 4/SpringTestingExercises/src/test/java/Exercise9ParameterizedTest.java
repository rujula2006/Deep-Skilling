import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise9ParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "4,6,10",
            "1,1,2"
    })
    void testAddition(
            int a,
            int b,
            int expected) {

        assertEquals(
                expected,
                a + b
        );
    }
}