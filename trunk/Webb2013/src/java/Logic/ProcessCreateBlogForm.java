/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.BlogData;
import Bean.UserData;
import Database.DBManager;
import Interface.iDBManager;

/**
 *
 * @author Kerrai
 */
public class ProcessCreateBlogForm {

    private iDBManager dbManager = new DBManager();

    public ProcessCreateBlogForm(BlogData createBlog, UserData user) {
        System.out.println(createBlog.getBlogName() + user.getUserID());
                
    }

}
