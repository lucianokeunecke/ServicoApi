-- Table: postgres.cidade

-- DROP TABLE IF EXISTS postgres.cidade;

CREATE TABLE IF NOT EXISTS postgres.cidade
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome text COLLATE pg_catalog."default",
    estado text COLLATE pg_catalog."default",
    CONSTRAINT cidade_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS postgres.cidade
    OWNER to postgres;



-- Table: postgres.cliente

-- DROP TABLE IF EXISTS postgres.cliente;

CREATE TABLE IF NOT EXISTS postgres.cliente
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    cnpj_cpf text COLLATE pg_catalog."default",
    nome text COLLATE pg_catalog."default",
    endereco text COLLATE pg_catalog."default",
    numero_endereco integer,
    bairro text COLLATE pg_catalog."default",
    cep text COLLATE pg_catalog."default",
    cidade text COLLATE pg_catalog."default",
    estado text COLLATE pg_catalog."default",
    CONSTRAINT pessoa_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS postgres.cliente
    OWNER to postgres;



insert into cidade (nome, estado) values ('Blumenau', 'SC');
insert into cidade (nome, estado) values ('Timbo', 'SC');
insert into cidade (nome, estado) values ('Florianopolis', 'SC');

insert into cliente (cnpj_cpf, nome, endereco, numero_endereco, bairro, cep, cidade, estado) values ('031.865.695-92', 'Luciano Keunecke','Rua Max Weise', 290, 'Agua Verde', '89.032-280', 'Blumenau', 'SC');
insert into cliente (cnpj_cpf, nome, endereco, numero_endereco, bairro, cep, cidade, estado) values ('04.965.365/0001-63', 'Eletrônica Blumenau','Rua XV de Novembro', 6856, 'Centro', '89.133-270', 'Blumenau', 'SC');
insert into cliente (cnpj_cpf, nome, endereco, numero_endereco, bairro, cep, cidade, estado) values ('085.463.695-92', 'Adriano dos Santos','Rua Jaragua', 756, 'Vila Nova', '86.654-145', 'Florianopolis', 'SC');
insert into cliente (cnpj_cpf, nome, endereco, numero_endereco, bairro, cep, cidade, estado) values ('653.765.413-33', 'Paulo Vieira Souza','Rua das Palmeiras', 98, 'Bela Vista', '86.463-746', 'Timbo', 'SC');
