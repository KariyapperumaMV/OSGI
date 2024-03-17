package staffUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bookPublisher.Book;
import bookPublisher.IBook;
import libraryMemberPublisher.ILibraryMember;
import libraryStaffPublisher.ILibraryStaff;
import libraryStaffPublisher.LibraryStaff;
import mainMenuUI.MainMenuUI;

public class AllStaffUI {

	JButton buttonStaffHome;
	JButton buttonAddStaff;
	JButton buttonAllStaff;
	JButton buttonUpdateStaff;
	JButton buttonDeleteStaff;
	JButton buttonSearchStaff;
	JScrollPane scrollPane;
	
	private JFrame frame;
	private JLabel labelAllStaff;
	private JTable table;
	
	private IBook bookService;
	private ILibraryMember clientService;
	private ILibraryStaff staffService;
	
	public AllStaffUI(ILibraryStaff staffservice) {
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
		
		ArrayList<LibraryStaff> staff = staffService.getAllLibraryStaffs();
		
		if(!staff.isEmpty()) {
			List<Object[]> list = new ArrayList<Object[]>();
			
			for(int i= 0; i<staff.size(); i++) {
				list.add(new Object[] {staff.get(i).getNIC(), staff.get(i).getName(), staff.get(i).getPhoneNo(), staff.get(i).getType()});
			}
			
			table.setModel(new DefaultTableModel(list.toArray(new Object[][] {}), new String[] {"ID" ,"Name", "Author", "Type"}));
		}
	}
	
	private void initialize() {
		
		//Create Frame
			frame = new JFrame();
			frame.setBounds(100, 100, 750, 300);
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
			
		//title
			labelAllStaff = new JLabel("All Book");
			labelAllStaff.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelAllStaff.setBounds(375, 16, 124, 17);
			frame.getContentPane().add(labelAllStaff);
			
		//book table
			table = new JTable();
			scrollPane = new JScrollPane(table);
			scrollPane.setBounds(172, 58, 500, 184);
			frame.getContentPane().add(scrollPane);
			
		}
}
