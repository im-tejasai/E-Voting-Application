package com.codingninjas.EVotingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.services.ElectionService;

@RestController
public class ElectionController {

	@Autowired
	ElectionService service;
	@GetMapping("/get/elections")
	public List<Election> getListOfElections(){
		return service.getListOfElections();
	}
	
	@PostMapping("/add/election")
	public void addElection(@RequestBody Election election) {
		service.addElection(election);
	}
}
