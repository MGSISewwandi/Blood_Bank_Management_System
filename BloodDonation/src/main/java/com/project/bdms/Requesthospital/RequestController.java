package com.project.bdms.Requesthospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.bdms.blood.Blood;
import com.project.bdms.blood.BloodRepository;
import com.project.bdms.bloodstock.Bloodstock;
import com.project.bdms.bloodstock.BloodstockRepository;



@Controller
public class RequestController {

	@Autowired
	private RequesthospitalRepository requesthospitalRepo;

	
	@Autowired
	private BloodRepository bloodRepository;
	
	@GetMapping("/requesthospital")
	public String listRequesthospital(Model m) {
		List<Requesthospital> listRequesthospital = requesthospitalRepo.findAll();
		m.addAttribute("listRequesthospital", listRequesthospital);
		return "requesthospital";
		
	}
	
	@GetMapping("/requesthospital/new")
	public String addRequesthospitalForm(Model m) {
		List<Blood> listBlood = bloodRepository.findAll();
		m.addAttribute("requesthospital", new Requesthospital());
		m.addAttribute("listBlood", listBlood);
		return "newRequesthospital";
	}
	
	@PostMapping("/requesthospital/save")
	public String saveRequesthoapital(Requesthospital requesthospital) {
		requesthospitalRepo.save(requesthospital);
		return "redirect:/requesthospital";
		
	}
	
	@GetMapping("/back_main")
	public String backToWelcome() {
		return "redirect:/";
	}
 
	@GetMapping("requesthospital/edit/{id}")
		public String updateRequesthospital(@PathVariable("id") Integer id, Model m) {
			Requesthospital requesthospital = requesthospitalRepo.findById(id).get();
			m.addAttribute("requesthospital", requesthospital);
			List<Blood> listBlood = bloodRepository.findAll();
			m.addAttribute("listBlood", listBlood);
			return "updateRequesthospital";
	}
	
	@GetMapping("requesthospital/delete/{id}")
	public String deleteRequesthospital(@PathVariable("id") Integer id, Model m) {
		requesthospitalRepo.deleteById(id);
		return "redirect:/requesthospital";
}
}
