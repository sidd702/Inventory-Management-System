# Inventory-Management-System

Backend Inventory Management System built using Java Spring Boot, PostgreSQL, and RabbitMQ. This project includes product management, stock operations, and event-driven notifications.



Difficulty: Hard | Skills and Technologies Used:



&nbsp;   Java (Spring Boot Framework)

&nbsp;   PostgreSQL (Database)

&nbsp;   RabbitMQ (Event Handling)

&nbsp;   RESTful API Design

&nbsp;   Event-Driven Architecture



Project Overview: Create a backend to track inventory, restocking, orders, and related tasks. Learn event-driven systems with RabbitMQ and database management.



API Responsibilities:



&nbsp;   Inventory Management:

&nbsp;       Add/update products and stock levels.

&nbsp;       Process orders and update inventory.

&nbsp;       Notify low stock using RabbitMQ events.

&nbsp;   Task Operations (CRUD):

&nbsp;       Create a new task: Allow users to add a task with a title (e.g., "Restock Item #456"), description (e.g., stock details), and optional category (e.g., warehouse, urgent).

&nbsp;       Read tasks:

&nbsp;           Return all inventory tasks for the authenticated user.

&nbsp;           Filter by status (e.g., restocked or pending) or category.

&nbsp;           Retrieve a single task by its ID.

&nbsp;       Update a task: Modify task details (e.g., update stock quantity) or mark as restocked/pending using its ID.

&nbsp;       Delete a task: Remove an inventory task based on its ID.



Recommended Tech Stack:



&nbsp;   Framework: Spring Boot (Java)

&nbsp;   Database: PostgreSQL

&nbsp;   Events: RabbitMQ



