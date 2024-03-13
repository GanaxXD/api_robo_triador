create table if not exists processos_remetidos (
    id serial not null primary key,
	robo_id int not null,
	data_execucao TIMESTAMP not null default LOCALTIMESTAMP(0),
	quantidade_processos_remetidos int not null,
	
	FOREIGN KEY (robo_id) REFERENCES robos(id)
);