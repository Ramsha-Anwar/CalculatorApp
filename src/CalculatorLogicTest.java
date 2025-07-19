import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorLogicTest {

    CalculatorLogic logic = new CalculatorLogic();

    @Test
    public void testAddition() {
        assertEquals(5.0, logic.calculate(2, 3, '+'));
    }

    @Test
    public void testSubtraction() {
        assertEquals(4.0, logic.calculate(7, 3, '-'));
    }

    @Test
    public void testMultiplication() {
        assertEquals(15.0, logic.calculate(5, 3, '*'));
    }

    @Test
    public void testDivision() {
        assertEquals(2.5, logic.calculate(5, 2, '/'));
    }

    @Test
    public void testDivisionByZero() {
        assertTrue(Double.isNaN(logic.calculate(5, 0, '/')));
    }
}
 
    

