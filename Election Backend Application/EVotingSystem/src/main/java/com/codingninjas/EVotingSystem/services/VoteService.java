package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class VoteService {

	@Autowired
	VoteRepository repo;
	
	
	
    public void addVote(Vote vote) {
		repo.save(vote);
		
	}

	public List<Vote> getAllVotes() {
		return repo.findAll();
	}

	public long getCountOfVotes() {
		return repo.count();
	}

	public long getCountByElection(Election election) {
		return repo.countByElection(election);
	}

	

}
