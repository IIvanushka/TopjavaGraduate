DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM RESTAURANTS;
ALTER SEQUENCE GLOBAL_SEQ
RESTART WITH 100000;

INSERT INTO users (name, email, password, role) VALUES
  ('User', 'user@yandex.ru', 'password', 'USER'),
  ('Admin', 'admin@gmail.com', 'admin', 'ADMIN');

INSERT INTO user_roles (role, user_id) VALUES
  ('USER', 100000),
  ('ADMIN', 100001);

INSERT INTO RESTAURANTS (NAME, ADDRESS) VALUES
  ('Levadiya', '50, Lenina str, Citysburg'),
  ('Grechka', '100, Poselenina str, Burgcity');