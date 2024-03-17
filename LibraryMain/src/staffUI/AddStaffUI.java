package staffUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bookPublisher.IBook;
import libraryMemberPublisher.ILibraryMember;
import libraryStaffPublisher.ILibraryStaff;
import libraryStaffPublisher.LibraryStaff;
import mainMenuUI.MainMenuUI;

public class AddStaffUI {
	
	//declare variables
	JButton buttonStaffHome;
	JButton buttonAddStaff;
	JButton buttonAllStaff;
	JButton buttonUpdateStaff;
	JButton buttonDeleteStaff;
	JButton buttonSearchStaff;
	
	private JFrame frame;
	private JLabel labelAddStaff;
	private JLabel labelStaffNIC;
	private JTextField textFieldStaffNIC;
	private JLabel labelStaffName;
	private JTextField textFieldStaffName;
	private JLabel labelStaffPhoneNo;
	private JTextField textFieldStaffPhoneNo;
	private JLabel labelStaffType;
	private JTextField textFieldStaffType;
	private JButton buttonAdd;
	
	private IBook bookService;
	private ILibraryMember clientService;
	private ILibraryStaff staffService;
	
	public AddStaffUI(ILibraryStaff staffService) {
		this.staffService = staffService;
		
		//call initialize method
		initialize();
	
		buttonStaffHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenuUI(bookService, clientService, staffService);
				frame.setVisible(false);
			}
		});
		
		buttonAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddStaffUI(staffService);
				frame.setVisible(false);
			}
		});
		
		buttonAllStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllStaffUI(staffService);
				frame.setVisible(false);
			}
		});
		
		buttonUpdateStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateStaffUI(staffService);
				frame.setVisible(false);
			}
		});
		
		buttonDeleteStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStaffUI(staffService);
				frame.setVisible(false);
			}
		});
		
		buttonSearchStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchStaffUI(bookService);
				frame.setVisible(false);
			}
		});
	}
	
	private void initialize() {
		//create frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setTitle("Library Management System - Staff Member");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		//Create Menu
		buttonStaffHome = new JButton("Main menu");
		buttonStaffHome.setBounds(10, 12, 140, 21);
		frame.getContentPane().add(buttonStaffHome);
		
		buttonAddStaff = new JButton("Add Staff");
		buttonAddStaff.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddStaff);
		
		buttonAllStaff = new JButton("All Staff");
		buttonAllStaff.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllStaff);
		
		buttonUpdateStaff = new JButton("Update Staff");
		buttonUpdateStaff.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateStaff);
		
		buttonDeleteStaff = new JButton("Delete Staff");
		buttonDeleteStaff.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteStaff);
		
		buttonSearchStaff = new JButton("Search Staff");
		buttonSearchStaff.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchStaff);
		
		//create form
		//title
		labelAddStaff = new JLabel("Add Staff member");
		labelAddStaff.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAddStaff.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelAddStaff);
		
		//Staff NIC label
		labelStaffNIC = new JLabel("NIC");
		labelStaffNIC.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(labelStaffNIC);
		
		//Staff NIC text
		textFieldStaffNIC = new JTextField();
		textFieldStaffNIC.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldStaffNIC);
		textFieldStaffNIC.setColumns(10);
		
		//Staff Name label
		labelStaffName = new JLabel("Name");
		labelStaffName.setBounds(198, 102, 96, 13);
		frame.getContentPane().add(labelStaffName);
		
		//staff Name text
		textFieldStaffName = new JTextField();
		textFieldStaffName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldStaffName);
		textFieldStaffName.setColumns(10);
		
		//staff phone no label
		labelStaffPhoneNo = new JLabel("Phone No");
		labelStaffPhoneNo.setBounds(198, 148, 81, 13);//
		frame.getContentPane().add(labelStaffPhoneNo);
		
		//staff phone No text
		textFieldStaffPhoneNo = new JTextField();
		textFieldStaffPhoneNo.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldStaffPhoneNo);
		textFieldStaffPhoneNo.setColumns(10);
		
		//staff type label
		labelStaffType = new JLabel("Phone No");
		labelStaffType.setBounds(198, 192, 81, 13);
		frame.getContentPane().add(labelStaffType);
		
		//staff type text
		textFieldStaffType = new JTextField();
		textFieldStaffType.setBounds(304, 189, 122, 19);
		frame.getContentPane().add(textFieldStaffType);
		textFieldStaffType.setColumns(10);
		
		buttonAdd = new JButton("Add Staff");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declare Variables
				String nic, staffName, phoneNo, staffType;
				
				//Get Values from Text Fields
				nic = textFieldStaffNIC.getText().trim();
				staffName = textFieldStaffName.getText().trim();
				phoneNo = textFieldStaffPhoneNo.getText().trim();
				staffType = textFieldStaffType.getText().trim();
				
				//Validations
				if(nic.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Staff NIC","Error",JOptionPane.WARNING_MESSAGE);
					
				} else if(staffName.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Staff Name","Error",JOptionPane.WARNING_MESSAGE);
					
				} else if(phoneNo.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Phone No","Error",JOptionPane.WARNING_MESSAGE);
					
				} else if(staffType.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Staff Type","Error",JOptionPane.WARNING_MESSAGE);
					
				} else {
					try {
						LibraryStaff staff = new LibraryStaff(nic, staffName, phoneNo, staffType);
						
						boolean isStaff = staffService.addLibraryStaff(staff);
						if(isStaff) {
							//Set Text Fields to Null for Next Addition
							textFieldStaffNIC.setText("");
							textFieldStaffName.setText("");
							textFieldStaffPhoneNo.setText("");
							textFieldStaffType.setText("");;
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Staff member Added Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
							
						} else {
							//unsuccess message
							JOptionPane.showMessageDialog( frame, "Cannot Add Staff member","Error",JOptionPane.WARNING_MESSAGE);
							}
					} 
					catch (Exception ex) {
						
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
						}
				}	
			}	
		});
		
		buttonAdd.setBounds(266, 266, 150, 21);
		frame.getContentPane().add(buttonAdd);
	}
	
}
