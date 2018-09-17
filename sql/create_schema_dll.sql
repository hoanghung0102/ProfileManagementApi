create table person
(
  id bigserial not null
    constraint person_pkey
    primary key,
  address varchar(255),
  pcity varchar(255),
  name varchar(255),
  sex boolean not null
)
;

create table "user"
(
  id bigserial not null
    constraint user_pkey
    primary key,
  user_name varchar,
  pwd varchar,
  gender boolean default true,
  address varchar,
  city varchar
)
;

comment on table "user" is 'User Management'
;

comment on column "user".gender is 'True is male
False is female'
;

