# ♠️ Poker Trainer

Application web (PWA à terme) pour s’entraîner au poker :
- Évaluation de main (préflop, flop, turn, river)
- Calcul des outs
- Pot odds et règle du 2 & 4
- Simulation de parties
- Suivi de progression (charts, historique)

Inspirée de l’esprit **chess.com** mais pour le poker.

---

## 🚀 Stack technique

### Backend
- Java 21 + Spring Boot 3
- Maven (wrapper inclus)
- Architecture multi-modules :
  - `poker-core` : logique métier
  - `trainer-preflop` : exercices préflop
  - `api` : REST API (`/api/*`)

### Frontend
- Angular 18 (standalone + signals)
- TypeScript strict
- SCSS
- Angular Router
- HttpClient
- Tests : Jest + Cypress
- Sprint 3 : ajout PWA

### CI/CD
- GitHub Actions (workflows YAML dans `.github/workflows`)
- Exécution locale avec [`act`](https://github.com/nektos/act) + [Colima](https://github.com/abiosoft/colima)
- Caches intégrés (Maven/NPM)
- Futur : self-hosted runner sur homelab

---

## 🛠️ Développement

### Prérequis
- Java 21
- Node.js (LTS)
- npm ou pnpm
- Docker + Colima (pour act en local)
- Git

### Backend
```bash
cd backend
./mvnw -pl api spring-boot:run
# API dispo sur http://localhost:8080/api/health
