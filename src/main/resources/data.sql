-- Table: postgres.cliente

-- DROP TABLE IF EXISTS postgres.cliente;
CREATE TABLE IF NOT EXISTS postgres.endereco
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    endereco text COLLATE pg_catalog."default",
    numero_endereco integer,
    bairro text COLLATE pg_catalog."default",
    cep text COLLATE pg_catalog."default",
    cidade text COLLATE pg_catalog."default",
    estado text COLLATE pg_catalog."default",
    CONSTRAINT endereco_pkey PRIMARY KEY (id)
) TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS postgres.cliente
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    cnpj_cpf text COLLATE pg_catalog."default",
    nome text COLLATE pg_catalog."default",
    id_endereco int,
    CONSTRAINT pessoa_pkey PRIMARY KEY (id),
    CONSTRAINT fk_endereco FOREIGN KEY(id_endereco) REFERENCES endereco(id)
) TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS postgres.fornecedor
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    cnpj_cpf text COLLATE pg_catalog."default",
    razaoSocial text COLLATE pg_catalog."default",
    nomeFantasia text COLLATE pg_catalog."default",
    nomeContato text COLLATE pg_catalog."default",
    telefone text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    id_endereco int,
    CONSTRAINT fornecedor_pkey PRIMARY KEY (id),
    CONSTRAINT fk_endereco FOREIGN KEY(id_endereco) REFERENCES endereco(id)
) TABLESPACE pg_default;

ALTER TABLE IF EXISTS postgres.endereco
    OWNER to postgres;

ALTER TABLE IF EXISTS postgres.cliente
    OWNER to postgres;

ALTER TABLE IF EXISTS postgres.fornecedor
    OWNER to postgres;

insert into cliente (cnpj_cpf, nome, endereco, numero_endereco, bairro, cep, cidade, estado) values ('031.865.695-92', 'Luciano Keunecke','Rua Max Weise', 290, 'Agua Verde', '89.032-280', 'Blumenau', 'SC');
insert into cliente (cnpj_cpf, nome, endereco, numero_endereco, bairro, cep, cidade, estado) values ('04.965.365/0001-63', 'Eletrônica Blumenau','Rua XV de Novembro', 6856, 'Centro', '35.182-016', 'Florianópolis', 'SC');
insert into cliente (cnpj_cpf, nome, endereco, numero_endereco, bairro, cep, cidade, estado) values ('085.463.695-92', 'Adriano dos Santos','Rua Jaragua', 756, 'Vila Nova', '06.542-089', 'Curitiba', 'PR');
insert into cliente (cnpj_cpf, nome, endereco, numero_endereco, bairro, cep, cidade, estado) values ('653.765.413-33', 'Paulo Vieira Souza','Rua das Palmeiras', 98, 'Bela Vista', '89.160-001', 'Rio do Sul', 'SC');
insert into cliente (cnpj_cpf, nome, endereco, numero_endereco, bairro, cep, cidade, estado) values ('986.465.413-33', 'Adriana dos Santos','Rua das Missoes', 6354, 'Passo Manso', '84.093-073', 'Itajai', 'SC');
