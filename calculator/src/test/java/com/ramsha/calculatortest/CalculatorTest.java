/**
 * © 2025 Ramsha Anwar. All rights reserved.
 *
 * Licensed under the MIT License.
 * You may obtain a copy of the License at
 *
 *     https://opensource.org/licenses/MIT
 */

package com.ramsha.calculatortest;

import com.ramsha.calculator.Calculator;
import com.ramsha.printer.Printer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the {@link com.ramsha.calculator.Calculator} class.
 *
 * © 2025 Ramsha Anwar. All rights reserved.
 */
public class CalculatorTest {

    Fixture fixture = new Fixture();

    /**
     * Tests addition of two numbers.
     * Verifies the result and the printed output.
     */
    @Test
    public void testAddition() {
        fixture.givenTwoNumbers(2, 3);
        fixture.whenAdditionIsCalled();
        fixture.thenTheAnswerIs(5);
        fixture.thenResultIsPrinted("The result is: 5.0");
    }

    /**
     * Tests division of two numbers.
     * Verifies the result and the printed output.
     */
    @Test
    public void testDivision() {
        fixture.givenTwoNumbers(10, 2);
        fixture.whenDivisionIsCalled();
        fixture.thenTheAnswerIs(5);
        fixture.thenResultIsPrinted("The result is: 5.0");
    }

    /**
     * Tests division by zero.
     * Expects an {@link ArithmeticException} to be thrown.
     */
    @Test
    public void testDivisionByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            fixture.givenTwoNumbers(10, 0);
            fixture.whenDivisionIsCalled();
        });
    }

    /**
     * Tests modulo operation between two numbers.
     * Verifies the result and the printed output.
     */
    @Test
    public void testModulo() {
        fixture.givenTwoNumbers(10, 3);
        fixture.whenModuloIsCalled();
        fixture.thenTheAnswerIs(1);
        fixture.thenResultIsPrinted("The result is: 1.0");
    }

    /**
     * Tests square root of a positive number.
     * Verifies the result and the printed output.
     */
    @Test
    public void testSquareRoot() {
        fixture.givenOneNumber(16);
        fixture.whenSquareRootIsCalled();
        fixture.thenTheAnswerIs(4);
        fixture.thenResultIsPrinted("The result is: 4.0");
    }

    /**
     * Tests square root of a negative number.
     * Expects an {@link ArithmeticException} to be thrown.
     */
    @Test
    public void testSquareRootOfNegative() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            fixture.givenOneNumber(-9);
            fixture.whenSquareRootIsCalled();
        });
    }

    /**
     * Fixture inner class used for Given–When–Then style testing.
     * Provides helper methods to set inputs, invoke operations, and verify outputs.
     */
    class Fixture {
        Printer mockPrinter = mock(Printer.class);
        Calculator calculator = new Calculator(mockPrinter);
        double first, second, result;

        /**
         * Sets two numbers for the test.
         * @param a first number
         * @param b second number
         */
        void givenTwoNumbers(double a, double b) {
            this.first = a;
            this.second = b;
        }

        /**
         * Sets a single number for the test.
         * @param a the number to set
         */
        void givenOneNumber(double a) {
            this.first = a;
        }

        /**
         * Calls the add method of {@link Calculator}.
         */
        void whenAdditionIsCalled() {
            result = calculator.add(first, second);
        }

        /**
         * Calls the divide method of {@link Calculator}.
         */
        void whenDivisionIsCalled() {
            result = calculator.divide(first, second);
        }

        /**
         * Calls the modulo method of {@link Calculator}.
         */
        void whenModuloIsCalled() {
            result = calculator.modulo(first, second);
        }

        /**
         * Calls the squareRoot method of {@link Calculator}.
         */
        void whenSquareRootIsCalled() {
            result = calculator.squareRoot(first);
        }

        /**
         * Verifies the calculated answer matches the expected result.
         * @param expected expected numerical result
         */
        void thenTheAnswerIs(double expected) {
            assertEquals(expected, result, 0.0001);
        }

        /**
         * Verifies the expected result was printed by the printer.
         * @param expectedMessage the message expected to be printed
         */
        void thenResultIsPrinted(String expectedMessage) {
            verify(mockPrinter).print(expectedMessage);
        }
    }
}
