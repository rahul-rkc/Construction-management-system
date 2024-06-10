import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
//import net.ucanaccess.*;

public class customer extends JFrame implements ActionListener,FocusListener
{
    int flg=0;

    JTextField txtCustomerID=new JTextField();
    JTextField txtCustomerName=new JTextField();
    JTextField txtAadharNo=new JTextField();
    JTextField txtContactNo=new JTextField();
    JTextField txtAddress=new JTextField();
    JTextField txtdate=new JTextField();

    JButton btnNew=new JButton("");
    JButton btnSave=new JButton("");
    JButton btnSearch=new JButton("");
    JButton btnEdit=new JButton("");
    JButton btnCancel=new JButton("");

    String[] sdate ={"DATE","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
   String smonth[]={"select","01","02","03","04","05","06","07","08","09","10","11","12"};
    String[] syear ={"YEAR","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
    JComboBox cmbDOB0=new JComboBox(sdate);
    JComboBox cmbDOB1=new JComboBox(smonth);
    JComboBox cmbDOB2=new JComboBox(syear);

    JRadioButton rbmale=new JRadioButton("Male");
    JRadioButton rbfemale=new JRadioButton("Female");
    ButtonGroup bg=new ButtonGroup();

    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/customer.png"));
    public customer()
    {
        //setUndecorated(true);
        //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        setTitle("Customer Details");
        setSize(2500,1500);
        // setResizable(false);
        setLocationRelativeTo(null);
        txtCustomerID.setEnabled(false);
        txtdate.setEnabled(false);

        // txtCustomerID.setFont(new Font("Georgia",Font.BOLD,25));
        // txtCustomerName.setFont(new Font("Georgia",Font.BOLD,25));
        // txtAadharNo.setFont(new Font("Georgia",Font.BOLD,25));
        // txtContactNo.setFont(new Font("Georgia",Font.BOLD,25));
        // txtAddress.setFont(new Font("Georgia",Font.BOLD,25));
        // txtdate.setFont(new Font("Georgia",Font.BOLD,25));

        // btnNew.setFont(new Font("Georgia",Font.BOLD,30));
        // btnSave.setFont(new Font("Georgia",Font.BOLD,30));
        // btnSearch.setFont(new Font("Georgia",Font.BOLD,30));
        // btnEdit.setFont(new Font("Georgia",Font.BOLD,30));
        // btnCancel.setFont(new Font("Georgia",Font.BOLD,30));

        // cmbDOB0.setFont(new Font("Georgia",Font.BOLD,25));
        // cmbDOB1.setFont(new Font("Georgia",Font.BOLD,25));
        // cmbDOB2.setFont(new Font("Georgia",Font.BOLD,25));


        //---Setting Border Properties
        txtCustomerID.setBorder(null);
        txtCustomerName.setBorder(null);
        txtAadharNo.setBorder(null);
        txtContactNo.setBorder(null);
        txtAddress.setBorder(null);
        txtdate.setBorder(null);

        //Opaqueness
        txtCustomerID.setOpaque(false);
        txtCustomerName.setOpaque(false);
        txtAadharNo.setOpaque(false);
        txtContactNo.setOpaque(false);
        txtAddress.setOpaque(false);
        txtdate.setOpaque(false);
        txtAddress.setOpaque(false);

        rbmale.setOpaque(false);
        rbfemale.setOpaque(false);

        cmbDOB0.setOpaque(false);
        cmbDOB1.setOpaque(false);
        cmbDOB2.setOpaque(false);

        //
        btnNew.setContentAreaFilled(false);
        btnSave.setContentAreaFilled(false);
        btnSearch.setContentAreaFilled(false);
        btnEdit.setContentAreaFilled(false);
        btnCancel.setContentAreaFilled(false);



        //Setting Bounds of Elements
        txtCustomerID.setBounds(495,184 ,300,22);
        txtCustomerName.setBounds(495,235,500,22);
        txtAadharNo.setBounds(495,340,400,20);
        txtContactNo.setBounds(495,502,403,21);
        txtAddress.setBounds(495,571,700,21);
        txtdate.setBounds(1272,173,110,22);

        cmbDOB0.setBounds(495,280,80,30);
        cmbDOB1.setBounds(585,280,80,30);
        cmbDOB2.setBounds(675,280,80,30);



        rbmale.setBounds(495,380,100,40);
        rbfemale.setBounds(610,380,100,40);

        btnNew.setBounds(365,689,95,30);
        btnSave.setBounds(495,689,95,30);
        btnSearch.setBounds(618,689,95,30);
        btnEdit.setBounds(747,689,95,30);
        btnCancel.setBounds(1460,680,75,75);

        add(txtCustomerID);
        add(txtCustomerName);
        add(txtContactNo);
        add(txtAadharNo);
        add(txtAddress);
        add(txtdate);


        add(btnNew);
        add(btnSave);
        add(btnSearch);
        add(btnEdit);
        add(btnCancel);

        add(cmbDOB0);
        add(cmbDOB1);
        add(cmbDOB2);

        add(rbmale);
        add(rbfemale);
        bg.add(rbmale);
        bg.add(rbfemale);

        add(limg);
        limg.setBounds(-15,-43,this.getWidth(),this.getHeight());

        btnNew.addActionListener(this);
        btnSave.addActionListener(this);
        btnSearch.addActionListener(this);
        btnEdit.addActionListener(this);
        btnCancel.addActionListener(this);
        txtCustomerName.addFocusListener(this);
        txtAadharNo.addFocusListener(this);
        txtContactNo.addFocusListener(this);
        repaint();
    }
    public void focusGained(FocusEvent fe)
    {
    }
    public void focusLost(FocusEvent fe)
    {
        if(fe.getSource()==txtCustomerName)
        {
            int ctr=0;
            String s=txtCustomerName.getText();
            if(s.equals(""))
            {}
            else
            {
                for( int i=0;i<s.length();i++)
                {
                    if(s.charAt(i)>='a' && s.charAt(i)<='z'||s.charAt(i)>='A' && s.charAt(i)<='Z'||s.charAt(i)==' ')
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
            btnEdit.setEnabled(false);
            btnSave.setEnabled(true);
            try
            {
                int ctr=1;
                Calendar cal=Calendar.getInstance();
                String sdate=cal.get(Calendar.YEAR)+"-"+(String.format("%02d",cal.get(Calendar.MONTH)+1))+"-"+String.format("%02d",cal.get(Calendar.DATE));                //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                //  System.out.println("Driver loded sucessfully");
                // Connection con=DriverManager.getConnection("jdbc:odbc:CDN");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str1="select customerid from keytbl";
                ResultSet res=st.executeQuery(str1);
                while(res.next())
                {
                    ctr=Integer.parseInt(res.getString(1));
                }
                if(ctr>0&&ctr<=9)
                {
                    txtCustomerID.setText("C00"+ctr);
                }
                else if(ctr>=10&&ctr<=99)
                {
                    txtCustomerID.setText("C0"+ctr);
                }
                else if(ctr>=100)
                {
                    txtCustomerID.setText("C"+ctr);
                }
                txtCustomerName.setText("");
                txtAadharNo.setText("");
                txtContactNo.setText("");
                txtAddress.setText("");
                txtdate.setText(sdate);

                cmbDOB0.setSelectedIndex(0);
                cmbDOB1.setSelectedIndex(0);
                cmbDOB2.setSelectedIndex(0);

                bg.clearSelection();
            }
            catch( Exception e1)
            {
                System.out.println(e1);
            }
            repaint();
        }
        if(e.getSource()==btnSave)
        {
            btnEdit.setEnabled(false);
            try
            {
                flg=1;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                String str="insert into Customertbl(customer_ID,customer_name,DOB,aadhar_no,contact_no,gender,address,dated)values(?,?,?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(str);
                ps.setString(1,(txtCustomerID.getText()));
                ps.setString(2,(txtCustomerName.getText()));
                ps.setString(7,(txtAddress.getText()));
                ps.setString(8,(txtdate.getText()));
                ps.setString(4,(txtAadharNo.getText()));
                String aa=txtAadharNo.getText();
                if((aa.length())!=12)
                {
                    flg=0;
                    JOptionPane.showMessageDialog(null,"Enter correct Aadhar number!");
                    txtAadharNo.setText("");
                }
                ps.setString(5,(txtContactNo.getText()));
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
                ps.setString(6,gen);

                String sdob=cmbDOB2.getSelectedItem()+"-"+cmbDOB1.getSelectedItem()+"-"+cmbDOB0.getSelectedItem();
                ps.setString(3,sdob);
                if(flg==1)
                {
                    ps.executeUpdate();
                    String strr="update keytbl set customerid=customerid+1";
                    Statement st=con.createStatement();
                    st.executeUpdate(strr);
                    JOptionPane.showMessageDialog(null,"Record saved");
                }
            }
            catch(Exception ee)
            {
                System.out.println(ee);
            }
        }
        if(e.getSource()==btnSearch)
        {
            btnSave.setEnabled(false);
            btnEdit.setEnabled(true);
            txtdate.setEnabled(true);
            try
            {
                int flag=0;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String stt=JOptionPane.showInputDialog(null,"Enter Customer ID");
                txtCustomerID.setText(stt);
                String str="select * from customertbl where customer_ID='"+stt+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    flag=1;
                    txtCustomerID.setText(res.getString(1));
                    txtCustomerName.setText(res.getString(2));
                    txtAadharNo.setText(res.getString(4));
                    txtContactNo.setText(res.getString(5));
                    txtAddress.setText(res.getString(7));
                    txtdate.setText(res.getString(8));

                    if(res.getString(6).equals("Male"))
                        rbmale.setSelected(true);
                    else
                        rbfemale.setSelected(true);

                    String[] dd =res.getString(3).split("-");
                    cmbDOB0.setSelectedItem(dd[2]);
                    cmbDOB1.setSelectedItem(dd[1]);
                    cmbDOB2.setSelectedItem(dd[0]);

                }
                if(flag==0)
                    JOptionPane.showMessageDialog(null,"NO SUCH RECORD");
            }
            catch(Exception ce)
            {
                JOptionPane.showMessageDialog(null,ce);
            }
        }
        if(e.getSource()==btnEdit)
        {
            btnSave.setEnabled(false);
            try
            {
                String gen="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();

                if(rbmale.isSelected())
                    gen="Male";
                else
                    gen="Female";
                String str1="update customertbl set customer_name='"+txtCustomerName.getText()+"',DOB='"+cmbDOB2.getSelectedItem()+"-"+cmbDOB1.getSelectedItem()+"-"+cmbDOB0.getSelectedItem()+"',aadhar_no='"+txtAadharNo.getText()+"',contact_no='"+txtContactNo.getText()+"',gender='"+gen+"',address='"+txtAddress.getText()+"',dated='"+txtdate.getText()+"' where customer_ID='"+txtCustomerID.getText()+"'";
                st.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"record updated");
            }
            catch(Exception ee1)
            {
                System.out.println(ee1);
            }

        }
        if(e.getSource()==btnCancel)
        {
            this.dispose();
        }
    }
    public static void main(String[] args)throws IOException
    {
        customer obj=new customer();
    }
}