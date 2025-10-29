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