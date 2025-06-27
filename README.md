# 🎮 Projeto de Jogo 2.5D em Java — Arquitetura Modular

Este projeto segue uma arquitetura modular moderna com separação clara entre **engine**, **cliente**, **API**, e **microserviços**. Ideal para jogos 2.5D com lógica robusta, multiplayer e extensibilidade.

---

## 🧱 Estrutura dos Modulos
game-project/ <br>
├── game-engine/ # Motor gráfico e lógica (ECS, renderização, física) <br>
├── game-client/ # Cliente (JavaFX, LWJGL, libGDX, etc.) <br>
├── game-server/ # Servidor multiplayer (tempo real) <br>
├── game-api/ # API externa REST/gRPC (login, ranking) <br>
├── game-shared/ # Modelos e eventos compartilhados (DTOs, configs) <br>
├── microservices/ <br>
│ ├── auth-service/ # Autenticação e segurança <br>
│ ├── matchmaking-service/ # Sistema de pareamento e ranking <br>
│ ├── profile-service/ # Perfil do jogador e estatísticas <br>
│ └── shop-service/ # Loja e microtransações <br> 
└── tools/ <br>
├── map-editor/ # Editor visual de mapas 2.5D <br> 
└── asset-pipeline/ # Conversão e empacotamento de assets <br> 


---

## 🕹️ Módulo `game-engine`

Motor modular orientado a objetos com suporte a ECS (Entity Component System).

### Componentes principais:
- `core.graphics`: renderização 2.5D, depth sorting
- `core.physics`: colisões e movimentação
- `core.ecs`: entidades, componentes e sistemas
- `core.events`: sistema de eventos interno
- `core.time`: deltaTime e controle de ticks

---

## 🌐 Módulo `game-api`

API externa (Micronaut REST/gRPC) usada para:

- Registro e login de jogadores
- Obtenção de status, inventário e ranking
- Comunicação com microsserviços

---

## 🧠 Módulo `game-server`

Servidor de tempo real responsável por:

- Simular a lógica do mundo do jogo
- Validar ações dos jogadores
- Sincronizar estado com os clientes
- Pode usar TCP, UDP, WebSocket (Netty/Vert.x)

---

## ⚙️ Microsserviços

| Serviço                | Função                                               |
|------------------------|------------------------------------------------------|
| `auth-service`         | Login, tokens JWT, gerenciamento de conta           |
| `matchmaking-service`  | Sistema de pareamento por elo/rank                  |
| `profile-service`      | XP, conquistas, inventário, personagens              |
| `shop-service`         | Loja, moedas, itens cosméticos                       |

---

## 🔄 Comunicação

| Canal                   | Tecnologia          |
|-------------------------|---------------------|
| Cliente ↔ API           | REST ou gRPC        |
| Cliente ↔ Game Server   | TCP/UDP personalizado |
| Microsserviços internos | Kafka ou Redis Pub/Sub |
| Cache                   | Redis               |
| Banco de dados          | MongoDB / PostgreSQL |

---

## 🛠️ Ferramentas Auxiliares

| Ferramenta          | Objetivo                                       |
|---------------------|------------------------------------------------|
| `map-editor`        | Editor visual de mapas 2.5D (tileset + lógica) |
| `asset-pipeline`    | Otimização e empacotamento de sprites          |
| `Sentry/New Relic`  | Monitoramento e tracking de exceções           |
| `Prometheus + Grafana` | Métricas dos microserviços                  |
| `Docker Compose`    | Subir o ambiente completo localmente           |

## 🔗 Tecnologias Uguadas

- Java 24
- Micronaut
- Kafka / Redis Streams / Redis Pub Sub
- MongoDB + Redis + Caffeine
- Netty ou Vert.x (game server)
- JavaFX, libGDX, ou LWJGL (render)
