# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

`cadance` — a Spring Boot 4.0.6 application (Java 21), generated via Spring Initializr. The project is at skeleton stage: only the entry point and a context-loads smoke test exist.

- Group: `com.natene`
- Main class: `src/main/java/com/natene/cadance/CadanceApplication.java`

## Commands

```bash
# Build (skip tests)
./mvnw package -DskipTests

# Run
./mvnw spring-boot:run

# Run all tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=CadanceApplicationTests

# Run a single test method
./mvnw test -Dtest=CadanceApplicationTests#contextLoads
```
