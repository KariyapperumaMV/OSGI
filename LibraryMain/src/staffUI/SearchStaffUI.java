package staffUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bookPublisher.Book;
import bookPublisher.IBook;
import libraryMemberPublisher.ILibraryMember;
import libraryStaffPublisher.ILibraryStaff;
import libraryStaffPublisher.LibraryStaff;
import mainMenuUI.MainMenuUI;

public class SearchStaffUI {

	JButton buttonStaffHome;
	JButton buttonAddStaff;
	JButton buttonAllStaff;
	JButton buttonUpdateStaff;
	JButton buttonDeleteStaff;
	JButton buttonSearchStaff;
	JScrollPane scrollPane;
	
	private JFrame frame;
	private JLabel labelSearchStaff;
	private JLabel labelEnterStaffNIC;
	private JTextField textFieldSearch;
	private JButton buttonSearch;
	private JTextArea textAreaSearchResult;
	
	private IBook bookService;
	private ILibraryMember clientService;
	private ILibraryStaff staffService;
	
	public SearchStaffUI(ILibraryStaff staffservice) {
		this.staffService = staffservice;
		
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
		
		//Create Frame
			frame = new JFrame();
			frame.setBounds(100, 100, 550, 450);
			frame.setTitle("Library Management System - Staff Member");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setVisible(true);
			
		//create Menu
			//Home Menu Button
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
	
	//Search Section
			//title
			labelSearchStaff = new JLabel("Find Staff");
			labelSearchStaff.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelSearchStaff.setBounds(248, 16, 124, 17);
			frame.getContentPane().add(labelSearchStaff);
			
			////Book Search Id label
			labelEnterStaffNIC = new JLabel("Staff NIC");
			labelEnterStaffNIC.setBounds(186, 46, 113, 13);
			frame.getContentPane().add(labelEnterStaffNIC);
			
			//Book Search Id text
			textFieldSearch = new JTextField();
			textFieldSearch.setBounds(258, 43, 96, 19);
			frame.getContentPane().add(textFieldSearch);
			textFieldSearch.setColumns(10);
			
			//Search Button
			buttonSearch = new JButton("Search");
			buttonSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Get ID for Search
					String id = textFieldSearch.getText().trim();
					
					//Validation
					if(id.isEmpty()) {
						JOptionPane.showMessageDialog( frame, "Please Enter Staff NIC","Error",JOptionPane.WARNING_MESSAGE);
					} else {
						try {
							LibraryStaff staff = staffService.libraryStaffGetByNIC(id);
							if(staff != null) {
								
								//book Details
								textAreaSearchResult.setText("Staff NIC : " + staff.getNIC() +
										"\nName : " + staff.getName() +
										"\nPhone No : " + staff.getPhoneNo() +
										"\nBook Type : " + staff.getType() + "\n");
							} else {
								textAreaSearchResult.setText("\n\nSorry, But Nothing Matched Your Search./n Please Try Again With Different NIC\n");
								JOptionPane.showMessageDialog( frame, "Cannot Find Staff Member","Error",JOptionPane.WARNING_MESSAGE);
								
							}
						} catch (Exception ex) {
							textAreaSearchResult.setText("Something Went Wrong");
							JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);	
						}
					}
				
				}
			});
			
			buttonSearch.setBounds(366, 41, 100, 21);
			frame.getContentPane().add(buttonSearch);
			
			textAreaSearchResult = new JTextArea();
			textAreaSearchResult.setBounds(186, 83, 280, 170);
			frame.getContentPane().add(textAreaSearchResult);
	}
}
