CREATE DATABASE EduSys
GO 

USE EduSys
GO

CREATE TABLE ChuyenDe
(
	MaCD INT IDENTITY(1,1) PRIMARY KEY,
	TenCD NVARCHAR(50) NOT NULL,
	HocPhi MONEY NOT NULL,
	ThoiLuong INT NOT NULL,
	Hinh NVARCHAR(200) NULL,
	Mota NVARCHAR(200) NULL,
	TrangThai bit default(0),
)
GO

--Nhập dữ liệu chuyên đề:

CREATE TABLE NhanVien
(
	MaNV NVARCHAR(50) NOT NULL PRIMARY KEY,
	MatKhau NVARCHAR(50) NOT NULL,
	Hoten NVARCHAR(50) NOT NULL,
	Email NVARCHAR(50) NOT NULL,
	VaiTro bit NOT NULL,
	TrangThai bit default(0),
)
GO

CREATE TABLE KhoaHoc
(
	MaKH INT IDENTITY(1,1) PRIMARY KEY,
	MaCD INT NOT NULL,
	HocPhi MONEY NOT NULL,
	ThoiLuong INT NOT NULL,
	NgayKG DATETIME NOT NULL,
	GhiChu NVARCHAR(200) NULL,
	NgayTao DATETIME DEFAULT GETDATE() NOT NULL,
	MaNV NVARCHAR(50) NOT NULL,
	TrangThai bit default(0),
	FOREIGN KEY(MaCD) REFERENCES dbo.ChuyenDe(MaCD) ON UPDATE CASCADE ON DELETE NO ACTION,
	FOREIGN KEY(MaNV) REFERENCES dbo.NhanVien(MaNV) ON UPDATE CASCADE ON DELETE NO ACTION,
)
GO

CREATE TABLE NguoiHoc
(
	MaNH INT IDENTITY(1,1) PRIMARY KEY,
	Hoten NVARCHAR(50) NOT NULL,
	NgaySinh DATETIME NOT NULL,
	GioiTinh bit NOT NULL,
	DienThoai VARCHAR(10) not null,
	Email NVARCHAR(50) NOT NULL,
	GhiChu NVARCHAR(200) NULL,
	MaNV NVARCHAR(50),
	NgayDK DATETIME not null,
	TrangThai bit default(0),
	FOREIGN KEY(MaNV) REFERENCES dbo.NhanVien(MaNV) ON UPDATE CASCADE ON DELETE NO ACTION,
)
go


CREATE TABLE HocVien
(
	MaHV INT IDENTITY(1,1) PRIMARY KEY,
	MaKH INT NOT NULL,
	MaNH INT NOT NULL,
	Diem float NOT NULL,
	TrangThai bit default(0),
	FOREIGN KEY(MaKH) REFERENCES dbo.KhoaHoc(MaKH) ON DELETE NO ACTION,
	FOREIGN KEY(MaNH) REFERENCES dbo.NguoiHoc(MaNH) ON DELETE NO ACTION ON UPDATE CASCADE,
)
GO

--insert into nhanvien values ( '3','1','1', 1)
select * from nhanvien where trangthai = 0
select * from nhanvien
delete from nhanvien
--update nhanvien set manv = 'sangsakerquy' where trangthai = 0 
insert into NhanVien values('thaohocdot','123456','thaoongvang','thaocnph13274@fpt.edu.vn',0,0)
insert into NhanVien values('admin','admin','admin','admin@fpt.edu.vn',0,0)
select * from chuyende
select * from hocvien
select * from nguoihoc
select * from khoahoc
--update NhanVien set MatKhau =1 where MaNV='thaohocdot'
--update NhanVien set MatKhau =? where Email=?