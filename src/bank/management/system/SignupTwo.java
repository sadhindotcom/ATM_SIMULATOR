package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    long random;
    JTextField   pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education, occupation;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
       
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.ITALIC, 25));
        additionalDetails.setBounds(280, 80, 400, 30);
        add(additionalDetails);

        JLabel eRligion = new JLabel("Religion: ");
        eRligion.setFont(new Font("Raleway", Font.BOLD, 20));
        eRligion.setBounds(100, 150, 200, 30);
        add(eRligion);
        
        String valReligion [] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 150, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel eCategory = new JLabel("Category: ");
        eCategory.setFont(new Font("Raleway", Font.BOLD, 20));
        eCategory.setBounds(100, 190, 200, 30);
        add(eCategory);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel eIncome = new JLabel("Annual Income: ");
        eIncome.setFont(new Font("Raleway", Font.BOLD, 20));
        eIncome.setBounds(100, 230, 200, 30);
        add(eIncome);
        
        String valIncome[] = {"NULL", "< 1,50,000", "< 2,50,000", "< 5,00,000", "< 10,00,000", "Over 10,00,00"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 230, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel eEducation = new JLabel("Educational ");
        eEducation.setFont(new Font("Raleway", Font.BOLD, 20));
        eEducation.setBounds(100, 270, 200, 30);
        add(eEducation);

        JLabel eQualification = new JLabel("Qualification: ");
        eQualification.setFont(new Font("Raleway", Font.BOLD, 20));
        eQualification.setBounds(100, 300, 200, 30);
        add(eQualification);
        
        String valEducation[] = {"10th", "12th", "Graduation", "Post-Graduation", "Others"};
        education = new JComboBox(valEducation);
        education.setBounds(300, 290, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel eOccupation = new JLabel("Occupation: ");
        eOccupation.setFont(new Font("Raleway", Font.BOLD, 20));
        eOccupation.setBounds(100, 350, 200, 30);
        add(eOccupation);
        
        String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Others"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300, 350, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

       

        JLabel ePan = new JLabel("Pan No: ");
        ePan.setFont(new Font("Raleway", Font.BOLD, 20));
        ePan.setBounds(100, 390, 200, 30);
        add(ePan);

        pan= new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 15));
        pan.setBounds(300, 390, 400, 30);
        add(pan);

        JLabel eAadhar = new JLabel("Aadhar No: ");
        eAadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        eAadhar.setBounds(100, 430, 200, 30);
        add(eAadhar);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 15));
        aadhar.setBounds(300, 430, 400, 30);
        add(aadhar);

        JLabel eCitizen = new JLabel("Senior Citizen: ");
        eCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        eCitizen.setBounds(100, 470, 200, 30);
        add(eCitizen);

        syes = new JRadioButton ("Yes");
        syes.setBounds(300, 470, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton ("No");
        sno.setBounds(500, 470, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(syes);
        citizengroup.add(sno);

        

        JLabel eAccount = new JLabel("Existing Account: ");
        eAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        eAccount.setBounds(100, 510, 200, 30);
        add(eAccount);

        eyes = new JRadioButton ("Yes");
        eyes.setBounds(300, 510, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton ("No");
        eno.setBounds(500, 510, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup eAccountgroup = new ButtonGroup();
        eAccountgroup.add(eyes);
        eAccountgroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 580, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();
        
         try{
    
    
        
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount + "')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
}catch(Exception e){
    System.out.println(e);
}
    }
    
   

    public static void main(String args[]) {
        new SignupTwo("");
    }

}
