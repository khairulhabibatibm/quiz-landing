package com.example.servingwebcontent;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/result")
	public String result(@RequestParam(name="result", required=true) String result, Model model) {
		Timestamp ts = new Timestamp(new Date().getTime());
		System.out.println(ts + ": incoming result > " + result);
		String wording = "unknown";

		if("1".equals(result)){
			wording = "You are good to go";
		}else if("2".equals(result)){
			wording = "You have excellent knowledge!";
		}else{
			wording = "You need to learn more about Openshift";
		}

		model.addAttribute("wording", wording);
		return "result";
	}

}
