﻿CREATE DATABASE EduSys
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
)
GO

--insert into chuyende values (?, ?, ?, ?, ?, ?)
select * from chuyende

CREATE TABLE NhanVien
(
	MaNV NVARCHAR(50) NOT NULL PRIMARY KEY,
	MatKhau NVARCHAR(50) NOT NULL,
	Hoten NVARCHAR(50) NOT NULL,
	VaiTro bit NOT NULL,
)
GO

insert into NhanVien values('1', '1', N'Trần Minh Sáng', 0)
update NhanVien set MatKhau = '123' where manv = N'Sáng'
select * from nhanvien

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
	FOREIGN KEY(MaCD) REFERENCES dbo.ChuyenDe(MaCD) ON UPDATE CASCADE ON DELETE NO ACTION,
	FOREIGN KEY(MaNV) REFERENCES dbo.NhanVien(MaNV) ON UPDATE CASCADE ON DELETE NO ACTION,
)
GO

insert into khoahoc(macd, hocphi, thoiluong, ngaykg, ghichu, manv) values (1, 2, 2, '20200302', 'a', 1)
delete from khoahoc
select * from khoahoc

CREATE TABLE NguoiHoc
(
	MaNH INT IDENTITY(1,1) PRIMARY KEY,
	Hoten NVARCHAR(50) NOT NULL,
	NgaySinh DATETIME NOT NULL,
	GioiTinh bit NOT NULL,
	DienThoai VARCHAR(10),
	Email NVARCHAR(50) NOT NULL,
	GhiChu NVARCHAR(200) NULL,
	MaNV NVARCHAR(50) NOT NULL,
	NgayDK DATETIME,
	FOREIGN KEY(MaNV) REFERENCES dbo.NhanVien(MaNV) ON UPDATE CASCADE ON DELETE NO ACTION,
)
go

CREATE TABLE HocVien
(
	MaHV INT IDENTITY(1,1) PRIMARY KEY,
	MaKH INT NOT NULL,
	MaNH INT NOT NULL,
	Diem float NOT NULL,
	FOREIGN KEY(MaKH) REFERENCES dbo.KhoaHoc(MaKH) ON DELETE NO ACTION,
	FOREIGN KEY(MaNH) REFERENCES dbo.NguoiHoc(MaNH) ON DELETE NO ACTION ON UPDATE CASCADE,
)
GO


select * from nhanvien
select * from chuyende
select * from khoahoc
select * from hocvien
select * from nguoihoc