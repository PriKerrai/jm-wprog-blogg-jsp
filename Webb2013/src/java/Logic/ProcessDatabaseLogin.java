/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.DatabaseLoginData;
import Database.DBManager;
import Interface.iDBManager;
import java.sql.Connection;

/**
 *
 * @author Kerrai
 */
public class ProcessDatabaseLogin {
    
    private iDBManager dbManager = new DBManager();

    public ProcessDatabaseLogin() {
			
		}
		
		public boolean connect(DatabaseLoginData database) {
			Connection connection = dbManager.connectDB(database.getLogin(), database.getPassword());
			if (connection == null)
				return false;
			return true;
		}

}
