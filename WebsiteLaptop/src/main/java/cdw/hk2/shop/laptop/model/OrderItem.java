package cdw.hk2.shop.laptop.model;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders_items")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.ALL)
	private List<Product> product= new ArrayList<Product>();

	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private int price;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "total")
	private long total;

	
	
}
