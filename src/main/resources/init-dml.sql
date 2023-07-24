-- DML

--Default Rooms
INSERT INTO room (balcony, extra, isBooked, numberOfBeds, statusroom, square, numberOfRooms, roomnumber)
VALUES (true, 'Extra bed', false, 2, 'DELUXE', 25, 1, 101);

INSERT INTO room (balcony, extra, isBooked, numberOfBeds, statusroom, square, numberOfRooms, roomnumber)
VALUES (true, 'Extra bed', false, 2, 'STANDARD', 30, 2, 102);

INSERT INTO room (balcony, extra, isBooked, numberOfBeds, statusroom, square, numberOfRooms, roomnumber)
VALUES (true, 'Extra bed', false, 2, 'STANDARD', 25, 3, 103);

INSERT INTO room (balcony, extra, isBooked, numberOfBeds, statusroom, square, numberOfRooms, roomnumber)
VALUES (true, 'Extra bed', false, 2, 'DELUXE', 35, 4, 104);

INSERT INTO room (balcony, extra, isBooked, numberOfBeds, statusroom, square, numberOfRooms, roomnumber)
VALUES (true, 'Extra bed', false, 2, 'PREMIUM', 30, 2, 105);

--Default admin
INSERT INTO users(first_name, surname, phone_number, email, role, password)
VALUES ('Sarvar', 'Abdivaliyev', '+998949147959', 'sarvarabdivaliyev@gmail.com', 'ADMIN', 'admin')