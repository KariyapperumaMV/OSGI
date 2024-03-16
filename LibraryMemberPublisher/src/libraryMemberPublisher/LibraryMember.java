package libraryMemberPublisher;

import java.util.Date;

//this is model class
/**
 * @since 1.1
 */
public class LibraryMember {
	
	private String NIC;
	private String name;
	private String address;
	private String teleNo;
	//private ArrayList<Book> borrowedBooks = new ArrayList<>();
	
	/**
	 * @param nIc
	 * @param name
	 * @param dob
	 * @param teleNo
	 * @param borrowedBooks
	 */
	public LibraryMember(String NIC, String name, String address, String teleNo) {
		super();
		this.NIC = NIC;
		this.name = name;
		this.address = address;
		this.teleNo = teleNo;
	}
	
//getters and setters

	/**
	 * @return the nIc
	 */
	public String getNIC() {
		return NIC;
	}

	/**
	 * @param nIc the nIc to set
	 */
	public void setNIC(String NIC) {
		this.NIC = NIC;
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
	 * @return the dob
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String address) {
		this.address = address;
	}

	/**
	 * @return the teleNo
	 */
	public String getTeleNo() {
		return teleNo;
	}

	/**
	 * @param teleNo the teleNo to set
	 */
	public void setTeleNo(String teleNo) {
		this.teleNo = teleNo;
	}

	/**
	 * @return the borrowedBooks
	 
	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}*/

	

}
