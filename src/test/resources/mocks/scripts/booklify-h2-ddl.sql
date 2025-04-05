CREATE TABLE category (
    id numeric,
    name VARCHAR(50),
    tms timestamp,
    CONSTRAINT category_pk PRIMARY KEY (id)
);


CREATE TABLE publisher (
    id numeric,
    name varchar,
    country varchar,
    city varchar,
    address varchar,
    zip varchar,
    website varchar,
    contacts varchar,
    tms timestamp,
    CONSTRAINT publisher_pk PRIMARY KEY (id)
);

CREATE TABLE book (
    id numeric,
    category numeric,
    author varchar(50),
    title varchar(50),
    title2 varchar(50),
    title3 varchar(50),
    subtitle varchar(50),
    volume varchar(3),
    publication_year varchar(4),
    language varchar(2),
    isbn varchar(50),
    publisher int8,
    width numeric,
    length numeric,
    pages varchar,
    image varchar,
    note varchar,
    price varchar,
    tms timestamp,
    CONSTRAINT book_pk PRIMARY KEY (id),
    CONSTRAINT book_category_fk FOREIGN KEY (category) REFERENCES category(id),
    CONSTRAINT book_publisher_fk FOREIGN KEY (publisher) REFERENCES publisher(id)
);

CREATE SEQUENCE IF NOT EXISTS book_seq
    START WITH 6
    INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS category_seq
    START WITH 11
    INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS publisher_seq
    START WITH 9
    INCREMENT BY 1;