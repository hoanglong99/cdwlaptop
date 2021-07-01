package cdw.hk2.shop.laptop.controller;

import java.util.List;

import org.hibernate.service.internal.ProvidedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cdw.hk2.shop.laptop.dto.ProvinceDto;
import cdw.hk2.shop.laptop.model.Information;
import cdw.hk2.shop.laptop.model.User;
import cdw.hk2.shop.laptop.services.ProvinceServices;
import cdw.hk2.shop.laptop.services.UserServiceImpl;

@Controller
public class ProfileController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private ProvinceServices providedS;
	@Autowired
	private BCryptPasswordEncoder pass;

	@RequestMapping(path = "/account/profile", method = RequestMethod.GET)
	public String profileView(Model model) {
		User user = userServiceImpl.findUserById(3);
		model.addAttribute("informations", user.getInformation());
		List<ProvinceDto> listProvince = providedS.findAllProvince();
		model.addAttribute("listProvince", listProvince);
		model.addAttribute("users", user);

		return "/account/index";

	}

	@RequestMapping(path = "/update/profile", method = RequestMethod.POST)
	public String updateProfile(Model model, @ModelAttribute(name = "informations") Information infor) {

		return "/account/index";

	}

	@RequestMapping(value = "/account/profile/change/pass",method = RequestMethod.POST)
	public  String  changePass(Model model, @RequestParam(value = "password_old") String password_old,
			@RequestParam(value = "password_new") String password_new) {
		String passEncode = pass.encode(password_old);
		String passUser = userServiceImpl.findUserById(3).getAccountDto().getPassword();
		boolean response;
		User user = userServiceImpl.findUserById(3);
		model.addAttribute("informations", user.getInformation());
		List<ProvinceDto> listProvince = providedS.findAllProvince();
		model.addAttribute("listProvince", listProvince);
		model.addAttribute("users", user);

		if (passEncode.equals(passUser)) {
			String passNew = pass.encode(password_new);
			userServiceImpl.updatePass(passNew, 3);
			response = false;
		} else {
			response = true;
		}
		return "TRUE";
	}

}
