package com.journaldev.spring;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.openhmis.exception.oauth2.UnableToAuthorizeException;
import org.openhmis.service.AuthenticateManager;
import org.openhmis.service.impl.AuthenticateManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.journaldev.spring.model.UserInfo;
import com.journaldev.spring.service.UserService;

@Controller
public class UserInfoController {

	private final static Logger log = Logger
			.getLogger(UserInfoController.class);

	@Autowired
	private UserService userService;

	private AuthenticateManager authenticateManager;

	public UserInfoController() {
		authenticateManager = new AuthenticateManagerImpl();
	}

	public void setUserService(UserService userService) {
		System.out.println("User Servie : " + userService);

		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {
		log.info("Login Action Begin");
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("password");
		log.info("Login Action End");
		return "login";

	}

	@RequestMapping(value = "/temp_login", method = RequestMethod.POST)
	public String ClientSearch(@RequestParam("j_username") String username,
			@RequestParam("j_password") String password, Model model,
			HttpServletRequest request) throws UnableToAuthorizeException {
		log.info("Temp Login Action Begin");

		List<UserInfo> user_info_list = (List<UserInfo>) this.userService
				.LoginUser(username, password);
		if (user_info_list.size() != 0) {
			System.out.println("User Availble");
			request.getSession().setAttribute("username",
					user_info_list.get(0).getUserId());
			request.getSession().setAttribute("password",
					user_info_list.get(0).getPasswordEnc());

			String pass_password = password + "@developer.gserviceaccount.com";
			boolean isAuthenticate = authenticateManager.authenticateUser(
					username, pass_password);
			if(isAuthenticate){
				log.info("Temp Login Action End");
				return "success";
			}else{
				log.info("Temp Login Action End");
				return "redirect:/login";
			}
		}else {
			request.getSession().removeAttribute("username");
			request.getSession().removeAttribute("password");
			model.addAttribute("error_message","Invalid User");
			System.out.println("User not  Availble");
			log.info("Temp Login Action End");
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(Model model, HttpServletRequest request) {
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("password");
		return "redirect:/login";
	}

}
