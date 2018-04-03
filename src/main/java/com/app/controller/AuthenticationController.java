package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.helper.ReponseHelper;

@RestController
public class AuthenticationController {
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public ResponseEntity<ReponseHelper> userLogin(
			HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam(name="user_id")String userId, @RequestParam(name="user_pwd")String userPwd) {
		System.out.println("LOG IN REQUEST CALLED");
		
		return new ResponseEntity<>(ReponseHelper.setSuccessMessage("User Logged in"), HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value = "/userLogout", method = RequestMethod.GET)
	public ResponseEntity<ReponseHelper> userLogout(
			HttpServletRequest request, HttpServletResponse response, HttpSession session ) {
		System.out.println("LOG OUT REQUEST CALLED");
		
		return new ResponseEntity<>(ReponseHelper.setSuccessMessage("User Logged out"), HttpStatus.NO_CONTENT);
	}
	
}
