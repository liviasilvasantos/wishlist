# Wishlist Service

Projeto desenvolvido para o gerenciamento de wishlist de uma empresa de varejo, sendo possível adicionar e remover produto na wishlist de um cliente, assim como consultar os produtos de uma wishlist.

# Arquitetura

Arquitetura em camadas, separando as responsabilidades de cada classe com o intuito de facilitar teste e leitura de código. 

### Pacote Config

Contém uma carga estática de dados (LoadDB) e uma configuração de documentação da API com Swagger2.

### Pacote Core

Contém a classe de negócio e as exceções utilizadas. 

### Pacote Input

Contém as classes que estão anotadas com @RestController e serão os endpoints da nossa aplicação, e os DTOs.

### Pacote Output

Contém as entidades de persistência e a interface de Repositório do MongoDB.


Para acessar os endpoints, veja a documentação em [Documentação Swagger](http://localhost:8080/swagger-ui/).

# Executando a aplicação

A aplicação foi desenvolvida em SpringBoot utilizando Java 17, MondoDB e Docker/Docker Compose.

Para executar a aplicação:

1. Gere os artefatos
```sh
cd ../wishlist-service
./mvnc clean install
```
2. Suba o container do MongoDB
```sh
cd local
docker-compose -f docker-compose-mongo.yml up
```
3. Suba o container da aplicação
```sh
cd local
docker-compose -f docker-compose-app.yml up
```
4. Acesse a documentação 
Acesse http://localhost:8080/swagger-ui.

## Trabalhos futuros

Vejo que a separação das camadas poderia ser melhorada, utilizando os conceitos de Clean Arch, e separando as responsabilidades em módulos diferentes, isolando o código de maneira a deixar o core totalmente livre de dependências de framework. 

