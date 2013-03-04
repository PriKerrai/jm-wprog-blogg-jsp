/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Josef
 */
public class Post {
	
	String headline = "";
	String content = "";
	String date = "";
	String author = "";
	int userID = 0;
	int numComments = 0;
	
	public Post() {
		
	}
	
	public void setHeadline(String newHeadline) {
		headline = newHeadline;
	}
	
	public String getHeadline() {
		return headline;
	}
	
	public void setContent(String newContent) {
		content = newContent;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setDate(String newDate) {
		date = newDate;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setAuthor(String newAuthor) {
		author = newAuthor;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setUserID(int newID) {
		userID = newID;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setNumComments(int newNum) {
		numComments = newNum;
	}
	
	public int getNumComments() {
		return numComments;
	}
	
}
