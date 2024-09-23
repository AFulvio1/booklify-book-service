INSERT INTO public.category ("name")
VALUES
('Fiction'),
('Non-fiction'),
('Science Fiction'),
('Fantasy'),
('Mystery'),
('Thriller'),
('Romance'),
('Biography'),
('History'),
('Self-help');

INSERT INTO publisher (name, country, city, address, zip, website, contacts)
VALUES
('Penguin Random House', 'USA', 'New York', '1745 Broadway', '10019', 'https://www.penguinrandomhouse.com/', 'contact@penguinrandomhouse.com'),
('HarperCollins Publishers', 'USA', 'New York', '195 Broadway', '10007', 'https://www.harpercollins.com/', 'customerservice@harpercollins.com'),
('Simon & Schuster', 'USA', 'New York', '1230 Avenue of the Americas', '10020', 'https://www.simonandschuster.com/', 'webmaster@simonandschuster.com'),
('Macmillan Publishers', 'USA', 'New York', '120 Broadway', '10271', 'https://us.macmillan.com/', 'info@macmillan.com'),
('Hachette Livre', 'France', 'Paris', '58 Rue Jean Bleuzen', '92170', 'https://www.hachette.com/', 'contact@hachette.com'),
('Grupo Planeta', 'Spain', 'Barcelona', 'Av. Diagonal 662-664', '08034', 'https://www.planetadelibros.com/', 'info@planetadelibros.com'),
('Bertelsmann', 'Germany', 'Gütersloh', 'Carl-Bertelsmann-Straße 270', '33311', 'https://www.bertelsmann.com/', 'info@bertelsmann.com'),
('Holtzbrinck Publishing Group', 'Germany', 'Stuttgart', 'Senefelderstraße 12', '70176', 'https://www.holtzbrinck.com/', 'info@holtzbrinck.com');

INSERT INTO public.book (category, author, title, subtitle, "year", "language", isbn, publisher, price, tms)
VALUES
(8, 'J.K. Rowling', 'Harry Potter and the Philosopher''s Stone', NULL, '1997', 'EN', '9780747532743', 1, '20.00', '2023-06-30 10:00:00'),
(11, 'George R.R. Martin', 'A Game of Thrones', NULL, '1996', 'EN', '9780553103540', 2, '25.00', '2023-06-30 10:00:00'),
(15, 'Walter Isaacson', 'Steve Jobs', 'The Exclusive Biography', '2011', 'EN', '9781451648539', 3, '30.00', '2023-06-30 10:00:00'),
(10, 'Philip K. Dick', 'Do Androids Dream of Electric Sheep?', NULL, '1968', 'EN', '9780345404473', 4, '18.00', '2023-06-30 10:00:00'),
(9, 'Yuval Noah Harari', 'Sapiens: A Brief History of Humankind', NULL, '2014', 'EN', '9780062316097', 5, '22.00', '2023-06-30 10:00:00');
