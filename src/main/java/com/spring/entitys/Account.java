package com.spring.entitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "role")
	private Integer role;
	@Column(name = "trangthai")
	private Integer trangThai;
	

	@OneToMany(mappedBy = "username", fetch = FetchType.LAZY)
	private List<HoaDon> hoaDons;
	@OneToMany(mappedBy = "username", fetch = FetchType.LAZY)
	private List<Cart> carts;

	
}