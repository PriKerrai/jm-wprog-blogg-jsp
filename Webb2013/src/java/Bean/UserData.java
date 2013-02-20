
package Bean;

/**
 * UserData Bean
 * @author Josef
 */
public class UserData {
	
	private String userID = "";
	private String username = "";
	private String password = "";
	
	public void setUserID(String newID) {
		userID = newID;
	}
	
	public void setUsername(String newName) {
		username = newName;
	}
	
	public void setPassword(String newPass) {
		password = newPass;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
}
