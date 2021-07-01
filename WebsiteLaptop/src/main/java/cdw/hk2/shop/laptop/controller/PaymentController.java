package cdw.hk2.shop.laptop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cdw.hk2.shop.laptop.model.AddressOrder;

@Controller
public class PaymentController {
@PostMapping("/thanhtoan")
public String viewPayment(Model model,@ModelAttribute (value = "address_order") AddressOrder addressOrder) {
model.addAttribute("address_order", addressOrder);
model.getAttribute("total");
	return "checkout";
	
}
@PostMapping("/thanhtoandonhang")
public String orderPayment() {
	return"";
}
}
