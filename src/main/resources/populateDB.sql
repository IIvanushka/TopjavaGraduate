DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM RESTAURANTS;
DELETE FROM LUNCH_MENU;
ALTER SEQUENCE GLOBAL_SEQ
RESTART WITH 100000;

INSERT INTO users (name, email, password, role, ID_LM_VOTE) VALUES
  ('User', 'user@yandex.ru', 'password', 'USER', 100005),
  ('Admin', 'admin@gmail.com', 'admin', 'ADMIN', NULL );

INSERT INTO user_roles (role, user_id) VALUES
  ('USER', 100000),
  ('ADMIN', 100001);

INSERT INTO RESTAURANTS (NAME, ADDRESS) VALUES
  ('Levadiya', '50, Lenina str, Citysburg'),
  ('Grechka', '100, Poselenina str, Burgcity');

INSERT INTO LUNCH_MENU (ID_REST, DATE, VOTES) VALUES
  (100002,'2018-01-06', 0),
  (100002,'2018-01-07', 1),
  (100003,'2018-01-07', 0);