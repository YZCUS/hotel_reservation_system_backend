-- insert pre-defined data into database

INSERT INTO addresses (street_num, street, city, state, country, zip_code) VALUES
('2','Songshou Rd','Taipei','Taipei','Taiwan','110'),
('10','Section 5 of Zhongxiao East RoadSection 5 of Zhongxiao E Rd','Taipei','Taipei','Taiwan','110');

INSERT INTO hotels (name, address_id, contact_number, email) VALUES
('Grand Hyatt Taipei', 1, '+886 2 2720 1234', 'taipei.grand@hyatt.com'),
('W Hotel Taipei', 2, '+886 2 7703 8888', 'w.taipei@whotels.com');


INSERT INTO rooms (hotel_id, number, type, bed_number, capacity, price_per_night) VALUES
(1, '301', 'Standard', 2, 2, 215),
(1, '302', 'Standard', 2, 2, 215),
(1, '303', 'Standard', 2, 2, 215),
(1, '305', 'Standard', 1, 2, 215),
(1, '306', 'Standard', 1, 2, 215),
(1, '307', 'Standard', 1, 2, 215),
(1, '308', 'Standard - Extension', 2, 3, 245),
(1, '309', 'Standard - Extension', 2, 3, 245),
(1, '501', 'Standard', 2, 2, 235),
(1, '502', 'Standard', 2, 2, 235),
(1, '503', 'Standard', 2, 2, 235),
(1, '505', 'Standard', 1, 2, 235),
(1, '506', 'Standard', 1, 2, 235),
(1, '507', 'Standard', 1, 2, 235),
(1, '508', 'Standard - Extension', 2, 3, 275),
(1, '509', 'Standard - Extension', 2, 3, 275),
(1, '701V', 'View - City', 2, 2, 285),
(1, '702V', 'View - City', 2, 2, 285),
(1, '703V', 'View - City', 2, 2, 285),
(1, '705V', 'View - River', 2, 2, 315),
(1, '706V', 'View - River', 2, 2, 315),
(1, '707V', 'View - River', 2, 2, 315),
(1, '708V', 'View - Extension', 2, 4, 355),
(1, '709V', 'View - Extension', 2, 4, 355),
(1, '901', 'Executive', 2, 6, 515),
(1, '902', 'Executive', 2, 6, 515),
(1, '903', 'Executive', 2, 6, 515),
(1, '1001', 'President', 2, 2, 745),
(1, '1002', 'President', 2, 2, 745),
(2, '301', 'Standard', 2, 2, 225),
(2, '302', 'Standard', 2, 2, 225),
(2, '303', 'Standard', 2, 2, 225),
(2, '305', 'Standard', 2, 1, 225),
(2, '306', 'Standard', 2, 1, 225),
(2, '307', 'Standard', 2, 1, 225),
(2, '308', 'Standard - Extension', 2, 3, 255),
(2, '309', 'Standard - Extension', 2, 3, 255),
(2, '501', 'Standard', 2, 2, 245),
(2, '502', 'Standard', 2, 2, 245),
(2, '503', 'Standard', 2, 2, 245),
(2, '505', 'Standard', 2, 1, 245),
(2, '506', 'Standard', 2, 1, 245),
(2, '507', 'Standard', 2, 1, 245),
(2, '508', 'Standard - Extension', 2, 3, 275),
(2, '509', 'Standard - Extension', 2, 3, 275),
(2, '701V', 'View - City', 2, 2, 295),
(2, '702V', 'View - City', 2, 2, 295),
(2, '703V', 'View - City', 2, 2, 295),
(2, '705V', 'View - River', 2, 2, 325),
(2, '706V', 'View - River', 2, 2, 325),
(2, '707V', 'View - River', 2, 2, 325),
(2, '708V', 'View - Extension', 2, 4, 375),
(2, '709V', 'View - Extension', 2, 4, 375),
(2, '901', 'Executive', 2, 6, 535),
(2, '902', 'Executive', 2, 6, 535),
(2, '903', 'Executive', 2, 6, 535),
(2, '1001', 'President', 2, 2, 765),
(2, '1002', 'President', 2, 2, 765);