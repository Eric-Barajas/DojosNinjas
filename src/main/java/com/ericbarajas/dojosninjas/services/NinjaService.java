package com.ericbarajas.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericbarajas.dojosninjas.models.Ninja;
import com.ericbarajas.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

//	injection (injecting whatever repository files you have)
	
	@Autowired
	NinjaRepository ninjaRepo;
	
	
	// ------------- CRUD FOR Ninja ----------------//
	// CREATE
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	// READ ONE
	public Ninja getOneNinja(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
	// READ ALL
	public List<Ninja> getAllNinjaes(){
		return ninjaRepo.findAll();
	}
	// UPDATE
	public Ninja updateNinja(Ninja updatedNinja) {
		return ninjaRepo.save(updatedNinja);
	}
	// DELETE
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
