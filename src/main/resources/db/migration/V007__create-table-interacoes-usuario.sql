create table if not exists interacoes_usuarios(
	id serial primary key not null,
	quantidade_click int not null default 0,
	data_de_execucao TIMESTAMP not null default LOCALTIMESTAMP(0),
	
	id_robo int not null,
	foreign key (id_robo) references robos(id)	
);