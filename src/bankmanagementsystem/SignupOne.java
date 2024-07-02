package bankmanagementsystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextfield,fnameTextfield,emailTextfield, addressTextfield, cityTextfield, stateTextfield, pincodeTextfield;
    JRadioButton male, female, others, married, single;
    JButton next;
    JLabel formno;
    JDateChooser dateChooser;


    SignupOne(){
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L) + 1000L);
        formno = new JLabel("Application Form No." + random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        personalDetails.setBounds(290,80,400,80);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextfield = new JTextField();
        nameTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextfield.setBounds(300,140,400,30);
        add(nameTextfield);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextfield = new JTextField();
        fnameTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        fnameTextfield.setBounds(300,190,400,30);
        add(fnameTextfield);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,80,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400,290,80,30);
        female.setBackground(Color.WHITE);
        add(female);

        others = new JRadioButton("Others");
        others.setBounds(500,290,80,30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextfield = new JTextField();
        emailTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextfield.setBounds(300,340,400,30);
        add(emailTextfield);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300 ,390,80,30 );
        married.setBackground(Color.WHITE);
        add(married);

        single = new JRadioButton("Single");
        single.setBounds(400 ,390,80,30 );
        single.setBackground(Color.WHITE);
        add(single);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(single);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextfield = new JTextField();
        addressTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextfield.setBounds(300,440,400,30);
        add(addressTextfield);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextfield = new JTextField();
        cityTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextfield.setBounds(300,490,400,30);
        add(cityTextfield);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextfield = new JTextField();
        stateTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        stateTextfield.setBounds(300,540,400,30);
        add(stateTextfield);

        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pincodeTextfield = new JTextField();
        pincodeTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        pincodeTextfield.setBounds(300,590,400,30);
        add(pincodeTextfield);

        next = new JButton("Next");
        next.setBounds(400 , 650,80,40);
        next.setFont(new Font("", Font.BOLD,14));
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }



    public static void main(String[] args) {
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; //long
        String name = nameTextfield.getText();
        String fname = fnameTextfield.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (others.isSelected()) {
            gender = "Others";
        }
        String email = emailTextfield.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        }else if (single.isSelected()){
            marital = "Single";
        }
        String address = addressTextfield.getText();
        String city = cityTextfield.getText();
        String state = stateTextfield.getText();
        String pin = pincodeTextfield.getText();

        try{
            //Validations
          if (name.equals("")){
              JOptionPane.showMessageDialog(null , "Please Enter Your Name");
          }else{
              Conn c = new Conn();
              String query = "insert into signup values('"+formno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+marital+"' , '"+address+"' , '"+city+"' , '"+pin+"' , '"+state+"')";
              c.s.executeUpdate(query);

              setVisible(false);
              new SignupTwo(formno).setVisible(true);
          }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
