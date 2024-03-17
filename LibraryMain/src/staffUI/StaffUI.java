package staffUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import bookPublisher.IBook;
import libraryMemberPublisher.ILibraryMember;
import libraryStaffPublisher.ILibraryStaff;
import mainMenuUI.MainMenuUI;

public class StaffUI {
	JButton buttonStaffHome;
	JButton buttonAddStaff;
	JButton buttonAllStaff;
	JButton buttonUpdateStaff;
	JButton buttonDeleteStaff;
	JButton buttonSearchStaff;
	
	private JFrame frame;
	
	private IBook bookService;
	private ILibraryMember clientService;
	private ILibraryStaff staffService;
	
	public StaffUI(ILibraryStaff staffservice) {
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Library Management System - Staff");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		frame.setVisible(true);
		
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
	}
}
