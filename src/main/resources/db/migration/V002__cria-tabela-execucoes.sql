<<<<<<< HEAD
create table if not exists execucoes_clovisjudith(
=======
create table if not exists execucoes(
>>>>>>> bfc5b69ce59f4ad750a34cf0bde06091082ee113
	id SERIAL NOT NULL PRIMARY KEY,
	tempo_etiquetando_processos varchar NOT NULL,
	hora_inicial_execucao_robo varchar(11) not null,
	quantidade_processos_etiquetados INT NOT NULL,
	quantidade_processos_lidos INTEGER DEFAULT 0,
	quantidade_etiquetas_inseridas INTEGER DEFAULT 0,
	minutas_inseridas INTEGER DEFAULT 0,
	rodou_em TIMESTAMP not null default LOCALTIMESTAMP(0),
	encontrou_erro BOOLEAN DEFAULT false,
	robo_id INT NOT NULL,
	
	FOREIGN KEY (robo_id) REFERENCES robos(id)
);