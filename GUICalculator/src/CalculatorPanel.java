import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The calculator panel
 *
 * @author See Lok Ashley Ho
 */
public class CalculatorPanel extends JPanel implements ButtonConstants {
    private final int CALC_Width = 265;
    private final int CALC_Height = 375;
    private JLabel result;
    private JLabel memory;
    private JLabel calculation;
    private JButton[] buttons;
    private String[] buttonLabels = {
            "MC","MR","M+","M-","MS",
            "%","CE", "C",DELETE,
            RECIPROCAL, X_SQUARED, SQUARE_ROOT, DIVISION,
            "7", "8", "9",MULTIPLICATION,
            "4", "5", "6",SUBTRACTION,
            "1", "2", "3",ADDITION,
            CHANGE_SIGN, "0", DECIMAL, EQUALS,
    };

    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";

    // getters
    public double getNum1() {
        return num1;
    }
    public double getNum2() {
        return num2;
    }
    public String getOperator() {
        return operator;
    }

    // setters
    public void setNum1(double num) {
        num1 = num;
    }
    public void setNum2(double num) {
        num2 = num;
    }
    public void setOperator(String op) {
        operator = op;
    }

    /**
     * Constructor for the Calculator Panel: Sets up the GUI
     */

    public CalculatorPanel() {
        init();
    }

    private void init() {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(CALC_Width, CALC_Height));

        // Display calculator operations
        result = new JLabel("0", JLabel.RIGHT);
        result.setPreferredSize(new Dimension(CALC_Width - 5, 50));
        result.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        result.setFont(new Font("Arial", Font.BOLD, 32));
        result.setBackground(Color.white);
        result.setOpaque(true);
//        result.setBounds(10, 50, CALC_Width - 5, 50);

        // Hold information for current calculation
        calculation = new JLabel("", JLabel.RIGHT);
        calculation.setBackground(Color.lightGray);
        calculation.setFont(new Font("Helvetica", Font.PLAIN, 12));
        calculation.setPreferredSize(new Dimension(CALC_Width - 5, 20));
//        calculation.setBounds(10, 10, CALC_Width - 5, 20);

        // Hold memorize value
        memory = new JLabel("0", JLabel.RIGHT);
        memory.setPreferredSize(new Dimension(CALC_Width-5, 0));
        memory.setBackground(Color.lightGray);
        memory.setFont(new Font("Helvetica", Font.PLAIN, 12));

        initializeButtons();

        // memory panel
        JPanel memoryPanel = createMemoryPanel();

        // calculation panel
        JPanel calcPanel = createCalcPanel();

