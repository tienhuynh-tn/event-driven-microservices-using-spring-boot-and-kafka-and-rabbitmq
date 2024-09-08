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

## What is RabbitMQ
### What is a Message Queue?
Message queuing allows applications to communicate by sending messages to each other. The message queue provides temporary
message storage when the destination program is busy or not connected

A message queue is made up of a producer, a broker (the message queue software), and a consumer.

A message queue provides an asynchronous communication between applications.

### What is RabbitMQ?
RabbitMQ is a message queue software (message broker/queue manager) that acts as an intermediary platform where different 
applications can send and receive messages.

RabbitMQ originally implements the Advanced Message Queuing Protocol (AMQP). But now RabbitMQ also supports several other 
API protocols such as STOMP, MQTT and HTTP.

Producer is an application that sends messages to the RabbitMQ broker and Consumer is an application that reads messages 
from the RabbitMQ broker.

### RabbitMQ Core Concepts
![](https://www.cloudamqp.com/img/blog/exchanges-bidings-routing-keys.png)
- **Producer:** An application that sends messages to the RabbitMQ broker, not directly to the consumer. Messages are sent to the broker, which then handles them. 
- **Consumer:** An application that reads messages from the RabbitMQ broker. Multiple consumers can subscribe to the broker to read messages sent by the producer.
- **Queue:** A buffer or storage in RabbitMQ that holds messages. Producers send messages to the broker, which stores them in a queue. Consumers then read messages from the queue. Multiple queues can be created in RabbitMQ. 
- **Message:** The information sent from a producer to a consumer through RabbitMQ. Messages can be in various formats such as strings, JSON, binary, plain text, or HTML. 
- **Exchange:** Acts as an intermediary between the producer and the queue. Instead of sending messages directly to a queue, producers send them to an exchange, which then routes them to the appropriate queues based on defined rules. 
- **Routing Key:** A key that an exchange uses to route messages to the appropriate queues. In complex applications with multiple queues, the producer sends a message with a routing key that the exchange uses to determine the correct queue. 
- **Binding:** A link between a queue and an exchange. Binding is necessary for an exchange to route messages to a queue, and it is established using a routing key.

## Note on When to use Kafka, and when to use RabbitMQ?
RabbitMQ and Apache Kafka are popular message brokers that can handle long-running tasks, but they have different design philosophies and use cases.
- **RabbitMQ** is a traditional message broker that is optimized for reliability and ease of use. It supports multiple messaging 
protocols and provides features like message queuing, routing, and delivery guarantees. RabbitMQ is commonly used in 
enterprise environments for mission-critical applications that require high availability and fault tolerance.
- **Apache Kafka**, on the other hand, is a distributed streaming platform that is optimized for scalability and high throughput. 
It is designed to handle large volumes of data in real time and supports features like event streaming, message replay, 
and distributed processing. Apache Kafka is commonly used for big data applications, IoT, and real-time analytics.
> If your application requires high reliability and ease of use, RabbitMQ may be a better choice. If your application 
> requires high scalability and real-time processing of large volumes of data, Apache Kafka may be a better choice. 
> It's also worth noting that there are other message brokers and streaming platforms available that may be better 
> suited for your specific use case. It's important to evaluate your options carefully and choose the one that best meets your requirements.