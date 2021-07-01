package cdw.hk2.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cdw.hk2.shop.laptop.dto.AccountDto;
import cdw.hk2.shop.laptop.model.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

}
