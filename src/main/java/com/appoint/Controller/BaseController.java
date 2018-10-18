package com.appoint.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

	@GetMapping("/")
	public String home() {
		return "HomePage";
	}
	
	@GetMapping("/find/Appointments")
	public String fetchData() {
		return "findAppointment";
	}
	
}
