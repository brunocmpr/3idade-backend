package com.campera.app3idade.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
public class AppUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)  @Getter @Setter
	private Long id;
	@Getter @Setter
	private String firstName;
	@Getter @Setter
	private String lastName;
	@Getter @Setter
	private String countryCode;
	@Getter @Setter
	private String areaCode;
	@Getter @Setter
	private String phoneNumber;
	@Getter	@Setter
	private String email;
	@Setter
	private String hashedPassword;
	@Transient  @Setter
	private String rawPassword;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Authority> authorityList = new ArrayList<Authority>();

	public AppUser(String firstName, String lastName, String countryCode, String areaCode, String phoneNumber,
				   String email, String hashedPassword){
		this.firstName = firstName;
		this.lastName = lastName;
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.hashedPassword = hashedPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorityList;
	}
	public String getPassword() {
		return this.hashedPassword;
	}
	@Override
	public String getUsername() {
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() { return true; }
	@Override
	public boolean isAccountNonLocked() { return true; }
	@Override
	public boolean isCredentialsNonExpired() { return true;	}
	@Override
	public boolean isEnabled() { return true; }

}
