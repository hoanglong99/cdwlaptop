package cdw.hk2.shop.laptop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cdw.hk2.shop.laptop.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private AccountDto accountDto ;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "infor_id")
	private Information information;

	@OneToMany(mappedBy = "user", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Product> products = new ArrayList<Product>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Review> reviews = new ArrayList<Review>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<Order>();
	@Column(name = "avatarUrl")
	private String avatarUrl;

}
