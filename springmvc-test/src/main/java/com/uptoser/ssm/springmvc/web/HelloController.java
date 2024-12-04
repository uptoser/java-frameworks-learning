package com.uptoser.ssm.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String hello() {
		return "index";
	}

}
