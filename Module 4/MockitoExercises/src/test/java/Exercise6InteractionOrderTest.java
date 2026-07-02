import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

interface ApiService {
    void firstMethod();
    void secondMethod();
}

public class Exercise6InteractionOrderTest {

    @Test
    void testInteractionOrder() {

        ApiService mockApi =
                mock(ApiService.class);

        mockApi.firstMethod();
        mockApi.secondMethod();

        InOrder inOrder =
                inOrder(mockApi);

        inOrder.verify(mockApi)
                .firstMethod();

        inOrder.verify(mockApi)
                .secondMethod();
    }
}
