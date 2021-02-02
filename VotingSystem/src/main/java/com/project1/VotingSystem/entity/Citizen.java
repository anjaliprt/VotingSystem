package com.project1.VotingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="Citizens")
@Entity
public class Citizen {
    public Citizen() {
		super();
	}
	@Id
    @Column(name="id")
	private Long id;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
@Column(name="citizen_name")
public String name;

public Citizen(Long id, String name,Boolean hasVoted) {
	super();
	this.id = id;
	this.name = name;
	//this.hasVoted = hasVoted;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


private Boolean hasVoted;

@Column(name="has_voted")
public Boolean getHasVoted() {
	return hasVoted;
}

public void setHasVoted(Boolean hasVoted) {
	this.hasVoted = hasVoted;	
}




}
