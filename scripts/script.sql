CREATE DATABASE IF NOT EXISTS travel_agency;
USE travel_agency;

CREATE TABLE countries (
  country_id INT(10) AUTO_INCREMENT NOT NULL,
  country_name VARCHAR(40) NOT NULL ,
  PRIMARY KEY (country_id)
);

CREATE TABLE cities (
  city_id INT(10) AUTO_INCREMENT NOT NULL,
  city_name VARCHAR(40) NOT NULL,
  c_id INT NOT NULL,
  PRIMARY KEY (city_id),
  FOREIGN KEY (c_id) REFERENCES countries(country_id)
);

CREATE TABLE boards (
  board_id INT(10) AUTO_INCREMENT NOT NULL,
  board_type CHAR(3) NOT NULL,
  PRIMARY KEY (board_id)
);

CREATE TABLE hotels (
hotel_id INT(10) AUTO_INCREMENT NOT NULL,
hotel_name VARCHAR(60) NOT NULL,
stars INT,
c_id INT NOT NULL,
b_id INT NOT NULL,
room_price DEC(6, 2) NOT NULL,
board_price DEC(6, 2) NOT NULL,
PRIMARY KEY (hotel_id),
FOREIGN KEY (c_id) REFERENCES cities(city_id),
FOREIGN KEY (b_id) REFERENCES boards(board_id)
);


CREATE TABLE flights (
  flight_id INT(10) AUTO_INCREMENT NOT NULL,
  departure DATE NOT NULL,
  arrival DATE NOT NULL,
  cn_id int NOT NULL,
  flight_cost DEC(6, 2) NOT NULL,
  PRIMARY KEY (flight_id),
  FOREIGN KEY (cn_id) REFERENCES countries(country_id)
);

