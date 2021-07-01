package cdw.hk2.shop.laptop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cdw.hk2.shop.laptop.dto.DistrictDto;
import cdw.hk2.shop.laptop.dto.ProvinceDto;
import cdw.hk2.shop.laptop.dto.VillageDto;
import cdw.hk2.shop.laptop.dto.WardDto;
import cdw.hk2.shop.laptop.model.AddressOrder;
import cdw.hk2.shop.laptop.model.Product;
import cdw.hk2.shop.laptop.services.DistrictServices;
import cdw.hk2.shop.laptop.services.ProductServices;
import cdw.hk2.shop.laptop.services.ProvinceServices;
import cdw.hk2.shop.laptop.services.WardDtoServices;

@Controller
public class ShoppingCartController {
	@Autowired
	private ProductServices pServer;
	@Autowired
	private ProvinceServices prServices;
	@Autowired
	private DistrictServices dServices;
	@Autowired
	private WardDtoServices wardServies;

	@GetMapping("/giohang")
	public String viewCart(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Product> listCart = (List<Product>) session.getAttribute("listProduct");
		int price = pServer.sumPrice(listCart, 5);
		model.addAttribute("amount",1);
		model.addAttribute("shipper", 30000);
		model.addAttribute("total", price);
		AddressOrder ao= new AddressOrder(); 
		System.out.println("sdsds"+price);
		session.setAttribute("listProduct",listCart);
		List<ProvinceDto> listProvince = prServices.findAllProvince();
		List<Product> listOther = pServer.findAllProduct();
		model.addAttribute("listProvince", listProvince);
		model.addAttribute("listOther", listOther);
		model.addAttribute("address_order", ao);
		return "shopping_cart";
	}

	@GetMapping("/chondiachi")
	public String selectAddress(Model model, @RequestParam(value = "Id") String id,
			@RequestParam(value = "IdAddress") String idAddress) {

		if (idAddress.equals("country")) {
			ProvinceDto getAddress = prServices.FindByIdProvince(id);
			List<DistrictDto> list = getAddress.getDistrict();
			model.addAttribute("address", list);
			model.addAttribute("check", "D");

		}

		if (idAddress.equals("district")) {
			DistrictDto getAddress = dServices.findDistrictById(id);
			List<WardDto> list = getAddress.getWard();
			model.addAttribute("address", list);
			model.addAttribute("check", "W");
		}
		if (idAddress.equals("ward")) {
			System.out.println("Village" + id);
			WardDto getAddress = wardServies.findWardByID(id);
			List<VillageDto> list = getAddress.getVillages();
			model.addAttribute("address", list);
			model.addAttribute("check", "V");
		}
		return "fragments/option";
	}

	@GetMapping("/themgiohang")
	public String addProductCart(Model model, HttpServletRequest request) {
		String getID = request.getParameter("ajaxID");
		long id = Long.parseLong(getID);
		HttpSession session = request.getSession();
		Product product = pServer.findByIdProduct(id);
		List<Product> getList = (List<Product>) session.getAttribute("listProduct");
		if (getList != null) {
			model.addAttribute("numbercart", getList.size());
			getList.add(product);
			session.setAttribute("listProduct", getList);
			session.setAttribute("numbercart", getList.size());
		} else {
			List<Product> listProduct = new ArrayList<Product>();
			listProduct.add(product);
			session.setAttribute("listProduct", listProduct);
			session.setAttribute("numbercart", 1);
		}
		return "fragments/cart";
	}

	@GetMapping("/capnhatdonhang")
	public String updatecart(Model model) {
		return null;

	}

}
