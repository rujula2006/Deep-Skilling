import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

interface NetworkClient4 {
    String connect();
}

class NetworkService4 {

    private NetworkClient4 client;

    public NetworkService4(
            NetworkClient4 client) {

        this.client = client;
    }

    public String connectToServer() {

        return "Connected to "
                + client.connect();
    }
}

public class Exercise4MockNetworkTest {

    @Test
    void testServiceWithMockNetworkClient() {

        NetworkClient4 mockClient =
                mock(NetworkClient4.class);

        when(mockClient.connect())
                .thenReturn("Mock Connection");

        NetworkService4 service =
                new NetworkService4(
                        mockClient);

        String result =
                service.connectToServer();

        assertEquals(
                "Connected to Mock Connection",
                result
        );
    }
}
