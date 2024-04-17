import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class form3 extends JFrame  {
    JRadioButton savacc, curracc,c1, c2, c3, c4, c5, foot;
    ButtonGroup cg;
    JButton btnback, btnfinish, btncencle; 
    String formno;
    long card_no, pin_no;
    String acctype="", facility= "";
    public void f3(String a){
        formno=a;
        setLayout(null);

        JLabel head= new JLabel("3 : Account Details");
        head.setBounds(150, 90, 650, 30);
        head.setFont(new Font("Osward", Font.BOLD, 30));
        add(head);

        JLabel acc= new JLabel("Account Type*:");
        acc.setFont(new Font("Raleway", Font.BOLD, 22));
        acc.setBounds(100, 180, 300, 30);
        add(acc);

        savacc= new JRadioButton("Saving Account");
        savacc.setFont(new Font("Raleway", Font.BOLD, 16));
        savacc.setBounds(110, 220, 150, 30);
        add(savacc);

        curracc= new JRadioButton("Current Account");
        curracc.setFont(new Font("Raleway", Font.BOLD, 16));
        curracc.setBounds(110, 250, 300, 30);
        add(curracc);

        cg= new ButtonGroup();
        cg.add(curracc);
        cg.add(savacc);

        JLabel card= new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 300, 30);
        add(card);

        JLabel cardd= new JLabel("(16-Digit Card Number)");
        cardd.setFont(new Font("Raleway", Font.BOLD, 12));
        cardd.setBounds(110, 320, 200, 30);
        add(cardd);

        JLabel cardno= new JLabel("XXXX-XXXX-XXXX-XXXX");
        cardno.setFont(new Font("Raleway", Font.BOLD, 22));
        cardno.setBounds(300, 300, 300, 30);
        add(cardno);

        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 360, 300, 30);
        add(pin);

        JLabel pind= new JLabel("(16-Digit Card Number)");
        pind.setFont(new Font("Raleway", Font.BOLD, 12));
        pind.setBounds(110, 380, 200, 30);
        add(pind);

        JLabel pinno= new JLabel("XXXX");
        pinno.setFont(new Font("Raleway", Font.BOLD, 22));
        pinno.setBounds(300, 360, 300,30);
        add(pinno);

        foot=new JRadioButton("I here by declare all the above given information are correct*");
        foot.setFont(new Font("Raleway", Font.BOLD, 18));
        foot.setBounds(100,580,600,30);
        add(foot);

        JLabel service= new JLabel("Services Required:");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 420, 300, 30);
        add(service);

        c1= new JRadioButton("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(110, 460, 200, 30);
        add(c1);

        c2= new JRadioButton("Cheque Book");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(310, 460, 200, 30);
        add(c2);

        c3= new JRadioButton("Net Banking ");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(110, 490, 200, 30);
        add(c3);

        c4= new JRadioButton("Email Alert");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(310, 490, 200, 30);
        add(c4);

        c5= new JRadioButton("E-Statement");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(110, 520, 200, 30);
        add(c5);

        btnback= new JButton("Back");
        btnback.setBounds(480, 700, 100, 30);
        btnback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                form2 form= new form2();
                form.f2(formno);
                dispose();
            }
        });
        add(btnback);

        btnfinish= new JButton("Finish");
        btnfinish.setBounds(600, 700, 100, 30);
        btnfinish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (savacc.isSelected()) {
                    acctype= "Saving Account";
                }else if (curracc.isSelected()) {
                    acctype= "Current Account";
                }
                Random random= new Random();
                card_no= Math.abs((random.nextLong() % 90000000L)) + 5050936000000000L; 
                pin_no= Math.abs((random.nextLong() % 9000L)) + 1000L; 
                if (c1.isSelected()) {
                    facility= facility + "ATM Card ,";
                }
                else if (c2.isSelected()) {
                    facility= facility + "Cheque Book ,";
                }
                else if (c3.isSelected()) {
                    facility= facility + "Net Banking ,";
                }
                else if (c4.isSelected()) {
                    facility= facility + "Email Alert ,";
                }
                else if (c5.isSelected()) {
                    facility= facility + "E-Statement ,";
                }
                if (acctype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please select the account type");
                }
                else if (foot.isSelected()) {
                    conn();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please select declaration ");
                }
            }
        });
        add(btnfinish);

        btncencle= new JButton("Cancel");
        btncencle.setBounds(720, 700, 100, 30);
        btncencle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                connectest c=new connectest();
                c.del(formno);
                stafework s=new stafework();
                s.work();
                dispose();
            }
        });
        add(btncencle);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    public void conn(){
        connectest con=new connectest();
        try{
            String c=""+card_no;
            con.stm= con.conn.createStatement();
            String sql="insert into form3 values('"+formno+"', '"+acctype+"','"+card_no+"','"+pin_no+"','"+facility+"')";
            String sql2="insert into acclog values('"+formno+"', '"+card_no+"','"+pin_no+"')";
            con.stm.executeUpdate(sql);
            con.stm.executeUpdate(sql2);
            JOptionPane.showMessageDialog(null, "Card no.: "+card_no+"\nPin no.: "+pin_no);
            deposit d=new deposit();
            d.depo(c);
            dispose();
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "error of connection data 3 = "+e);
        }
    }
    public static void main(String[] args) {
        form3 f=new form3();
        f.f3(null);
    }
}
