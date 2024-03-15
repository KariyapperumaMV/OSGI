package bookPublisher;

//this is the book model
public class Book {
	
	//Declare variables
	private String id;
	private String name;
	private String author;
	private String type;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param author
	 * @param type
	 */
	public Book(String id, String name, String author, String type) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	

}
