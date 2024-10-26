CREATE TABLE public.tb_client (
    id bigint NOT NULL,
    email character varying(150) NOT NULL,
    name character varying(150) NOT NULL,
    password character varying(255) NOT NULL,
    phone character varying(20) NOT NULL
);