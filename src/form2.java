import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class form2 extends JFrame {
    JLabel religion, category, income, education, occupation, pan, aadhar, scitizen, head;
    String sreligion, scategory, sincome, seducation, soccupation, span, sscitizen, saadhar, formno;;
    JTextField tfpan, tfaadhar, tfincome;  
    Choice lreligion, lcategory, ledu, loccu, lincome;
    JButton btnnext, btnback;
    Checkbox cby, cbn;
    CheckboxGroup hg, cg;
    public void f2(String a){
        formno= a;
        setLayout(null);

        hg= new CheckboxGroup();
        cg= new CheckboxGroup();
        cby= new Checkbox("Yes", hg, false);
        cby.setBounds(450, 500, 50, 30);
        cbn= new Checkbox("No", hg, false);
        cbn.setBounds(550, 500, 50, 30);
        add(cby);
        add(cbn);

        lreligion= new Choice();
        lreligion.setBounds(450, 150, 300, 30);
        lreligion.add("Hindu");
        lreligion.add("Muslim");
        lreligion.add("Sikh");
        lreligion.add("other");
        add(lreligion);

        lcategory= new Choice();
        lcategory.setBounds(450, 200, 300, 30);
        lcategory.add("General");
        lcategory.add("OBC");
        lcategory.add("SC/ST");
        add(lcategory);

        ledu= new Choice();
        ledu.setBounds(450, 300, 300, 30);
        ledu.add("None");
        ledu.add("10th Pass");
        ledu.add("12th Pass");
        ledu.add("Graduate");
        ledu.add("Masters");
        add(ledu);

        loccu= new Choice();
        loccu.setBounds(450, 350, 300, 30);
        loccu.add("Goverment-Employee");
        loccu.add("private-Employee");
        loccu.add("Self-Employee");
        add(loccu);

        head= new JLabel("2 : Additional Details");
        head.setBounds(150, 90, 650, 30);
        head.setFont(new Font("Osward", Font.BOLD, 30));
        add(head);

        religion= new JLabel("Religion :");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100, 150, 300, 30);
        add(religion);

        category= new JLabel("Category :");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(100, 200, 300, 30);
        add(category);

        lincome= new Choice();
        lincome.setBounds(450, 250, 300, 30);
        lincome.add("Null");
        lincome.add("<1,50,000");
        lincome.add("<2,50,000");
        lincome.add("<5,00,000");
        lincome.add("<10,00,000");
        lincome.add("Upto 10,00,000");
        add(lincome);

        income= new JLabel("Income :");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100, 250, 300, 30);
        add(income);

        education= new JLabel("Education Qualification :");
        education.setFont(new Font("Raleway", Font.BOLD, 22));
        education.setBounds(100, 300, 300, 30);
        add(education);

        occupation= new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation.setBounds(100, 350, 300, 30);
        add(occupation);

        pan= new JLabel("Pan Number :");
        pan.setFont(new Font("Raleway", Font.BOLD, 22));
        pan.setBounds(100, 400, 300, 30);
        add(pan);

        aadhar= new JLabel("Aadhar Number* :");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 22));
        aadhar.setBounds(100, 450, 300, 30);
        add(aadhar);

        scitizen= new JLabel("Senior Citizen :");
        scitizen.setFont(new Font("Raleway", Font.BOLD, 22));
        scitizen.setBounds(100, 500, 300, 30);
        add(scitizen);

        tfpan= new JTextField();
        tfpan.setBounds(450, 400, 300, 30);
        add(tfpan);

        tfaadhar= new JTextField();
        tfaadhar.setBounds(450, 450, 300, 30);
        add(tfaadhar);

        btnnext= new JButton("Next");
        btnnext.setBounds(600, 700, 100, 30);
        btnnext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sreligion= lreligion.getSelectedItem();
                sincome= lincome.getSelectedItem();
                scategory= lcategory.getSelectedItem();
                seducation= ledu.getSelectedItem();
                soccupation= loccu.getSelectedItem();
                span= tfpan.getText();
                saadhar = tfaadhar.getText();
                if (cby.getState()) {
                    sscitizen= "yes";
                }
                else if (cbn.getState()) {
                    sscitizen= "no"; 
                }
                if (saadhar.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Aadhar no.");
                }
                else if (saadhar.length()!=12){ 
                    JOptionPane.showMessageDialog(null, "Aadhar no. should be of 12 digit ");
                }
                else{
                    conn();
                }
            }
        });
        add(btnnext);

        btnback= new JButton("Back");
        btnback.setBounds(480, 700, 100, 30);
        btnback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                form1 f= new form1();
                f.f1();
                dispose();
            }
        });
        add(btnback);

        setTitle("welcome");
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void conn(){
        connectest con= new connectest();
        try{
            con.stm= con.conn.createStatement();
            String sql="insert into form2 values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+sscitizen+"')";
            con.stm.executeUpdate(sql);
            form3 f= new form3();
            f.f3(formno);
            dispose();
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "error of connection data 2 = "+e);
        }
    }
    public static void main(String[] args) {
        form2 f=new form2();
        f.f2(null);
    }
}
