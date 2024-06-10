import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class monthlyreport extends JFrame implements ActionListener
{
    JButton btnOk=new JButton("");
    JButton btnCancel=new JButton("");

    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/month.png"));

        String bmonth[]={"select","01","02","03","04","05","06","07","08","09","10","11","12"};
    JComboBox cmbMonthName=new JComboBox(bmonth);  

    public monthlyreport()
    {
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //setUndecorated(true);
      setLayout(null);
      setVisible(true);
      setSize(700,450);
       setResizable(false);
      setLocationRelativeTo(null);

      cmbMonthName.setFont(new Font("Georgia",Font.BOLD,20));

      cmbMonthName.setBounds(300,120,108,30);

      btnOk.setBounds(193,240,94,30);
      btnCancel.setBounds(320,240,94,30);

      add(cmbMonthName);
      add(btnOk);
      add(btnCancel);

      btnOk.setContentAreaFilled(false);
      btnCancel.setContentAreaFilled(false);

      btnOk.addActionListener(this);
      btnCancel.addActionListener(this);

      add(limg);
      limg.setBounds(0,0,this.getWidth(),this.getHeight());
  }
  	public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==btnOk)
        {
        	try
        	{     
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");

                String sdate="select * from paymenttbl ";//where date_of_payment='"+cmbMonthName.getSelectedItem()+"'";
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(sdate);
                PrintWriter pw=new PrintWriter("collection.txt");
                pw.println("");
                pw.println("");
                pw.println("                                Nikhil Township Pvt. Ltd.");
                pw.println("                                --------------------------");
                pw.println("");
                pw.println("");
                pw.println("");

                  pw.println(" Payment ID     Date of Payment     Payment Type     Booking ID     Booking Type     Payment Mode    Amount    Customer ID    Customer Name");
                pw.println("--------------------------------------------------------------------------------------------------------------------------------------------");
               while(res.next())
                 {
                     String mstr="";
                     mstr=res.getString(2);
                     String []mmm=mstr.split("-",3);
                     int m1=Integer.parseInt(mmm[1]);
                     if(bmonth[m1].equals(cmbMonthName.getSelectedItem()))
                      {
                        String tsta=res.getString(1);
                        int len=tsta.length();
                        for(int i=1;i<12-len;i++)
                         {
                            pw.print(" ");  
                         }
                        pw.print(tsta);

                        int len1=mstr.length();
                        for(int ii=1;ii<21-len1;ii++)
                         {
                            pw.print(" ");
                         }
                        pw.print(mstr);

                        String tstc=res.getString(3);
                        int len3=tstc.length();
                        for(int i=1;i<18-len3;i++)
                         {
                            pw.print(" ");
                         }
                        pw.print(tstc);

                        String tstd=res.getString(4);
                        int len4=tstd.length();
                        for(int ii=1;ii<16 -len4;ii++)
                         {
                             pw.print(" ");
                         }
                        pw.print(tstd);

                        String tste=res.getString(5);
                        int len5=tste.length();
                        for(int i=1;i<18-len5;i++)
                         {
                             pw.print(" ");
                         }
                        pw.print(tste);

                        String tstf=res.getString(6);
                        int len6=tstf.length();
                        for(int ii=1;ii<15-len6;ii++)
                         {
                             pw.print(" ");
                         }
                        pw.print(tstf);

                        String tstg=res.getString(7);
                        int len7=tstg.length();
                        for(int ii=1;ii<14-len7;ii++)
                         {
                             pw.print(" ");
                         }
                        pw.print(tstg);
     
                        String tsth=res.getString(12);
                        int len8=tsth.length();
                        for(int ii=1;ii<16-len8;ii++)
                         {
                             pw.print(" ");
                         }
                        pw.print(tsth);
                    
                        String tsti=res.getString(13);
                        int len9=tsti.length();
                        for(int ii=1;ii<18-len9;ii++)
                         {
                            pw.print(" ");
                         }
                        pw.print(tsti);

                       pw.println();       
                   }
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
  public static void main(String args[])throws IOException
  {
  	monthlyreport obj=new monthlyreport();
  }
}