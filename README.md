# Desafio BRQ - Cadastro de usuários
Sistema para cadastro de usuários

# Tecnologias utilizadas
- Springboot
- H2
- MapStruct
- Swagger

# Exigências
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org)

# Como executar o Projeto
Um projeto maven e necessário que execute o comando na raiz do projeto.
Com isso ele irá baixar as dependências do projeto.

```sh
 $ mvn clean install
```
Depois de instaladas as dependências. É necessário acessar a pasta target dentro do projeto e  
e executar o comando.

```sh
 $ java -jar brq-0.0.1-SNAPSHOT.jar
```
Com isso o projeto irá inicializar na porta 8080.

# Swagger
Documentação dos endpoints estão em:
http://localhost:8080/swagger-ui/index.html