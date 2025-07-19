
    public class CalculatorLogic {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) return Double.NaN;
        return a / b;
    }

    public double modulo(double a, double b) {
        return a % b;
    }

    public double squareRoot(double a) {
        if (a < 0) throw new ArithmeticException("Square root of negative");
        return Math.sqrt(a);
    }
    public double calculate(double a, double b, char operator) {
    switch (operator) {
        case '+': return add(a, b);
        case '-': return subtract(a, b);
        case '*': return multiply(a, b);
        case '/': return divide(a, b);
        case '%': return modulo(a, b);
        default: throw new IllegalArgumentException("Invalid operator: " + operator);
    }
}
}

