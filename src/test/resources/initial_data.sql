-- CREATE StudyGroup
insert into LangString ( id, en ) values ( '1', 'Series1' );
insert into LangString ( id, en ) values ( '2', 'Series2' );

insert into Resource ( id ) values ( 'studyGroup1' );
insert into StudyGroup ( id, title_id ) values ( 'studyGroup1', '1' ); 

insert into Resource ( id ) values ( 'studyGroup2' );
insert into StudyGroup ( id, title_id ) values ( 'studyGroup2', '2' ); 
