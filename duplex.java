import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class duplex extends JFrame implements ActionListener,ItemListener,FocusListener
{
    int tflg=1;
    JTextField txtDuplexNo=new JTextField();    
    JTextField txtBuiltUpArea=new JTextField();
    JTextField txtMaintainance=new JTextField();
    JTextField txtPrice=new JTextField();
    JTextField txtAvailable=new JTextField("Available");

    JButton btnNew=new JButton("");
    JButton btnSave=new JButton("");
    JButton btnSearch=new JButton("");
    JButton btnEdit=new JButton("");
    JButton btnCancel=new JButton("");

    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop//project/design/duplex.png"));

    String bname[]={"select","Mannat","Jannat","Janak","Jalsa"};
    JComboBox cmbDuplexName=new JComboBox(bname);

    public duplex()
   {
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //setUndecorated(true);
   	setLayout(null);
   	setVisible(true);
    setSize(2500,1500); 
    setTitle("DUPLEX DETAILS");
    //setResizable(false);
    setLocationRelativeTo(null);

    txtAvailable.setEnabled(false);
    //txtDuplexNo.setEnabled(true);

    txtDuplexNo.setFont(new Font("Georgia",Font.BOLD,25));
    txtBuiltUpArea.setFont(new Font("Georgia",Font.BOLD,25));
    txtMaintainance.setFont(new Font("Georgia",Font.BOLD,25));
    txtPrice.setFont(new Font("Georgia",Font.BOLD,25));
    txtAvailable.setFont(new Font("Georgia",Font.BOLD,25));
    
    btnNew.setFont(new Font("Georgia",Font.BOLD,30));
    btnSave.setFont(new Font("Georgia",Font.BOLD,30));
    btnSearch.setFont(new Font("Georgia",Font.BOLD,30));
    btnEdit.setFont(new Font("Georgia",Font.BOLD,30));
    btnCancel.setFont(new Font("Georgia",Font.BOLD,30));

    cmbDuplexName.setFont(new Font("Georgia",Font.BOLD,25));

    txtDuplexNo.setBorder(null);
    txtBuiltUpArea.setBorder(null);
    txtMaintainance.setBorder(null);
    txtPrice.setBorder(null);
    txtAvailable.setBorder(null);

    btnNew.setContentAreaFilled(false);
    btnSave.setContentAreaFilled(false);
    btnSearch.setContentAreaFilled(false);
    btnEdit.setContentAreaFilled(false);
    btnCancel.setContentAreaFilled(false);

    txtDuplexNo.setOpaque(false);
    txtBuiltUpArea.setOpaque(false);
    txtMaintainance.setOpaque(false);
    txtPrice.setOpaque(false);
    txtAvailable.setOpaque(false);

    txtDuplexNo.setBounds(575,180,350,30);
    txtBuiltUpArea.setBounds(575,300,350,30);
    txtMaintainance.setBounds(575,358,350,30);
    txtPrice.setBounds(575,420,350,27);
    txtAvailable.setBounds(575,473,350,30);

    cmbDuplexName.setBounds(570,240,350,30);
    
    btnNew.setBounds(378,650,95,32);
    btnSave.setBounds(495,650,95,32);
    btnSearch.setBounds(617,650,95,32);
    btnEdit.setBounds(738,650,95,32);
    btnCancel.setBounds(1457,627,75,75);

   	add(txtDuplexNo);
   	add(txtBuiltUpArea);
   	add(txtMaintainance);
    add(txtPrice);
   	add(txtAvailable);

   	add(btnNew);
   	add(btnSave);
   	add(btnSearch);
   	add(btnEdit);
   	add(btnCancel);

    add(cmbDuplexName);

    add(limg);
  limg.setBounds(-15,-43,this.getWidth(),this.getHeight());

    cmbDuplexName.addItemListener(this);
   	btnNew.addActionListener(this);
   	btnSave.addActionListener(this);
   	btnSearch.addActionListener(this);
   	btnEdit.addActionListener(this);
   	btnCancel.addActionListener(this);
    txtBuiltUpArea.addFocusListener(this);
    txtMaintainance.addFocusListener(this);
    txtPrice.addFocusListener(this);
   }

public void itemStateChanged(ItemEvent ie)
{
    if(ie.getSource()==cmbDuplexName && tflg==1)
    {
      try
      {
        int ctr=1;
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
        Statement st=con.createStatement();
        String str="select * from duplextbl where duplex_name='"+cmbDuplexName.getSelectedItem()+"'";
        ResultSet res=st.executeQuery(str);
        while(res.next())
        {
         ctr++;
        }
      txtDuplexNo.setText(cmbDuplexName.getSelectedItem()+"/"+ctr);
      }
     catch(Exception ee)
        {
           System.out.println(ee);
        }
     }
 }
 public void focusGained(FocusEvent fe)
   {
   }
 public void focusLost(FocusEvent fe)
   {
    if(fe.getSource()==txtBuiltUpArea)
         {
          int ctr0=0;
          String s=txtBuiltUpArea.getText();
          if(s.equals(""))
          {
          }
          else
          {
          for( int i=0;i<s.length();i++)
            {
              if(s.charAt(i)>='0' && s.charAt(i)<='9')
                {
                  ctr0++;
                }
              else
                {         
                   JOptionPane.showMessageDialog(null,"Enter Correct BuiltUp Area");
                   txtBuiltUpArea.setText("");
                   break;
                }                      
            }
          }
          } 

      if(fe.getSource()==txtPrice)
         {
          int ctr1=0;
          String s1=txtPrice.getText();
          if(s1.equals(""))
          {
          }
          else
          {
          for( int i=0;i<s1.length();i++)
             {
                if(s1.charAt(i)>='0' && s1.charAt(i)<='9')
                {
                  ctr1++;
                }
                else
                {         
                   JOptionPane.showMessageDialog(null,"Enter Correct Price");
                   txtPrice.setText("");
                   break;
                }                   
              }
          }
         }
      if(fe.getSource()==txtMaintainance)
         {
          int ctr2=0;
          String s2=txtMaintainance.getText();
          if(s2.equals(""))
          {
          }
          else
          {
             for( int i=0;i<s2.length();i++)
                {
                  if(s2.charAt(i)>='0' && s2.charAt(i)<='9')
                   {
                     ctr2++;
                   }
                  else
                  {
                   JOptionPane.showMessageDialog(null,"Enter Correct Maintainance cost");
                   txtMaintainance.setText("");
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
      tflg=1;
      txtDuplexNo.setEnabled(false);
      btnSave.setEnabled(true);
      btnEdit.setEnabled(false);
      btnSearch.setEnabled(true);
      txtDuplexNo.setText("");
      txtBuiltUpArea.setText("");
      txtMaintainance.setText("");
      txtPrice.setText("");
      txtAvailable.setText("Available");

      cmbDuplexName.setSelectedIndex(0);
    }

   if(e.getSource()==btnSave)
   {
     try
     {
      tflg=1;
      txtDuplexNo.setEnabled(false);
      btnNew.setEnabled(true);
      btnEdit.setEnabled(false);
      btnSearch.setEnabled(true);
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
      String str="insert into duplextbl(duplex_no,duplex_name,duplex_builtup,duplex_maintain,duplex_price,duplex_status)values(?,?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(str);
      ps.setString(1,(txtDuplexNo.getText()));
      ps.setString(3,(txtBuiltUpArea.getText()));
      ps.setString(4,(txtMaintainance.getText()));
      ps.setString(5,(txtPrice.getText()));
      ps.setString(6,(txtAvailable.getText()));
     
      ps.setString(2,(""+cmbDuplexName.getSelectedItem()));

      ps.executeUpdate();
      JOptionPane.showMessageDialog(null,"Record saved");
     }
     catch(Exception ee)
     {
      System.out.println(ee);
     }
   }
   if(e.getSource()==btnSearch)
   {
    try
      {
        tflg=0;
        btnSave.setEnabled(false);
        btnNew.setEnabled(true);
        btnEdit.setEnabled(true);
        txtDuplexNo.setEnabled(false);
        int flag=0;
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
        Statement st=con.createStatement();
        String stt=JOptionPane.showInputDialog(null,"Enter Duplex No");
        txtDuplexNo.setText(stt);
        String str="select * from duplextbl where duplex_no='"+stt+"'";
        ResultSet res=st.executeQuery(str);
        while(res.next())
        {
          flag=1;
          txtBuiltUpArea.setText(res.getString(3));
          txtMaintainance.setText(res.getString(4));
          txtPrice.setText(res.getString(5));
          txtAvailable.setText(res.getString(6));
          
          cmbDuplexName.setSelectedItem(res.getString(2));
        }
        if(flag==0)
          JOptionPane.showMessageDialog(null,"NO SUCH RECORD");
      }
      catch(Exception ce)
      {
        JOptionPane.showMessageDialog(null,ce);
      }
   }
   if(e.getSource()==btnEdit)
   {
    try
      {
        tflg=0;
         btnSave.setEnabled(false);
         txtDuplexNo.setEnabled(false);
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
         Statement st=con.createStatement();
         String str="update duplextbl set duplex_name='"+cmbDuplexName.getSelectedItem()+"',duplex_builtup='"+txtBuiltUpArea.getText()+"',duplex_maintain='"+txtMaintainance.getText()+"',duplex_price='"+txtPrice.getText()+"',duplex_status='"+txtAvailable.getText()+"' where duplex_no='"+txtDuplexNo.getText()+"'";
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
   public static void main(String args[])throws IOException
   {
   	duplex obj=new duplex();
   }
}