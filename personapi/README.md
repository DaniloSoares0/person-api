<h2>Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot</h2>

Durante o desenvolvimento foram abordados os seguintes tópicos:

* Setup inicial de projeto com o Spring Boot Initialzr 
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de pessoas de um sistema).

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/people
```

Spring Boot REST API - Documentation

Url: http://localhost:8080/swagger-ui.html#/cliente-controller/saveUsingPOST

![alt text](https://github.com/DaniloSoares0/projeto-pratico-elotech/blob/master/person-api/personapi/src/main/resources/img/capture1.JPG)

![alt text](https://github.com/DaniloSoares0/projeto-pratico-elotech/blob/master/person-api/personapi/src/main/resources/img/Capturar2.JPG)

Banco de dados em memória com as seguintes credenciais:

Url: http://localhost:8080/h2-console/login.jsp

![alt text](https://github.com/DaniloSoares0/projeto-pratico-elotech/blob/master/person-api/personapi/src/main/resources/img/capture3.JPG)
