import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class stafelogin extends JFrame {
    JLabel lbUserName, lbPassword, lbresult, lbloginform;
    JTextField tfusername;
    JButton btnok, btnclear;
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
        
        btnclear= new JButton("Back");
        btnclear.setBounds(350, 300, 100, 30);
        btnclear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                home h=new home();
                h.start();
                dispose();
            }
        });
        add(btnclear);
        btnok= new JButton("Login");
        btnok.setBounds(500, 300, 100, 30);
        btnok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                name= tfusername.getText();
                pass= String.valueOf(pfpassword.getPassword());
                connectest mainsho=new connectest();
                mainsho.check(name, pass);
                dispose();
            }
        });
        add(btnok);

        getContentPane().setBackground(Color.WHITE);
       
        JLabel lbloginform= new JLabel("<html><u>STAFF LOGIN</u></html>");
        lbloginform.setFont(new Font("Osward", Font.BOLD, 38));
        lbloginform.setBounds(200, 50, 400, 50);
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
        stafelogin myframe= new stafelogin();
        myframe.initialize();
    }
}
