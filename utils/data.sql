-- -----------------------------------------------------
-- This script inserts some data in the database.
-- REMINDER: Before running the script, please create the database with 'database.sql'
-- -----------------------------------------------------

-- Insert some USERS
INSERT INTO `dbinterjob`.`USER`
           (`USERNAME`,`PASSWORD`,`NAME`,`LAST_NAME`,`TWITTER`,`INSTAGRAM`,`WEBPAGE`,`FOTO`)
    VALUES ('User1','123456','NameOfUser1','LastnameOfUser1','User1', 'User1','User1.abc','User1.jpg');
INSERT INTO `dbinterjob`.`USER`
           (`USERNAME`,`PASSWORD`,`NAME`,`LAST_NAME`,`TWITTER`,`INSTAGRAM`,`WEBPAGE`,`FOTO`)
    VALUES ('User2','123456','NameOfUser2','LastnameOfUser2','User2', 'User2','User2.abc','User2.jpg');
INSERT INTO `dbinterjob`.`USER`
           (`USERNAME`,`PASSWORD`,`NAME`,`LAST_NAME`,`TWITTER`,`INSTAGRAM`,`WEBPAGE`,`FOTO`)
    VALUES ('User3','123456','NameOfUser3','LastnameOfUser3','User3', 'User3','User3.abc','User3.jpg');

-- Insert some HOBBIES
INSERT INTO `dbinterjob`.`HOBBY`
           (`NAME`)
    VALUES ('play football');
INSERT INTO `dbinterjob`.`HOBBY`
           (`NAME`)
    VALUES ('read books');
INSERT INTO `dbinterjob`.`HOBBY`
           (`NAME`)
    VALUES ('watch movies');

-- Insert some STUDIES
INSERT INTO `dbinterjob`.`STUDIES`
           (`START_DATE`,`END_DATE`,`DESCRIPTION`,`LOCATION`,`USER_ID`)
    VALUES ('2014-01-01','2016-01-01','Bachelor of Science','Universidad de Málaga',1);
INSERT INTO `dbinterjob`.`STUDIES`
           (`START_DATE`,`END_DATE`,`DESCRIPTION`,`LOCATION`,`USER_ID`)
    VALUES ('2016-01-01','2018-01-01','Master of Science','Universidad de Sevilla',1);
INSERT INTO `dbinterjob`.`STUDIES`
           (`START_DATE`,`END_DATE`,`DESCRIPTION`,`LOCATION`,`USER_ID`)
    VALUES ('2015-01-01','2017-01-01','Bachelor of Arts','Universidad de Málaga',2);
INSERT INTO `dbinterjob`.`STUDIES`
           (`START_DATE`,`END_DATE`,`DESCRIPTION`,`LOCATION`,`USER_ID`)
    VALUES ('2013-01-01','2015-01-01','Bachelor of Arts','Universidad de Granada',3);

-- Insert some WORK EXPERIENCES
INSERT INTO `dbinterjob`.`WORK_EXPERIENCE`
           (`START_DATE`,`END_DATE`,`BUSINESS`,`JOB`,`WEBPAGE`,`USER_ID`)
    VALUES ('2014-01-01','2015-01-01','Microsoft','Web-Developer','microsoft.com',1);
INSERT INTO `dbinterjob`.`WORK_EXPERIENCE`
           (`START_DATE`,`END_DATE`,`BUSINESS`,`JOB`,`WEBPAGE`,`USER_ID`)
    VALUES ('2015-01-01',NULL,'Facebook','Web-Developer','facebook.com',1);
INSERT INTO `dbinterjob`.`WORK_EXPERIENCE`
           (`START_DATE`,`END_DATE`,`BUSINESS`,`JOB`,`WEBPAGE`,`USER_ID`)
    VALUES ('2013-01-01','2014-01-01','Google','Front-End Developer','google.com',2);
INSERT INTO `dbinterjob`.`WORK_EXPERIENCE`
           (`START_DATE`,`END_DATE`,`BUSINESS`,`JOB`,`WEBPAGE`,`USER_ID`)
    VALUES ('2015-01-01','2017-01-01','Netflix','Back-End Developer','netflix.com',3);

-- Insert some MESSAGES
INSERT INTO `dbinterjob`.`MESSAGE`
           (`DATE`,`CONTENT`,`READ`,`USER_FROM`,`USER_TO`)
    VALUES ('2017-01-01 00:00:00','This is a test. :D',1,1,2);
INSERT INTO `dbinterjob`.`MESSAGE`
           (`DATE`,`CONTENT`,`READ`,`USER_FROM`,`USER_TO`)
    VALUES ('2017-01-01 00:00:01','This is an answer to the first test message. :D',0,2,1);
INSERT INTO `dbinterjob`.`MESSAGE`
           (`DATE`,`CONTENT`,`READ`,`USER_FROM`,`USER_TO`)
    VALUES ('2017-01-01 00:00:03','This is a test. :D',0,1,3);

-- Insert some FRIENDSHIPS
INSERT INTO `dbinterjob`.`FRIENDSHIP`
           (`CONFIRMED`,`USER_ID`,`USER_ID1`)
    VALUES (1,1,2);
INSERT INTO `dbinterjob`.`FRIENDSHIP`
           (`CONFIRMED`,`USER_ID`,`USER_ID1`)
    VALUES (0,1,3);
INSERT INTO `dbinterjob`.`FRIENDSHIP`
           (`CONFIRMED`,`USER_ID`,`USER_ID1`)
    VALUES (1,2,3);

-- Connect some USERS with a HOBBY
INSERT INTO `dbinterjob`.`USER_has_HOBBY`
           (`USER_ID`,`HOBBY_ID`)
    VALUES (1,1);
INSERT INTO `dbinterjob`.`USER_has_HOBBY`
           (`USER_ID`,`HOBBY_ID`)
    VALUES (1,3);
INSERT INTO `dbinterjob`.`USER_has_HOBBY`
           (`USER_ID`,`HOBBY_ID`)
    VALUES (2,3);
