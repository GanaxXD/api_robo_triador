create table if not exists mandados (
    id serial not null primary key,
    numero_processo varchar,
	codigo_mandado varchar,
	distrito_id int not null,
	data_distribuicao TIMESTAMP not null default LOCALTIMESTAMP(0),
	
	FOREIGN KEY (distrito_id) REFERENCES distritos(id)
);