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
    
	private String databaseLogin;
	private String databasePassword;

        public void setDatabaseLogin( String login ){
            databaseLogin = login;
        }
        
        public void setDatabasePassword( String password ){
            databasePassword = password;
        }
        
        
        public String getDatabaseLogin() {
		return databaseLogin;
	}
        
        public String getDatabasePassword() {
		return databasePassword;
	}
        
}
