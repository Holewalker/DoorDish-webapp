
import com.svalero.restaurant.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

 class TestUser {
    String name = "Daniel";
    String username = "holewalker";
    String role = "dev";

    User user = new User(name, username, "pwd", role);

    @Test
     void dishGenerationTest1() {
        boolean res;
        res = Objects.equals(user.getName(), name);
        Assertions.assertTrue(res);
    }

    @Test
     void dishGenerationTest2() {
        boolean res;
        res = Objects.equals(user.getUsername(), username);
        Assertions.assertTrue(res);
    }

    @Test
     void dishGenerationTest3() {
        boolean res;
        res = Objects.equals(user.getRole(), role);
        Assertions.assertTrue(res);
    }

}
