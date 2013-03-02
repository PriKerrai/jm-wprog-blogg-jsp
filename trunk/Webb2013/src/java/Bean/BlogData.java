package Bean;

/**
 * BlogData Bean
 *
 * @author Josef
 */
public class BlogData {

    private int blogID = -1;
    private String blogName = "";

    public void setBlogID(int newID) {
        blogID = newID;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogName(String bName) {
        blogName = bName;
    }

    public String getBlogName() {
        return blogName;
    }
}
