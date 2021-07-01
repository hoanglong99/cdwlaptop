package cdw.hk2.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdw.hk2.shop.laptop.model.OrderItem;


@Repository
public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {

}
