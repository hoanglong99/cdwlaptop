package cdw.hk2.shop.laptop.model;

import java.util.Set;

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
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@Column(name = "enable")
	private Boolean enable;

	@Column(name = "quantity")
	private int quantity;

	public long getTotal() {
		return Math.round(Double.valueOf(product.getPrice() * (100 - product.getDiscount()) / 100) / 10000) * 10000
				* quantity;
	}
}
