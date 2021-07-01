package cdw.hk2.shop.laptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import cdw.hk2.shop.laptop.model.Banner;
import cdw.hk2.shop.laptop.model.Product;
import cdw.hk2.shop.laptop.services.BannerServices;
import cdw.hk2.shop.laptop.services.ProductServices;

@Controller
public class HomeController {
	@Autowired 
	private ProductServices productServices;
	@Autowired 
	private BannerServices bannerS;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeView(Model model) {
		List<Product> listProducts= productServices.findAllProduct();
		model.addAttribute("listproduct",listProducts);
		List<Product> listTop= productServices.findAllByCategory(0);
		List<Banner> listBannerns=bannerS.findAllBanner();
		model.addAttribute("listBanner",listBannerns);
		return "index";
	}
}
