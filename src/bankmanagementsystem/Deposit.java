package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JLabel text, image;
    JTextField amount;
    JButton deposit , back;
    String pinnumber;

    Deposit(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Enter the Amount You want to deposit");
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.ITALIC, 16));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(180, 350, 320, 25 );
        amount.setFont(new Font("Raleway" ,Font.BOLD, 22));
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.addActionListener(this);
        deposit.setFont(new Font("System", Font.BOLD, 16));
        deposit.setBounds(362, 486, 150, 28);
        image.add(deposit);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.setBounds(362, 520, 150, 28);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== deposit){
            String amnt = amount.getText();
            Date date = new Date();
            if (amnt.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Amount");
            }else {
                try {
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit' , '"+amnt+"') ";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amnt+" Deposited Succesfully"  );
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }else if (ae.getSource() == back){
            setVisible(false);
             new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
