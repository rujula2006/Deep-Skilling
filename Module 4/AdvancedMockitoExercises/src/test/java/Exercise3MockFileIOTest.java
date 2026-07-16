import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

interface FileReader3 {
    String read();
}

interface FileWriter3 {
    void write(String data);
}

class FileService3 {

    private FileReader3 reader;
    private FileWriter3 writer;

    public FileService3(
            FileReader3 reader,
            FileWriter3 writer) {

        this.reader = reader;
        this.writer = writer;
    }

    public String processFile() {

        return "Processed " + reader.read();
    }
}

public class Exercise3MockFileIOTest {

    @Test
    void testServiceWithMockFileIO() {

        FileReader3 mockReader =
                mock(FileReader3.class);

        FileWriter3 mockWriter =
                mock(FileWriter3.class);

        when(mockReader.read())
                .thenReturn("Mock File Content");

        FileService3 service =
                new FileService3(
                        mockReader,
                        mockWriter
                );

        String result =
                service.processFile();

        assertEquals(
                "Processed Mock File Content",
                result
        );
    }
}
