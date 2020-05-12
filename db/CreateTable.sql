CREATE DATABASE INVENTORY;
USE INVENTORY;

CREATE TABLE LICENCE_TYPE(
	LICENCE_TYPE_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	LICENCE_TYPE_NAME VARCHAR(255),
	DELETED_FLAG VARCHAR(1)
);


CREATE TABLE LICENCE (
  LICENCE_ID int(11) NOT NULL auto_increment PRIMARY KEY,
  LICENCE_NAME varchar(255) default NULL,
  OWNER_NAME varchar(255) default NULL,
  LICENCE_NUMBER varchar(255) default NULL,
  ADDRESS varchar(255) default NULL,
  LAND_LINE varchar(255) default NULL,
  MOBILE varchar(255) default NULL,
  EMAIL varchar(255) default NULL,
  WEBSITE varchar(255) default NULL, 
  GST_NUMBER varchar(255) default NULL,
  DELETED_FLAG VARCHAR(1),
  LICENCE_TYPE_ID INT(11),
  STATE_ID INT(11),
  BANK_ID INT(11)
);




CREATE TABLE BANK(
	BANK_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	BANK_NAME VARCHAR(255),
	BANK_BRANCH VARCHAR(255),
	ACCOUNT_HOLDER_NAME VARCHAR(255),
	ACCOUNT_NUMBER VARCHAR(255),
	ACCOUNT_TYPE VARCHAR(255),
	IFSC_CODE VARCHAR(255),
	DELETED_FLAG VARCHAR(1)
);

CREATE TABLE USER_TYPE(
	USER_TYPE_ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	USER_TYPE VARCHAR(255),
	DELETED_FLAG VARCHAR(1)
);


CREATE TABLE USER (
  USER_ID int(11) NOT NULL auto_increment PRIMARY KEY,
  USER_NAME varchar(255) default NULL,
  PASSWORD varchar(255) default NULL,
  DELETED_FLAG VARCHAR(1),
  USER_TYPE_ID INT(11)
);

CREATE TABLE STATE(
    STATE_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    STATE_NAME VARCHAR(255),
    DELETED_FLAG VARCHAR(1)
);

CREATE TABLE CITY(
    CITY_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CITY_NAME VARCHAR(255),
    STATE_ID INT(11),
    DELETED_FLAG VARCHAR(1)
);

CREATE TABLE ARIA(
    AREA_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    AREA_NAME VARCHAR(255),
    CITY_ID INT(11),
    PIN_CODE INT(11),
    DELETED_FLAG VARCHAR(1)
);

CREATE TABLE STREET(
    STREET_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    STREET_NAME VARCHAR(255),
    AREA_ID INT(11),
    DELETED_FLAG VARCHAR(1)
);
CREATE TABLE CONTACT_TYPE(
	CONTACT_TYPE_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	CONTACT_TYPE_NAME VARCHAR(255),
	DELETED_FLAG VARCHAR(1)
);
CREATE TABLE CONTACT(
    CONTACT_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CONTACT_NAME VARCHAR(255),
    DATE_OF_BIRTH DATE,
    DOOR_NO VARCHAR(255),
    STREET_ID INT(11),
    MOBILE VARCHAR(255),
    EMAIL VARCHAR(255),
    IS_ENABLED VARCHAR(1),
    DELETED_FLAG VARCHAR(1),
    CREATED_DATE DATE,
    CONTACT_TYPE_ID INT(11),
    GST_NUMBER VARCHAR(255)
);
CREATE TABLE BILL_TYPE(
	BILL_TYPE_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	BILL_TYPE_NAME VARCHAR(255),
	DELETED_FLAG VARCHAR(1)
);
CREATE TABLE BILL(
	BILL_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	CUSTOMER_ID INT NOT NULL,
	LICENCE_ID INT NOT NULL,
	DELETED_FLAG VARCHAR(1) NOT NULL,
	BILL_TYPE_ID INT NOT NULL,
	BILL_NUMBER VARCHAR(255),
	BILL_DATE DATE,
	CREATED_BY_USER_ID INT,
	CREATED_DATE_TIME DATE,
	UPDATED_BY_USER_ID INT,
	LAST_UPDATED_DATE_TIME DATE,
	METAL_ID INT NOT NULL,
	
	BILL_GROSS_WEIGHT DOUBLE,
	BILL_WEIGHT_LESS DOUBLE,
	BILL_WEIGHT DOUBLE,
	BILL_PURE_WEIGHT DOUBLE,
	
	RETURN_GROSS_WEIGHT DOUBLE,
	RETURN_WEIGHT_LESS DOUBLE,
	RETURN_WEIGHT DOUBLE,
	RETURN_PURE_WEIGHT DOUBLE,
	
	GROSS_WEIGHT DOUBLE,
	WEIGHT_LESS DOUBLE,
	WEIGHT DOUBLE,
	PURE_WEIGHT DOUBLE,
	
	BILL_AMOUNT DOUBLE,
	BILL_TAX_AMOUNT DOUBLE,
	BILL_ROUND_OFF DOUBLE,
	BILL_TOTAL_AMOUNT DOUBLE,
	
	RETURN_AMOUNT DOUBLE,
	RETURN_ROUND_0FF DOUBLE,
	RETURN_TOTAL_AMOUNT DOUBLE,	
	
	AMOUNT DOUBLE,
	TAX_AMOUNT DOUBLE,
	ROUND_0FF DOUBLE,
	LESS_AMOUNT DOUBLE,
	TOTAL_AMOUNT DOUBLE,
	AMOUNT_IN_WORDS DOUBLE,
	
	BILL_METAL_BALANCE DOUBLE,
	RETURN_METAL DOUBLE,
	METAL_BALANCE DOUBLE,
	
	NO_OF_PIECE INT(11),
	BILL_SOURCE VARCHAR(255)
	
);

