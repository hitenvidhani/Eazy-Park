package com.example.handlingformsubmission;
 
import java.util.concurrent.ExecutionException;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class UserController {
	
 @GetMapping("/viewUser")
	public String viewUser(Model model) {
		return "viewUser";
	}
 @GetMapping("/user_login")
	public String userLogin(Model model) {
		return "user_login";
	}
 
 @GetMapping("/user_signup")
	public String userSignup(Model model) {
		return "user_signup";
	}

	@GetMapping("/user_dashboard")
	public String userDashboard(Model model){
		return "user_dashboard";
	}

	@GetMapping("/booking")
	public String booking(Model model){
		return "booking";
	}

	@PostMapping("/user_login")
	@ResponseBody
	public String confirmSignup(@RequestBody String name) throws ExecutionException, InterruptedException {
		System.out.println(name);
		
		System.out.println(new WorkerService().deleteCRUD(name));
		return "confirmSignup";
	}
}