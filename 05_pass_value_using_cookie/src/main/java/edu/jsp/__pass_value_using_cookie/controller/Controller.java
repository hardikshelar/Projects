package edu.jsp.__pass_value_using_cookie.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/testCookie")
public String testCookie(@CookieValue String Cookie) {
	return "Your Token : "+Cookie;
}
}
