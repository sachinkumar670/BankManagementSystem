import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class addstafe extends JFrame {
    JLabel lbUserName, lbPassword, lbloginform;
    JTextField tfusername;
    JButton  btnclear, btnsinghup, btnback;
    JPasswordField pfpassword;
    String name, pass;
    public void initialize()
    {
        
        JLabel lbUserName= new JLabel("UserName");
        lbUserName.setBounds(150, 150, 400, 40);
        lbUserName.setFont(new Font("Raleway", Font.BOLD, 28));
        add(lbUserName);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setBounds(150, 200, 400, 40);
        lbPassword.setFont(new Font("Raleway", Font.BOLD, 28));
        add(lbPassword);

        tfusername = new JTextField();
        tfusername.setBounds(350, 150, 250, 30);
        add(tfusername);
        

        pfpassword = new JPasswordField();
        pfpassword.setBounds(350, 200, 250, 30);
        add(pfpassword);
        
        btnsinghup= new JButton("Add");
        btnsinghup.setBounds(480, 300, 100, 30);
        btnsinghup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                name= tfusername.getText();
                pass= String.valueOf(pfpassword.getPassword());
                connectest mainsho=new connectest();
                mainsho.data(name, pass);
                stafework f=new stafework();
                f.work();                
                dispose();
            }
        });
        add(btnsinghup);
        /*btnclear= new JButton("Clear");
        btnclear.setBounds(610, 300, 100, 30);
        btnclear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tfusername.setText("");
                pfpassword.setText("");
            }
        });
        add(btnclear);*/

        btnback= new JButton("Back");
        btnback.setBounds(350, 300, 100, 30);
        btnback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                stafework back=new stafework();
                back.work();
                dispose();
            }
        });
        add(btnback);
       
        JLabel lbloginform= new JLabel("<html><u>ADD STAFF</u></html>");
        lbloginform.setFont(new Font("Osward", Font.BOLD, 38));
        lbloginform.setBounds(300, 50, 400, 50);
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
    public static void main(String[] args) {
        addstafe s=new addstafe();
        s.initialize();
    }
}


