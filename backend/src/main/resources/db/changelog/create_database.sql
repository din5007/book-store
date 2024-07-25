-- liquibase formatted sql

-- changeset admin:1721892872926-1
CREATE TABLE books (id BIGINT NOT NULL, title VARCHAR(255) NULL, author VARCHAR(255) NULL, price DOUBLE NULL, quantity INT NULL, CONSTRAINT pk_books PRIMARY KEY (id));

-- changeset admin:1721892872926-2
CREATE TABLE cart (id BIGINT NOT NULL, user_name VARCHAR(255) NULL, book_id BIGINT NULL, quantity INT NOT NULL, CONSTRAINT pk_cart PRIMARY KEY (id));

-- changeset admin:1721892872926-3
CREATE TABLE order_book (id BIGINT NOT NULL, book_id BIGINT NULL, order_id INT NULL, CONSTRAINT pk_order_book PRIMARY KEY (id));

-- changeset admin:1721892872926-4
CREATE TABLE orders (order_id INT NOT NULL, user_name VARCHAR(255) NULL, total_price DOUBLE NULL, total_quantity DOUBLE NULL, order_date datetime NULL, CONSTRAINT pk_orders PRIMARY KEY (order_id));

-- changeset admin:1721892872926-5
CREATE TABLE users (user_name VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, name VARCHAR(255) NULL, created_date datetime NULL, upadated_date datetime NULL, CONSTRAINT pk_users PRIMARY KEY (user_name));

-- changeset admin:1721892872926-6
ALTER TABLE users ADD CONSTRAINT uc_users_email UNIQUE (email);

-- changeset admin:1721892872926-7
ALTER TABLE cart ADD CONSTRAINT FK_CART_ON_BOOK FOREIGN KEY (book_id) REFERENCES books (id);

-- changeset admin:1721892872926-8
ALTER TABLE cart ADD CONSTRAINT FK_CART_ON_USER_NAME FOREIGN KEY (user_name) REFERENCES users (user_name);

-- changeset admin:1721892872926-9
ALTER TABLE orders ADD CONSTRAINT FK_ORDERS_ON_USERNAME FOREIGN KEY (user_name) REFERENCES users (user_name);

-- changeset admin:1721892872926-10
ALTER TABLE order_book ADD CONSTRAINT FK_ORDER_BOOK_ON_BOOK FOREIGN KEY (book_id) REFERENCES books (id);

-- changeset admin:1721892872926-11
ALTER TABLE order_book ADD CONSTRAINT FK_ORDER_BOOK_ON_ORDERID FOREIGN KEY (order_id) REFERENCES orders (order_id);

