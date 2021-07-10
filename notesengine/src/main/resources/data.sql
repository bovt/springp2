insert into note_book (id, name) values (null, 'local_notes');
insert into note_book (id, name) values (null, 'global_notes');
insert into note_book (id, name) values (null, 'misc_notes');
insert into note_agent (id, name, api_key, notebook) values (null,'telegrambot1','sdfqerf435rf3', select id from note_book where name='local_notes');
insert into note_agent (id, name, api_key, notebook) values (null,'androidapp1','sdfqerf435rf3',select id from note_book where name='local_notes');
insert into note_agent (id, name, api_key, notebook) values (null,'spa1','sdfqerf435rf3',select id from note_book where name='local_notes');
insert into note (id, text, notebook) values (null, 'Съешь же ещё этих мягких французских булок да выпей чаю.',select id from note_book where name='local_notes');
insert into note (id, text, notebook) values (null, 'The five boxing wizards jump quickly.',select id from note_book where name='local_notes');