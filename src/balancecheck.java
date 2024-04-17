import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

public class balancecheck extends JFrame implements ActionListener{
    JButton back;
    String cardno;
    int balance;
    public void balcheck(String c){
        cardno=c;

        back= new JButton("Back");
        back.setBounds(550,300,100,30);
        back.addActionListener(this);
        add(back);

        balance=0;
        ResultSet result;
        connectest con= new connectest();
        try{
            con.stm= con.conn.createStatement();
            String sql="select * from bank where card_no= '"+cardno+"'";
            result = con.stm.executeQuery(sql);
            while (result.next()) {
                if (result.getString("type").equals("Deposit")){
                    balance+= Integer.parseInt(result.getString("amount")); 
                }
                else{
                    balance-= Integer.parseInt(result.getString("amount"));  
                }
            }
        }
        catch (Exception e) {
            String s=e.getMessage();
            JOptionPane.showMessageDialog(null, "connection error="+s);
        }

        JLabel text=new JLabel("Current Account Balance of your account:"+balance);
        text.setFont(new Font("Raleway", Font.BOLD, 28));
        text.setBounds(50,150,700,40);
        add(text);

        JLabel head=new JLabel("Account Balance");
        head.setFont(new Font("Osward", Font.BOLD, 38));
        head.setBounds(250,50,400,50);
        add(head);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800,480);
        setLocation(350,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        userwork u=new userwork();
        u.work(cardno);
        dispose();
    }
    public static void main(String[] args) {
        balancecheck b=new balancecheck();
        b.balcheck(null);
    }

}
