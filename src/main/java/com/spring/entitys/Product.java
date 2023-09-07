package com.spring.entitys;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
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
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product", nullable = false)
	private Integer id;
	@Column(name = "tieude")
	private String tieuDe;
	@Column(name = "mota")
	private String moTa;
	@Column(name = "image")
	private String anh;
	@Column(name = "gia")
	private BigDecimal gia;
	@Column(name = "giamgia")
	private Integer giamGia;
	@Column(name = "soluong")
	private Integer soLuong;
	@Column(name = "phanloai")
	private String phanLoai;
	@Column(name = "kichthuoc")
	private String kichThuoc;
	@Column(name = "chatlieu")
	private String chatLieu;
	@Column(name = "thietke")
	private String thietKe;
	@Column(name = "trangthai")
	private Integer trangThai;
	

	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;

	
}
