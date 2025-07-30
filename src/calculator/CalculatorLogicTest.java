package calculator;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorLogicTest {

    private final CalculatorLogic logic = new CalculatorLogic();

    @Test
    public void testAddition() {
        assertEquals("Addition failed", 7.0, logic.calculate(2, 5, '+'), 0.0001);
    }

    @Test
    public void testSubtraction() {
        assertEquals("Subtraction failed", 4.0, logic.calculate(7, 3, '-'), 0.0001);
    }

    @Test
    public void testMultiplication() {
        assertEquals("Multiplication failed", 15.0, logic.calculate(5, 3, '*'), 0.0001);
    }

    @Test
    public void testDivision() {
        assertEquals("Division failed", 2.5, logic.calculate(5, 2, '/'), 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        assertTrue("Division by zero should return NaN", Double.isNaN(logic.calculate(5, 0, '/')));
    }

    @Test
    public void testModulo() {
        assertEquals("Modulo failed", 1.0, logic.calculate(10, 3, '%'), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperator() {
        logic.calculate(2, 2, '^');
    }

    @Test(expected = ArithmeticException.class)
    public void testSquareRootOfNegative() {
        logic.squareRoot(-9);
    }

    @Test
    public void testSquareRoot() {
        assertEquals("Square root failed", 3.0, logic.squareRoot(9), 0.0001);
    }
    
    //Create mock printer
    @Test
    public void testPrinterCalledWithCalculatedResult() {

    Printer mockPrinter = mock(Printer.class);

    
    PrinterUser user = new PrinterUser(mockPrinter);

   
    user.calculateAndPrint(6, 7, '*');  // Expected result = 42.0

    //  Verify the mock printer received correct output
    verify(mockPrinter).print("The result is: 42.0");
}

}
