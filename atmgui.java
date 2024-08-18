import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class atmgui extends JFrame implements ActionListener {
    private JLabel labelWelcome;
    private JLabel labelPin;
    private JTextField textPin;
    private JButton buttonLogin;
    private JButton buttonWithdraw;
    private JButton buttonDeposit;
    private JButton buttonCheckBalance;
    private JButton buttonExit;

    private double balance = 1000.00;

    public atmgui() {
        setTitle("ATM Simulator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        labelWelcome = new JLabel("Welcome to the ATM", JLabel.CENTER);
        labelWelcome.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(labelWelcome);

        labelPin = new JLabel("Enter PIN:", JLabel.CENTER);
        panel.add(labelPin);

        textPin = new JPasswordField(10);
        panel.add(textPin);

        buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(this);
        panel.add(buttonLogin);

        add(panel, BorderLayout.CENTER);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogin) {

            if (textPin.getText().equals("1234")) {
                showMenu();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid PIN. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == buttonWithdraw) {
            String amountStr = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            double amount = Double.parseDouble(amountStr);
            if(amount !=0) {

                if (amount > balance) {
                    JOptionPane.showMessageDialog(this, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    balance -= amount;
                    JOptionPane.showMessageDialog(this, "Withdrawal successful. New balance: ₹" + balance);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Please Enter a valid amount!" , "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else if (e.getSource() == buttonDeposit) {
            String amountStr = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            double amount = Double.parseDouble(amountStr);
            if (amount != 0 && amount<=50000){

                balance += amount;
                JOptionPane.showMessageDialog(this, "Deposit successful. New balance: ₹" + balance);
            } 
            else if(amount>50000){
                JOptionPane.showMessageDialog(this, "Amount exceeds the maximum deposit limit!" ,  "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(this, "Invalid Deposit amount!" ,  "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else if (e.getSource() == buttonCheckBalance) {
            JOptionPane.showMessageDialog(this, "Current balance: ₹" + balance);
        } else if (e.getSource() == buttonExit) {
            JOptionPane.showMessageDialog(this, "Thank you for using our ATM. Goodbye!");
            System.exit(0);
        }
    }


    private void showMenu() {

        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(4, 1, 10, 10));

        buttonWithdraw = new JButton("Withdraw");
        buttonWithdraw.addActionListener(this);
        panelMenu.add(buttonWithdraw);

        buttonDeposit = new JButton("Deposit");
        buttonDeposit.addActionListener(this);
        panelMenu.add(buttonDeposit);

        buttonCheckBalance = new JButton("Check Balance");
        buttonCheckBalance.addActionListener(this);
        panelMenu.add(buttonCheckBalance);

        buttonExit = new JButton("Exit");
        buttonExit.addActionListener(this);
        panelMenu.add(buttonExit);


        getContentPane().removeAll();
        getContentPane().add(panelMenu, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            atmgui atm = new atmgui();
            atm.setVisible(true);
        });
    }
}
