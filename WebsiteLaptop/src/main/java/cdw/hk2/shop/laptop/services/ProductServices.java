package cdw.hk2.shop.laptop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cdw.hk2.shop.laptop.model.Product;
import cdw.hk2.shop.laptop.model.ProductDetails;
import cdw.hk2.shop.laptop.repository.IProductRepository;

@Service
public class ProductServices implements IProductServices {
	@Autowired
	private IProductRepository ipRes;

	// Select
	public Product findByIdProduct(long id) {
		return ipRes.findById(id).orElse(null);
	}

	public List<Product> findAllProduct() {
		return ipRes.findAll();
	}

	public List<Product> findAllByIdProduct(Iterable<Long> id) {
		return ipRes.findAllById(id);

	}

	// Delete
	public String deleteByIdProduct(long id) {
		ipRes.deleteById(id);
		return "deteleID";
	}

	public String deleteByProduct(Product product) {
		ipRes.delete(product);
		return "deteleProduct";
	}

	public String deteleAllByID(Iterable<Long> id) {
		ipRes.deleteAllById(id);
		return "deteleAllId";
	}

	public String deteleAll() {
		ipRes.deleteAll();
		return "deteleALL";
	}

	// Save
	public String saveProduct(Product product) {
		ipRes.save(product);
		return "saveProduct";
	}

	public String saveListProduct(List<Product> list) {
		ipRes.saveAll(list);
		return "saveListProduct";
	}

	// Update
	public String updateProduct(Product product) {
		Product exitsGetP = ipRes.findById(product.getId()).orElse(null);
		exitsGetP.setBrand(product.getBrand());
		exitsGetP.setCategory(product.getCategory());
		exitsGetP.setCreatedDate(product.getCreatedDate());
		exitsGetP.setDescription(product.getDescription());
		exitsGetP.setDetails(product.getDetails());
		exitsGetP.setDiscount(product.getDiscount());
		exitsGetP.setImages(product.getImages());
		exitsGetP.setQuantity(product.getQuantity());
		exitsGetP.setReviews(product.getReviews());
		exitsGetP.setUser(product.getUser());
		exitsGetP.setPrice(product.getPrice());
		exitsGetP.setName(product.getName());
		ipRes.save(exitsGetP);
		return "update";

	}

	// List Category
	public List<Product> findAllByCategory(long id) {
		List<Product> listCategory = new ArrayList<Product>();
		List<Product> list = ipRes.findAll();
		for (Product product : list) {
			if (product.getCategory().getId() == id) {
				listCategory.add(product);
			}
		}
		return listCategory;

	}

	// list related product
	public List<Product> findALLByProductRelated(Product product) {
		List<Product> list = ipRes.findAll();
		List<Product> listRelate = new ArrayList<Product>();
		for (Product lProduct : list) {
			if (lProduct.getBrand().getId() == product.getBrand().getId()) {
				listRelate.add(lProduct);
			}
		}

		return listRelate;
	}

	@Override
	public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.ipRes.findAll(pageable);
	}

	public int sumPrice(List<Product> list,int discount) {
		int total = 0;
		for (Product product : list) {
			total = total + product.getPrice();
		}
		return total;
				
	}
}
