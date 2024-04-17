import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class withdraw extends JFrame {
    JTextField amount;
    String card_no;
    JButton withdrawl, back;
    int n=0;
    public void withd(String w){
        card_no=w;
        JLabel text= new JLabel("Enter the amount to Withdraw :");
        text.setBounds(150, 150, 500, 40);
        text.setFont(new Font("Raleway", Font.BOLD, 28));
        add(text);

        /*JLabel cardno= new JLabel("Card no.:");
        cardno.setBounds(150, 250, 450, 40);
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardno);*/

        amount = new JTextField();
        amount.setBounds(150, 200, 450, 30);
        add(amount);

        /*card_no = new JTextField();
        card_no.setBounds(350, 250, 250, 30);
        add(card_no);*/

        withdrawl= new JButton("Withdraw");
        withdrawl.setBounds(480, 320, 100, 30);
        withdrawl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String am= amount.getText();
                try{
                    n=Integer.parseInt(am);
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Enter correct amount ");
                    }
                if (n!=0) {
                    conn();
                }
            }
        });
        add(withdrawl);

        back= new JButton("Back");
        back.setBounds(350, 320, 100, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                userwork back=new userwork();
                back.work(card_no);
                dispose();
            }
        });
        add(back);
       
        JLabel lbloginform= new JLabel("<html><u>WITHDRAWL AMOUNT</u><html>");
        lbloginform.setFont(new Font("Osward", Font.BOLD, 39));
        lbloginform.setBounds(200, 50, 500, 50);
        add(lbloginform);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("welcome");
        setLocation(350, 200);
        setSize(800,480);
        setMinimumSize(new Dimension(200, 200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void conn(){
        int balance=0;
        ResultSet result, rs;
        connectest con= new connectest();
        //card= card_no.getText();
        Date date=new Date();
        try{
            con.stm= con.conn.createStatement();
            String sql="select * from bank where card_no= '"+card_no+"'";
            result = con.stm.executeQuery(sql);
            while (result.next()) {
                if (result.getString("type").equals("Deposit")){
                    balance+= Integer.parseInt(result.getString("amount")); 
                }
                else{
                    balance-= Integer.parseInt(result.getString("amount"));  
                }
            }
            String sql1="select * from form3 where card_no='"+card_no+"'";
            rs= con.stm.executeQuery(sql1);
            if (balance<n) {
                if (rs.next()) {
                    if (rs.getString("account_type").equals("Saving Account")) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        userwork f=new userwork();
                        f.work(card_no);
                        dispose();
                    }
                    else{
                        int choice=JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "confirmation", JOptionPane.YES_NO_OPTION);
                        if (choice==JOptionPane.YES_OPTION) {
                            String sql2="insert into bank values('"+card_no+"','"+date+"','Withdrawl','"+n+"')";
                            con.stm.executeUpdate(sql2);   
                            JOptionPane.showMessageDialog(null, "Amount Withdrawl"+balance);
                            userwork f=new userwork();
                            f.work(card_no);
                            dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "withdrawl Canceled"+balance);
                        }
                    }}
                    else{
                        JOptionPane.showMessageDialog(null, "withdrawl Canceled"+balance);
                    }

            }
            else{
                String sql2="insert into bank values('"+card_no+"','"+date+"','Withdrawl','"+n+"')";
                con.stm.executeUpdate(sql2);   
                JOptionPane.showMessageDialog(null, "Amount Withdrawl");
                userwork f=new userwork();
                f.work(card_no);
                dispose();
            }
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "error of connection data = "+e);
        }
    }
    public static void main(String[] args) {
        withdraw d=new withdraw();
        d.withd(null);
    }
}
