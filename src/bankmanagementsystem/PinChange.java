package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JLabel text, image, pintext, repintext;
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        setLayout(null);

        text = new JLabel("Change Your PIN");
        text.setBounds(250, 280, 500, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.ITALIC, 16));
        image.add(text);

        pintext = new JLabel("New PIN");
        pintext.setBounds(165, 320, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        repintext = new JLabel("Re-enter New PIN");
        repintext.setBounds(165, 360, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.addActionListener(this);
        change.setBounds(355, 485, 150, 30);
        image.add(change);

        back = new JButton("BACK");
        back.addActionListener(this);
        back.setBounds(355, 520, 150, 30);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't Match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Re-PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                // Perform PIN change operation here
                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
