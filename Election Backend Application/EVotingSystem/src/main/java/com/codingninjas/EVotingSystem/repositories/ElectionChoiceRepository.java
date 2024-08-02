package com.codingninjas.EVotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;

@Repository
public interface ElectionChoiceRepository extends JpaRepository<ElectionChoice,Long> {

	@Query("Select count(ec) From ElectionChoice ec where ec.election = :election")
	long countByElection(@Param("election") Election election);
	
	@Query(value = "SELECT ec.* FROM election_choice ec "
            + "JOIN vote v ON ec.id = v.election_choice_id "
            + "WHERE ec.election_id = :electionId "
            + "GROUP BY ec.id "
            + "ORDER BY COUNT(v.id) DESC LIMIT 1", nativeQuery = true)
    ElectionChoice findElectionChoiceWithMaxVotes(@Param("electionId") Long electionId);




	
}
