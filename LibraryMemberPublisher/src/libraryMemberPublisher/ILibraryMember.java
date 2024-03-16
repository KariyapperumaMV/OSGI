package libraryMemberPublisher;

import java.util.ArrayList;

/**
 * @since 1.1
 */
public interface ILibraryMember {
	
	public boolean addLibraryClient(LibraryMember client);
	public boolean updateLibraryClient(String NIC, LibraryMember client);
	public boolean deleteLibraryClient(String NIc);
	public LibraryMember libraryClientGetByNIc(String NIc);
	public ArrayList<LibraryMember> getAllLibraryClients();
}
