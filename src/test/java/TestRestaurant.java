import com.svalero.restaurant.domain.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

 class TestRestaurant {
    String name = "TestRestaurante";
    String nation = "TestNacion";
    String stars = "5";
    Restaurant restaurant = new Restaurant(name, nation, stars);

    @Test
     void restaurantGenerationTest1() {
        boolean res;
        res = Objects.equals(restaurant.getName(), name);
        Assertions.assertTrue(res);
    }
    @Test
     void restaurantGenerationTest2() {
        boolean res;
        res = Objects.equals(restaurant.getNation(), nation);
        Assertions.assertTrue(res);
    }
    @Test
     void restaurantGenerationTest3() {
        boolean res;
        res = Objects.equals(restaurant.getStars(), stars);
        Assertions.assertTrue(res);
    }

}
