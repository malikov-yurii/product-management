TRUNCATE TABLE products, users CASCADE;

ALTER SEQUENCE products_id_seq RESTART WITH 1;
ALTER SEQUENCE users_id_seq RESTART WITH 1;

INSERT INTO users (name, password) VALUES
  ('User', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni'),
  ('Admin', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 1),
  ('ROLE_ADMIN', 2),
  ('ROLE_USER', 2);

INSERT INTO products (name, producer, price, description) VALUES
  ('Shellac', 'Manetti', 235, 'Varnish for protecting imitation gold leaf gilding'),
  ('Gold leaf imitation', 'Nazionale', 385, '100 leaves of gold leaf imitation'),
  ('Alcohol gilding glue', 'Ferrario', 315, 'Glue for gold leaf imitation'),
  ('Bitumen Wax', 'Divolo', 570, 'Wax which may be used as patina for gilded surfaces');