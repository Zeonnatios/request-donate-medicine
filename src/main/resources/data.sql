insert into USERS (USERNAME, PASSWORD, AGE, GENDER, ADDRESS)
  values ('Admin', 'Admin@123', 22, 'Male', 'Admin Address'),
         ('User', 'User@123', 22, 'Male', 'User Address');

insert into MEDICINE (NAME, CATEGORY, QUANTITY)
  values ('Resfenol', 'FEVER', 120);

 insert into DONATE (MED_CATEGORY, MED_NAME, MED_QUANTITY, USERNAME, ADDRESS, REQUESTED_DATE)
  values ('FEVER', 'Resfenol', 10, 'User', 'User Address', '2022-05-29');

