# --- Sample dataset

# --- !Ups
INSERT INTO brand (name, country) values ('Audi', 'GER');
INSERT INTO brand (name, country) values ('VW', 'GER');
INSERT INTO brand (name, country) values ('Lexus', 'JAP');
INSERT INTO brand (name, country) values ('Lada', 'RUS');
INSERT INTO brand (name, country) values ('KIA', 'RUS');
INSERT INTO brand (name, country) values ('Skoda', 'RUS');
INSERT INTO brand (name, country) values ('Hyundai', 'KOR');

INSERT INTO model (name, yearStart, yearEnd) values ('A7 4G', 2010, 2017);
INSERT INTO model (name, yearStart, yearEnd) values ('A7 4K', 2017, 2020);
INSERT INTO model (name, yearStart, yearEnd) values ('Passat B8', 2017, 2020);
INSERT INTO model (name, yearStart, yearEnd) values ('GX 470', 2002, 2009);
INSERT INTO model (name, yearStart, yearEnd) values ('GX 460', 2017, 2020);
INSERT INTO model (name, yearStart, yearEnd) values ('Priora', 2007, 2018);
INSERT INTO model (name, yearStart, yearEnd) values ('Ceed', 2018, 2020);
INSERT INTO model (name, yearStart, yearEnd) values ('Octavia 1U', 1996, 2010);
INSERT INTO model (name, yearStart, yearEnd) values ('Octavia 1Z', 2004, 2013);
INSERT INTO model (name, yearStart, yearEnd) values ('Sonata 8DN', 2019, 2020);

INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('Audi', 'A7 4G', 2015, 70000, 1300000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('Audi', 'A7 4K', 2020, 1500, 4300000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('VW', 'Passat B8', 2020, 950, 2000000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('Lexus', 'GX 470', 2008, 120000, 1900000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('Lexus', 'GX 460', 2020, 7300, 5000000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('Lada', 'Priora', 2015, 43000, 420000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('KIA', 'Ceed', 2018, 22000, 1150000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('Skoda', 'Octavia 1U', 2008, 170000, 400000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('Skoda', 'Octavia 1Z', 2011, 150000, 130000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('Hyundai', 'Sonata 8DN', 2020, 690, 1950000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)

# --- !Downs
DELETE FROM brand;
DELETE FROM model;
DELETE FROM store;
