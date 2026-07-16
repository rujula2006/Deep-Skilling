import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise5TimeoutTest {

    @Test
    void testTimeout(){

        assertTimeout(
                Duration.ofSeconds(2),
                () -> {

                    Thread.sleep(1000);

                });
    }
}
