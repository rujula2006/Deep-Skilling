import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise2ParameterizedLogging {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    Exercise2ParameterizedLogging.class);

    public static void main(String[] args) {

        String name = "Rujula";
        int age = 20;

        logger.info(
                "Name: {}, Age: {}",
                name,
                age
        );
    }
}