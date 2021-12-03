package com.example.handlingformsubmission;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpotController  {
	public SpotService crudService;
	public SpotController (SpotService crudService) {
		this.crudService=crudService;
	}
	@GetMapping("/spot")
	public String spotForm(Model model) {
		model.addAttribute("spot", new Spot());
		return "spot";
	}


	@GetMapping("/view")
	public String viewSpot(Model model) throws InterruptedException, ExecutionException {
		// model.addAttribute("view");
		crudService.getAllCRUD();
		return "view";
	}

	
	@PostMapping("/spot")
	public String greetingSubmit(@RequestParam("name") String name, @RequestParam("location") String location, @RequestParam("num") int num ,@ModelAttribute Spot spot, Model model) throws ExecutionException, InterruptedException {
		
		// System.out.println("User Name :" + id);
		// System.out.println("Password :" + pass);
		Spot s= new Spot();
		s.setName(name);
		s.setLocation(location);
		s.setNum(num);
		crudService.createCRUD(s);
		model.addAttribute("spot", spot);
		return "output";
	}

}
