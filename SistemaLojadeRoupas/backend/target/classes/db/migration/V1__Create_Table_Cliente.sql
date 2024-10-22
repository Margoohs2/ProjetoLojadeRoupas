CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email VARCHAR(255) UNIQUE,
    phone VARCHAR(20),
    password VARCHAR(255)
);