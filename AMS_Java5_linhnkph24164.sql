Create database AMS_Java5_linhnkph24164
go
Use AMS_Java5_linhnkph24164
go

Create table Account(	
	username varchar(10) primary key not null,
	password nvarchar(50),
	email nvarchar(255),
	role int,
	trangthai int

)
create table Category(
	idCategory INT PRIMARY KEY IDENTITY(1,1) not null,
	ten nvarchar(100),
	trangthai int
)
create table Product(
	id_product INT PRIMARY KEY IDENTITY(1,1) not null,
	tieude nvarchar(100),
	image nvarchar(255),
	gia decimal(18,2),
	giamgia decimal(18,2),
	mota nvarchar(255),
	soluong int,
	thietke nvarchar(255),
	kichthuoc nvarchar(50),
	chatlieu nvarchar(255),
	phanloai nvarchar(100),
	trangthai int,
	idCategory INT foreign key references Category(idCategory)
)
drop table Category;

create table HoaDon(
	idHoaDon INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	ngayTao date,
	ngayThanhToan date,
	trangThai int,
	nguoiNhan nvarchar(255),
	diaChi nvarchar(255),
	soDienThoai nvarchar(50),
	username varchar(10) foreign key references Account(username)

)

create table HoaDonChiTiet(
	idHoaDonChiTiet INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	idHoaDon INT FOREIGN KEY REFERENCES HoaDon(idHoaDon),
	id_product INT FOREIGN KEY REFERENCES Product(id_product),
	soLuong int,
	donGia decimal,
	kichThuoc nvarchar(50)

)
create table Cart(
	idGioHang INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	username varchar(10) FOREIGN KEY REFERENCES Account(username),
	id_product INT FOREIGN KEY REFERENCES Product(id_product),
	soLuong int,
	donGia decimal,
	kichThuoc nvarchar(50)
	
)



insert into Account values( N'linhcon24' , '123456' , 'linhnk2000zz@gmail.com', 0)


