create table if not exists execucao_mario_lucio(
		id SERIAL NOT NULL PRIMARY KEY,
		tempo_distribuindo_mandados VARCHAR(11) NOT NULL,
		quantidade_mandados_enviados INT NOT NULL,
		quantidade_mandados_enviados_analise INT NOT NULL,
		rodou_em DATE DEFAULT CURRENT_DATE,
		houve_erro BOOLEAN,
		robo_id INT NOT NULL,
		hora_inicial_execucao_robo VARCHAR(11) NOT NULL,

		FOREIGN KEY (robo_id) REFERENCES robos(id)
);