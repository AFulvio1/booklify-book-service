FROM postgres:latest

# Set environment variables for PostgreSQL
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=pgadmin
ENV POSTGRES_DB=booklify

# Copy initialization scripts to docker-entrypoint-initdb.d
COPY booklify-ddl.sql.sql /docker-entrypoint-initdb.d/
COPY booklify-data.sql.sql /docker-entrypoint-initdb.d/
