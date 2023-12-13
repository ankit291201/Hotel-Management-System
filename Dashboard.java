
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame{

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");
	
        setForeground(Color.CYAN);
        setLayout(null); 

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/wall3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1080,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1950, 1080); 
        add(NewLabel);
        
        JLabel Text = new JLabel("THE {AR} GROUP WELCOMES YOU");
	Text.setForeground(Color.black);
        Text.setFont(new Font("serif", Font.ITALIC, 46));
	Text.setBounds(450, 60, 1080, 85);
	NewLabel.add(Text);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu Hotel = new JMenu("HOTEL MANAGEMENT");
        Hotel.setForeground(Color.BLUE);
	menuBar.add(Hotel);
		
        JMenuItem Hotel1 = new JMenuItem("RECEPTION");
	Hotel.add(Hotel1);
		
	JMenu HotelHello = new JMenu("ADMIN");
        HotelHello.setForeground(Color.RED);
	menuBar.add(HotelHello);
        
        JMenuItem Adminhello1 = new JMenuItem("ADD EMPLOYEE");
	HotelHello.add(Adminhello1);
        
        Adminhello1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

        JMenuItem Adminhello2 = new JMenuItem("ADD ROOMS");
	HotelHello.add(Adminhello2);
        
        Adminhello2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	Hotel1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
	});
        
        
        JMenuItem Adminhello3 = new JMenuItem("ADD DRIVERS");
	HotelHello.add(Adminhello3);
        
	Adminhello3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDrivers().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
		
        setSize(1950,1090);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
