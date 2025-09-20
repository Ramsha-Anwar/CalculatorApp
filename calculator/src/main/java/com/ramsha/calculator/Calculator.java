/**
 * © 2025 Ramsha Anwar. All rights reserved.
 *
 * Licensed under the MIT License.
 * You may obtain a copy of the License at
 *
 *     https://opensource.org/licenses/MIT
 */

package com.ramsha.calculator;

import com.ramsha.printer.Printer;

/**
 * A simple calculator for basic arithmetic operations.
 *
 * © 2025 Ramsha Anwar. All rights reserved.
 */

public class Calculator {

 private Printer printer;

    /**
     * Constructs a new Calculator with the specified printer.
     * @param printer the printer to use for displaying results
     */
    public Calculator(Printer printer) {
        this.printer = printer;
    }

/**
 * Prints the calculation result using the configured printer.
 * @param result the numerical result to be displayed
  */
    private void printResult(double result) {
        if (printer != null) {
            printer.print("The result is: " + result);
        }
    }
/**
 * Adds two numbers and returns the result.
 *
 * @param firstNumber  the first number to add
 * @param secondNumber the second number to add
 * @return the sum of {@code firstNumber} and {@code secondNumber}
 */

    public double add(double firstNumber, double secondNumber)
     {
        double result = firstNumber + secondNumber;
        printResult(result);
        return result;
    }
 
/**
 * Subtracts the second number from the first number and returns the result.
 *
 * @param firstNumber  the first number 
 * @param secondNumber the second number to be subtracted from the first number 
 * @return the difference between {@code firstNumber} and {@code secondNumber}
 */    

    public double subtract(double firstNumber, double secondNumber)
     {
        double result = firstNumber - secondNumber;
        printResult(result);
        return result;
    }

/**
 * Multiplies two numbers and returns the result.
 *
 * @param firstNumber  the first number to multiply
 * @param secondNumber the second number to multiply
 * @return the product of {@code firstNumber} and {@code secondNumber}
 */    

    public double multiply(double firstNumber, double secondNumber) {
        double result = firstNumber *  secondNumber;
        printResult(result);
        return result;
    }

 /**
 * Divides the first number by the second and returns the result.
 *
 * @param firstNumber  the number to be divided
 * @param secondNumber the number to divide by
 * @return the quotient of {@code firstNumber} divided by {@code secondNumber}
 * @throws ArithmeticException if {@code secondNumber} is zero
 */ 

    public double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
             throw new ArithmeticException("Denominator cannot be zero.");
        }
        double result = firstNumber/secondNumber;
        printResult(result);
        return result;
    }

/**
 * Returns the remainder when the first number is divided by the second.
 *
 * @param firstNumber  the number to be divided
 * @param secondNumber the number to divide by
 * @return the remainder of {@code firstNumber} divided by {@code secondNumber}
 * @throws ArithmeticException if {@code secondNumber} is zero
 */

    public double modulo(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Cannot perform modulo with zero as divisor.");
        }
        double result = firstNumber % secondNumber;
        printResult(result);
        return result;
    }

/**
 * Returns the square root of a number.
 *
 * @param firstNumber the number to find the square root of
 * @return the square root of {@code firstNumber}
 * @throws ArithmeticException if {@code firstNumber} is negative
 */

    public double squareRoot(double firstNumber) {
        if (firstNumber < 0) {
            throw new ArithmeticException("Cannot take square root of a negative number");
        }
        double result= Math.sqrt(firstNumber);
        printResult(result);
        return result;    }

/**
 * Performs a calculation on two numbers based on the specified operator.
 * <p>
 * Supported operators:
 * <ul>
 *   <li>{@code '+'} - addition</li>
 *   <li>{@code '-'} - subtraction</li>
 *   <li>{@code '*'} - multiplication</li>
 *   <li>{@code '/'} - division</li>
 *   <li>{@code '%'} - modulo</li>
 * </ul>
 *
 * @param firstNumber  the first number for the calculation
 * @param secondNumber the second number for the calculation
 * @param operator     the operator to apply ({@code +, -, *, /, %})
 * @return the result of the calculation
 * @throws IllegalArgumentException if the operator is invalid
 * @throws ArithmeticException      if division or modulo by zero occurs
 */
    public double calculate(double firstNumber, double secondNumber, char operator) {
        switch (operator) {
            case '+': return add(firstNumber, secondNumber);
            case '-': return subtract(firstNumber, secondNumber);
            case '*': return multiply(firstNumber, secondNumber);
            case '/': return divide(firstNumber, secondNumber);
            case '%': return modulo(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}


