import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class payment extends JFrame implements ActionListener,FocusListener
{
    int fflg=0;
    JTextField txtPaymentID=new JTextField("");
    JTextField txtDateOfPayment=new JTextField("");
    JTextField txtPaymentType=new JTextField("");
    JTextField txtBookingID=new JTextField("");
    JTextField txtBookingType=new JTextField("");
    JTextField txtCustomerID=new JTextField("");
    JTextField txtCustomerName=new JTextField("");
    JTextField txtAmountPaid=new JTextField("");
    JTextField txtAmountDue=new JTextField("");
    JTextField txtAmount=new JTextField("");
    JTextField txtTotalAmount=new JTextField("");
    JTextField txtChequeNo=new JTextField("");
    JTextField txtAccountNo=new JTextField("");
    JTextField txtChequeDate=new JTextField("");
    JTextField txtBankName=new JTextField("");

    JButton btnNew=new JButton("");
    JButton btnPay=new JButton("");
    JButton btnSearch=new JButton("");
    JButton btnEdit=new JButton("");
    JButton btnCancel=new JButton("");

    JRadioButton rbcash=new JRadioButton("Cash");
    JRadioButton rbcheque=new JRadioButton("Cheque");
    ButtonGroup bg=new ButtonGroup();

    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/payment.png"));
    public payment()
    {
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setSize(2500,1500);
        txtPaymentID.setEditable(false);

        txtAmountPaid.setEditable(false);
        txtAmountDue.setEditable(false);
        txtTotalAmount.setEditable(false);
        txtAmount.setVisible(false);
        txtChequeNo.setVisible(false);
        txtAccountNo.setVisible(false);
        txtChequeDate.setVisible(false);
        txtBankName.setVisible(false);

        txtPaymentID.setFont(new Font("Georgia",Font.BOLD,25));
        txtDateOfPayment.setFont(new Font("Georgia",Font.BOLD,17));
        txtPaymentType.setFont(new Font("Georgia",Font.BOLD,25));
        txtBookingID.setFont(new Font("Georgia",Font.BOLD,25));
        txtBookingType.setFont(new Font("Georgia",Font.BOLD,25));
        txtCustomerID.setFont(new Font("Georgia",Font.BOLD,25));
        txtCustomerName.setFont(new Font("Georgia",Font.BOLD,25));
        txtAmount.setFont(new Font("Georgia",Font.BOLD,25));
        txtChequeNo.setFont(new Font("Georgia",Font.BOLD,25));
        txtAccountNo.setFont(new Font("Georgia",Font.BOLD,25));
        txtChequeDate.setFont(new Font("Georgia",Font.BOLD,25));
        txtBankName.setFont(new Font("Georgia",Font.BOLD,25));
        txtTotalAmount.setFont(new Font("Georgia",Font.BOLD,20));
        txtAmountPaid.setFont(new Font("Georgia",Font.BOLD,20));
        txtAmountDue.setFont(new Font("Georgia",Font.BOLD,20));

        rbcash.setFont(new Font("calibri",Font.BOLD,25));
        rbcheque.setFont(new Font("calibri",Font.BOLD,25));

        btnNew.setFont(new Font("Georgia",Font.BOLD,30));
        btnPay.setFont(new Font("Georgia",Font.BOLD,30));
        btnSearch.setFont(new Font("Georgia",Font.BOLD,30));
        btnEdit.setFont(new Font("Georgia",Font.BOLD,30));
        btnCancel.setFont(new Font("Georgia",Font.BOLD,30));

        //Border of elements
        txtPaymentID.setBorder(null);
        txtDateOfPayment.setBorder(null);
        txtPaymentType.setBorder(null);
        txtBookingID.setBorder(null);
        txtBookingType.setBorder(null);
        txtCustomerID.setBorder(null);
        txtCustomerName.setBorder(null);
        txtAmount.setBorder(null);
        txtChequeNo.setBorder(null);
        txtAccountNo.setBorder(null);
        txtChequeDate.setBorder(null);
        txtBankName.setBorder(null);
        txtTotalAmount.setBorder(null);
        txtAmountPaid.setBorder(null);
        txtAmountDue.setBorder(null);

        //Optacity of elements
        txtPaymentID.setOpaque(false);
        //txtDateOfPayment.setOpaque(false);
        txtPaymentType.setOpaque(false);
        txtBookingID.setOpaque(false);
        txtBookingType.setOpaque(false);
        txtCustomerID.setOpaque(false);
        txtCustomerName.setOpaque(false);
        txtAmount.setOpaque(false);
        txtChequeNo.setOpaque(false);
        txtAccountNo.setOpaque(false);
        txtChequeDate.setOpaque(false);
        txtBankName.setOpaque(false);
        txtTotalAmount.setOpaque(false);
        txtAmountPaid.setOpaque(false);
        txtAmountDue.setOpaque(false);

        rbcash.setOpaque(false);
        rbcheque.setOpaque(false);

        //SetBound of elements
        txtPaymentID.setBounds(388,113,342,25);
        txtDateOfPayment.setBounds(1353,80,115,25);
        txtPaymentType.setBounds(388,163,342,25);
        txtBookingID.setBounds(388,215,342,25);
        txtBookingType.setBounds(388,262,342,29);
        txtCustomerID.setBounds(1110,142,342,25);
        txtCustomerName.setBounds(1110,192,342,25);
        txtAmount.setBounds(391,418,133,25);
        txtChequeNo.setBounds(825,400,133,25);
        txtAccountNo.setBounds(825,437,133,25);
        txtChequeDate.setBounds(825,472,133,25);
        txtBankName.setBounds(825,510,133,25);
        txtTotalAmount.setBounds(388,559,133,25);
        txtAmountPaid.setBounds(388,601,133,25);
        txtAmountDue.setBounds(388,645,133,25);
        txtAmountPaid.setText("0");
        txtAmountDue.setText("0");

        rbcash.setBounds(388,355,90,35);
        rbcheque.setBounds(490,355,110,35);

        btnNew.setBounds(363,726,100,30);
        btnPay.setBounds(485,726,100,30);
        btnSearch.setBounds(615,726,100,30);
        btnEdit.setBounds(745,726,95,30);
        btnCancel.setBounds(1460,700,75,75);

        //ContentAreaFilled of elements
        btnNew.setContentAreaFilled(false);
        btnPay.setContentAreaFilled(false);
        btnSearch.setContentAreaFilled(false);
        btnEdit.setContentAreaFilled(false);
        btnCancel.setContentAreaFilled(false);

        add(txtPaymentID);
        add(txtDateOfPayment);
        add(txtPaymentType);
        add(txtBookingID);
        add(txtBookingType);
        add(txtCustomerID);
        add(txtCustomerName);
        add(txtTotalAmount);
        add(txtAmountPaid);
        add(txtAmountDue);
        add(txtAmount);
        add(txtChequeNo);
        add(txtAccountNo);
        add(txtChequeDate);
        add(txtBankName);

        add(btnNew);
        add(btnPay);
        add(btnSearch);
        add(btnEdit);
        add(btnCancel);

        add(rbcash);
        add(rbcheque);
        bg.add(rbcash);
        bg.add(rbcheque);

        add(limg);
        limg.setBounds(-15,-43,this.getWidth(),this.getHeight());

        btnNew.addActionListener(this);
        btnPay.addActionListener(this);
        btnSearch.addActionListener(this);
        btnEdit.addActionListener(this);
        btnCancel.addActionListener(this);
        rbcash.addActionListener(this);
        rbcheque.addActionListener(this);
        txtBookingID.addFocusListener(this);
        txtAmountPaid.addFocusListener(this);
        txtTotalAmount.addFocusListener(this);
        txtAmountDue.addFocusListener(this);
        txtAmount.addFocusListener(this);

        txtChequeNo.addFocusListener(this);
        txtBankName.addFocusListener(this);
        txtBookingType.addFocusListener(this);
        txtPaymentType.addFocusListener(this);
        txtAccountNo.addFocusListener(this);
    }
    public void focusGained(FocusEvent fe)
    {

    }
    public void focusLost(FocusEvent fe)
    {

        ///////////////bookinf id lost focus ////////////////////////
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
                    txtBookingType.setText(res.getString(3));
                    txtTotalAmount.setText(res.getString(8));
                    txtCustomerID.setText(res.getString(9));
                    txtCustomerName.setText(res.getString(10));
                }
                str="select * from paymenttbl where booking_ID='"+txtBookingID.getText()+"'";
                ResultSet res1=st.executeQuery(str);
                double sum=0;
                while(res1.next())
                {
                    sum=sum+Double.parseDouble(res1.getString(7));
                }
                txtAmountPaid.setText(""+sum);
                double ramt=Double.parseDouble(txtTotalAmount.getText())-sum;
                txtAmountDue.setText(""+ramt);

            }
            catch(Exception e)
            {
                System.out.print(e);
            }
        }


