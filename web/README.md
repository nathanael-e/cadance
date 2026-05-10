# Cadance Frontend

React 19 + TypeScript + Vite 8. All commands run via Docker from the **repo root**.

## Development

```bash
docker run --rm -it -p 5173:5173 -v "$(pwd)/web":/app -w /app node:24.15.0 npm run dev
```

Open http://localhost:5173. Supports HMR.

## Production build

```bash
docker run --rm -v "$(pwd)/web":/app -w /app node:24.15.0 npm run build
```

Output is written to `web/dist/`.
