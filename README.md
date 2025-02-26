### Backend Test

[Ir para Detalhes do teste/case Boticário - Mateus Pontes](#detalhes-do-testecase-boticário---mateus-pontes)

---
[![Build Status](https://travis-ci.com/belezanaweb/test-java.svg?branch=master)](https://travis-ci.com/belezanaweb/test-java)

[![codecov](https://codecov.io/gh/belezanaweb/test-java/branch/master/graph/badge.svg)](https://codecov.io/gh/belezanaweb/test-java)

Esta é uma avaliação básica de código.

O objetivo é conhecer um pouco do seu conhecimento/prática de RESTful, Spring e Java.

Recomendamos que você não gaste mais do que 4 - 6 horas.

Faça um fork deste repositório que contém o bootstrap de uma aplicação SpringBoot 1.5.12. (você pode utilizar spring boot 2+)

Ao finalizar o teste, submeta um pull request para o repositório que nosso time será notificado.

### Tarefas

Com a seguinte representação de produto:

```json
{
    "sku": 43264,
    "name": "L'Oréal Professionnel Expert Absolut Repair Cortex Lipidium - Máscara de Reconstrução 500g",
    "inventory": {
        "quantity": 15,
        "warehouses": [
            {
                "locality": "SP",
                "quantity": 12,
                "type": "ECOMMERCE"
            },
            {
                "locality": "MOEMA",
                "quantity": 3,
                "type": "PHYSICAL_STORE"
            }
        ]
    },
    "isMarketable": true
}
```

Crie endpoints para as seguintes ações:

- [x] Criação de produto onde o payload será o json informado acima (exceto as propriedades **isMarketable** e **inventory.quantity**)

- [x] Edição de produto por **sku**

- [x] Recuperação de produto por **sku**

- [x] Deleção de produto por **sku**

### Requisitos


- [x] Toda vez que um produto for recuperado por **sku** deverá ser calculado a propriedade: **inventory.quantity**

        A propriedade inventory.quantity é a soma da quantity dos warehouses

- [x] Toda vez que um produto for recuperado por **sku** deverá ser calculado a propriedade: **isMarketable**

        Um produto é marketable sempre que seu inventory.quantity for maior que 0

- [x] Caso um produto já existente em memória tente ser criado com o mesmo **sku** uma exceção deverá ser lançada

        Dois produtos são considerados iguais se os seus skus forem iguais


- [x] Ao atualizar um produto, o antigo deve ser sobrescrito com o que esta sendo enviado na requisição

        A requisição deve receber o sku e atualizar com o produto que tbm esta vindo na requisição

### Dicas

- Os produtos devem ficar em memória, não é necessário persistir os dados. Não utilize `h2`
- Não é necessário adicionar swagger (não será avaliado)
- Sinta-se a vontade para fazer o código em ```groovy```, ```kotlin``` ou ```scala``` se preferir, utilizamos bastante aqui
- Testes são sempre bem-vindos :smiley:

----


### Detalhes do teste/case Boticário - Mateus Pontes


- Optei por fazer o desafio em Kotlin, pois acredito que novas features serão sempre priorizadas o desenvolvimento em Kotlin.
Também é uma linguagem a qual tenho me exposto mais nos ultimos meses.
- Decidi fazer o tratamento de exception através da classe ExceptionHandler para que o usuario final, tenha retornos de exceções mais amigaveis e claras.
- Sobre a Service, inclui validações, como a verificação de SKU positivo, e tratamento adequado de exceções, como NotFoundException. Visando a clareza, modularidade e boas práticas de desenvolvimento.
- Utilizei os mappers para fazer a conversão do form e do view, como forma de abstração de código e logica para ficar mais organizado.
- Para os testes unitarios decidi usar MockK, pois estou me familiarizando em testes unitarios utilizando essa biblioteca. 
- Ainda sobre testes unitarios, decidi criar templates para os cenarios necessarios, pois acho uma forma de deixar os testes unitarios mais limpos e legiveis e também facilita testes futuros pensando em escalabilidade da feature.


[![My Skills](https://skillicons.dev/icons?i=kotlin,spring,idea,maven&theme=light)](https://skillicons.dev)
