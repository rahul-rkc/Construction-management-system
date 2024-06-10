import java.io.*;
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import java.applet.*;
public class db extends JFrame implements ActionListener
{
	MenuBar mb=new MenuBar();
	
	Menu mnmas=new Menu("master");
	Menu mntrans=new Menu("transaction");
	Menu mnreport=new Menu("Report");

	MenuItem flt=new MenuItem("Flat");
	MenuItem dplx=new MenuItem("Duplex");
	MenuItem stf=new MenuItem("Staff");
	MenuItem cus=new MenuItem("Customer");

	MenuItem enq=new MenuItem("Enquiry");
	MenuItem flwup=new MenuItem("Follow Up");
	MenuItem book=new MenuItem("Booking");
	MenuItem can=new MenuItem("Cancel");
	MenuItem pay=new MenuItem("Payment");

	MenuItem rdate=new MenuItem("Daily Report");
	MenuItem ravail=new MenuItem("Availability Status");
	MenuItem rcoll=new MenuItem("Collection Status");

	JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/dbb.png"));
	
	public db()
	{
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//setUndecorated(true);
	setLayout(null);
   	setVisible(true);
    setSize(2500,1500);
    setResizable(false);
    //setLocationRelativeTo(null);

    mb.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
	
	mb.add(mnmas);
	mb.add(mntrans);
	mb.add(mnreport);

	mnmas.add(flt);
	mnmas.add(dplx);
	mnmas.add(stf);
	mnmas.add(cus);

	mntrans.add(enq);
	mntrans.add(flwup);
	mntrans.add(book);
	mntrans.add(can);
	mntrans.add(pay);

	mnreport.add(rdate);
	mnreport.add(ravail);
	mnreport.add(rcoll);

	this.setMenuBar(mb);
	
	flt.addActionListener(this);
	dplx.addActionListener(this);
	stf.addActionListener(this);
	cus.addActionListener(this);

	enq.addActionListener(this);
	flwup.addActionListener(this);
	book.addActionListener(this);
	can.addActionListener(this);
	pay.addActionListener(this);

	rdate.addActionListener(this);
	ravail.addActionListener(this);
	rcoll.addActionListener(this);
	add(limg);
	limg.setBounds(-15,-50,this.getWidth(),this.getHeight());
   }
	public void actionPerformed(ActionEvent e)
   {
   	if(e.getSource()==flt)
   	{
   		flat obj=new flat();
   	}
   	if(e.getSource()==dplx)
    {
    	duplex obj=new duplex();
   	}
	if(e.getSource()==stf)
	{
    	staff obj=new staff();
	}
    if(e.getSource()==cus)
	{
    	customer obj=new customer();
	}
	if(e.getSource()==enq)
	{
        enquiry obj=new enquiry();
	}
   	if(e.getSource()==flwup)
	{
    	followup obj=new followup(); 
	}
	if(e.getSource()==book)
	{
        booking obj=new booking();
	}
	if(e.getSource()==can)
	{
		cancel obj=new cancel();
	}
	if(e.getSource()==pay)
	{
	    payment obj=new payment();
	}
	if(e.getSource()==rdate)
	{
		dailyreport obj=new dailyreport();
	}
	if(e.getSource()==ravail)
	{
		availablereport obj=new availablereport();
	}
	if(e.getSource()==rcoll)
	{
		reportcollection obj=new reportcollection();
	}
   }
	public static void main(String args[])throws IOException
	{
		db obj=new db();
	}
}