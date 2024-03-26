create table if not exists processos(
    id serial primary key not null,
    numero_processo varchar(25) not null,
    id_processo_remetido int not null,

    foreign key (id_processo_remetido) references processos_remetidos(id)
)