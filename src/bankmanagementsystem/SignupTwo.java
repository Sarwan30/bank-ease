package bankmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField panTextfield,aadhaarTextfield,existaccTextfield;
    JRadioButton syes, sno, eyes , eno;
    JButton next;
    JComboBox religion , category , occupation, qualification, income;
    String formno;

    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,80);
        add(additionalDetails);

        JLabel religionname = new JLabel("Religion:");
        religionname.setFont(new Font("Raleway", Font.BOLD,20));
        religionname.setBounds(100,140,100,30);
        add(religionname);

        String [] valReligion = {"Hindu" , "Sikh" , "Muslim" , "Christian" };
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel categoryname = new JLabel("Category:");
        categoryname.setFont(new Font("Raleway", Font.BOLD,20));
        categoryname.setBounds(100,190,200,30);
        add(categoryname);

        String [] valCategory = {"General" , "SC" , "ST" , "Minority" };
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incomename = new JLabel("Income: ");
        incomename.setFont(new Font("Raleway", Font.BOLD,20));
        incomename.setBounds(100,240,200,30);
        add(incomename);

        String [] valIncome = {"Null" , "< 1,00,000" , "< 1,00,000 > 2,00,000" , "> 2,00,000" };
        income = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel qualificationname = new JLabel("Qualification: ");
        qualificationname.setFont(new Font("Raleway", Font.BOLD,20));
        qualificationname.setBounds(100,290,200,30);
        add(qualificationname);

        String [] valQualification = {"Non-Graduate" ,"Diploma Holder", "Graduate" , "Post Graduate" , "Doctorate" , "Oth" };
        qualification = new JComboBox(valQualification);
        qualification.setBounds(300,290,400,30);
        qualification.setBackground(Color.WHITE);
        add(qualification);


        JLabel occupationname = new JLabel("Occupation: ");
        occupationname.setFont(new Font("Raleway", Font.BOLD,20));
        occupationname.setBounds(100,340,200,30);
        add(occupationname);

        String [] valOccupation = {"Salaried" , "Self-Employed" , "Student" , "Force Official", "Retired"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300 ,340,400,30 );
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel panname = new JLabel("PAN Number: ");
        panname.setFont(new Font("Raleway", Font.BOLD,20));
        panname.setBounds(100,390,200,30);
        add(panname);

        panTextfield = new JTextField();
        panTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        panTextfield.setBounds(300,390,400,30);
        add(panTextfield);

        JLabel aadhaar = new JLabel("Aadhaar: ");
        aadhaar.setFont(new Font("Raleway", Font.BOLD,20));
        aadhaar.setBounds(100,440,200,30);
        add(aadhaar);

        aadhaarTextfield = new JTextField();
        aadhaarTextfield.setFont(new Font("Raleway", Font.BOLD,14));
        aadhaarTextfield.setBounds(300,440,400,30);
        add(aadhaarTextfield);

        JLabel state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,490,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,490,50,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,490,40,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup Senior = new ButtonGroup();
        Senior.add(syes);
        Senior.add(sno);


        JLabel exisaccname = new JLabel("Existing Account: ");
        exisaccname.setFont(new Font("Raleway", Font.BOLD,20));
        exisaccname.setBounds(100,540,200,30);
        add(exisaccname);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,540,50,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,540,40,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup exisacc = new ButtonGroup();
        exisacc.add(eyes);
        exisacc.add(eno);

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

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String squalification = (String) qualification.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String sseniorcitizen =null;
        if (syes.isSelected()){
            sseniorcitizen = "Yes";
        }else if (sno.isSelected()){
            sseniorcitizen = "No";
        }
        String sexisaccount = null;
        if (eyes.isSelected()){
            sexisaccount = "Yes";
        } else if (eno.isSelected()) {
            sexisaccount = "No";
        }
        String span = panTextfield.getText();
        String saadhaar = aadhaarTextfield.getText();

        try{
            //Validations
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"' , '"+sreligion+"' , '"+scategory+"' , '"+sincome+"' , '"+squalification+"' ,'"+soccupation+"', '"+span+"' , '"+saadhaar+"' , '"+sseniorcitizen+"' , '"+sexisaccount+"' )";
                c.s.executeUpdate(query);
         //Signup 3 Object
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
