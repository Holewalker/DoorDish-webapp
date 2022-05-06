import com.svalero.restaurant.domain.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

 class TestOrder {
    String id="1";
    String id_dish="2";
    String id_restaurant="3";
Order order= new Order(id, id_dish, id_restaurant);
    @Test
     void orderGenerationTest1() {
        boolean res;
        res = Objects.equals(order.getIdDish(), id_dish);
        Assertions.assertTrue(res);
    }

    @Test
     void orderGenerationTest2() {
        boolean res;
        res = Objects.equals(order.getIdRestaurant(), id_restaurant);
        Assertions.assertTrue(res);
    }
    @Test
     void orderGenerationTest3() {
        boolean res;
        res = Objects.equals(order.getId(), id);
        Assertions.assertTrue(res);
    }

}
