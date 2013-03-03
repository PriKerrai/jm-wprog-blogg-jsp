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

    private String blogheadline;
    private String text;
    
    public void setBlogheadline(String newheader) {
        blogheadline = newheader;
    }

    public String getBlogheadline() {
        return blogheadline;
    }
    
    public void setText(String newtext) {
        text = newtext;
    }

    public String getText() {
        return text;
    }
    
    
    
}