import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class form1 extends JFrame {
    static int a=6001;
    int  n;
    long no;
    JLabel name, fname, dob, gender, email, mstatus, address, city, state, pin, head, d1;
    String sname, sfname, sdob, sgender="", semail, smstatus, saddress, scity, sstate, spin, shead, f;
    JTextField tfname, tffname, tfdob, tfemail, tfaddress, tfcity, tfstate, tfpin;  
    JButton btnnext, btnback;
    Checkbox cbmale, cbfemale, cbother, cbmarried, cbunmarried, cbdivorse;
    CheckboxGroup hg, cg;
    public void f1(){
        Random random= new Random(); 
        no= Math.abs((random.nextLong() % 9000L)) + 1000L; 
        setLayout(null);
        

        hg= new CheckboxGroup();
        cg= new CheckboxGroup();
        cbmale= new Checkbox("Male", hg, false);
        cbmale.setBounds(400, 300, 60, 30);
        cbfemale= new Checkbox("Female", hg, false);
        cbfemale.setBounds(500, 300, 60, 30);
        cbother= new Checkbox("Other", hg, false);
        cbother.setBounds(600, 300, 60, 30);
        cbmarried= new Checkbox("Married", cg, false);
        cbmarried.setBounds(400, 400, 60, 30);
        cbunmarried= new Checkbox("Unmarried", cg, false);
        cbunmarried.setBounds(500, 400, 70, 30);
        cbdivorse= new Checkbox("Other", cg, false);
        cbdivorse.setBounds(600, 400, 60, 30); 
        add(cbmale);
        add(cbfemale);
        add(cbother);
        add(cbmarried);
        add(cbunmarried);
        add(cbdivorse);

        head= new JLabel("APPLICATION FORM NO. "+no);
        head.setBounds(100, 40, 650, 30);
        head.setFont(new Font("Osward", Font.BOLD, 34));
        add(head);

        d1= new JLabel("1 : PERSNAL DETAILS");
        d1.setBounds(150, 90, 500, 30);
        d1.setFont(new Font("Osward", Font.BOLD, 30));
        add(d1);


        name= new JLabel("Name* :");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 150, 300, 30);
        add(name);

        fname= new JLabel("Father Name* :");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 200, 300, 30);
        add(fname);


        dob= new JLabel("Date of Birth* :");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 250, 300, 30);
        add(dob);

        gender= new JLabel("Gender* :");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 300, 300, 30);
        add(gender);

        email= new JLabel("Email Address* :");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 350, 300, 30);
        add(email);

        mstatus= new JLabel("Marital Status :");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 22));
        mstatus.setBounds(100, 400, 300, 30);
        add(mstatus);

        address= new JLabel("Address* :");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 450, 300, 30);
        add(address);

        city= new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 500, 300, 30);
        add(city);

        state= new JLabel("State* :");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 550, 300, 30);
        add(state);

        pin= new JLabel("Pin Code* :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 600, 300, 30);
        add(pin);

        tfname= new JTextField();
        tfname.setBounds(400, 150, 300, 30);

        tffname= new JTextField();
        tffname.setBounds(400, 200, 300, 30);

        tfdob= new JTextField();
        tfdob.setBounds(400, 250, 300, 30);

        tfaddress= new JTextField();
        tfaddress.setBounds(400, 450, 300, 30);

        tfemail= new JTextField();
        tfemail.setBounds(400, 350, 300, 30);

        tfpin= new JTextField();
        tfpin.setBounds(400, 600, 300, 30);

        JLabel foot=new JLabel("(fields with * are mandatory to fill)");
        foot.setFont(new Font("Ralway", Font.BOLD, 18));
        foot.setBounds(100,650,600,30);

        tfcity= new JTextField();
        tfcity.setBounds(400, 500, 300, 30);

        tfstate= new JTextField();
        tfstate.setBounds(400, 550, 300, 30);
        add(tfname);
        add(tffname);
        add(tfdob);
        add(tfaddress);
        add(tfstate);
        add(tfcity);
        add(tfpin);
        add(tfemail);
        add(foot);

        btnnext= new JButton("Next");
        btnnext.setBounds(600, 700, 100, 30);
        btnnext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sname= tfname.getText();
                sfname= tffname.getText();
                sdob= tfdob.getText();
                saddress= tfaddress.getText();
                sstate= tfstate.getText();
                scity= tfcity.getText();
                spin= tfpin.getText();
                semail= tfemail.getText();
                try{
                    n=Integer.parseInt(spin);
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Please Enter Correct Pin Code ");
                    }
                if (cbmale.getState()) {
                    sgender= "Male";
                }
                else if (cbfemale.getState()) {
                    sgender= "Female"; 
                }
                else if (cbother.getState()) {
                    sgender= "Other";
                }

                if (cbmarried.getState()) {
                    smstatus= "Married";
                        }
                else if (cbunmarried.getState()) {
                    smstatus= "Unmaried"; 
                }
                else if (cbdivorse.getState()) {
                    smstatus= "Other";
                }
                if (sname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Name");
                }
                else if (sfname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Father Name");
                }
                else if (sdob.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Date of Birth");
                }
                else if (sgender.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please select Gender");
                }
                else if (saddress.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Address");
                }
                else if (sstate.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter State");
                }
                else if (semail.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Email Id");
                }
                else if (spin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Pin Code");
                }
                else if (spin.length()!=6) {
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Pin Code");
                }
                else{
                    f=""+no;
                    conn();
                }
            }
        });
        add(btnnext);

        btnback= new JButton("Back");
        btnback.setBounds(450, 700, 100, 30);
        btnback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                stafework back=new stafework();
                back.work();
                dispose();}
        });
        add(btnback);

        setTitle("welcome");
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void conn(){
        connectest con=new connectest();
        try{
            con.stm= con.conn.createStatement();
            String sql="insert into form1 values('"+no+"', '"+sname+"','"+sfname+"','"+sdob+"','"+sgender+"','"+semail+"','"+smstatus+"','"+saddress+"','"+scity+"','"+sstate+"','"+spin+"')";
            con.stm.executeUpdate(sql);
            form2 f2= new form2();
            f2.f2(f);
            dispose();

        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "connection error="+e);
            stafework s=new stafework();
            s.work();
            dispose();
        }
    }
    public static void main(String[] args) {
        form1 s=new form1();
        s.f1();
    }
}
