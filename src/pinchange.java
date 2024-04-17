import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class pinchange extends JFrame implements ActionListener {
    JTextField npin, renpin;
    int n=0;
    String cardno;
    JButton change, back;
    void pinch(String c){
        cardno= c;
        JLabel head=new JLabel("<html><u>CHANGE PIN</u></html>");
        head.setFont(new Font("Osward", Font.BOLD, 38));
        head.setBounds(250,50,400,50);
        add(head);

        JLabel newpin=new JLabel("New Pin:");
        newpin.setFont(new Font("Raleway", Font.BOLD, 28));
        newpin.setBounds(150,150,300,30);
        add(newpin);

        npin=new JTextField();
        npin.setBounds(400,150,300,30);
        add(npin);

        JLabel repin=new JLabel("Re-Enter New Pin:");
        repin.setFont(new Font("Raleway", Font.BOLD, 28));
        repin.setBounds(150,200,300,30);
        add(repin);

        renpin=new JTextField();
        renpin.setBounds(400,200,300,30);
        add(renpin);

        change=new JButton("Change Pin");
        change.setBounds(250,280,150,30);
        change.addActionListener(this);
        add(change);

        back=new JButton("Back");
        back.setBounds(440,280,150,30);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800,480);
        setLocation(350,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==change) {
            try{
                String pin=npin.getText();
                String rpin=renpin.getText();
                try{
                    n=Integer.parseInt(pin);
                }
                catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Enter Integer Only");
                }
                if (n!=0) {
                    if (pin.equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter New Pin");
                    }
                    else if (pin.length()!=4) {
                        JOptionPane.showMessageDialog(null, "PIN must be of 4 digit");
                    }
                    else if (rpin.equals("")) {
                        JOptionPane.showMessageDialog(null, "Re-Enter New Pin");
                    }
                    else if (!pin.equals(rpin) ) {
                        JOptionPane.showMessageDialog(null, "Pin not match");
                    }
                    else{
                        connectest con= new connectest();    
                        con.stm= con.conn.createStatement();
                        String sql="update acclog set pinno= '"+pin+"' where cardno='"+cardno+"'";
                        String sql1="update form3 set pin_no= '"+pin+"' where card_no='"+cardno+"'";
                        con.stm.executeUpdate(sql);
                        con.stm.executeUpdate(sql1);
                        JOptionPane.showMessageDialog(null, "done");
                        userlogin u=new userlogin();
                        u.initialize();
                        dispose();
                    }
                } 
            }
            catch(Exception ex){
                String e= ex.getMessage();
                JOptionPane.showMessageDialog(null, "error of connection data 2 = "+e);
            } 
        }
        if (ae.getSource()==back) {
            userwork u= new userwork();
            u.work(cardno);
            dispose();
        }
    }
    public static void main(String[] args) {
        pinchange p=new pinchange();
        p.pinch(null);
    }
}
