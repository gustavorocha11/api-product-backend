### Products API

 Aplicação criada com Springboot(2.1.0.RELEASE) e módulos:

  - spring-boot-starter-data-mongodb
  - spring-boot-starter-web
  - spring-boot-devtools

#### Database: MongoDB

Na ```application.properties``` define-se:

```
spring.data.mongodb.database=products_mongodb
spring.data.mongodb.port=27017

```
Portanto, você deve ter o serviço mongoDB com os parâmetros padrão.

Centro de download do MongoDB (https://www.mongodb.com/download-center/community)

A coleção products_mongodb será criada assim que os produtos forem adicionados.

#### Logging: Logback

O aplicativo deixa um log ```C:/dev/products/log/```, se não existir, este diretório será criado quando o aplicativo for iniciado.

De acordo com a configuração de ```logback.xml``` na pasta resources:
  
2 arquivos são criados de acordo com o _Layout_: arquivo simples e html. 

  - Ambos têm uma política de rolar a cada 10 Mb.
  - Os mesmos arquivos são salvos até um total de 100 unidades cada ou por um período máximo de 30 dias.

#### [Inserir um Produto](http://localhost:8080/api/create)

  - Endpoint: http://localhost:8080/api/create
  - Method: _POST_
  - Header: Content-Type=_application/json_
  - Body:
```
{
	"name": "Product name example",
	"price": 99.99,
	"brand": "Product brand",
	"categoryId": 123
}
```
  - Response: Obejto Criado.

#### [Obter todos os produtos](http://localhost:8080/api/products)
  - Endpoint: http://localhost:8080/api/products
  - Method: _GET_
  - Response:  
```
[{
	"id": "5bf56394255ba017ec1dd0a0",
	"name": "Product name example",
	"price": 99.99,
	"brand": "Product brand",
	"categoryId": 123
}]
```
