
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
	
	public ProcessRegisterForm(UserData user) {
		if (isValidInput(user))
			register(user);
	}
	
	private boolean isValidInput(UserData user) {
		// Validera input
		return true;
	}
	
	private void register(UserData user) {
		// Register user
	}
}
