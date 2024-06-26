DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS model;
DROP TABLE IF EXISTS brand_model;
DROP TABLE IF EXISTS type;
CREATE TABLE IF NOT EXISTS brand
(
    brand_id SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS model
(
    model_id SERIAL PRIMARY KEY,
    name     VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS brand_model
(
    brand_id INT REFERENCES brand (brand_id),
    model_id INT REFERENCES model (model_id),
    PRIMARY KEY (brand_id, model_id)
);

CREATE TABLE IF NOT EXISTS type
(
    type_id SERIAL PRIMARY KEY,
    type    VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS product
(
    product_id SERIAL PRIMARY KEY,
    type       INT NOT NULL REFERENCES type (type_id),
    brand_id   INT NOT NULL,
    model_id   INT NOT NULL,
    price      DECIMAL(8, 2),
    FOREIGN KEY (brand_id, model_id) REFERENCES brand_model (brand_id, model_id)
);

