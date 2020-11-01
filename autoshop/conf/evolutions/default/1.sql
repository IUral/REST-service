# --- First database schema

# --- !Ups
CREATE TABLE public.brand
(
    name character varying(50) NOT NULL,
    country character varying(50) NOT NULL,
    PRIMARY KEY (name)
);

CREATE TABLE public.model
(
    name character varying(50) NOT NULL,
    yearStart integer NOT NULL,
    yearEnd integer NOT NULL,
    PRIMARY KEY (name)
);

CREATE TABLE public.store
(
    brand_name character varying(50) NOT NULL REFERENCES public.brand,
    model_name character varying(50) NOT NULL REFERENCES public.model,
    year_created integer NOT NULL,
    milage integer NOT NULL,
    price integer NOT NULL,
    PRIMARY KEY (brand_name, model_name)
);


# --- !Downs
DROP TABLE IF EXISTS public.brand;
DROP TABLE IF EXISTS public.model;
DROP TABLE IF EXISTS public.store;