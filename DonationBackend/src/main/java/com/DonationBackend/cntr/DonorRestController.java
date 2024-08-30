package com.DonationBackend.cntr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DonationBackend.model.Donor;
import com.DonationBackend.service.AdminService;
import com.DonationBackend.service.DonorService;

@CrossOrigin
@RestController
public class DonorRestController {
	
	@Autowired
	private DonorService donorService;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(value= {"/donorRegister"})
	public String donorRegister(@RequestBody Donor donorObj) {
		
		if(adminService.doesEmailExist(donorObj.getDonorEmail())) {
			return "email id present";
		}
		else {
			donorService.add(donorObj);
			return "added success";
		}
	}
	
	@GetMapping(value= {"/donorProfile/{donorId}"})
	public Donor getDonor(@PathVariable int donorId) {	
		Donor donor=donorService.getById(donorId);
		//System.out.println();
		System.out.println(donor);
		if (donor != null) {
			System.out.println(donor);
				return donor;
			}
		return null;
	}

	@PostMapping("donorUpdate")
	public String volunteerUpdate(@RequestBody Donor donor) {
		donorService.add(donor);
		return "Update SuccessFully";
	}
}
