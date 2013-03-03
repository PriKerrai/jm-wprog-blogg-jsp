
package Bean;

/**
 * UserData Bean
 * @author Josef
 */
public class UserData {
	
	private int userid = 0;
	private String useralias = "";
	private String username = "";
	private String password = "";
	private String blog = "";
	
	public void setUserid(int newID) {
		userid = newID;
	}
	
	public void setUseralias(String newAlias) {
		useralias = newAlias;
	}
	
	public void setUsername(String newName) {
		username = newName;
	}
	
	public void setPassword(String newPass) {
		password = newPass;
	}
	
	public void setBlog(String newBlog) {
		blog = newBlog;
	}
	
	public int getUserid() {
		return userid;
	}
	
	public String getUseralias() {
		return useralias;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getBlog() {
		return blog;
	}
}
