alter table interacoes_usuarios add column quantidade_caracteres_lidos integer default 0;
alter table interacoes_usuarios add column quantidade_palavras_lidas integer default 0;
update interacoes_usuarios  set quantidade_caracteres_lidos = 0;
update interacoes_usuarios  set quantidade_palavras_lidas = 0;