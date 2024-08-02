package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;

@Service
public class ElectionChoiceService {

	@Autowired
	ElectionChoiceRepository repo;
	
	public void addElectionChoice(ElectionChoice electionChoice) {
		repo.save(electionChoice);
		
	}

	public List<ElectionChoice> getAllElectionChoice() {
		return repo.findAll();
	}

	public long countByElection(Election election) {
		return repo.countByElection(election);
		
	}
	
	public ElectionChoice findElectionChoiceWithMaxVotes(Election election) {
		return repo.findElectionChoiceWithMaxVotes(election.getId());
	}

}
