package calculator;

public class PrinterUser {
    private final Printer printer;
    private final CalculatorLogic logic;

    public PrinterUser(Printer printer) {
        this.printer = printer;
        this.logic = new CalculatorLogic();
    }

    public void calculateAndPrint(double a, double b, char operator) {
        double result = logic.calculate(a, b, operator);
        printer.print("The result is: " + result);
    }
}
