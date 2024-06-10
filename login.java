import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class login extends JFrame implements ActionListener
{
	int ctr=0;

	JTextField txtUsername=new JTextField();
	JPasswordField txtPassword=new JPasswordField();

	JButton btnOk=new JButton("");
    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/login1.png"));

    public login()
    {
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   // setUndecorated(true);
	setLayout(null);
   	setVisible(true);
    setSize(845,720);
    setTitle("Login");
    setResizable(false);
    setLocationRelativeTo(null);

    txtUsername.setFont(new Font("Georgia",Font.BOLD,20));
    txtPassword.setFont(new Font("Georgia",Font.BOLD,20));

    txtUsername.setBounds(358,269,296,44);
    txtUsername.setBorder(null);
    txtPassword.setBounds(358,355,296,44);
    txtPassword.setBorder(null);
    btnOk.setBounds(82,495,650,45);

    btnOk.setContentAreaFilled(false);
    btnOk.setOpaque(false);
    //btnOk.setBorder(null);
    txtUsername.setOpaque(false);
    txtPassword.setOpaque(false);

    add(txtUsername);
    add(txtPassword);

    add(btnOk);
    add(limg);
    limg.setBounds(-0,0,this.getWidth(),this.getHeight());

    btnOk.addActionListener(this);
    }
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==btnOk)
	{
		
		try
        {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
	        Statement st=con.createStatement();
            String spass=new String(txtPassword.getPassword());
		    String str="select * from logintbl where username='"+txtUsername.getText()+"' and password='"+spass+"'";
	        ResultSet res=st.executeQuery(str);
            if(res.next())
                {
                    JOptionPane.showMessageDialog(null,"Login Sucessfull :)");
            		this.dispose();
            		main obj=new main();
            		ctr=0;
            	}
            else
            	{
            		JOptionPane.showMessageDialog(null,"Login Denied :(");
            		ctr++;
                    if(ctr>=3)
                    {
                        JOptionPane.showMessageDialog(null,"Sorry!!! can't try more then thrice :)");
                        this.dispose();
                    }
                }
        }
        catch(Exception ee)
        {
        	System.out.print(ee);
        }
    }
}
public static void main(String args[])throws IOException
{
	login obj=new login();
}
}