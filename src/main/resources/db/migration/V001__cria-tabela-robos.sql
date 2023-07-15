create table if not exists robos(
	id SERIAL NOT NULL PRIMARY KEY,
	tipo VARCHAR(100) NOT NULL,
	local_implantado VARCHAR(250) NOT NULL,
	instalado_em DATE DEFAULT CURRENT_DATE,
	nome_robo varchar(120) unique,
<<<<<<< HEAD
	grau varchar(100),
=======
>>>>>>> bfc5b69ce59f4ad750a34cf0bde06091082ee113
	
	constraint uk_nome_robos unique (nome_robo)
);