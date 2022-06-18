-- Table: postgres.cliente

-- DROP TABLE IF EXISTS postgres.cliente;
CREATE TABLE IF NOT EXISTS postgres.tipo_pessoa
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    descricao text COLLATE pg_catalog."default",
    CONSTRAINT cliente_pkey PRIMARY KEY (id)
) TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS postgres.pessoa
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    cnpj_cpf text COLLATE pg_catalog."default",
    nome text COLLATE pg_catalog."default",
    nome_fantasia text COLLATE pg_catalog."default",
    nome_contato text COLLATE pg_catalog."default",
    telefone text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    id_tipo_pessoa int,
    CONSTRAINT pessoa_pkey PRIMARY KEY (id),
    CONSTRAINT fk_tipo_pessoa FOREIGN KEY(id_tipo_pessoa) REFERENCES tipo_pessoa(id)
) TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS postgres.endereco_pessoa
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    endereco text COLLATE pg_catalog."default",
    numero_endereco integer,
    bairro text COLLATE pg_catalog."default",
    cep text COLLATE pg_catalog."default",
    cidade text COLLATE pg_catalog."default",
    estado text COLLATE pg_catalog."default",
    id_pessoa int,
    CONSTRAINT endereco_pkey PRIMARY KEY (id),
    CONSTRAINT fk_pessoa FOREIGN KEY(id_pessoa) REFERENCES pessoa(id)
) TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS postgres.servico
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    descricao text COLLATE pg_catalog."default",
    CONSTRAINT servico_pkey PRIMARY KEY (id)
) TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS postgres.fornecedor_servico
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    id_pessoa int,
    id_servico int,
    valor decimal(10,2),
    CONSTRAINT fornecedor_pkey PRIMARY KEY (id),
    CONSTRAINT fk_pessoa FOREIGN KEY(id_pessoa) REFERENCES pessoa(id),
    CONSTRAINT fk_servico FOREIGN KEY(id_servico) REFERENCES servico(id)
) TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS postgres.contratacao_servico
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    data_contratacao timestamp with time zone,
                                   id_pessoa int,
                                   id_fornecedor_servico int,
                                   valor decimal(10,2),
    CONSTRAINT contratacao_servico_pkey PRIMARY KEY (id),
    CONSTRAINT fk_pessoa FOREIGN KEY(id_pessoa) REFERENCES pessoa(id),
    CONSTRAINT fk_fornecedor_servico FOREIGN KEY(id_fornecedor_servico) REFERENCES fornecedor_servico(id)
) TABLESPACE pg_default;

ALTER TABLE IF EXISTS postgres.tipo_pessoa
    OWNER to postgres;

ALTER TABLE IF EXISTS postgres.pessoa
    OWNER to postgres;

ALTER TABLE IF EXISTS postgres.endereco_pessoa
    OWNER to postgres;

ALTER TABLE IF EXISTS postgres.servico
    OWNER to postgres;

ALTER TABLE IF EXISTS postgres.fornecedor_servico
    OWNER to postgres;

ALTER TABLE IF EXISTS postgres.contratacao_servico
    OWNER to postgres;

insert into tipo_pessoa(descricao) values ('Cliente'), ('Fornecedor'), ('Cliente/Fornecedor');

INSERT INTO postgres.pessoa(cnpj_cpf, nome, nome_fantasia, nome_contato, telefone, email, id_tipo_pessoa)
VALUES ('031.865.695-92', 'Luciano Keunecke','','Teste 01','(41) 99922-3344)','teste01@gmail.com',1),
       ('04.965.365/0001-63','Eletrônica Blumenau', 'Eletrônica Blumenau','Teste 02','(41) 99922-3355)','teste02@gmail.com',2),
       ('085.463.695-92', 'Adriano dos Santos','','Teste 03','(41) 99922-3366)','teste03@gmail.com',1),
       ('653.765.413-33', 'Paulo Vieira Souza','','Teste 04','(41) 99922-3377)','teste04@gmail.com',3),
       ('986.465.413-33', 'Adriana dos Santos','','Teste 05','(41) 99922-3388)','teste05@gmail.com',2),
       ('08.564.208/0001-01','Empresa Teste Cliente', 'Empresa Teste','Teste 02','(41) 99922-3355)','teste02@gmail.com',1),
       ('08.564.208/0001-01','Empresa Teste Fornecedor', 'Empresa Teste','Teste 02','(41) 99922-3355)','teste02@gmail.com',2);

INSERT INTO postgres.endereco_pessoa(endereco, numero_endereco, bairro, cep, cidade, estado, id_pessoa)
VALUES ('Rua Rezala Simão', '123', 'Santa Quitéria','80330-180', 'Curitiba','PR',1);
INSERT INTO postgres.endereco_pessoa(endereco, numero_endereco, bairro, cep, cidade, estado, id_pessoa)
VALUES ('Rua Rezala Simão', '456', 'Santa Quitéria','80330-181', 'Curitiba','RS',2);
INSERT INTO postgres.endereco_pessoa(endereco, numero_endereco, bairro, cep, cidade, estado, id_pessoa)
VALUES ('Rua Rezala Simão', '789', 'Santa Quitéria','80330-182', 'Curitiba','MG',3);
INSERT INTO postgres.endereco_pessoa(endereco, numero_endereco, bairro, cep, cidade, estado, id_pessoa)
VALUES ('Rua Rezala Simão', '987', 'Santa Quitéria','80330-183', 'Curitiba','SC',4);
INSERT INTO postgres.endereco_pessoa(endereco, numero_endereco, bairro, cep, cidade, estado, id_pessoa)
VALUES ('Rua Rezala Simão', '654', 'Santa Quitéria','80330-184', 'Curitiba','SP',5);
INSERT INTO postgres.endereco_pessoa(endereco, numero_endereco, bairro, cep, cidade, estado, id_pessoa)
VALUES ('Rua Rezala Simão', '321', 'Santa Quitéria','80330-185', 'Curitiba','PR',6);
INSERT INTO postgres.endereco_pessoa(endereco, numero_endereco, bairro, cep, cidade, estado, id_pessoa)
VALUES ('Rua Rezala Simão', '852', 'Santa Quitéria','80330-186', 'Curitiba','PR',7);

INSERT INTO postgres.servico(descricao)
VALUES ('Pintor'), ('Encanador'), ('Barbeiro'), ('Manicure'), ('Eletricista');

INSERT INTO postgres.fornecedor_servico(id_pessoa, id_servico, valor)
VALUES (2, 1, 153.80), (5, 2, 321.50), (4, 3, 70);

INSERT INTO postgres.contratacao_servico(data_contratacao, id_pessoa, id_fornecedor_servico, valor)
VALUES (now(), 1, 1, 153.80), (now(), 3, 2, 321.50), (now(), 6, 3, 70.00);