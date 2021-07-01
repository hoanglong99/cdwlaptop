package cdw.hk2.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdw.hk2.shop.laptop.model.Brand;


@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {

}
