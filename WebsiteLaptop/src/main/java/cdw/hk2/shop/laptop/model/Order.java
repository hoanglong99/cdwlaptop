package cdw.hk2.shop.laptop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import cdw.hk2.shop.laptop._enum.EOrderStatus;
import cdw.hk2.shop.laptop._enum.EPaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EOrderStatus status;

	@Column(name = "settled")
	private Boolean settled = false;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method")
	private EPaymentMethod paymentMethod;
	@Column(name = "stripeChagreId")
	private String stripeChagreId;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "updated_date")
	private Date updatedDate;

}