CREATE TABLE client (
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	email TEXT,
	phone TEXT,
	password TEXT
);