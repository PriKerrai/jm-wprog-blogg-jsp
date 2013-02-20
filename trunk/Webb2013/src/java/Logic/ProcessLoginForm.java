
package Logic;

import Bean.UserData;
import Database.DBManager;
import Interface.iDBManager;

/**
 *
 * @author Josef
 */
public class ProcessLoginForm {
	
	private iDBManager dbManager = new DBManager();
	
	public ProcessLoginForm(UserData user) {
		login(user);
	}
	
	private void login(UserData user) {
		// Login user
	}
}
