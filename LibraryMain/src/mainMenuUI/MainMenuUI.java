package mainMenuUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import authenticationPublisher.AuthenticationInterface;
import authenticationUI.AuthenticationUI;
import bookPublisher.IBook;
import bookUI.BookUI;
import libraryMemberPublisher.ILibraryMember;
import libraryStaffPublisher.ILibraryStaff;
import memberUI.MemberUI;
import staffUI.StaffUI;

public class MainMenuUI extends JFrame{
	
	private JPanel contentPane;
	private JButton buttonBook;
	private JButton buttonClient;
	private JButton buttonStaff;
	private JButton buttonLogout;
	
	private IBook bookService;
	private ILibraryMember clientService;
	private ILibraryStaff staffService;
	private AuthenticationInterface authenticationService;
	

	public MainMenuUI(IBook bookService, ILibraryMember clientService, ILibraryStaff staffService) {
		this.bookService = bookService;
		this.clientService = clientService;
		this.staffService = staffService;
		
		Initial();
	}
	
	public void Initial() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 524, 340);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		//Button Book
		buttonBook = new JButton("Book");
		buttonBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new BookUI(bookService);
			}
		});
	
		buttonBook.setBounds(221, 53, 89, 23);
		menuPanel.add(buttonBook);
		
		//Button Library Client
		buttonClient = new JButton("Library Client");
		buttonClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MemberUI(clientService);
			}
		});
	
		buttonClient.setBounds(221, 86, 120, 23);
		menuPanel.add(buttonClient);
		
		//button staff
		buttonStaff = new JButton("Library Staff");
		buttonStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new StaffUI(staffService);
			}
		});
	
		buttonStaff.setBounds(221, 121, 151, 23);
		menuPanel.add(buttonStaff);
		
		//logout button
		buttonLogout = new JButton("Log Out");
		buttonLogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				JOptionPane.showMessageDialog( contentPane, "You Logged out!!","Log out",JOptionPane.PLAIN_MESSAGE);
				
				new AuthenticationUI(authenticationService);
			}
		});
	
		buttonLogout.setBounds(221, 207, 182, 23);
		menuPanel.add(buttonLogout);
	}

}
