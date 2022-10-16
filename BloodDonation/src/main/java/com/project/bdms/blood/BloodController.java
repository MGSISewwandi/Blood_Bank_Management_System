package com.project.bdms.blood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BloodController {
	
	@Autowired
	private BloodRepository bloodRepository;
	
		
	@GetMapping("/blood")
	public String listBlood(Model m) {
		List<Blood> listBlood = bloodRepository.findAll();
		m.addAttribute("listBlood", listBlood);
		return "blood";
		
	}
	
	
	@GetMapping("/blood/new")
	public String addBloodForm(Model m) {
		m.addAttribute("blood", new Blood());
		return "newBlood";
		
	}
	
	
	
	
	@PostMapping("/blood/save")
	public String saveBlood(Blood blood) {
		bloodRepository.save(blood);
		return "redirect:/blood";
		
	}
	
	
	
	@GetMapping("blood/edit/{id}")
	public String updateBlood(@PathVariable("id") Integer id, Model m) {	
		Blood blood = bloodRepository.findById(id).get();
		m.addAttribute("blood", blood);
		return "updateBlood";
		
	}
	
	@GetMapping("blood/delete/{id}")
	public String deleteBlood(@PathVariable("id") Integer id, Model m) {
		bloodRepository.deleteById(id);
		return "redirect:/blood";
}
	
}


