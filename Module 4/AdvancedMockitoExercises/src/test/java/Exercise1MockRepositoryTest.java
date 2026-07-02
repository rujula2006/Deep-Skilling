import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

interface Repository1 {
    String getData();
}

class Service1 {

    private Repository1 repository;

    public Service1(Repository1 repository) {
        this.repository = repository;
    }

    public String processData() {
        return "Processed " + repository.getData();
    }
}

public class Exercise1MockRepositoryTest {

    @Test
    void testServiceWithMockRepository() {

        Repository1 mockRepository =
                mock(Repository1.class);

        when(mockRepository.getData())
                .thenReturn("Mock Data");

        Service1 service =
                new Service1(mockRepository);

        String result =
                service.processData();

        assertEquals(
                "Processed Mock Data",
                result
        );
    }
}