import com.svalero.restaurant.domain.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class TestRestaurant {
    String name = "TestRestaurante";
    String nation = "TestNacion";
    String stars = "5";
    Restaurant restaurant = new Restaurant(name, nation, stars);

    @Test
    public void restaurantGenerationTest1() {
        boolean res;
        if (Objects.equals(restaurant.getName(), name)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }
    @Test
    public void restaurantGenerationTest2() {
        boolean res;
        if (Objects.equals(restaurant.getNation(), nation)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }
    @Test
    public void restaurantGenerationTest3() {
        boolean res;
        if (Objects.equals(restaurant.getStars(), stars)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }

}
