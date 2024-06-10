import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
public class cancel extends JFrame implements ActionListener,FocusListener
{
    
    JTextField txtCancelID=new JTextField("");
    JTextField txtBookingID=new JTextField("");
    JTextField txtDateOfCancel=new JTextField("");
    JTextField txtCustomerID=new JTextField("");
    JTextArea txtReason=new JTextArea("");
    JTextField txtAmountPaid=new JTextField("");
    JTextField txtAmountDeducted=new JTextField("");
    JTextField txtAmountRefunded=new JTextField("");

    JButton btnNew=new JButton("");
    JButton btnSubmit=new JButton("");
    JButton btnSearch=new JButton("");
    JButton btnCancel=new JButton("");
    
    String sdate[]={"select","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/cancel.png"));
    public cancel()
    {
   // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   // setUndecorated(true);
    txtCancelID.setEditable(false);
    setLayout(null);
    setVisible(true);
    //setResizable(false);
    setSize(2500,1490); 
    txtAmountPaid.setEditable(false);
        txtAmountRefunded.setEditable(false);
        txtAmountDeducted.setEditable(false);
    txtCancelID.setFont(new Font("Georgia",Font.BOLD,25));
    txtBookingID.setFont(new Font("Georgia",Font.BOLD,25));
    txtDateOfCancel.setFont(new Font("Georgia",Font.BOLD,23));
    txtCustomerID.setFont(new Font("Georgia",Font.BOLD,25));
    txtReason.setFont(new Font("Georgia",Font.BOLD,25));
    txtAmountPaid.setFont(new Font("Georgia",Font.BOLD,25));
    txtAmountDeducted.setFont(new Font("Georgia",Font.BOLD,25));
    txtAmountRefunded.setFont(new Font("Georgia",Font.BOLD,25));

     txtCancelID.setBorder(null);
     txtBookingID.setBorder(null);
     txtDateOfCancel.setBorder(null);
     txtCustomerID.setBorder(null);
     txtReason.setBorder(null);
     txtAmountPaid.setBorder(null);
     txtAmountDeducted.setBorder(null);
     txtAmountRefunded.setBorder(null);
     btnNew.setBorder(null);
     btnSubmit.setBorder(null);
     btnSearch.setBorder(null);
     btnCancel.setBorder(null);

     txtCancelID.setOpaque(false);
     txtBookingID.setOpaque(false);
     txtDateOfCancel.setOpaque(false);
     txtCustomerID.setOpaque(false);
     txtReason.setOpaque(false);
     txtAmountPaid.setOpaque(false);
     txtAmountDeducted.setOpaque(false);
     txtAmountRefunded.setOpaque(false);
    
    txtCancelID.setBounds(498,155,200,23);
    txtBookingID.setBounds(498,205,200,23);
    txtDateOfCancel.setBounds(1313,122,150,23);
    txtCustomerID.setBounds(498,255,450,23);
    txtReason.setBounds(498,310,495,100);
    txtAmountPaid.setBounds(498,500,200,23);
    txtAmountDeducted.setBounds(498,545,200,23);
    txtAmountRefunded.setBounds(498,585,200,23);
    

    btnNew.setContentAreaFilled(false);
    btnSubmit.setContentAreaFilled(false);
    btnSearch.setContentAreaFilled(false);
    btnCancel.setContentAreaFilled(false);

     btnNew.setBounds(350,700,120,40);
     btnSubmit.setBounds(495,700,120,40);
     btnSearch.setBounds(630,690,120,40);
     btnCancel.setBounds(1462,680,75,75);
        
    add(txtCancelID);
    add(txtBookingID);
    add(txtDateOfCancel);
    add(txtCustomerID);
    add(txtReason);
    add(txtAmountPaid);
    add(txtAmountRefunded);
    add(txtAmountDeducted);
    
    add(btnNew);
    add(btnSubmit);
    add(btnSearch);
    add(btnCancel);

    add(limg);
  limg.setBounds(-15,-43,this.getWidth(),this.getHeight());
  
    btnNew.addActionListener(this);
    btnSubmit.addActionListener(this);
    btnSearch.addActionListener(this);
    btnCancel.addActionListener(this);
    txtCustomerID.addFocusListener(this);
    txtCancelID.addFocusListener(this);
    txtBookingID.addFocusListener(this);
    txtAmountRefunded.addFocusListener(this);
    txtAmountDeducted.addFocusListener(this);
    }
    public void focusGained(FocusEvent fe)
    {
         if(fe.getSource()==txtAmountRefunded || fe.getSource()== txtAmountDeducted)
            {
                try
                {
                    double i=Double.valueOf(txtAmountPaid.getText());
                    double sin=Double.valueOf((i*0.1));
                    double sma=Double.valueOf(i-sin);
                    txtAmountRefunded.setText(""+sin);
                    txtAmountDeducted.setText(""+sma);
                }
                catch(Exception e1)
                {
                    System.out.print(e1);
                }
            }
    }
    public void focusLost(FocusEvent fe)
    {
        if(fe.getComponent()==txtBookingID)
        {
            try
            {
                String stat="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();

                String str="select * from bookingtbl where booking_ID='"+txtBookingID.getText()+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    txtBookingID.setText(res.getString(1));
                    txtCustomerID.setText(res.getString(9));
                }
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
        }
        if(fe.getComponent()==txtBookingID)
            {
                try
                {
                    String stat="";
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                    Statement st=con.createStatement();
                    String str="select * from paymenttbl where booking_ID='"+txtBookingID.getText()+"'";
                    ResultSet res=st.executeQuery(str);
                    while(res.next())
                        {
                            txtAmountPaid.setText(res.getString(15));
                        }
                }
                catch(Exception e1)
                {
                    System.out.print(e1);
                }
            }
      }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnNew)
        {
          txtDateOfCancel.setEnabled(true);
            try
            {
                int ctr=1;
                Calendar cal=Calendar.getInstance();
String sdate=cal.get(Calendar.YEAR)+"-"+(String.format("%02d",cal.get(Calendar.MONTH)+1))+"-"+String.format("%02d",cal.get(Calendar.DATE));                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str1="select cancelid from keytbl";
                ResultSet res=st.executeQuery(str1);
                while(res.next())
                {
                 ctr=Integer.parseInt(res.getString(1));
                }
                while(res.next())
                {
                    ctr=Integer.parseInt(res.getString(1));
                }
                if(ctr>0&&ctr<=9)
                {
                  txtCancelID.setText("C00"+ctr);
                }
                else if(ctr>=10&&ctr<=99)
                {
                 txtCancelID.setText("C0"+ctr);
                }
                else if(ctr>=100)
                {
                 txtCancelID.setText("C"+ctr);
                }                
                txtDateOfCancel.setText(sdate);
                txtBookingID.setText("");
                txtCustomerID.setText("");
                txtReason.setText("");
                txtAmountPaid.setText("");
                txtAmountDeducted.setText("");
                txtAmountRefunded.setText("");
                }
                catch( Exception e1)
                {
                  System.out.println(e1);
                }
        }
        if(e.getSource()==btnSubmit)
        {
            int flg=1;
            try
            {
               flg=1;
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
               String str1="select * from canceltbl where booking_ID='"+txtBookingID.getText()+"'";
               Statement st1=con.createStatement();
               ResultSet res1=st1.executeQuery(str1);
               if(res1.next())
               {
                JOptionPane.showMessageDialog(null,"Already Cancelled");
               }
               else
               {
                  String str="insert into canceltbl(cancel_ID,booking_ID,date_of_cancel,reason,customer_ID,amount_paid,amount_deducted,amount_refunded) values(?,?,?,?,?,?,?,?)";
                  PreparedStatement ps=con.prepareStatement(str);
                  ps.setString(1,(txtCancelID.getText()));
                  ps.setString(2,(txtBookingID.getText()));
                  ps.setString(3,(txtDateOfCancel.getText()));
                  ps.setString(4,(txtReason.getText()));
                  ps.setString(5,(txtCustomerID.getText()));
                  ps.setString(6,(txtAmountPaid.getText()));
                  ps.setString(7,(txtAmountDeducted.getText()));
                  ps.setString(8,(txtAmountRefunded.getText()));
            
                    if(flg==1)
                    {
                     ps.executeUpdate();
                     String strr="update keytbl set cancelid=cancelid+1";
                     Statement st=con.createStatement();
                     st.executeUpdate(strr);
                     JOptionPane.showMessageDialog(null,"Record saved");
                     
                    }
                }
            }
            catch(Exception ee)
            {
             System.out.println(ee);
            }
        }
        if(e.getSource()==btnSearch)
        {
          txtDateOfCancel.setEnabled(true);
            try
            {
              int flag=0;
              String stat="";
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
              Statement st=con.createStatement();
              String stt=JOptionPane.showInputDialog(null,"Enter Cancellation ID");
              txtCancelID.setText(stt);
              String str="select * from canceltbl where cancel_ID='"+txtCancelID.getText()+"'";
              ResultSet res=st.executeQuery(str);
              while(res.next())
              {
                flag=1;
                txtBookingID.setText(res.getString(2));      

                txtDateOfCancel.setText(res.getString(3));
                txtCustomerID.setText(res.getString(5));
                txtReason.setText(res.getString(4));
                txtAmountPaid.setText(res.getString(6));
                txtAmountRefunded.setText(res.getString(8));
                txtAmountDeducted.setText(res.getString(7)); 
               
              }
              if(flag==0)
                JOptionPane.showMessageDialog(null,"NO SUCH RECORD");
            }
            catch(Exception ce)
              {
                JOptionPane.showMessageDialog(null,ce);
              }
        }
        if(e.getSource()==btnCancel)
        {
            this.dispose();
        }
    }
   public static void main(String args[])throws IOException
   {
    cancel obj=new cancel();
   }
}