
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JTextField username;
    JPasswordField password;
    JButton b1,b2;

    Login(){

        super("Login");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
 
        username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        password=new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150);
        add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(600,350);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
        try{
          conn c = new conn();
             String user = username.getText();

            String pass = password.getText();
            
            String q = "select * from login where username=' "+user+" ' and password=' "+pass+" ' ";
            
            ResultSet rs = c.s.executeQuery(q); 
                                if(rs.next()){ 
                setVisible(false);
                new Dashboard();
                
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
    public static void main(String[] arg){
        new Login();
    }
}
