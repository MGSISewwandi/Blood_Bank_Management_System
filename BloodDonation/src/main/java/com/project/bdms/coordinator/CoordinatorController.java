package com.project.bdms.coordinator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.bdms.Donateevent.Donateevent;
import com.project.bdms.Donateevent.DonateeventRepository;


@Controller
public class CoordinatorController {
	
	
	@Autowired
	private DonateeventRepository donateeventRepo;
	@Autowired
	private CoordinatorRepository coordinatorRepository; 
	
	@GetMapping("/coordinator/new")
	public String createCoordinatorForm(Model m) {
		List<Donateevent> listDonateevent = donateeventRepo.findAll();
		m.addAttribute("coordinator", new Coordinator());
		m.addAttribute("listDonateevent", listDonateevent);
		
		return "newCoordinator";
		
	}
	
	@GetMapping("/coordinator")
	public String listCoordinator(Model m) {
		List<Coordinator> listCoordinator = coordinatorRepository.findAll();
		m.addAttribute("listCoordinator",listCoordinator);
		return "coordinator";
		
	}
	
	@PostMapping("/coordinator/save")
	public String saveCoordinator(Coordinator coordinator) {
		coordinatorRepository.save(coordinator);
		return "redirect:/coordinator";
		
	}

	@GetMapping("coordinator/edit/{id}")
	public String updateCoordinator(@PathVariable("id") Integer id, Model m) {
		Coordinator coordinator = coordinatorRepository.findById(id).get();
		m.addAttribute("coordinator", coordinator);
		return "updateCoordinator";
		
	}
	
	
	
	@GetMapping("coordinator/delete/{id}")
	public String deleteCoordinator(@PathVariable("id") Integer id, Model m) {
		coordinatorRepository.deleteById(id);
			return "redirect:/coordinator";
}

}
