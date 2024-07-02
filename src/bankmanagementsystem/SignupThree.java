package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{
        JLabel l1 ,type, card, cardnum,carddetail,pin , pnum,pindetail,services;
        JRadioButton sa , cu , jo, fi;
        JCheckBox c1,c2,c3,c4,c5,c6,c7;
        JButton submit , cancel;
        String formno;

    SignupThree(String formno) {
        this.formno = formno;
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway" , Font.BOLD , 22));
        l1.setBounds(280,40,400,40);
        add(l1);

        type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway" , Font.BOLD , 22));
        type.setBounds(100,140,200,30);
        add(type);

        sa = new JRadioButton("Saving");
        sa.setBounds(300,143,85,30);
        sa.setFont(new Font("Raleway" , Font.ITALIC , 16));
        sa.setBackground(Color.WHITE);
        add(sa);

        cu = new JRadioButton("Current");
        cu.setBounds(400,143,85,30);
        cu.setFont(new Font("Raleway" , Font.ITALIC , 16));
        cu.setBackground(Color.WHITE);
        add(cu);

        jo = new JRadioButton("Joint");
        jo.setBounds(500,143,85,30);
        jo.setFont(new Font("Raleway" , Font.ITALIC , 16));
        jo.setBackground(Color.WHITE);
        add(jo);

        fi = new JRadioButton("Fixed Deposit");
        fi.setBounds(600,143,150,30);
        fi.setFont(new Font("Raleway" , Font.ITALIC , 16));
        fi.setBackground(Color.WHITE);
        add(fi);

        ButtonGroup acctype = new ButtonGroup();
        acctype.add(sa);
        acctype.add(cu);
        acctype.add(jo);
        acctype.add(fi);

        card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway" , Font.BOLD , 22));
        card.setBounds(100,240,200,40);
        add(card);

        cardnum = new JLabel("XXXX-XXXX-XXXX-2874");
        cardnum.setFont(new Font("Raleway" , Font.ITALIC , 22));
        cardnum.setBounds(300,240,280,40);
        add(cardnum);

        cardnum = new JLabel("XXXX-XXXX-XXXX-2874");
        cardnum.setFont(new Font("Raleway" , Font.ITALIC , 22));
        cardnum.setBounds(300,240,280,40);
        add(cardnum);

        carddetail = new JLabel("(Your 16 Digit Card No.)");
        carddetail.setFont(new Font("Raleway" , Font.ITALIC , 12));
        carddetail.setBounds(100,260,280,40);
        add(carddetail);

        pin = new JLabel("Pin Number :");
        pin.setFont(new Font("Raleway" , Font.BOLD , 22));
        pin.setBounds(100,340,150,40);
        add(pin);

        pnum = new JLabel("XXXX");
        pnum.setFont(new Font("Raleway" , Font.ITALIC , 22));
        pnum.setBounds(300,340,100,40);
        add(pnum);

        pindetail = new JLabel("(Your 4 Digit PIN.)");
        pindetail.setFont(new Font("Raleway" , Font.ITALIC , 12));
        pindetail.setBounds(100,360,100,40);
        add(pindetail);

        services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD , 18));
        services.setBounds(100 , 440 , 220,40);
        add(services);

        c1= new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway" , Font.ITALIC , 16));
        c1.setBounds(100, 480 ,150,30);
        add(c1);

        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway" , Font.ITALIC , 16));
        c2.setBounds(260, 480 ,150,30);
        add(c2);

        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway" , Font.ITALIC , 16));
        c3.setBounds(420, 480 ,150,30);
        add(c3);

        c4= new JCheckBox("EMAIL & SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway" , Font.ITALIC , 16));
        c4.setBounds(580, 480 ,150,30);
        add(c4);

        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway" , Font.ITALIC , 16));
        c5.setBounds(100, 520 ,150,30);
        add(c5);

        c6= new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway" , Font.ITALIC , 16));
        c6.setBounds(260, 520 ,150,30);
        add(c6);

        c7= new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway" , Font.ITALIC , 16));
        c7.setBounds(100, 590 ,700,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway" , Font.BOLD , 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250 , 680 , 100, 35);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway" , Font.BOLD , 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450 , 680 , 100, 35);
        add(cancel);



        setLayout(null); // Call setLayout with an argument (null or a specific layout manager)
        getContentPane().setBackground(Color.white);
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Add this to ensure the application exits properly
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){

            String acctype = null;
            if (sa.isSelected()){
                acctype = "Saving Account";
            } else if (cu.isSelected()) {
                acctype = "Current Account";
            } else if (jo.isSelected()) {
                acctype = "Joint Account";
            } else if (fi.isSelected()) {
                acctype = "Fixed Deposit";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() %9000L )+ 1000L);

            String facility = "";
            if (c1.isSelected()){
               facility = facility + " ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            }else if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            }else if (c4.isSelected()) {
                facility = facility + " EMAIL & SMS Alert";
            }else if (c5.isSelected()) {
                facility = facility + " Cheque";
            }else if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }

            try{
               if (acctype.equals("")){
                   JOptionPane.showMessageDialog(null , "Account Type is Required");
               }else{
                   Conn conn = new Conn();
                   String query1 = "insert into signupthree values('"+formno+"', '"+acctype+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"' )";
                   String query2 = "insert into login values('"+formno+"',  '"+cardnumber+"', '"+pinnumber+"')";
                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
                   JOptionPane.showMessageDialog(null , "Card Number: " + cardnumber + "\n Pin: " + pinnumber );
                   setVisible(false);
                   new Deposit(pinnumber).setVisible(false);

               }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
          setVisible(false);
          new Login(formno).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
