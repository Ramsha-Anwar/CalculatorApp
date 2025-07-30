package calculator;
// for Calculator GUI 
import javax.swing.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame implements ActionListener {

    private JTextField display;
    private CalculatorLogic logic = new CalculatorLogic();

    public CalculatorApp() {
        setTitle("Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Display field
        display = new JTextField();
        display.setBounds(30, 30, 320, 40);
        display.setEditable(false);
        add(display);

        // Buttons
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

    private void backspace() {
        String text = display.getText();
        if (!text.isEmpty()) {
            display.setText(text.substring(0, text.length() - 1));
        }
    }

    private void addOperator(String op) {
        String text = display.getText();
        if (!text.isEmpty() && !endsWithOperator(text)) {
            display.setText(text + op);
        }
    }

    private void addDecimal() {
        String text = display.getText();
        if (!text.endsWith(".")) {
            display.setText(text + ".");
        }
    }

    private void squareRoot() {
        try {
            double value = Double.parseDouble(display.getText());
            display.setText(String.valueOf(logic.squareRoot(value)));
        } catch (Exception e) {
            display.setText("Error");
        }
    }

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

    private boolean endsWithOperator(String text) {
        return text.endsWith("+") || text.endsWith("-") || text.endsWith("*")
            || text.endsWith("/") || text.endsWith("%");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorApp().setVisible(true));
    }
}
