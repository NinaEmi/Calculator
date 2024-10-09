import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel implements ActionListener {

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    JButton button9 = new JButton("9");
    JButton button8 = new JButton("8");
    JButton button7 = new JButton("7");
    JButton button6 = new JButton("6");
    JButton button5 = new JButton("5");
    JButton button4 = new JButton("4");
    JButton button3 = new JButton("3");
    JButton button2 = new JButton("2");
    JButton button1 = new JButton("1");
    JButton button0 = new JButton("0");

    JButton[] numberButtons = {button0, button1, button2, button3, button4, button5, button6, button7, button8, button9};
    JTextField textField = new JTextField();

    JButton buttonAdd = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonMultiplication = new JButton("x");
    JButton buttonCancel = new JButton("C");
    JButton buttonEqual = new JButton("=");
    JButton buttonDivision = new JButton("/");

    private int num1, num2, result = 0;
    char operator;

    public CalculatorPanel() {
      //  this.setBackground(Color.GRAY);

        this.setLayout(null);

        this.add(buttonAdd);
        this.add(buttonMinus);
        this.add(buttonMultiplication);
        this.add(buttonCancel);
        this.add(buttonEqual);
        this.add(buttonDivision);

        this.add(button0);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);

        button0.setFont(myFont);
        button1.setFont(myFont);
        button2.setFont(myFont);
        button3.setFont(myFont);
        button4.setFont(myFont);
        button5.setFont(myFont);
        button6.setFont(myFont);
        button7.setFont(myFont);
        button8.setFont(myFont);
        button9.setFont(myFont);
        buttonCancel.setFont(myFont);
        buttonAdd.setFont(myFont);
        buttonDivision.setFont(myFont);
        buttonMinus.setFont(myFont);
        buttonMultiplication.setFont(myFont);
        buttonEqual.setFont(myFont);

        button7.setBounds(10, 90, 80, 80);
        button8.setBounds(110, 90, 80, 80);
        button9.setBounds(210, 90, 80, 80);
        buttonAdd.setBounds(310, 90, 80, 80);
        button4.setBounds(10, 180, 80, 80);
        button5.setBounds(110, 180, 80, 80);
        button6.setBounds(210, 180, 80, 80);
        buttonMinus.setBounds(310, 180, 80, 80);
        button1.setBounds(10, 270, 80, 80);
        button2.setBounds(110, 270, 80, 80);
        button3.setBounds(210, 270, 80, 80);
        buttonMultiplication.setBounds(310, 270, 80, 80);
        buttonCancel.setBounds(10, 360, 80, 80);
        button0.setBounds(110, 360, 80, 80);
        buttonEqual.setBounds(210, 360, 80, 80);
        buttonDivision.setBounds(310, 360, 80, 80);

        textField.setBounds(10, 10, 380, 65);
        textField.setFont(myFont);
        textField.setEditable(false);

        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonMultiplication.addActionListener(this);
        buttonDivision.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonCancel.addActionListener(this);

        this.add(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == buttonAdd){
            num1 = (int) Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == buttonMinus){
            num1 = (int) Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == buttonMultiplication){
            num1 = (int) Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText("");
        }
        if(e.getSource() == buttonDivision){
            num1 = (int) Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == buttonCancel){
            textField.setText("");
        }
        if(e.getSource() == buttonEqual){
            num2 = (int) Double.parseDouble(textField.getText());

            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

    }
}
