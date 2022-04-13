import com.svalero.restaurant.domain.Order;
import com.svalero.restaurant.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

public class TestOrder {
    String code = "1234";
    Boolean paid = true ;
    LocalDate date = LocalDate.now();
    User user = new User();
    Order order = new Order(code, paid, date, user);

    @Test
    public void orderGenerationTest1() {
        boolean res;
        if (Objects.equals(order.getCode(), code)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }
    @Test
    public void orderGenerationTest2() {
        boolean res;
        if (Objects.equals(order.isPaid(), paid)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }
    @Test
    public void orderGenerationTest3() {
        boolean res;
        if (Objects.equals(order.getDate(), date)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }
    @Test
    public void orderGenerationTest4() {
        boolean res;
        if (Objects.equals(order.getUser(), user)) {
            res = true;
        } else
            res = false;
        Assertions.assertTrue(res);
    }

}
