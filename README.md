# Event-driven Microservices using Spring Boot and RabbitMQ

## What is event-drive architecture?
Event-driven architecture is a software design pattern in which decoupled applications can asynchronously publish and 
subscribe to events via an event broker/message broker.

In an event-driven architecture, applications communicate with each other by sending and/or receiving events or messages.

Event-driven architecture is often referred to as "asynchronous" communication.

Event-driven apps can be created in any programming language because event-driven is a programming approach, not a language.

An event-driven architecture is loosely coupled.

## How Event-driven Architecture works and it's advantages
Event-driven microservices architecture is a design pattern where multiple microservices communicate asynchronously 
through a message broker. This architecture improves flexibility, scalability, and maintainability by decoupling 
services from one another, enabling them to work independently and communicate via events.

**1. Microservices and Message Broker:**

In an event-driven architecture, each microservice has a specific responsibility, such as handling orders, 
managing stock, or sending emails.

Microservices communicate asynchronously by publishing and consuming events through a message broker like RabbitMQ, 
Apache Kafka, or Apache ActiveMQ.

### How It Works:

When an event (e.g., a customer places an order) occurs, the relevant microservice (e.g., Order Service) creates an event 
and publishes it to the message broker. Other microservices (e.g., Stock Service, Email Service) that are subscribed to 
the message broker consume the event and perform their respective tasks, such as updating stock or sending an order confirmation email.

**2. Advantages of Event-Driven Architecture:**

- **Flexibility and Maintainability:** Each microservice is responsible for a specific task and can be developed, 
deployed, and maintained independently. This separation of concerns ensures that changes in one service do not affect others.
- **Scalability:** New microservices can be added easily without affecting existing ones. For example, adding an 
SMS Service to send SMS notifications can be done by subscribing to the relevant events from the message broker.
- **Improved Availability:** If one microservice fails, it does not impact the functioning of other microservices. 
This contrasts with monolithic architectures, where a failure in one part can cause the entire application to fail.
- **Loose Coupling:** Services are decoupled from one another, relying only on the message broker for communication. 
This reduces dependencies and makes the architecture more robust.

> In summary, event-driven architecture is an effective approach for building scalable, flexible, and highly available 
microservices-based applications. It provides clear separation of responsibilities, allows independent scaling and maintenance, 
and enhances overall system resilience.