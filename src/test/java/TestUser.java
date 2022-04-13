
import com.svalero.restaurant.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class TestUser {
    String name = "Daniel";
    String username = "holewalker";
    String role = "dev";

    User user = new User(name, username, "pwd", role);

    @Test
    public void dishGenerationTest1() {
        boolean res;
        if (Objects.equals(user.getName(), name)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }

    @Test
    public void dishGenerationTest2() {
        boolean res;
        if (Objects.equals(user.getUsername(), username)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }

    @Test
    public void dishGenerationTest3() {
        boolean res;
        if (Objects.equals(user.getRole(), role)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }

}
