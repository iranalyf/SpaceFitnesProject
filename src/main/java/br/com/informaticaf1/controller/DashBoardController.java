package br.com.informaticaf1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/DashBoard")
public class DashBoardController {

	
	@RequestMapping
	public ModelAndView dash(){
		
		return new ModelAndView("dash/dash");
	}
}
