create table if not exists processos_remetidos(
    id serial not null primary key,
    quantidade_processos_remetidos int not null,
    robo_id int not null,
    data_execucao timestamp not null default current_timestamp,

    foreign key (robo_id) references robos(id)
)