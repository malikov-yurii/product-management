-- DROP TABLE IF EXISTS user_roles;
-- DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS products;

-- CREATE TABLE users
-- (
--   id       SERIAL PRIMARY KEY,
--   name     VARCHAR NOT NULL,
--   password VARCHAR NOT NULL,
--   CONSTRAINT users_unique_name_idx UNIQUE (name)
-- );
--
-- CREATE TABLE user_roles
-- (
--   user_id INTEGER NOT NULL,
--   role    VARCHAR NOT NULL,
--   CONSTRAINT users_roles_idx UNIQUE (user_id, role),
--   FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
-- );

CREATE TABLE products (
  id               SERIAL PRIMARY KEY,
  name             VARCHAR,
  producer             VARCHAR,
  price            FLOAT,
  description         TEXT
);