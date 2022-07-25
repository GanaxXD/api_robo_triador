CREATE TABLE IF NOT EXISTS execucoes_robos(
	id SERIAL NOT NULL PRIMARY KEY,
	robo_id INT NOT NULL,
	execucao_id INT NOT NULL,
	
	FOREIGN KEY (robo_id) REFERENCES robos (id) ON delete CASCADE,
	FOREIGN KEY (execucao_id) REFERENCES execucoes (id)
);