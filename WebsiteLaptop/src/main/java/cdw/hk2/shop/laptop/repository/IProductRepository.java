package cdw.hk2.shop.laptop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdw.hk2.shop.laptop.model.Brand;
import cdw.hk2.shop.laptop.model.Category;
import cdw.hk2.shop.laptop.model.Product;



@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
	public List<Product> findByNameContaining(String productName);

	public List<Product> findByNameContainingIgnoreCaseAndPriceBetween(String productName, int priceStart,
			int priceEnd);

	public List<Product> findByBrandAndPriceBetween(Brand brand, int priceStart, int priceEnd);

	public List<Product> findByCategoryAndPriceBetween(Category brand, int priceStart, int priceEnd);

	public List<Product> findByBrandAndCategoryAndPriceBetween(Brand brand, Category category, int priceStart,
			int priceEnd);
}
