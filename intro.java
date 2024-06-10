import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class intro extends JFrame implements ActionListener
{
    int ctr=0;
    JButton btnOk=new JButton("");
    Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/rahul/Desktop/project/design/icon.png");
    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/intro.png"));
        public intro()
    {
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setSize(600,730);
        // setIconImage(icon);    
        setLocationRelativeTo(null);
        // setResizable(false);

        add(btnOk);
        btnOk.setBounds(260,675,87,42);
        btnOk.setContentAreaFilled(false);
        btnOk.addActionListener(this);
        add(limg);
        limg.setBounds(0,0,this.getWidth(),this.getHeight());
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnOk)
        {
            login obj=new login();
            this.dispose();
        }
    }
    public static void main(String args[])throws IOException
    {
        intro obj=new intro();
    }
}