////////////////////////////////////////////

    /*if(fe.getSource()==txtAmount)
    {
      try{
      Double sumtt=0.0,sums=0.0;
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
       Statement st=con.createStatement();
       String str="select * from paymenttbl where booking_ID='"+txtBookingID.getText()+"'";
       ResultSet res=st.executeQuery(str);
       while(res.next())
         {
          txtAmountPaid.setText(res.getString(15));
         }
}
catch(Exception e)
            {
                System.out.print(e);
            }
    }        */
        if(fe.getSource()==txtBookingID)
        {
            int ctr=0;
            fflg=1;
            String s=txtBookingID.getText();
            if(s.equals(""))
            {}
            else
            {
                for( int i=0;i<s.length();i++)
                {
                    if(s.charAt(i)>='0' && s.charAt(i)<='9'||s.charAt(i)>='a' && s.charAt(i)<='z'||s.charAt(i)>='A' && s.charAt(i)<='Z')
                    {
                        ctr++;
                    }
                    else
                    {
                        fflg=0;
                        JOptionPane.showMessageDialog(null,"Enter Correct Booking ID");
                        txtBookingID.setText("");
                        break;
                    }
                }
            }
        }

        if(fe.getSource()==txtBookingType)
        {
            int ctr=0;
            String s=txtBookingType.getText();
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
                        JOptionPane.showMessageDialog(null,"Enter in Correct Format");
                        txtBookingType.setText("");
                        break;
                    }
                }
            }
        }
        if(fe.getSource()==txtPaymentType)
        {
            int ctr=0;
            String s=txtPaymentType.getText();
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
                        JOptionPane.showMessageDialog(null,"Enter in Correct Format");
                        txtPaymentType.setText("");
                        break;
                    }
                }
            }
        }
        if(fe.getSource()==txtBankName)
        {
            int ctr=0;
            String s=txtBankName.getText();
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
                        JOptionPane.showMessageDialog(null,"Enter Correct Bank Name");
                        txtBankName.setText("");
                        break;
                    }
                }
            }
        }
        if(fe.getSource()==txtAmount)
        {
            int ctr=0;
            String s=txtAmount.getText();
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
                        JOptionPane.showMessageDialog(null,"Enter Correct Amount");
                        txtAmount.setText("");
                        break;
                    }
                }
            }
        }
        if(fe.getSource()==txtAccountNo)
        {
            int ctr=0;
            String s=txtAccountNo.getText();
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
                        JOptionPane.showMessageDialog(null,"Enter Correct Account No");
                        txtAccountNo.setText("");
                        break;
                    }
                }
            }
        }
        if(fe.getSource()==txtChequeNo)
        {
            int ctr=0;
            String s=txtChequeNo.getText();
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
                        JOptionPane.showMessageDialog(null,"Enter Correct Cheque Number");
                        txtChequeNo.setText("");
                        break;
                    }
                }
            }
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==rbcash)
        {
            txtAmount.setVisible(true);
            txtChequeNo.setVisible(false);
            txtAccountNo.setVisible(false);
            txtChequeDate.setVisible(false);
            txtBankName.setVisible(false);
            txtAmount.setText("");
        }
        if(e.getSource()==rbcheque)
        {
            txtAmount.setVisible(true);
            txtChequeNo.setVisible(true);
            txtAccountNo.setVisible(true);
            txtChequeDate.setVisible(true);
            txtBankName.setVisible(true);
            txtAmount.setText("");
            txtChequeNo.setText("");
            txtChequeDate.setText("");
            txtAccountNo.setText("");
            txtBankName.setText("");
        }
        if(e.getSource()==btnNew)
        {
            btnEdit.setEnabled(false);
            btnPay.setEnabled(true);
            txtDateOfPayment.setEnabled(true);
            try
            {
                int ctr=1;
                Calendar cal=Calendar.getInstance();
String sdate=cal.get(Calendar.YEAR)+"-"+(String.format("%02d",cal.get(Calendar.MONTH)+1))+"-"+String.format("%02d",cal.get(Calendar.DATE));                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str1="select payid from keytbl";
                ResultSet res=st.executeQuery(str1);
                while(res.next())
                {
                    ctr=Integer.parseInt(res.getString(1));
                }
                if(ctr>0&&ctr<=9)
                {
                    txtPaymentID.setText("P00"+ctr);
                }
                else if(ctr>=10&&ctr<=99)
                {
                    txtPaymentID.setText("P0"+ctr);
                }
                else if(ctr>=100)
                {
                    txtPaymentID.setText("P"+ctr);
                }
                txtDateOfPayment.setText(sdate);
                txtPaymentType.setText("");
                txtBookingID.setText("");
                txtBookingType.setText("");
                txtTotalAmount.setText("");
                txtAmountPaid.setText("0");
                txtAmount.setText("0");
                txtAmountDue.setText("0");
                txtCustomerID.setText("");
                txtCustomerName.setText("");

                bg.clearSelection();
            }
            catch( Exception e1)
            {
                System.out.println(e1);
            }
        }

        if(e.getSource()==btnPay)
        {
            btnEdit.setEnabled(false);
            try
            {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                String str="insert into paymenttbl(payment_ID,date_of_payment,payment_type,booking_ID,booking_type,payment_mode,amount,cheque_no,account_no,cheque_date,bank_name,customer_ID,customer_name,total_amt,amt_paid,amt_due)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(str);

                ps.setString(1,(txtPaymentID.getText()));
                ps.setString(2,(txtDateOfPayment.getText()));
                ps.setString(3,(txtPaymentType.getText()));
                ps.setString(4,(txtBookingID.getText()));
                ps.setString(5,(txtBookingType.getText()));
                ps.setString(7,(txtAmount.getText()));
                ps.setString(12,(txtCustomerID.getText()));
                ps.setString(13,(txtCustomerName.getText()));
                ps.setString(14,(txtTotalAmount.getText()));

                if(rbcash.isSelected())
                {
                    ps.setString(6,"Cash");
                    ps.setString(8,"NA");
                    ps.setString(9,"NA");
                    ps.setString(10,"NA");
                    ps.setString(11,"NA");
                }
                else
                {
                    ps.setString(6,"Cheque");
                    ps.setString(8,(txtChequeNo.getText()));
                    ps.setString(9,(txtAccountNo.getText()));
                    ps.setString(10,(txtChequeDate.getText()));
                    ps.setString(11,(txtBankName.getText()));
                }
                double amt=Double.parseDouble(txtAmount.getText());
                double pamt=Double.valueOf(txtAmountPaid.getText())+amt;
                txtAmountPaid.setText(""+pamt);

                double damt=Double.valueOf(txtTotalAmount.getText())-pamt;
                txtAmountDue.setText(""+damt);
                ps.setString(15,(txtAmountPaid.getText()));
                ps.setString(16,(txtAmountDue.getText()));
                ps. executeUpdate();

                String strr="update keytbl set payid=payid+1";
                Statement st=con.createStatement();
                st.executeUpdate(strr);
                JOptionPane.showMessageDialog(null,"Record saved");

                PrintWriter pw=new PrintWriter("receipt.txt");

                pw.println("Rahul Township Pvt. Ltd.");
                pw.println("-------------------------");
                pw.println("Customer ID: "+txtCustomerID.getText()+"\t\t\t\t\tDate: "+txtDateOfPayment.getText());
                pw.println("\nCustomer Name: "+txtCustomerName.getText());
                if(rbcash.isSelected())
                {
                    pw.println("Booking ID: "+txtBookingID.getText());
                    pw.println("Booking Type: "+txtBookingType.getText());
                    pw.println("Payment Mode: "+txtPaymentType.getText());
                    pw.println("Amount: "+txtAmount.getText());
                    pw.println("Cheque No: "+"NA");
                    pw.println("Account No: "+"NA");
                    pw.println("Cheque Date: "+"NA");
                    pw.println("Bank Name: "+"NA");

                    pw.close();
                    Process p=Runtime.getRuntime().exec("Notepad receipt.txt");
                }
                else
                {
                    pw.println("Booking ID: "+txtBookingID.getText());
                    pw.println("Booking Type: "+txtBookingType.getText());
                    pw.println("Payment Mode: "+txtPaymentType.getText());
                    pw.println("Amount: "+txtAmount.getText());
                    pw.println("Cheque No: "+txtChequeNo.getText());
                    pw.println("Account No: "+txtAccountNo.getText());
                    pw.println("Cheque Date: "+txtChequeDate.getText());
                    pw.println("Bank Name: "+txtBankName.getText());

                    pw.close();
                    Process p=Runtime.getRuntime().exec("Notepad receipt.txt");
                }
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }

        }
        //   Double sii=Double.parseDouble(txtTotalAmount.getText())-Double.parseDouble(txtAmountPaid.getText());
        // ps.setString(16,""+sii);

        if(e.getSource()==btnSearch)
        {
            txtDateOfPayment.setEnabled(true);
            btnPay.setEnabled(false);
            btnEdit.setEnabled(true);
            try
            {
                int flag=0;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String stt=JOptionPane.showInputDialog(null,"Enter Payment ID");
                txtPaymentID.setText(stt);

                String str="select * from paymenttbl where payment_ID='"+txtPaymentID.getText()+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    flag=1;
                    txtPaymentID.setText(stt);
                    txtDateOfPayment.setText(res.getString(2));
                    txtPaymentType.setText(res.getString(3));
                    txtBookingID.setText(res.getString(4));
                    txtBookingType.setText(res.getString(5));
                    if(res.getString(6).equals("Cash"))
                    {
                        rbcash.setSelected(true);
                        txtAmount.setVisible(true);
                        txtChequeNo.setVisible(false);
                        txtAccountNo.setVisible(false);
                        txtChequeDate.setVisible(false);
                        txtBankName.setVisible(false);
                    }
                    else
                    {
                        rbcheque.setSelected(true);
                        txtAmount.setVisible(true);
                        txtChequeNo.setVisible(true);
                        txtAccountNo.setVisible(true);
                        txtChequeDate.setVisible(true);
                        txtBankName.setVisible(true);
                    }

                    txtAmount.setText(res.getString(7));
                    txtChequeNo.setText(res.getString(8));
                    txtAccountNo.setText(res.getString(9));
                    txtChequeDate.setText(res.getString(10));
                    txtBankName.setText(res.getString(11));
                    txtCustomerID.setText(res.getString(12));
                    txtCustomerName.setText(res.getString(13));
                    txtTotalAmount.setText(res.getString(14));
                    txtAmountPaid.setText(res.getString(15));
                    txtAmountDue.setText(res.getString(16));
                /*    Connection con1=DriverManager.getConnection("jdbc:odbc:cdsn");
            Statement st1=con1.createStatement();
            String stt1=JOptionPane.showInputDialog(null,"Enter Payment ID");
            txtPaymentID.setText(stt1);

            String str1="select * from paymenttbl where payment_ID='"+txtPaymentID.getText()+"'";
            ResultSet res1=st.executeQuery(str1);
            while(res1.next())
                {
                }
        if(flag==0)
          JOptionPane.showMessageDialog(null,"NO SUCH RECORD");
  }*/
                }
            }
            catch(Exception ce)
            {
                JOptionPane.showMessageDialog(null,ce);
            }
        }
        if(e.getSource()==btnEdit)
        {
            btnPay.setEnabled(false);
            String stt="";
            try
            {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                if(rbcash.isSelected())
                    stt="Cash";
                else
                    stt="Cheque";

                String str="update paymenttbl set date_of_payment='"+txtDateOfPayment.getText()+"',payment_type='"+txtPaymentType.getText()+"',booking_ID='"+txtBookingID.getText()+"',booking_type='"+txtBookingType.getText()+"',payment_mode='"+stt+"',amount='"+txtAmount.getText()+"',cheque_no='"+txtChequeNo.getText()+"',Cheque_Date='"+txtChequeDate.getText()+"',bank_name='"+txtBankName.getText()+"',customer_ID='"+txtCustomerID+"',customer_name='"+txtCustomerName.getText()+"',total_amt='"+txtTotalAmount.getText()+"',amt_paid='"+txtAmountPaid.getText()+"',amt_due='"+txtAmountDue+"' where payment_ID='"+txtPaymentID.getText()+"'";
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
    public static void main(String[] args)throws IOException
    {
        payment obj=new payment();
    }
}