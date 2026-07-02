import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

interface Repository5 {
    String getData();
}

class Service5 {

    private Repository5 repository;

    public Service5(
            Repository5 repository) {

        this.repository = repository;
    }

    public String processData() {

        return "Processed "
                + repository.getData();
    }
}

public class Exercise5MultipleReturnValuesTest {

    @Test
    void testServiceWithMultipleReturnValues() {

        Repository5 repository =
                mock(Repository5.class);

        when(repository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        Service5 service =
                new Service5(repository);

        String first =
                service.processData();

        String second =
                service.processData();

        assertEquals(
                "Processed First Mock Data",
                first
        );

        assertEquals(
                "Processed Second Mock Data",
                second
        );
    }
}
