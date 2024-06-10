import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class flat extends JFrame implements ActionListener,FocusListener
{
    int tflag=1;

    JTextField txtFlatNo=new JTextField();
    JTextField txtBuiltUpArea=new JTextField();
    JTextField txtMaintainance=new JTextField();
    JTextField txtPrice=new JTextField();
    JTextField txtAvailable=new JTextField("Available");

    JButton btnNew=new JButton("");
    JButton btnSave=new JButton("");
    JButton btnSearch=new JButton("");
    JButton btnEdit=new JButton("");
    JButton btnCancel=new JButton("");

    JLabel limg=new JLabel(new ImageIcon("C:/Users/rahul/Desktop/project/design/flat.png"));

    String[] floor ={"Select","0","1","2","3","4","5","6"};
    String[] bname ={"select","Ruby","Emerald","Sapphire","Diamond"};
    JComboBox cmbFlatFloor=new JComboBox(floor);
    JComboBox cmbBuilding=new JComboBox(bname);

    public flat()
    {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setUndecorated(true);
        setVisible(true);
        setSize(2490,1490);
        //setResizable(false);
        setLocationRelativeTo(null);
        //txtFlatNo.setEditable(false);
        txtAvailable.setEditable(false);

        txtFlatNo.setFont(new Font("Georgia",Font.BOLD,25));
        txtBuiltUpArea.setFont(new Font("Georgia",Font.BOLD,25));
        txtMaintainance.setFont(new Font("Georgia",Font.BOLD,25));
        txtPrice.setFont(new Font("Georgia",Font.BOLD,25));
        txtAvailable.setFont(new Font("Georgia",Font.BOLD,25));

        btnNew.setFont(new Font("Georgia",Font.BOLD,30));
        btnSave.setFont(new Font("Georgia",Font.BOLD,30));
        btnSearch.setFont(new Font("Georgia",Font.BOLD,30));
        btnEdit.setFont(new Font("Georgia",Font.BOLD,30));
        btnCancel.setFont(new Font("Georgia",Font.BOLD,30));

        cmbFlatFloor.setFont(new Font("Georgia",Font.BOLD,25));
        cmbBuilding.setFont(new Font("Georgia",Font.BOLD,25));

        txtFlatNo.setBorder(null);
        txtBuiltUpArea.setBorder(null);
        txtMaintainance.setBorder(null);
        txtPrice.setBorder(null);
        txtAvailable.setBorder(null);

        txtFlatNo.setOpaque(false);
       // txtBuiltUpArea.setOpaque(false);
        txtMaintainance.setOpaque(false);
        txtPrice.setOpaque(false);
        txtAvailable.setOpaque(false);

        btnNew.setContentAreaFilled(false);
        //btnNew.setBorder(null);
        btnSave.setContentAreaFilled(false);
        btnSearch.setContentAreaFilled(false);
        btnEdit.setContentAreaFilled(false);
        btnCancel.setContentAreaFilled(false);

        txtFlatNo.setBounds(573,193,550,26);
        txtBuiltUpArea.setBounds(573,351,550,26);
        txtMaintainance.setBounds(573,404,550,26);
        txtPrice.setBounds(573,457,550,26);
        txtAvailable.setBounds(573,512,550,26);

        cmbFlatFloor.setBounds(570,245,556,30);
        cmbBuilding.setBounds(570,300,556,30);

        btnNew.setBounds(380,645,100,38);
        btnSave.setBounds(500,645,100,38);
        btnSearch.setBounds(622,645,100,38);
        btnEdit.setBounds(745,645,100,38);
        btnCancel.setBounds(1455,625,75,75);

        add(txtFlatNo);
        add(txtBuiltUpArea);
        add(txtMaintainance);
        add(txtPrice);
        add(txtAvailable);

        add(btnNew);
        add(btnSave);
        add(btnSearch);
        add(btnEdit);
        add(btnCancel);

        add(cmbFlatFloor);
        add(cmbBuilding);

        add(limg);
        limg.setBounds(-15,-43,this.getWidth(),this.getHeight());

        btnNew.addActionListener(this);
        btnSave.addActionListener(this);
        btnSearch.addActionListener(this);
        btnEdit.addActionListener(this);
        btnCancel.addActionListener(this);
        txtBuiltUpArea.addFocusListener(this);
        txtMaintainance.addFocusListener(this);
        txtPrice.addFocusListener(this);
    }
    public void focusGained(FocusEvent fe)
    {
        if(fe.getSource()==txtBuiltUpArea && tflag==1)
        {
            try
            {
                int ctr=1;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str="select * from flattbl";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    if(res.getString(1).startsWith(""+cmbBuilding.getSelectedItem()))
                        ctr++;
                }
                txtFlatNo.setText(""+cmbBuilding.getSelectedItem()+"/"+(""+cmbFlatFloor.getSelectedItem())+"/"+ctr);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        }

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
              /*    if(s.charAt(i)>='a' && s.charAt(i)<='z'||s.charAt(i)>='A' && s.charAt(i)<='Z')
                  {
                    cctr++;
                  }
                  else
                  {
                    cctr++;
                  }
                  }
                }
              if(ctr2<=0)
                {
                   JOptionPane.showMessageDialog(null,"Enter  Maintainance cost");
                   txtMaintainance.setText("");
                }
              if(cctr>=0)
                {         */
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
            tflag=1;
            btnSave.setEnabled(true);
            btnEdit.setEnabled(false);
            btnSearch.setEnabled(true);
            txtFlatNo.setText("");
            txtBuiltUpArea.setText("");
            txtMaintainance.setText("");
            txtPrice.setText("");
            txtAvailable.setText("Available");

            cmbFlatFloor.setSelectedIndex(0);
            cmbBuilding.setSelectedIndex(0);
        }
        if(e.getSource()==btnSave)
        {
            btnNew.setEnabled(true);
            btnEdit.setEnabled(false);
            btnSearch.setEnabled(true);
            tflag=1;
            try
            {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                String str="insert into flattbl(flat_no,flat_floor,flat_building,flat_builtup,flat_maintain,flat_price,flat_status)values(?,?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(str);
                ps.setString(1,(txtFlatNo.getText()));
                ps.setString(4,(txtBuiltUpArea.getText()));
                ps.setString(5,(txtMaintainance.getText()));
                ps.setString(6,(txtPrice.getText()));
                ps.setString(7,(txtAvailable.getText()));

                ps.setString(2,(""+cmbFlatFloor.getSelectedItem()));
                ps.setString(3,(""+cmbBuilding.getSelectedItem()));
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
            tflag=0;
            try
            {
                btnSave.setEnabled(false);
                btnNew.setEnabled(true);
                btnEdit.setEnabled(true);
                int flag=0;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String stt=JOptionPane.showInputDialog(null,"Enter flat no");
                txtFlatNo.setText(stt);
                String str="select * from flattbl where flat_no='"+stt+"'";
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    flag=1;
                    txtFlatNo.setText(res.getString(1));
                    if(tflag==0);
                    {
                        txtBuiltUpArea.setText(res.getString(4));
                    }
                    txtMaintainance.setText(res.getString(5));
                    txtPrice.setText(res.getString(6));
                    txtAvailable.setText(res.getString(7));

                    cmbFlatFloor.setSelectedItem(res.getString(2));
                    cmbBuilding.setSelectedItem(res.getString(3));
                }
                if(flag==0)
                {
                    JOptionPane.showMessageDialog(null,"NO SUCH RECORD");
                    btnEdit.setEnabled(false);
                }
            }
            catch(Exception ee)
            {
                JOptionPane.showMessageDialog(null,ee);
            }
        }
        if(e.getSource()==btnEdit)
        {
            tflag=0;
            btnSave.setEnabled(false);
            try
            {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                Statement st=con.createStatement();
                String str="update flattbl set flat_floor='"+cmbFlatFloor.getSelectedItem()+"',flat_Building='"+cmbBuilding.getSelectedItem()+"',flat_builtup='"+txtBuiltUpArea.getText()+"',flat_maintain='"+txtMaintainance.getText()+"',flat_price='"+txtPrice.getText()+"',flat_status='"+txtAvailable.getText()+"' where flat_no='"+txtFlatNo.getText()+"'";
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
            //System.exit(0);
        }
    }
    public static void main(String[] args)throws IndexOutOfBoundsException
    {
        flat obj=new flat();
    }
}