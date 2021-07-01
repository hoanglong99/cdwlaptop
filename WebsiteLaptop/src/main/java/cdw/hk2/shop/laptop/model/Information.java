package cdw.hk2.shop.laptop.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "informations")
public class Information {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "phone")
	private String phone;
	@Column(name = "country")
	private String country;
	@Column(name = "dateBrithday")
	private Date dateBrithday;
	@Column(name = "sex")
	private String sex;
	@Column(name = "company")
	private String company;
	@Column(name = "province")
	private String province;
	@Column(name = "district")
	private String district;
	@Column(name = "ward")
	private String ward;
	@Column(name = "village")
	private String village;
	@Column(name = "note")
	private String note;

	@OneToOne(mappedBy = "information")
	private User user;

}
