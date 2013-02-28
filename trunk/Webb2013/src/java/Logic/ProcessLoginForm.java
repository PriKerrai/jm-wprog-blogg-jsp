
package Logic;

import Bean.UserData;
import Database.DBManager;
import Interface.iDBManager;
import java.sql.SQLException;

/**
 *
 * @author Josef
 */
public class ProcessLoginForm {
	
	private iDBManager dbManager = new DBManager();
	
	public ProcessLoginForm() {
		
	}
	
	public UserData login(UserData user) throws SQLException {
		UserData tmp = new UserData();
		if (dbManager.isValidLogin(user.getUsername(), user.getPassword()))
			tmp = dbManager.userLogin(user.getUsername(), user.getPassword());
		return tmp;
	}
}
