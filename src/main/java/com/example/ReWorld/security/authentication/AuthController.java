package com.example.ReWorld.security.authentication;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.example.ReWorld.entities.User;
import com.example.ReWorld.entities.VerificationToken;
import com.example.ReWorld.models.Message;
import com.example.ReWorld.security.services.IUserService;


@Controller
public class AuthController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@GetMapping("/login")
	public String userLogin(@RequestParam(name = "error", required = false, defaultValue = "false") Boolean error,
			Model model) {
		if (error) {
			model.addAttribute("message",
					new Message("Đăng nhập thất bại vui lòng kiểm tra lại Email và Password", false));
		}
		return "signin";
	}

	@GetMapping("/signup")
	public String userRegister(@RequestParam(name = "error", required = false, defaultValue = "false") Boolean error,
			Model model) {
		if (error) {
			model.addAttribute("message",
					new Message("Đăng nhập thất bại vui lòng kiểm tra lại Email và Password", false));
		}
		return "signup";
	}

	@GetMapping("/registration-confirm")
	public String confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token,@RequestParam("role")String role) {
		
		VerificationToken verificationToken = userService.getVerificationToken(token);
		if (verificationToken == null) {
			model.addAttribute("steps", 2);
			model.addAttribute("message", new Message("Token is no match", false));
			return "applicant/register";
		}

		User user = verificationToken.getUser();
		Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			model.addAttribute("message", new Message("Token is expired", false));
			model.addAttribute("steps", 2);
			return "applicant/register";
		}
		
		user.setEnabled(true);
		userService.saveRegisteredUser(user);
		if(role.equals("recruiter")) {
			model.addAttribute("steps",3);
		}
		return  role.equals("applicant") ? "redirect:/login" : "recruiter/register";
	}
	
}
