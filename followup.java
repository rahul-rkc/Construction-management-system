import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class followup extends JFrame implements ActionListener,FocusListener
{
    int flg=0;

    JTextField txtFollowUpID=new JTextField();
    JTextField txtEnquiryID=new JTextField();
    JTextField txtCustomerName=new JTextField();
    JTextField txtDesc=new JTextField();
    JTextField txtStatus=new JTextField();
    JTextField txtContactNo=new JTextField();
    JTextField txtRemarks=new JTextField();
    JTextField txtdate=new JTextField();

    JButton btnNew=new JButton("");
    JButton btnSave=new JButton("");
    JButton btnSearch=new JButton("");
    JButton btnCancel=new JButton("");

    String[] senquiry ={"select","Flat","Duplex"};
    JComboBox cmbEnquiry=new JComboBox(senquiry);

    JRadioButton rbmale=new JRadioButton("Male");
    JRadioButton rbfemale=new JRadioButton("Female");
    ButtonGroup bg=new ButtonGroup();

    JRadioButton rbpending=new JRadioButton("Pending");
    JRadioButton rbconfirmed=new JRadioButton("Confirmed");
    JRadioButton rbrejected=new JRadioButton("Rejected");
    ButtonGroup bgs=new ButtonGroup();

    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/followup.png"));


    //---------JTable--------------
    String[] col ={"Sl.No.","followup_ID","enquiry_ID","customer_name","gender","description","enquiring_for","status","contact_no","Remarks","date"};
    String slno,fid,eid,cname,gen,desc,enq,stat,conno,rem,dt;
    Object[][] data={{slno,fid,eid,cname,gen,desc,enq,stat,conno,rem,dt}};
    DefaultTableModel model=new DefaultTableModel(col,0);
    JTable jtbl;
    JScrollPane jspn;
    //---------JTable--------------

    public followup()
    {
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setLayout(null);
        setVisible(true);
        //setResizable(false);
        //setLocationRelativeTo(null);
        setSize(2500,1500);
        txtFollowUpID.setEnabled(false);

        txtFollowUpID.setFont(new Font("Georgia",Font.BOLD,22));
        txtEnquiryID.setFont(new Font("Georgia",Font.BOLD,22));
        txtCustomerName.setFont(new Font("Georgia",Font.BOLD,22));
        txtDesc.setFont(new Font("Georgia",Font.BOLD,22));
        txtContactNo.setFont(new Font("Georgia",Font.BOLD,18));
        txtRemarks.setFont(new Font("Georgia",Font.BOLD,20));
        txtdate.setFont(new Font("Georgia",Font.BOLD,18));

        btnNew.setFont(new Font("Georgia",Font.BOLD,30));
        btnSave.setFont(new Font("Georgia",Font.BOLD,30));
        btnSearch.setFont(new Font("Georgia",Font.BOLD,30));
        btnCancel.setFont(new Font("Georgia",Font.BOLD,30));

        rbmale.setFont(new Font("Georgia",Font.BOLD,25));
        rbfemale.setFont(new Font("Georgia",Font.BOLD,25));
        rbpending.setFont(new Font("Georgia",Font.BOLD,20));
        rbconfirmed.setFont(new Font("Georgia",Font.BOLD,20));
        rbrejected.setFont(new Font("Georgia",Font.BOLD,20));

        cmbEnquiry.setFont(new Font("Georgia",Font.BOLD,25));

        txtFollowUpID.setBorder(null);
        txtEnquiryID.setBorder(null);
        txtCustomerName.setBorder(null);
        txtDesc.setBorder(null);
        txtContactNo.setBorder(null);
        txtRemarks.setBorder(null);
        txtdate.setBorder(null);


        txtFollowUpID.setOpaque(false);
        txtEnquiryID.setOpaque(false);
        txtCustomerName.setOpaque(false);
        txtDesc.setOpaque(false);
        txtContactNo.setOpaque(false);
        txtRemarks.setOpaque(false);
        txtdate.setOpaque(true);

        txtFollowUpID.setBounds(450,115,340,20);
        txtEnquiryID.setBounds(450,155,340,23);
        txtCustomerName.setBounds(450,198,830,23);
        txtDesc.setBounds(450,283,830,23);
        txtContactNo.setBounds(450,420,830,23);
        txtRemarks.setBounds(454,471,830,23);
        txtdate.setBounds(1244,115,100,23);

        rbmale.setOpaque(false);
        rbfemale.setOpaque(false);
        rbpending.setOpaque(false);
        rbconfirmed.setOpaque(false);
        rbrejected.setOpaque(false);

        rbmale.setBounds(450,230,100,30);
        rbfemale.setBounds(570,230,120,30);
        rbpending.setBounds(450,330,150,30);
        rbconfirmed.setBounds(600,330,170,30);
        rbrejected.setBounds(780,330,150,30);

        cmbEnquiry.setBounds(450,375,835,28);

        btnNew.setContentAreaFilled(false);
        btnSave.setContentAreaFilled(false);
        btnSearch.setContentAreaFilled(false);
        btnCancel.setContentAreaFilled(false);


        btnNew.setBounds(415,712,100,30);
        btnSave.setBounds(573,714,100,30);
        btnSearch.setBounds(720,715,100,30);
        btnCancel.setBounds(1462,687,75,75);

        add(txtFollowUpID);
        add(txtEnquiryID);
        add(txtCustomerName);
        add(txtDesc);
        add(txtContactNo);
        add(txtRemarks);
        add(txtdate);

        add(btnNew);
        add(btnSave);
        add(btnSearch);
        add(btnCancel);

        add(rbmale);
        add(rbfemale);
        add(rbpending);
        add(rbconfirmed);
        add(rbrejected);

        add(cmbEnquiry);

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
        btnCancel.addActionListener(this);
        txtEnquiryID.addFocusListener(this);
        txtCustomerName.addFocusListener(this);
        txtContactNo.addFocusListener(this);

        //--------JTable---------
        jtbl=new JTable(data,col);
        jspn=new JScrollPane(jtbl);
        jspn.setOpaque(true);
        jspn.setBounds(450,510,850,180);
        add(jspn);
        jtbl.setModel(model);
        //--------JTable---------

    }
    public void focusGained(FocusEvent fe)
    {

    }
    public void focusLost(FocusEvent fe)
    {
        if(fe.getComponent()==txtEnquiryID)
        {
            btnSave.setEnabled(true);
            int ctr=0,flg=0;
            try
            {
                String stat="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str="select * from enquirytbl where enquiry_ID='"+txtEnquiryID.getText()+"' and status='Pending'";
                ResultSet res=st.executeQuery(str);
                model.setRowCount(0);
                while(res.next())
                {
                    flg=1;
                    txtCustomerName.setText(res.getString(2));
                    txtContactNo.setText(res.getString(5));
                    txtRemarks.setText(res.getString(11));
                    //txtdate.setText(res.getString(8));
                    cmbEnquiry.setSelectedItem(res.getString(9));
                    rbpending.setSelected(true);
                    String s1=res.getString(6);
                    if(s1.equals("Male"))
                        rbmale.setSelected(true);
                    else
                        rbfemale.setSelected(true);
                }
                if(flg==0)
                {
                    btnSave.setEnabled(false);
                    JOptionPane.showMessageDialog(null,"Cannot followup beacuse its already cancelled or rejected");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

            try
            {
                flg=0;
                String stat="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str="select * from followuptbl where enquiry_ID='"+txtEnquiryID.getText()+"'";
                ResultSet res=st.executeQuery(str);
                //model.setRowCount(0);
                while(res.next())
                {
                    Vector v=new Vector();
                    v.add(ctr=ctr+1);
                    v.add(res.getString(1));
                    v.add(res.getString(2));
                    v.add(res.getString(3));
                    v.add(res.getString(4));
                    v.add(res.getString(5));
                    v.add(res.getString(6));
                    v.add(res.getString(7));
                    v.add(res.getString(8));
                    v.add(res.getString(9));
                    v.add(res.getString(10));
                    model.addRow(v);
                }
            }
            catch(Exception ee1)
            {
                System.out.println(ee1);
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
            txtdate.setEnabled(true);
            btnSave.setEnabled(true);
            try
            {
                int ctr=1;
                Calendar cal=Calendar.getInstance();
String sdate=cal.get(Calendar.YEAR)+"-"+(String.format("%02d",cal.get(Calendar.MONTH)+1))+"-"+String.format("%02d",cal.get(Calendar.DATE));                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str1="select fupid from keytbl";
                ResultSet res=st.executeQuery(str1);
                while(res.next())
                {
                    ctr=Integer.parseInt(res.getString(1));
                }
                if(ctr>0&&ctr<=9)
                {
                    txtFollowUpID.setText("F00"+ctr);
                }
                else if(ctr>=10&&ctr<=99)
                {
                    txtFollowUpID.setText("F0"+ctr);
                }
                else if(ctr>=100)
                {
                    txtFollowUpID.setText("F"+ctr);
                }
                txtEnquiryID.setText("");
                txtCustomerName.setText("");
                txtDesc.setText("");
                txtContactNo.setText("");
                txtRemarks.setText("");
                txtdate.setText(sdate);

                cmbEnquiry.setSelectedIndex(0);

                bg.clearSelection();
                bgs.clearSelection();
                model.setRowCount(0);
            }
            catch( Exception e1)
            {
                System.out.println(e1);
            }
        }

        if(e.getSource()==btnSave)
        {
            int flag=0,sflg=0;
            try
            {
                flg=0;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                String str="";
                PreparedStatement ps;
                Statement st1=con.createStatement();
                ResultSet rs1=st1.executeQuery("Select status from enquirytbl where enquiry_ID='"+txtEnquiryID.getText()+"' and status='Pending'");
                while(rs1.next())
                {
                    sflg=1;
                }
                if(sflg==1)
                {
                    String sstr="insert into followuptbl(followup_ID,enquiry_ID,customer_name,gender,description,enquiring_for,status,contact_no,remarks,dated)values(?,?,?,?,?,?,?,?,?,?)";
                    ps=con.prepareStatement(sstr);
                    ps.setString(1,txtFollowUpID.getText());
                    ps.setString(2,txtEnquiryID.getText());
                    ps.setString(3,txtCustomerName.getText());
                    ps.setString(5,txtDesc.getText());
                    ps.setString(6,(""+cmbEnquiry.getSelectedItem()));
                    ps.setString(8,txtContactNo.getText());
                    ps.setString(9,txtRemarks.getText());
                    ps.setString(10,txtdate.getText());

                    String gen="";
                    if(rbmale.isSelected())
                        gen="Male";
                    if(rbfemale.isSelected())
                        gen="Female";
                    ps.setString(4,gen);

                    String stat="";
                    if(rbpending.isSelected())
                        stat="Pending";
                    if(rbconfirmed.isSelected())
                        stat="Confirmed";
                    if(rbrejected.isSelected())
                        stat="Rejected";
                    ps.setString(7,stat);

                    ps.executeUpdate();

                    sstr="update keytbl set fupid=fupid+1";
                    ps=con.prepareStatement(sstr);
                    ps.executeUpdate();
                    String estr="update enquirytbl set status='"+stat+"' where enquiry_ID='"+txtEnquiryID.getText()+"'";
                    ps=con.prepareStatement(estr);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"saved");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Followup not possible");
                }
            }
            catch(Exception ee)
            {
                System.out.println(ee);
            }
        }
        if(e.getSource()==btnSearch)
        {
            model.setRowCount(0);
            txtdate.setEnabled(true);
            txtEnquiryID.setEnabled(true);
            try
            {
                int flag=0;
                String stat="";
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String stt=JOptionPane.showInputDialog(null,"Enter Enquiry ID");
                txtEnquiryID.setText(stt);
                String str="select * from followuptbl where enquiry_ID='"+stt+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    flag=1;
                    txtFollowUpID.setText(res.getString(1));
                    txtCustomerName.setText(res.getString(3));
                    txtDesc.setText(res.getString(5));
                    txtContactNo.setText(res.getString(8));
                    txtRemarks.setText(res.getString(9));

                    if(res.getString(4).equals("Male"))
                        rbmale.setSelected(true);
                    else
                        rbfemale.setSelected(true);

                    txtdate.setText(res.getString(10));
                    cmbEnquiry.setSelectedItem(res.getString(6));

                    stat=res.getString(7);
                    if(stat.equals("Pending"))
                        rbpending.setSelected(true);
                    if(stat.equals("Confirmed"))
                        rbconfirmed.setSelected(true);
                    if(stat.equals("Rejected"))
                        rbrejected.setSelected(true);
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
    public static void main(String[] args)throws IOException
    {
        followup obj=new followup();
    }
}