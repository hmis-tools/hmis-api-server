package com.innoppl.intake;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.innoppl.intake.model.ClientDetailVO;
import com.innoppl.intake.model.ClientVO;
import com.innoppl.intake.model.EthnicityVO;
import com.innoppl.intake.model.GenderVO;
import com.innoppl.intake.model.UserInfo;
import com.innoppl.intake.service.UserService;

/*
 * @author  Haridharan Durairaj
 * 
 */
@Controller
public class UserInfoController {

	private final static Logger log = Logger
			.getLogger(UserInfoController.class);

	@Autowired
	private UserService userService;

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
			HttpServletRequest request) {
		log.info("Temp Login Action Begin");

		List<UserInfo> user_info_list = (List<UserInfo>) this.userService
				.LoginUser(username, password);
		if (user_info_list.size() != 0) {
			System.out.println("User Availble");
			request.getSession().setAttribute("username",
					user_info_list.get(0).getUserId());
			request.getSession().setAttribute("password",
					user_info_list.get(0).getPasswordEnc());
			log.info("Temp Login Action End");
			return "search";
		} else {
			request.getSession().removeAttribute("username");
			request.getSession().removeAttribute("password");
			System.out.println("User not  Availble");
			model.addAttribute("error_message", "Invalid User");
			log.info("Temp Login Action End");
			return "login";
		}

	}

	@RequestMapping(value = "clients/lastName", method = RequestMethod.GET)
	public String ClientList(@RequestParam("firstName") String firstName,
			Model model, HttpServletRequest request) {
		log.info("Client/lastNmae  Action Begin..");
		if (request.getSession().getAttribute("username") == null) {
			log.info("Client/lastNmae  Action End..");
			return "redirect:/login";
		} else {
			List<ClientVO> cl = new ArrayList<ClientVO>();
			try {
				String xml = null;
				xml = getHTML("http://" + request.getServerName() + ":"
						+ request.getServerPort()
						+ "/OpenHMIS-master/services/clients/lastName/"
						+ firstName + "/"
						+ request.getSession().getAttribute("username") + "/"
						+ request.getSession().getAttribute("password"));
				if(xml==null || xml.isEmpty()){
					throw new NullPointerException();
				}
				Document doc = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder()
						.parse(new InputSource(new StringReader(xml)));
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("clientVO");
				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;

						cl.add(new ClientVO(Long.valueOf(eElement
								.getElementsByTagName("clientKey").item(0)
								.getTextContent()), "", eElement
								.getElementsByTagName("nameLast").item(0)
								.getTextContent(), eElement
								.getElementsByTagName("nameFirst").item(0)
								.getTextContent(), eElement
								.getElementsByTagName("socSecNumber").item(0)
								.getTextContent(), eElement
								.getElementsByTagName("dateOfBirth").item(0)
								.getTextContent()));

					}
				}
			} catch (NullPointerException null_ex) {
				System.out.println("response xml could not found ..."
						+ null_ex.getMessage());
			} catch (Exception other_ex) {
				System.out
						.println("Web Service Server down :Please try later sometime..."
								+ other_ex.getMessage());
			}

			log.info("Searched by " + firstName
					+ " , Available User List is  : " + cl.size());
			model.addAttribute("clientList", cl);
			log.info("Client/lastNmae  Action End..");
		}
		return "result";

	}

	@RequestMapping("clients/clientdetail/{clientKey}")
	public String ClientDetailsInfo(@PathVariable("clientKey") Long clientKey,
			Model model, HttpServletRequest request) {
		log.info("clients/clientdetail/{clientKey}  Action Begin..");
		if (request.getSession().getAttribute("username") == null) {
			log.info("clients/clientdetail/{clientKey}  Action End..");
			return "redirect:/login";
		} else {
			try {
				String xml = null;
				xml = getHTML("http://" + request.getServerName() + ":"
						+ request.getServerPort()
						+ "/OpenHMIS-master/services/clients/clientdetail/"
						+ clientKey + "/"
						+ request.getSession().getAttribute("username") + "/"
						+ request.getSession().getAttribute("password"));
				if(xml==null || xml.isEmpty()){
					throw new NullPointerException();
				}
				Document doc = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder()
						.parse(new InputSource(new StringReader(xml)));
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("clientDetailVO");
				log.info("clientDetailVO Iteration Strat Here..");
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						ClientDetailVO cdvo = new ClientDetailVO();
						cdvo.setClientKey(Long.valueOf(eElement
								.getElementsByTagName("clientKey").item(0)
								.getTextContent()));
						cdvo.setNameLast(eElement
								.getElementsByTagName("nameLast").item(0)
								.getTextContent());
						cdvo.setNameFirst(eElement
								.getElementsByTagName("nameFirst").item(0)
								.getTextContent());
						cdvo.setNameMiddle("");
						cdvo.setDateOfBirth(eElement
								.getElementsByTagName("dateOfBirth").item(0)
								.getTextContent());
						cdvo.setSocSecNumber(eElement
								.getElementsByTagName("socSecNumber").item(0)
								.getTextContent());
						NodeList innernList = eElement
								.getElementsByTagName("ethnicityVO");
						Element innerElement = (Element) innernList.item(0);

						cdvo.setSocSecTypeCode(Integer.parseInt(eElement
								.getElementsByTagName("socSecTypeCode").item(0)
								.getTextContent()));
						cdvo.setSocSecTypeCode(Integer.parseInt(eElement
								.getElementsByTagName("socSecTypeCode").item(0)
								.getTextContent()));

						cdvo.setVeteranStatusGct(Integer.parseInt(eElement
								.getElementsByTagName("recActiveGct").item(0)
								.getTextContent()));
						cdvo.setRecActiveGct(Integer.parseInt(eElement
								.getElementsByTagName("recActiveGct").item(0)
								.getTextContent()));
						cdvo.setEntryDateTime(eElement
								.getElementsByTagName("entryDateTime").item(0)
								.getTextContent());
						cdvo.setLogDateTime(eElement
								.getElementsByTagName("logDateTime").item(0)
								.getTextContent());
						cdvo.setLogUserKey(Long.valueOf(eElement
								.getElementsByTagName("logUserKey").item(0)
								.getTextContent()));
						cdvo.setEntryUserKey(Long.valueOf("123"));
						try {
							EthnicityVO ev = new EthnicityVO(
									Integer.parseInt(innerElement
											.getElementsByTagName("codeKey")
											.item(0).getTextContent()),
									innerElement
											.getElementsByTagName("description")
											.item(0).getTextContent(), "", "",
									Integer.parseInt(eElement
											.getElementsByTagName(
													"recActiveGct").item(0)
											.getTextContent()), "",
									Long.valueOf(eElement
											.getElementsByTagName("logUserKey")
											.item(0).getTextContent()));
							cdvo.setEthnicityVO(ev);
						} catch (NullPointerException null_ex) {
							System.out.println(" Null Pointer Exception : "
									+ null_ex.getMessage());
						}
						try {
							NodeList myinnerList = eElement
									.getElementsByTagName("genderVO");
							Element myinnerElement = (Element) myinnerList
									.item(0);

							GenderVO genderVO = new GenderVO(
									Integer.parseInt(myinnerElement
											.getElementsByTagName("codeKey")
											.item(0).getTextContent()), "", "",
									"", Integer.parseInt(myinnerElement
											.getElementsByTagName(
													"recActiveGct").item(0)
											.getTextContent()), "",
									Long.valueOf(eElement
											.getElementsByTagName("logUserKey")
											.item(0).getTextContent()));
							cdvo.setGenderVO(genderVO);
						} catch (NullPointerException null_ex) {

							System.out.println(" Null Pointer Exception : "
									+ null_ex.getMessage());
						}

						model.addAttribute("clientList", cdvo);
					} else {
						log.info("Node cannot found");

					}

				}
				log.info("clientDetailVO Iteration Strat Here..");
			} catch (NullPointerException null_ex) {
				System.out.println("response xml could not found ..."
						+ null_ex.getMessage());
			} catch (Exception other_ex) {
				System.out
						.println("Web Service Server down :Please try later sometime..."
								+ other_ex.getMessage());
			}
			log.info("clients/clientdetail/{clientKey}  Action End..");
		}
		return "client_details";
	}

	public String getHTML(String urlToRead) {
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader rd = null;
		String line = null;
		String result = "";
		try {
			url = new URL(urlToRead);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			rd.close();
		} catch (FileNotFoundException file_not_found_ex) {
			System.out
			.println("Webservice Server down ..Please try again later.(Reading URL is Problem)."
					+ file_not_found_ex.getMessage());
}
		catch (IOException io_ex) {
			System.out
					.println("File IO Exception occured while  reading  file( failed or interrupted) : "
							+ io_ex.getMessage());
		} catch (Exception all_ex) {
			System.out.println("Error due to  : " + all_ex.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(Model model, HttpServletRequest request) {
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("password");
		return "redirect:/login";
	}

}
