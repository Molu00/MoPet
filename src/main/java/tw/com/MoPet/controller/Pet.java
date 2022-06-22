package tw.com.MoPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import tw.com.MoPet.model.pet;
import tw.com.MoPet.service.petService;

@Controller
public class Pet {

	@Autowired
	private petService pService;
	
	@PostMapping(path="pet/insert")
	public pet insertPet(pet pet) {
		return pService.insert(pet);
	}
}
