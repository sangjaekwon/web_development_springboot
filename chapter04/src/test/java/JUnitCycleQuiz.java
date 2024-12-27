import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitCycleQuiz {

    @BeforeEach
    public void beforeEach() {
        System.out.println("Hello!");
    }
    @Test
    public void junitQuiz3() {
        System.out.println("this is the first test.");

    }

    @Test
    public void junitQuiz4() {
        System.out.println("this is the second test.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Bye!");
    }
}
