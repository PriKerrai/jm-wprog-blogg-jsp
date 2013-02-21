/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Kerrai
 */
public class DatabaseLoginForm {
    
    private String databaseLoginForm = 
                                "<div id=\"databaselogin-form-box\">"+
				"<p id=\"databaselogin-form-title\">Database Login</p>"+
				"<form action=\"process_database_login_form.jsp\" method=\"post\">"+
					"<div id=\"databaselogin-form-text-box\">"+
                                               "Database Server: "+
                                               "<br />"+
                                               "Database Login"+
                                               "<br />"+
                                               "Database Password"+
                                "</div>"+
                                "<div id\"databaselogin-form-input-box\">"+
						"<input type=\"text\" name=\"Database Server\" value=\"\" />"+
						"<br />"+
						"<input type=\"login\" name=\"Database Login\" value=\"\" />"+
                                                "<br />"+
						"<input type=\"password\" name=\"Database Password\" value=\"\" />"+
					"</div>"+
					"<div class=\"clear\"></div>"+
					"<button type=\"submit\">Submit</button>"+
				"</form>"+
			"</div>";
    
    public String getDatabaseLoginForm() {
		return databaseLoginForm;
	}
}
