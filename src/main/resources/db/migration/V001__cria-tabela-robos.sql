create table if not exists robos(
	id SERIAL NOT NULL PRIMARY KEY,
	tipo VARCHAR(100) NOT NULL,
	local_implantado VARCHAR(250) NOT NULL,
	instalado_em DATE DEFAULT CURRENT_DATE,
	nome_robo varchar(120) unique,
	grau varchar(100),
	
	constraint uk_nome_robos unique (nome_robo)
);