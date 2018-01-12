drop table tbl_user if exists;

CREATE TABLE tbl_user (
  id varchar(40) NOT NULL,
  username varchar(45) NOT NULL,
  email varchar(45) NOT NULL
);