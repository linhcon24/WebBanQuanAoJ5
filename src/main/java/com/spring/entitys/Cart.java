package com.spring.entitys;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGioHang;

	@ManyToOne
	@JoinColumn(name = "username")
	private Account username;

	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;

	@JoinColumn(name = "soLuong")
	private Integer soLuong;

	@JoinColumn(name = "donGia")
	private BigDecimal donGia;

	@JoinColumn(name = "kichThuoc")
	private String kichThuoc;

	
	
}
