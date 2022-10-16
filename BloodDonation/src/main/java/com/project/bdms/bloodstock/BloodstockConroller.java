package com.project.bdms.bloodstock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.bdms.Requesthospital.Requesthospital;
import com.project.bdms.Requesthospital.RequesthospitalRepository;


@Controller
public class BloodstockConroller {
	
	@Autowired
	private BloodstockRepository bloodstockRepository;
	
	@Autowired
	private RequesthospitalRepository requesthospitalRepository; 
	
	@GetMapping("/bloodstock/new")
	public String createBloodstockForm(Model m) {
		List<Requesthospital> listRequesthospital = requesthospitalRepository.findAll();
		m.addAttribute("bloodstock", new Bloodstock());
		m.addAttribute("listRequesthospital", listRequesthospital);
		
		return "newBloodstock";
		
	}
	
	@GetMapping("/bloodstock")
	public String listBloodstock(Model m) {
		List<Bloodstock> listBloodstock = bloodstockRepository.findAll();
		m.addAttribute("listBloodstock",listBloodstock);
		return "bloodstock";
		
	}
	
	@PostMapping("/bloodstock/save")
	public String saveBloodstock(Bloodstock bloodstock) {
		bloodstockRepository.save(bloodstock);
		return "redirect:/bloodstock";
		
	}

	@GetMapping("bloodstock/edit/{id}")
	public String updateBloodstock(@PathVariable("id") Integer id, Model m) {
		
		Bloodstock bloodstock = bloodstockRepository.findById(id).get();
		m.addAttribute("bloodstock", bloodstock);
		return "updateBloodstock";
		
	}
	
	@GetMapping("bloodstock/delete/{id}")
	public String deleteBloodstock(@PathVariable("id") Integer id, Model m) {
		bloodstockRepository.deleteById(id);
		return "redirect:/bloodstock";
}

}
