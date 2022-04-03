# ClienteApi
Esta API permitirá incluir, alterar e excluir pessoas, utilizando o banco de dados PostgreSQL.

Ao incluir ou alterar um pessoa, caso o número do Cep seja informado, esta API irá comunicar-se com a API Cep, retornando as informações do endereço correspondente ao Cep. Caso o Cep existir, serão atualizados de forma automática os campos endereco, bairro, cidade e estado do cliente.

Trabalho da disciplina de Integração Continua e DevOps.
