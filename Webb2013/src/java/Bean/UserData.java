
package Bean;

/**
 * UserData Bean
 * @author Josef
 */
public class UserData {
	
	private String userid = "";
	private String username = "";
	private String password = "";
	
	public void setUserid(String newID) {
		userid = newID;
	}
	
	public void setUsername(String newName) {
		username = newName;
	}
	
	public void setPassword(String newPass) {
		password = newPass;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
}
