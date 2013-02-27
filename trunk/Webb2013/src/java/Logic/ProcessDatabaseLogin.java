/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.DatabaseLoginData;
import Database.DBManager;
import Interface.iDBManager;

/**
 *
 * @author Kerrai
 */
public class ProcessDatabaseLogin {
    
    private iDBManager dbManager = new DBManager();

    public ProcessDatabaseLogin(DatabaseLoginData database) {
			dbManager.connectDB(database.getDatabaseLogin(), database.getDatabasePassword());
		}

}
