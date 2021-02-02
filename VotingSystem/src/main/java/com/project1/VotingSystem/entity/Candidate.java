package com.project1.VotingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Candidates")
@Entity
public class Candidate {
public Candidate() {
		super();
}
	@Id
    @Column(name="id")
	private Long id;

	public Candidate(Long id) {
		super();
		this.id = id;
	}
	@Column(name="candidate_name")
	private String name;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Candidate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private int numberOfVotes;
    @Column(name="number_Of_Votes")
	public int getNumberOfVotes() {
		return numberOfVotes;
	}
	public void setNumberOfVotes(int numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
	
}
