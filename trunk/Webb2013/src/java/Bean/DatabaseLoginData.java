/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Kerrai
 */
public class DatabaseLoginData {
    
	private String login = "";
	private String password = "";

  public void setLogin(String newLogin){
		login = newLogin;
	}
        
  public void setPassword(String newPassword){
		password = newPassword;
  }
            
  public String getLogin() {
		return login;
	}
        
  public String getPassword() {
		return password;
	}
        
}