CREATE TABLE BILL_DETAILS(
	BILL_DETAILS_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	BILL_ID INT NOT NULL,
	DELETED_FLAG VARCHAR(1) NOT NULL,
	BARCODE_ID INT NULL,
	
	ORNAMENT_ID INT NOT NULL,
	GROSS_WEIGHT DOUBLE,
	WEIGHT_LESS DOUBLE,
	WEIGHT DOUBLE,
	PURITY DOUBLE,
	PURE_WEIGHT DOUBLE,
	WASTAGE DOUBLE
	RATE DOUBLE,
	
	TAX_PERCENTAGE DOUBLE,
	ORNAMENT_AMOUNT DOUBLE,
	TAX_AMOUNT DOUBLE,
	
	MC_RATE DOUBLE,
	MC_PER_PIECE DOUBLE,
	MC_AMOUNT DOUBLE,
	
	ROUND_OFF DOUBLE,
	AMOUNT DOUBLE,
	NO_OF_PIECE INT,
	DIRECT_AMOUNT DOUBLE,
	
	SNO INT(11)
	
);

create table employee(
	EMPLOYEE_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	EMPLOYEE_NAME VARCHAR(255)
);

CREATE TABLE EMPLOYEE_DETAILS(
	EMPLOYEE_DETAILS_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	PHONE_NUMBER VARCHAR(255),
	EMPLOYEE_ID INT(11)
);

CREATE TABLE METAL(
	METAL_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	METAL_CODE VARCHAR(255),
	METAL_NAME VARCHAR(255),
	DELETED_FLAG VARCHAR(1)
);
CREATE TABLE ORNAMENT_GROUP(
	ORNAMENT_GROUP_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ORNAMENT_GROUP_NAME VARCHAR(255),
	DELETED_FLAG VARCHAR(1)
);

CREATE TABLE ORNAMENT_SUB_GROUP(
	ORNAMENT_SUB_GROUP_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ORNAMENT_SUB_GROUP_NAME VARCHAR(255),
	DELETED_FLAG VARCHAR(1)
);

CREATE TABLE ORNAMENT(
	ORNAMENT_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	METAL_ID INT(11),
	ORNAMENT_GROUP_ID INT(11),
	ORNAMENT_SUB_GROUP_ID INT(11),
	ORNAMENT_NAME VARCHAR(255),
	ORNAMENT_KEY_CODE VARCHAR(255),
	GST_PERCENTAGE DOUBLE,
	DELETED_FLAG VARCHAR(1),
	LICENCE_ID INT(11)
);

CREATE TABLE ENTRY_TYPE(
	ENTRY_TYPE_ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ENTRY_TYPE VARCHAR(255),
	DELETED_FLAG VARCHAR(1)
);

CREATE TABLE LICENCE_OPENING_STOCK_DETAILS(
	LICENCE_OPENING_STOCK_DETAILS_ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	ORNAMENT_ID INT(11),
	GST_GRAMS DOUBLE,
	NONGST_GRAMS DOUBLE,
	DELETED_FLAG VARCHAR(1),
	LICENCE_ID INT(11)	
);

CREATE TABLE STREET(
	STREET_ID
);

CREATE TABLE CONTACT(
	CONTACT_ID INT(11) PRIMARY KEY AUTO_INCREMENT,
	CONTACT_NAME VARCHAR(255),
	DOOR_NO VARCHAR(255),
	STREET_ID INT(11),
	GST_NO VARCHAR(255),
	DELETED_FLAG VARCHAR(1),
	CONTACT_TYPE_ID INT(11)
);