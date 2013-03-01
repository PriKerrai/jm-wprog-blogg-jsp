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
public class ProcessNewBlogPost {
    
    private iDBManager dbManager = new DBManager();
    
    public ProcessNewBlogPost(BlogPost blogPost, UserData user) throws SQLException {
        dbManager.registerNewBlogMessage(blogPost, user);
        System.out.println("Rubrik: " + blogPost.getBlogHeadline() + "Text: " + blogPost.getBlogText() + "Användare: " + user.getUsername());
    }
    
}
