package cdw.hk2.shop.laptop.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cdw.hk2.shop.laptop._enum.EOrderStatus;
import cdw.hk2.shop.laptop._enum.EPaymentMethod;
import cdw.hk2.shop.laptop._enum.EProductImageTypeDisplay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product_images")
public class ProductImage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private EProductImageTypeDisplay type;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

}