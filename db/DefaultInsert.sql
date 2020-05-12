/*http://opencity.in/data/chennai-street-names-in-chennai-corporation-ward - To get the list of street name

*/
INSERT INTO LICENCE_TYPE(LICENCE_TYPE_NAME,DELETED_FLAG) VALUES('GYM','N');
INSERT INTO LICENCE_TYPE(LICENCE_TYPE_NAME,DELETED_FLAG) VALUES('PAWNBROKER','N');
INSERT INTO LICENCE_TYPE(LICENCE_TYPE_NAME,DELETED_FLAG) VALUES('GOLD_WHOLESALE','N');
INSERT INTO LICENCE_TYPE(LICENCE_TYPE_NAME,DELETED_FLAG) VALUES('SILVER_WHOLESALE','N');
INSERT INTO LICENCE_TYPE(LICENCE_TYPE_NAME,DELETED_FLAG) VALUES('JEWELLERY','N');
INSERT INTO LICENCE_TYPE(LICENCE_TYPE_NAME,DELETED_FLAG) VALUES('FINANCE','N');
INSERT INTO LICENCE_TYPE(LICENCE_TYPE_NAME,DELETED_FLAG) VALUES('HANDLOAN','N');

INSERT INTO STATE(STATE_NAME,DELETED_FLAG) VALUES('TAMIL NADU','N');
INSERT INTO STATE(STATE_NAME,DELETED_FLAG) VALUES('Rajasthan','N');
INSERT INTO STATE(STATE_NAME,DELETED_FLAG) VALUES('Andhra Pradesh','N');

INSERT INTO CITY(CITY_NAME,STATE_ID,DELETED_FLAG) VALUES('Chennai',(SELECT STATE_ID FROM STATE WHERE STATE_NAME='TAMIL NADU'),'N');
INSERT INTO CITY(CITY_NAME,STATE_ID,DELETED_FLAG) VALUES('Hyd',(SELECT STATE_ID FROM STATE WHERE STATE_NAME='Andhra Pradesh'),'N');
INSERT INTO CITY(CITY_NAME,STATE_ID,DELETED_FLAG) VALUES('Jaipur',(SELECT STATE_ID FROM STATE WHERE STATE_NAME='Rajasthan'),'N');

INSERT INTO ARIA(AREA_NAME,CITY_ID,PIN_CODE,DELETED_FLAG) VALUES('Madhavaram',(SELECT CITY_ID FROM CITY WHERE CITY_NAME='CHENNAI'),600060,'N');
INSERT INTO ARIA(AREA_NAME,CITY_ID,PIN_CODE,DELETED_FLAG) VALUES('Moolakadai',(SELECT CITY_ID FROM CITY WHERE CITY_NAME='CHENNAI'),600051,'N');
INSERT INTO ARIA(AREA_NAME,CITY_ID,PIN_CODE,DELETED_FLAG) VALUES('Kodambakkam',(SELECT CITY_ID FROM CITY WHERE CITY_NAME='CHENNAI'),600024,'N');
INSERT INTO ARIA(AREA_NAME,CITY_ID,PIN_CODE,DELETED_FLAG) VALUES('Manali',(SELECT CITY_ID FROM CITY WHERE CITY_NAME='CHENNAI'),600090,'N');
INSERT INTO ARIA(AREA_NAME,CITY_ID,PIN_CODE,DELETED_FLAG) VALUES('Perambur',(SELECT CITY_ID FROM CITY WHERE CITY_NAME='CHENNAI'),600011,'N');

INSERT INTO STREET(STREET_NAME,AREA_ID,DELETED_FLAG) VALUES('Siva Sakthi Nagar 1st Street',(SELECT AREA_ID FROM ARIA WHERE AREA_NAME='Madhavaram'),'N');
INSERT INTO STREET(STREET_NAME,AREA_ID,DELETED_FLAG) VALUES('Siva Sakthi Nagar 2nd Street',(SELECT AREA_ID FROM ARIA WHERE AREA_NAME='Madhavaram'),'N');
INSERT INTO STREET(STREET_NAME,AREA_ID,DELETED_FLAG) VALUES('Roja Nagar',(SELECT AREA_ID FROM ARIA WHERE AREA_NAME='Madhavaram'),'N');
INSERT INTO STREET(STREET_NAME,AREA_ID,DELETED_FLAG) VALUES('United India Colony',(SELECT AREA_ID FROM ARIA WHERE AREA_NAME='Kodambakkam'),'N');
INSERT INTO STREET(STREET_NAME,AREA_ID,DELETED_FLAG) VALUES('CRP Garden',(SELECT AREA_ID FROM ARIA WHERE AREA_NAME='Kodambakkam'),'N');
INSERT INTO STREET(STREET_NAME,AREA_ID,DELETED_FLAG) VALUES('Taylor Street',(SELECT AREA_ID FROM ARIA WHERE AREA_NAME='Kodambakkam'),'N');



INSERT INTO BANK(BANK_NAME,BANK_BRANCH,ACCOUNT_HOLDER_NAME,ACCOUNT_NUMBER,ACCOUNT_TYPE,IFSC_CODE,DELETED_FLAG) VALUES('IOB','MADHAVARAM','VIKASH','12456321458784','CURRENT','IOB226521477','N');

INSERT INTO USER_TYPE(USER_TYPE,DELETED_FLAG)VALUES('GST','N');
INSERT INTO USER_TYPE(USER_TYPE,DELETED_FLAG)VALUES('NON_GST','N');
INSERT INTO USER_TYPE(USER_TYPE,DELETED_FLAG)VALUES('ADMIN','N');

INSERT INTO CONTACT_TYPE(CONTACT_TYPE_NAME,DELETED_FLAG)VALUES('RETAIL','N');
INSERT INTO CONTACT_TYPE(CONTACT_TYPE_NAME,DELETED_FLAG)VALUES('WHOLESALE','N');
INSERT INTO CONTACT_TYPE(CONTACT_TYPE_NAME,DELETED_FLAG)VALUES('SUPPLIER','N');

INSERT INTO BILL_TYPE(BILL_TYPE_NAME,DELETED_FLAG)VALUES('GST','N');
INSERT INTO BILL_TYPE(BILL_TYPE_NAME,DELETED_FLAG)VALUES('NON_GST','N');
INSERT INTO BILL_TYPE(BILL_TYPE_NAME,DELETED_FLAG)VALUES('ADMIN','N');

INSERT INTO METAL(METAL_CODE,METAL_NAME,DELETED_FLAG) VALUES ('GOLD','Gold','N');
INSERT INTO METAL(METAL_CODE,METAL_NAME,DELETED_FLAG) VALUES ('SILVER','Silver','N');

INSERT INTO ORNAMENT_GROUP(ORNAMENT_GROUP_NAME,DELETED_FLAG) VALUES('DEFAULT','N');

INSERT INTO ORNAMENT_SUB_GROUP(ORNAMENT_SUB_GROUP_NAME,DELETED_FLAG) VALUES('DEFAULT','N');

INSERT INTO ENTRY_TYPE(ENTRY_TYPE,DELETED_FLAG)VALUES('GST','N');
INSERT INTO ENTRY_TYPE(ENTRY_TYPE,DELETED_FLAG)VALUES('NON_GST','N');

INSERT INTO LICENCE_OPENING_STOCK_DETAILS(ORNAMENT_ID,GST_GRAMS,NONGST_GRAMS,DELETED_FLAG,LICENCE_ID)VALUES(3,14,15,'N',2);