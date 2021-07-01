package cdw.hk2.shop.laptop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdw.hk2.shop.laptop._enum.EProductImageTypeDisplay;
import cdw.hk2.shop.laptop.model.Product;
import cdw.hk2.shop.laptop.model.ProductImage;



@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage, Long> {
	public List<ProductImage> findByProduct(Product product);

	public List<ProductImage> findByProductAndType(Product product, EProductImageTypeDisplay type);

	public Optional<ProductImage> findFirstByProductAndType(Product product, EProductImageTypeDisplay type);

}
