package com.spring.entitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHoaDon")
	private Integer idHoaDon;

	@ManyToOne
	@JoinColumn(name = "username")
	private Account username;

	@JoinColumn(name = "ngayTao")
	private String ngayTao;

	@JoinColumn(name = "ngayThanhToan")
	private String ngayThanhToan;

	@JoinColumn(name = "trangThai")
	private Integer trangThai;

	@JoinColumn(name = "nguoiNhan")
	private String nguoiNhan;

	@JoinColumn(name = "diaChi")
	private String diaChi;

	@JoinColumn(name = "soDienThoai")
	private String soDienThoai;

	@OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
	private List<HoaDonChiTiet> hdcts;

	
}
