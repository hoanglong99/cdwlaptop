package cdw.hk2.shop.laptop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdw.hk2.shop.laptop.model.Brand;
import cdw.hk2.shop.laptop.repository.IBrandRepository;
@Service
public class BrandServices {
	@Autowired
	private IBrandRepository iBrandRepository;

	public List<Brand> findAllBrand() {

		return iBrandRepository.findAll();

	}

}
