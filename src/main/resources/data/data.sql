-- Hotels
INSERT INTO hotel (id, name, address) VALUES (1, 'Seaside Escape', '123 Ocean Ave, Miami');
INSERT INTO hotel (id, name, address) VALUES (2, 'Mountain View Inn', '789 Peak Rd, Aspen');

-- Rooms (linked to hotels via hotel_id)
INSERT INTO room (id, room_number, type, price_per_night, hotel_id) VALUES (1, '101', 'single', 100.00, 1);
INSERT INTO room (id, room_number, type, price_per_night, hotel_id) VALUES (2, '102', 'double', 150.00, 1);
INSERT INTO room (id, room_number, type, price_per_night, hotel_id) VALUES (3, '201', 'suite', 250.00, 2);

-- Users
INSERT INTO users (id, name, email) VALUES (1, 'Alice Smith', 'alice@example.com');
INSERT INTO users (id, name, email) VALUES (2, 'Bob Johnson', 'bob@example.com');

-- Bookings (user_id and room_id must exist)
INSERT INTO booking (id, user_id, room_id, check_in, check_out) VALUES (1, 1, 1, '2025-08-10', '2025-08-12');
INSERT INTO booking (id, user_id, room_id, check_in, check_out) VALUES (2, 2, 3, '2025-09-01', '2025-09-05');
