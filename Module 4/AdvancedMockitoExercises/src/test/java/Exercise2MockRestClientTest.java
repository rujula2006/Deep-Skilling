import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

interface RestClient2 {
    String getResponse();
}

class ApiService2 {

    private RestClient2 client;

    public ApiService2(RestClient2 client) {
        this.client = client;
    }

    public String fetchData() {
        return "Fetched " + client.getResponse();
    }
}

public class Exercise2MockRestClientTest {

    @Test
    void testServiceWithMockRestClient() {

        RestClient2 mockClient =
                mock(RestClient2.class);

        when(mockClient.getResponse())
                .thenReturn("Mock Response");

        ApiService2 service =
                new ApiService2(mockClient);

        String result =
                service.fetchData();

        assertEquals(
                "Fetched Mock Response",
                result
        );
    }
}
