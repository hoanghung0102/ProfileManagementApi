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

create table users
(
  id bigserial not null
    constraint users_pkey
    primary key,
  address varchar(255),
  city varchar(255),
  gender boolean not null,
  pwd varchar(255),
  user_name varchar(255)
)
;

create table role
(
  role_id bigint not null
    constraint role_pkey
    primary key,
  role_name varchar(30) not null
)
;

comment on table role is 'Role of application'
;

create table user_role
(
  id bigint not null
    constraint user_role_users_id_fk
    references users,
  user_id bigint not null,
  role_id bigint not null
    constraint user_role_role_role_id_fk
    references role
)
;

comment on table user_role is 'Manage role base on user'
;