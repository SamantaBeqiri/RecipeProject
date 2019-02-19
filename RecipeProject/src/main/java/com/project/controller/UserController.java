package com.project.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Validation.UserValidation;
import com.project.dto.UserDto;
import com.project.service.UserService;

@Controller

public class UserController {


	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpSession session) {
	if (session.getAttribute("user") == null) {
			model.put("userData", new UserDto());
			
			return "register";
	}else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveForm(ModelMap model ,@ModelAttribute("userData") @Valid UserDto userDto, BindingResult bindingResult,
			HttpSession session) {
		UserValidation userValidation = new UserValidation();
		userValidation.validate(userValidation, bindingResult);
		if (bindingResult.hasErrors()) {
			return "register";
		} else {
			if (userDto.getConfirmPassword().equals(userDto.getPassword())) {
				UserDto userCheck=userService.findUserByUsEmail(userDto.getUsername(), userDto.getPassword());
				
				if(userCheck!=null) {
					return "UserExists";
				}
				userService.save(userDto);
				return "redirect:/login";
			} else
				return "register";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			model.put("userData", new UserDto());
			return "login";
		} else {
			return "redirect:/allrecipe";
		}
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String login(ModelMap model, @ModelAttribute("userData") UserDto userDto, HttpSession session) {
		if (userDto.getUsername() != null && userDto.getPassword() != null) {
			userDto = userService.findUserByUsPass(userDto.getUsername(), userDto.getPassword());
			if (userDto != null) {
				session.setAttribute("user", userDto);
				return "redirect:/allrecipe";
			} else {
				model.put("failed", "Login Failed");
				return "login";
			}
		} else {
			return "redirect:/recipes";
		}
	}

}
