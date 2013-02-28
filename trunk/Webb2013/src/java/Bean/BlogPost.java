/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Kerrai
 */
public class BlogPost {

    private String blogHeadline;
    private String blogText;
    
    public void setBlogHeadline(String newHeader) {
        blogHeadline = newHeader;
    }

    public String getBlogHeadline() {
        return blogHeadline;
    }
    
    public void setBlogText(String newText) {
        blogText = newText;
    }

    public String getBlogText() {
        return blogText;
    }
    
    
    
}