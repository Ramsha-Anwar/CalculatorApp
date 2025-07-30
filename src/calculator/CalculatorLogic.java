package calculator;

public class CalculatorLogic {

    // Addition
    public double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Division (returns NaN if divided by 0)
    public double divide(double a, double b) {
        if (b == 0) {
            return Double.NaN;
        }
        return a / b;
    }

    // Modulo (remainder)
    public double modulo(double a, double b) {
        return a % b;
    }

    // Square root (throws error if negative input)
    public double squareRoot(double a) {
        if (a < 0) {
            throw new ArithmeticException("Cannot take square root of a negative number");
        }
        return Math.sqrt(a);
    }

    // Central method to perform calculation based on operator
    public double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+': return add(a, b);
            case '-': return subtract(a, b);
            case '*': return multiply(a, b);
            case '/': return divide(a, b);
            case '%': return modulo(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
