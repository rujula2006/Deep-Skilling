import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class Exercise3ExecutionOrderTest {

    @Test
    @Order(1)
    void first(){

        System.out.println("First");
    }

    @Test
    @Order(2)
    void second(){

        System.out.println("Second");
    }

    @Test
    @Order(3)
    void third(){

        System.out.println("Third");
    }
}
