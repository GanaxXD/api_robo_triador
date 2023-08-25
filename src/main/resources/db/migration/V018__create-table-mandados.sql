create table if not exists mandados (
    id serial not null primary key,
    numero_processo varchar not null,
	codigo_mandado varchar not null,
	distrito_id int not null,
	data_distribuicao TIMESTAMP not null default LOCALTIMESTAMP(0),
	id_documento varchar not null,
	
	FOREIGN KEY (distrito_id) REFERENCES distritos(id)
);