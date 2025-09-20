/**
 * © 2025 Ramsha Anwar. All rights reserved.
 *
 * Licensed under the MIT License.
 * You may obtain a copy of the License at
 *
 *     https://opensource.org/licenses/MIT
 */
package com.ramsha.userInterface;

import javax.swing.*;
import com.ramsha.calculator.Calculator;
import java.awt.event.*;
 
/**
 * A simple GUI-based calculator built with Java Swing.
 * <p>
 * Supports basic operations (+, -, *, /, %), square root, decimal input,
 * clear, and backspace. Uses the {@code Calculator} class for performing
 * calculations. Implements {@link ActionListener} to handle button events.
 * </p>
 */
public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField display;
    private Calculator logic = new Calculator(null);
/**
 * Constructs the Calculator GUI window.
 * <p>
 * Initializes the main frame with a fixed size, title, and layout.
 * Creates the display text field and adds all calculator buttons
 * (digits, operators, clear, backspace, square root, decimal, equals).
 * </p>
 */    
public CalculatorGUI() {
        setTitle("Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

       
        display = new JTextField();
        display.setBounds(30, 30, 320, 40);
        display.setEditable(false);
        add(display);

        String[] labels = {
            "√", "%", "C", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "=", "←"
        };

        int x = 30, y = 90;
        for (int i = 0; i < labels.length; i++) {
            JButton btn = new JButton(labels[i]);
            btn.setBounds(x, y, 70, 50);
            btn.addActionListener(this);
            add(btn);

            x += 80;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 60;
            }
        }
    }
/**
 * Handles button click events for the calculator.
 * <p>
 * Determines the button text and performs the corresponding action:
 * <ul>
 *   <li>"C" → clears the display</li>
 *   <li>"←" → deletes the last character (backspace)</li>
 *   <li>"=" → evaluates the current expression</li>
 *   <li>"√" → calculates the square root of the displayed number</li>
 *   <li>Operators (+, -, *, /, %) → appends an operator to the expression</li>
 *   <li>"." → adds a decimal point</li>
 *   <li>Digits → appends the digit to the expression</li>
 * </ul>
 * </p>
 *
 * @param e the ActionEvent triggered by the button click
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = ((JButton) e.getSource()).getText();

        switch (input) {
            case "C" -> display.setText("");
            case "←" -> backspace();
            case "=" -> calculateResult();
            case "√" -> squareRoot();
            case "+", "-", "*", "/", "%" -> addOperator(input);
            case "." -> addDecimal();
            default -> display.setText(display.getText() + input);
        }
    }
/**
 * Removes the last character from the display text, 
 * if the display is not empty.
 */
    private void backspace() {
        String text = display.getText();
        if (!text.isEmpty()) {
            display.setText(text.substring(0, text.length() - 1));
        }
    }
/**
 * Appends an operator to the display text if the display 
 * is not empty and does not already end with another operator.
 *
 * @param op the operator symbol to add (+, -, *, /, %)
 */
    private void addOperator(String op) {
        String text = display.getText();
        if (!text.isEmpty() && !endsWithOperator(text)) {
            display.setText(text + op);
        }
    }
/**
 * Adds a decimal point to the display text 
 * if the current text does not already end with one.
 */
    private void addDecimal() {
        String text = display.getText();
        if (!text.endsWith(".")) {
            display.setText(text + ".");
        }
    }
/**
 * Calculates and displays the square root of the current value.
 * <p>
 * Attempts to parse the number from the display and computes its 
 * square root using the Calculator logic. If parsing fails or an 
 * error occurs, displays "Error".
 * </p>
 */
    private void squareRoot() {
        try {
            double value = Double.parseDouble(display.getText());
            display.setText(String.valueOf(logic.squareRoot(value)));
        } catch (Exception e) {
            display.setText("Error");
        }
    }
/**
 * Evaluates the arithmetic expression in the display and shows the result.
 * <p>
 * Parses the current display text to identify the first operator 
 * (+, -, *, /, %). Splits the expression into two operands and 
 * delegates the calculation to the {@code Calculator} logic class.
 * </p>
 * <p>
 * If the expression is valid, the result is displayed. 
 * If no valid operator is found, displays "Invalid". 
 * If parsing or calculation fails, displays "Error".
 * </p>
 */
    private void calculateResult() {
        try {
            String text = display.getText();
            char[] ops = { '+', '-', '*', '/', '%' };
            for (char op : ops) {
                int idx = text.indexOf(op);
                if (idx > 0) {
                    double a = Double.parseDouble(text.substring(0, idx));
                    double b = Double.parseDouble(text.substring(idx + 1));
                    double result = logic.calculate(a, b, op);
                    display.setText(String.valueOf(result));
                    return;
                }
            }
            display.setText("Invalid");
        } catch (Exception e) {
            display.setText("Error");
        }
    }
/**
 * Checks if the given text ends with a mathematical operator.
 *
 * @param text the string to check
 * @return true if the text ends with +, -, *, /, or %; false otherwise
 */
    private boolean endsWithOperator(String text) {
        return text.endsWith("+") || text.endsWith("-") || text.endsWith("*")
            || text.endsWith("/") || text.endsWith("%");
    }
/**
 * The entry point of the program.
 * <p>
 * Launches the Calculator GUI on the Event Dispatch Thread (EDT) 
 * using {@link SwingUtilities#invokeLater(Runnable)} to ensure 
 * thread-safe GUI creation.
 * </p>
 *
 * @param args command-line arguments (not used)
 */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI().setVisible(true));
    }
}

