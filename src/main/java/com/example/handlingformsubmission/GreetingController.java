package com.example.handlingformsubmission;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	public CRUDService crudService;
	public GreetingController(CRUDService crudService) {
		this.crudService=crudService;
	}
	@GetMapping("/greeting")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "greeting";
	}

	
	@PostMapping("/greeting")
	public String greetingSubmit(@RequestParam("id") String id, @RequestParam("content") String pass ,@ModelAttribute Greeting greeting, Model model) throws ExecutionException, InterruptedException {
		
		System.out.println("User Name :" + id);
		System.out.println("Password :" + pass);
		Greeting g= new Greeting();
		g.setId(id);
		g.setContent(pass);
		crudService.createCRUD(g);
		model.addAttribute("greeting", greeting);
		return "result";
	}

}
