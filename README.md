# Kukurekin Danil Student API

Spring Boot CRUD API for students. Author: **Kukurekin Danil**, group **it2-2312**, ID **37554**.

## Change implemented

The `PUT /api/students/{id}` operation updates the student record. The API stores data in PostgreSQL when started with Docker Compose.

## Run locally

```bash
./gradlew test
docker compose up --build
```

The application is available at `http://localhost:8081/api/students`. Host port 8081 avoids a conflict with the local Jenkins service; the container still exposes Spring Boot port 8080.

## CRUD examples

```bash
curl -X POST http://localhost:8081/api/students \
  -H 'Content-Type: application/json' \
  -d '{"name":"Kukurekin Danil","email":"danil.37554@iitu.kz"}'
curl http://localhost:8081/api/students
curl http://localhost:8081/api/students/1
curl -X PUT http://localhost:8081/api/students/1 \
  -H 'Content-Type: application/json' \
  -d '{"name":"Kukurekin Danil Updated","email":"danil.37554@iitu.kz"}'
curl -X DELETE http://localhost:8081/api/students/1
curl -i http://localhost:8081/api/students/999
```

## Project services

- `app`: Spring Boot API, port 8080.
- `db`: PostgreSQL 16 with a persistent named volume `postgres_data`.

The app connects to `db`, the Compose service name, rather than `localhost`.
