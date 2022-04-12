Trabalho apresentado na disciplina de Integração Continua e DevOps, do curso de Pós-Graduação MIT em Engenharia de Software com Java, realizado no instituto INFNET.

Itens de entrega:

- Projeto com Spring Boot;
- Uso de TDD, usando os métodos JUNIT e MOCKITO;
- Exportação de métricas para o formato Prometheus, utilizando o micrometer.
- Exportação do health check do projeto usando o Actuator;
- Exportação de logs do projeto para o Papertrail;
- Exportaçao de dados do projeto para o Zipkin;
- Criação de script no TerraForm;
- Criação de pipeline de build, utilizando o Action do Github.

# ClienteApi

Objetivo: 

Esta API permitirá incluir, alterar, excluir e consultar pessoas, utilizando como banco de dados o PostgreSQL, além de permitir consultar o endereço correspodente do CEP.

Nos métodos POST e PUT, caso o número do Cep tenha sido informado no arquivo JSON, esta API irá se integrar com a CepApi que por sua vez irá se integrar com o WebService ViaCep (API de terceiros).

Caso o número do CEP informado no arquivo JSON existir, serão atualizados de forma automática no arquivo JSON os campos endereco, bairro, cidade e estado do cliente.

O objetivo desta API é integrar-se com outras API's, além de lançar exceções de forma aleatória com o objetivo de criar métricas, atendendo os itens de entrega relacionados acima.

Observações:

- Esta API está configurada para utilizar o schema postgres e a senha 123456;
- Para a criação da tabela e a inserção dos dados, utilize o arquivo data.sql da pasta resources;

# CepApi

https://github.com/lucianokeunecke/CepApi

# TerraForm

https://github.com/lucianokeunecke/TerraForm