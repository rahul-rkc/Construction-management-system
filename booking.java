import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
public class booking extends JFrame implements ActionListener,FocusListener
{
    int flg=0;
    Border border = BorderFactory.createLineBorder(Color.red);
    JTextField txtBookingID=new JTextField("");
    JTextField txtDateOfBooking=new JTextField("");
    JTextField txtFlatNo=new JTextField("");
    JTextField txtDuplexNo=new JTextField("");
    JTextField txtBuiltUpArea=new JTextField("");
    JTextField txtMaintainance=new JTextField("");
    JTextField txtPrice=new JTextField("");
    JTextField txtCustomerID=new JTextField("");
    JTextField txtCustomerName=new JTextField("");
    JTextField txtAadharNo=new JTextField("");
    JTextField txtContactNo=new JTextField("");
    JTextArea txtAddress=new JTextArea("");
    JTextField txtdate=new JTextField("");
  
    JButton btnNew=new JButton("");
    JButton btnBook=new JButton("");
    JButton btnSearch=new JButton("");
    JButton btnEdit=new JButton("");
    JButton btnCancel=new JButton("");
    
    String sdate[]={"select","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String smonth[]={"select","01","02","03","04","05","06","07","08","09","10","11","12"};
    String syear[]={"select","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
    JComboBox cmbDOB0=new JComboBox(sdate);
    JComboBox cmbDOB1=new JComboBox(smonth);
    JComboBox cmbDOB2=new JComboBox(syear);

    String btype[]={"select","Flat","Duplex"};
    JComboBox cmbBookingType=new JComboBox(btype);

    JRadioButton rbmale=new JRadioButton("Male");
    JRadioButton rbfemale=new JRadioButton("Female");
    ButtonGroup bg=new ButtonGroup();

   JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/booking.png"));

    public booking()
    {
   // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // setUndecorated(true);
    setLayout(null);
    setVisible(true);
    setSize(2500,1500);
    txtBookingID.setEditable(false);
    
    // txtBookingID.setFont(new Font("Georgia",Font.BOLD,30));
    // txtDateOfBooking.setFont(new Font("Georgia",Font.BOLD,30));
    // txtFlatNo.setFont(new Font("Georgia",Font.BOLD,30));
    // txtDuplexNo.setFont(new Font("Georgia",Font.BOLD,30));
    // txtBuiltUpArea.setFont(new Font("Georgia",Font.BOLD,30));
    // txtMaintainance.setFont(new Font("Georgia",Font.BOLD,30));
    // txtPrice.setFont(new Font("Georgia",Font.BOLD,30));
    // txtCustomerID.setFont(new Font("Georgia",Font.BOLD,30));
    // txtCustomerName.setFont(new Font("Georgia",Font.BOLD,30));
    // txtAadharNo.setFont(new Font("Georgia",Font.BOLD,30));
    // txtContactNo.setFont(new Font("Georgia",Font.BOLD,30));
    // txtAddress.setFont(new Font("Georgia",Font.BOLD,30));
     
    // btnNew.setFont(new Font("Georgia",Font.BOLD,30));
    // btnBook.setFont(new Font("Georgia",Font.BOLD,30));
    // btnSearch.setFont(new Font("Georgia",Font.BOLD,30));
    // btnEdit.setFont(new Font("Georgia",Font.BOLD,30));
    // btnCancel.setFont(new Font("Georgia",Font.BOLD,30));
    
    // cmbDOB0.setFont(new Font("Georgia",Font.BOLD,25));
    // cmbDOB1.setFont(new Font("Georgia",Font.BOLD,25));
    // cmbDOB2.setFont(new Font("Georgia",Font.BOLD,25));
    // cmbBookingType.setFont(new Font("Georgia",Font.BOLD,25));

    // rbmale.setFont(new Font("Georgia",Font.BOLD,25));
    // rbfemale.setFont(new Font("Georgia",Font.BOLD,25));

    //Border of TextBox
    txtBookingID.setBorder(null);
    txtDateOfBooking.setBorder(null);
    txtFlatNo.setBorder(null);
    txtDuplexNo.setBorder(null);
    txtBuiltUpArea.setBorder(null);
    txtMaintainance.setBorder(null);
    txtPrice.setBorder(null);
    txtCustomerID.setBorder(null);
    txtCustomerName.setBorder(null);
    txtAadharNo.setBorder(null);
    txtAddress.setBorder(null);

    //opaqueness of textBox
    txtBookingID.setOpaque(false);
    txtDateOfBooking.setOpaque(false);
    txtFlatNo.setOpaque(false);
    txtDuplexNo.setOpaque(false);
    txtBuiltUpArea.setOpaque(false);
    txtMaintainance.setOpaque(false);
    txtPrice.setOpaque(false);
    txtCustomerID.setOpaque(false);
    txtCustomerName.setOpaque(false);
    txtAadharNo.setOpaque(false);
    txtContactNo.setOpaque(false);
    txtContactNo.setBorder(null);
    txtAddress.setOpaque(false);

    //SetBounds
    txtBookingID.setBounds(360,216,300,22);
    txtDateOfBooking.setBounds(360,268,300,22);
    txtFlatNo.setBounds(360,366,300,22);
    txtDuplexNo.setBounds(360,413,300,22);
    txtBuiltUpArea.setBounds(362,461,300,22);
    txtMaintainance.setBounds(363,509,300,22);
    txtPrice.setBounds(363,556,300,22);
    txtCustomerID.setBounds(1090,220,300,22);
    txtCustomerName.setBounds(1090,280,300,22);
    txtAadharNo.setBounds(1091,436,300,22);
    txtContactNo.setBounds(1091,491,300,22);
    txtAddress.setBounds(1091,549,338,33);


    rbmale.setBackground(new Color(33,178,201));
    rbfemale.setBackground(new Color(33,178,201));

    cmbBookingType.setBounds(361,316,343,25);
    cmbDOB0.setBounds(1091,328,80,25);
    cmbDOB1.setBounds(1191,328,80,25);
    cmbDOB2.setBounds(1291,328,80,25);

    rbmale.setBounds(1091,376,80,34);
    rbfemale.setBounds(1191,376,80,34);

    btnNew.setBounds(390,727,116,35);
    btnBook.setBounds(540,727,115,35);
    btnSearch.setBounds(690,727,115,35);
    btnEdit.setBounds(837,723,118,35);
    btnCancel.setBounds(1460,689,97,81);

    //color of the combo button
    cmbBookingType.setBackground(new Color(54,201,222));
    cmbDOB0.setBackground(new Color(54,201,222));
    cmbDOB1.setBackground(new Color(54,201,222));
    cmbDOB2.setBackground(new Color(54,201,222));

    //setting Content Area Filled Property
    btnNew.setContentAreaFilled(false);
    btnBook.setContentAreaFilled(false);
    btnSearch.setContentAreaFilled(false);
    btnEdit.setContentAreaFilled(false);
    btnCancel.setContentAreaFilled(false);

   
    add(txtBookingID);
    add(txtDateOfBooking);
    add(txtFlatNo);
    add(txtDuplexNo);
    add(txtBuiltUpArea);
    add(txtMaintainance);
    add(txtPrice);
    add(txtCustomerID);
    add(txtCustomerName);
    add(txtContactNo);
    add(txtAadharNo);
    add(txtAddress);
    
    add(btnNew);
    add(btnBook);
    add(btnSearch);
    add(btnEdit);
    add(btnCancel);

    add(cmbDOB0);
    add(cmbDOB1);
    add(cmbDOB2);
    add(cmbBookingType);

    add(rbmale);
    add(rbfemale);
    bg.add(rbmale);
    bg.add(rbfemale);
    
     add(limg);
  limg.setBounds(-15,-43,this.getWidth(),this.getHeight());
    
    btnNew.addActionListener(this);
    btnBook.addActionListener(this);
    btnSearch.addActionListener(this);
    btnEdit.addActionListener(this);
    btnCancel.addActionListener(this);
    cmbBookingType.addFocusListener(this);
    txtPrice.addFocusListener(this);
    txtBuiltUpArea.addFocusListener(this);
    txtMaintainance.addFocusListener(this);
    txtCustomerID.addFocusListener(this);
    }
    public void focusGained(FocusEvent fe)
    {
         
    }
    public void focusLost(FocusEvent fe)
    {                        
      if(fe.getComponent()==cmbBookingType)
      {
        if(cmbBookingType.getSelectedItem().equals("Flat"))
          {
            txtDuplexNo.setEditable(false);
            try
            {
                txtDuplexNo.setText("NA");
                txtFlatNo.setEditable(true);
                String stat="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str="select * from flattbl where flat_no='"+txtFlatNo.getText()+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    txtBuiltUpArea.setText(res.getString(4));
                    txtMaintainance.setText(res.getString(5));
                    txtPrice.setText(res.getString(6));
                }
            }    
            catch(Exception e)
            {
                System.out.print(e);
            }
           }
          else
          {
            txtFlatNo.setEditable(false);
            try
            {
                txtFlatNo.setText("NA");
                txtDuplexNo.setEditable(true);
                String stat="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str="select * from duplextbl where duplex_no='"+txtDuplexNo.getText()+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    txtBuiltUpArea.setText(res.getString(3));
                    txtMaintainance.setText(res.getString(4));
                    txtPrice.setText(res.getString(5));
                }
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
          }
      }
      if(fe.getComponent()==txtCustomerID)
          {
            try
            {
                String stat="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str="select * from customertbl where customer_ID='"+txtCustomerID.getText()+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    txtCustomerName.setText(res.getString(2));
                    txtAadharNo.setText(res.getString(4));
                    txtContactNo.setText(res.getString(5));
                    txtAddress.setText(res.getString(7));
                    if(res.getString(6).equals("Male"))
                        rbmale.setSelected(true);                 
                    else 
                        rbfemale.setSelected(true);
                    String dd[]=res.getString(3).toString().split("-");
                    cmbDOB0.setSelectedItem(dd[2]);
                    cmbDOB1.setSelectedItem(""+dd[1]);
                    System.out.println("h"+dd[1]);
                    cmbDOB2.setSelectedItem(dd[0]);
                }
            }    
            catch(Exception e)
            {
                System.out.print(e);
            }
          }
      if(fe.getComponent()==txtFlatNo)
      {
         try
            {
                String stat="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str="select * from flattbl where flat_no='"+txtFlatNo.getText()+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    txtDuplexNo.setText("NA");
                    txtBuiltUpArea.setText(res.getString(4));
                    txtMaintainance.setText(res.getString(5));
                    txtPrice.setText(res.getString(6));
                }
            }
         catch(Exception ee)
         {
            System.out.print(ee);
         }
     }

