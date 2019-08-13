CREATE SCHEMA IF NOT EXISTS shoppingList DEFAULT CHARACTER SET utf8;
USE shoppingList;

CREATE TABLE IF NOT EXISTS products
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    price       DECIMAL      NOT NULL,
    category    VARCHAR(100) NOT NULL,
    discount    DECIMAL      NOT NULL,

    created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;

CREATE TABLE IF NOT EXISTS shoppingCarts
(
    id           BIGINT       NOT NULL AUTO_INCREMENT,
    name         VARCHAR(100) NOT NULL,
    totalAmount  DECIMAL      NOT NULL,
    productCount INT,

    created      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;

CREATE TABLE product_cart
(
    product_id BIGINT REFERENCES products (id),
    cart_id    BIGINT REFERENCES shoppingCarts (id),
    PRIMARY KEY (product_id, cart_id),
    KEY product_id (product_id),
    CONSTRAINT product_cart_1
        FOREIGN KEY (product_id) REFERENCES products (id),
    CONSTRAINT product_cart_2
        FOREIGN KEY (cart_id) REFERENCES shoppingCarts (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

