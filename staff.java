import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class staff extends JFrame implements ActionListener,FocusListener
{
    int flg=0;

    JTextField txtStaffID=new JTextField();
    JTextField txtStaffName=new JTextField();
    JTextField txtAadharNo=new JTextField();
    JTextField txtContactNo=new JTextField();
    JTextField txtAddress=new JTextField();
    JTextField txtDesignation=new JTextField();
    JTextField txtExperience=new JTextField();
    JTextField txtdate=new JTextField();

    JButton btnNew=new JButton("");
    JButton btnSave=new JButton("");
    JButton btnSearch=new JButton("");
    JButton btnEdit=new JButton("");
    JButton btnCancel=new JButton("");

    String[] sdate ={"select","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String[] smonth ={"select","01","02","03","04","05","06","07","08","09","10","11","12"};
    String[] syear ={"select","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
    JComboBox cmbDOB0=new JComboBox(sdate);
    JComboBox cmbDOB1=new JComboBox(smonth);
    JComboBox cmbDOB2=new JComboBox(syear);

    JRadioButton rbmale=new JRadioButton("Male");
    JRadioButton rbfemale=new JRadioButton("Female");
    ButtonGroup bg=new ButtonGroup();
    String gen="";

    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/staff.png"));

    public staff()
    {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setSize(2500,1500);
        //setResizable(false);
        setLocationRelativeTo(null);

        txtStaffID.setEnabled(false);

        txtStaffID.setFont(new Font("Georgia",Font.BOLD,25));
        txtStaffName.setFont(new Font("Georgia",Font.BOLD,25));
        txtAadharNo.setFont(new Font("Georgia",Font.BOLD,20));
        txtContactNo.setFont(new Font("Georgia",Font.BOLD,20));
        txtAddress.setFont(new Font("Georgia",Font.BOLD,25));
        txtDesignation.setFont(new Font("Georgia",Font.BOLD,25));
        txtExperience.setFont(new Font("Georgia",Font.BOLD,25));
        txtdate.setFont(new Font("Georgia",Font.BOLD,20));

        btnNew.setFont(new Font("Georgia",Font.BOLD,30));
        btnSave.setFont(new Font("Georgia",Font.BOLD,30));
        btnSearch.setFont(new Font("Georgia",Font.BOLD,30));
        btnEdit.setFont(new Font("Georgia",Font.BOLD,30));
        btnCancel.setFont(new Font("Georgia",Font.BOLD,30));

        cmbDOB0.setFont(new Font("Georgia",Font.BOLD,22));
        cmbDOB1.setFont(new Font("Georgia",Font.BOLD,22));
        cmbDOB2.setFont(new Font("Georgia",Font.BOLD,22));

        rbmale.setFont(new Font("Georgia",Font.BOLD,25));
        rbfemale.setFont(new Font("Georgia",Font.BOLD,25));

        txtStaffID.setBorder(null);
        txtStaffName.setBorder(null);
        txtAadharNo.setBorder(null);
        txtContactNo.setBorder(null);
        txtAddress.setBorder(null);
        txtDesignation.setBorder(null);
        txtExperience.setBorder(null);
        txtdate.setBorder(null);

        txtStaffID.setOpaque(false);
        txtStaffName.setOpaque(false);
        txtAadharNo.setOpaque(false);
        txtContactNo.setOpaque(false);
        txtAddress.setOpaque(false);
        txtDesignation.setOpaque(false);
        txtExperience.setOpaque(false);
        txtdate.setOpaque(false);

        btnNew.setContentAreaFilled(false);
        btnSave.setContentAreaFilled(false);
        btnSearch.setContentAreaFilled(false);
        btnEdit.setContentAreaFilled(false);
        btnCancel.setContentAreaFilled(false);

        txtStaffID.setBounds(490,143,348,26);
        txtStaffName.setBounds(490,193,835,26);
        txtAadharNo.setBounds(490,287,835,26);
        txtContactNo.setBounds(490,520,348,26);
        txtAddress.setBounds(490,585,835,26);
        txtDesignation.setBounds(490,378,840,26);
        txtExperience.setBounds(490,425,840,26);
        txtdate.setBounds(1240,135,120,30);

        cmbDOB2.setBounds(490,240,100,25);
        cmbDOB1.setBounds(620,240,100,25);
        cmbDOB0.setBounds(750,240,100,25);

        rbmale.setBounds(490,330,100,25);
        rbfemale.setBounds(630,330,140,25);

        btnNew.setBounds(367,725,100,35);
        btnSave.setBounds(489,725,100,35);
        btnSearch.setBounds(612,725,96,35);
        btnEdit.setBounds(733,725,96,35);
        btnCancel.setBounds(1450,700,75,75);

        add(txtStaffID);
        add(txtStaffName);
        add(txtContactNo);
        add(txtAadharNo);
        add(txtAddress);
        add(txtDesignation);
        add(txtExperience);
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

        limg.setBounds(-20,-40,this.getWidth(),this.getHeight());
        btnNew.addActionListener(this);
        btnSave.addActionListener(this);
        btnSearch.addActionListener(this);
        btnEdit.addActionListener(this);
        btnCancel.addActionListener(this);
        txtStaffName.addFocusListener(this);
        txtExperience.addFocusListener(this);
        txtContactNo.addFocusListener(this);
        txtAadharNo.addFocusListener(this);
    }
    public void focusGained(FocusEvent fe)
    {
    }
    public void focusLost(FocusEvent fe)
    {
        if(fe.getSource()==txtStaffName)
        {
            int ctr=0;
            String s=txtStaffName.getText();
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
                        txtStaffName.setText("");
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
        if(fe.getSource()==txtExperience)
        {
            int ctr=0;
            String s=txtExperience.getText();
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
                        JOptionPane.showMessageDialog(null,"Enter in correct format");
                        txtExperience.setText("");
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
                txtdate.setEnabled(true);
                btnEdit.setEnabled(false);
                btnSave.setEnabled(true);
                int ctr=1;
                Calendar cal=Calendar.getInstance();
String sdate=cal.get(Calendar.YEAR)+"-"+(String.format("%02d",cal.get(Calendar.MONTH)+1))+"-"+String.format("%02d",cal.get(Calendar.DATE));
                txtStaffID.setEnabled(false);
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str1="select staffid from keytbl";
                ResultSet res=st.executeQuery(str1);
                while(res.next())
                {
                    ctr=Integer.parseInt(res.getString(1));
                }
                if(ctr>0&&ctr<=9)
                {
                    txtStaffID.setText("S00"+ctr);
                }
                else if(ctr>=10&&ctr<=99)
                {
                    txtStaffID.setText("S0"+ctr);
                }
                else if(ctr>=100)
                {
                    txtStaffID.setText("S"+ctr);
                }
                txtStaffName.setText("");
                txtAadharNo.setText("");
                txtContactNo.setText("");
                txtAddress.setText("");
                txtDesignation.setText("");
                txtExperience.setText("");
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
        }
        if(e.getSource()==btnSave)
        {
            try
            {
                btnEdit.setEnabled(false);
                flg=1;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                String str="insert into stafftbl(staff_ID,staff_name,DOB,aadhar_no,contact_no,gender,address,designation,experience,dated)values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(str);
                ps.setString(1,(txtStaffID.getText()));
                ps.setString(2,(txtStaffName.getText()));
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
                ps.setString(7,(txtAddress.getText()));
                ps.setString(8,(txtDesignation.getText()));
                ps.setString(9,(txtExperience.getText()));
                ps.setString(10,(txtdate.getText()));

                String sdob=cmbDOB2.getSelectedItem()+"-"+cmbDOB1.getSelectedItem()+"-"+cmbDOB0.getSelectedItem();
                ps.setString(3,sdob);

                String gen="";
                if(rbmale.isSelected())
                    gen="Male";
                if(rbfemale.isSelected())
                    gen="Female";

                ps.setString(6,gen);
                if(flg==1)
                {
                    ps.executeUpdate();
                    String strr="update keytbl set staffid=staffid+1";
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
            try
            {
                btnSave.setEnabled(false);
                btnEdit.setEnabled(true);
                int flag=0;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String stt=JOptionPane.showInputDialog(null,"Enter Staff ID");
                txtStaffID.setText(stt);
                String str="select * from stafftbl where staff_ID='"+stt+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    flag=1;
                    txtStaffID.setText(res.getString(1));
                    txtStaffName.setText(res.getString(2));
                    txtAadharNo.setText(res.getString(4));
                    txtContactNo.setText(res.getString(5));
                    txtAddress.setText(res.getString(7));
                    txtDesignation.setText(res.getString(8));
                    txtExperience.setText(res.getString(9));
                    txtdate.setText(res.getString(10));

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
            try
            {
                btnSave.setEnabled(false);
                String gen="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                if(rbmale.isSelected())
                    gen="Male";
                else
                    gen="Female";
                String str1="update stafftbl set staff_name='"+txtStaffName.getText()+"',DOB='"+cmbDOB2.getSelectedItem()+"-"+cmbDOB1.getSelectedItem()+"-"+cmbDOB0.getSelectedItem()+"',aadhar_no='"+txtAadharNo.getText()+"',contact_no='"+txtContactNo.getText()+"',Gender='"+gen+"',Address='"+txtAddress.getText()+"',Designation='"+txtDesignation.getText()+"',Experience='"+txtExperience.getText()+"',dated='"+txtdate.getText()+"' where staff_ID='"+txtStaffID.getText()+"'";
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
        staff obj=new staff();
    }
}