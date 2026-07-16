import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

interface PaymentService {
    void processPayment();
}

public class Exercise7VoidExceptionTest {

    @Test
    void testVoidMethodException() {

        PaymentService mockService =
                mock(PaymentService.class);

        doThrow(new RuntimeException("Payment Failed"))
                .when(mockService)
                .processPayment();

        assertThrows(
                RuntimeException.class,
                mockService::processPayment
        );
    }
}