INSERT INTO `users` (`user_name`,`upadated_date`,`created_date`,`email`,`name`,`password`) VALUES ('dine','2024-07-22 04:38:10.984808','2024-07-22 04:38:10.984808','dine@gmail.com',NULL,'$2a$10$jPLAfwzX8y0ItExay1dM9..WfDAo4o5aDIaBFL56XhhHGrWwOOuR.');

INSERT INTO `books` (`id`,`author`,`price`,`quantity`,`title`) VALUES (1,'jk rowling',500,40000,'harry potter');
INSERT INTO `books` (`id`,`author`,`price`,`quantity`,`title`) VALUES (2,'jk rowling',500,40000,'harry potter');
INSERT INTO `books` (`id`,`author`,`price`,`quantity`,`title`) VALUES (3,'jk rowling',500,40000,'harry potter');
INSERT INTO `books` (`id`,`author`,`price`,`quantity`,`title`) VALUES (4,'jk rowling',500,40000,'harry potter');
INSERT INTO `books` (`id`,`author`,`price`,`quantity`,`title`) VALUES (5,'jk rowling',500,40000,'harry potter');
INSERT INTO `books` (`id`,`author`,`price`,`quantity`,`title`) VALUES (6,'jk rowling',500,40000,'harry potter');

INSERT INTO `cart` (`id`,`quantity`,`book_id`,`user_name`) VALUES (1,11,2,'dine');
INSERT INTO `cart` (`id`,`quantity`,`book_id`,`user_name`) VALUES (2,1,3,'dine');
INSERT INTO `cart` (`id`,`quantity`,`book_id`,`user_name`) VALUES (3,3,1,'dine');
