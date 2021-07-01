package cdw.hk2.shop.laptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cdw.hk2.shop.laptop.model.Product;
import cdw.hk2.shop.laptop.services.ProductServices;

@Controller
public class ProductController {
	@Autowired
	private ProductServices pServer;

	@GetMapping("sanpham/{id}")
	public String getViewProduct(Model model, @PathVariable(value = "id") String value) {
		long id=Long.parseLong(value);
		System.out.println("long"+value);
		Product getProduct=pServer.findByIdProduct(id);
		List<Product> listProductRelated = pServer.findALLByProductRelated(getProduct);
		List<Product> listProduct=pServer.findAllProduct();
		model.addAttribute("getProduct",getProduct);
		model.addAttribute("productRelated",listProductRelated);
		model.addAttribute("listProduct", listProduct);
		return "/product_detail";
	}
	@GetMapping("/sanpham")
	private String viewAllProduct(Model model) {
		
	return	findPaginated(1, "price", "asc", model)		;
	}
	@GetMapping("sanpham/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 10;
		
		Page<Product> page = pServer.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Product> listProduct = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listProduct", listProduct);
		return "product";
	}
}
