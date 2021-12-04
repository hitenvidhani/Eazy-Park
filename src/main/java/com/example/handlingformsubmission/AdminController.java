package com.example.handlingformsubmission;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	
	@GetMapping("/admin_login")
	public String login(Model model) {
		return "admin_login";
	}
 @GetMapping("/admin_dashboard")
	public String dashboard(Model model) {
		return "admin_dashboard";
	}
}
