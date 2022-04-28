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
        if (Objects.equals(order.getId_dish(), id_dish)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }

    @Test
    public void orderGenerationTest2() {
        boolean res;
        if (Objects.equals(order.getId_restaurant(), id_restaurant)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }
    @Test
    public void orderGenerationTest3() {
        boolean res;
        if (Objects.equals(order.getId(), id)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }

}
