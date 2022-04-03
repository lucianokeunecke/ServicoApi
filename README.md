# Instituto: INFNET

# Curso: Pós-Graduação MIT em Engenharia de Software com Java

# Disciplina: Integração Continua e DevOps

# ClienteApi

Esta API permitirá incluir, alterar, excluir e consultar pessoas, utilizando como banco de dados o PostgreSQL.

Ao incluir ou alterar uma pessoa, caso o número do Cep tenha sido informado no arquivo Json, esta API irá comunicar-se com a API CepApi, onde esta irá se comunicar-se com o WebService ViaCep (API de terceiros), retornando um arquivo Json do endereço correspondente do CEP. 

Existindo o Cep, serão atualizados de forma automática no arquivo Json os campos endereco, bairro, cidade e estado do cliente.

O objetivo desta API é integrar-se com outras API's, permitindo:

- Exportar métricas para o formato do Prometheus utilizando o micrometer;
- Exportar logs utilizando como ferramenta o Papertrail;
- Exportar os dados para o Zipkin.
