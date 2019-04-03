create table auth
(
  id serial not null
    constraint auth_pk
      primary key,
  authorization_code varchar,
  access_token varchar,
  refresh_token varchar,
  expired_token boolean,
  expires_in integer,
  scope varchar,
  token_type varchar,
  user_id varchar
);

alter table auth owner to postgres;

create unique index auth_id_uindex
  on auth (id);

create table users
(
  id serial not null
    constraint users_pk
      primary key,
  first_name varchar,
  last_name varchar,
  date_start date,
  date_end date,
  birthday date
);

alter table users owner to postgres;

create unique index users_id_uindex
  on users (id);

create table trackeractivity
(
  id serial not null
    constraint trackeractivity_pk
      primary key,
  calories integer,
  steps integer,
  distance double precision,
  minutessedentary integer,
  minuteslightlyactive integer,
  minutesfairlyactive integer,
  minutesveryactive integer,
  activitycalories integer,
  user_id integer
    constraint user_id
      references users
      on update cascade on delete cascade,
  datetime date
);

alter table trackeractivity owner to postgres;

create unique index trackeractivity_id_uindex
  on trackeractivity (id);

