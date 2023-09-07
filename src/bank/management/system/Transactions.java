
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, ministatement, fastcash, pinchange, balance, exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please Select your Transaction");
        text.setBounds(220, 280, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 420, 120, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash withdrawl");
        withdrawl.setBounds(380, 400, 120, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        
        fastcash = new JButton("Fast cash");
        fastcash.setBounds(170, 460, 120, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        
        ministatement = new JButton("Mini statement");
        ministatement.setBounds(380, 440, 120, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        pinchange = new JButton("Pin change");
        pinchange.setBounds(170, 500, 120, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("balance Enqiry");
        balance.setBounds(380, 480, 120, 30);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(380, 520, 120, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()== withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()== pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()== balance){
           setVisible(false);
           new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()== ministatement){
           new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
}
