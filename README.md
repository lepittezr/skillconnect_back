# skillconnect 
## Backend

Projeto Spring Boot criado que contempla as seguintes funcionalidades:

- Serviço de Login - Recebe login e senha e verifica se está igual ao da database. A senha é criptografada. Ao logar, retorna um token para acessar aos demais serviços.

- Serviço de Cadastro - Recebe um login e senha para ser cadastrado. A senha é enviada ao banco de dados criptografada.

- Serviço de Listagem de Skills - Esse serviço recebe o id do usuário e retorna todas as skills associadas a ele e seu respectivo level.

- Serviço de Associar Skill - Esse serviço recebe o usuário, a skill e o level para persistir na base de dados.

- Serviço de Atualizar Associação de Skill - Recebe o id da associação da skill e o level para atualização na base de dados (podendo alterar o level). 

- Serviço de Excluir Associação de Skill - Esse serviço recebe o id da associação da skill e exclui da base de dados.

  Projeto contém segurança JWT e documentação pelo Swagger.
