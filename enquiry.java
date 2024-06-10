import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class enquiry extends JFrame implements ActionListener,FocusListener
{
    int flg=0;

    JTextField txtEnquiryID=new JTextField();
    JTextField txtCustomerName=new JTextField();
    JTextField txtAadharNo=new JTextField();
    JTextField txtContactNo=new JTextField();
    JTextField txtAddress=new JTextField();
    JTextField txtdate=new JTextField();
    JTextField txtRemarks=new JTextField();

    JButton btnNew=new JButton("");
    JButton btnSave=new JButton("");
    JButton btnSearch=new JButton("");
    JButton btnEdit=new JButton("");
    JButton btnCancel=new JButton("");

    String[] sdate ={"select","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String[] smonth ={"select","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    String[] syear ={"select","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
    JComboBox cmbDOB0=new JComboBox(sdate);
    JComboBox cmbDOB1=new JComboBox(smonth);
    JComboBox cmbDOB2=new JComboBox(syear);

    String[] senquiry ={"select","Flat","Duplex"};
    JComboBox cmbEnquiry=new JComboBox(senquiry);

    JRadioButton rbmale=new JRadioButton("Male");
    JRadioButton rbfemale=new JRadioButton("Female");
    ButtonGroup bg=new ButtonGroup();

    JRadioButton rbpending=new JRadioButton("Pending");
    JRadioButton rbconfirmed=new JRadioButton("Confirmed");
    JRadioButton rbrejected=new JRadioButton("Rejected");
    ButtonGroup bgs=new ButtonGroup();
    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/enquiry.png"));

    public enquiry()
    {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setUndecorated(true);
        //setResizable(false);
        setVisible(true);
        setSize(2500,1500);

        txtEnquiryID.setFont(new Font("Georgia",Font.BOLD,25));
        txtCustomerName.setFont(new Font("Georgia",Font.BOLD,25));
        txtAadharNo.setFont(new Font("Georgia",Font.BOLD,20));
        txtContactNo.setFont(new Font("Georgia",Font.BOLD,20));
        txtAddress.setFont(new Font("Georgia",Font.BOLD,25));
        txtdate.setFont(new Font("Georgia",Font.BOLD,20));
        txtRemarks.setFont(new Font("Georgia",Font.BOLD,20));

        btnNew.setFont(new Font("Georgia",Font.BOLD,30));
        btnSave.setFont(new Font("Georgia",Font.BOLD,30));
        btnSearch.setFont(new Font("Georgia",Font.BOLD,30));
        btnEdit.setFont(new Font("Georgia",Font.BOLD,30));
        btnCancel.setFont(new Font("Georgia",Font.BOLD,30));

        cmbDOB0.setFont(new Font("Georgia",Font.BOLD,25));
        cmbDOB1.setFont(new Font("Georgia",Font.BOLD,25));
        cmbDOB2.setFont(new Font("Georgia",Font.BOLD,25));
        cmbEnquiry.setFont(new Font("Georgia",Font.BOLD,25));

        rbmale.setFont(new Font("Georgia",Font.BOLD,25));
        rbfemale.setFont(new Font("Georgia",Font.BOLD,25));
        rbpending.setFont(new Font("Georgia",Font.BOLD,25));
        rbconfirmed.setFont(new Font("Georgia",Font.BOLD,25));
        rbrejected.setFont(new Font("Georgia",Font.BOLD,25));

        txtEnquiryID.setBorder(null);
        txtdate.setBorder(null);
        txtCustomerName.setBorder(null);
        txtAadharNo.setBorder(null);
        txtRemarks.setBorder(null);
        txtContactNo.setBorder(null);
        txtAddress.setBorder(null);

        txtEnquiryID.setOpaque(false);
        txtdate.setOpaque(false);
        txtCustomerName.setOpaque(false);
        txtAadharNo.setOpaque(false);
        txtRemarks.setOpaque(false);
        txtContactNo.setOpaque(false);
        txtAddress.setOpaque(false);

        txtEnquiryID.setBounds(497,112,347,28);
        txtCustomerName.setBounds(495,156,842,26);
        txtAadharNo.setBounds(495,246,842,26);
        txtdate.setBounds(1246,100,120,30);
        txtRemarks.setBounds(497,427,838,45);
        txtContactNo.setBounds(497,525,300,27);
        txtAddress.setBounds(497,594,838,27);

        cmbDOB0.setBounds(495,197,100,32);
        cmbDOB1.setBounds(630,197,100,32);
        cmbDOB2.setBounds(765,197,100,32);
        cmbEnquiry.setBounds(497,340,432,30);

        rbmale.setBounds(495,290,100,34);
        rbfemale.setBounds(650,290,120,34);
        rbpending.setBounds(495,380,140,34);
        rbconfirmed.setBounds(670,380,170,34);
        rbrejected.setBounds(880,380,150,34);

        btnNew.setContentAreaFilled(false);
        btnSave.setContentAreaFilled(false);
        btnSearch.setContentAreaFilled(false);
        btnEdit.setContentAreaFilled(false);
        btnCancel.setContentAreaFilled(false);

        btnNew.setBounds(363,715,100,35);
        btnSave.setBounds(487,715,100,35);
        btnSearch.setBounds(615,715,100,35);
        btnEdit.setBounds(743,718,100,35);
        btnCancel.setBounds(1460,696,75,75);

        add(txtEnquiryID);
        add(txtCustomerName);
        add(txtContactNo);
        add(txtAadharNo);
        add(txtAddress);
        add(txtdate);
        add(txtRemarks);

        add(btnNew);
        add(btnSave);
        add(btnSearch);
        add(btnEdit);
        add(btnCancel);

        add(cmbDOB0);
        add(cmbDOB1);
        add(cmbDOB2);
        add(cmbEnquiry);

        add(rbmale);
        add(rbfemale);
        add(rbpending);
        add(rbconfirmed);
        add(rbrejected);

        bg.add(rbmale);
        bg.add(rbfemale);

        bgs.add(rbpending);
        bgs.add(rbconfirmed);
        bgs.add(rbrejected);

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
            txtEnquiryID.setEnabled(false);
            txtdate.setEnabled(true);
            try
            {
                int ctr=1;
                Calendar cal=Calendar.getInstance();
String sdate=cal.get(Calendar.YEAR)+"-"+(String.format("%02d",cal.get(Calendar.MONTH)+1))+"-"+String.format("%02d",cal.get(Calendar.DATE));                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str1="select enqid from keytbl";
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
                    txtEnquiryID.setText("E00"+ctr);
                }
                else if(ctr>=10&&ctr<=99)
                {
                    txtEnquiryID.setText("E0"+ctr);
                }
                else if(ctr>=100)
                {
                    txtEnquiryID.setText("E"+ctr);
                }
                txtCustomerName.setText("");
                txtAadharNo.setText("");
                txtContactNo.setText("");
                txtAddress.setText("");
                txtdate.setText(sdate);
                txtRemarks.setText("");

                cmbDOB0.setSelectedIndex(0);
                cmbDOB1.setSelectedIndex(0);
                cmbDOB2.setSelectedIndex(0);
                cmbEnquiry.setSelectedIndex(0);

                bg.clearSelection();
                bgs.clearSelection();
            }
            catch( Exception e1)
            {
                System.out.println(e1);
            }
        }
        if(e.getSource()==btnSave)
        {
            try
            {
                txtdate.setEnabled(true);
                int flg=1;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                String str="insert into enquirytbl(enquiry_ID,customer_name,DOB,aadhar_no,contact_no,gender,address,dated,enquiring_for,status,remarks)values(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(str);
                ps.setString(1,(txtEnquiryID.getText()));
                ps.setString(2,(txtCustomerName.getText()));
                ps.setString(7,(txtAddress.getText()));
                ps.setString(8,(txtdate.getText()));
                ps.setString(11,(txtRemarks.getText()));
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

                String stat="";
                if(rbpending.isSelected())
                    stat="Pending";
                if(rbconfirmed.isSelected())
                    stat="Confirmed";
                if(rbrejected.isSelected())
                    stat="Rejected";
                ps.setString(10,stat);

                String sdob=cmbDOB0.getSelectedItem()+"-"+cmbDOB1.getSelectedItem()+"-"+cmbDOB2.getSelectedItem();
                ps.setString(3,sdob);
                ps.setString(9,(""+cmbEnquiry.getSelectedItem()));
                if(flg==1)
                {
                    ps.executeUpdate();
                    String strr="update keytbl set enqid=enqid+1";
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
            txtdate.setEnabled(true);
            txtEnquiryID.setEnabled(false);
            try
            {
                int flag=0;
                String stat="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String stt=JOptionPane.showInputDialog(null,"Enter Enquiry ID");
                txtEnquiryID.setText(stt);
                String str="select * from enquirytbl where enquiry_ID='"+txtEnquiryID.getText()+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    flag=1;
                    txtCustomerName.setText(res.getString(2));

                    String[] dd =res.getString(3).split("-");
                    cmbDOB0.setSelectedItem(dd[0]);
                    cmbDOB1.setSelectedItem(dd[1]);
                    cmbDOB2.setSelectedItem(dd[2]);

                    txtAadharNo.setText(res.getString(4));
                    txtContactNo.setText(res.getString(5));

                    if(res.getString(6).equals("Male"))
                        rbmale.setSelected(true);
                    else
                        rbfemale.setSelected(true);

                    txtAddress.setText(res.getString(7));
                    txtdate.setText(res.getString(8));
                    cmbEnquiry.setSelectedItem(res.getString(9));

                    stat=res.getString(10);
                    if(stat.equals("Pending"))
                        rbpending.setSelected(true);
                    if(stat.equals("Confirmed"))
                        rbconfirmed.setSelected(true);
                    if(stat.equals("Rejected"))
                        rbrejected.setSelected(true);

                    txtRemarks.setText(res.getString(11));

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
            try
            {
                int sflg=0;
                Connection con1=DriverManager.getConnection("jdbc:odbc:cdsn");
                String str="";
                PreparedStatement ps;
                Statement st1=con1.createStatement();
                ResultSet rs1=st1.executeQuery("Select status from enquirytbl where enquiry_ID='"+txtEnquiryID.getText()+"' and status='Pending'");
                while(rs1.next())
                {
                    sflg=1;
                }
                if(sflg==1)
                {
                    String gen="",stat="";
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                    Statement st=con.createStatement();

                    if(rbmale.isSelected())
                        gen="Male";
                    else
                        gen="Female";

                    if(rbpending.isSelected())
                        stat="Pending";
                    else if(rbconfirmed.isSelected())
                        stat="Confirmed";
                    else
                        stat="Rejected";

                    String str1="update enquirytbl set customer_name='"+txtCustomerName.getText()+"',DOB='"+cmbDOB0.getSelectedItem()+"-"+cmbDOB1.getSelectedItem()+"-"+cmbDOB2.getSelectedItem()+"',aadhar_no='"+txtAadharNo.getText()+"',contact_no='"+txtContactNo.getText()+"',Gender='"+gen+"',address='"+txtAddress.getText()+"',enquiring_for='"+cmbEnquiry.getSelectedItem()+"',status='"+stat+"',remarks='"+txtRemarks.getText()+"' where enquiry_ID='"+txtEnquiryID.getText()+"'";
                    st.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null,"record updated");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"enquiry closed for this customer:)");
                }
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
        enquiry obj=new enquiry();
    }
}

///have to change coding of status...pending confirm...like followup