        add(memory);
        add(calculation);
        add(result);
        add(memoryPanel);
        add(calcPanel);
    }

    private void initializeButtons() {
        buttons = new JButton[29];
        for (int i = 0; i < 29; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Helvetica", Font.PLAIN, 13));
            buttons[i].setPreferredSize(new Dimension(65, 40));
            buttons[i].setForeground(Color.darkGray);
            buttons[i].addActionListener(new ButtonListener());
            // memory buttons
            if (i >= 0 && i < 5) {
                buttons[i].setPreferredSize(new Dimension(48, 30));
                buttons[i].setFont(new Font("Helvetica", Font.PLAIN, 12));
                buttons[i].setBackground(Color.lightGray);
            }
            // "CE" & "C"
            else if (i == 6 || i == 7) {
                buttons[i].setForeground(Color.RED);
            }
            // numeric buttons
            else if (Character.isDigit(buttonLabels[i].charAt(0))) {
                buttons[i].setFont(new Font("Helvetica", Font.BOLD, 13));
            }
            // equal
            else if (i == 28) { // Equals button
                buttons[i].setForeground(new Color(0.13f, 0.55f, 0.13f));
            }
//            buttons[i].addActionListener(new ButtonListener());
        }
    }
    private JPanel createMemoryPanel() {
        JPanel memoryPanel = new JPanel();
        memoryPanel.setBackground(Color.lightGray);
        GridLayout gridLayout = new GridLayout(1, 1);
        gridLayout.setVgap((1));
        memoryPanel.setLayout(gridLayout);
//        memoryPanel.setBounds(10, 50, CALC_Width - 5, 50);
//        memoryPanel.setPreferredSize(new Dimension(CALC_Width - 5, 30));
        for (int i = 0; i < 5; i++) {
            memoryPanel.add(buttons[i]);
        }
        return memoryPanel;
    }
    private JPanel createCalcPanel() {
        JPanel calcPanel = new JPanel();
        calcPanel.setBackground(Color.lightGray);
        calcPanel.setBorder(new EmptyBorder(2, 2, 2, 2));
        GridLayout gridLayoutCalc = new GridLayout(7, 4);
        gridLayoutCalc.setVgap(1);
        gridLayoutCalc.setHgap(1);
        calcPanel.setLayout(gridLayoutCalc);
        for (int i = 5; i < 29; i++) {
            calcPanel.add(buttons[i]);
        }
        return calcPanel;
    }

    private double calculate(String op, double num1, double num2) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "−":
                return num1 - num2;
            case "×":
                return num1 * num2;
            case "÷":
                // division by 0
                if (num2 == 0) {
                    return Double.NaN;
                }
                return num1 / num2;
            default:
                return 0;
        }
    }
    private class ButtonListener implements ActionListener {
        double resultValue = 0;
        double memValue = 0;
        StringBuilder formula = new StringBuilder();
        @Override
        public void actionPerformed(ActionEvent e) {
            // retrieve the label from the JButtons
            String label = e.getActionCommand();
            // determine action to perform
        /*    switch (label) {
                // number: display it on the label, add new num to the end of label text
                case "0", "1", "2", "3","4","5","6","7","8","9",".":
                    String currentText = result.getText();
                    if (currentText.equals("0")) {
                        resultValue = 0;
                        formula.append(label);
                        calculation.setText(formula.toString());
                        result.setText(label);
                    } else {
                        result.setText(currentText + label);
                    }
                    break;
                // arithmetic operator

                case "+":
                case "−":
                case "×":
                case "÷":
                    double num = Double.parseDouble(result.getText());
                    setNum1(num);
                    String op = label;
                    if (!formula.isEmpty()) {
                        // If there's already a formula, calculate the result and set it as the first number
                        setNum1(calculate(operator, num1, num2));

                        // Append the current formula to the previous one
                        // formula += num2 + " " + op + " ";
                    } else {
                        double num1 = Double.parseDouble(result.getText());
                        setNum1(num);
                    }
                    // Update the operator
                    setOperator(op);
                    // Set the current formula
                    formula.append(" "+label+" ");
                    result.setText("0");
                    break;
*/

            // determine action to perform
            switch (label) {
                // number: display it on the label, add new num to the end of label text
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".":
                    String currentText = result.getText();
                    if (currentText.equals("0")) {
                        resultValue = 0;
                        formula.append(label);
                        calculation.setText(formula.toString());
                        result.setText(label);
                    } else {
                        result.setText(currentText + label);
                        formula.append(label);
                        calculation.setText(formula.toString());
                    }
                    break;

                // arithmetic operator
                case "+":
                case "−":
                case "×":
                case "÷":
                    double num = Double.parseDouble(result.getText());
                    setNum1(num);
                    String op = label;
                    if (!formula.toString().isEmpty()) {
                        // If there's already a formula, calculate the result and set it as the first number
                        setNum1(calculate(operator, num1, num2));
                        // Append the current formula to the previous one
                        formula.append(" " + op + " ");
                    } else {
                        double num1 = Double.parseDouble(result.getText());
                        setNum1(num);
                    }

                    if (formula.length() == 0) {
                        // If there's no existing formula, simply set the formula as the current number and operator
                        formula.append(result.getText() + " " + label);
                    } else {
                        // If there's already a formula, calculate the result and set it as the first number
                        setNum1(calculate(operator, num1, num2));
                        formula.append(" " + label);
                    }
                    // Update the operator
                    setOperator(label);
                    calculation.setText(formula.toString());
                    result.setText("0");
                    break;

                case "=":
                    num2 = Double.parseDouble(result.getText());
                    setNum2(num2);
                    resultValue = calculate(operator, num1, num2);
                    if (resultValue % 1 == 0) {
                        int resultValueInt = (int) resultValue;
                        result.setText(Integer.toString(resultValueInt));
                    }
                    else {
                        result.setText(Double.toString(resultValue));
                    }
                    break;

                case "DEL":
                    String currentDisplay = result.getText();
                    // remove the last digit on the display
                    if (currentDisplay.length() > 1) {
                        result.setText(currentDisplay.substring(0, currentDisplay.length() - 1));
                    }
                    // remove all digits -> display "0"
                    else {
                        result.setText("0");
                    }
                    break;

                case "C":
                case "CE":
                    setNum1(0);
                    setNum2(0);
                    setOperator("");
                    result.setText("0");
                    break;
                case "√":
                    num = Double.parseDouble(result.getText());
                    resultValue = Math.sqrt(num);
                    if (resultValue % 1 == 0) {
                        int resultValueInt = (int) resultValue;
                        result.setText(Integer.toString(resultValueInt));
                    }
                    else {
                        result.setText(Double.toString(resultValue));
                    }
                    break;
                case "x²":
                    num = Double.parseDouble(result.getText());
                    resultValue = num * num;
                    if (resultValue % 1 == 0) {
                        int resultValueInt = (int) resultValue;
                        result.setText(Integer.toString(resultValueInt));
                    }
                    else {
                        result.setText(Double.toString(resultValue));
                    }
                    break;
                case "1/x":
                    num = Double.parseDouble(result.getText());
                    resultValue = 1 / num;
                    if (resultValue % 1 == 0) {
                        int resultValueInt = (int) resultValue;
                        result.setText(Integer.toString(resultValueInt));
                    }
                    else {
                        result.setText(Double.toString(resultValue));
                    }
                    break;
                case "%":
                    num = Double.parseDouble(result.getText());
                    resultValue = num / 100;
                    if (resultValue % 1 == 0) {
                        int resultValueInt = (int) resultValue;
                        result.setText(Integer.toString(resultValueInt));
                    }
                    else {
                        result.setText(Double.toString(resultValue));
                    }
                    break;
                case "MS":
                    resultValue = Double.parseDouble(result.getText());
                    memory.setText(Double.toString(resultValue));
                    System.out.println("value stored in memory: "+memory.getText());
                    break;
                case "M+":
                    memValue = Double.parseDouble(memory.getText());
                    resultValue = Double.parseDouble(result.getText());
                    memValue = memValue + resultValue;
                    if (memValue % 1 == 0) {
                        int memValueInt = (int) memValue;
                        memory.setText(Integer.toString(memValueInt));
                    }
                    else {
                        memory.setText(Double.toString(memValue));
                    }
                    result.setText("0");
                    break;
                case "M-":
                    memValue = Double.parseDouble(memory.getText());
                    resultValue = Double.parseDouble(result.getText());
                    memValue = memValue - resultValue;
                    if (memValue % 1 == 0) {
                        int memValueInt = (int) memValue;
                        memory.setText(Integer.toString(memValueInt));
                    }
                    else {
                        memory.setText(Double.toString(memValue));
                    }
                    result.setText("0");
                    break;
                case "MR":
                    result.setText(memory.getText());
                    break;
                case "MC":
                    memory.setText("0");
                    break;
                case "+/-":
                    num = Double.parseDouble(result.getText());
                    resultValue = num * (-1);
                    if (resultValue % 1 == 0) {
                        int resultValueInt = (int) resultValue;
                        result.setText(Integer.toString(resultValueInt));
                    }
                    else {
                        result.setText(Double.toString(resultValue));
                    }
                    break;

            }calculation.setText(formula.toString());
        }

    }
}
