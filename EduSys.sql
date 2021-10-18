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

select * from KhoaHoc
CREATE TABLE LsKhoaHoc
(
	Mals INT IDENTITY(1,1) PRIMARY KEY,
	MaKH INT  NULL,	
	MaNV NVARCHAR(50) NOT NULL,
	Ngaythuchien DATETIME DEFAULT GETDATE() NOT NULL,
	mota NVARCHAR(200) NULL,
	TrangThai bit default(0),
	FOREIGN KEY(MaKH) REFERENCES dbo.KhoaHoc(MaKH) ON UPDATE CASCADE ON DELETE NO ACTION,
	
)
GO

insert into LsKhoaHoc (MaKH,MaNV,mota,TrangThai) values(?,?,?,0)

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
insert into NhanVien values('sang','sang','sang','sangtm2612@gmail.com',0,0)
insert into NhanVien values('1','1','sang','sangtm2612@gmail.com',0,0)

SELECT COUNT(ChuyenDe.MaCD) FROM dbo.KhoaHoc 
JOIN dbo.ChuyenDe ON ChuyenDe.MaCD = KhoaHoc.MaCD 
WHERE ChuyenDe.TrangThai = 0 AND KhoaHoc.TrangThai = 0 AND ChuyenDe.MaCD = ?

select * from LsKhoaHoc tr
select * from LsKhoaHoc where trangthai = 0
select * from chuyende
select * from hocvien
select * from nguoihoc
--select * from khoahoc join chuyende on chuyende.macd = khoahoc.macd where khoahoc.trangthai = 0 and chuyende.trangthai = 0 and chuyende.macd = ?
--update NhanVien set MatKhau =1 where MaNV='thaohocdot'
--update NhanVien set MatKhau =? where Email=?

select tencd, ngaykg from khoahoc join chuyende on chuyende.macd = khoahoc.macd





select tencd, ngaykg, makh from khoahoc join chuyende on chuyende.macd = khoahoc.macd WHERE dbo.KhoaHoc.TrangThai = 0

SELECT HocVien.MaNH, hoten, diem, IIF(diem>=9, N'Xuất sắc', IIF(diem>=8, N'Giỏi', IIF(diem>=6.5, N'Khá', IIF(diem >= 5, N'Trung bình', N'Yếu')))) AS xeploai FROM dbo.HocVien JOIN dbo.NguoiHoc ON NguoiHoc.MaNH = HocVien.MaNH WHERE MaKH = ?

SELECT * FROM dbo.NguoiHoc
SELECT * FROM dbo.HocVien
SELECT * FROM dbo.NguoiHoc

select year(ngaydk)as Nam,count(maNH) as SoLuong, MIN(ngayDK), MAX(ngayDK) from NguoiHoc GROUP by year(ngaydk)
select TenCD, count(mahv),max(diem),min(diem),CONVERT(decimal(8,2),avg(diem),0) from ChuyenDe join KhoaHoc on ChuyenDe.MaCD = KhoaHoc.MaCD join HocVien on HocVien.MaKH = KhoaHoc.MaKH group by TenCD

SELECT TenCD,count(ChuyenDe.MaCD),count(mahv),sum(khoahoc.hocphi),max(khoahoc.HocPhi),min(khoahoc.hocphi),year(ngaytao) 
FROM ChuyenDe join KhoaHoc on ChuyenDe.MaCD = KhoaHoc.MaCD
JOIN HocVien on HocVien.MaKH = KhoaHoc.MaKH
GROUP by TenCD,year(ngaytao)
HAVING year(ngaytao) = ?

SELECT DISTINCT YEAR(NgayDK) FROM dbo.NguoiHoc

SELECT TenCD,count(ChuyenDe.MaCD),count(mahv),sum(khoahoc.hocphi),max(khoahoc.HocPhi),min(khoahoc.hocphi),year(ngaytao)
FROM ChuyenDe join KhoaHoc on ChuyenDe.MaCD = KhoaHoc.MaCD
JOIN HocVien on HocVien.MaKH = KhoaHoc.MaKH
GROUP by TenCD,year(ngaytao)
HAVING year(ngaytao) = 2021
