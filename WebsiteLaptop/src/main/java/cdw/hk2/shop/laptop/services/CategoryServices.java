package cdw.hk2.shop.laptop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdw.hk2.shop.laptop.model.Category;
import cdw.hk2.shop.laptop.repository.ICategoryRepository;

@Service
public class CategoryServices {
	@Autowired
	private ICategoryRepository iCategoryRepository;

	public List<Category> findAllCategory() {
		return iCategoryRepository.findAll();

	}

}
