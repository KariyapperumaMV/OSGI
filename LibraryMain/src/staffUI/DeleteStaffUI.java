package staffUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bookPublisher.IBook;
import libraryMemberPublisher.ILibraryMember;
import libraryStaffPublisher.ILibraryStaff;
import libraryStaffPublisher.LibraryStaff;
import mainMenuUI.MainMenuUI;

public class DeleteStaffUI {
	
	JButton buttonStaffHome;
	JButton buttonAddStaff;
	JButton buttonAllStaff;
	JButton buttonUpdateStaff;
	JButton buttonDeleteStaff;
	JButton buttonSearchStaff;
	
	private JFrame frame;
	private JLabel labelDeleteStaff;
	private JLabel labelDelete;
	private JTextField textFieldDelete;
	private JButton buttonSearch;
	private JTextArea textAreaDelete;
	private JButton buttonDelete;

	private IBook bookService;
	private ILibraryMember clientService;
	private ILibraryStaff staffService;
	
	public DeleteStaffUI(ILibraryStaff staffService) {
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
		
		//delete section
		//title
		
		labelDeleteStaff = new JLabel("Delete Book");
		labelDeleteStaff.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDeleteStaff.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelDeleteStaff);
		
		//staff Delete Button
		buttonDelete = new JButton("Delete");
		frame.getContentPane().add(buttonDelete);
		
		//staff Delete nic label
		labelDelete = new JLabel("Staff NICs");
		labelDelete.setBounds(180, 45, 100, 13);
		frame.getContentPane().add(labelDelete);
		
		//staff Delete nic text
		textFieldDelete = new JTextField();
		textFieldDelete.setBounds(278, 43, 96, 19);
		frame.getContentPane().add(textFieldDelete);
		textFieldDelete.setColumns(10);
		
		//Search staff Button
		buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get nic Value
				String nic = textFieldDelete.getText().trim();
				
				//validation
				if(nic.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Staff NIC Number","Error",JOptionPane.WARNING_MESSAGE);
					
				} else {
					try {	
						LibraryStaff staff = staffService.libraryStaffGetByNIC(nic);
						
						if(staff != null) {
							
							//staff Details
							textAreaDelete.setText("Staff NIC : " + staff.getNIC()  +
									"\nStaff Name : " + staff.getName() +
									"\nPhone No : " + staff.getPhoneNo() +
									"\nStaff Type : " + staff.getType() + "\n");
							
						} else {
							textAreaDelete.setText("\n\nSorry, But Nothing Matched Your Search./n Please Try Again With Different \nNIC.");
							JOptionPane.showMessageDialog( frame, "Cannot Find Staff Member","Error",JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception ex) {
						textAreaDelete.setText("Something Went Wrong");
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
					}				
				}
			}	
		});
		
		buttonSearch.setBounds(384, 43, 75, 21);
		frame.getContentPane().add(buttonSearch);
		
		textAreaDelete = new JTextArea();
		textAreaDelete.setBounds(180, 70, 279, 126);
		frame.getContentPane().add(textAreaDelete);
		
		//Delete Button
		buttonDelete = new JButton("Delete Book");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID Number
				String id = textFieldDelete.getText().trim();
				
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Staff NIC","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						boolean isEmployee = bookService.deleteBook(id);
						if(isEmployee) {
							textFieldDelete.setText("");
							//Success Message
							textAreaDelete.setText("\n\nStaff Member Deleted Sucessfully");
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Staff member Deleted Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						} else {
							textAreaDelete.setText("\n\nCannot Delete Book");
							JOptionPane.showMessageDialog( frame, "Cannot Delete Staff Member","Error",JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception ex) {
						textAreaDelete.setText("\n\nSomething Went Wrong..!");
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		
		buttonDelete.setBounds(274, 219, 152, 21);
		frame.getContentPane().add(buttonDelete);
	}
}
