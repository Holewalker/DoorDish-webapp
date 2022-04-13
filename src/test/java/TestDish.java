import com.svalero.restaurant.domain.Dish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class TestDish {
    String name = "TestPlato";
    String restaurant = "TestRestaurante";
    String type = "Vegetariano";
    Double price = 10.5;
    Dish dish = new Dish(name, restaurant, type, price);

    @Test
    public void dishGenerationTest1() {
        boolean res;
        if (Objects.equals(dish.getName(), name)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }
    @Test
    public void dishGenerationTest2() {
        boolean res;
        if (Objects.equals(dish.getRestaurant(), restaurant)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }
    @Test
    public void dishGenerationTest3() {
        boolean res;
        if (Objects.equals(dish.getType(), type)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }
    @Test
    public void dishGenerationTest4() {
        boolean res;
        if (Objects.equals(dish.getPrice(), price)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }

}
