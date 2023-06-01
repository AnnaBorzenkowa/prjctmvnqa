import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.BonusService;

public class BonusServiceTest {

    @Test
    public void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForRegisteredAndOverLimit() {

        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldCalculateForeUnRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForUnRegisteredOverLimit() {

        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForRegisteredBeforeLimit() {

        BonusService service = new BonusService();

        long amount = 30;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForUnRegisteredBeforeLimit() {

        BonusService service = new BonusService();

        long amount = 30;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

}
