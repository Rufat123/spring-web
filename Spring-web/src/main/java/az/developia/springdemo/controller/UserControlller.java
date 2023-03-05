package az.developia.springdemo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.springdemo.model.User;

@Controller
public class UserControlller {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@GetMapping("/my-login")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/auth-user")
	public void authUser() {

	}

	@GetMapping("/logout")
	public String showLgoutPage(HttpServletRequest r) {
		SecurityContextHolder.clearContext();
		r.getSession().invalidate();
		return "login";
	}

	@GetMapping("/create-account")
	public String showCreateAccountPage(Model m) {
		User user = new User();
		m.addAttribute("user", user);
		return "create-account";
	}

	@Autowired
	private DataSource dataSource;
	


	@PostMapping("/create-account-save")
	public String userSave(@Valid @ModelAttribute(name = "user") User user, BindingResult br) {
		


		if (br.hasErrors()) {
			return "create-account";
		}
		
			try {
				Connection conn = dataSource.getConnection();
				Statement st = conn.createStatement();
				
				ResultSet rs= st.executeQuery("select * from users where username='"+ user.getUsername()+"'");
				if (rs.next()) {
					br.addError(new FieldError("user", "username", "Bu istifadeci adindan artiq istifade olunur"));
					return "create-account";
				}

				st.executeUpdate("insert into users" + "(username,password,enabled) values" + "('" + user.getUsername()
						+ "','{bcrypt}" + encoder.encode(user.getPassword()) + "',1);");

				st.executeUpdate("insert into authorities" + "(username,authority) values" + "('" + user.getUsername()
						+ "','admin'),('" + user.getUsername() + "','list:cars');");
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		return "login";
	}
}
