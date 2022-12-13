#Imagen usada https://hub.docker.com/_/postgres
FROM postgres:latest

#Senha do banco
ENV POSTGRES_PASSWORD=1234

#Usuario do banco
ENV POSTGRES_USER=app

#Nome do banco
ENV POSTGRES_DB=falae
