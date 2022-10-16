package com.project.bdms.Donor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.bdms.blood.Blood;
import com.project.bdms.blood.BloodRepository;

@Controller
public class DonorController {
	
	@Autowired
	private DonorRepository donorRepository;
	
	@Autowired
	private BloodRepository bloodRepository;
	
	@GetMapping("/donor/new")
	public String createDonorForm(Model m) {
		List<Blood> listBlood = bloodRepository.findAll();
		m.addAttribute("donor", new Donor());
		m.addAttribute("listBlood", listBlood);
		
		return "newDonor";
		
	}
	
	
	
	@PostMapping("/donor/save")
	public String saveDonor(Donor donor) {
		donorRepository.save(donor);
		return "redirect:/donor";
		
	}
	
	

	@GetMapping("/donor")
	public String listDonor(Model m) {
		List<Donor> listDonor = donorRepository.findAll();
		m.addAttribute("listDonor",listDonor);
		List<Blood> listBlood = bloodRepository.findAll();
		m.addAttribute("listBlood", listBlood);
		return "donor";
		
	}
	

	
	@GetMapping("donor/edit/{id}")
	public String updateDonor(@PathVariable("id") Integer id, Model m) {
		List<Blood> listBlood = bloodRepository.findAll();
		Donor donor = donorRepository.findById(id).get();
		m.addAttribute("listBlood", listBlood);
		m.addAttribute("donor", donor);
		return "updateDonor";
	}
	
	@GetMapping("donor/delete/{id}")
	public String deleteDonor(@PathVariable("id") Integer id, Model m) {
		donorRepository.deleteById(id);
		return "redirect:/donor";
		

	}

}
