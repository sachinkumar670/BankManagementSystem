import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
public class minist extends JFrame {
    String card;
    int balance=0;
    public void stm(String c){
        card=c;

        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank=new JLabel("APNA BANK");
        bank.setBounds(150,20,300,20);
        add(bank);

        JLabel bal=new JLabel();
        bal.setBounds(20,400,300,20);
        add(bal);

        JLabel cn=new JLabel("Card No.:");
        cn.setBounds(20,80,100,20);
        add(cn);

        JLabel cardno=new JLabel(card.substring(0,4)+"xxxxxxxx"+card.substring(12));
        cardno.setBounds(120,80,300,20);
        add(cardno);

        try{
            connectest con=new connectest();
            con.stm= con.conn.createStatement();
            ResultSet rs=con.stm.executeQuery("select * from bank where card_no='"+card+"'");
            while (rs.next()) {
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    balance+=rs.getInt("amount");
                }
                else{
                    balance-=rs.getInt("amount");
                }
                bal.setText("Current Account Balance is "+balance);
            }

        }
        catch (Exception e) {
            String es=e.getMessage();
            JOptionPane.showMessageDialog(null, "connection error="+es);
        }


        setLayout(null);
        setTitle("Mini-Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    public static void main(String[] args) {
        minist m=new minist();
        m.stm(null);
    }
}
