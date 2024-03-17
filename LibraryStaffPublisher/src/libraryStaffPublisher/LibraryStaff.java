package libraryStaffPublisher;

/**
 * @since 1.1
 */
public class LibraryStaff {
	
	private String NIC;
	private String Name;
	private String phoneNo;
	private String type;
	/**
	 * @param nIC
	 * @param name
	 * @param address
	 * @param phoneNo
	 * @param type
	 */
	public LibraryStaff(String nIC, String name, String phoneNo, String type) {
		super();
		NIC = nIC;
		Name = name;
		this.phoneNo = phoneNo;
		this.type = type;
	}
	/**
	 * @return the nIC
	 */
	public String getNIC() {
		return NIC;
	}
	/**
	 * @param nIC the nIC to set
	 */
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
