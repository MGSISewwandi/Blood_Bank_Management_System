package com.project.bdms.Donateevent;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.bdms.coordinator.Coordinator;
import com.project.bdms.coordinator.CoordinatorRepository;



@Controller
public class DonateeventController {

	@Autowired
	private DonateeventRepository donateeventRepo;
	@Autowired
	private CoordinatorRepository coordinatorRepostiory;

	@GetMapping("/donateevent")
	public String listDonateevent(Model m) {
		List<Donateevent> listDonateevent = donateeventRepo.findAll();
		m.addAttribute("listDonateevent", listDonateevent);
		return "donateevent";
		
	}
	
	@GetMapping("/donateevent/new")
	public String addDonateeventrForm(Model m) {
		List<Coordinator> listCoordinator = coordinatorRepostiory.findAll();
		m.addAttribute("donateevent", new Donateevent());
		m.addAttribute("listCoordinator", listCoordinator);
		return "newDonateevent";
	}
	
	
	

	@PostMapping("/donateevent/save")
	public String saveDonateevent(Donateevent donateevent) {
		donateeventRepo.save(donateevent);
		return "redirect:/donateevent";
		
	}
	

	@GetMapping("donateevent/edit/{id}")
		public String updateDonateevent(@PathVariable("id") Integer id, Model m) {
		Donateevent donateevent = donateeventRepo.findById(id).get();
		List<Coordinator> listCoordinator = coordinatorRepostiory.findAll();
		m.addAttribute("listCoordinator", listCoordinator);
		m.addAttribute("donateevent", donateevent);
		return "updateDonateevent";
	}
	


	@GetMapping("donateevent/delete/{id}")
	public String deleteDonateevent(@PathVariable("id") Integer id, Model m) {
		donateeventRepo.deleteById(id);
		return "redirect:/donateevent";

	}
}
