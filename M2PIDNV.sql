DROP TABLE IF EXISTS registroMovimientos;
DROP TABLE IF EXISTS articulos;
DROP TABLE IF  EXISTS grupos;

create table grupos(
	IDG char(4),
	nombre varchar(15),
	constraint gruposPK primary key(idG)
) ;


create table articulos(
	 IDP char(5) not null,
	 nombre varchar(15) not null,
	 precio_venta money not null,
	 precio_compra money not null,
	 idG char(4) not null,
	 constraint articulosPK primary key(idP),
	 constraint articulosGruposFK foreign key(idG) references grupos(IDG)
) ;

create table registroMovimientos(
	Movimiento Serial not null,
	idP char(5) not null,
	cantidad int not null,
	fecha_movimiento TimeStamp not null,
	constraint rmPK primary key(Movimiento),
	constraint rmPFK foreign key(idP) references articulos(IDP)
) ;

insert into grupos(IDG,nombre) values
('G001','Ropa Grande'),
('G002','Ropa Mediana'),
('G003', 'Ropa chikita');

insert into articulos(IDP,nombre,precio_venta,precio_compra,idG) values
('P0001','Camisa oficina', 1.7, 1.55,'G001'),
('P0002','Gabardina', 1, 1.8,'G001'),
('P0003','T-shirt', 1.5, 1.42,'G002'),
('P0004','medias', 1.25, 1.21,'G003'),
('P0005','guantes', 1.5, 1.42,'G003'),
('P0006','Chompita', 1.5, 1.42,'G002'),
('P0007','Sueter', 1.5, 1.42,'G002'),
('P0008','Abrigo', 1.5, 1.42,'G001'),
('P0009','bufanda', 1.5, 1.42,'G002'),
('P0010','gorrita', 1.5, 1.42,'G003');

insert into registroMovimientos(idP,cantidad,fecha_movimiento) values
('P0010',3,'26/10/2024 09:54'),
('P0001',1,'26/10/2024 09:55'),
('P0002',2,'26/10/2024 09:57'),
('P0003',2,'26/11/2024 09:58'),
('P0005',1,'26/11/2024 09:59'),
('P0004',3,'26/12/2024 10:00'),
('P0006',2,'26/12/2024 10:02'),
('P0008',4,'26/12/2024 10:54'),
('P0007',6,'26/12/2024 10:55'),
('P0009',1,'26/12/2024 10:56');

select * from grupos ;
select * from articulos;
select * from registroMovimientos 
