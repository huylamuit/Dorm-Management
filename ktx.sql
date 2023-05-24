Create database QuanLyKTX;
use QuanLyKTX;

create table truongtoa(
	MaTT char(6) PRIMARY KEY,
    PASSWORD VARCHAR(20),
    CCCD VARCHAR(12),
    TEN VARCHAR(40),
    NGAYSINH DATE,
    DIACHI VARCHAR(40),
    TOA char(3)
);


create table ketoan(
	MaKT char(6) PRIMARY KEY,
    PASSWORD VARCHAR(20),
    CCCD VARCHAR(12),
    TEN VARCHAR(40),
    NGAYSINH DATE,
    DIACHI VARCHAR(40)
);

insert into ketoan values('kt0001','1','012344421144','long dep trai','1989-12-08','ktx khu a');
insert into truongtoa
values('tt0','','','','','');
insert into truongtoa value ('tt0001','123456','2052139134','lam huy','2002-10-10','66/141','a18');

create table sinhvien(
	MASV char(6) PRIMARY KEY,
    PASSWORD VARCHAR(20),
    CCCD VARCHAR(12),
    TEN VARCHAR(40),
    NGAYSINH DATE,
    DIACHI VARCHAR(40),
    TRUONG VARCHAR(40),
    TOA CHAR(3),
	PHONG char(3),
    SoDT char(10)
);
alter table sinhvien
add sodt char(10);
CREATE TABLE PHONG(
	MAPHONG char(3) primary key,
    LOAIPHONG INT(1),
    GIATIEN BIGINT,
    MATOA char(3)
);

insert into phong value('101','8','100000','a18');
insert into phong value('102','8','100000','a18');
insert into phong value('103','8','100000','a18');
insert into phong value('104','8','100000','a18');
insert into phong value('105','8','100000','a18');
insert into phong value('106','8','100000','a18');
insert into phong value('107','8','100000','a18');
insert into phong value('108','8','100000','a18');
insert into phong value('109','8','100000','a18');
insert into phong value('110','8','100000','a18');
insert into phong value('111','8','100000','a18');
insert into phong value('112','8','100000','a18');
insert into phong value('113','8','100000','a18');
insert into phong value('114','8','100000','a18');
insert into phong value('115','8','100000','a18');

insert into phong value('201','8','100000','a18');
insert into phong value('202','8','100000','a18');
insert into phong value('203','8','100000','a18');
insert into phong value('204','8','100000','a18');
insert into phong value('205','8','100000','a18');
insert into phong value('206','8','100000','a18');
insert into phong value('207','8','100000','a18');
insert into phong value('208','8','100000','a18');
insert into phong value('209','8','100000','a18');
insert into phong value('210','8','100000','a18');
insert into phong value('211','8','100000','a18');
insert into phong value('212','8','100000','a18');
insert into phong value('213','8','100000','a18');
insert into phong value('214','8','100000','a18');
insert into phong value('215','8','100000','a18');

insert into phong value('301','8','100000','a18');
insert into phong value('302','8','100000','a18');
insert into phong value('303','8','100000','a18');
insert into phong value('304','8','100000','a18');
insert into phong value('305','8','100000','a18');
insert into phong value('306','8','100000','a18');
insert into phong value('307','8','100000','a18');
insert into phong value('308','8','100000','a18');
insert into phong value('309','8','100000','a18');
insert into phong value('310','8','100000','a18');
insert into phong value('311','8','100000','a18');
insert into phong value('312','8','100000','a18');
insert into phong value('313','8','100000','a18');
insert into phong value('314','8','100000','a18');
insert into phong value('315','8','100000','a18');

insert into phong value('401','8','100000','a18');
insert into phong value('402','8','100000','a18');
insert into phong value('403','8','100000','a18');
insert into phong value('404','8','100000','a18');
insert into phong value('405','8','100000','a18');
insert into phong value('406','8','100000','a18');
insert into phong value('407','8','100000','a18');
insert into phong value('408','8','100000','a18');
insert into phong value('409','8','100000','a18');
insert into phong value('410','8','100000','a18');
insert into phong value('411','8','100000','a18');
insert into phong value('412','8','100000','a18');
insert into phong value('413','8','100000','a18');
insert into phong value('414','8','100000','a18');
insert into phong value('415','8','100000','a18');

CREATE TABLE TOA(
	MATOA char(3) primary key,
    TENTOA VARCHAR(2),
    SLPHONG INT,
    SLPHONGTRONG INT,
    MaTruongToa char(6)
);
select * from phong where matoa = 'a18' and maphong like '%1%';

insert into toa value ('a18','ag','15','3','tt0001');
select * from toa;

create table luutru(
	MALT CHAR(6) PRIMARY KEY,
    MASV VARCHAR(6),
    PHONG char(3),
    TOA char(3),
    NGTHUE DATE,
    NGKETTHUC DATE,
    THANHTOAN BOOLEAN
);

create table thongtinhoadon(
	mahd char(6),
    masv char(6),
    chitiet char(40),
    ngaytao date,
    dathanhtoan boolean,
    ngaythanhtoan date,
    primary key(mahd, masv)
);
create table hoadondiennuoc(
	mahd char(10),
    toa char(3),
    phong char(3),
    chitiet char(40),
    ngaytao date,
    dathanhtoan boolean,
    ngaythanhtoan date,
    tongtien bigint
);

create table thongtinhoadon(
	mahd char(10),
    masv char(6),
    chitiet char(40),
    ngaytao date,
    dathanhtoan boolean,
    ngaythanhtoan date,
    tongtien bigint
);

select * from thongtinhoadon;
create table taikhoandn(
	ID char(6),
    password varchar(20)
);
insert into taikhoandn values('kt0001','1');
create table thongbao(
	matb char(10),
    chude varchar(20),
    noidung varchar(100),	
    ngaydang date,
    tacgia char(6) 	
);


select * from toa;
select * from phong;
select * from sinhvien;
update sinhvien set toa = 'a18' where masv = 'sv0001';
update sinhvien set phong = '415' where masv = 'sv0001';
select*from phong;
select * from phong where maphong = '415' and MaToa = 'a18';
select * from thongbao;
select * from truongtoa;
DELETE FROM thongbao WHERE matb like '%tb%';
select * from thongbao order by matb desc;
alter table thongbao add tacgia char(6);
insert into thongbao
values ('tb0001','test','Khong nen djt cuoc doi','2022-06-03');
insert into thongbao
values ('tb0002','test2','Khong nen djt cuoc doi','2022-06-03', 'tt0001');
insert into thongbao
values ('tb0003','test','Khong nen djt cuoc doi','2022-06-04','tt0001');
select * from thongbao order by ngaydang;
select * from thongbao where matb = 'tb0001';
select * from sinhvien;
insert taikhoandn 
values ('sv0001','sv0001');
select * from taikhoandn where id='sv0001';
alter table luutru add constraint fk_lt_masv foreign key (MASV) REFERENCES sinhvien(MASV);
alter table luutru add constraint fk_lt_phong foreign key (PHONG) references PHONG(MAPHONG);
ALTER TABLE sinhvien add constraint fk_sv_phong foreign key (PHONG) references PHONG(MAPHONG);


select * from sinhvien;
select* from truongtoa;
select* from toa;
select* from phong;
select * from taikhoandn;
select * from hoadondiennuoc;


