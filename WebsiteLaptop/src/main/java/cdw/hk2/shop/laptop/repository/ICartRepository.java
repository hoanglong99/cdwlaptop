package cdw.hk2.shop.laptop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdw.hk2.shop.laptop.model.Cart;


@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
	
}
