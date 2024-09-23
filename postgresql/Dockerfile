FROM postgres:latest

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=pgadmin
ENV POSTGRES_DB=booklify

COPY booklify-psql-ddl.sql /docker-entrypoint-initdb.d/
COPY booklify-psql-data.sql /docker-entrypoint-initdb.d/
