package memberUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import bookPublisher.IBook;
import libraryMemberPublisher.ILibraryMember;
import mainMenuUI.MainMenuUI;

public class MemberUI {
	JButton buttonClientHome;
	JButton buttonAddClient;
	JButton buttonAllClients;
	JButton buttonUpdateClient;
	JButton buttonDeleteClient;
	JButton buttonSearchClient;
	
	private JFrame frame;

	private ILibraryMember clientService;
	private IBook bookService;
	
	public MemberUI(ILibraryMember clientService) {
		this.clientService = clientService;
		initialize();
	
		buttonClientHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenuUI(bookService, clientService, null);
				frame.setVisible(false);
			}
		});
		
		buttonAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddMemberUI(clientService);
				frame.setVisible(false);
			}
		});
		
		buttonAllClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new AllClientsUI(clientService);
				frame.setVisible(false);
			}
		});
		
		buttonUpdateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new UpdateClientUI(clientService);
				frame.setVisible(false);
			}
		});
		
		buttonDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new DeleteClientUI(clientService);
				frame.setVisible(false);
			}
		});
		
		buttonSearchClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new SearchClientUI(clientService);
				frame.setVisible(false);
			}
		});

	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Library Management System - Client");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		frame.setVisible(true);
		
		buttonClientHome = new JButton("Main menu");
		buttonClientHome.setBounds(10, 12, 140, 21);
		frame.getContentPane().add(buttonClientHome);
		
		buttonAddClient = new JButton("Add Client");
		buttonAddClient.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddClient);
		
		buttonAllClients = new JButton("All Clients");
		buttonAllClients.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllClients);
		
		buttonUpdateClient = new JButton("Update Client");
		buttonUpdateClient.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateClient);
		
		buttonDeleteClient = new JButton("Delete Client");
		buttonDeleteClient.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteClient);
		
		buttonSearchClient = new JButton("Search Client");
		buttonSearchClient.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchClient);
	}
}
