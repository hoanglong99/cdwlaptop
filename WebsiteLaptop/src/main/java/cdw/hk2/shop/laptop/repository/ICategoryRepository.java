package cdw.hk2.shop.laptop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdw.hk2.shop.laptop.model.Category;
import cdw.hk2.shop.laptop.model.Product;


@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
