DROP TABLE GEFDATABASE.ROOM_CLASSES;
DROP TABLE GEFDATABASE.CLASS_TIME;
DROP TABLE GEFDATABASE.STUDENTS_CLASS;
DROP TABLE GEFDATABASE.COURSE;
DROP TABLE GEFDATABASE.ROOM;

CREATE TABLE GEFDATABASE.Course (CODE_COURSE VARCHAR(5) NOT NULL,
CREDIT INTEGER NOT NULL,
NAME VARCHAR(20) NOT NULL,
MODULE INTEGER NOT NULL,
PRIMARY KEY (CODE_COURSE));

CREATE TABLE GEFDATABASE.Students_Class ( CODE_STUDENTS_CLASS INTEGER NOT NULL, 
CODE_COURSE VARCHAR(5) NOT NULL,
CODE_ROOM VARCHAR(5) NULL,
CODE_BUILDING VARCHAR(10) NULL,
PRIMARY KEY(CODE_STUDENTS_CLASS, CODE_COURSE),
FOREIGN KEY(CODE_COURSE) REFERENCES GEFDATABASE.Course)
FOREIGN KEY(CODE_ROOM, CODE_BUILDING) REFERENCES GEFDATABASE.Room;

CREATE TABLE GEFDATABASE.Class_Time( CODE_STUDENTS_CLASS INTEGER NOT NULL,
CODE_COURSE VARCHAR(5) NOT NULL,
DAY_OF_WEEK INTEGER NOT NULL,
CLASS_TIME VARCHAR(1) NOT NULL,
PRIMARY KEY (CODE_STUDENTS_CLASS, CODE_COURSE, DAY_OF_WEEK, CLASS_TIME),
FOREIGN KEY(CODE_COURSE) REFERENCES GEFDATABASE.Course,
FOREIGN KEY(CODE_STUDENTS_CLASS, CODE_COURSE) REFERENCES GEFDATABASE.Students_Class);

CREATE TABLE GEFDATABASE.Room ( CODE_ROOM VARCHAR(10) NOT NULL,
BUILDING VARCHAR(10) NOT NULL,
CAPACITY INTEGER NOT NULL,
PRIMARY KEY (CODE_ROOM, BUILDING));