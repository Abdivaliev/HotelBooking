-- DDL

CREATE TABLE room
(
    id            SERIAL PRIMARY KEY,
    balcony       BOOLEAN DEFAULT FALSE,
    extra         VARCHAR(255),
    isBooked      BOOLEAN DEFAULT FALSE,
    numberOfBeds  INTEGER,
    statusRoom    VARCHAR(255),
    square        NUMERIC,
    numberOfRooms INTEGER,
    roomNumber    INTEGER,
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
    status         VARCHAR(255) NOT NULL,
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
    phoneNumber VARCHAR(255) NOT NULL UNIQUE ,
    description TEXT
);

CREATE TABLE reservation
(
    id         SERIAL PRIMARY KEY,
    price      INTEGER NOT NULL,
    startDate  DATE NOT NULL,
    endDate    DATE NOT NULL,
    clientName VARCHAR(255) NOT NULL,
    roomNumber INTEGER NOT NULL,
    hotelId    INTEGER REFERENCES hotel (id),
    extraInfo  TEXT
);


COMMIT;