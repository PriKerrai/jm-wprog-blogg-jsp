/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.BlogPost;
import Bean.UserData;
import Database.DBManager;
import Interface.iDBManager;
import java.sql.SQLException;

/**
 *
 * @author Kerrai
 */
public class ProcessNewBlogPostForm {
    
    private iDBManager dbManager = new DBManager();
    
    public ProcessNewBlogPostForm(BlogPost blogpost, UserData user) 
		throws SQLException {
        System.out.println("Rubrik: " + blogpost.getBlogheadline() + "Text: " + blogpost.getText() + "Användare: " + user.getUsername());
        dbManager.registerNewBlogPost(blogpost, user);
        
    }
    
}
