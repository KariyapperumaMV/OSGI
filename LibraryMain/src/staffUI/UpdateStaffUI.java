package staffUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bookPublisher.Book;
import bookPublisher.IBook;
import libraryMemberPublisher.ILibraryMember;
import libraryStaffPublisher.ILibraryStaff;
import libraryStaffPublisher.LibraryStaff;
import mainMenuUI.MainMenuUI;

public class UpdateStaffUI {
	
	JButton buttonStaffHome;
	JButton buttonAddStaff;
	JButton buttonAllStaff;
	JButton buttonUpdateStaff;
	JButton buttonDeleteStaff;
	JButton buttonSearchStaff;
	
	private JFrame frame;
	private JLabel labelUpdateStaff;
	private JLabel labelUpdateStaffNIC;
	private JTextField textFieldUpdateStaffNIC;
	private JLabel labelUpdateStaffName;
	private JTextField textFieldUpdateStaffName;
	private JLabel labelUpdateStaffPhoneNo;
	private JTextField textFieldUpdateStaffPhoneNo;
	private JLabel labelUpdateStaffType;
	private JTextField textFieldUpdateStaffType;
	private JButton buttonUpdate;
	
	private IBook bookService;
	private ILibraryMember clientService;
	private ILibraryStaff staffService;
	
	public UpdateStaffUI(ILibraryStaff staffService) {
		this.staffService = staffService;
		
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
				new SearchStaffUI(staffService);
				frame.setVisible(false);
			}
		});
	}
	
	private void initialize() {
		//create frame
				frame = new JFrame();
				frame.setBounds(100, 100, 550, 450);
				frame.setTitle("Library Management System - Staff Member");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				
				//Create Menu
				buttonStaffHome = new JButton("Main menu");
				buttonStaffHome.setBounds(10, 12, 140, 21);
				frame.getContentPane().add(buttonStaffHome);
				
				buttonAddStaff = new JButton("Update Staff");
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
				labelUpdateStaff = new JLabel("Update Staff member");
				labelUpdateStaff.setFont(new Font("Tahoma", Font.PLAIN, 13));
				labelUpdateStaff.setBounds(248, 16, 124, 17);
				frame.getContentPane().add(labelUpdateStaff);
				
				//Staff NIC label
				labelUpdateStaffNIC = new JLabel("NIC");
				labelUpdateStaffNIC.setBounds(198, 59, 96, 13);
				frame.getContentPane().add(labelUpdateStaffNIC);
				
				//Staff NIC text
				textFieldUpdateStaffNIC = new JTextField();
				textFieldUpdateStaffNIC.setBounds(304, 56, 122, 19);
				frame.getContentPane().add(textFieldUpdateStaffNIC);
				textFieldUpdateStaffNIC.setColumns(10);
				
				//Staff Name label
				labelUpdateStaffName = new JLabel("Name");
				labelUpdateStaffName.setBounds(198, 102, 96, 13);
				frame.getContentPane().add(labelUpdateStaffName);
				
				//staff Name text
				textFieldUpdateStaffName = new JTextField();
				textFieldUpdateStaffName.setBounds(304, 99, 122, 19);
				frame.getContentPane().add(textFieldUpdateStaffName);
				textFieldUpdateStaffName.setColumns(10);
				
				//staff phone no label
				labelUpdateStaffPhoneNo = new JLabel("Phone No");
				labelUpdateStaffPhoneNo.setBounds(198, 148, 81, 13);//
				frame.getContentPane().add(labelUpdateStaffPhoneNo);
				
				//staff phone No text
				textFieldUpdateStaffPhoneNo = new JTextField();
				textFieldUpdateStaffPhoneNo.setBounds(304, 145, 122, 19);
				frame.getContentPane().add(textFieldUpdateStaffPhoneNo);
				textFieldUpdateStaffPhoneNo.setColumns(10);
				
				//staff type label
				labelUpdateStaffType = new JLabel("Phone No");
				labelUpdateStaffType.setBounds(198, 192, 81, 13);
				frame.getContentPane().add(labelUpdateStaffType);
				
				//staff type text
				textFieldUpdateStaffType = new JTextField();
				textFieldUpdateStaffType.setBounds(304, 189, 122, 19);
				frame.getContentPane().add(textFieldUpdateStaffType);
				textFieldUpdateStaffType.setColumns(10);
				
				//Update Book Button
				buttonUpdate = new JButton("Update");
				buttonUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//Declare Variables
						String id, bookName, author, bookType;
						
						//Get Values from Text Fields
						id = textFieldUpdateStaffNIC.getText().trim();
						bookName = textFieldUpdateStaffName.getText().trim();
						author = textFieldUpdateStaffPhoneNo.getText().trim();
						bookType = textFieldUpdateStaffType.getText().trim();
						
						//validation
						if(id.isEmpty()) {
							JOptionPane.showMessageDialog( frame, "Please Enter Book ID","Error",JOptionPane.WARNING_MESSAGE);
							
						} else if(bookName.isEmpty()) {
							JOptionPane.showMessageDialog( frame, "Please Enter Book Name","Error",JOptionPane.WARNING_MESSAGE);
							
						} else if(author.isEmpty()) {
							JOptionPane.showMessageDialog( frame, "Please Enter Author","Error",JOptionPane.WARNING_MESSAGE);
							
						} else if(bookType.isEmpty()) {
							JOptionPane.showMessageDialog( frame, "Please Enter Book Type","Error",JOptionPane.WARNING_MESSAGE);
							
						} else {
							try {
								Book book = new Book(id, bookName, author, bookType);
								boolean isBook = bookService.updateBook(id, book);
								
								if(isBook) {
									//Set Text Fields to Null for Next Addition
									textFieldUpdateStaffNIC.setText("");
									textFieldUpdateStaffName.setText("");
									textFieldUpdateStaffPhoneNo.setText("");
									textFieldUpdateStaffType.setText("");;
									
									//Success Message
									JOptionPane.showMessageDialog( frame, "Book Updated Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
									
								} else {
									//unsuccess message
									JOptionPane.showMessageDialog( frame, "Cannot Update Book","Error",JOptionPane.WARNING_MESSAGE);
									}
								
							}catch (Exception ex) {
								JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);					
							}
						}
					}
				});

			buttonUpdate.setBounds(266, 266, 85, 21);
			frame.getContentPane().add(buttonUpdate);
			
			//Find Button
			JButton buttonUpdateFind = new JButton("Find");
			buttonUpdateFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Get ID from Search Bar
					String nic = textFieldUpdateStaffNIC.getText().trim();
					
					//Validation
					if(nic.isEmpty()) {
						JOptionPane.showMessageDialog( frame, "Please Enter Staff NIC","Error",JOptionPane.WARNING_MESSAGE);
					}
					else {
						try {
							LibraryStaff staff = staffService.libraryStaffGetByNIC(nic);
							if(staff != null) {
								//Set Values
								textFieldUpdateStaffName.setText(staff.getName());
								textFieldUpdateStaffPhoneNo.setText(staff.getPhoneNo());
								textFieldUpdateStaffType.setText(staff.getType());
								
							} else {
								JOptionPane.showMessageDialog( frame, "Cannot Find Staff Member","Error",JOptionPane.WARNING_MESSAGE);
							}
						} 
						catch (Exception ex) {
							JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			});
			
			buttonUpdateFind.setBounds(430, 55, 64, 21);
			frame.getContentPane().add(buttonUpdateFind);
	}
	
}
