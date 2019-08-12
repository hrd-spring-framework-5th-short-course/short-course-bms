create table tb_author
(
  id serial primary key ,
  name varchar,
  contact varchar(20),

  status boolean default true,
  created_at TIMESTAMP default now()
);

create table tb_category
(
  id serial primary key ,
  name varchar,

  status boolean default true,
  created_at TIMESTAMP default now()
);

create table tb_book
(
  id serial primary key ,
  title varchar,
  isbn varchar,
  book_image varchar,

  cate_id integer references tb_category(id),

  publish_date date,

  status boolean default true,
  created_at TIMESTAMP default now()

);


create table tb_book_author
(
  book_id integer not null references tb_book(id),
  author_id integer not null references tb_author(id),

  primary key (book_id, author_id)

);


create table tb_user
(
  id serial primary key,
  username varchar unique ,
  fullname varchar,

  gender varchar,
  email varchar,

  status boolean default true,
  created_at TIMESTAMP default now()

);


create table tb_category_local
(
    id   serial not null,
    name varchar
);


