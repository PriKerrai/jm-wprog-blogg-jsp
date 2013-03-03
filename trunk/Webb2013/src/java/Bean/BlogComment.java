/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Kerrai
 */
public class BlogComment {
    
    private String comment;
    private int postid;
    
    public void setPostid(int newpostid) {
        postid = newpostid;
    }
    
    public int getPostid() {
        return postid;
    }
    
    public void setComment(String blogCommentText) {
        comment = blogCommentText;
        
    }
    
    public String getComment() {
        return comment;
    }
    
}
