import com.svalero.restaurant.domain.Dish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class TestDish {
    String name = "TestPlato";
    String restaurant = "TestRestaurante";
    String type = "Vegetariano";
    String price = "10.5";
    Dish dish = new Dish(name, restaurant, type, price);

    @Test
    public void dishGenerationTest1() {
        boolean res;
        res = Objects.equals(dish.getName(), name);
        Assertions.assertTrue(res);
    }
    @Test
    public void dishGenerationTest2() {
        boolean res;
        res = Objects.equals(dish.getRestaurant(), restaurant);
        Assertions.assertTrue(res);
    }
    @Test
    public void dishGenerationTest3() {
        boolean res;
        res = Objects.equals(dish.getType(), type);
        Assertions.assertTrue(res);
    }
    @Test
    public void dishGenerationTest4() {
        boolean res;
        res = Objects.equals(dish.getPrice(), price);
        Assertions.assertTrue(res);
    }

}
