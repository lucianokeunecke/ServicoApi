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

INSERT INTO postgres.endereco(endereco, numero_endereco, bairro, cep, cidade, estado)
VALUES ('Rua Rezala Simão', '650', 'Santa Quitéria','80330-180', 'Curitiba','PR');

insert into cliente (cnpj_cpf, nome, id_endereco) values ('031.865.695-92', 'Luciano Keunecke',1);
insert into cliente (cnpj_cpf, nome, id_endereco) values ('04.965.365/0001-63', 'Eletrônica Blumenau',1);
insert into cliente (cnpj_cpf, nome, id_endereco) values ('085.463.695-92', 'Adriano dos Santos',1);
insert into cliente (cnpj_cpf, nome, id_endereco) values ('653.765.413-33', 'Paulo Vieira Souza',1);
insert into cliente (cnpj_cpf, nome, id_endereco) values ('986.465.413-33', 'Adriana dos Santos',1);

INSERT INTO postgres.fornecedor(cnpj_cpf, razaosocial, nomefantasia, nomecontato, telefone, email, id_endereco)
VALUES ('04.965.365/0001-63', 'Eletrônica Blumenau', 'Eletrônica Blumenau', 'Teste', '(41) 99223-2843', 'eduardo_carriel@live.com', 1);
