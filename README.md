# Projeto em equipe de desenvolvimento de aplicações corporativas

# LojaAutoPeças

## Para Rodar o projeto

#### Eclipse

1. Vá no src/main/resources/db.properties e coloque seu login do postgresql;

2. Crie o banco de dados no postgresql;
3. Crie as tabelas pela classe br.com.lojaautopecas.CriacaoTabelas.CreateAll.java;
4. Popule o banco com a classe br.com.lojaautopecas.CriacaoTabelas.Povoamento.java;

5. Crie o server com o tomcat;
6. Importe o projeto como um projeto maven;
7. Tenha certeza de ter baixado as dependencias;
  1. Maven > Download sources;
  2. Run as > Run on server.

8 Faça o login (existe o funcionario com login "teste", "teste").


### Tecnologias

- Maven
- Jakarta EE
- Java Server Pages
- Apache Tomcat
- JDBD
