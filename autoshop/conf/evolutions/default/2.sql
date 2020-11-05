# --- Sample dataset

# --- !Ups
INSERT INTO brand (name, country) values ('BMW', 'GER');
INSERT INTO brand (name, country) values ('KIA', 'KOR');
INSERT INTO brand (name, country) values ('Lada', 'RUS');

INSERT INTO model (name, yearStart, yearEnd) values ('x1', 2013, 2020);
INSERT INTO model (name, yearStart, yearEnd) values ('ceed', 2010, 2021);
INSERT INTO model (name, yearStart, yearEnd) values ('priora', 1980, 2019);

INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('Lada', 'priora', 2005, 290000, 30000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('KIA', 'ceed', 2015, 78000, 350000);
INSERT INTO store (brand_name, model_name, year_created, milage, price)
VALUES ('BMW', 'x1', 2020, 2000, 1550000);


# --- !Downs
DELETE FROM brand
DELETE FROM model
DELETE FROM store
