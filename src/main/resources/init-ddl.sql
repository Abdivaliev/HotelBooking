-- DDL

CREATE TABLE room
(
    id              SERIAL PRIMARY KEY,
    balcony         BOOLEAN DEFAULT FALSE,
    extra           VARCHAR(255),
    is_booked       BOOLEAN DEFAULT FALSE,
    number_of_beds  INTEGER,
    status_of_room  VARCHAR(255),
    square          NUMERIC,
    number_of_rooms INTEGER,
    room_number     INTEGER,
    photo_link      TEXT
);

CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    first_name   VARCHAR(255) NOT NULL,
    surname      VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL,
    role         VARCHAR(255) NOT NULL,
    password     TEXT
);

CREATE TABLE booking
(
    id             SERIAL PRIMARY KEY,
    status_room    VARCHAR(255) NOT NULL,
    number_of_beds INTEGER      NOT NULL,
    start_date     DATE         NOT NULL,
    end_date       DATE         NOT NULL,
    client_id      INTEGER      NOT NULL,
    FOREIGN KEY (client_id) REFERENCES users (id)
);


CREATE TABLE hotel
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(255) NOT NULL UNIQUE,
    address      VARCHAR(255) NOT NULL,
    photo_link   TEXT         NOT NULL,
    description  TEXT
);

CREATE TABLE reservation
(
    id          SERIAL PRIMARY KEY,
    price       INTEGER,
    extra_info  TEXT,
    hotel_id    INTEGER REFERENCES hotel (id),
    room_id    INTEGER REFERENCES room (id),
    booking_id  INTEGER REFERENCES booking (id)
);

CREATE
OR REPLACE FUNCTION update_room_status()
RETURNS TRIGGER AS $$
BEGIN
UPDATE room
SET is_booked = FALSE
WHERE room_number = OLD.room_number
  AND OLD.end_date < CURRENT_DATE;
RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER update_room_status_trigger
    AFTER UPDATE
    ON booking
    FOR EACH ROW
    EXECUTE FUNCTION update_room_status();


COMMIT;