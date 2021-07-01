package cdw.hk2.shop.laptop.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cdw.hk2.shop.laptop._enum.ERole;
import cdw.hk2.shop.laptop.dto.AccountDto;
import cdw.hk2.shop.laptop.model.Role;
import cdw.hk2.shop.laptop.model.User;
import cdw.hk2.shop.laptop.repository.IUserRepository;


@Service
public class UserServiceImpl implements IUserService{

	private IUserRepository userRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(AccountDto accountDto) {
		Role roles = new Role(null, ERole.ROLE_USER);
		accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
		accountDto.setRoles(Arrays.asList(roles));
		User user = new User(null, accountDto, null, null, null, null, null, null, null);
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountDto user = getUserByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	
	}
	
	private AccountDto getUserByUsername(String username) {
		List<User> user =userRepository.findAll();
		System.out.println(username);		AccountDto accountDto=null;
		for (User user2:user) {
			if(user2.getAccountDto().getEmail().equals(username)) {
				 accountDto=user2.getAccountDto();
			}
		}
		// TODO Auto-generated method stub
		return accountDto;
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
	}

	public User findUserById(long id) {
		return userRepository.findById(id).orElse(null);
	}

	public User updatePass(String passNew,long id) {
		User userOld= userRepository.findById(id).orElse(null);
		userOld.getAccountDto().setPassword(passNew);;
		return userRepository.save(userOld);
		
	}
	
}
