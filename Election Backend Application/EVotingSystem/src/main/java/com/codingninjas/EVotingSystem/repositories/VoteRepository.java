package com.codingninjas.EVotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {

	@Query("SELECT COUNT(v) FROM Vote v WHERE v.election = :election")
	long countByElection(@Param("election") Election election);
	

	
}
