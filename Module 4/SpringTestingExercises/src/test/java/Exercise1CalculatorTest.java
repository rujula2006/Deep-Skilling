import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorService {

    public int add(int a, int b) {
        return a + b;
    }
}

public class Exercise1CalculatorTest {

    @Test
    void testAdd() {

        CalculatorService service =
                new CalculatorService();

        assertEquals(
                10,
                service.add(4,6)
        );
    }
}
