-- Table: public.person

-- DROP TABLE public.person;

CREATE TABLE public.person
(
  id bigint NOT NULL DEFAULT nextval('person_id_seq'::regclass),
  name character varying,
  address character varying,
  pcity character varying,
  sex boolean DEFAULT true, -- true is male
  CONSTRAINT person_id_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.person
  OWNER TO postgres;
COMMENT ON COLUMN public.person.sex IS 'true is male';
