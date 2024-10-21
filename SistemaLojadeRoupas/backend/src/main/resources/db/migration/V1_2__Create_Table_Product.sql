CREATE TABLE public.tb_product (
	id SERIAL PRIMARY KEY,
    name STRING NOT NULL,
    price DOUBLE,
    size STRING,
    quantity INTEGER,
    color STRING,
    description STRING
);