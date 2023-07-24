-- DDL

CREATE TABLE room
(
    id            SERIAL PRIMARY KEY,
    balcony       BOOLEAN DEFAULT FALSE,
    extra         VARCHAR(255),
    is_booked      BOOLEAN DEFAULT FALSE,
    number_of_beds  INTEGER,
    status_of_room    VARCHAR(255),
    square        NUMERIC,
    number_of_rooms INTEGER,
    room_number    INTEGER,
    photoLink     TEXT
);

CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    first_name   VARCHAR(255) NOT NULL,
    surname      VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL UNIQUE,
    email        VARCHAR(255) NOT NULL UNIQUE,
    role         VARCHAR(255) NOT NULL,
    password     TEXT
);

CREATE TABLE booking
(
    id             SERIAL PRIMARY KEY,
    status_room         VARCHAR(255) NOT NULL,
    number_of_beds INTEGER      NOT NULL,
    start_date     DATE         NOT NULL,
    end_date       DATE         NOT NULL,
    client_id      INTEGER      NOT NULL,
    FOREIGN KEY (client_id) REFERENCES users (id)
);


CREATE TABLE hotel
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE ,
    phone_number VARCHAR(255) NOT NULL UNIQUE ,
    description TEXT
);

CREATE TABLE reservation
(
    id         SERIAL PRIMARY KEY,
    price      INTEGER NOT NULL,
    start_date  DATE NOT NULL,
    end_date    DATE NOT NULL,
    client_name VARCHAR(255) NOT NULL,
    room_number INTEGER NOT NULL,
    hotelId    INTEGER REFERENCES hotel (id),
    extra_info  TEXT
);


COMMIT;