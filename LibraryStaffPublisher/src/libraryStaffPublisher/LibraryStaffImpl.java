package libraryStaffPublisher;

import java.util.ArrayList;

public class LibraryStaffImpl implements ILibraryStaff{
	
	private ArrayList<LibraryStaff> staffList = new ArrayList<LibraryStaff>();

	@Override
	public boolean addLibraryStaff(LibraryStaff staff) {
		staffList.add(staff);
		return true;
	}

	@Override
	public boolean updateLibraryStaff(String NIC, LibraryStaff staff) {
		if(staffList.isEmpty()) {
			return false; //if the list is empty
			
		}else {
			int i = -1;
			for (LibraryStaff object : staffList) {
				i = i + 1;
				if(object.getNIC().equals(NIC)) {
					staffList.set(i, new LibraryStaff (staff.getNIC(), staff.getName(), staff.getPhoneNo(), staff.getType()));
					return true;	//if the client details have successfully updated
				}
			}
			return false;	//if there is no client exists from that NIC
		}
	}

	@Override
	public boolean deleteLibraryStaff(String NIc) {
		if(staffList.isEmpty()) {
			return false; //if the list is empty
			
		}else {
			for(LibraryStaff object : staffList) {
				if(object.getNIC().equals(NIc)) {
					staffList.remove(object);
					return true;	//if the deletion is success
				}
			}
			return false;	//if there is no client exists from that NIC
		}
	}

	@Override
	public LibraryStaff libraryStaffGetByNIC(String nic) {
		if(staffList.isEmpty()) {
			return null;	//list is empty
		}else {
			for (LibraryStaff object : staffList) {
				if (object.getNIC().equals(nic)) {
					return object; 	//if the client exists
				}
			}
			return null;	//o client from that NIC
		}
		
	}

	@Override
	public ArrayList<LibraryStaff> getAllLibraryStaffs() {
		return staffList;
	}

}
