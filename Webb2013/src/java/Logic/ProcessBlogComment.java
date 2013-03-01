/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.BlogComment;
import Bean.BlogData;
import Bean.UserData;
import Database.DBManager;
import Interface.iDBManager;
import java.sql.SQLException;

/**
 *
 * @author Kerrai
 */
public class ProcessBlogComment {
    
     private iDBManager dbManager = new DBManager();
     
     public ProcessBlogComment(UserData userData, BlogData blogData, BlogComment blogComment) throws SQLException {
         
         dbManager.registerNewBlogComment(blogData, userData, blogComment);
         
         System.out.println(userData.getUserid() + blogData.getBlogID() + blogComment.getBlogComment());
         
     }
}
