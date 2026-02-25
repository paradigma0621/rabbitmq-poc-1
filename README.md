# RABBITMQ POC #1

Using Java 21 and Spring Boot 3.2.x

Start RabbitMQ from this folder: `docker compose up`

## Orders Microservice
Producer
## Notification Microservice
Listener
## MailHog
MailHog is a fake SMTP server for development and testing.

It simulates an email server, but it does not send real emails to the internet.

Instead, it:
- Receives emails sent by your application
- Stores them temporarily
- Displays them in a web interface (`http://localhost:8025/`)

