import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class availablereport extends JFrame implements ActionListener
{
	
	JButton btnOk=new JButton(" ");
	JButton btnCancel=new JButton("");

	JRadioButton rbflat=new JRadioButton("Flat");
    JRadioButton rbduplex=new JRadioButton("Duplex");
    ButtonGroup bg=new ButtonGroup();

    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/availability.png"));

	public availablereport()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
		setLayout(null);
        setVisible(true);
        setSize(840,460);
        setResizable(false);
        setLocationRelativeTo(null);

        rbflat.setFont(new Font("Georgia",Font.BOLD,25));
        rbduplex.setFont(new Font("Georgia",Font.BOLD,25));

        rbflat.setBounds(270,159,120,45);
        rbduplex.setBounds(380,159,120,45);

        rbduplex.setOpaque(false);
        rbflat.setOpaque(false);
         btnCancel.setBorder(null);
        btnOk.setBorder(null);

        btnOk.setBounds(270,274,90,30);
        btnCancel.setBounds(387,274,92,30);

        btnOk.setContentAreaFilled(false);
        btnCancel.setContentAreaFilled(false);


        add(rbflat);
        add(rbduplex);
        bg.add(rbflat);
        bg.add(rbduplex);

        add(btnOk);
        add(btnCancel);

        add(limg);
      limg.setBounds(0,-10,835,460);

        btnOk.addActionListener(this);
        btnCancel.addActionListener(this);
        rbduplex.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnOk)
        {
            if(rbflat.isSelected())
            {
            try
            {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String sdate="select * from flattbl where flat_status='Available'";
                ResultSet res=st.executeQuery(sdate);
                PrintWriter pw=new PrintWriter("report.txt");
                pw.println("");
                pw.println("");
                pw.println("                               Nikhil Township Pvt. Ltd.");
                pw.println("                              --------------------------");
                pw.println("");
                pw.println("");
                pw.println("");
                pw.println("       Flat No             Flat Floor          Flat Building          Builtup Area          Maintainance          Price");
                pw.println("      ------------------------------------------------------------------------------------------------------------------");
               while(res.next())
                 {
                    String tsta=res.getString(1);
                    int len=tsta.length();
                    for(int i=1;i<15-len;i++)
                    {
                        pw.print(" ");  
                    }
                    pw.print(tsta);

                    String tstb=res.getString(2);
                    int len1=tstb.length();
                    for(int ii=1;ii<20-len1;ii++)
                    {
                        pw.print(" ");
                    }
                    pw.print(tstb);

                    String tstc=res.getString(3);
                    int len3=tstc.length();
                    for(int i=1;i<25-len3;i++)
                    {
                        pw.print(" ");
                    }
                     pw.print(tstc);

                    String tstd=res.getString(4);
                    int len4=tstd.length();
                    for(int ii=1;ii<25 -len4;ii++)
                    {
                        pw.print(" ");
                    }
                    pw.print(tstd);

                    String tste=res.getString(5);
                    int len5=tste.length();
                    for(int i=1;i<23-len5;i++)
                    {
                        pw.print(" ");
                    }
                    pw.print(tste);

                    String tstf=res.getString(6);
                    int len6=tstf.length();
                    for(int ii=1;ii<17-len6;ii++)
                    {
                        pw.print(" ");
                    }
                    pw.print(tstf);
                    
                    pw.println();       
                }
                pw.close();

                Process p=Runtime.getRuntime().exec("Notepad report.txt");
                 
             }
             catch(Exception eee)
            {
                System.out.print(eee);
            }
        }

        else
        {
            if(rbduplex.isSelected())
            {
            try
            {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String sdate="select * from duplextbl where duplex_status='Available'";
                ResultSet res1=st.executeQuery(sdate);
                PrintWriter pwr=new PrintWriter("report1.txt");
                pwr.println("");
                pwr.println("");
                pwr.println("                                                         Rahul Township Pvt. Ltd.");
                pwr.println("                                                        --------------------------");
                pwr.println("");
                pwr.println("");
                pwr.println("");
                pwr.println("       Duplex No             Flat Building          Builtup Area          Maintainance          Price");
                pwr.println("      ------------------------------------------------------------------------------------------------");
                while(res1.next())
                 {
                    String tstaa=res1.getString(1);
                    int len7=tstaa.length();
                    for(int i=1;i<16-len7;i++)
                    {
                        pwr.print(" ");  
                    }
                    pwr.print(tstaa);

                    String tstbb=res1.getString(2);
                    int len8=tstbb.length();
                    for(int ii=1;ii<25-len8;ii++)
                    {
                        pwr.print(" ");
                    }
                    pwr.print(tstbb);

                    String tstcc=res1.getString(3);
                    int len9=tstcc.length();
                    for(int i=1;i<25-len9;i++)
                    {
                        pwr.print(" ");
                    }
                     pwr.print(tstcc);

                    String tstdd=res1.getString(4);
                    int lenn=tstdd.length();
                    for(int ii=1;ii<23-lenn;ii++)
                    {
                        pwr.print(" ");
                    }  
                    pwr.print(tstdd);

                    String tstee=res1.getString(5);
                    int lenn1=tstee.length();
                    for(int i=1;i<17-lenn1;i++)
                    {
                        pwr.print(" ");
                    }
                    pwr.print(tstee);
                    pwr.println();
                 }
                    pwr.close();
                    Process p=Runtime.getRuntime().exec("Notepad report1.txt");
                }
            catch(Exception ee)
            {
                System.out.print(ee);
            }
        }
    }
}
    if(e.getSource()==btnCancel)
        {
            this.dispose();
        }
    }
	public static void main(String args[])throws IOException
	{
		availablereport obj=new availablereport();
	}
}