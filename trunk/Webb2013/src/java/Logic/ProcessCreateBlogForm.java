/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.BlogData;
import Bean.UserData;
import Database.DBManager;
import Interface.iDBManager;
import java.sql.SQLException;

/**
 *
 * @author Kerrai
 */
public class ProcessCreateBlogForm {

    private iDBManager dbManager = new DBManager();

    public ProcessCreateBlogForm() {
			
    }
		
		public boolean isValidBlogInput(BlogData newBlog, UserData user)
		throws SQLException {
			if (newBlog.getBlogname().equals(""))
				return false;
			if (!dbManager.getPassword(user.getUserid()).equals(user.getPassword()))
				return false;
			return true;
		}
		
		public void registerBlog(BlogData newBlog, UserData user)
		throws SQLException {
			dbManager.registerNewBlog(newBlog, user);
		}
}
