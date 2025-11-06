# 🧩 Tukuntech API Gateway

**Tukuntech API Gateway** acts as the single entry point for all frontend and backend communication within the Tukuntech platform.  
It currently routes all traffic to the monolithic backend and provides global CORS handling, route filtering, and metrics endpoints.  
This setup is the foundation for the upcoming microservices architecture.

---

## 🚀 Features

- 🌐 **Spring Cloud Gateway (v4.1.5)** — reverse proxy and smart routing.
- 🔒 **Spring Security (basic dev config)** — allows all requests in development mode.
- ⚙️ **CORS Management** — global, centralized control (no duplication between backend and gateway).
- 📊 **Spring Boot Actuator + Micrometer Prometheus** — for monitoring and observability.
- 🧰 **Ready for JWT Security** — can easily be extended for token validation.
- 🧱 **Supports migration** — each monolith context (`auth`, `care`, `profiles`, etc.) is already isolated as a future microservice.

---

## 🗂️ Project Structure

tukuntech-api-gateway/
├── src/
│ └── main/
│ ├── java/com/upc/tukuntechapigateway/
│ │ └── SecurityConfig.java
│ └── resources/
│ └── application.yml
├── pom.xml
└── README.md


---

## ⚙️ Configuration Summary

### 📄 `pom.xml`
Includes:
- `spring-cloud-starter-gateway` — routing engine.
- `spring-boot-starter-oauth2-resource-server` — for future JWT validation.
- `spring-boot-starter-actuator` — exposes `/actuator` endpoints.
- `micrometer-registry-prometheus` — integrates with Prometheus.
- `spring-boot-devtools` — developer hot reload.

---

### 🔐 `SecurityConfig.java`
Development configuration that:
- Permits all incoming requests.
- Allows all HTTP methods.
- Prepares structure for future JWT-based authentication.

---

### ⚙️ `application.yml`
Configured for:
- Global CORS (for `http://localhost:4200` frontend).
- Default filters (`RemoveRequestHeader=Cookie`, `DedupeResponseHeader`).
- Individual route mapping for each bounded context.
- Monolith fallback for unhandled routes.
- Runs on port `8081`.

---

## 🌍 Routing Table

| Route ID           | Path Predicate                     | Destination URI            | Purpose                        |
|--------------------|------------------------------------|----------------------------|--------------------------------|
| `auth`             | `/api/v1/auth/**`                  | `http://localhost:8080`    | Authentication and login        |
| `profiles`         | `/api/v1/profiles/**`              | `http://localhost:8080`    | User profiles                   |
| `monitoring`       | `/api/v1/monitoring/**`            | `http://localhost:8080`    | Monitoring module               |
| `care`             | `/api/v1/care/**`                  | `http://localhost:8080`    | Care management                 |
| `reports`          | `/api/v1/reports/**`               | `http://localhost:8080`    | Reports and analytics           |
| `support`          | `/api/v1/support/**`               | `http://localhost:8080`    | Support and helpdesk            |
| `swagger-docs`     | `/api/v1/v3/api-docs/**`           | `http://localhost:8080`    | Swagger documentation JSON      |
| `swagger-ui`       | `/api/v1/swagger-ui/**`            | `http://localhost:8080`    | Swagger UI interface            |
| `actuator-v1`      | `/api/v1/actuator/**`              | `http://localhost:8080`    | Health and metrics endpoints    |
| `actuator-root`    | `/actuator/**`                     | `http://localhost:8080`    | Health and metrics (root path)  |
| `monolith-fallback`| `/api/v1/**`                       | `http://localhost:8080`    | Catch-all route for legacy APIs |

---

## 🧭 How to Run

### 🧱 Prerequisites
- Java 21+
- Maven 3.9+
- The **monolithic backend** running on port **8080**
- The **Angular frontend** running on port **4200**

### ▶️ Run the gateway
```bash
./mvnw spring-boot:run


