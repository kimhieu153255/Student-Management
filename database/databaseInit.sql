ALTER USER system IDENTIFIED BY 153255;

DROP TABLE USERADMIN;
CREATE TABLE USERADMIN (
    id NUMBER(10) PRIMARY KEY,
    username VARCHAR2(50) NOT NULL,
    password VARCHAR2(50) NOT NULL
);
INSERT INTO USERADMIN VALUES (1,'kimhieu','123');
INSERT INTO USERADMIN VALUES (2,'KIMHIEU2','123');
/
DROP TABLE SCORE_BOARD;
DROP TABLE COURSE;
DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    ID NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY(START WITH 1 INCREMENT BY 1),
    NAME VARCHAR2(50),
    GRADE INT,
    BIRTHDAY DATE,
    ADDRESS VARCHAR2(100),
    NOTES VARCHAR2(100),
    CONSTRAINT PK_STUDENT PRIMARY KEY (ID)
);
GRANT INSERT, SELECT,DELETE,UPDATE ON STUDENT TO SYSTEM;
/
CREATE TABLE COURSE(
    ID NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY(START WITH 1 INCREMENT BY 1),
    NAME VARCHAR2(50),
    LECTURER VARCHAR2(50),
    YEAR float,
    NOTES VARCHAR2(50),
    CONSTRAINT PK_COURSE PRIMARY KEY (ID)
);
GRANT INSERT, SELECT,DELETE,UPDATE ON COURSE TO SYSTEM;
/

CREATE TABLE SCORE_BOARD(
    STUDENT_ID NUMBER,
    COURSE_ID NUMBER,
    SCORE FLOAT
);
GRANT INSERT, SELECT,DELETE,UPDATE ON SCORE_BOARD TO SYSTEM;
ALTER TABLE SCORE_BOARD ADD CONSTRAINT FK_SCORE_STUDENT FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT(ID);
ALTER TABLE SCORE_BOARD ADD CONSTRAINT FK_SCORE_COURSE FOREIGN KEY (COURSE_ID) REFERENCES COURSE(ID);
/
INSERT INTO STUDENT VALUES (NULL, 'LE KIM HIEU1', 12, TO_DATE('21/5/2002', 'DD/MM/YYYY'), 'PHU YEN1','STUDENT1');
INSERT INTO STUDENT VALUES (NULL, 'LE KIM HIEU2', 12, TO_DATE('21/5/2002', 'DD/MM/YYYY'), 'PHU YEN2','STUDENT2');
INSERT INTO STUDENT VALUES (NULL, 'LE KIM HIEU3', 12, TO_DATE('21/5/2002', 'DD/MM/YYYY'), 'PHU YEN3','STUDENT3');
INSERT INTO STUDENT VALUES (NULL, 'LE KIM HIEU4', 12, TO_DATE('21/5/2002', 'DD/MM/YYYY'), 'PHU YEN4','STUDENT4');
INSERT INTO STUDENT VALUES (NULL, 'LE KIM HIEU5', 12, TO_DATE('21/5/2002', 'DD/MM/YYYY'), 'PHU YEN5','STUDENT5');
INSERT INTO STUDENT VALUES (NULL, 'LE KIM HIEU6', 12, TO_DATE('21/5/2002', 'DD/MM/YYYY'), 'PHU YEN6','STUDENT6');
/
INSERT INTO COURSE VALUES(NULL,'MATHEMATICS', 'JOHNSON', 2022, 'ADVANCED LEVEL COURSE');
INSERT INTO COURSE VALUES(NULL,'ENGLISH', 'THOMPSON', 2023, NULL);
INSERT INTO COURSE VALUES(NULL,'CHEMISTRY', 'PETER CHEN', 2022, 'LAB EXPERIENTS REQUIRED');
INSERT INTO COURSE VALUES(NULL,'HISTORY', 'SUSAN LEE', 2023, 'LAB EXPERIENTS REQUIRED');
/
INSERT INTO SCORE_BOARD VALUES (1, 1, 9.5);
INSERT INTO SCORE_BOARD VALUES (1, 3, 8.7);
INSERT INTO SCORE_BOARD VALUES (2, 1, 7.9);
INSERT INTO SCORE_BOARD VALUES (2, 2, 9.4);
INSERT INTO SCORE_BOARD VALUES (2, 4, 8.6);
INSERT INTO SCORE_BOARD VALUES (3, 2, 9.1);
INSERT INTO SCORE_BOARD VALUES (3, 3, 8.0);
INSERT INTO SCORE_BOARD VALUES (4, 1, 8.5);
INSERT INTO SCORE_BOARD VALUES (4, 4, 9.2);
INSERT INTO SCORE_BOARD VALUES (5, 1, 8.9);
INSERT INTO SCORE_BOARD VALUES (6, 2, 9.5);


conn system/153255;
select * from sys.student;
select * from sys.score_board;
select*from sys.course;
--select s.ID, s.name,s.grade,s.birthday,s.address,s.notes , c.name from student s, course c , score_board b where s.Id = b.student_id and b.course_id = c.id;

select c.id, b.score, c.name, c.lecturer, c.notes from sys.student s, sys.course c, sys.score_board b where s.id=b.student_id and b.course_id = c.id and c.year =2023 and s.id=2;
select c.id, c.name, c.lecturer,c.year, c.notes from sys.student s, sys.course c, sys.score_board b where s.id=b.student_id and b.course_id = c.id and c.year =2023 and s.id=2;


select c.id, b.score, c.name, c.lecturer, c.notes 
from sys.student s, sys.course c, sys.score_board b 
where s.id=b.student_id and b.course_id = c.id and c.year =TO_NUMBER('2023') and s.id=TO_NUMBER('2')