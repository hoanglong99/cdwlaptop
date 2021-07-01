package cdw.hk2.shop.laptop.utils;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cdw.hk2.shop.laptop._enum.EOrderStatus;
import cdw.hk2.shop.laptop._enum.EPaymentMethod;
import cdw.hk2.shop.laptop.model.Order;
import cdw.hk2.shop.laptop.model.OrderItem;
import cdw.hk2.shop.laptop.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
public class UrlImageUtils {
	public UrlImageUtils() {
		// TODO Auto-generated constructor stub
	}

	public String buildPathWithName(String fileName) {
		if (fileName.isEmpty()) {
			return null;
		}
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(fileName).toUriString();
	}
}
