import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class deposit extends JFrame {
    JTextField amount, card_no;
    JButton deposit, back;
    String c;
    int n=0;
    public void depo(){
        JLabel text= new JLabel("Enter the amount to deposit :");
        text.setBounds(150, 150, 400, 40);
        text.setFont(new Font("Raleway", Font.BOLD, 28));
        add(text);

        JLabel cardno= new JLabel("Card no.:");
        cardno.setBounds(150, 250, 450, 40);
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardno);

        amount = new JTextField();
        amount.setBounds(150, 200, 450, 30);
        add(amount);

        card_no = new JTextField();
        card_no.setBounds(350, 250, 250, 30);
        add(card_no);

        deposit= new JButton("Deposit");
        deposit.setBounds(480, 320, 100, 30);
        deposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String am= amount.getText();
                try{
                    n=Integer.parseInt(am);
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Enter correct amount = ");
                    }
                if (n!=0) {
                    conn(card_no.getText());
                }
            }
        });
        add(deposit);

        back= new JButton("Back");
        back.setBounds(350, 320, 100, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                stafework back=new stafework();
                back.work();
                dispose();
            }
        });
        add(back);
       
        JLabel lbloginform= new JLabel("<html><u>DEPOSIT</u></html>");
        lbloginform.setFont(new Font("Osward", Font.BOLD, 40));
        lbloginform.setBounds(350, 50, 400, 50);
        add(lbloginform);
        setLayout(null);
        setTitle("welcome");
        getContentPane().setBackground(Color.WHITE);
        setLocation(350, 200);
        setSize(800,480);
        setMinimumSize(new Dimension(200, 200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void depo(String cardno){
        c=cardno;
        JLabel text= new JLabel("Enter the amount to deposit :");
        text.setBounds(150, 150, 400, 40);
        text.setFont(new Font("Raleway", Font.BOLD, 28));
        add(text);

        amount = new JTextField();
        amount.setBounds(150, 200, 450, 30);
        add(amount);

        deposit= new JButton("Deposit");
        deposit.setBounds(480, 320, 100, 30);
        deposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String am= amount.getText();
                try{
                    n=Integer.parseInt(am);
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Enter correct amount = ");
                    }
                if (n!=0) {
                    conn(c);
                }
            }
        });
        add(deposit);

        back= new JButton("Back");
        back.setBounds(350, 320, 100, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                stafework back=new stafework();
                back.work();
                dispose();
            }
        });
        add(back);
       
        JLabel lbloginform= new JLabel("<html><u>DEPOSIT</u></html>");
        lbloginform.setFont(new Font("Osward", Font.BOLD, 40));
        lbloginform.setBounds(350, 50, 400, 50);
        add(lbloginform);
        setLayout(null);
        setTitle("welcome");
        getContentPane().setBackground(Color.WHITE);
        setLocation(350, 200);
        setSize(800,480);
        setMinimumSize(new Dimension(200, 200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void conn(String c){
        connectest con= new connectest();
        Date date=new Date();
        try{
            con.stm= con.conn.createStatement();
            String sql="select * from acclog where cardno= '"+c+"'";
            ResultSet resultset1 = con.stm.executeQuery(sql);
            if (resultset1.next()){ 
                String sql1="insert into bank values('"+c+"','"+date+"','Deposit','"+n+"')";
                con.stm.executeUpdate(sql1);   
                JOptionPane.showMessageDialog(null, "Amount Deposited");
                stafework f=new stafework();
                f.work();
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Account not found");
                
            }
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "error of connection data 2 = "+e);
        }
    }
    public static void main(String[] args) {
        deposit d=new deposit();
        d.depo();
    }
}
