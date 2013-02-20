
package GUI;

/**
 * LoginForm Bean
 * @author Josef
 */
public class LoginForm {
	
	private String loginForm = 
			"<div id=\"login-box\">"+
				"<form id=\"login-form\" action=\"process_form.jsp\" method=\"post\">"+
					"<div>"+
						"Login: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"text\" name=\"username\" value=\"\" />"+
						"<br />"+
						"Password: <input type=\"text\" name=\"username\" value=\"\" />"+
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
