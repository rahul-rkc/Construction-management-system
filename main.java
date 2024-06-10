import java.io.*;
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import java.applet.*;
public class main extends JFrame implements ActionListener
{
	MenuBar mb=new MenuBar();
	
	Menu mnmas=new Menu("master");
	Menu mntrans=new Menu("transaction");
	Menu mnreport=new Menu("Report");
	Menu mnexit=new Menu("Exit");

	MenuItem flt=new MenuItem("Flat");
	MenuItem dplx=new MenuItem("Duplex");
	MenuItem stf=new MenuItem("Staff");
	MenuItem cus=new MenuItem("Customer");

	MenuItem enq=new MenuItem("Enquiry");
	MenuItem flwup=new MenuItem("Follow Up");
	MenuItem book=new MenuItem("Booking");
	MenuItem can=new MenuItem("Cancel");
	MenuItem pay=new MenuItem("Payment");

	MenuItem rdate=new MenuItem("Daily Status");
	MenuItem rcoll=new MenuItem("Monthly Status");
	MenuItem ravail=new MenuItem("Availability Status");

	MenuItem ext=new MenuItem("Exit");

	JButton btnflat=new JButton("");
    JButton btnstaff=new JButton("");
    JButton btncustomer=new JButton("");
    JButton btnfollowup=new JButton("");
    JButton btnbooking=new JButton("");
    JButton btnpayment=new JButton("");

	JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/main.png"));
	
	public main()
	{
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setUndecorated(true);
	setLayout(null);
   	setVisible(true);
    setSize(2500,1500);

    mb.setFont(new Font("Georgia",Font.BOLD,20));
	
	mb.add(mnmas);
	mb.add(mntrans);
	mb.add(mnreport);
	mb.add(mnexit);

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
	mnreport.add(rcoll);
	mnreport.add(ravail);

	mnexit.add(ext);

	btnflat.setContentAreaFilled(false);
    btnstaff.setContentAreaFilled(false);
    btncustomer.setContentAreaFilled(false);
    btnfollowup.setContentAreaFilled(false);
    btnbooking.setContentAreaFilled(false);
    btnpayment.setContentAreaFilled(false);

    btnflat.setBounds(210,200,280,55);
    btnstaff.setBounds(43,480,280,55);
    btncustomer.setBounds(231,760,310,55);
    btnfollowup.setBounds(1075,197,270,55);
    btnbooking.setBounds(1200,468,270,47);
    btnpayment.setBounds(1075,765,285,55);

    add(btnflat);
    add(btnstaff);
    add(btncustomer);
    add(btnfollowup);
    add(btnbooking);
    add(btnpayment);

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
	ext.addActionListener(this);

	btnflat.addActionListener(this);
    btnstaff.addActionListener(this);
    btncustomer.addActionListener(this);
    btnfollowup.addActionListener(this);
    btnbooking.addActionListener(this);
    btnpayment.addActionListener(this);
    
	add(limg);
	limg.setBounds(-480,-330,this.getWidth(),this.getHeight());
   }
	public void actionPerformed(ActionEvent e)
   {
   	if(e.getSource()==btnflat)
   	{
   		flat obj=new flat();
   	}
    if(e.getSource()==btncustomer)
	{
    	customer obj=new customer();
	}
	if(e.getSource()==btnstaff)
	{
    	staff obj=new staff();
	}
	if(e.getSource()==btnbooking)
	{
        booking obj=new booking();
	}
   	if(e.getSource()==btnfollowup)
	{
    	followup obj=new followup(); 
	}
	if(e.getSource()==btnpayment)
	{
    	payment obj=new payment(); 
	}
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
		monthlyreport obj=new monthlyreport();
	}
	if(e.getSource()==ext)
	{
		this.dispose();
	}
   }
	public static void main(String args[])throws IOException
	{
		main obj=new main();
	}
}