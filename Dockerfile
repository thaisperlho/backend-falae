#Imagen usada https://hub.docker.com/_/postgres
FROM postgres:latest

#Senha do banco
ENV POSTGRES_PASSWORD=1234

#Usuario do banco
ENV POSTGRES_USER=postgres

#Nome do banco
ENV POSTGRES_DB=postgres

COPY falae-dump.sql /docker-entrypoint-initdb.d/