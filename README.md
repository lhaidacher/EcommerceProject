# MyEcommerceProject

## Überblick

Dieses Projekt demonstriert eine Microservices-basierte E-Commerce-Plattform, implementiert mit Java, Spring Boot und Spring Cloud. Es verwendet moderne Architektur-Patterns wie Service Discovery, API-Gateway, Load Balancing und Distributed Log-Tracing, um eine skalierbare, robuste und wartbare Anwendung zu realisieren.


## Anwendung starten

1. **Projekt bauen und starten:**
    - Navigieren Sie in das Root-Verzeichnis des Projekts.
    - Führen Sie den folgenden Gradle-Befehl aus, um alle Services zu bauen und zu starten:
      ```bash
      ./gradlew bootRun
      ```
    - Alternativ können Sie die einzelnen Services als Subprojekte in Ihrer IDE (z. B. IntelliJ) starten.

2. **Docker-Compose (inklusive Jaeger) starten:**
    - Stellen Sie sicher, dass Docker auf Ihrem System installiert und gestartet ist.
    - Starten Sie die Container mit:
      ```bash
      docker-compose up --build
      ```
    - Dadurch werden alle notwendigen Container (z. B. Service Registry, API-Gateway, Microservices, Jaeger) orchestriert und gestartet.

3. **API-Test-Files:**
    - Die API-Test-Dateien befinden sich im Verzeichnis `/api`.
    - Nutzen Sie diese Dateien, um Ihre Schnittstellen zu testen oder als Referenz für Ihre API-Dokumentation.

## Hinweise

- **Service Discovery & API-Gateway:**  
  Alle Microservices registrieren sich dynamisch bei der Service Registry, und das API-Gateway fungiert als zentraler Einstiegspunkt für externe Anfragen.
- **Distributed Log-Tracing:**  
  Mithilfe von Jaeger und OpenTelemetry wird der gesamte Pfad einer Anfrage nachvollzogen, was eine schnelle Diagnose und Optimierung ermöglicht.

