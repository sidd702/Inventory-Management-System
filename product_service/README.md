# Inventory-Management-System
Backend Inventory Management System built using Java Spring Boot, PostgreSQL, and RabbitMQ. This project includes product management, stock operations, and event-driven notifications.

Inventory Management System

Difficulty: Hard |
Skills and Technologies Used:

    Java (Spring Boot Framework)
    PostgreSQL (Database)
    RabbitMQ (Event Handling)
    RESTful API Design
    Event-Driven Architecture

Project Overview: Create a backend to track inventory, restocking, orders, and related tasks. Learn event-driven systems with RabbitMQ and database management.

API Responsibilities:

    Inventory Management:
        Add/update products and stock levels.
        Process orders and update inventory.
        Notify low stock using RabbitMQ events.
    Task Operations (CRUD):
        Create a new task: Allow users to add a task with a title (e.g., "Restock Item #456"), description (e.g., stock details), and optional category (e.g., warehouse, urgent).
        Read tasks:
            Return all inventory tasks for the authenticated user.
            Filter by status (e.g., restocked or pending) or category.
            Retrieve a single task by its ID.
        Update a task: Modify task details (e.g., update stock quantity) or mark as restocked/pending using its ID.
        Delete a task: Remove an inventory task based on its ID.

Recommended Tech Stack:

    Framework: Spring Boot (Java)
    Database: PostgreSQL
    Events: RabbitMQ
