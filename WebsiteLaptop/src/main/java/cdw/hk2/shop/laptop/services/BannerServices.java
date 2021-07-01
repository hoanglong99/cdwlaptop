package cdw.hk2.shop.laptop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdw.hk2.shop.laptop.model.Banner;
import cdw.hk2.shop.laptop.repository.IBannerRespository;

@Service
public class BannerServices {
	@Autowired
	private IBannerRespository iBannerRespository;

	public List<Banner> findAllBanner() {
		return iBannerRespository.findAll();

	}
}
