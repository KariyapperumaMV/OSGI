package bookUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bookPublisher.Book;
import bookPublisher.IBook;
import libraryMemberPublisher.ILibraryMember;
import libraryStaffPublisher.ILibraryStaff;
import mainMenuUI.MainMenuUI;

public class UpdateBookUI {
	
	JButton buttonBookHome;
	JButton buttonAddBook;
	JButton buttonAllBooks;
	JButton buttonUpdateBook;
	JButton buttonDeleteBook;
	JButton buttonSearchBook;
	
	private JFrame frame;
	private JLabel labelUpdateBook;
	private JLabel labelUpdateBookId;
	private JTextField textFieldUpdateBookId;
	private JLabel labelUpdateBookName;
	private JTextField textFieldUpdateBookName;
	private JLabel labelUpdateBookAuthor;
	private JTextField textFieldUpdateBookAuthor;
	private JLabel labelUpdateBookType;
	private JTextField textFieldUpdateBookType;
	
	private JButton buttonUpdate;
	
	private IBook bookService;
	private ILibraryMember clientService;
	private ILibraryStaff staffService;
	
	public UpdateBookUI(IBook bookService) {
		this.bookService = bookService;
		
		initialize();
		
		buttonBookHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenuUI(bookService, clientService, staffService);
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
	
	//Initialize Method
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
		
	//Update Book Form
		//title
		labelUpdateBook = new JLabel("Update Book");
		labelUpdateBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUpdateBook.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelUpdateBook);
		
		//Book Update ID label
		labelUpdateBookId = new JLabel("Book ID");
		labelUpdateBookId.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(labelUpdateBookId);
		
		//Employee Update ID Text
		textFieldUpdateBookId = new JTextField();
		textFieldUpdateBookId.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldUpdateBookId);
		textFieldUpdateBookId.setColumns(10);
		
		//Book Update Name label
		labelUpdateBookName = new JLabel("Name");
		labelUpdateBookName.setBounds(198, 102, 96, 13);
		frame.getContentPane().add(labelUpdateBookName);
		
		//Book Update Name text
		textFieldUpdateBookName = new JTextField();
		textFieldUpdateBookName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldUpdateBookName);
		textFieldUpdateBookName.setColumns(10);
		
		//Book Update Author label				
		labelUpdateBookAuthor = new JLabel("Author");
		labelUpdateBookAuthor.setBounds(198, 148, 81, 13);
		frame.getContentPane().add(labelUpdateBookAuthor);
		
		//Book Update Author text
		textFieldUpdateBookAuthor = new JTextField();
		textFieldUpdateBookAuthor.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldUpdateBookAuthor);
		textFieldUpdateBookAuthor.setColumns(10);
		
		//Book Update type label
		labelUpdateBookType = new JLabel("Book Type");
		labelUpdateBookType.setBounds(198, 192, 81, 13);
		frame.getContentPane().add(labelUpdateBookType);
		
		//Book Update type text
		textFieldUpdateBookType = new JTextField();
		textFieldUpdateBookType.setBounds(304, 189, 117, 19);
		frame.getContentPane().add(textFieldUpdateBookType);
		textFieldUpdateBookType.setColumns(10);
		
		//Update Book Button
		buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declare Variables
				String id, bookName, author, bookType;
				
				//Get Values from Text Fields
				id = textFieldUpdateBookId.getText().trim();
				bookName = textFieldUpdateBookName.getText().trim();
				author = textFieldUpdateBookAuthor.getText().trim();
				bookType = textFieldUpdateBookType.getText().trim();
				
				//validation
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Book ID","Error",JOptionPane.WARNING_MESSAGE);
					
				} else if(bookName.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Book Name","Error",JOptionPane.WARNING_MESSAGE);
					
				} else if(author.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Author","Error",JOptionPane.WARNING_MESSAGE);
					
				} else if(bookType.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Book Type","Error",JOptionPane.WARNING_MESSAGE);
					
				} else {
					try {
						Book book = new Book(id, bookName, author, bookType);
						boolean isBook = bookService.updateBook(id, book);
						
						if(isBook) {
							//Set Text Fields to Null for Next Addition
							textFieldUpdateBookId.setText("");
							textFieldUpdateBookName.setText("");
							textFieldUpdateBookAuthor.setText("");
							textFieldUpdateBookType.setText("");;
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Book Updated Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
							
						} else {
							//unsuccess message
							JOptionPane.showMessageDialog( frame, "Cannot Update Book","Error",JOptionPane.WARNING_MESSAGE);
							}
						
					}catch (Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);					
					}
				}
			}
		});

	buttonUpdate.setBounds(266, 266, 85, 21);
	frame.getContentPane().add(buttonUpdate);
	
	//Find Button
	JButton buttonUpdateFind = new JButton("Find");
	buttonUpdateFind.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			//Get ID from Search Bar
			String id = textFieldUpdateBookId.getText().trim();
			
			//Validation
			if(id.isEmpty()) {
				JOptionPane.showMessageDialog( frame, "Please Enter Book ID Number","Error",JOptionPane.WARNING_MESSAGE);
			}
			else {
				try {
					Book book = bookService.bookGetById(id);
					if(book != null) {
						//Set Values
						textFieldUpdateBookName.setText(book.getName());
						textFieldUpdateBookAuthor.setText(book.getAuthor());
						textFieldUpdateBookType.setText(book.getType());
						
					} else {
						JOptionPane.showMessageDialog( frame, "Cannot Find Book","Error",JOptionPane.WARNING_MESSAGE);
					}
				} 
				catch (Exception ex) {
					JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	});
	
	buttonUpdateFind.setBounds(430, 55, 64, 21);
	frame.getContentPane().add(buttonUpdateFind);
	}
}
