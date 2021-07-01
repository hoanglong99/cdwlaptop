package cdw.hk2.shop.laptop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cdw.hk2.shop.laptop._enum.EOrderStatus;
import cdw.hk2.shop.laptop._enum.EPaymentMethod;
import cdw.hk2.shop.laptop._enum.EProductImageTypeDisplay;
import cdw.hk2.shop.laptop.utils.UrlImageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToOne
	@JoinColumn(name = "orderItem_id")
	private OrderItem orderItem;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@Column(name = "created_date")
	private Date createdDate = new Date();

	@Column(name = "name")
	private String name;

	@Column(name = "description", columnDefinition = "text")
	private String description;

	@Column(name = "price")
	private int price;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "discount")
	private int discount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_details_id")
	private ProductDetails details;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<ProductImage> images = new ArrayList<ProductImage>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product")
	private List<Review> reviews = new ArrayList<Review>();

	public String getUrlOfficalImage() {
		UrlImageUtils urlImageUtils = new UrlImageUtils();
		ProductImage imageOfficial = images.stream()
				.filter(image -> image.getType() == EProductImageTypeDisplay.Official).findAny().orElseGet(null);

		return urlImageUtils.buildPathWithName(imageOfficial.getName());
	}

}