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

public class AddBookUI {
	//Declare Objects / Elements
		JButton buttonBookHome;
		JButton buttonAddBook;
		JButton buttonAllBooks;
		JButton buttonUpdateBook;
		JButton buttonDeleteBook;
		JButton buttonSearchBook;
		
		private JFrame frame;
		private JLabel labelAddBook;
		private JLabel labelBookId;
		private JTextField textFieldBookId;
		private JLabel labelBookName;
		private JTextField textFieldBookName;
		private JLabel labelAuthor;
		private JTextField textFieldBookAuthor;
		private JLabel labelType;
		private JTextField textFieldBookType;
		private JButton buttonAdd;

		private IBook bookService;
		private ILibraryMember clientService;
		private ILibraryStaff staffService;
		
		public AddBookUI(IBook bookService) {
			
			this.bookService = bookService;
			//Called Initialize Method
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
			
			//Create Frame
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 450);
			frame.setTitle("Library Management System - Book");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setVisible(true);
			
		//Create Menu
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
			
		//Add Book Form
			//Title
			labelAddBook = new JLabel("Add Book");
			labelAddBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelAddBook.setBounds(248, 16, 124, 17);
			frame.getContentPane().add(labelAddBook);
			
			//Book ID Label
			labelBookId = new JLabel("Book ID");
			labelBookId.setBounds(198, 59, 96, 13);
			frame.getContentPane().add(labelBookId);
			
			//Book ID Text
			textFieldBookId = new JTextField();
			textFieldBookId.setBounds(304, 56, 122, 19);
			frame.getContentPane().add(textFieldBookId);
			textFieldBookId.setColumns(10);
			
			//Book Name Label
			labelBookName = new JLabel("Book Name");
			labelBookName.setBounds(198, 102, 96, 13);
			frame.getContentPane().add(labelBookName);
			
			//Book Name Text
			textFieldBookName = new JTextField();
			textFieldBookName.setBounds(304, 99, 122, 19);
			frame.getContentPane().add(textFieldBookName);
			textFieldBookName.setColumns(10);
			
			//Author Label
			labelAuthor = new JLabel("Author");
			labelAuthor.setBounds(198, 148, 81, 13);
			frame.getContentPane().add(labelAuthor);
			
			//Author Text
			textFieldBookAuthor = new JTextField();
			textFieldBookAuthor.setBounds(304, 145, 122, 19);
			frame.getContentPane().add(textFieldBookAuthor);
			textFieldBookAuthor.setColumns(10);
			
			//Type Label
			labelType = new JLabel("Type");
			labelType.setBounds(198, 192, 81, 13);
			frame.getContentPane().add(labelType);
			
			//Type Text
			textFieldBookType = new JTextField();
			textFieldBookType.setBounds(304, 189, 122, 19);
			frame.getContentPane().add(textFieldBookType);
			textFieldBookType.setColumns(10);
			
			//Add Book Submit Button
			buttonAdd = new JButton("Add Book");
			buttonAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Declare Variables
					String id, bookName, author, bookType;
					
					//Get Values from Text Fields
					id = textFieldBookId.getText().trim();
					bookName = textFieldBookName.getText().trim();
					author = textFieldBookAuthor.getText().trim();
					bookType = textFieldBookType.getText().trim();
					
					//Validations
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
							
							boolean isBook = bookService.addBook(book);
							if(isBook) {
								//Set Text Fields to Null for Next Addition
								textFieldBookId.setText("");
								textFieldBookName.setText("");
								textFieldBookAuthor.setText("");
								textFieldBookType.setText("");;
								
								//Success Message
								JOptionPane.showMessageDialog( frame, "Book Added Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
								
							} else {
								//unsuccess message
								JOptionPane.showMessageDialog( frame, "Cannot Add Book","Error",JOptionPane.WARNING_MESSAGE);
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
