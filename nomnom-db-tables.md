DROP TABLE IF EXISTS restaurant CASCADE;
DROP TABLE IF EXISTS kitchen CASCADE;
DROP TABLE IF EXISTS location CASCADE;
DROP TABLE IF EXISTS district CASCADE;


CREATE TABLE kitchen (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE district (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE location (
    id SERIAL PRIMARY KEY,
    address VARCHAR(255),
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    district_id BIGINT,
    CONSTRAINT fk_district
        FOREIGN KEY (district_id)
        REFERENCES district(id)
);

CREATE TABLE restaurant (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    location_id BIGINT UNIQUE,
    CONSTRAINT fk_location
        FOREIGN KEY (location_id)
        REFERENCES location(id),
    image VARCHAR(255),
    kitchen_id BIGINT,
    CONSTRAINT fk_kitchen
        FOREIGN KEY (kitchen_id)
        REFERENCES kitchen(id)
);


INSERT INTO kitchen (name) VALUES
('Nordiskt'),
('Italienskt'),
('Japanskt'),
('Spanskt');

INSERT INTO district (name) VALUES
('Södermalm'),
('Östermalm'),
('Vasastan'),
('Kungsholmen');

INSERT INTO location (address, latitude, longitude, district_id) VALUES
('Nytorgsgatan 30, 116 40 Stockholm', 59.3165, 18.0679, 1),
('Odengatan 39, 113 51 Stockholm', 59.3422, 18.0557, 3),
('Kronobergsgatan 37, 112 33 Stockholm', 59.3329, 18.0305, 4),
('Tegnérgatan 41, 111 61 Stockholm', 59.3408, 18.0621, 2),
('Sveavägen 46, 111 34 Stockholm', 59.3378, 18.0561, 3), 
('Birger Jarlsgatan 36, 111 45 Stockholm', 59.3385, 18.0732, 2), 
('Kungsgatan 63, 111 22 Stockholm', 59.3326, 18.0664, 4); 

INSERT INTO restaurant (name, location_id,  image, kitchen_id) VALUES
('Meatballs for the People', 1, 'image1.jpg', 1), 
('Pom & Flora', 2, 'image2.jpg', 1), 
('AG', 3, 'image3.jpg', 1),
('Rolfs Kök', 4, 'image4.jpg', 1),
('Pasta e Basta', 5, 'image6.jpg', 2),
('Sushi House', 6, 'image7.jpg', 3), 
('Tapas Bar', 7, 'image8.jpg', 4);
