package cdw.hk2.shop.laptop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "banner")
public class Banner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category banner;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private ProductImage images;
	@Column(name ="title_price")
	private String title_price;
	@Column (name = "theme_title")
	private String theme_title;
	@Column(name = "slogan")
	private  String slogan;
	
	
	

}
