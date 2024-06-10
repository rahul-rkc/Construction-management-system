import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class dailyreport extends JFrame implements ActionListener
{
	JTextField txtDate=new JTextField();

	JButton btnOk=new JButton("");
	JButton btnCancel=new JButton("");

	JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/date.png"));

	public dailyreport()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
		  setLayout(null);
        setVisible(true);
        setSize(855,490);
        setResizable(false);
        setLocationRelativeTo(null);    

        txtDate.setFont(new Font("Georgia",Font.BOLD,20));

        txtDate.setBounds(374,118,107,26);

        btnOk.setBounds(266,236,94,30);
        btnCancel.setBounds(391,238,93,29);

        txtDate.setOpaque(false);
        txtDate.setBorder(null);

        add(txtDate);
        add(btnOk);
        add(btnCancel);

        btnOk.setContentAreaFilled(false);
        btnCancel.setContentAreaFilled(false);

        btnOk.addActionListener(this);
   	    btnCancel.addActionListener(this);

   	    add(limg);
        limg.setBounds(-5,-10,850,460);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnOk)
		{
			int ctr=0;
			try
			{
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
				Statement st=con.createStatement();
				String sdate="select * from bookingtbl where date_of_booking='"+txtDate.getText()+"'";
				ResultSet res=st.executeQuery(sdate);
				PrintWriter pw=new PrintWriter("report.txt");

				pw.println("");
                pw.println("");
                pw.println("                              Nikhil Township Pvt. Ltd.");
                pw.println("                              --------------------------");
                pw.println("");
                pw.println("");
                pw.println("");
				pw.println("        Booking ID     Booking Type     Flat No         Duplex No       Price    Customer ID    Customer Name     Contact No     Address");
                pw.println("       ----------------------------------------------------------------------------------------------------------------------------------");
//int fflg=0;
               while(res.next())
                 {
                 	//fflg=1;
                 	ctr++;
				    String tsta=res.getString(1);
                    int len=tsta.length();
                    for(int i=1;i<19-len;i++)
                     {
                        pw.print(" ");  
                     }
                    pw.print(tsta);

                    String tstb=res.getString(3);
                    int len1=tstb.length();
                    for(int ii=1;ii<18-len1;ii++)
                     {
                        pw.print(" ");
                     }
                    pw.print(tstb);

                    String tstc=res.getString(4);
                    int len3=tstc.length();
                    for(int i=1;i<13-len3;i++)
                     {
                        pw.print(" ");
                     }
                    pw.print(tstc);

                    String tstd=res.getString(5);
                    int len4=tstd.length();
                    for(int ii=1;ii<19-len4;ii++)
                     {
                         pw.print(" ");
                     }
                    pw.print(tstd);

                    String tstg=res.getString(8);
                    int len7=tstg.length();
                    for(int ii=1;ii<13-len7;ii++)
                     {
                         pw.print(" ");
                     }
                    pw.print(tstg);
     
                    String tsth=res.getString(9);
                    int len8=tsth.length();
                    for(int ii=1;ii<16-len8;ii++)
                    {
                        pw.print(" ");
                    }
                    pw.print(tsth);
                    
                    String tsti=res.getString(10);
                    int len9=tsti.length();
                    for(int ii=1;ii<18-len9;ii++)
                     {
                        pw.print(" ");
                     }
                    pw.print(tsti);
     
                    String tstl=res.getString(13);
                    int len12=tstl.length();
                    for(int ii=1;ii<16-len12;ii++)
                     {
                        pw.print(" ");
                     }
                    pw.print(tstl);
                   
                    String tstn=res.getString(15);
                    int len14=tstn.length();
                    for(int ii=1;ii<13-len14;ii++)
                     {
                        pw.print(" ");
                     }
                    pw.print(tstn);

                    pw.println();
                  }
			pw.close();
			//if(fflg==1)
			
			Process p=Runtime.getRuntime().exec("Notepad report.txt");
			
		}

			catch(Exception ee)
			{
				System.out.print(e);
			}
		}
		if(e.getSource()==btnCancel)
		{
			this.dispose();
		}
	}
	public static void main(String args[])throws IOException
	{
		dailyreport obj=new dailyreport();
	}
}