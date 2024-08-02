package com.codingninjas.EVotingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.services.ElectionChoiceService;
import com.codingninjas.EVotingSystem.services.ElectionService;

@RestController
public class ElectionChoiceController {

	@Autowired
	ElectionChoiceService service;
	
	@Autowired
	ElectionService electionService;
	
	@PostMapping("/add/electionChoice")
	public void addElectionChoice(@RequestBody ElectionChoice electionChoice) {
		service.addElectionChoice(electionChoice);
	}
	
	@GetMapping("/get/electionChoices")
	public List<ElectionChoice>  getAllElectionChoices(){
		return service.getAllElectionChoice();
	}
	
	@PostMapping("/count/election/choices")
	public long getElectionChoiceByElection(@RequestBody Election election){
		return service.countByElection(election);
	}
	
	@PostMapping("/winner/election")
	public ElectionChoice getWinnerOfElection(@RequestBody Election election) {
		Election updatedWinner = electionService.findElectionByName(election.getName());
		return service.findElectionChoiceWithMaxVotes(updatedWinner);
	}
}
