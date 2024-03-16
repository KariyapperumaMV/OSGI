package libraryMemberPublisher;

import java.util.ArrayList;

public class LibraryMemberImpl implements ILibraryMember{
	
	private ArrayList<LibraryMember> clientList = new ArrayList<LibraryMember>();

	@Override
	public boolean addLibraryClient(LibraryMember client) {
		clientList.add(client);
		return true;
	}

	@Override
	public boolean updateLibraryClient(String NIC, LibraryMember client) {
		
		if(clientList.isEmpty()) {
			return false; //if the list is empty
			
		}else {
			int i = -1;
			for (LibraryMember object : clientList) {
				i = i + 1;
				if(object.getNIC().equals(NIC)) {
					clientList.set(i, new LibraryMember (client.getNIC(), client.getName(), client.getAddress(), client.getTeleNo()));
					return true;	//if the client details have successfully updated
				}
			}
			return false;	//if there is no client exists from that NIC
		}
	}

	@Override
	public boolean deleteLibraryClient(String NIc) {
		if(clientList.isEmpty()) {
			return false; //if the list is empty
			
		}else {
			for(LibraryMember object : clientList) {
				if(object.getNIC().equals(NIc)) {
					clientList.remove(object);
					return true;	//if the deletion is success
				}
			}
			return false;	//if there is no client exists from that NIC
		}
	}

	@Override
	public LibraryMember libraryClientGetByNIc(String NIc) {
		
		if(clientList.isEmpty()) {
			return null;	//list is empty
		}else {
			for (LibraryMember object : clientList) {
				if (object.getNIC().equals(NIc)) {
					return object; 	//if the client exists
				}
			}
			return null;	//o client from that NIC
		}
		
	}

	@Override
	public ArrayList<LibraryMember> getAllLibraryClients() {
		return clientList;
	}

}
