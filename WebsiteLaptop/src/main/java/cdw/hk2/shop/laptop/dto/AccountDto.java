package cdw.hk2.shop.laptop.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import cdw.hk2.shop.laptop.model.Role;
import cdw.hk2.shop.laptop.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account",uniqueConstraints = @UniqueConstraint(columnNames = "email"),schema = "cdwebshoplaptop")
public class AccountDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")

	private Long id;

	@Column(nullable = false)
	private String email;

	@JsonIgnore
	private String password;

	@Column(nullable = false)
	private Boolean emailVerified;

	private String providerId;
	@OneToOne(mappedBy = "accountDto")
	private User user;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

}
