
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton Rs100, Rs500, Rs1000, Rs2000, Rs5000, Rs10000, back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl amount");
        text.setBounds(220, 280, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        Rs100 = new JButton("Rs 100");
        Rs100.setBounds(170, 420, 120, 30);
        Rs100.addActionListener(this);
        image.add(Rs100);
        
        Rs500 = new JButton("Rs 500");
        Rs500.setBounds(380, 400, 120, 30);
        Rs500.addActionListener(this);
        image.add(Rs500);
        
        
        Rs1000 = new JButton("Rs 1000");
        Rs1000.setBounds(170, 460, 120, 30);
        Rs1000.addActionListener(this);
        image.add(Rs1000);
        
        
        Rs2000 = new JButton("Rs 2000");
        Rs2000.setBounds(380, 440, 120, 30);
        Rs2000.addActionListener(this);
        image.add(Rs2000);
        
        
        Rs5000 = new JButton("Rs 5000");
        Rs5000.setBounds(170, 500, 120, 30);
        Rs5000.addActionListener(this);
        image.add(Rs5000);
        
        Rs10000 = new JButton("Rs 10000");
        Rs10000.setBounds(380, 480, 120, 30);
        Rs10000.addActionListener(this);
        image.add(Rs10000);
        
        back = new JButton("Back");
        back.setBounds(380, 520, 120, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    
    }
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
           String amount = ((JButton)ae.getSource()).getText().substring(3);
           Conn c = new Conn();
           
           try{
             ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
             int balance = 0;
             while(rs.next()){
                 if(rs.getString("type").equals("Deposit")){
                     balance += Integer.parseInt( rs.getString("amount"));
                 }else{
                     balance -= Integer.parseInt( rs.getString("amount"));
                 }
             }
             
             if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
                 JOptionPane.showMessageDialog(null, "Insuuficient Balance");
                 return;
             }
             
             Date date = new Date();
             String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"' )";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Rs " +amount+ " Debited Successfully");
             
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
             
           }catch(Exception e){
               System.out.println(e);
           }
           
        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
}
