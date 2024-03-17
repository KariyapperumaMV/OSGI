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

public class DeleteBookUI {
	
	JButton buttonBookHome;
	JButton buttonAddBook;
	JButton buttonAllBooks;
	JButton buttonUpdateBook;
	JButton buttonDeleteBook;
	JButton buttonSearchBook;
	
	private JFrame frame;
	private JLabel labelDeleteBook;
	private JLabel labelDelete;
	private JTextField textFieldDelete;
	private JButton buttonSearch;
	private JTextArea textAreaDelete;
	private JButton buttonDelete;
	
	//Declare Book interface
	private IBook bookService;
	
	public DeleteBookUI(IBook bookService) {
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
		
	//Delete Section
		//title
		labelDeleteBook = new JLabel("Delete Book");
		labelDeleteBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDeleteBook.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelDeleteBook);
		
		//Book Delete Button
		buttonDelete = new JButton("Delete");
		frame.getContentPane().add(buttonDelete);
		
		//Book Delete Id label
		labelDelete = new JLabel("Book ID");
		labelDelete.setBounds(180, 45, 100, 13);
		frame.getContentPane().add(labelDelete);
		
		//Book Delete Id text
		textFieldDelete = new JTextField();
		textFieldDelete.setBounds(278, 43, 96, 19);
		frame.getContentPane().add(textFieldDelete);
		textFieldDelete.setColumns(10);
		
		//Search Book Button
		buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID Value
				String id = textFieldDelete.getText().trim();
				
				//validation
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Book ID Number","Error",JOptionPane.WARNING_MESSAGE);
					
				} else {
					try {	
						Book book = bookService.bookGetById(id);
						
						if(book != null) {
							
							//Book Details
							textAreaDelete.setText("Book ID : " + book.getId()  +
									"\nBook Name : " + book.getName() +
									"\nAuthor : " + book.getAuthor() +
									"\nBook Type : " + book.getType() + "\n");
							
						} else {
							textAreaDelete.setText("\n\nSorry, But Nothing Matched Your Search \nBook. Please Try Again With Different \nBook ID.");
							JOptionPane.showMessageDialog( frame, "Cannot Find Book","Error",JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showMessageDialog( frame, "Please Enter Employee ID Number","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						boolean isEmployee = bookService.deleteBook(id);
						if(isEmployee) {
							textFieldDelete.setText("");
							//Success Message
							textAreaDelete.setText("\n\nBook Deleted Sucessfully");
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Book Deleted Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						} else {
							textAreaDelete.setText("\n\nCannot Delete Book");
							JOptionPane.showMessageDialog( frame, "Cannot Delete Book","Error",JOptionPane.WARNING_MESSAGE);
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
