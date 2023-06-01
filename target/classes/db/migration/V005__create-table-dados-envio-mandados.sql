create table if not exists dados_envio_mandados (
    id serial not null primary key,
    quantidade_mandados_distrito_data_distribuicao_a varchar(65535),
    quantidade_mandados_distrito_data_distribuicao_b varchar(65535),
    data_criacao_no_banco date default current_date,
    distrito_mais_mandados_enviados varchar(100)
);