
package Logic;

import Bean.UserData;
import Database.DBManager;
import Interface.iDBManager;

/**
 *
 * @author Josef
 */
public class ProcessRegisterForm {
	
	private iDBManager dbManager = new DBManager();
	
	public ProcessRegisterForm() {
		
	}
	
	public boolean isValidRegInput(UserData user) {
		return dbManager.isValidRegInput(user.getUserID(), user.getUsername());
	}
	
	public void registerUser(UserData user) {
		dbManager.registerUser(user);
	}
}
