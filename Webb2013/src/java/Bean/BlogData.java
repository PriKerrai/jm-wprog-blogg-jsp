package Bean;

/**
 * BlogData Bean
 *
 * @author Josef
 */
public class BlogData {

    private int blogid = -1;
    private String blogname = "";

    public void setBlogid(int newID) {
        blogid = newID;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogname(String bName) {
        blogname = bName;
    }

    public String getBlogname() {
        return blogname;
    }
}
