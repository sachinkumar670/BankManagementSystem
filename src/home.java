import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class home extends JFrame implements ActionListener{
    JButton user, staff;
    public void start(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/home.jpeg"));
        Image i2=i1.getImage().getScaledInstance(600,480,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel lable=new JLabel(i3);
        add(lable); 

        JLabel head=new JLabel("APNA BANK");
        head.setBounds(180,130,500,50);
        head.setFont(new Font("Osward", Font.BOLD, 38));
        head.setBackground(Color.white);
        lable.add(head);

        user=new JButton("User Login");
        user.setBounds(213,218,160,24);
        user.setBackground(Color.white);
        user.addActionListener(this);
        lable.add(user);

        staff=new JButton("Staff Login");
        staff.setBounds(213,260,160,24);
        staff.addActionListener(this);
        staff.setBackground(Color.white);
        lable.add(staff);

        setSize(600,480);
        setLocation(400,220);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==staff) {
            stafelogin s=new stafelogin();
            s.initialize();
            dispose();
        }
        if (e.getSource()==user) {
            userlogin s=new userlogin();
            s.initialize();
            dispose();
        }
    }
    public static void main(String[] args) {
        home h=new home();
        h.start();
    }
}