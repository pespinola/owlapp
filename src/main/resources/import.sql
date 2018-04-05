
INSERT INTO permiso(id, nombre, descripcion)
VALUES(1, 'Cargo_ins', 'Permiso para insertar cargos');

INSERT INTO permiso(id, nombre, descripcion)
VALUES(2, 'Cargo_upd', 'Permiso para actualizar cargos');

INSERT INTO permiso(id, nombre, descripcion)
VALUES(3, 'Cargo_del', 'Permiso para borrar cargos');

INSERT INTO permiso(id, nombre, descripcion)
VALUES(4, 'Cargo_sel', 'Permiso para ver cargos');

INSERT INTO permiso(id, nombre, descripcion)
VALUES(5, 'Departamento_ins', 'Permiso para insertar departamentos');

INSERT INTO permiso(id, nombre, descripcion)
VALUES(6, 'Departamento_upd', 'Permiso para actualizar departamentos');

INSERT INTO permiso(id, nombre, descripcion)
VALUES(7, 'Departamento_del', 'Permiso para borrar departamentos');

INSERT INTO permiso(id, nombre, descripcion)
VALUES(8, 'Departamento_sel', 'Permiso para ver departamentos');


INSERT INTO rol(id, codigo) VALUES(1, 'ADMIN');
--Asignamos todos los permisos al rol admin
INSERT INTO rolpermiso(id, permiso_id, rol_id) VALUES(1, 1, 1);
INSERT INTO rolpermiso(id, permiso_id, rol_id) VALUES(2, 2, 1);
INSERT INTO rolpermiso(id, permiso_id, rol_id) VALUES(3, 3, 1);
INSERT INTO rolpermiso(id, permiso_id, rol_id) VALUES(4, 4, 1);
INSERT INTO rolpermiso(id, permiso_id, rol_id) VALUES(5, 5, 1);
INSERT INTO rolpermiso(id, permiso_id, rol_id) VALUES(6, 6, 1);
INSERT INTO rolpermiso(id, permiso_id, rol_id) VALUES(7, 7, 1);
INSERT INTO rolpermiso(id, permiso_id, rol_id) VALUES(8, 8, 1);

INSERT INTO usuario(id, codigo, nombres, apellidos, email, password, rol_id) VALUES(1, 'admin', 'Administrador', 'Sistema','admin@gmail.com',  MD5('adm'), 1);