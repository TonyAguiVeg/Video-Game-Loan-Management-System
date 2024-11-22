-- borra la bd si existe
DROP DATABASE IF EXISTS juegos_entretenimiento;
-- creamos la bd
CREATE DATABASE juegos_entretenimiento;
-- activamos la bd
USE juegos_entretenimiento;

INSERT INTO tb_juegos (nom_juego, des_juego, dispo_jueg, precio) 
VALUES ('The Legend of Code', 'An epic adventure game where you solve puzzles and defeat bugs.', 'Disponible', 59.99);

INSERT INTO tb_juegos (nom_juego, des_juego, dispo_jueg, precio) 
VALUES ('Cyber Quest', 'A futuristic cyberpunk game with high-tech heists and exploration.', 'Agotado', 49.99);

INSERT INTO tb_juegos (nom_juego, des_juego, dispo_jueg, precio) 
VALUES ('Ocean Explorer', 'A relaxing underwater exploration game with stunning visuals.', 'Disponible', 19.99);

INSERT INTO tb_juegos (nom_juego, des_juego, dispo_jueg, precio) 
VALUES ('Mystery Mansion', 'Solve mysteries and unlock secrets in a haunted mansion.', 'Disponible', 39.99);

INSERT INTO tb_juegos (nom_juego, des_juego, dispo_jueg, precio) 
VALUES ('Sky Warriors', 'An intense flight simulation game with realistic aerial combat.', NULL, 29.99);

INSERT INTO tb_juegos (nom_juego, des_juego, dispo_jueg, precio) 
VALUES ('Pixel Kingdom', 'A retro-style RPG with pixel art graphics and epic battles.', 'Disponible', 14.99);

INSERT INTO tb_juegos (nom_juego, des_juego, dispo_jueg, precio) 
VALUES ('Future Racer', 'High-speed racing in futuristic tracks and customizable vehicles.', 'Disponible', 24.99);

INSERT INTO tb_juegos (nom_juego, des_juego, dispo_jueg, precio) 
VALUES ('Space Miner', 'Mine resources on distant planets and build your space empire.', NULL, 9.99);

INSERT INTO tb_juegos (nom_juego, des_juego, dispo_jueg, precio) 
VALUES ('Magic Forest', 'An enchanting game where you harness magic and explore a fantasy forest.', 'Agotado', 34.99);

INSERT INTO tb_juegos (nom_juego, des_juego, dispo_jueg, precio) 
VALUES ('Ancient Ruins', 'Adventure through ancient ruins and uncover historical secrets.', 'Disponible', 44.99);
select*from tb_juegos;






INSERT INTO tb_cliente (nom_cliente, ap_pat, ap_mat, dni, tel, correo) 
VALUES ('Juan', 'Pérez', 'Gómez', '12345678', '987654321', 'juan.perez@example.com');

INSERT INTO tb_cliente (nom_cliente, ap_pat, ap_mat, dni, tel, correo) 
VALUES ('María', 'López', 'Rodríguez', '87654321', '912345678', 'maria.lopez@example.com');

INSERT INTO tb_cliente (nom_cliente, ap_pat, ap_mat, dni, tel, correo) 
VALUES ('Carlos', 'Martínez', 'Díaz', '45678901', '934567890', 'carlos.martinez@example.com');

INSERT INTO tb_cliente (nom_cliente, ap_pat, ap_mat, dni, tel, correo) 
VALUES ('Ana', 'García', 'Fernández', '34567890', '945678901', 'ana.garcia@example.com');

INSERT INTO tb_cliente (nom_cliente, ap_pat, ap_mat, dni, tel, correo) 
VALUES ('Luis', 'Ramírez', 'Castro', '23456789', '956789012', 'luis.ramirez@example.com');


INSERT INTO tb_reserva (id_cliente, fech_evento, lugar, estado, id_juego) 
VALUES (1, '2024-12-01', 'Lima', 'Pendiente', 1);

INSERT INTO tb_reserva (id_cliente, fech_evento, lugar, estado, id_juego) 
VALUES (2, '2024-12-05', 'Arequipa', 'Confirmada', 2);

INSERT INTO tb_reserva (id_cliente, fech_evento, lugar, estado, id_juego) 
VALUES (3, '2024-12-10', 'Cusco', 'Cancelada', 3);

INSERT INTO tb_reserva (id_cliente, fech_evento, lugar, estado, id_juego) 
VALUES (4, '2024-12-15', 'Trujillo', 'Pendiente', 4);




INSERT INTO tb_usuario (name_usuario, contrasena, id_cliente) 
VALUES ('usuario1', 'contrasenaSegura1', 1);

INSERT INTO tb_usuario (name_usuario, contrasena, id_cliente) 
VALUES ('usuario2', 'contrasenaSegura2', 2);

INSERT INTO tb_usuario (name_usuario, contrasena, id_cliente) 
VALUES ('usuario3', 'contrasenaSegura3', 3);

INSERT INTO tb_usuario (name_usuario, contrasena, id_cliente) 
VALUES ('usuario4', 'contrasenaSegura4', 4);



INSERT INTO tb_entrega (id_reserva, fech_entrega, hora_entrega, estado_entrega) 
VALUES (1, '2024-12-02', '10:30:00', 'Programado');

INSERT INTO tb_entrega (id_reserva, fech_entrega, hora_entrega, estado_entrega) 
VALUES (2, '2024-12-06', '14:00:00', 'Programado');

INSERT INTO tb_entrega (id_reserva, fech_entrega, hora_entrega, estado_entrega) 
VALUES (3, '2024-12-11', '09:00:00', 'No entregado');

INSERT INTO tb_entrega (id_reserva, fech_entrega, hora_entrega, estado_entrega) 
VALUES (4, '2024-12-16', '11:00:00', 'Programado');

