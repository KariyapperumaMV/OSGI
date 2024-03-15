package bookPublisher;

import java.util.ArrayList;

public class BookImpl implements IBook{
	
	//Book List
	private ArrayList<Book> bookList = new ArrayList<Book>();

	//Add Book Method
	@Override
	public boolean addBook(Book book) {
		bookList.add(book);
		return true;
	}

	//Update Book Method
	@Override
	public boolean updateBook(String id, Book book) {
		
		if(bookList.isEmpty()) {
			return false;	//if the list is empty
			
		}else {
			int i = -1;
			for (Book object : bookList) {
				i = i + 1;
				if(object.getId().equals(id)) {
					bookList.set(i, new Book (book.getId(), book.getName(), book.getAuthor(), book.getType()));
					return true;	//if the book details have successfully updated
				}
			}
			return false; //if there is no book from the given id
		}
		
	}
	
	//Delete Book Method
	@Override
	public boolean deleteBook(String id) {
		if(bookList.isEmpty()) {
			return false; //if the booklist is empty
		}else {
			for(Book object : bookList) {
				if(object.getId().equals(id)) {
					bookList.remove(object);
					return true;	//if the book has deleted
				}
			}
			return false;	//if there is no book from the given id
		}
		
	}

	//Book Get By Id Method
	@Override
	public Book bookGetById(String id) {
		if(bookList.isEmpty()) {
			return null; //if the booklist is empty
		}else {
			for(Book object : bookList) {
				if(object.getId().equals(id)) {
					return object;	//if the book exists
				}
			}
			return null;	//if there is no book from the given id
		}
	}

	//Get All Book Method
	@Override
	public ArrayList<Book> getAllBooks() {
		return bookList;
	}

}
