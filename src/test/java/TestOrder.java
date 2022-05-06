import com.svalero.restaurant.domain.Order;
import com.svalero.restaurant.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

public class TestOrder {
    String id="1";
    String id_dish="2";
    String id_restaurant="3";
Order order= new Order(id, id_dish, id_restaurant);
    @Test
    public void orderGenerationTest1() {
        boolean res;
        res = Objects.equals(order.getId_dish(), id_dish);
        Assertions.assertTrue(res);
    }

    @Test
    public void orderGenerationTest2() {
        boolean res;
        res = Objects.equals(order.getId_restaurant(), id_restaurant);
        Assertions.assertTrue(res);
    }
    @Test
    public void orderGenerationTest3() {
        boolean res;
        res = Objects.equals(order.getId(), id);
        Assertions.assertTrue(res);
    }

}
