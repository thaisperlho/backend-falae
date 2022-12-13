# backend-falae


## Docker
---

__Criando a imagem Docker do banco Postgres__

O seguinte aquivo:s
- [Dockerfile](Dockerfile)

Para realizarmos o build desse arquivo e criar a imagen:

```
docker build -t falae .
```

Logo em seguida inicializarmos um container da imagem gerada:

```
docker run --name db-falae -p 5432:5432 img-falae
```

Com container rodando podemos da continuar a criacao do Database.

## Criando Databse

O seguinte script:
- [Script-falae](script-falae.sql)

Abra a IDE de banco de dados para utilizacao do Postgres.

Em seguida execute o script acima e o banco de dados será criado.

