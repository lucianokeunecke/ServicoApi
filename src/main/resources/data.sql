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
    nome_contato text COLLATE pg_catalog."default",
    telefone text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    id_endereco int,
    CONSTRAINT pessoa_pkey PRIMARY KEY (id),
    CONSTRAINT fk_endereco FOREIGN KEY(id_endereco) REFERENCES endereco(id)
) TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS postgres.fornecedor
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    cnpj_cpf text COLLATE pg_catalog."default",
    razao_social text COLLATE pg_catalog."default",
    nome_fantasia text COLLATE pg_catalog."default",
    nome_contato text COLLATE pg_catalog."default",
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

insert into cliente (cnpj_cpf, nome, nome_contato, telefone, email, id_endereco) values ('031.865.695-92', 'Luciano Keunecke','Teste 01','(41) 99922-3344)','teste01@gmail.com',1);
insert into cliente (cnpj_cpf, nome, nome_contato, telefone, email, id_endereco) values ('04.965.365/0001-63', 'Eletrônica Blumenau','Teste 02','(41) 99922-3355)','teste02@gmail.com',1);
insert into cliente (cnpj_cpf, nome, nome_contato, telefone, email, id_endereco) values ('085.463.695-92', 'Adriano dos Santos','Teste 03','(41) 99922-3366)','teste03@gmail.com',1);
insert into cliente (cnpj_cpf, nome, nome_contato, telefone, email, id_endereco) values ('653.765.413-33', 'Paulo Vieira Souza','Teste 04','(41) 99922-3377)','teste04@gmail.com',1);
insert into cliente (cnpj_cpf, nome, nome_contato, telefone, email, id_endereco) values ('986.465.413-33', 'Adriana dos Santos','Teste 05','(41) 99922-3388)','teste05@gmail.com',1);

INSERT INTO postgres.fornecedor(cnpj_cpf, razao_social, nome_fantasia, nome_contato, telefone, email, id_endereco)
VALUES ('04.965.365/0001-63', 'Eletrônica Blumenau', 'Eletrônica Blumenau', 'Teste', '(41) 99223-2843', 'eduardo_carriel@live.com', 1);
