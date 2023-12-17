-- Schema for Hotel Reservation System

-- Creating the 'addresses' table
CREATE TABLE addresses (
    address_id SERIAL PRIMARY KEY,
    street_num VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    zip_code VARCHAR(20) NOT NULL
);

-- Creating the 'hotels' table
CREATE TABLE hotels (
    hotel_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address_id INTEGER NOT NULL REFERENCES addresses(address_id),
    contact_number VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE
);

-- Creating the 'rooms' table
CREATE TABLE rooms (
    room_id SERIAL PRIMARY KEY,
    hotel_id INTEGER NOT NULL REFERENCES hotels(hotel_id),
    number VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    bed_number INTEGER NOT NULL CHECK (bed_number > 0),
    capacity INTEGER NOT NULL CHECK (capacity > 0),
    price_per_night DECIMAL(10, 2) NOT NULL CHECK (price_per_night > 0)
);

-- Creating the 'customers' table
CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    phone_number VARCHAR(50) NOT NULL
);

-- Creating the 'reservations' table
CREATE TABLE reservations (
    reservation_id SERIAL PRIMARY KEY,
    room_id INTEGER NOT NULL REFERENCES rooms(room_id),
    customer_id INTEGER NOT NULL REFERENCES customers(customer_id),
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL CHECK (check_out_date > check_in_date),
    total_price DECIMAL(10, 2) NOT NULL CHECK (total_price >= 0),
    status VARCHAR(50) NOT NULL,
    create_time TIMESTAMP NOT NULL
);

-- Creating the 'membership' table
CREATE TABLE membership (
    membership_id SERIAL PRIMARY KEY,
    customer_id INTEGER UNIQUE NOT NULL REFERENCES customers(customer_id),
    type VARCHAR(50) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE CHECK (end_date > start_date),
    benefits TEXT
);

-- Creating the 'discounts' table
CREATE TABLE discounts (
    discount_id SERIAL PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    description TEXT NOT NULL,
    discount_percent DECIMAL(5, 2) NOT NULL CHECK (discount_percent > 0 AND discount_percent <= 100),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL CHECK (end_date >= start_date),
    conditions TEXT,
    isMembership BOOLEAN NOT NULL
);
