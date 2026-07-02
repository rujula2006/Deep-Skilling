import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

interface ExternalApi2 {
    String getData();
}

class MyService2 {

    private ExternalApi2 api;

    public MyService2(ExternalApi2 api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}

public class Exercise2VerifyInteractionTest {

    @Test
    void testVerifyInteraction() {

        ExternalApi2 mockApi = mock(ExternalApi2.class);

        MyService2 service = new MyService2(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }
}