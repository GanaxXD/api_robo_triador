create table if not exists distritos (
    id serial not null primary key,
    nomeDistrito varchar;
	codNormal varchar;
	codUrgente varchar;
);