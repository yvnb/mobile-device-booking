create table USERS (
  ID bigint not null AUTO_INCREMENT,
  USER_NAME varchar(100) not null,
  PASSWORD varchar(100) not null,
  EMAIL varchar(100) not null,
  STATUS int not null,
  PRIMARY KEY ( ID )
);

create table MOBILEDEVICE (
  ID bigint not null AUTO_INCREMENT,
  DEVICE_NAME varchar(100) not null,
  BRAND varchar(100) not null,
  TECHNOLOGY varchar(50) not null,
  _2G_BANDS VARCHAR(100) ARRAY,
  _3G_BANDS VARCHAR(100) ARRAY,
  _4G_BANDS VARCHAR(100) ARRAY,
  PRIMARY KEY ( ID )
);

create table USERROLES (
  USER_ID bigint not null,
  ROLES varchar(100) ARRAY,
  PRIMARY KEY ( USER_ID )
);

create table MOBILEBOOKING (
  ID bigint not null AUTO_INCREMENT,
  USER_ID bigint not null,
  DEVICE_ID bigint not null,
  BOOKING_DATE date not null,
  QUANTITY int not null,
  STATUS int not null,
  PRIMARY KEY ( ID )
);

create table MOBILEINVENTORY (
  MOBILE_ID bigint not null,
  QUANTITY int not null,
  STATUS int not null,
  PRIMARY KEY ( MOBILE_ID )
);
