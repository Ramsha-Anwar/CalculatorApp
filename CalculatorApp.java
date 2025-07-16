import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame implements ActionListener {

    JTextField textField;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    CalculatorApp() {
        setTitle("Calculator");
        setSize(400, 630);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setBounds(30, 40, 330, 40);
        textField.setEditable(false);
        add(textField);

        String[] buttonLabels = {
            "√", "%", "C", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "=", "←"   // Added backspace button
        };

        JButton[] buttons = new JButton[buttonLabels.length];
        int x = 30, y = 100;

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setBounds(x, y, 70, 50);
            buttons[i].addActionListener(this);
            add(buttons[i]);

            x += 80;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 60;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        handleInput(((JButton) e.getSource()).getText());
    }

    public void handleInput(String input) {
        try {
            switch (input) {
                case "C":
                    textField.setText("");
                    num1 = num2 = result = 0;
                    break;

                case "←":  // New case for backspace
                    String currentText = textField.getText();
                    if (!currentText.isEmpty()) {
                        textField.setText(currentText.substring(0, currentText.length() - 1));
                    }
                    break;

                case "=":
                    String expression = textField.getText();
                    char[] ops = { '+', '-', '*', '/', '%' };
                    for (char op : ops) {
                        int idx = expression.indexOf(op);
                        if (idx > 0 && idx < expression.length() - 1) {
                            String part1 = expression.substring(0, idx);
                            String part2 = expression.substring(idx + 1);

                            num1 = Double.parseDouble(part1);
                            num2 = Double.parseDouble(part2);
                            operator = op;

                            switch (operator) {
                                case '+': result = num1 + num2; break;
                                case '-': result = num1 - num2; break;
                                case '*': result = num1 * num2; break;
                                case '/':
                                    if (num2 != 0) result = num1 / num2;
                                    else {
                                        textField.setText("Error: /0");
                                        return;
                                    }
                                    break;
                                case '%': result = num1 % num2; break;
                            }

                            textField.setText(String.valueOf(result));
                            return;
                        }
                    }
                    textField.setText("Invalid");
                    break;

                case "+": case "-": case "*": case "/": case "%":
                    String txt = textField.getText();
                    if (!txt.isEmpty() && !endsWithOperator(txt)) {
                        textField.setText(txt + input);
                    }
                    break;

                case "√":
                    double val = Double.parseDouble(textField.getText());
                    if (val < 0) {
                        textField.setText("Invalid √");
                    } else {
                        result = Math.sqrt(val);
                        textField.setText(String.valueOf(result));
                    }
                    break;

                case ".":
                    String t = textField.getText();
                    if (!t.isEmpty() && !t.endsWith(".") && !hasTwoOperands(t)) {
                        textField.setText(t + ".");
                    }
                    break;

                default: // Digits 0-9
                    textField.setText(textField.getText() + input);
                    break;
            }
        } catch (Exception ex) {
            textField.setText("Error");
        }
    }

    private boolean endsWithOperator(String s) {
        return s.endsWith("+") || s.endsWith("-") || s.endsWith("*") || s.endsWith("/") || s.endsWith("%");
    }

    private boolean hasTwoOperands(String s) {
        return s.contains("+") || s.contains("-") || s.contains("*") || s.contains("/") || s.contains("%");
    }

    public static void main(String[] args) {
        new CalculatorApp().setVisible(true);
    }
}
