create table if not exists robos(
	id SERIAL NOT NULL PRIMARY KEY,
	tipo VARCHAR(100) NOT NULL,
	local_implantado VARCHAR(250) NOT NULL,
	instalado_em DATE DEFAULT CURRENT_DATE,
	quantidade_vezes_rodou INT
);