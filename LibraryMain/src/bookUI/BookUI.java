package bookUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import bookPublisher.IBook;
import mainMenuUI.MainMenuUI;

public class BookUI {
	JButton buttonBookHome;
	JButton buttonAddBook;
	JButton buttonAllBooks;
	JButton buttonUpdateBook;
	JButton buttonDeleteBook;
	JButton buttonSearchBook;
	
	private JFrame frame;

	private IBook bookService;
	
	public BookUI(IBook bookService) {
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
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Library Management System - Book");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		frame.setVisible(true);
		
		buttonBookHome = new JButton("Main menu");
		buttonBookHome.setBounds(10, 12, 140, 21);
		frame.getContentPane().add(buttonBookHome);
		
		buttonAddBook = new JButton("Add Book");
		buttonAddBook.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddBook);
		
		buttonAllBooks = new JButton("All Books");
		buttonAllBooks.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllBooks);
		
		buttonUpdateBook = new JButton("Update Book");
		buttonUpdateBook.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateBook);
		
		buttonDeleteBook = new JButton("Delete Book");
		buttonDeleteBook.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteBook);
		
		buttonSearchBook = new JButton("Search Book");
		buttonSearchBook.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchBook);
	}
}
