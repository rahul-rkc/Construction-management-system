//Reportcollection is all about the total payment in the specific day.

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class reportcollection extends JFrame implements ActionListener//,FocusListener
{
    JLabel lblDate=new JLabel("Date");
    JLabel lblDescription=new JLabel("Description");
    JLabel lblMonth=new JLabel("Month");
    JLabel lblPaymentType=new JLabel("Payment Type");
    JLabel lblAmount=new JLabel("Amount");
    JLabel lblChequeNo=new JLabel("Cheque No");
    JLabel lblAccountNo=new JLabel("Account No");
    JLabel lblChequeDate=new JLabel("Cheque Date");
    JLabel lblBankName=new JLabel("Bank Name");

    JTextField txtAmount=new JTextField("");    
    JTextField txtDate=new JTextField();
    JTextArea txtDescription=new JTextArea();
    JTextField txtMonth=new JTextField();

    JTextField txtChequeNo=new JTextField("");
    JTextField txtAccountNo=new JTextField("");
    JTextField txtChequeDate=new JTextField("");
    JTextField txtBankName=new JTextField("");

    JRadioButton rbcash=new JRadioButton("Cash");
    JRadioButton rbcheque=new JRadioButton("Cheque");
    ButtonGroup bg=new ButtonGroup();

    JButton btnOk=new JButton("OK");
    JButton btnCancel=new JButton("Cancel");

    String smonth[]={"select","01","02","03","04","05","06","07","08","09","10","11","12"};
    JComboBox cmbMonth=new JComboBox(smonth);

    public reportcollection()
    {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      setVisible(true);
      setSize(1500,1500);
      lblAmount.setVisible(false);
      lblChequeNo.setVisible(false);
      lblAccountNo.setVisible(false);
      lblChequeDate.setVisible(false);
      lblBankName.setVisible(false);
      txtAmount.setVisible(false);
      txtChequeNo.setVisible(false);
      txtAccountNo.setVisible(false);
      txtChequeDate.setVisible(false);
      txtBankName.setVisible(false);

      lblDate.setBounds(50,150,100,40);
      lblDescription.setBounds(50,200,100,40);
      lblMonth.setBounds(50,300,100,40);
      lblPaymentType.setBounds(650,150,100,40);
      lblAmount.setBounds(650,220,100,40);
      lblChequeNo.setBounds(890,220,100,40);
      lblAccountNo.setBounds(890,270,100,40);
      lblChequeDate.setBounds(890,320,100,40);
      lblBankName.setBounds(890,370,100,40);

      txtDate.setBounds(200,150,120,40);
      txtDescription.setBounds(200,200,200,80);
      txtAmount.setBounds(750,220,100,40);
      txtChequeNo.setBounds(990,220,100,40);
      txtAccountNo.setBounds(990,270,100,40);
      txtChequeDate.setBounds(990,320,100,40);
      txtBankName.setBounds(990,370,100,40);

      rbcash.setBounds(790,150,70,40);
      rbcheque.setBounds(870,150,70,40);

      cmbMonth.setBounds(200,300,100,40);

      btnOk.setBounds(70,650,100,40);
      btnCancel.setBounds(185,650,100,40);

      add(lblDate);
      add(lblDescription);
      add(lblMonth);
      add(lblPaymentType);
      add(lblAmount);
      add(lblChequeNo);
      add(lblAccountNo);
      add(lblChequeDate);
      add(lblBankName);

      add(txtDate);
      add(txtDescription);
      add(txtAmount);
      add(txtChequeNo);
      add(txtAccountNo);
      add(txtChequeDate);
      add(txtBankName);

      add(rbcash);
      add(rbcheque);
      bg.add(rbcash);
      bg.add(rbcheque);

      add(cmbMonth);

      add(btnOk);
      add(btnCancel);

      btnOk.addActionListener(this);
      btnCancel.addActionListener(this);
      rbcash.addActionListener(this);
      rbcheque.addActionListener(this);
  }
  	public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==rbcash)
        {
        lblChequeNo.setVisible(false);
        lblAccountNo.setVisible(false);
        lblChequeDate.setVisible(false);
        lblBankName.setVisible(false);
        lblAmount.setVisible(true);
        txtAmount.setVisible(true);
        txtChequeNo.setVisible(false);
        txtAccountNo.setVisible(false);
        txtChequeDate.setVisible(false);
        txtBankName.setVisible(false);
        }
        if(e.getSource()==rbcheque)
        { 
        lblChequeNo.setVisible(true);
        lblAccountNo.setVisible(true);
        lblChequeDate.setVisible(true);
        lblBankName.setVisible(true);
        lblAmount.setVisible(true);
        txtAmount.setVisible(true);
        txtChequeNo.setVisible(true);
        txtAccountNo.setVisible(true);
        txtChequeDate.setVisible(true);
        txtBankName.setVisible(true);
        }
        if(e.getSource()==btnOk)
        {
        	try
        	{     
                Connection con=DriverManager.getConnection("jdbc:odbc:constructdsn");
                String sdate="select * from paymenttbl where date_of_payment='"+txtDate.getText()+"'";
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(sdate);
                PrintWriter pw=new PrintWriter("collection.txt");
                pw.println("Nikhil Township Pvt. Ltd.");
                pw.println("-------------------------");

           		while(res.next())
                {
                	String tsta=res.getString(4);
                    pw.println("Booking ID: "+tsta);
                	String tstb=res.getString(5);
                	pw.println("Booking Type: "+tstb);
           	        String tstc=res.getString(4);
           	        pw.println("Flat No: "+tstc);
           	        String tstd=res.getString(5);
           	        pw.println("Duplex No: "+tstd);
           	        String tstg=res.getString(8);
           	        pw.println("Price: "+tstg);
           	        String tsth=res.getString(9);
           	        pw.println("Customer ID: "+tsth);
           	        String tsti=res.getString(10);
           	        pw.println("Customer Name: "+tsti);
           	        String tstj=res.getString(11);
           	        
                    pw.println("---------------------------------------------");
                }
                pw.close();
                Process p=Runtime.getRuntime().exec("Notepad collection.txt");
            }
            catch(Exception ee)
            {
            	System.out.print(ee);
            }
        }
        if(e.getSource()==btnCancel)
        {
        	this.dispose();
        }
    } 
  public static void main(String[] args)throws IOException
  {
  	reportcollection obj=new reportcollection();
  }
}
