package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JLabel text, image;
    JButton onehundred, fivehundred, onek, fivek, sevenfivek, tenk, exit;
    String pinnumber;  // Declare pinnumber field

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;  // Assign the passed pinnumber to the field

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.ITALIC, 16));
        image.add(text);

        onehundred = new JButton("Rs. 100");
        onehundred.setBounds(159, 418, 150, 28);
        onehundred.addActionListener(this);
        onehundred.setFont(new Font("System", Font.BOLD, 16));
        image.add(onehundred);

        fivehundred = new JButton("Rs. 500");
        fivehundred.setBounds(362, 418, 150, 28);
        fivehundred.addActionListener(this);
        fivehundred.setFont(new Font("System", Font.BOLD, 16));
        image.add(fivehundred);

        onek = new JButton("Rs. 1000");
        onek.addActionListener(this);
        onek.setBounds(159, 452, 150, 28);
        onek.setFont(new Font("System", Font.BOLD, 16));
        image.add(onek);

        fivek = new JButton("Rs. 5000");
        fivek.setBounds(362, 452, 150, 28);
        fivek.addActionListener(this);
        fivek.setFont(new Font("System", Font.BOLD, 16));
        image.add(fivek);

        sevenfivek = new JButton("Rs. 7500");
        sevenfivek.setBounds(159, 486, 150, 28);
        sevenfivek.addActionListener(this);
        sevenfivek.setFont(new Font("System", Font.BOLD, 16));
        image.add(sevenfivek);

        tenk = new JButton("Rs. 9000");
        tenk.setBounds(362, 486, 150, 28);
        tenk.addActionListener(this);
        tenk.setFont(new Font("System", Font.BOLD, 16));
        image.add(tenk);

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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(4).replace(",", "");
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "' , '" + date + "' , 'Withdraw', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
