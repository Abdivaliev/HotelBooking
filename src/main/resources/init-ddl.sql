-- DDL

CREATE TABLE Room
(
    id            SERIAL PRIMARY KEY,
    balcony       BOOLEAN,
    extra         VARCHAR(255),
    isBooked      BOOLEAN,
    numberOfBeds  INTEGER,
    status        VARCHAR(255),
    square        INTEGER,
    numberOfRooms INTEGER,
    number        INTEGER
);

CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    first_name   VARCHAR(255) NOT NULL,
    surname      VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL,
    role         VARCHAR(255) NOT NULL
);

CREATE TABLE booking
(
    id             SERIAL PRIMARY KEY,
    status         VARCHAR(255) NOT NULL,
    number_of_beds INTEGER      NOT NULL,
    start_date     TIMESTAMP    NOT NULL,
    end_date       TIMESTAMP    NOT NULL,
    client_id      INTEGER      NOT NULL,
    FOREIGN KEY (client_id) REFERENCES users (id)
);

CREATE TABLE hotel
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    description  VARCHAR(255)
);

CREATE TABLE price_by_status
(
    id             SERIAL PRIMARY KEY,
    type_of_status VARCHAR(255) NOT NULL,
    price          INTEGER      NOT NULL
);

CREATE TABLE price_by_square
(
    id             SERIAL PRIMARY KEY,
    type_of_status VARCHAR(255) NOT NULL,
    price          INTEGER      NOT NULL
);

CREATE TABLE price_by_each_bed
(
    id          SERIAL PRIMARY KEY,
    type_of_bed VARCHAR(255) NOT NULL,
    price       INTEGER      NOT NULL
);

CREATE TABLE price
(
    id SERIAL PRIMARY KEY,
    basic_price INTEGER NOT NULL
);

ALTER TABLE price_by_status
    ADD COLUMN price_id INTEGER,
ADD FOREIGN KEY (price_id) REFERENCES price (id);

ALTER TABLE price_by_square
    ADD COLUMN price_id INTEGER,
ADD FOREIGN KEY (price_id) REFERENCES price (id);

ALTER TABLE price_by_each_bed
    ADD COLUMN price_id INTEGER,
ADD FOREIGN KEY (price_id) REFERENCES price (id);


COMMIT;