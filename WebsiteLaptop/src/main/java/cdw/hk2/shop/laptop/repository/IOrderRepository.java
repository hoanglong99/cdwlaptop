package cdw.hk2.shop.laptop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdw.hk2.shop.laptop.model.Order;
import cdw.hk2.shop.laptop.model.User;


@Repository
public interface IOrderRepository extends JpaRepository<Order, String> {
	public List<Order> findAllByUser(User user);
}
