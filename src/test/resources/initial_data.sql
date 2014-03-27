-- CREATE Resource
insert into Resource ( id ) values ( 'studyGroup1' );
insert into Resource ( id ) values ( 'studyGroup2' );

insert into Resource ( id, urn ) values ( 'study1', 'de.gesis:study1:0.1' );
insert into Resource ( id, urn ) values ( 'study2', 'de.gesis:study2:0.1' );

insert into Resource ( id ) values ( 'temporal1' );

insert into Resource ( id ) values ( 'concept1' );
insert into Resource ( id ) values ( 'concept2' );
insert into Resource ( id ) values ( 'concept3' );

-- CREATE Concept
insert into Concept ( id, notation ) values ( 'concept1', 'a notation' );
insert into Concept ( id, notation ) values ( 'concept2', 'a notation' );
insert into Concept ( id, notation ) values ( 'concept3', 'notation for concept3' );

-- CREATE StudyGroup
insert into LangString ( id, en ) values ( '1', 'Series1' );
insert into LangString ( id, en ) values ( '2', 'Series2' );

insert into LangString ( id, en ) values ( '3', 'Study 1' );
insert into LangString ( id, en ) values ( '4', 'Study 2' );

insert into StudyGroup ( id, title_id ) values ( 'studyGroup1', '1' ); 
insert into StudyGroup ( id, title_id ) values ( 'studyGroup2', '2' ); 

-- CREATE Study

insert into Study ( id, title_id ) values ( 'study1', '3' );
insert into Study ( id, title_id ) values ( 'study2', '4' );

-- CREATE PeriodOfTime

insert into PeriodOfTime ( id, startDate ) values ( 'temporal1', '2009-01-01' );

insert into Study_PeriodOfTime values ( 'study1', 'temporal1' );
insert into Study_PeriodOfTime values ( 'study2', 'temporal1' );

