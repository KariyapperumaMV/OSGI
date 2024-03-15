package bookPublisher;

import java.util.ArrayList;

public interface IBook {
	
	//methods
	public boolean addBook(Book book);
	public boolean updateBook(String id, Book book);
	public boolean deleteBook(String id);
	public Book bookGetById(String id);
	public ArrayList<Book> getAllBooks();
}
