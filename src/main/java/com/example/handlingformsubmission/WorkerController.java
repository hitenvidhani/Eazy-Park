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
public class WorkerController {
	public WorkerService crudService;
	public WorkerController (WorkerService crudService) {
		this.crudService=crudService;
	}
 @GetMapping("/employee_login")
	public String emplogin(Model model) {
		return "employee_login";
	}
	@GetMapping("/worker")
	public String workerForm(Model model) {
		model.addAttribute("worker", new Worker());
		return "worker";
	}
	
	@PostMapping("/viewWorker")
	@ResponseBody
	public String greetingSubmit(@RequestBody String name) throws ExecutionException, InterruptedException {
		System.out.println(name);
		
		System.out.println(new WorkerService().deleteCRUD(name));
		return "Hi";
	}

	@GetMapping("/viewWorker")
	public String viewWorker(Model model) throws InterruptedException, ExecutionException {
		// model.addAttribute("view");
		// crudService.getAllCRUD();
		return "viewWorker";
	}

	@GetMapping("/view_jobs")
	public String viewJobs(Model model) throws InterruptedException, ExecutionException {
		// model.addAttribute("view");
		// crudService.getAllCRUD();
		return "worker_availableJobs";
	}
 @GetMapping("/worker_dashboard")
	public String dashWork(Model model) throws InterruptedException, ExecutionException {
		// model.addAttribute("view");
		// crudService.getAllCRUD();
		return "worker_dashboard";
	}
	@PostMapping("/worker")
	public String greetingSubmit(@RequestParam("name") String name, @RequestParam("spot") String spot, @RequestParam("slot") int slot , @RequestParam("hour") int hour , @RequestParam("rating") int rating,@RequestParam("password") String password ,@ModelAttribute Worker worker, Model model) throws ExecutionException, InterruptedException {
		// System.out.println("User Name :" + id);
		// System.out.println("Password :" + pass);
		Worker w= new Worker();
		w.setName(name);
		w.setSpot(spot);
		// w.setSlot(slot);
		w.setHour(hour);
		w.setRating(rating);
  w.setPassword(password);
		crudService.createCRUD(w);
		// model.addAttribute("worker", worker);
		return "viewWorker";
	}

}
