
CREATE DATABASE QUANLYNHANVIEN
go
use QUANLYNHANVIEN
CREATE TABLE [dbo].[Logins](
	[id] [int] IDENTITY(1,1) primary key NOT NULL,
	[username] [nvarchar](30) NOT NULL,
	[passwords] [nvarchar](30) NOT NULL,
)
go

CREATE TABLE [dbo].[Nhanvien](
	[ID] [bigint] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[MaNV] [varchar](10) NOT NULL,
	[Hoten] [nvarchar](30) NOT NULL,
	[Gioitinh] [nvarchar](50) NOT NULL,
	[Tuoi] [int] NOT NULL,
	[Luong] [int] NOT NULL,
	[Email] [varchar](30) NOT NULL,
	[Sodienthoai] [varchar](30) NOT NULL,
)
go

insert into Logins values ('User','123');
insert into Logins values ('User1','123');
insert into Logins values ('User2','123');
go

insert into Nhanvien values ('PH01',N'Vũ Nguyên','Nam',19,100000,'nguyenvd@fpt.edu.vn','0321654987');
insert into Nhanvien values ('PH02',N'Lương Công','Nam',19,200000,'congld@fpt.edu.vn','0321654987');
insert into Nhanvien values ('PH03',N'Phạm Hà',N'Nữ',19,300000,'haptth@fpt.edu.vn','0321654987');

