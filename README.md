#  <div align="center"> Implementação Feign  </div>

<br/>

#  <div align="center"> 🚧 Concluído 🚧  </div>

<br/>

## Conteúdos

* [Pré-requisitos](#pré-requisitos)
* [Sobre](#sobre)
* [Como usar](#como-usar)
* [Tecnologias](#tecnologias)

<br/>

## Pré-requisitos
- JDK 17
- Postman
- Intellij

<br/>

## Sobre
Este projeto demonstra como consumir um serviço externo em uma aplicação Java utilizando três abordagens diferentes: 
- RestTemplate.
- OpenFeign com URL fixa. 
- OpenFeign com RequestLine.

<br/>

1️⃣ Usando RestTemplate (Abordagem Tradicional)

A primeira abordagem utiliza RestTemplate, uma classe do Spring para realizar requisições HTTP de forma programática. Aqui, montamos manualmente a URL e realizamos a requisição:
```java
 public Object findCepRestTemplate(String cep) {    
    var template = new RestTemplate();
    var url = String.format("https://viacep.com.br/ws/%s/json/", cep);
    return template.getForEntity(url, Object.class);
}
```

``✅ Vantagens:`` Simples e direta para chamadas pontuais.

``❌ Desvantagens:`` Requer a construção manual das URLs e tratamento explícito das respostas.

<br/>

2️⃣ Usando OpenFeign com URL fixa
Nesta abordagem, utilizamos o OpenFeign, uma biblioteca declarativa para comunicação HTTP, configurando um cliente Feign com uma URL pré-definida:
```java
@FeignClient(name = "location", url = "https://viacep.com.br/ws/")
public interface LocationProxy {
    @GetMapping("{cep}/json")
    Object findByCepFeign(@PathVariable String cep);
}
```
``✅ Vantagens:``
- Menos código e mais legibilidade.
- O Feign cuida da construção da URL e da conversão automática da resposta.

``❌ Desvantagens:``
- A URL é fixa, tornando mais difícil a configuração dinâmica via application.properties.

<br/>

3️⃣ Usando OpenFeign com RequestLine
Neste caso, utilizamos RequestLine, que permite uma definição mais flexível dos métodos:
```java
@FeignClient(name = "location-line")
public interface LocationRequestLineProxy {
    @RequestLine(value = "GET")
    Object findByCep();
}
```

``✅ Vantagens:``
- Suporta formatação personalizada da requisição.
- Mais flexível para definir métodos HTTP diferentes.

``❌ Desvantagens:``
- Precisa ser combinada com @Headers e outros atributos para controle avançado.
- Menos comum em aplicações Spring modernas.

<br/>

### 🏆 Conclusão

Este projeto apresenta três formas de realizar requisições HTTP em ``Java``, destacando as vantagens e desvantagens de cada uma. O ``RestTemplate`` é útil para chamadas simples, mas o ``OpenFeign`` oferece uma solução mais declarativa e integrada ao ``Spring Boot``, tornando o código mais limpo e fácil de manter.

<br/>

## Como Usar
Entre na classe ``ImplementationFeignApplication`` e execute o método ``main``.

O projeto roda na url ``http://localhost:8080``.

No ``Postman``, utilize o curl abaixo.
 ```sh
curl --location --request GET 'http://localhost:8080/location/feign-request-line/cep/23045805'
 ```

<br/>

## Tecnologias
![Java](https://img.shields.io/static/v1?label=Java&message=17&color=green)
![Spring Boot](https://img.shields.io/static/v1?label=spring-boot&message=3.2.2&color=green)
![OpenFeign](https://img.shields.io/static/v1?label=openfeign&message=4.1.0&color=green)
 