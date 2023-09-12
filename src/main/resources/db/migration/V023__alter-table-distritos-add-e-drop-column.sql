alter table distritos drop column cod_normal;
alter table distritos drop column cod_urgente;
alter table distritos add column codigo varchar unique;