package com.project1.VotingSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project1.VotingSystem.entity.Candidate;
import com.project1.VotingSystem.entity.Citizen;
import com.project1.VotingSystem.repositories.CandidateRepo;
import com.project1.VotingSystem.repositories.CitizenRepo;
import org.jboss.logging.Logger;

//import ch.qos.logback.classic.Logger;

@Controller
public class VotingController {
	
	public final Logger logger = Logger.getLogger(VotingController.class);

	@Autowired
	CitizenRepo citizenRepo;

	@Autowired
	CandidateRepo candidateRepo;

	@RequestMapping("/")
	public String goToVote() {
		logger.info("Returning vote.html file");
		return "vote.html";
	}

	@RequestMapping("doLogin")
	public String doLogin(@RequestParam String name, Model model, HttpSession session) {

		logger.info("getting citizen from database");
		
		Citizen citizen = citizenRepo.findByName(name);
	
		logger.info("putting citizen into session");
		session.setAttribute("citizen", citizen);

		if(!citizen.getHasVoted()) {
			logger.info("putting candidates into model");
			List<Candidate> candidates = candidateRepo.findAll();
			model.addAttribute("candidates", candidates);
			return "/performVote.html";
		} else {
			return "/alreadyVoted.html";
		}

	}

	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id, HttpSession session) {
		Citizen citizen = (Citizen) session.getAttribute("citizen");
		
		if (!citizen.getHasVoted()) {
			
			citizen.setHasVoted(true);
			
			Candidate c = candidateRepo.findById((Long) id);
			logger.info("voting for candidate "+c.getName());
			c.setNumberOfVotes(c.getNumberOfVotes() + 1);
			
			candidateRepo.save(c);
			citizenRepo.save(citizen);
			
			return "voted.html";
		}
		
		return "alreadyVoted.html";

		

	}

}

