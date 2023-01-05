package com.ericbarajas.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericbarajas.dojosninjas.models.Dojo;
import com.ericbarajas.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

//	injection (injecting whatever repository files you have)
	@Autowired
	DojoRepository dojoRepo;
	
	
	
	// ------------- CRUD FOR Dojo ----------------//
	// CREATE
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	// READ ONE
	public Dojo getOneDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	// READ ALL
	public List<Dojo> getAllDojoes(){
		return dojoRepo.findAll();
	}
	// UPDATE
	public Dojo updateDojo(Dojo updatedDojo) {
		return dojoRepo.save(updatedDojo);
	}
	// DELETE
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}

