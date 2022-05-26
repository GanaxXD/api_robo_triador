create table if not exists execucoes(
	id SERIAL NOT NULL PRIMARY KEY,
	robo_id INT NOT NULL,
	tempo_etiquetando_processos VARCHAR(100) NOT NULL,
	quantidade_processos_etiquetados INT NOT NULL,
	rodou_em DATE,
	encontrou_erro BOOLEAN,
	
	CONSTRAINT fk_id_robo FOREIGN KEY (robo_id) REFERENCES robos(id)
);