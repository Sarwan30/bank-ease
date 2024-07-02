package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    String formno;
    Login(String formno){
        this.formno = formno;
        setTitle("AUTOMATIC TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/03.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100,100);
        add(label);

        JLabel text = new JLabel("Welcome To ATM");
        text.setBounds(200 , 40 , 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 28));
        add(text);

        JLabel cardno = new JLabel("CARD NO: ");
        cardno.setBounds(120 , 150 , 150, 100);
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,185,230,35);
        cardTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120 , 220 , 450, 100);
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,250,230,35);
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        setSize(800,480);//Use to Give the Size of the Frame
         setVisible(true);// Use to Display the Frame
         setLocation(350,250);// Decides the frame location

    }

    public void actionPerformed(ActionEvent ae){
     if (ae.getSource() == clear){
         cardTextField.setText("");
         pinTextField.setText("");
     } else if (ae.getSource() == login) {
         Conn conn = new Conn();
         String cardnumber = cardTextField.getText();
         String pinnumber = new String(pinTextField.getPassword());
         String query = "select * from login where cardnumber ='"+cardnumber+"' and pinnumber = '"+pinnumber+"'";

         try {
          ResultSet rs = conn.s.executeQuery(query);
          if (rs.next()){
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
          }else {
              JOptionPane.showMessageDialog(null , "Incorrect Card Number or PIN");

          }
         }catch (Exception e){
             System.out.println(e);
         }

     } else if (ae.getSource() == signup) {
         setVisible(false);
         new SignupOne().setVisible(true);
     }
    }

    public static void main(String[] args) {
         new Login("");
    }


}