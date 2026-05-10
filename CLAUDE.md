# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Architecture

Full-stack application with two independent sub-projects:

- **`/` (root)** — Spring Boot 4.0.6 backend (Java 21). Entry point: `src/main/java/com/natene/cadance/CadanceApplication.java`. Group: `com.natene`.
- **`/web`** — React 19 + TypeScript frontend scaffolded with Vite 8, using `@vitejs/plugin-react`.

## Backend commands (repo root)

```bash
./mvnw package -DskipTests               # build JAR
./mvnw spring-boot:run                   # run dev server
./mvnw test                              # run all tests
./mvnw test -Dtest=ClassName             # run single test class
./mvnw test -Dtest=ClassName#method      # run single test method
```

## Frontend commands (always via Docker, run from repo root)

```bash
# Dev server with HMR
docker run --rm -it -p 5173:5173 -v "$(pwd)/web":/app -w /app node:24.15.0 npm run dev

# Production build
docker run --rm -v "$(pwd)/web":/app -w /app node:24.15.0 npm run build

# Lint
docker run --rm -v "$(pwd)/web":/app -w /app node:24.15.0 npm run lint

# Preview production build
docker run --rm -it -p 4173:4173 -v "$(pwd)/web":/app -w /app node:24.15.0 npm run preview
```
