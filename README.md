# SkillConnect
## Backend


O projeto SkillConnect é uma aplicação Spring Boot que oferece um conjunto de funcionalidades voltadas para o gerenciamento de habilidades de usuários.


- Serviço de Login - Este serviço permite aos usuários se autenticarem na plataforma. Ao fornecer login e senha, a aplicação verifica se as credenciais correspondem às armazenadas na base de dados. As senhas são armazenadas de forma criptografada. Após a autenticação bem-sucedida, um token é retornado, permitindo o acesso aos demais serviços.

- Serviço de Cadastro - Neste serviço, os usuários devem fornecer um login e senha, que são armazenados no banco de dados de forma criptografada.

- Serviço de Listagem de Skills - Esse serviço recebe o ID do usuário como entrada e retorna todas as habilidades associadas a ele, juntamente com seus níveis.

- Serviço de Associar Skill - Aqui os usuários podem associar habilidades a si mesmos, indicando também o nível de proficiência.

- Serviço de Atualizar Associação de Skill - Caso um usuário deseje atualizar o nível de proficiência de uma habilidade previamente associada, este serviço permite essa atualização com base no ID da associação da habilidade. 

- Serviço de Excluir Associação de Skill - Caso um usuário não queira mais manter uma habilidade associada a si, este serviço permite a exclusão dessa associação com base no ID da associação da habilidade.


  Projeto contém segurança JWT para garantir autenticação e autorização adequada dos usuários.
  A documentação da API é fornecida pelo Swagger.

Adicionalmente, embora não tenha sido implementado devido a restrições de tempo, foi concebida a ideia de diferentes roles para os usuários (user e admin). A função "admin" teria a capacidade de cadastrar novas habilidades no sistema, enquanto "user" estaria limitada a associar as habilidades existentes a si mesmo.

  O projeto também inclui um script SQL que descreve a estrutura do banco de dados e uma carga inicial de dados de Skills.
  
#
by Letícia Pittezr
