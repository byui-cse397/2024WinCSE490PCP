# Software Design Description 
# Community Board Forum 
## Authors:
Anita Woodford

Submitted to: Brother William Clements

CSE 490R Special Topics

Project Manager: 
Team Leads: 

**Version:** 3.0  
**Date:** Post-Thursday's Update
## Details
## 1. Introduction

### Purpose
This document provides a detailed design overview for the Community Board Forum, an Android application aimed at facilitating community engagement and interaction. It serves as a blueprint for development, detailing the application's architecture, components, and interaction flows in adherence to the Model-View-Controller (MVC) design pattern.

### Scope
The application will support functionalities such as user registration and login, post creation and management, commenting, and searching, with a focus on mobile usability and performance.

### Definitions, Acronyms, and Abbreviations
- **SDD:** Software Design Description
- **SRS:** Software Requirements Specification
- **MVC:** Model-View-Controller
- **FE:** Front End
- **BE:** Back End
- **DB:** Database
- **CRUD:** Create, Read, Update, Delete

### References
- Software Requirements Specification for the Community Board Forum

# Table of Contents

## Overview 
The document is structured to guide the development process across the front-end, back-end, and database components, emphasizing detailed feature breakdowns and MVC implementation for each sub-feature.

## 2. System Overview

The Community Board Forum is transitioning to an Android application to directly target mobile users. This change impacts the development strategy, focusing on Android Studio for both front-end and back-end development, with MySQL for database management. The architecture supports modular development and scalability, adhering to MVC principles.

## 3. Design Considerations

### Assumptions and Dependencies
The application's successful operation depends on the Android operating environment, reliable internet connectivity, and the availability of AWS services for backend and database hosting.

### Development Environment Setup
Android Studio is designated for integrated development, with MySQL for data management. The backend services will be hosted on AWS, utilizing Linux-based/Ubuntu servers.

## 4. Architecture

### System Architecture Overview
The application leverages a microservices architecture, enabling independent development and scaling of its components. It integrates MVC across all levels—FE, BE, and DB—to ensure a cohesive and maintainable codebase.



## Front-End Design(Android Studio)
Focuses on delivering a seamless user experience with a native Android application, implementing views for user interaction and controllers for handling user input and system responses.

## Back-End Design (Java in Android Studio)
Utilizes Java for creating robust back-end logic, including APIs for data manipulation and communication with the MySQL database, following the controller component of MVC.

### Introduction 
The back-end system plays a critical role in managing the Community Board Forum's data and business logic. It serves as the intermediary between the front-end application and the database, handling user requests, processing data, and ensuring secure and efficient operations.

### Architecture 
* Description of the server setup and configuration.
* Outline of the frameworks and languages used.

### Search Functionality 
* View: Description of the API endpoints that serve the search functionality to the front end.
  
* Controller: Elaboration on the controller logic that processes search requests, including:
- Handling HTTP requests.
- Inter-controller communication (if applicable).
- Interaction with the Model for data retrieval.

* Model: Details on how search queries are constructed and executed against the database.
  This may include:
  - Data conversion and formatting.Communication with file storage if relevant.

## Database Design (MySQL)
Structured to support the application's data needs efficiently, with schemas for users, posts, and comments, incorporating CRUD operations at the database level.

## 5. Detailed System Design

### Main Feature: User Login

#### Sub-Features Breakdown
1. **User Authentication**
   - **Model (DB):** Manages user credentials and session data.
   - **View (FE):** Displays login UI and feedback.
   - **Controller (BE):** Handles authentication logic.

#### Data Description
Involves user credentials (username/password) and session management for maintaining login states.

#### Collaboration Requirements
Teams must define clear interfaces for credential validation, session management, and user feedback, ensuring seamless integration across MVC components.
### Search Functionality

#### Data Description
Here, you would describe the types of data involved in the search functionality, such as user credentials (username/password), search criteria (destination, category, timestamp), and how this data is managed and utilized within the system.

After providing a thorough understanding of the data aspects, you then introduce the sequence diagram to visually represent how this data is processed within the MVC framework of your application.

#### Search Functionality Sequence Diagram
Following the data description, the sequence diagram illustrates the interactions for the search functionality within the Community Board Forum. This visualization helps in understanding the dynamic process from when a user initiates a search query to when the results are displayed.

- **Stimulus/Response Sequences (MVC Framework):**
  - **Stimulus:** User inputs search criteria in the View.
  - **Controller Action:** Interprets the input and communicates with the Model.
  - **Model Processing:** The Model queries the database using the search criteria and retrieves matching posts.
  - **Response:** The View updates to display the search results to the user.

![Search Functionality Sequence Diagram](https://github.com/byui-cse397/2024WinCSE490PCP/blob/1a674c31fd77cbb03b71c26bd620919a18e3ec4d/ProjectManagement/Design/Images/Backend-search.drawio.png)

This sequence diagram is essential for detailing the operational flow of the search functionality, emphasizing the MVC architectural pattern's role in facilitating this feature.

## Development and Runtime Environment Setup
Preparation for implementation includes setting up Android Studio, configuring MySQL, and preparing AWS environments for both development and operational deployment.

## Implementation Planning
- **First Feature Implementation:** Begins with user login due to its central role in user access control.
- **Classes for Implementation:** Detailed planning for the classes involved in the login feature is required, focusing on MVC implementation across the FE, BE, and DB.

## 8. Appendices
Includes installation guides, class diagrams, interface definitions, and detailed instructions tailored to the Android and MySQL setup, ensuring readiness for the project's implementation phase.

