package bookUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bookPublisher.Book;
import bookPublisher.IBook;
import mainMenuUI.MainMenuUI;

public class SearchBookUI {

	//Declare objects
	JButton buttonBookHome;
	JButton buttonAddBook;
	JButton buttonAllBooks;
	JButton buttonUpdateBook;
	JButton buttonDeleteBook;
	JButton buttonSearchBook;
	
	private JFrame frame;
	private JLabel labelSearchBook;
	private JLabel labelEnterBookId;
	private JTextField textFieldSearch;
	private JButton buttonSearch;
	private JTextArea textAreaSearchResult;
	
	//Declare Employee Interface Class
	private IBook bookService;
	
	public SearchBookUI(IBook bookService) {
		this.bookService = bookService;
		
		initialize();
		
		buttonBookHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenuUI(bookService, null, null);
				frame.setVisible(false);
			}
		});
		
		buttonAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBookUI(bookService);
				frame.setVisible(false);
			}
		});
		
		buttonAllBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllBooksUI(bookService);
				frame.setVisible(false);
			}
		});
		
		buttonUpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBookUI(bookService);
				frame.setVisible(false);
			}
		});
		
		buttonDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteBookUI(bookService);
				frame.setVisible(false);
			}
		});
		
		buttonSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBookUI(bookService);
				frame.setVisible(false);
			}
		});
	}
	
	//initialize method
	private void initialize() {
		//create frame
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 450);
		frame.setTitle("Library Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
	//create Menu
		//Home Menu Button
		buttonBookHome = new JButton("Main Menu");
		buttonBookHome.setBounds(10, 12, 140, 21);
		frame.getContentPane().add(buttonBookHome);
		
		//Add Book Menu Button
		buttonAddBook = new JButton("Add Book");
		buttonAddBook.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddBook);
		
		//All Book Menu Button
		buttonAllBooks = new JButton("All Book");
		buttonAllBooks.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllBooks);
		
		//Update Book Menu Button
		buttonUpdateBook = new JButton("Update Book");
		buttonUpdateBook.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateBook);
		
		//Delete Book Menu Button
		buttonDeleteBook = new JButton("Delete Book");
		buttonDeleteBook.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteBook);
		
		//Search Book Menu Button
		buttonSearchBook = new JButton("Search Book");
		buttonSearchBook.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchBook);
		
	//Search Section
		//title
		labelSearchBook = new JLabel("Find Book");
		labelSearchBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSearchBook.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelSearchBook);
		
		////Book Search Id label
		labelEnterBookId = new JLabel("Book ID");
		labelEnterBookId.setBounds(186, 46, 113, 13);
		frame.getContentPane().add(labelEnterBookId);
		
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
					JOptionPane.showMessageDialog( frame, "Please Enter Employee ID Number","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						Book book = bookService.bookGetById(id);
						if(book != null) {
							
							//book Details
							textAreaSearchResult.setText("Employee ID : " + book.getId() +
									"\nBook Name : " + book.getName() +
									"\nAuthor : " + book.getAuthor() +
									"\nBook Type : " + book.getType() + "\n");
						} else {
							textAreaSearchResult.setText("\n\nSorry, But Nothing Matched Your Search \nBook. Please Try Again With Different \nBook ID.");
							JOptionPane.showMessageDialog( frame, "Cannot Find Book","Error",JOptionPane.WARNING_MESSAGE);
							
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
