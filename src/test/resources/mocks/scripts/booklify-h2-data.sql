INSERT INTO category (id, name)
VALUES
    (1, 'Fiction'),
    (2, 'Non-fiction'),
    (3, 'Science Fiction'),
    (4, 'Fantasy'),
    (5, 'Mystery'),
    (6, 'Thriller'),
    (7, 'Romance'),
    (8, 'Biography'),
    (9, 'History'),
    (10, 'Self-help');

INSERT INTO publisher (id, name, country, city, address, zip, website, contacts)
VALUES
    (1, 'Penguin Random House', 'USA', 'New York', '1745 Broadway', '10019', 'https://www.penguinrandomhouse.com/', 'contact@penguinrandomhouse.com'),
    (2, 'HarperCollins Publishers', 'USA', 'New York', '195 Broadway', '10007', 'https://www.harpercollins.com/', 'customerservice@harpercollins.com'),
    (3, 'Simon & Schuster', 'USA', 'New York', '1230 Avenue of the Americas', '10020', 'https://www.simonandschuster.com/', 'webmaster@simonandschuster.com'),
    (4, 'Macmillan Publishers', 'USA', 'New York', '120 Broadway', '10271', 'https://us.macmillan.com/', 'info@macmillan.com'),
    (5, 'Hachette Livre', 'France', 'Paris', '58 Rue Jean Bleuzen', '92170', 'https://www.hachette.com/', 'contact@hachette.com'),
    (6, 'Grupo Planeta', 'Spain', 'Barcelona', 'Av. Diagonal 662-664', '08034', 'https://www.planetadelibros.com/', 'info@planetadelibros.com'),
    (7, 'Bertelsmann', 'Germany', 'Gütersloh', 'Carl-Bertelsmann-Straße 270', '33311', 'https://www.bertelsmann.com/', 'info@bertelsmann.com'),
    (8, 'Holtzbrinck Publishing Group', 'Germany', 'Stuttgart', 'Senefelderstraße 12', '70176', 'https://www.holtzbrinck.com/', 'info@holtzbrinck.com');

INSERT INTO book (id, category,author,title,title2,title3,subtitle,volume,publication_year,lang,isbn,publisher,width,length,pages,image,note,price,tms) VALUES
    (1, 1,'J.K. Rowling','Harry Potter and the Philosopher''s Stone',NULL,NULL,NULL,NULL,'1997','EN','9780747532743',1,NULL,NULL,NULL,NULL,NULL,'20.00','2023-06-30 10:00:00'),
    (2, 4,'George R.R. Martin','A Game of Thrones',NULL,NULL,NULL,NULL,'1996','EN','9780553103540',2,NULL,NULL,NULL,NULL,NULL,'25.00','2023-06-30 10:00:00'),
    (3, 8,'Walter Isaacson','Steve Jobs',NULL,NULL,'The Exclusive Biography',NULL,'2011','EN','9781451648539',3,NULL,NULL,NULL,NULL,NULL,'30.00','2023-06-30 10:00:00'),
    (4, 3,'Philip K. Dick','Do Androids Dream of Electric Sheep?',NULL,NULL,NULL,NULL,'1968','EN','9780345404473',4,NULL,NULL,NULL,NULL,NULL,'18.00','2023-06-30 10:00:00'),
    (5, 2,'Yuval Noah Harari','Sapiens: A Brief History of Humankind',NULL,NULL,NULL,NULL,'2014','EN','9780062316097',5,NULL,NULL,NULL,NULL,NULL,'22.00','2023-06-30 10:00:00');