CREATE TABLE users (
  user_id INT(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  login VARCHAR(20) NOT NULL,
  password VARCHAR(25) NOT NULL,
  role CHAR(5) DEFAULT 'user' NOT NULL
);

CREATE TABLE tours (
  tour_id INT(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  h_id VARCHAR(20) REFERENCES hotels(hotel_id),
  duration INT NOT NULL,
  b_id CHAR(3) REFERENCES boards(board_id),
  p_quantity INT DEFAULT 1 NOT NULL,
  full_cost DEC(6, 2) NOT NULL,
  f_id INT REFERENCES flights(flight_id)
);

CREATE TABLE orders (
  order_id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  t_id INT REFERENCES tours(tour_id),
  u_id INT NOT NULL,
  order_date DATE NOT NULL,
  FOREIGN KEY (u_id) REFERENCES users(user_id)
);

INSERT INTO countries VALUES (NULL, 'Испания');
INSERT INTO countries VALUES (NULL, 'Италия');
INSERT INTO countries VALUES (NULL, 'Франция');
INSERT INTO countries VALUES (NULL, 'Португалия');

INSERT INTO cities VALUES (NULL, 'Барселона', 1);
INSERT INTO cities VALUES (NULL, 'Тенерифе', 1);
INSERT INTO cities VALUES (NULL, 'Майорка', 1);
INSERT INTO cities VALUES (NULL, 'Римини', 2);
INSERT INTO cities VALUES (NULL, 'Тоскана', 2);
INSERT INTO cities VALUES (NULL, 'Сицилия', 2);
INSERT INTO cities VALUES (NULL, 'Канны', 3);
INSERT INTO cities VALUES (NULL, 'Монако', 3);
INSERT INTO cities VALUES (NULL, 'Ницца', 3);
INSERT INTO cities VALUES (NULL, 'Мадейра', 4);
INSERT INTO cities VALUES (NULL, 'Порту', 4);

INSERT INTO boards VALUES (NULL, 'ro');
INSERT INTO boards VALUES (NULL, 'bb');
INSERT INTO boards VALUES (NULL, 'hb');
INSERT INTO boards VALUES (NULL, 'fb');
INSERT INTO boards VALUES (NULL, 'ai');
INSERT INTO boards VALUES (NULL, 'uai');

INSERT INTO hotels VALUES (NULL, 'Condal Mar', 4, 1, 4, 100, 40);
INSERT INTO hotels VALUES (NULL, 'Del Mar', 3, 1, 3, 80, 30);
INSERT INTO hotels VALUES (NULL, 'Espana', 4, 1, 3, 90, 30);
INSERT INTO hotels VALUES (NULL, 'Ponderosa', 3, 2, 3, 90, 30);
INSERT INTO hotels VALUES (NULL, 'Sol Tenerife', 4, 2, 4, 110, 40);
INSERT INTO hotels VALUES (NULL, 'Xibana Park', 3, 2, 3, 100, 30);
INSERT INTO hotels VALUES (NULL, 'Lago Garden', 5, 3, 5, 140, 50);
INSERT INTO hotels VALUES (NULL, 'Manaus', 3, 3, 4, 100, 40);
INSERT INTO hotels VALUES (NULL, 'Mediterranian Bay', 4, 3, 4, 120, 40);
INSERT INTO hotels VALUES (NULL, 'BellaVista', 3, 4, 3, 70, 30);
INSERT INTO hotels VALUES (NULL, 'Vittoria', 4, 4, 5, 110, 50);
INSERT INTO hotels VALUES (NULL, 'Villa Adriatica', 4, 4, 5, 120, 50);
INSERT INTO hotels VALUES (NULL, 'Villa Mdeici', 5, 5, 6, 150, 60);
INSERT INTO hotels VALUES (NULL, 'Toascana', 2, 5, 2, 40, 20);
INSERT INTO hotels VALUES (NULL, 'Strozzi Palace', 4, 5, 4, 90, 40);
INSERT INTO hotels VALUES (NULL, 'Sole Castello', 3, 6, 3, 80, 30);
INSERT INTO hotels VALUES (NULL, 'Villa Athena', 5, 6, 6, 180, 60);
INSERT INTO hotels VALUES (NULL, 'Porto Azzurro', 3, 6, 2, 70, 20);
INSERT INTO hotels VALUES (NULL, 'Montaigne', 4, 7, 4, 120, 40);
INSERT INTO hotels VALUES (NULL, 'Renoir', 3, 7, 3, 100, 30);
INSERT INTO hotels VALUES (NULL, 'Hotel Eden', 4, 7, 4, 110, 40);
INSERT INTO hotels VALUES (NULL, 'Hermitage', 5, 8, 6, 320, 60);
INSERT INTO hotels VALUES (NULL, 'Royal Riviera', 5, 8, 6, 400, 60);
INSERT INTO hotels VALUES (NULL, 'Metropole', 5, 8, 6, 420, 60);
INSERT INTO hotels VALUES (NULL, 'Nice Plaza', 4, 9, 3, 100, 30);
INSERT INTO hotels VALUES (NULL, 'Negresco', 5, 9, 5, 150, 50);
INSERT INTO hotels VALUES (NULL, 'Imperatriz', 3, 10, 3, 80, 30);
INSERT INTO hotels VALUES (NULL, 'Nzcional', 3, 10, 3, 90, 30);
INSERT INTO hotels VALUES (NULL, 'Porto Mare', 4, 10, 4, 100, 40);
INSERT INTO hotels VALUES (NULL, 'Tivoli Porto', 4, 11, 4, 90, 40);
INSERT INTO hotels VALUES (NULL, 'Teatro', 4, 11, 3, 80, 30);
INSERT INTO hotels VALUES (NULL, 'Inca', 4, 11, 4, 85, 40);

INSERT INTO flights VALUES (NULL, '2017-08-25', '2017-09-08', 1, 280);
INSERT INTO flights VALUES (NULL, '2017-08-26', '2017-09-07', 2, 160);
INSERT INTO flights VALUES (NULL, '2017-08-28', '2017-09-11', 1, 300);
INSERT INTO flights VALUES (NULL, '2017-08-26', '2017-09-08', 3, 180);
INSERT INTO flights VALUES (NULL, '2017-08-27', '2017-09-10', 4, 340);
INSERT INTO flights VALUES (NULL, '2017-08-30', '2017-09-12', 4, 330);
INSERT INTO flights VALUES (NULL, '2017-08-27', '2017-09-09', 3, 170);
INSERT INTO flights VALUES (NULL, '2017-09-02', '2017-09-12', 2, 150);

INSERT INTO users VALUES (NULL, 'admin@mail.ru', 'admin', 'admin');
INSERT INTO users VALUES (NULL, 'yauheni@mail.ru', 'yauheni', 'user');