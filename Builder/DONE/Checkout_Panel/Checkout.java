import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Checkout
{
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author, book_quantity;
	String purchase_Quantity, applied_Voucher;
	int quantity;
	// String voucher;
	
	Color very_light_Blue = new Color(225,246,255);
	Color dark = new Color(0,159,148);

public Checkout()
{
//frame
	JFrame fr = new JFrame("Checkout-(Afif)");
    fr.setBounds(220,110,1000,600);
	fr.setLayout(null);
	Image fr_icon = Toolkit.getDefaultToolkit().getImage("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Logo.png");    
	fr.setIconImage(fr_icon);
	fr.setResizable(false);
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	/* fr.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						File folder = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Classes");
						File fList[] = folder.listFiles();

						for (File f : fList) {
							if (f.getName().endsWith(".class")) {
								f.delete(); 
							}
						}
						
						fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					}else{
						fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		); */
						fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
//Gtting The Book ID
	String runtxt="";

		try{
			File running_user_File = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Running_Book.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				runtxt=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f)		{System.out.println("Running txt problem");}
		
//Getting Quantity and the Voucher Code
		
		try{
			File running_user_File = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Quantity___Voucher.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				purchase_Quantity=scanFile.next();
				applied_Voucher=scanFile.next();
				break;
			}
			scanFile.close();
			
			quantity= Integer.parseInt(purchase_Quantity);
			
		}catch(Exception f)		{System.out.println("Running txt problem");}
		
//Getting Book Info

	String User_Information_File_Path="D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Book Information\\Book-"+runtxt+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
						
				while(scanFile.hasNext()){
					book_Id=scanFile.next();
					book_Price=scanFile.next();
					book_name=scanFile.next();
					book_category=scanFile.next();
					book_path=scanFile.next();
					book_author=scanFile.next()+" "+scanFile.next();
					book_quantity=scanFile.next();
					break;
				}
				scanFile.close();
			}catch(Exception f)		{System.out.println("Book Info file problem");}
	
//backbutton
		JButton d1 =new JButton(new ImageIcon());  
        d1.setBounds(22,520,42,30); 
		d1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		d1.setContentAreaFilled(false);
		d1.setFocusPainted(false);
		d1.setBorderPainted(false);  
        fr.add(d1);	
	
//Back Home Button
		JButton back_to_home =new JButton(new ImageIcon());  
        back_to_home.setBounds(18,15,40,30); 
		back_to_home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back_to_home.setContentAreaFilled(false);
		back_to_home.setFocusPainted(false);
		back_to_home.setBorderPainted(false);
        fr.add(back_to_home);	
	
		double bookPrice=Double.parseDouble(book_Price);
//bookname label	
	    JLabel bookname_label = new JLabel(book_name);//Book Name
		bookname_label.setBounds(130,420,260,50);
		bookname_label.setFont(new Font ("Arial", Font.BOLD,35));
		fr.add(bookname_label);
		
//by label		
		JLabel author_label = new JLabel("by");
		author_label.setBounds(144,472,20,30);
		author_label.setFont(new Font ("Arial", Font.PLAIN,12));
		fr.add(author_label);
		
		JLabel author2_label = new JLabel(book_author);//Author Name
		author2_label.setBounds(160,470,150,30);
		author2_label.setFont(new Font ("Arial", Font.BOLD,16));
		fr.add(author2_label);
		
//Book_Price
	    JLabel Book_Price_label = new JLabel(book_Price);//Book Price//
		Book_Price_label.setBounds(855,209,100,30);
		Book_Price_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Book_Price_label);
				
//Order_Quantity
	    JLabel Order_Quantity_label = new JLabel(purchase_Quantity);//Order_Quantity//
		Order_Quantity_label.setBounds(855,247,100,30);
		Order_Quantity_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Order_Quantity_label);
		
//Subtotal
		double subtotal=bookPrice*quantity;
		
	    JLabel Subtotal_label = new JLabel(""+subtotal);//Subtotal_label//
		Subtotal_label.setBounds(855,283,100,30);
		Subtotal_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Subtotal_label);
		
//Discount		
		double discount;
		
		if(applied_Voucher.equals("BEVOID10")){
			discount=subtotal*0.10;
		}else{
			discount=0.0;
		}
		
		
		JLabel Discount_label = new JLabel(""+discount);//Discount
		Discount_label.setBounds(855,320,100,30);
		Discount_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Discount_label);
		
//Shipping		
		double totalWithDiscount=subtotal-discount;
		double shippingFee=50.00;
		
		JLabel Shipping_label = new JLabel(""+shippingFee);//Shipping
		Shipping_label.setBounds(855,357,100,30);
		Shipping_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Shipping_label);

//Total
		double total=totalWithDiscount+shippingFee;
		
	    JLabel Total_label = new JLabel(""+total);//total
		Total_label.setBounds(855,393,100,30);
		Total_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Total_label);
//photo
		JLabel image_label = new JLabel(new ImageIcon(book_path));
		image_label.setBounds(144,146,179,265);
		fr.add(image_label);
		
		
//Checkout button
		JButton buy_Button = new JButton("Checkout");
		buy_Button.setBounds(705,468,150,30);
		buy_Button.setFont(new Font ("Arial", Font.BOLD,14));
		buy_Button.setFocusPainted(false);
		buy_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buy_Button.setForeground(dark);
		buy_Button.setBackground(Color.WHITE);
		fr.add(buy_Button);
		
		
		buy_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				buy_Button.setBackground(very_light_Blue);
				buy_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				buy_Button.setForeground(dark);
				buy_Button.setBackground(Color.WHITE);
			}
		});
//Address
		JTextArea address_field = new JTextArea();
		address_field.setBounds(650,101,260,90);
		new TextPrompt("Enter Your Address Here",address_field);
		fr.add(address_field);
		
		
		ImageIcon Username_Background = new ImageIcon("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\checkout---Copy.jpg");
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		fr.add(bg_label);
		
		
		
		
		
		
		
		
////////////////////////////////////////////////////////////////Action Listeners///////////////////////////////////////////////////
		d1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				/* fr.setVisible(false);
				new Details_Panel(); */
				
			}
		});
		
		back_to_home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				/* fr.setVisible(false);
				new Home(); */
				
			}
		});
		
		buy_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String address=address_field.getText();
				
				if( address_field.getText().isEmpty() ){
					JOptionPane.showMessageDialog(null, "Address can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else{
					try{
						Formatter formatter=new Formatter("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Order_Pre_Info.txt");
						
						formatter.format("%s\r\n", book_Price);
						formatter.format("%s\r\n", purchase_Quantity);
						formatter.format("%s\r\n", ""+subtotal);
						formatter.format("%s\r\n", ""+discount);
						formatter.format("%s\r\n", ""+shippingFee);
						formatter.format("%s\r\n", ""+total);
						
						
						
						formatter.close();	
					}catch(Exception f)		{System.out.println("problem while writting pre info of order");}
				}
				/* fr.setVisible(false);
				new dfasdfasdfasdfadsfasdfasdfasfsdfasdfasdfasdfasdfasdfasdfas(); */
				
			}
		});
		
		
fr.setVisible(true);
}
}