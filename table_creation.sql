-- Usado para la creacion automatica de UUID
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS genres(
	genre_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	genre_name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS users(
	user_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	full_name VARCHAR(30) NOT NULL, 
	username VARCHAR(20) NOT NULL, 
	passwd VARCHAR(20) NOT NULL, 
	user_state VARCHAR(3) NOT NULL
);

CREATE TABLE IF NOT EXISTS books(
	book_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	book_name VARCHAR(50) NOT NULL, 
	summary VARCHAR(256), 
	price NUMERIC(6,2) NOT NULL,
	book_state VARCHAR(3),
	image VARCHAR(500),
	gen_id INT,
	user_id UUID,
	CONSTRAINT fk_genre FOREIGN KEY(gen_id) REFERENCES genres(genre_id),
	CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);


-- INSERTS

INSERT INTO genres(genre_name)
VALUES 
	('horror'),
	('science fiction'),
	('realism');


INSERT INTO users (full_name, username, passwd, user_state) VALUES
('Alice Johnson', 'alice', 'password123', 'ACT'),
('Bob Martinez', 'bob', 'qwerty456', 'ACT'),
('Charlie Kim', 'charlie', 'admin789', 'INA');


INSERT INTO books (book_name, summary, price, book_state, image, gen_id, user_id) VALUES
('Frankenstein', 
 'A scientist creates life and faces the consequences of his own ambition.', 
 11.99, 'AVL', 'https://example.com/frankenstein.jpg', 1, '95e112bb-3e1b-45cf-83f5-c92790365911'),

('Dracula', 
 'The story of Count Dracula and his attempt to move from Transylvania to England.', 
 10.50, 'AVL', 'https://example.com/dracula.jpg', 1, '95e112bb-3e1b-45cf-83f5-c92790365911'),

('Dune', 
 'A young man becomes the key to his planet’s survival amidst interstellar politics and prophecy.', 
 15.75, 'AVL', 'https://example.com/dune.jpg', 2, '1aec5514-ae9c-40db-9da9-8ecf0eba1ac5'),

('The War of the Worlds', 
 'Earth faces invasion from Martians in this science fiction classic.', 
 13.40, 'AVL', 'https://example.com/war_of_worlds.jpg', 2, 'd658def5-8007-48b2-85d1-184f44247739'),

('Madame Bovary', 
 'A woman trapped in a provincial life seeks fulfillment through love and luxury.', 
 12.80, 'AVL', 'https://example.com/madame_bovary.jpg', 3, '1aec5514-ae9c-40db-9da9-8ecf0eba1ac5'),

('The Catcher in the Rye', 
 'A young man narrates a few days in his life after being expelled from school.', 
 14.20, 'AVL', 'https://example.com/catcher_rye.jpg', 3, 'd658def5-8007-48b2-85d1-184f44247739');



-- Validacion
SELECT * FROM genres;
SELECT * FROM users;
SELECT * FROM books;

SELECT * FROM
books as B 
INNER JOIN
users as U
ON U.user_id = B.user_id
WHERE U.user_id = '95e112bb-3e1b-45cf-83f5-c92790365911';

