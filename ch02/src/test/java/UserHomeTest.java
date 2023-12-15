import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UserHomeTest {
    @Test
    void getUserHomePath() {
       String userHomePath = System.getProperty("user.home");
       System.out.println(userHomePath);
        Assertions.assertNotNull(userHomePath);
    }
}
