package bookUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bookPublisher.Book;
import bookPublisher.IBook;
import mainMenuUI.MainMenuUI;

public class AllBooksUI {
	
	//Declare Objects / Elements
	JButton buttonBookHome;
	JButton buttonAddBook;
	JButton buttonAllBooks;
	JButton buttonUpdateBook;
	JButton buttonDeleteBook;
	JButton buttonSearchBook;
	JScrollPane scrollPane;
	
	private JFrame frame;
	private JLabel labelAllBooks;
	private JTable table;
	
	//Declare Book Interface Class
	private IBook bookService;
	
	public AllBooksUI(IBook bookService) {
		this.bookService = bookService;
		
		initialize();
		
		//create employee Array List
		ArrayList<Book> books = bookService.getAllBooks();
		
		if(!books.isEmpty()) {
			List<Object[]> list = new ArrayList<Object[]>();
			
			for(int i= 0; i<books.size(); i++) {
				list.add(new Object[] {books.get(i).getId(), books.get(i).getName(), books.get(i).getAuthor(), books.get(i).getType()});
			}
			
			table.setModel(new DefaultTableModel(list.toArray(new Object[][] {}), new String[] {"ID" ,"Name", "Author", "Type"}));
		}
		
		buttonBookHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenuUI(bookService, null, null);
				frame.setVisible(false);
			}	
		});
		
		buttonAddBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBookUI(bookService);
				frame.setVisible(false);
			}
		});
		
		buttonAllBooks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AllBooksUI(bookService);
				frame.setVisible(false);
			}
		});
		
		buttonUpdateBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateBookUI(bookService);
				frame.setVisible(false);
			}
		});
		
		buttonDeleteBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteBookUI(bookService);
				frame.setVisible(false);
			}
		});
		
		buttonSearchBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchBookUI(bookService);
				frame.setVisible(false);
			}
		});
	}
	
	//initialize method
	private void initialize() {
		
	//Create Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 300);
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
		
	//title
		labelAllBooks = new JLabel("All Book");
		labelAllBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAllBooks.setBounds(375, 16, 124, 17);
		frame.getContentPane().add(labelAllBooks);
		
	//book table
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(172, 58, 500, 184);
		frame.getContentPane().add(scrollPane);
		
	}

}
