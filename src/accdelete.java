import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class accdelete extends JFrame {
    JLabel pinno, formno, loginform;
    JTextField tfpinno, tfcardno;
    JButton  btnclear, btndelete, btnback;
    String name, pass;
    public void delete()
    {
        
        formno= new JLabel("Card no.:");
        formno.setBounds(150, 150, 400, 40);
        formno.setFont(new Font("Raleway", Font.BOLD, 28));
        add(formno);

        pinno = new JLabel("Pin no.:");
        pinno.setBounds(150, 200, 400, 40);
        pinno.setFont(new Font("Raleway", Font.BOLD, 28));
        add(pinno);

        tfcardno = new JTextField();
        tfcardno.setBounds(350, 150, 250, 30);
        add(tfcardno);
        

        tfpinno = new JTextField();
        tfpinno.setBounds(350, 200, 250, 30);
        add(tfpinno);
        
        btndelete= new JButton("Delete");
        btndelete.setBounds(480, 300, 100, 30);
        btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                name= tfcardno.getText();
                pass= tfpinno.getText();

                connectest mainsho=new connectest();
                mainsho.checkdelete(name, pass);
                stafework f=new stafework();
                f.work();                
                dispose();
            }
        });
        add(btndelete);
        /*btnclear= new JButton("Clear");
        btnclear.setBounds(610, 300, 100, 30);
        btnclear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tfcardno.setText("");
                tfpinno.setText("");
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
       
        JLabel lbloginform= new JLabel("<html><u>DELETE ACCOUNT</u></html>");
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
        accdelete a=new accdelete();
        a.delete();
    }
}