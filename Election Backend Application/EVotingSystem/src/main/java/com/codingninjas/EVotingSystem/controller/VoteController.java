package com.codingninjas.EVotingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.services.VoteService;

@RestController
public class VoteController {

	@Autowired
	VoteService service;
	
	@PostMapping("/add/vote")
	public void addVote(@RequestBody Vote vote) {
		service.addVote(vote);
	}
	
	@GetMapping("/get/votes")
	public List<Vote> getAllVotes(){
		return service.getAllVotes();
	}
	
	@GetMapping("/count/votes")
	public long getCountOfVotes() {
		return service.getCountOfVotes();
	}
	
	@PostMapping("/count/election/votes")
	public long getCountByElection(@RequestBody Election election) {
		return service.getCountByElection(election);
	}
	
}

