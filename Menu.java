import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    private JMenuBar menuBar = new JMenuBar();
    private JMenu meniu;
    private JMenuItem calculator, help, exit;
    private CalculatorPanel calculatorPanel = new CalculatorPanel();
    private HelpPanel helpPanel = new HelpPanel();
    private ExitPanel exitPanel = new ExitPanel();
    private JFrame frame = new JFrame();

    public Menu() {
        frame.setVisible(true);
        frame.setSize(new Dimension(410, 510));
        frame.setMinimumSize(new Dimension(410, 510));
        frame.setMaximumSize(new Dimension(410, 510));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(calculatorPanel);
        frame.setLocationRelativeTo(null);

        //frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

        meniu = new JMenu("Meniu");
        calculator = new JMenuItem("Calculator");
        help = new JMenuItem("Help");
        exit = new JMenuItem("Exit");

        meniu.add(calculator);
        meniu.add(help);
        meniu.add(exit);

        calculator.addActionListener(this);
        help.addActionListener(this);
        exit.addActionListener(this);

        menuBar.add(meniu);

        frame.setJMenuBar(menuBar);

        frame.add(calculatorPanel);
        frame.add(helpPanel);
        frame.add(exitPanel);

        frame.pack();
        frame.repaint();

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calculator){
            System.out.println("Ai apasat optiunea Calculator!");
            frame.remove(helpPanel);
            frame.remove(exitPanel);
            frame.add(calculatorPanel);
            frame.pack();
            frame.repaint();
        } else if(e.getSource() == help){
            System.out.println("Ai apasat optiunea Help!");
            frame.remove(calculatorPanel);
            frame.add(helpPanel);
            frame.remove(exitPanel);
            frame.pack();
            frame.repaint();
            int option = JOptionPane.showConfirmDialog(null, "Something is wrong", "MyCalculator", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (option == JOptionPane.OK_OPTION) {
                System.out.println("OK pressed");
            } else {
                System.out.println("Cancel pressed");
            }
        } else if(e.getSource() == exit){
            System.out.println("Ai apasat optiunea Exit!");
            System.exit(0);
        }
    }
}
