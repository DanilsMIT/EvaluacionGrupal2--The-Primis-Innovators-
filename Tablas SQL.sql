drop table if exists registro_movimientos;
drop table if exists articulos;
drop table if exists grupos;

create table grupos(
	id char(4) not null,
	nombre varchar(20) not null,
	constraint grupos_pk primary key (id)
);

create table articulos(
	id char(5) not null,
	nombre varchar(30) not null,
	precio_venta money not null,
	precio_compra money not null,
	id_grupos char(4) not null,
	constraint articulos_pk primary key (id),
	constraint articulos_fk foreign key (id_grupos) references grupos(id)
);

create table registro_movimientos(
	id serial not null,
	id_articulos char(5) not null,
	cantidad int not null,
	fecha_movimiento timestamp not null,
	constraint hm_pk primary key (id),
	constraint hm_fk foreign key (id_articulos) references articulos(id)
);

insert into grupos(id, nombre)
values('C001', 'Bebidas');
insert into grupos(id, nombre)
values('C002', 'Snacks');
insert into grupos(id, nombre)
values('C003', 'Golosinas');

insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos)
values('P0001', 'Coca cola', 0.71, 0.55, 'C001');
insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos)
values('P0002', 'Pepsi', 0.72, 0.56, 'C001');
insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos)
values('P0003', 'Fanta', 0.73, 0.57, 'C001');
insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos)
values('P0004', 'Agua', 0.74, 0.58, 'C001');
insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos)
values('P0005', 'Doritos', 2.7, 1.2, 'C002');
insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos)
values('P0006', 'Galletas Ricas', 3.7, 1.25, 'C002');
insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos)
values('P0007', 'Papas', 4.7, 1.75, 'C002');
insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos)
values('P0008', 'Tango', 5.7, 1.2, 'C003');
insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos)
values('P0009', 'Chocolate', 6.7, 0.55, 'C003');
insert into articulos(id, nombre, precio_venta, precio_compra, id_grupos)
values('P0010', 'Choco Banana', 7.7, 0.59, 'C003');

insert into registro_movimientos(id_articulos, cantidad, fecha_movimiento)
values('P0001', 10, '28/10/2020 9:45');
insert into registro_movimientos(id_articulos, cantidad, fecha_movimiento)
values('P0002', 9, '28/10/2020 10:45');
insert into registro_movimientos(id_articulos, cantidad, fecha_movimiento)
values('P0003', 7, '28/10/2020 11:55');
insert into registro_movimientos(id_articulos, cantidad, fecha_movimiento)
values('P0004', 15, '28/10/2020 13:45');
insert into registro_movimientos(id_articulos, cantidad, fecha_movimiento)
values('P0005', 24, '28/10/2020 14:00');
insert into registro_movimientos(id_articulos, cantidad, fecha_movimiento)
values('P0006', 3, '28/10/2020 14:45');
insert into registro_movimientos(id_articulos, cantidad, fecha_movimiento)
values('P0007', 6, '28/10/2020 15:05');
insert into registro_movimientos(id_articulos, cantidad, fecha_movimiento)
values('P0008', 9, '28/10/2020 16:00');
insert into registro_movimientos(id_articulos, cantidad, fecha_movimiento)
values('P0009', 2, '28/10/2020 16:45');
insert into registro_movimientos(id_articulos, cantidad, fecha_movimiento)
values('P0010', 9, '28/10/2020 17:45');

select * from grupos;
select * from articulos;
select * from registro_movimientos;