/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.BlogPost;
import Bean.UserData;

/**
 *
 * @author Kerrai
 */
public class ProcessNewBlogPost {
    
    public ProcessNewBlogPost(BlogPost blogPost, UserData user) {
        System.out.println("Rubrik" + blogPost.getBlogHeadline() + "Text" + blogPost.getBlogText() + "Användare" + user.getUsername());
    }
    
}
