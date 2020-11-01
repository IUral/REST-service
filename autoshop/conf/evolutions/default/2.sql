# --- Sample dataset

# --- !Ups
INSERT INTO public.brand (name, country) values ('BMW', 'GER');
INSERT INTO public.brand (name, country) values ('KIA', 'KOR');
INSERT INTO public.brand (name, country) values ('LADA', 'RUS');

INSERT INTO public.model (name, yearStart, yearEnd) values ('x1', 2013, 2020);
INSERT INTO public.model (name, yearStart, yearEnd) values ('ceed', 2010, 2021);
INSERT INTO public.model (name, yearStart, yearEnd) values ('priora', 1980, 2019);

INSERT INTO public.store (brand_name, model_name, year_created, milage, price)
VALUES ('LADA', 'priora', 2005, 290000, 30000);
INSERT INTO public.store (brand_name, model_name, year_created, milage, price)
VALUES ('KIA', 'ceed', 2015, 78000, 350000);
INSERT INTO public.store (brand_name, model_name, year_created, milage, price)
VALUES ('BMW', 'x1', 2020, 2000, 1550000);


# --- !Downs
DELETE FROM public.brand
DELETE FROM public.model
DELETE FROM public.store
