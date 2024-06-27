DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS brand_model;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS model;
DROP TABLE IF EXISTS type;
CREATE TABLE IF NOT EXISTS brand
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS model
(
    id SERIAL PRIMARY KEY,
    name     VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS brand_model
(
    brand_id INT REFERENCES brand (id),
    model_id INT REFERENCES model (id),
    PRIMARY KEY (brand_id, model_id)
);

CREATE TABLE IF NOT EXISTS type
(
    id SERIAL PRIMARY KEY,
    type    VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS product
(
    id SERIAL PRIMARY KEY,
    type_id       INT NOT NULL REFERENCES type (id),
    brand_id   INT NOT NULL,
    model_id   INT NOT NULL,
    price      DECIMAL(8, 2),
    FOREIGN KEY (brand_id, model_id) REFERENCES brand_model (brand_id, model_id)
);

