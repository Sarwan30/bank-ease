package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JLabel text, image;
    JButton deposit, withdrawl, fastcash, ministat, pinchange, balenq, exit;
    String pinnumber;  // Declare pinnumber field

    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;  // Assign the passed pinnumber to the field

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Please Select Your Transaction");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.ITALIC, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(159, 418, 150, 28);
        deposit.addActionListener(this);
        deposit.setFont(new Font("System", Font.BOLD, 16));
        image.add(deposit);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(362, 418, 150, 28);
        withdrawl.addActionListener(this);
        withdrawl.setFont(new Font("System", Font.BOLD, 16));
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.addActionListener(this);
        fastcash.setBounds(362, 452, 150, 28);
        fastcash.setFont(new Font("System", Font.BOLD, 16));
        image.add(fastcash);

        ministat = new JButton("Mini Statement");
        ministat.setBounds(159, 452, 150, 28);
        ministat.addActionListener(this);
        ministat.setFont(new Font("System", Font.BOLD, 16));
        image.add(ministat);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(362, 486, 150, 28);
        pinchange.addActionListener(this);
        pinchange.setFont(new Font("System", Font.BOLD, 16));
        image.add(pinchange);

        balenq = new JButton("Balance Enquiry");
        balenq.setBounds(159, 486, 150, 28);
        balenq.addActionListener(this);
        balenq.setFont(new Font("System", Font.BOLD, 16));
        image.add(balenq);

        exit = new JButton("Exit");
        exit.setBounds(362, 520, 150, 28);
        exit.addActionListener(this);
        exit.setFont(new Font("System", Font.BOLD, 16));
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource()== deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()== withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource()== fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource()== pinchange) {
             setVisible(false);
             new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource()== balenq) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource()==ministat) {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
