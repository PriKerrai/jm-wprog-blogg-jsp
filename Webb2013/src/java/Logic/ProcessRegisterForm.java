
package Logic;

import Bean.UserData;
import Database.DBManager;
import Interface.iDBManager;
import java.sql.SQLException;

/**
 *
 * @author Josef
 */
public class ProcessRegisterForm {
	
	private iDBManager dbManager = new DBManager();
	
	public ProcessRegisterForm() {
		
	}
	
	public boolean isValidRegInput(UserData user) throws SQLException {
		return dbManager.isValidRegInput(user.getUserid(), user.getUsername());
	}
	
	public void registerUser(UserData user) throws SQLException {
		dbManager.registerUser(user);
	}
}
