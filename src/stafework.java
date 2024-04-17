import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class stafework extends JFrame {
    JLabel head;
    JButton btncreateacc, btndeposit, btnaddstafe, btndeleteacc, btnback;
    JPasswordField pfpassword;
    String name, pass;
    public void work()
    {
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel lable=new JLabel(i3);
        lable.setBounds(190,2,100,100);
        add(lable); 
        
        btncreateacc= new JButton("Create Account");
        btncreateacc.setFont(new Font("Raleway", Font.BOLD, 26));
        btncreateacc.setBounds(250, 100, 300, 40);
        btncreateacc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                form1 work=new form1();
                work.f1();
                dispose();
            }
        });
        add(btncreateacc);
        btndeleteacc= new JButton("Delete Account");
        btndeleteacc.setFont(new Font("Raleway", Font.BOLD, 26));
        btndeleteacc.setBounds(250, 200, 300, 40);
        btndeleteacc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                accdelete del=new accdelete();
                del.delete();
                dispose();
            }
        });
        add(btndeleteacc);
        btndeposit= new JButton("Deposit");
        btndeposit.setFont(new Font("Raleway", Font.BOLD, 26));
        btndeposit.setBounds(250, 150, 300, 40);
        btndeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                deposit d=new deposit();
                d.depo();
                dispose();
            }
        });
        add(btndeposit);
        btnaddstafe= new JButton("Add Staff");
        btnaddstafe.setFont(new Font("Raleway", Font.BOLD, 26));
        btnaddstafe.setBounds(250, 250, 300, 40);
        btnaddstafe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                addstafe add=new addstafe();
                add.initialize();
                dispose();
            }
        });
        add(btnaddstafe);
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
       
        JLabel head= new JLabel("<html><u>STAFF WORK</u></html>");
        head.setFont(new Font("Osward", Font.BOLD, 38));
        head.setBounds(300, 20, 400, 50);
        add(head);

        setTitle("welcome");
        setLocation(350, 200);
        setSize(800,480);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        stafework s=new stafework();
        s.work();
    }
}

