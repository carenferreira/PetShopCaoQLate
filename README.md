# PetShot Cão Q-Late
## Escopo do projeto:

O proprietário de um PetShop deseja criar um software para facilitar o controle dos serviços
prestados aos cães de seus clientes. O sistema é comporto por dois tipos de usuários que devem ter acesso as seguintes funcionalidades;

* Cliente: cadastrar cão; editar perfil; agendar serviço; listar serviços pendentes; listar serviços prestados.
* Funcionário: cadastrar serviço; editar serviço; listar serviços pendentes; listar serviços prestados; gerar relatório de serviços prestados.

Para ter acesso a aplicação é necessário realizar login, caso o cliente tente realizar login e o usuário não seja encontrado, ele será encaminhado para uma página de cadastro.
Ao finalizar o cadastro o cliente receberá um email com um link para confirmação.

### Especificações das funcionalidades:
#### Cliente
1. Editar perfil: o usuário só poderá alterar telefone e senha.
2. Agendar serviço: o cliente irá selecionar a data, o cão e os serviços que deseja. Caso já exista algum serviço agendado para a data selecionada não será possível realizar o
agendamento (apenas um serviço pode ser agendado por dia)

#### Funcionário:
1. Editar serviço: apenas o valor poderá ser editado.
2. O sistema deve calcular o valor final da prestação do serviço, com base nos serviços prestados ao cão. Se três ou mais serviços forem selecionados para um mesmo cão, o sistema
deverá calcular um desconto de 10% no valor final.

## Informações Técnicas:
* Desenvolvido usando conceitos trabalhados no Spring MVC
* Desenvolvido usando Eclipse EE 2023
* JavaSE-17
* Apache Tomcat v10.0
* Maven 4.0.0 - Dependências utilizadas e suas respectivas versões no arquivo pom.xml
* Font-end: Materialize 1.0.0

## Execução:
- Baixar o projeto;
- Certificar que as informações técnicas são compatíveis
  
Obs: O banco de dados será gerado automaticamente na primeira execução do projeto, sendo necessário apenas inserir um usuário na tabela funcionários para ter acesso as
funcionalidades destinadas a esse perfil.