     if(fe.getComponent()==txtDuplexNo)
      {
         try
            {
                String stat="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str="select * from duplextbl where duplex_no='"+txtDuplexNo.getText()+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    txtFlatNo.setText("NA");
                    txtBuiltUpArea.setText(res.getString(3));
                    txtMaintainance.setText(res.getString(4));
                    txtPrice.setText(res.getString(5));
                }
            }
         catch(Exception ee1)
         {
            System.out.print(ee1);
         }
     }
     if(fe.getSource()==txtBuiltUpArea)
         {
          int ctr0=0;
          String s=txtBuiltUpArea.getText();
          if(s.equals(""))
          {
          }
          else
          {
          for( int i=0;i<s.length();i++)
            {
              if(s.charAt(i)>='0' && s.charAt(i)<='9')
                {
                  ctr0++;
                }
              else
                {         
                   JOptionPane.showMessageDialog(null,"Enter Correct BuiltUp Area");
                   txtBuiltUpArea.setText("");
                   break;
                }                      
            }
          }
          } 

      if(fe.getSource()==txtPrice)
         {
          int ctr1=0;
          String s1=txtPrice.getText();
          if(s1.equals(""))
          {
          }
          else
          {
          for( int i=0;i<s1.length();i++)
             {
                if(s1.charAt(i)>='0' && s1.charAt(i)<='9')
                {
                  ctr1++;
                }
                else
                {         
                   JOptionPane.showMessageDialog(null,"Enter Correct Price");
                   txtPrice.setText("");
                   break;
                }                   
              }
          }
         }
      if(fe.getSource()==txtMaintainance)
         {
          int ctr2=0;
          String s2=txtMaintainance.getText();
          if(s2.equals(""))
          {
          }
          else
          {
             for( int i=0;i<s2.length();i++)
                {
                  if(s2.charAt(i)>='0' && s2.charAt(i)<='9')
                   {
                     ctr2++;
                   }
                  else
                  {
                   JOptionPane.showMessageDialog(null,"Enter Correct Maintainance cost");
                   txtMaintainance.setText("");
                   break;
                }                      
          }
        
      }
    }
    if(fe.getSource()==txtCustomerName)
     {
       int ctr=0;
       String s=txtCustomerName.getText();
       txtCustomerName.setBackground(Color.WHITE);
       if(s.equals(""))
       {}
       else
       {
         for( int i=0;i<s.length();i++)
          {
            if(s.charAt(i)>='a' && s.charAt(i)<='z'||s.charAt(i)>='A' && s.charAt(i)<='Z')
              {
                 ctr++;
              }
              else
                {         
                   JOptionPane.showMessageDialog(null,"Enter Name in Correct Format");
                   txtCustomerName.setText("");
                   break;
                }
          }
        }
      }
      if(fe.getSource()==txtAadharNo)
        {
          int ctr=0;
          String s=txtAadharNo.getText();
          if(s.equals(""))
           {}
          else
           {
            for( int i=0;i<s.length();i++)
             {
              if(s.charAt(i)>='0' && s.charAt(i)<='9')
              {
                 ctr++;
              }
              else
              {         
                 JOptionPane.showMessageDialog(null,"Enter Correct Aadhar Number");
                 txtAadharNo.setText("");
                 break;
              }
             }
            }
         }
        if(fe.getSource()==txtContactNo)
        {
          int ctr=0;
          String s=txtContactNo.getText();
          if(s.equals(""))
           {}
          else
           {
            for( int i=0;i<s.length();i++)
             {
              if(s.charAt(i)>='0' && s.charAt(i)<='9')
              {
                 ctr++;
              }
              else
              {         
                 JOptionPane.showMessageDialog(null,"Enter Correct Contact Number");
                 txtContactNo.setText("");
                 break;
              }
             }
            }
         }
 }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnNew)
        {
            try
            {
                btnEdit.setEnabled(false);
                btnBook.setEnabled(true);
                txtdate.setEnabled(true);
                int ctr=1;
                Calendar cal=Calendar.getInstance();
                String sdate=cal.get(Calendar.YEAR)+"-"+(String.format("%02d",cal.get(Calendar.MONTH)+1))+"-"+String.format("%02d",cal.get(Calendar.DATE));
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str1="select bookid from keytbl";
                ResultSet res=st.executeQuery(str1);
                  while(res.next())
                  {
                      ctr=Integer.parseInt(res.getString(1));
                  }
                  if(ctr>0&&ctr<=9)
                  {
                    txtBookingID.setText("B00"+ctr);
                  }
                  else if(ctr>=10&&ctr<=99)
                  {
                   txtBookingID.setText("B0"+ctr);
                  }
                  else if(ctr>=100)
                  {
                   txtBookingID.setText("B"+ctr);
                  }                
                txtDateOfBooking.setText(sdate);
                txtFlatNo.setText("");
                txtDuplexNo.setText("");
                txtBuiltUpArea.setText("");
                txtMaintainance.setText("");
                txtPrice.setText("");
                txtCustomerID.setText("");
                txtCustomerName.setText("");
                txtAadharNo.setText("");
                txtContactNo.setText("");
                txtAddress.setText("");
                
                cmbDOB0.setSelectedIndex(0);
                cmbDOB1.setSelectedIndex(0);
                cmbDOB2.setSelectedIndex(0);
                cmbBookingType.setSelectedIndex(0);

                bg.clearSelection();
            }
            catch( Exception e1)
            {
                System.out.println(e1);
            }
        }
        if(e.getSource()==btnBook)
        {
            try
            {  
              String sstt;
                btnEdit.setEnabled(false); 
                flg=1;
                if(cmbBookingType.getSelectedItem().equals("Flat"))
                {
                 sstt="select * from bookingtbl where flat_no='"+txtFlatNo.getText()+"'" ;
                }
                else
                {
                  sstt="select * from bookingtbl where duplex_no='"+txtDuplexNo.getText()+"'" ;

                }
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st3=con.createStatement();
                ResultSet res2=st3.executeQuery(sstt);
                if(res2.next())
                {
                  flg=0;
                    JOptionPane.showMessageDialog(null,"Already Booked");
                }
                else
                {
                String str="insert into bookingtbl(booking_ID,date_of_booking,booking_type,flat_no,duplex_no,builtup,maintainance,price,customer_ID,customer_name,DOB,aadhar_no,contact_no,gender,address)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(str);
                ps.setString(1,(txtBookingID.getText()));
                ps.setString(2,(txtDateOfBooking.getText()));
                ps.setString(3,(""+cmbBookingType.getSelectedItem()));
                String flatno="",dupno="";
                String ss=""+cmbBookingType.getSelectedItem();
                if(ss.equals("Flat"))
                {
                    flatno=txtFlatNo.getText();
                    dupno="NA";
                }
                if(ss.equals("Duplex"))
                {
                    dupno=txtDuplexNo.getText();
                    flatno="NA";
                }
                ps.setString(4,flatno);
                ps.setString(5,dupno);
                ps.setString(6,(txtBuiltUpArea.getText()));
                ps.setString(7,(txtMaintainance.getText()));
                ps.setString(8,(txtPrice.getText()));
                ps.setString(9,(txtCustomerID.getText()));
                ps.setString(10,(txtCustomerName.getText()));
                String sdob=cmbDOB2.getSelectedItem()+"-"+cmbDOB1.getSelectedItem()+"-"+cmbDOB0.getSelectedItem();
                ps.setString(11,sdob);
                ps.setString(12,(txtAadharNo.getText()));
                String aa=txtAadharNo.getText();
                if((aa.length())!=12)
                {
                  flg=0;
                  JOptionPane.showMessageDialog(null,"Enter correct Aadhar number!");
                  txtAadharNo.setText("");
                }
      
                ps.setString(13,(txtContactNo.getText()));
                String co=txtContactNo.getText();
                if((co.length())!=10)
                {
                  flg=0;
                  JOptionPane.showMessageDialog(null,"Enter correct Contact number");
                  txtContactNo.setText("");
                }
              
                String gen="";
                if(rbmale.isSelected())
                  gen="Male";
                if(rbfemale.isSelected())
                  gen="Female";
                ps.setString(14,gen);

                ps.setString(15,(txtAddress.getText()));
                
                if(flg==1)
                {
                   ps.executeUpdate();
                   String strr="update keytbl set bookid=bookid+1";
                   Statement st=con.createStatement();
                   st.executeUpdate(strr);
                   JOptionPane.showMessageDialog(null,"Record saved");
                        payment obj=new payment();
               }
               if(ss.equals("Flat"))
               {
                String sst="Update flattbl set flat_status='Occupied' where flat_no='"+txtFlatNo.getText()+"'";
                PreparedStatement pst=con.prepareStatement(sst);
                pst.executeUpdate();
              }
              if(ss.equals("Duplex"))
              {
                String sst="Update duplextbl set duplex_status='Occupied' where duplex_no='"+txtDuplexNo.getText()+"'";
                PreparedStatement pst=con.prepareStatement(sst);
                pst.executeUpdate();
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
            txtdate.setEnabled(true);
            txtFlatNo.setEnabled(false);
            try
            {
                btnBook.setEnabled(false);
                btnEdit.setEnabled(true);
                int flag=0;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String stt=JOptionPane.showInputDialog(null,"Enter Booking ID");
                //txt.setText(stt);
                String str="select * from bookingtbl where booking_ID='"+stt+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    flag=1;
                    txtBookingID.setText(stt);
                    txtFlatNo.setEnabled(false);
                    txtDateOfBooking.setText(res.getString(2));
                    txtFlatNo.setText(res.getString(4));
                    txtDuplexNo.setText(res.getString(5));
                    txtBuiltUpArea.setText(res.getString(6));
                    txtMaintainance.setText(res.getString(7));
                    txtPrice.setText(res.getString(8));
                    txtCustomerID.setText(res.getString(9));
                    txtCustomerName.setText(res.getString(10));
                    txtAadharNo.setText(res.getString(12));
                    txtContactNo.setText(res.getString(13));
                    txtAddress.setText(res.getString(15));

                    String dd[]=res.getString(11).split("/");
                    cmbDOB0.setSelectedItem(dd[0]);
                    cmbDOB1.setSelectedItem(dd[1]);
                    cmbDOB2.setSelectedItem(dd[2]);

                    if(res.getString(14).equals("Male"))
                        rbmale.setSelected(true);
                    else 
                        rbfemale.setSelected(true);

                    cmbBookingType.setSelectedItem(res.getString(3));
                }
                if(flag==0)
                    JOptionPane.showMessageDialog(null,"NO SUCH RECORD");
            }
            catch(Exception ee)
            {
                JOptionPane.showMessageDialog(null,ee);
            }
        }
        if(e.getSource()==btnEdit)
        {
            String gen="";
            try
            {
               btnBook.setEnabled(false);
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                if(rbmale.isSelected())
                    gen="Male";
                else
                    gen="Female";
                String str="update bookingtbl set date_of_booking='"+txtDateOfBooking.getText()+"',booking_type='"+cmbBookingType.getSelectedItem()+"',flat_no='"+txtFlatNo.getText()+"',duplex_no='"+txtDuplexNo.getText()+"',builtup='"+txtBuiltUpArea.getText()+"',maintainance='"+txtMaintainance.getText()+"',price='"+txtPrice.getText()+"',customer_ID='"+txtCustomerID.getText()+"',customer_name='"+txtCustomerName.getText()+"',DOB='"+cmbDOB2.getSelectedItem()+"-"+cmbDOB1.getSelectedItem()+"-"+cmbDOB0.getSelectedItem()+"',aadhar_no='"+txtAadharNo.getText()+"',contact_no='"+txtContactNo.getText()+"',gender='"+gen+"',address='"+txtAddress.getText()+"'where booking_ID='"+txtBookingID.getText()+"'";
                st.executeUpdate(str); 
                JOptionPane.showMessageDialog(null,"RECORD UPDATED");
            }
            catch(Exception eee)
            {
                JOptionPane.showMessageDialog(null,eee);
            }
        }
        if(e.getSource()==btnCancel)
        {
            this.dispose();
        }
    }
   public static void main(String args[])throws IOException
   {
    booking obj=new booking();
   }
}

