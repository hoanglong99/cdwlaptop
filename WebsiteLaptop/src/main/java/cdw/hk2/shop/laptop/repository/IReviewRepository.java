package cdw.hk2.shop.laptop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdw.hk2.shop.laptop.model.Product;
import cdw.hk2.shop.laptop.model.Review;
import cdw.hk2.shop.laptop.model.User;



@Repository
public interface IReviewRepository extends JpaRepository<Review, Long> {
	public List<Review> findByProduct(Product product);

	public boolean existsByUserAndProduct(User user, Product product);

	public Review findByUser(User user);
}
