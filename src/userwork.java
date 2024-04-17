import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class userwork extends JFrame {
    JLabel head;
    JButton btnwithdrawal, btnchangepin, btnbalance, btnministm, btnback;
    JPasswordField pfpassword;
    String name, pass, cardno;
    public void work(String c)
    {
        cardno=c;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel lable=new JLabel(i3);
        lable.setBounds(90,2,100,100);
        add(lable); 
        
        btnwithdrawal= new JButton("Withdraw Amount");
        btnwithdrawal.setFont(new Font("Raleway", Font.BOLD, 26));
        btnwithdrawal.setBounds(250, 100, 300, 40);
        btnwithdrawal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                withdraw work=new withdraw();
                work.withd(cardno);
                dispose();
            }
        });
        add(btnwithdrawal);
        btnchangepin= new JButton("Change PIN");
        btnchangepin.setFont(new Font("Raleway", Font.BOLD, 26));
        btnchangepin.setBounds(250, 200, 300, 40);
        btnchangepin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                pinchange del=new pinchange();
                del.pinch(cardno);
                dispose();
            }
        });
        add(btnchangepin);
        btnbalance= new JButton("Balance Enquiry");
        btnbalance.setFont(new Font("Raleway", Font.BOLD, 26));
        btnbalance.setBounds(250, 150, 300, 40);
        btnbalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                balancecheck b=new balancecheck();
                b.balcheck(cardno);
                dispose();
            }
        });
        add(btnbalance);
        btnministm= new JButton("Mini-Statement");
        btnministm.setFont(new Font("Raleway", Font.BOLD, 26));
        btnministm.setBounds(250, 250, 300, 40);
        btnministm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                minist add=new minist();
                add.stm(cardno);
            }
        });
        add(btnministm);

        btnback= new JButton("Back");
        btnback.setFont(new Font("Raleway", Font.BOLD, 26));
        btnback.setBounds(250, 300, 300, 40);
        btnback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                home add=new home();
                add.start();
                dispose();
            }
        });
        add(btnback);
       
        JLabel head= new JLabel("<html><u>USER TRANSACTION</u></html>");
        head.setFont(new Font("Osward", Font.BOLD, 40));
        head.setBounds(210, 20, 500, 50);
        add(head);

        setTitle("welcome");
        setLocation(350, 200);
        setSize(800,480);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        userwork u=new userwork();
        u.work(null);
    }
}


