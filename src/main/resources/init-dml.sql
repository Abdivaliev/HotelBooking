-- DML

--Default Rooms
INSERT INTO room(BALCONY, EXTRA, IS_BOOKED, NUMBER_OF_BEDS, STATUS_OF_ROOM, SQUARE, NUMBER_OF_ROOMS, ROOM_NUMBER,photo_link)
VALUES (FALSE, 'NOTHING TO SAY GOODBYE', FALSE, 4, 'DELUXE', 45.2, 2,1,'https://assets-global.website-files.com/5c6d6c45eaa55f57c6367749/624b471bdf247131f10ea14f_61d31b8dbff9b500cbd7ed32_types_of_rooms_in_a_5-star_hotel_2_optimized_optimized.jpeg');

INSERT INTO room(BALCONY, EXTRA, IS_BOOKED, NUMBER_OF_BEDS, STATUS_OF_ROOM, SQUARE, NUMBER_OF_ROOMS, ROOM_NUMBER,photo_link)
VALUES (FALSE, 'NOTHING TO SAY GOODBYE', FALSE, 3, 'PREMIUM', 45.2, 2,2,'https://assets-global.website-files.com/5c6d6c45eaa55f57c6367749/624b471bdf247131f10ea14f_61d31b8dbff9b500cbd7ed32_types_of_rooms_in_a_5-star_hotel_2_optimized_optimized.jpeg');

INSERT INTO room(BALCONY, EXTRA, IS_BOOKED, NUMBER_OF_BEDS, STATUS_OF_ROOM, SQUARE, NUMBER_OF_ROOMS, ROOM_NUMBER,photo_link)
VALUES (FALSE, 'NOTHING TO SAY GOODBYE', FALSE, 2, 'DELUXE', 45.2, 2,3,'https://assets-global.website-files.com/5c6d6c45eaa55f57c6367749/624b471bdf247131f10ea14f_61d31b8dbff9b500cbd7ed32_types_of_rooms_in_a_5-star_hotel_2_optimized_optimized.jpeg');

INSERT INTO room(BALCONY, EXTRA, IS_BOOKED, NUMBER_OF_BEDS, STATUS_OF_ROOM, SQUARE, NUMBER_OF_ROOMS, ROOM_NUMBER,photo_link)
VALUES (FALSE, 'NOTHING TO SAY GOODBYE', FALSE, 4, 'STANDARD', 45.2, 2,4,'https://assets-global.website-files.com/5c6d6c45eaa55f57c6367749/624b471bdf247131f10ea14f_61d31b8dbff9b500cbd7ed32_types_of_rooms_in_a_5-star_hotel_2_optimized_optimized.jpeg');

INSERT INTO room(BALCONY, EXTRA, IS_BOOKED, NUMBER_OF_BEDS, STATUS_OF_ROOM, SQUARE, NUMBER_OF_ROOMS, ROOM_NUMBER,photo_link)
VALUES (FALSE, 'NOTHING TO SAY GOODBYE', FALSE, 3, 'DELUXE', 45.2, 2,5,'https://assets-global.website-files.com/5c6d6c45eaa55f57c6367749/624b471bdf247131f10ea14f_61d31b8dbff9b500cbd7ed32_types_of_rooms_in_a_5-star_hotel_2_optimized_optimized.jpeg');

INSERT INTO room(BALCONY, EXTRA, IS_BOOKED, NUMBER_OF_BEDS, STATUS_OF_ROOM, SQUARE, NUMBER_OF_ROOMS, ROOM_NUMBER,photo_link)
VALUES (FALSE, 'NOTHING TO SAY GOODBYE', FALSE, 4, 'STANDARD', 45.2, 2,6,'https://assets-global.website-files.com/5c6d6c45eaa55f57c6367749/624b471bdf247131f10ea14f_61d31b8dbff9b500cbd7ed32_types_of_rooms_in_a_5-star_hotel_2_optimized_optimized.jpeg');

INSERT INTO room(BALCONY, EXTRA, IS_BOOKED, NUMBER_OF_BEDS, STATUS_OF_ROOM, SQUARE, NUMBER_OF_ROOMS, ROOM_NUMBER,photo_link)
VALUES (FALSE, 'NOTHING TO SAY GOODBYE', FALSE, 2, 'PREMIUM', 45.2, 2,7,'https://assets-global.website-files.com/5c6d6c45eaa55f57c6367749/624b471bdf247131f10ea14f_61d31b8dbff9b500cbd7ed32_types_of_rooms_in_a_5-star_hotel_2_optimized_optimized.jpeg');

--Default admin
INSERT INTO users(FIRST_NAME, SURNAME, PHONE_NUMBER, EMAIL, ROLE, PASSWORD)
VALUES ('Sarvar', 'Abdivaliyev', 'ADMIN', 'sarvarabdivaliyev@gmail.com', 'ADMIN', 'admin');

--Default Hotel

INSERT INTO hotel(name, email, phone_number, address, photo_link, description)
values ('Epam International Hotel','epam@gmail.com','778881020','Tashkent, Uzbekistan','https://i.ytimg.com/vi/RPb3h51sHAs/hqdefault.jpg','Welcome to epam international hotel again!');