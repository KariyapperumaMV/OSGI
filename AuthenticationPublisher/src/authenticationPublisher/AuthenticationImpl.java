package authenticationPublisher;

/**
 * @since 1.1
 */
public class AuthenticationImpl implements AuthenticationInterface{
	
	private String userName = "Library";
	private String psw = "Library123";

	@Override
	public boolean Authenticate(String inputUserName, String inputPsw) {
		
		/*
		//check the inputs are true
		if((this.userName != userName)&&(this.psw != psw)){
				return false; //username and password are wrong
				
		}else if((this.userName != userName)||(this.psw != psw))
			return false; //username or password are wrong
		else
			return true; //username and password are correct
			*/
		return userName.equals(inputUserName) && psw.equals(inputPsw);
	}	
}
