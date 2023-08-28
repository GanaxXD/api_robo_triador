create table if not exists distritos (
	id serial not null primary key,
    nome_distrito varchar,
	cod_normal varchar unique not null,
	cod_urgente varchar unique not null
);