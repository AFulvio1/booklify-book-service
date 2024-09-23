-- START BOOK ------------------------------------------------------------------------------------------- 
CREATE SEQUENCE public.book_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
	
CREATE TABLE public.book (
	id int8 DEFAULT nextval('book_seq'::regclass) NOT NULL,
	category int8 NULL,
	author varchar(50) NULL,
	title varchar(50) NULL,
	title2 varchar(50) NULL,
	title3 varchar(50) NULL,
	subtitle varchar(50) NULL,
	volume varchar(3) NULL,
	publication_year varchar(4) NULL,
	lang varchar(2) NULL,
	isbn varchar(50) NULL,
	publisher int8 NULL,
	width numeric(38, 2) NULL,
	length numeric(38, 2) NULL,
	pages varchar NULL,
	image varchar NULL,
	note varchar NULL,
	price varchar NULL,
	tms timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	CONSTRAINT book_pk PRIMARY KEY (id),
	CONSTRAINT book_category_fk FOREIGN KEY (category) REFERENCES public.category(id),
	CONSTRAINT book_publisher_fk FOREIGN KEY (publisher) REFERENCES public.publisher(id)
);

CREATE TABLE public.category (
	id int8 DEFAULT nextval('category_seq'::regclass) NOT NULL,
	"name" varchar(50) NULL,
	tms timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	CONSTRAINT category_pk PRIMARY KEY (id)
);

CREATE TABLE public.publisher (
	id int8 DEFAULT nextval('publisher_seq'::regclass) NOT NULL,
	"name" varchar NULL,
	country varchar NULL,
	city varchar NULL,
	address varchar NULL,
	zip varchar NULL,
	website varchar NULL,
	contacts varchar NULL,
	tms timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	CONSTRAINT publisher_pk PRIMARY KEY (id)
);

CREATE TABLE public."user" (
	id int8 DEFAULT nextval('user_seq'::regclass) NOT NULL,
	email varchar(255) NOT NULL,
	firstname varchar(255) NULL,
	lastname varchar(255) NULL,
	"password" varchar(255) NOT NULL,
	"role" varchar(255) NOT NULL,
	tms timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	CONSTRAINT user_email_key UNIQUE (email),
	CONSTRAINT user_pkey PRIMARY KEY (id)
);
CREATE UNIQUE INDEX user_pk ON public."user" USING btree (id);