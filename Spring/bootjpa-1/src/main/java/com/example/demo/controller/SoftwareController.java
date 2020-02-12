package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.SoftwareRepo;
import com.example.demo.model.Software;

@Controller
public class SoftwareController {
	
	@Autowired
	SoftwareRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addSoftware")
	public String addSoftware(Software sft) {
		repo.save(sft);
		return "home.jsp";
	}
	
	@RequestMapping("/getSoftware")
	public ModelAndView addSoftware(@RequestParam int sid) {
		ModelAndView mv = new ModelAndView("showSoft.jsp");
		Software sft = repo.findById(sid).orElse(new Software());
		
		System.out.println(repo.findBySname("Hibernate"));
		System.out.println(repo.findBySidGreaterThan(102));
		System.out.println(repo.findBySortedSname());
		
		mv.addObject(sft);
		return mv;
	}
}
