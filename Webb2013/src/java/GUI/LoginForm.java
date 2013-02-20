
package GUI;

/**
 * LoginForm Bean
 * @author Josef
 */
public class LoginForm {
	
	private String loginForm = 
			"<div id=\"login-form-box\">"+
				"<p id=\"login-form-title\">Login</p>"+
				"<form id=\"login-form\" action=\"process_form.jsp\" method=\"post\">"+
					"<div id=\"login-form-text-box\">"+
						"Username: "+
						"<br />"+
						"Password: "+
					"</div>"+
					"<div id\"login-form-input-box\">"+
						"<input type=\"text\" name=\"username\" value=\"\" />"+
						"<br />"+
						"<input type=\"password\" name=\"password\" value=\"\" />"+
					"</div>"+
				"</form>"+
			"</div>";
	
	public void setLoginForm(String newForm) {
		loginForm = newForm;
	}
	
	public String getLoginForm() {
		return loginForm;
	}
}
