import java.sql.*;
import javax.swing.JOptionPane;
public class connectest {
    Connection conn=null;
    Statement stm=null;
    connectest(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            String r= e.getMessage();
            JOptionPane.showMessageDialog(null, "Error of driver = "+r);
        }
        try{
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            stm= conn.createStatement();}
        catch(Exception ex){
                String e= ex.getMessage();
                JOptionPane.showMessageDialog(null, "Error of connection = "+e);
            }
    }
    public void data(String n, String p) {
        String username= n;
        String password= p;
        try{
            stm= conn.createStatement();
            String sql="insert into log values('"+username+"', '"+password+"')";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Entered new staff");
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "Error = "+e);
        }
    }
    public void check(String n, String p){
        Statement stm=null;
        try{
            stm= conn.createStatement();
            String sql="select passw from log where usern= '"+n+"' and passw='"+p+"'";
            ResultSet resultset1 = stm.executeQuery(sql);
            if (resultset1.next()){ 
                stafework form= new stafework();
                form.work();
            }
            else{
                JOptionPane.showMessageDialog(null, "Stafe not found");
                home h=new home();
                h.start();
            }
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "Error = "+e);}
    }
    public void checkdelete(String n, String p){
        Statement stm=null;
        try{
            stm= conn.createStatement();
            String sql="select * from acclog where cardno= '"+n+"' and pinno='"+p+"'";
            ResultSet resultset1 = stm.executeQuery(sql);
            if (resultset1.next()){ 
                del(resultset1.getString("formno"));
                JOptionPane.showMessageDialog(null, "Account Deleted");
            }
            else{
                    JOptionPane.showMessageDialog(null, "Account not found");
            }
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "Error = "+e);}
    }
    public void del(String f){
        try{
            stm= conn.createStatement();
            String sql="delete from form1 where form_id='"+f+"'";
            stm.executeUpdate(sql);          
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "Error ="+e);
            
        }
    }
    public void usercheck(String n, String p){
        Statement stm=null;
        try{
            stm= conn.createStatement();
            String sql="select * from acclog where cardno= '"+n+"' and pinno='"+p+"'";
            ResultSet resultset1 = stm.executeQuery(sql);
            if (resultset1.next()){ 
                userwork form= new userwork();
                form.work(n);
            }
            else{
                JOptionPane.showMessageDialog(null, "User not found");
                home h=new home();
                h.start();
            }
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "Error = "+e);}
    }
    /*public void f1(){
        form1 form= new form1();
        JOptionPane.showMessageDialog(null, "data = "+form.no  );
        try{
            stm= conn.createStatement();
            String sql="insert into form1 values("+form.no+", '"+form.sname+"','"+form.sfname+"','"+form.sdob+"','"+form.sgender+"','"+form.semail+"','"+form.smstatus+"','"+form.saddress+"','"+form.scity+"','"+form.sstate+"','"+form.spin+"')";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "done");
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "data ="+e);
            form.f1();
        }
    }*/
    /*public void f2(){
        form2 form= new form2();
        try{
            stm= conn.createStatement();
            String sql="insert into form2 values("+form.formno+", '"+form.sreligion+"','"+form.scategory+"','"+form.sincome+"','"+form.seducation+"','"+form.soccupation+"','"+form.span+"','"+form.saadhar+"','"+form.sscitizen+"')";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "done");
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "error of connection data = "+e);
        }
    }*/
   /*public void f3(){
        form3 form= new form3();
        try{
            stm= conn.createStatement();
            String sql="insert into form3 values("+form.formno+", '"+form.acctype+"','"+form.card_no+"','"+form.pin_no+"','"+form.facility+"')";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "done");
        }
        catch(Exception ex){
            String e= ex.getMessage();
            JOptionPane.showMessageDialog(null, "error of connection data = "+e);
        }
    }*/
}
