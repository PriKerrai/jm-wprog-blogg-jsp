/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 * 
 * @author Josef
 */
public class RegisterForm {
	
	private String registerForm =
			"<div id=\"register-form-box\">"+
				"<p id=\"register-form-title\">Register</p>"+
				"<form action=\"process_register_form.jsp\" method=\"post\">"+
					"<div id=\"register-form-text-box\">"+
						"UserID: "+
						"<br />"+
						"Username: "+
						"<br />"+
						"Password: "+
					"</div>"+
					"<div id=\"register-form-input-box\">"+
						"<input type=\"text\" name=\"userid\" value=\"\" />"+
						"<br />"+
						"<input type=\"text\" name=\"username\" value=\"\" />"+
						"<br />"+
						"<input type=\"password\" name=\"password\" value=\"\" />"+
					"</div>"+
					"<div class=\"clear\"></div>"+
					"<button type=\"submit\">Submit</button>"+
				"</form>"+
			"</div>";
	
	public String getRegisterForm() {
		return registerForm;
	}
}
