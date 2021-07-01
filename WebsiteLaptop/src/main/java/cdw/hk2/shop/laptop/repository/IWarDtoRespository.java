package cdw.hk2.shop.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdw.hk2.shop.laptop.dto.WardDto;
@Repository
public interface IWarDtoRespository extends JpaRepository<WardDto, String> {

}
