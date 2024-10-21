CREATE TABLE public.tb_product (
	id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    price INTEGER,
    size TEXT,
    quantity INTEGER,
    color TEXT,
    description TEXT
);