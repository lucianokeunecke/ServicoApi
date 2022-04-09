# Instituto: INFNET
# Curso: Pós-Graduação MIT em Engenharia de Software com Java
# Disciplina: Integração Continua e DevOps

Trabalho final da disciplina, atendendo os seguintes itens:

- Projeto utilizando Springboot;
- Uso de TDD, utilizando métodos JUNIT e MOCKITO;
- Exportação de métricas para o formato Prometheus, fazendo o uso de micrometer.
- Exportação do health check do projeto com o Actuator;
- Exportação de logs do projeto para o Papertrail;
- Exportaçao de dados do projeto para o Zipkin;
- Criação de script no TerraForm;
- Criação de pipeline de build, utilizando o Action do Github.

# ClienteApi

Esta API permitirá incluir, alterar, excluir, consultar pessoas e cep, utilizando como banco de dados o PostgreSQL.

Nos métodos POST e PUT, caso o número do Cep tenha sido informado no arquivo JSON, esta API irá comunicar-se com a API CepApi, onde esta irá se comunicar-se com o WebService ViaCep (API de terceiros), retornando um arquivo JSON do endereço correspondente do CEP.

Existindo o Cep, serão atualizados de forma automática no arquivo JSON os campos endereco, bairro, cidade e estado do cliente.

Já no método GET (localhost:8080/cep/89032280), será possível consultar o endereço correspondente do Cep.

O objetivo desta API é integrar-se com outras API's.

# CepApi

https://github.com/lucianokeunecke/CepApi

# TerraForm

https://github.com/lucianokeunecke/TerraForm