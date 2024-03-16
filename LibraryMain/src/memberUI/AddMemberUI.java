package memberUI;

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
import libraryMemberPublisher.LibraryMember;
import mainMenuUI.MainMenuUI;

public class AddMemberUI {
	JButton buttonClientHome;
	JButton buttonAddClient;
	JButton buttonAllClients;
	JButton buttonUpdateClient;
	JButton buttonDeleteClient;
	JButton buttonSearchClient;
	
	private JFrame frame;
	private JLabel labelAddClient;
	private JLabel labelClientNIC;
	private JTextField textFieldClientNIC;
	private JLabel labelClientName;
	private JTextField textFieldClientName;
	private JLabel labelClientDob;
	private JTextField textFieldClientAddress;
	private JLabel labelClientTeleNo;
	private JTextField textFieldClientTeleNo;
	private JButton buttonAdd;

//Declare Employee Interface Class
	private ILibraryMember clientService;
	private IBook bookService;
	
	public AddMemberUI(ILibraryMember clientService) {
		
		this.clientService = clientService;
		//Called Initialize Method
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
	
	//Initialize Method
	private void initialize() {
		
		//Create Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setTitle("Library Management System - Client");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
	//Create Menu
		//Home Menu Button
		buttonClientHome = new JButton("Main Menu");
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
		
	//Add Client Form
		//Title
		labelAddClient = new JLabel("Add Client Details");
		labelAddClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAddClient.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelAddClient);
		
		//Client NIC Label
		labelClientNIC = new JLabel("NIC");
		labelClientNIC.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(labelClientNIC);
		
		//Client NIC Text
		textFieldClientNIC = new JTextField();
		textFieldClientNIC.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldClientNIC);
		textFieldClientNIC.setColumns(10);
		
		//Client Name Label
		labelClientName = new JLabel("Name");
		labelClientName.setBounds(198, 102, 96, 13);
		frame.getContentPane().add(labelClientName);
		
		//Client Name Text
		textFieldClientName = new JTextField();
		textFieldClientName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldClientName);
		textFieldClientName.setColumns(10);
		
		//Client DoB Label
		labelClientDob = new JLabel("Date of Birth");
		labelClientDob.setBounds(198, 148, 81, 13);
		frame.getContentPane().add(labelClientDob);
		
		//Client Dob Text
		textFieldClientAddress = new JTextField();
		textFieldClientAddress.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldClientAddress);
		textFieldClientAddress.setColumns(10);
		
		//Client Tele No Label
		labelClientTeleNo = new JLabel("Contact No");
		labelClientTeleNo.setBounds(198, 192, 81, 13);
		frame.getContentPane().add(labelClientTeleNo);
		
		//Client Tele No Text
		textFieldClientTeleNo = new JTextField();
		textFieldClientTeleNo.setBounds(304, 189, 122, 19);
		frame.getContentPane().add(textFieldClientTeleNo);
		textFieldClientTeleNo.setColumns(10);
		
		//Add Client Submit Button
		buttonAdd = new JButton("Add Client");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declare Variables
				String NIC, clientName,address, teleNo;
				
				//Get Values from Text Fields
				NIC = textFieldClientNIC.getText().trim();
				clientName = textFieldClientName.getText().trim();
				address = textFieldClientAddress.getText().trim();
				teleNo = textFieldClientTeleNo.getText().trim();
				
				//Validations
				if(NIC.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter NIC","Error",JOptionPane.WARNING_MESSAGE);
					
				} else if(clientName.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Name","Error",JOptionPane.WARNING_MESSAGE);
					
				} else if(address.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Adress","Error",JOptionPane.WARNING_MESSAGE);
					
				} else if(teleNo.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Telephone No Type","Error",JOptionPane.WARNING_MESSAGE);
					
				} else {
					try {
						LibraryMember client = new LibraryMember(NIC,clientName,address,teleNo);
						
						boolean isClient = clientService.addLibraryClient(client);
						if(isClient) {
							//Set Text Fields to Null for Next Addition
							textFieldClientNIC.setText("");
							textFieldClientName.setText("");
							textFieldClientAddress.setText("");
							textFieldClientTeleNo.setText("");;
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Client Added Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
							
						} else {
							//unsuccess message
							JOptionPane.showMessageDialog( frame, "Cannot Add Client","Error",JOptionPane.WARNING_MESSAGE);
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
