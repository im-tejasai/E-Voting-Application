package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;

@Service
public class ElectionService {

	@Autowired
	ElectionRepository repo;
	public List<Election> getListOfElections() {
		return repo.findAll();
	}

	public void addElection(Election election) {
		repo.save(election);
		
	}
	
	public Election findElectionByName(String electionName) {
		return repo.findByName(electionName).orElseThrow();
	}

}
