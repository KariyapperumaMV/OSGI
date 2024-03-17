package libraryStaffPublisher;

import java.util.ArrayList;

/**
 * @since 1.1
 */
public interface ILibraryStaff {

	public boolean addLibraryStaff(LibraryStaff staff);
	public boolean updateLibraryStaff(String NIC, LibraryStaff staff);
	public boolean deleteLibraryStaff(String NIc);
	public ArrayList<LibraryStaff> getAllLibraryStaffs();
	public LibraryStaff libraryStaffGetByNIC(String nic);
}
