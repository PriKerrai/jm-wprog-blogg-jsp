/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Kerrai
 */
public class Comment {
    private String user = "";
    private int blogPostID = 0;
    private String date = "";
    private String text = "";
    private int commentID = 0;
    
    public int getCommentID() {
        return commentID;
    }
    
    public void setCommentID(int CommentID) {
        commentID = CommentID;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String Text) {
        text = Text;
    }
    
    public String getDate() {
        return date;
    } 
    
    public void setDate(String Date) {
        date = Date;
    }
    
    public int getBlogPostID() {
        return blogPostID;
    }
    
    public void setBlogPostID(int BlogPostID) {
        blogPostID = BlogPostID; 
    }
    
    public String getUser() {
        return user;
    }
    
    public void setUser(String newUser) {
        user = newUser;
    }
    
    
}
