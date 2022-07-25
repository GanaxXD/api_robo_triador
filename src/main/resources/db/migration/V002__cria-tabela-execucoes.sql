create table if not exists execucoes(
	id SERIAL NOT NULL PRIMARY KEY,
	tempo_etiquetando_processos DATE NOT NULL,
	quantidade_processos_etiquetados INT NOT NULL,
	rodou_em DATE DEFAULT CURRENT_DATE,
	encontrou_erro BOOLEAN,
	robo_id INT NOT NULL,
	
	FOREIGN KEY (robo_id) REFERENCES robos(id)
);