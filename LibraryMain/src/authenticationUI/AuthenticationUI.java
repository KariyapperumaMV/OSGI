package authenticationUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import authenticationPublisher.AuthenticationImpl;
import authenticationPublisher.AuthenticationInterface;
import bookPublisher.BookImpl;
import bookPublisher.IBook;
import mainMenuUI.MainMenuUI;

public class AuthenticationUI extends JFrame{
	
	private JFrame frame;
	private JLabel labelLogin;
	private JLabel labelUserName;
	private JTextField textFieldUsername;
	private JLabel labelPsw;
	private JPasswordField passwordFieldPsw;
	
	private JButton buttonLogin;
	
	private AuthenticationInterface authenticationService;
	
	public AuthenticationUI(AuthenticationInterface authenticationService) {
		this.authenticationService = authenticationService;
		Initial();
	}
	
	public void Initial() {
		
		setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding to the content pane

        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labelLogin = new JLabel("LogIn");
        labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        loginPanel.add(labelLogin, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        labelUserName = new JLabel("User name:");
        loginPanel.add(labelUserName, gbc);

        gbc.gridx = 1;
        textFieldUsername = new JTextField(20);
        loginPanel.add(textFieldUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        labelPsw = new JLabel("Password:");
        loginPanel.add(labelPsw, gbc);

        gbc.gridx = 1;
        passwordFieldPsw = new JPasswordField(20);
        loginPanel.add(passwordFieldPsw, gbc);

        contentPane.add(loginPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonLogin = new JButton("LogIn");
        buttonLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
	        	//Declare Variables
				String userName, psw;
				
				//Get values from text fields
				userName = textFieldUsername.getText().trim();
				char[] pswChar = passwordFieldPsw.getPassword();
				
				//extracting string
				psw = new String(pswChar);
				
				//Validation
				if(userName.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter User Name","Error",JOptionPane.WARNING_MESSAGE);
					
				}else if(psw.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Password","Error",JOptionPane.WARNING_MESSAGE);
					
				} else{
					try {
					
						AuthenticationImpl authenticate = new AuthenticationImpl();
						
						boolean result = authenticate.Authenticate(userName, psw);
						
						if(result == true) {
							dispose();
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "LogIn Success","Success",JOptionPane.PLAIN_MESSAGE);
							
							IBook bookService = new BookImpl();
							MainMenuUI mainFrame = new MainMenuUI(bookService, null, null);
							
							//load mainFrame
							mainFrame.setVisible(true);
							
						}else {
							//clear text field inputs
							textFieldUsername.setText("");
							passwordFieldPsw.setText("");
							
							JOptionPane.showMessageDialog( frame, "Login Failed","Success",JOptionPane.PLAIN_MESSAGE);
						}
					
					
					}catch(Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
						}
				}
			}
        });
        buttonPanel.add(buttonLogin);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
        pack(); // Adjust the size of the frame to fit its contents
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }
}

