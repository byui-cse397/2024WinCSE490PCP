**Software Design Description (SDD) for Community Board Forum**

**Document Identifier:** SDD-CBF-003

# 1. Front Matter

## 1.1 Authors

###  Frontend
- Darcy Merilan (Team Lead)
- Andrew Swayze
- Angela Slinker
- Conner Wadsworth
- Bryan Welton
### Backend
- Brian Anderson
- Jessica Vargas
- Anita Woodford
- George Krenk
- Allan Marina (Team Lead)
### Database
- Joshua Bee
- Brian Anderson
- Nolan Jeppson
- Kjellden Knutzen
- Claudio Parra

**Submitted to**
Brother William Clements  
CSE 490R Special Topics

**Project Management**
- **Project Manager:** [Project Manager's Name]
- **Team Leads:** [Joshua Bee, Darcy Merilan, Allan Marina]

**Version:** 6.0  
**Date:** [Current Date or "Post-Thursday's Update"]

---


## 1.2 Revision History
===============

| Date       | Version | Description of Changes                                      |
|------------|---------|-------------------------------------------------------------|
| 02/16/2024 | 1.0     | Initial creation of the document. Outlined basic structure and introduced key sections including Introduction, System Overview, and Initial Architecture. |
| 02/18/2024 | 2.0     | Minor updates and corrections. Enhanced the Architecture section, added preliminary details to the Design Considerations, and revised the Introduction for clarity. |
| 02/19/2024 | 3.0     | Today's updates include: Correcting the title page to better align with IEEE standards; Refining the Revision History section for enhanced document control and transparency; Adjusting the Table of Contents for improved navigation and consistency; Incorporating detailed descriptions and examples in the References section as per IEEE citation standards; Expanding the Search Functionality Overview with a more in-depth explanation of the MVC components and back-end processing; Adding detailed diagrams for the Model, View, and Controller to visually support the Search Functionality descriptions. |
| TBD        | 4.0     | Comprehensive review and update based on feedback. Enhanced security considerations, refined data models, and expanded the Appendix with additional resources. |
| 04/04/2024|5.0| Added info from the code that was not listed. User Account Management Security and Privacy, data collection and storage added 'CreateUser' information.|



**Date:** 02/19/2024

## 1.3 Table of Contents
- [1. Front Matter](#1-front-matter)
  - [1.1 Authors](#11-authors)
    - [Frontend](#frontend)
    - [Backend](#backend)
    - [Database](#database)
  - [1.2 Revision History](#12-revision-history)
  - [1.3 Table of Contents](#13-table-of-contents)
  - [1.4 References](#14-references)
- [Details](#details)
- [2. Introduction](#2-introduction)
  - [2.1 Purpose](#21-purpose)
  - [2.2 Scope](#22-scope)
  - [2.3 Glossary](#23-glossary)
  - [2.4 Overview](#24-overview)
- [3. System Overview](#3-system-overview)
- [4. Design Considerations](#4-design-considerations)
  - [4.1 Assumptions and Dependencies](#41-assumptions-and-dependencies)
    - [4.1.1 CreateUser Dependencies](#411-createuser-dependencies)
  - [4.2 Development Environment Setup](#42-development-environment-setup)
    - [Backend Development Environment Setup](#backend-development-environment-setup)
      - [Required Software and Tool](#required-software-and-tool)
  - [4.3 Security Considerations](#43-security-considerations)
- [5. Architecture](#5-architecture)
  - [5.1 System Architecture Overview](#51-system-architecture-overview)
  - [5.2 Front-End Design(Android Studio)](#52-front-end-designandroid-studio)
    - [Security Architeture](#security-architeture)
  - [5.3 Back-End Design (Java in Android Studio)](#53-back-end-design-java-in-android-studio)
    - [5.3.1 Introduction](#531-introduction)
    - [5.3.2 Architecture](#532-architecture)
    - [5.3.3 Delete Account](#533-delete-account)
    - [5.3.4 Login Functionality](#534-login-functionality)
    - [Login Functionality Overview](#login-functionality-overview)
    - [Model - Class Diagram](#model---class-diagram)
    - [Registration Functionality](#registration-functionality)
  - [Registration Functionality Overview](#registration-functionality-overview)
    - [Model – Process Flow Diagram](#model--process-flow-diagram)
  - [Controller](#controller)
    - [Search Functionality](#search-functionality)
  - [Search Functionality Overview](#search-functionality-overview)
    - [Model - Class Diagram](#model---class-diagram-1)
    - [Back-End System Processing of Search Requests](#back-end-system-processing-of-search-requests)
    - [View - Process Flow Diagram](#view---process-flow-diagram)
    - [Controller - Process Flow Diagram](#controller---process-flow-diagram)
  - [5.4 Database Design (MySQL)](#54-database-design-mysql)
    - [Account Sequence Diagram](#account-sequence-diagram)
    - [Post Sequence Diagram](#post-sequence-diagram)
    - [Community Sequence Diagram](#community-sequence-diagram)
- [6. Detailed System Design](#6-detailed-system-design)
  - [6.1 User Registration and Account Creation](#61-user-registration-and-account-creation)
    - [Overview :](#overview-)
    - [User Entity Representation](#user-entity-representation)
    - [Validation Mechanisms](#validation-mechanisms)
    - [Logging Strategy](#logging-strategy)
    - [Database Schema Design](#database-schema-design)
    - [Sub-Features Breakdown](#sub-features-breakdown)
    - [Data Description](#data-description)
    - [Collaboration Requirements](#collaboration-requirements)
  - [6.2 DeleteUser Class](#62-deleteuser-class)
    - [6.2.1 Overview:](#621-overview)
    - [6.2.2 Class Responsibilities:](#622-class-responsibilities)
    - [6.2.3 Attributes:](#623-attributes)
    - [6.2.4 Methods:](#624-methods)
    - [6.2.5 Interaction with Database:](#625-interaction-with-database)
    - [6.2.6 Security Measures:](#626-security-measures)
  - [6.3 Search Functionality](#63-search-functionality)
    - [6.3.1 OverView 'FindUser' Class Implementation](#631-overview-finduser-class-implementation)
    - [6.3.2 Class Responsibilities](#632-class-responsibilities)
    - [6.3.3 Attributes](#633-attributes)
    - [6.3.4 Methods](#634-methods)
    - [6.3.5 Interactions with Database](#635-interactions-with-database)
    - [6.3.6 Error Handling](#636-error-handling)
    - [6.3.7 Security Measure](#637-security-measure)
    - [Data Description](#data-description-1)
    - [Search Functionality Sequence Diagram](#search-functionality-sequence-diagram)
- [7 Front End :](#7-front-end-)
  - [7.1 User Account Management](#71-user-account-management)
    - [7.1.1 Security:](#711-security)
    - [7.1.2 View:](#712-view)
    - [7.1.3 Create:](#713-create)
    - [7.1.4 Read:](#714-read)
    - [7.1.5 Update:](#715-update)
    - [7.1.6 Delete:](#716-delete)
  - [7.2 Community Posts](#72-community-posts)
    - [7.2.1 View:](#721-view)
    - [7.2.2 Create:](#722-create)
    - [7.2.3 Read:](#723-read)
    - [7.2.4 Update:](#724-update)
    - [7.2.4 Delete:](#724-delete)
  - [7.3 Search Functionality](#73-search-functionality)
    - [7.3.1 View:](#731-view)
    - [7.3.2 Create:](#732-create)
    - [7.3.3 Read:](#733-read)
    - [7.3.4 Update:](#734-update)
    - [7.3.5 Delete:](#735-delete)
  - [7.4 Front End Design Detail:](#74-front-end-design-detail)
    - [7.4.1 User Account Management flow system:](#741-user-account-management-flow-system)
    - [7.4.2 Content Page Flow System:](#742-content-page-flow-system)
- [8 Development and Runtime Environment Setup](#8-development-and-runtime-environment-setup)
- [9. Implementation Planning](#9-implementation-planning)
  - [User account Creation Process](#user-account-creation-process)
- [10. Password Handling](#10-password-handling)
- [11. Appendices](#11-appendices)



## 1.4 References

The following references were used in the preparation of this Software Design Description (SDD) document:

1. IEEE. (2010). *IEEE Std 830-1998, IEEE Recommended Practice for Software Requirements Specifications*. IEEE Computer Society.
2. IEEE. (2009). *IEEE Std 1016-2009, IEEE Standard for Information Technology—System Design—Software Design Descriptions*. IEEE Computer Society.
3. Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
4. Martin, R. C. (2003). *Agile Software Development: Principles, Patterns, and Practices*. Prentice Hall.
5. Android Developers. (n.d.). *Android Studio*. Retrieved February 2024, from 
6. MySQL. (n.d.). *MySQL Documentation*. Retrieved February 2024, from
7. Software Requirements Specification for the Community Board Forum

Please note that the URLs and access dates are fictional and provided for illustrative purposes only.

# Details
# 2. Introduction

## 2.1 Purpose
This document provides a detailed design overview for the Community Board Forum, an Android application aimed at facilitating community engagement and interaction. It serves as a blueprint for development, detailing the application's architecture, components, and interaction flows in adherence to the Model-View-Controller (MVC) design pattern.

## 2.2 Scope
The application will support functionalities such as user registration and login, post creation and management, commenting, and searching, with a focus on mobile usability and performance.

## 2.3 Glossary

This section provides definitions for terms, acronyms, and abbreviations used throughout the Software Design Description (SDD) document to ensure clarity for all readers.
Here's a comprehensive list combining the initial terms you provided with the additional ones, all organized in alphabetical order:

 **API**: Application Programming Interface. A set of functions and procedures allows the creation of applications that access the features or data of an operating system, application, or other service.
. **API Endpoint**: A specific point at the end of an API that the client calls to perform an action. It refers to the location where APIs can access the resources they need to carry out their function.
**Asynchronous Operations**: In software, operations occur without waiting for other operations to complete, allowing for more efficient task execution without blocking the execution flow.
4. ** BE **: Back end. This part of the software does not directly interact with the users. It is responsible for storing and retrieving data and performing background operations.
 **Captcha**: A system designed to distinguish human from machine input, typically to thwart spam and automated data extraction from websites.
 **Cloud Computing**: The delivery of computing services—including servers, storage, databases, networking, software, analytics, and intelligence—over the Internet ("the cloud") to offer faster innovation, flexible resources, and economies of scale.
 **CRUD**: Create, Read, Update, Delete. These are the four essential functions of persistent storage in software development. CRUD operations are essential for managing databases.
 ** DB **: Database. A structured set of data held in a computer, especially one that is accessible in various ways. It is used to store and manage data in the software system.
 **Data Interchange Format**: A standard format for exchanging or transferring data between software systems or components. Examples include JSON (JavaScript Object Notation) and XML (eXtensible Markup Language).
 **Data Schema**: An outline or blueprint of how data is organized in a database. It defines how entities like tables, fields, and databases relate to each other and the attributes of data stored in these entities.
**Data Validation**: Ensuring data entered into an application meets predefined formats, rules, and constraints. It is crucial for ensuring the integrity and correctness of data in software applications.
**Dependency**: In software, a dependency is a piece of software required by another piece to function. Software dependencies can include libraries, frameworks, and other software modules.
 **Digital Signature**: A mathematical scheme for demonstrating the authenticity of digital messages or documents. A valid digital signature gives a recipient reason to believe that a known sender created the message and was not altered in transit.
**Encryption** is the method by which information is converted into secret code that hides its true meaning. The science of encrypting and decrypting information is known as cryptography.
**Error Logging** is the process of recording errors that occur in the operation of a software system. It is intended to provide debug information to software developers and system administrators.
**FE**: Front End. The part of a software system or application that interacts directly with the user, presenting data and providing interfaces for user input.
**Frontend Cryptography Libraries**: Collections of functions and algorithms used in web development to perform cryptographic operations on the client side, such as hashing and encrypting data before it is sent over the network.
**Hash Function**: A function that converts an input (or 'message') into a fixed-size string of bytes, typically a digest unique to each input. It is used in various security applications and data management.
**HTTP**: Hypertext Transfer Protocol. An application protocol for distributed, collaborative, hypermedia information systems. HTTP is the foundation of data communication for the World Wide Web.
20. ** HTTPS **: Hypertext Transfer Protocol Secure. This is an extension of HTTP. It is used for secure communication over a computer network and is widely used on the Internet. In HTTPS, the communication protocol is encrypted using Transport Layer Security (TLS).
**IDE (Integrated Development Environment)**: A software application that provides comprehensive facilities to computer programmers for software development. An IDE normally consists of at least a source code editor, build automation tools and a debugger.
22. ** JSON ** is JavaScript Object Notation, an open standard file format and data interchange format that uses human-readable text to store and transmit data objects consisting of attribute-value pairs and arrays.
**MVC**: Model-View-Controller. A design pattern used for developing user interfaces that divides the related program logic into three interconnected elements. This pattern is used to separate internal representations of information from the ways that information is presented to and accepted by the user.
**NoSQL**: A class of database management systems that do not follow all of the rules of a traditional database. NoSQL databases help work with a huge quantity of data when the data's nature does not require a relational model.
**Password Hashing** converts a password into another string of characters, known as a hash, which is difficult to reverse. It provides a layer of security for stored passwords.
**SDD**: Software Design Description. This is a document that provides a comprehensive description of the software's design and architecture, outlining components, interactions, and processes.
**Session Token (JWT, Session ID)**: Data that is passed between the client and server to keep track of the state of a user's session. It can be a JSON Web Token (JWT) or a simple session ID.
**SQL**: Structured Query Language. A standard language for storing, manipulating, and retrieving data in databases.
**SRS**: Software Requirements Specification. A document that captures the complete software requirements for the system, including functional, non-functional, and interface specifications.
** UI **: User interface. The means by which the user and a computer system interact, in particular, the use of input devices and software.
**UI Components**: The elements that make up the user interface of a software application, including buttons, text fields, data displays, navigation menus, and any visual element that the user interacts with.
** UX **: User experience refers to a person's emotions and attitudes about using a particular product, system, or service. It includes the practical, experiential, affective, meaningful, and valuable aspects of human-computer interaction and product ownership.
**XML** is an eXtensible Markup Language, a markup language that defines a set of rules for encoding documents in a human-readable and machine-readable format.

Please note that this glossary is not exhaustive and may be updated as the project evolves and new terms are introduced or existing definitions are revised.


## 2.4 Overview 
The document is structured to guide the development process across the front-end, back-end, and database components, emphasizing detailed feature breakdowns and MVC implementation for each sub-feature.

# 3. System Overview

The Community Board Forum is transitioning to an Android application to directly target mobile users. This change impacts the development strategy, focusing on Android Studio for both front-end and back-end development, with MySQL for database management. The architecture supports modular development and scalability, adhering to MVC principles.

# 4. Design Considerations

## 4.1 Assumptions and Dependencies
The application's successful operation depends on the Android operating environment, reliable internet connectivity, and the availability of AWS services for backend and database hosting.

### 4.1.1 CreateUser Dependencies
- **Java Development Kit(JDK)**: Version 11 or above.
- **Logging Framework**: Utilizes 'java.util.logging'.
- **Password Hashing Library**: Bcrypt for Java, ensuring secure password storage.
- **Datavase Connectivity**: JDBC driver for MySQL version 8.0.23.
- **Frontend Cryptography Libraries**: Include cryptographic libraries such as `crypto-js` for password hashing within the frontend. This ensures that passwords are hashed before being transmitted over the network.

## 4.2 Development Environment Setup
Android Studio is designated for integrated development, with MySQL for data management. The backend services will be hosted on AWS, utilizing Linux-based/Ubuntu servers.

### Backend Development Environment Setup
To support the 'CreateUser' functionality and other system requirements, the development environment must include the following configurations and tools:

#### Required Software and Tool
- JDK: Install version 11 or higher.  [Download link](https://www.oracle.com/java/technologies/downloads/
- MySQL Server 8.0.23: [Installation guide](https://...)(https://dev.mysql.com/downloads/mysql/)
- IntelliJ IDEA , Eclipse, or Visual Studio for development.

## 4.3 Security Considerations

# 5. Architecture

## 5.1 System Architecture Overview
The system architecture encompasses teh intergration fo various functionalities, including robust user account manangement. This ensures the secure and efficient handling of user registerations with the system. 

The application leverages a microservices architecture, enabling independent development and scaling of its components. It integrates MVC across all levels—FE, BE, and DB—to ensure a cohesive and maintainable codebase.

## 5.2 Front-End Design(Android Studio)
Focuses on delivering a seamless user experience with a native Android application, implementing views for user interaction and controllers for handling user input and system responses.

### Security Architeture
The decision to implement password hashing on the front end forms a crucial part of our security architecture. This approach is primarily adopted to enhance security by ensuring that user passwords are never transmitted in plain text over the network, significantly reducing the risk of exposure during data transmission.


## 5.3 Back-End Design (Java in Android Studio)
Utilizes Java for creating robust back-end logic, including APIs for data manipulation and communication with the MySQL database, following the controller component of MVC.

### 5.3.1 Introduction 
The back-end system plays a critical role in managing the Community Board Forum's data and business logic. It serves as the intermediary between the front-end application and the database, handling user requests, processing data, and ensuring secure and efficient operations.

### 5.3.2 Architecture 
The back-end architecture is designed to support user search functionality through efficient database interactions and robust security measures. The system leverages a relational database to store and retrieve user account information, facilitating quick and secure user searches. Security measures include input validation, authentication protocols, and encrypted communication to safeguard user data and prevent unauthorized access.

* Description of the server setup and configuration.
* Outline of the frameworks and languages used.


### 5.3.3 Delete Account

This diagram represents the deletion of a user's account.

![pics](https://github.com/byui-cse397/2024WinCSE490PCP/assets/97206108/0b1fd12f-ee3c-4f54-8772-c41da8906d24)

The deletion function is responsible for deleting all information of a specified account. The process involves asking the user for their login information in order to ensure that the actual user is the one asking to delete the account.

### 5.3.4 Login Functionality

* View: Explanation of the user interface components responsible for login, such as input fields for username and password, and the login button.
  
* Controller: Description of the controller's functionality in managing login requests, encompassing:
- Receiving and validating user input from the View.
- Processing login requests, including authentication logic.
- Handling various HTTP requests related to login operations.
- Potential inter-controller communication for managing session data or user state.
- Interaction with the Model to access user credentials and authentication data.

* Model: Clarification on how user authentication and credential verification are executed, involving:
- Storage and retrieval of user credentials from the database.
- Hashing and comparison of passwords for secure authentication.
- Possible integration with external authentication services.
- Data conversion and formatting as necessary for database interaction.

### Login Functionality Overview

The login functionality serves as a foundational aspect of the Community Board Forum, facilitating user access and authentication within the system. It is architected based on the MVC design pattern, emphasizing meticulous design and implementation across the Model, View, and Controller layers to guarantee a streamlined and secure login process.

### Model - Class Diagram

This diagram represents the structure of the data model for the login functionality, detailing the classes, their attributes, methods, and relationships.

![Backend-User Account Management Class drawio](https://github.com/byui-cse397/2024WinCSE490PCP/assets/43421813/2c7ae3ef-ece0-4482-9529-0661ddd223af)

The Model component is responsible for the data representation of the login functionality, including the storage, retrieval, and search algorithms used to find, identify, and authorize the user. Specifically, the Model:

- **Stores**:
  - user credentials, including usernames, passwords (hashed or encrypted), and any additional user-related data.
  - Session information, including session ID and timestamp.
  - Access logs, including successful or failed attempts and login time.
- **Retrieves**
  - Authentication, including hashed or encrypted passwords associated with the username.
  - Authorization, including login function check for user permission and roles.
- **Processes** login attempts by the system receiving user input (username and password). If the username and password match to database data authentication is successful, and the user gains access.

**Back-End System Processing of Login Attempt**

- **User Authentication**:

The login functionality begins when the user attempts to log in.

The system receives the user’s input (username and password).

The Model (database) retrieves the hashed or encrypted password associated with the provided username.

The Controller compares the user’s input password (after hashing or encryption) with the stored password.

If they match, authentication is successful, and the user gains access.

- **Session Management**:
  - Upon successful authentication:

The system generates a **session ID** for the user.

The session ID is stored in the database or as a secure token (e.g., JWT).

The Controller associates the session ID with the user’s session.

Subsequent requests from the user include the session ID for authorization.

- **Authorization and Access Control**:
  - The Controller retrieves the user’s roles or permissions from the Model.
  - Based on the user’s role, the system determines what actions the user is allowed to perform.
  - Authorization rules define access to specific resources (e.g., read, write, delete).
  - Access control lists (ACLs) or role-based access control (RBAC) mechanisms are used.

**View - Process Flow Diagram**

Illustrates the user's journey through the login interface, from inputting login criteria to receiving and interacting with login results.

![Backend-User Login drawio (1)](https://github.com/byui-cse397/2024WinCSE490PCP/assets/43421813/0dd0ba5c-ce94-4029-aaff-5b9b4117c9f1)

The **View** component provides the interface through which users interact with the login functionality. It is designed to:

- **Present Login Inputs**:
  - The login view presents user-friendly input fields for:
    - **Username**: A field where users enter their unique usernames.
    - **Password**: A secure input field for users to enter their passwords.
    - **Remember Me**: An optional checkbox allowing users to stay logged in across sessions.
- **Feedback and Error Messages**:
  - The view displays feedback messages to guide users during login attempts:
    - **Success Message**: When authentication is successful, a message confirms access.
    - **Error Messages**: For failed login attempts (e.g., incorrect password, locked account).
- **Security Measures**:
  - The view incorporates security best practices:
    - **Password Masking**: Passwords are masked to prevent shoulder surfing.
    - **Captcha (Optional)**: To prevent automated attacks (e.g., bots).
- **Session Management**:
  - If the user selects “Remember Me”:
    - The view provides an option to keep the user logged in across sessions.
    - A persistent session token (e.g., cookie) is generated and stored securely.
- **Links and Actions**:
  - The view includes links or buttons for additional actions:
    - **Forgot Password**: A link to initiate password recovery.
    - **Create Account**: For new users to register.
    - **Contact Support**: In case of login issues.

**Controller**

Details the sequence of operations performed by the controller in response to a login attempt, including validating the username/ password and processing the login results.

The Controller acts as the intermediary between the View and Model, processing user input and managing the flow of data. For the search functionality, the Controller:

- **Interprets** user inputs from the View, converting them into queries or commands that the Model can execute.
- **Coordinates** with the Model to retrieve search results based on the processed queries, applying any necessary logic or filters that are better handled outside the database (e.g., post-processing of results for personalization).
- **Optimizes** the search performance by implementing caching strategies for frequently accessed data or managing asynchronous operations to ensure a responsive user experience.

### Registration Functionality

* View: The user interface elements responsible for registration are meticulously crafted to streamline the account creation process. These components typically include input fields for user information such as username, email, password, and a registration button.

* Controller: The controller component orchestrates the registration process, managing user input validation and registration requests. Its functionalities encompass:

- Receiving and validating user input from the registration form.
- Processing registration requests, including data validation and account creation logic.
- Handling various HTTP requests associated with the registration process.
- Potential inter-controller communication for managing session data or user state.
- Interacting with the Model to store user registration details securely.

* Model: The Model component governs the data management and authentication aspects of user registration. It involves:

- Storage and retrieval of user registration data from the database, ensuring data integrity and security.
- Hashing and secure storage of user passwords to safeguard sensitive information.
- Potential integration with external authentication services for enhanced security measures.
- Data conversion and formatting as necessary for seamless interaction with the database.

## Registration Functionality Overview

The registration functionality serves as a pivotal aspect of the Community Board Forum, enabling users to create accounts and gain access to the platform's features. It operates within the MVC design pattern, ensuring seamless coordination and efficiency across the Model, View, and Controller components.

### Model – Process Flow Diagram

This process flow diagram outlines the sequence of steps involved in user registration for the Community Board Forum, delineating the roles of the Model, View, and Controller components:.


![Backend-User Registration Class drawio (1)](https://github.com/byui-cse397/2024WinCSE490PCP/assets/43421813/f0913f10-5861-448a-80f7-5b5950eff9cc)

The Model component is responsible for the data representation of the registration functionality, including the storage, retrieval, and search algorithms used to find, identify, and authorize the user. Specifically, the Model:

- **Stores**:

- user credentials, including usernames, passwords (hashed or encrypted), and any additional user-related data.

- Session information, including session id and timestamp.

- Access logs, including successful or failed registration attempts.

- **Retrieves**

- Authentication, including hashed or encrypted password associated to username.

- Authorization, including login function check for user permission and roles.

- **Processes** registration attempts by the system receiving user input (username and password). If username and password successfully match criteria then it is stored in the database.

**Back-End System Processing of Registration Attempt**

- ** Receiving Registration Requests\*\*:

- The registration functionality begins when the backend server initializes the registration process upon receiving registration requests from clients (e.g., web browsers, mobile apps) via HTTP or HTTPS requests.

- User input, including username and password, is received by the system.

- The Model (database) retrieves the hashed or encrypted password associated with the provided username.

- The Controller validates the user’s input password (after hashing or encryption) by comparing it with the stored password.

- Successful authentication grants the user access to the system.

- If they match, authentication is successful, and the user gains access.

- **Session Management**:

- A unique session ID is generated by the system for the authenticated user.

- The session ID is securely stored either in the database or as a secure token such as JSON Web Token (JWT).

- The Controller establishes an association between the user’s session and the generated session ID.

- Subsequent requests from the user include the session ID for authentication and authorization purposes.

- **Authorization and Access Control**:

- The Controller retrieves the user’s roles or permissions from the Model upon successful authentication.

- Based on the user’s role, the system determines the actions the user is authorized to perform.

- Authorization rules are defined to regulate access to specific resources, specifying permissions such as read, write, or delete.

- Access control lists (ACLs) or role-based access control (RBAC) mechanisms are implemented to enforce access control policies effectively.

The View component of the user registration feature provides an intuitive and user-friendly interface for users to interact with during the registration process. It is structured to accommodate various elements essential for a seamless registration experience:

- ** Input Fields for Registration**:

- The view displays feedback messages to guide users during registration attempts:

- **Username**: A field where users enter their desired usernames.

- **Email**: An input field for users to provide their email addresses.

- **Password**: A secure input field for users to create and confirm their passwords.

- **Additional Information**: Optional fields for users to input additional details such as full name, date of birth, etc.

- **Feedback and Error Messages**:

- The view displays feedback messages to guide users during login attempts:

- **Success Message**: Upon successful registration, a confirmation message is displayed.

- **Error Messages**: For registration failures (e.g., username/email already exists, invalid email format).

- **Security Measures**:
  - The view incorporates security best practices to ensure the safety of user information:
    - **Password Strength Indicator**: Provides visual feedback on password strength to encourage secure password creation.
    - **Captcha (Optional)**: Optionally, a CAPTCHA may be included to prevent automated registration attempts and spam.
- **Terms and Conditions Agreement**:
  - The view includes a checkbox or agreement section where users can acknowledge and agree to the platform's terms and conditions and privacy policy.
- **Session Management**:
  - Upon successful registration, the view may provide an option to immediately log in or redirect users to a login page.
  - Persistent session tokens (e.g., cookies) are generated and securely stored to keep users logged in across sessions, if applicable.
- **Links and Actions**:
  - The view includes links or buttons for additional actions:
    - **Login**: For users who have already registered and wish to log in.
    - **Forgot Password**: A link to initiate the password recovery process.
    - **Contact Support**: In case users encounter issues during the registration process, a link or button is provided to contact support for assistance.

## Controller

The **Controller** component orchestrates the sequence of operations involved in processing user registration attempts, ensuring seamless interaction between the View and Model while managing data flow effectively. For the user registration feature, the Controller executes the following tasks:

- **Interpreting User Inputs**:
  - The Controller receives user inputs from the View, including username, email address, password, and additional registration details.
  - It interprets these inputs, validating them to ensure they meet the required format and criteria for registration.
- **Communicating with the Model**:
  - Upon receiving user inputs, the Controller communicates with the Model to initiate the registration process.
  - It passes the validated user data to the Model, triggering the creation of a new user account and storage of registration details in the database.
- **Model Processing**:
  - The Model processes the received user data, performing tasks such as hashing passwords, checking for existing usernames or email addresses, and storing user registration details securely in the database.
  - It handles any necessary data validation and ensures that user registration adheres to system requirements and constraints.
- **Response Handling**:
  - Upon completion of the registration process, the Controller manages the response flow back to the View.
  - It updates the View to provide feedback to the user regarding the outcome of the registration attempt, including success messages for successful registrations and error messages for registration failures (e.g., duplicate username, invalid email format).
- **Stimulus/Response Sequences (MVC Framework)**:
  - **Stimulus:** User provides registration details through the View.
  - **Controller Action:** The Controller interprets and validates user inputs, communicating registration requests to the Model.
  - **Model Processing:** The Model processes registration data, executing necessary operations such as data validation, storage, and error handling.
  - **Response:** The Controller updates the View to inform the user of the registration outcome, ensuring a clear and informative user experience.


### Search Functionality 
* View: Description of the API endpoints that serve the search functionality to the front end.
  
* Controller: Elaboration on the controller logic that processes search requests, including:
- Handling HTTP requests.
- Inter-controller communication (if applicable).
- Interaction with the Model for data retrieval.

* Model: Details on how search queries are constructed and executed against the database.
  This may include:
  - Data conversion and formatting.Communication with file storage if relevant.

## Search Functionality Overview

The search functionality is a critical component of the Community Board Forum, allowing users to efficiently find posts and information relevant to their interests. It is implemented following the MVC design pattern, with detailed considerations for the Model, View, and Controller components to ensure a seamless and efficient search experience.

### Model - Class Diagram

This diagram represents the structure of the data model for the search functionality, detailing the classes, their attributes, methods, and relationships.

![Search Functionality Model](https://github.com/byui-cse397/2024WinCSE490PCP/blob/4d26d701fcf4268802da566c0f77fe7c1320bdc7/ProjectManagement/Design/Images/BackendSearchClass.drawio.png)

The Model component is responsible for the data representation of the search functionality, including the storage, retrieval, and search algorithms used to find relevant posts or information within the Community Board Forum. Specifically, the Model:

- **Stores** data structures for posts, user profiles, and other searchable content, ensuring they're optimized for search operations (e.g., indexing certain fields like post titles or tags).
- **Retrieves** data in response to queries generated by the Controller, using optimized search algorithms (such as full-text search capabilities or more complex query optimizations that take into account user preferences and past search history).
- **Processes** search queries by applying filters and sorting criteria specified by the user, ensuring the most relevant results are returned. This may involve advanced query processing techniques like natural language processing (NLP) for understanding user intent.

### Back-End System Processing of Search Requests

Following the detailed description of the Model component, it's important to understand the technical strategies employed by the back-end system to optimize search results, ensuring efficiency and relevance:

- **Indexing**: Implementing indexing on searchable fields to expedite query execution, potentially utilizing specialized search engines like Elasticsearch or Apache Solr.
- **Ranking Algorithms**: Applying algorithms to rank search results by relevance, considering factors such as keyword matches, user engagement (views, likes), and content freshness.
- **Personalization**: Using user data to tailor search results, possibly with machine learning models to predict and highlight content matching individual preferences or past behavior.
- **Query Expansion and Correction**: Improving search queries with techniques like synonym expansion, spell correction, and query suggestions to enhance result accuracy and user satisfaction.

### View - Process Flow Diagram

Illustrates the user's journey through the search interface, from inputting search criteria to receiving and interacting with search results.

![Search Functionality View](https://github.com/byui-cse397/2024WinCSE490PCP/blob/4d26d701fcf4268802da566c0f77fe7c1320bdc7/ProjectManagement/Design/Images/BackendSeachFlowView.drawio.png)

The View component provides the interface through which users interact with the search functionality. It is designed to:

- **Present** search inputs and filters in a user-friendly manner, allowing users to specify their search criteria easily (e.g., through search bars, dropdowns for filters, and checkboxes for categories).
- **Display** search results clearly, offering options for sorting and filtering to refine the results further. This could include displaying results in various formats (list, grid) or highlighting key information that matches the search query.
- **Facilitate** user interactions with the search results, such as pagination or direct actions like saving a post or initiating contact based on a search result.

### Controller - Process Flow Diagram

Details the sequence of operations performed by the controller in response to a search request, including validating the search criteria and processing the search results.

![Search Functionality Controller](https://github.com/byui-cse397/2024WinCSE490PCP/blob/4d26d701fcf4268802da566c0f77fe7c1320bdc7/ProjectManagement/Design/Images/BackendSearchController.drawio.png)

The Controller acts as the intermediary between the View and Model, processing user input and managing the flow of data. For the search functionality, the Controller:

- **Interprets** user inputs from the View, converting them into queries or commands that the Model can execute.
- **Coordinates** with the Model to retrieve search results based on the processed queries, applying any necessary logic or filters that are better handled outside the database (e.g., post-processing of results for personalization).
- **Optimizes** the search performance by implementing caching strategies for frequently accessed data or managing asynchronous operations to ensure a responsive user experience.

## 5.4 Database Design (MySQL)
Structured to support the application's data needs efficiently, with schemas for users, posts, and comments, incorporating CRUD operations at the database level. The database will provide an interface for extending in backend that will connect the objects designed by backend to to tables and operations in the database.

```mermaid
erDiagram
    ACCOUNT {
        int id PK
        varchar username
        varchar password_hash
    }
    POST {
        int id PK
        varchar(800) content_text
        int account_id FK
        int community_id FK
        datetime post_time
    }
    
    ACCOUNT ||--o{ POST : contains

    COMMENTS {
        int id PK
        varchar comment_text
        int post_id FK
    }

    POST ||--o{ COMMENTS : contains

    DEPARTING {
        int id pk
        varchar location_text
        int post_id fk
    }

    POST ||--o{ DEPARTING : contains

    ARRIVING {
        int id pk
        varchar location_text
        int post_id fk
    }

    POST ||--o{ ARRIVING : contains

    COMMUNITY ||--o{ FORUMS : contains
    COMMUNITY {
        int id PK
        varchar community_name
        int parent_account_id FK
    }

    FORUMS ||--o{ POST : contains
    FORUMS {
        int id PK
        varchar forum_name
        int post_id FK
    }

     ACCOUNT ||--o{ MESSAGES: contains
    MESSAGES{
        int id PK
        int sender_id FK
        int receiver_id FK
        varchar[300] message_content
        datetime message_time
    }
```
### Account Sequence Diagram
![Account Sequence Diagram](https://github.com/byui-cse397/2024WinCSE490PCP/blob/Week10/ProjectManagement/Design/Images/Account.drawio.png)
### Post Sequence Diagram
![Post Sequence Diagram](https://github.com/byui-cse397/2024WinCSE490PCP/blob/Week10/ProjectManagement/Design/Images/Post.drawio.png)
### Community Sequence Diagram
![Community Sequence Diagram](https://github.com/byui-cse397/2024WinCSE490PCP/blob/Week10/ProjectManagement/Design/Images/Community.drawio.png)

# 6. Detailed System Design

## 6.1 User Registration and Account Creation

### Overview :
The 'createUser' class is desinged to encapsulate the functionality related to registering and adding new users tothe system. Its primary reesponsbilities are:

- **Collecting User Date**: Gathering information from the user such as username , email,password. 
- **Validating Input**: All information gathered from the user will meet certain criteria, such as password complexity requriemetns, valid email format, and uniqueness of the username within the system. 
- **Password Hashing**: Securely handles te user's password by applying hashing functions in the frontend before submission to the backend. This security measure will prevent storing passwords in plain text. 
- **Pesisting User Data**: Saves the valiadated adn process user data in the database, creating a new user account within the system 
- **Error Handling**: Provides feedback for any errors encountered during the registration process.
- **User Feedback**: Communictes the success of the account creation precess to the user and possibly guiding them to the next step,such as logging in or verifying their email address. 

### User Entity Representation 
A detailed description of the entity is provided, including attributes such as 'username' , 'email', 'password_hash', 'registrationDate', 'lastLoginDate', and 'isActive'. This entity captures user information and status within the system. 

### Validation Mechanisms
The system utilizes regular expressions to validate user inputs during the registration procese. The email address is checked against a pattern that ensures it conforms to tstandard email formatting. Similarly, the password is validated to ensure it meets the specified security criteria, including length and character composition. 

### Logging Strategy 
A comprehensive logging strategy is outlined, where system actions relate to user account managment(such as update to username, email, password, and account status) are logged for auditing and monitoring purposes, This approach aids in debugging and ensures accountablility within the system. 

### Database Schema Design
The document details the database schema, particularly focusing on the "ACCOUNT" table, which stores user information. This section specifies the table's structure, including fields for storing usernames, hashed passwords, email addresses, registration dates, and activity statuses, aligning with the system's data managements. 

### Sub-Features Breakdown
   - **User Authentication**
   - **Model (DB):** Manages user credentials and session data.
   - **View (FE):** Displays login UI and feedback.
   - **Controller (BE):** Handles authentication logic.

### Data Description
Involves user credentials (username/password) and session management for maintaining login states.

### Collaboration Requirements
Teams must define clear interfaces for credential validation, session management, and user feedback, ensuring seamless integration across MVC components.

## 6.2 DeleteUser Class

### 6.2.1 Overview:
The DeleteUser class facilitates the deletion of user accounts from the system. To ensure account security, DeleteUser requires verification of the user's password before proceeding with the deletion.

### 6.2.2 Class Responsibilities:
- Verify the user's identity by comparing the provided password hash with the one stored in the database.
- Remove all user data from the database upon successful authentication.
- Provide feedback on the success or failure of the account deletion process.

### 6.2.3 Attributes:
- **userId**: The integer identifies the user's account that needs to be deleted.
- **password_Hash**: String containing the hash of the password provided by the user for verification.
- **confirmPassword_Hash**: String containing the hash of the confirmation password for additional verification.

### 6.2.4 Methods:
- nullIdCheck(): Ensures the userId is not null, throwing a FrontEndUsageException if it is.

### 6.2.5 Interaction with Database:
This class interacts with the ACCOUNT table in the database, specifically targeting the record associated with the userId. Upon successful verification, it issues a delete command to remove the user's record and all related data.

### 6.2.6 Security Measures:
- The class implements secure password verification to prevent unauthorized account deletion.
- Utilizes secure communication channels to protect user data during the deletion process.

## 6.3 Search Functionality

### 6.3.1 OverView 'FindUser' Class Implementation
The FindUser class is central to the system's ability to search for users by username. It extends the FindDBAction abstract class, inheriting the capability to execute database search operations.

### 6.3.2 Class Responsibilities

### 6.3.3 Attributes

### 6.3.4 Methods
- getTable(): Specifies the database table (ACCOUNT) targeted for the search, ensuring that queries are executed against the correct data set.
- checks(): Performs preliminary checks before executing the search query. This includes invoking nullUserCheck to validate that the username input is not null or empty.
- nullUserCheck(): Throws a FrontEndUsageException if the username input is null or empty, preventing the query from executing with invalid parameters.
- buildQuery(Map<String, String> colValueMap): Constructs the SQL query for searching the database. It uses a regular expression (REGEXP) to match the username, enhancing the flexibility of search operations.

### 6.3.5 Interactions with Database
The ACCOUNT table within the database schema is crucial for storing user information.
- username: A unique identifier for each user, used as the primary search parameter.
- password_hash: Stores the hashed version of the user's password, reinforcing security by avoiding plain text storage.

### 6.3.6 Error Handling 
The FindUser class implements specific error-handling strategies to manage null or empty username inputs gracefully.
- Invoking the nullUserCheck method ensures that the search operation only proceeds with valid input, reducing the risk of errors or security vulnerabilities.

### 6.3.7 Security Measure 
**User Authentication:** Before performing a search operation, the system verifies the user's identity to ensure that only authorized users can execute searches.
**Input Validation:** The nullUserCheck method is part of our input validation strategy. It ensures the integrity of search parameters, preventing SQL injection and other security threats.
**Regular Expressions in Queries:** Using regular expressions (REGEXP) for username searches adds an extra layer of flexibility and security. It allows for precise matching criteria without exposing the system to injection attacks.

### Data Description
Here, you would describe the types of data involved in the search functionality, such as user credentials (username/password), search criteria (destination, category, timestamp), and how this data is managed and utilized within the system.

After providing a thorough understanding of the data aspects, you then introduce the sequence diagram to visually represent how this data is processed within the MVC framework of your application.

### Search Functionality Sequence Diagram
Following the data description, the sequence diagram illustrates the interactions for the search functionality within the Community Board Forum. This visualization helps in understanding the dynamic process from when a user initiates a search query to when the results are displayed.

- **Stimulus/Response Sequences (MVC Framework):**
  - **Stimulus:** User inputs search criteria in the View.
  - **Controller Action:** Interprets the input and communicates with the Model.
  - **Model Processing:** The Model queries the database using the search criteria and retrieves matching posts.
  - **Response:** The View updates to display the search results to the user.

![Search Functionality Sequence Diagram](https://github.com/byui-cse397/2024WinCSE490PCP/blob/1a674c31fd77cbb03b71c26bd620919a18e3ec4d/ProjectManagement/Design/Images/Backend-search.drawio.png)

This sequence diagram is essential for detailing the operational flow of the search functionality, emphasizing the MVC architectural pattern's role in facilitating this feature.


# 7 Front End :

## 7.1 User Account Management 
The system must ensure security by implementing robust authorization, authentication, and access control mechanisms to protect user data and privacy.

### 7.1.1 Security:
The backend program will look for and report on suspicious activity that could be linked to a potential bot. This program will look for repeated suspicious sign-in attempts or bot-like behavior within an account (high post frequency, high comment frequency, etc). When these are seen, the program will alert the owner of the account (in the case of bot-like attempts trying to sign in) and warn the owner of this app of the behavior. If serious or repeated enough, this could put a block on the account until everything is figured out.
### 7.1.2 View:
The user interface elements for account registration, login, profile management, and account settings. This includes forms for input, pages for viewing and editing user profiles, and menus for accessing account settings. The View listens for user actions (e.g., button clicks, form submissions) and communicates these actions to the Controller.
### 7.1.3 Create:
- *Registration Form*
  - *Description:* Allows new users to create an account by entering their details, such as username, email, and password.
  - *Elements:* Text inputs for username, email, password, and possibly captcha or security questions for bot protection and user verification. A submit button to send the registration request.
  - *Actions:* When the user fills out the form and clicks the submit button, the View sends this information to the Controller to process the account creation.
### 7.1.4 Read:
- *Login Form*
  - *Description:* Enables users to access their account by providing their credentials.
  - *Elements:* Text inputs for username/email and password, with a submit button for logging in. Links for "Forgot password" or "Register" for navigation to other views.
  - *Actions:* Submitting the form sends the credentials to the Controller, which verifies them against the Model data.
- *Profile Page*
  - *Description:* Displays the user's profile information, including username, email, and any additional details like bio or profile picture.
  - *Elements:* Text and possibly images showing the user's information. May include an "Edit Profile" button to navigate to the Update view.
  - *Actions:* Viewing the profile does not directly interact with the Controller but may involve fetching updated information from the Model through the Controller.
### 7.1.5 Update:
- *Profile Edit Form*
  - *Description:* Allows users to update their profile information, such as email, bio, and profile picture.
  - *Elements:* Pre-filled text inputs and file upload inputs with the user's current information, and a submit button to apply changes.
  - *Actions:* Submitting the updated information sends it to the Controller, which processes the update requests and modifies the Model accordingly.
- *Change Password Form*
  - *Description:* Provides a way for users to change their password.
  - *Elements:* Text inputs for the old password, new password, and new password confirmation. A submit button to apply the password change.
  - *Actions:* On submission, the View sends the password details to the Controller, which handles the password update process.
### 7.1.6 Delete:
- *Account Deletion Option*
  - *Description:* Offers users the option to delete their account.
  - *Elements:* A "Delete Account" button, often accompanied by a confirmation step (e.g., entering a password or answering a security question) to prevent accidental deletions.
  - *Actions:* Confirming account deletion sends a request to the Controller to remove the user's account from the Model.

## 7.2 Community Posts 
Users can create posts to seek or offer rides, promoting transportation assistance within the community. Posts must include attributes like start and stop destinations, description, category, timestamp, rating, and available passenger seats to enable effective communication.
### 7.2.1 View:
The components and pages that display community posts, comments, and the interface for creating and editing posts. This includes the post feed, individual post views, and forms for post creation and editing. The View updates in response to user interactions and data changes, informing the Controller of user actions like post submissions or comment additions.
### 7.2.2 Create: 
- *Create Post Form*
  - *Description:* Allows users to create new posts by entering details such as start and stop destinations, description, category, timestamp, rating, and available passenger seats. 
  - *Elements:* Input fields, dropdowns, or other UI elements for each post attribute. A submit button to create the post. 
  - *Actions:* When the user submits the create post form, the view sends the post details to the controller, which processes the request and adds the new post to the model.
### 7.2.3 Read:
- *Post Feed*
  - *Description:* Displays community posts in a feed format, allowing users to easily browse through available options.
  - *Elements:* A list or grid displaying posts with summarized information. Each post may include start and stop destinations, description, category, timestamp, rating, and available passenger seats.
  - *Actions:* Viewing the post feed involves fetching and displaying data from the model. Users can click on individual posts to view more details.
### 7.2.4 Update:
- *Edit Post Form*
  - *Description:* Enables post creators to update their posts by modifying details such as start and stop destinations, description, category, timestamp, rating, and available passenger seats.
  - *Elements:* Pre-filled input fields and dropdowns with the current post details. A submit button to apply the changes.
  - *Actions:* Submitting the updated information sends it to the controller, which processes the update requests and modifies the model to reflect the changes.
### 7.2.4 Delete:
- *Delete Post Option*
  - *Description:* Provides users with the option to delete their own posts, preventing accidental deletions through a confirmation step.
  - *Elements:* A "Delete Post" button, accompanied by a confirmation modal or dialog. Users may need to confirm the deletion by entering a password or answering a security question.
  - *Actions:* Confirming post deletion sends a request to the controller to remove the post from the model. The confirmation step helps prevent accidental deletions.

---

## 7.3 Search Functionality 
The system must provide users with the ability to search for specific users, communities and posts based on criteria such as names and keywords, facilitating efficient discovery of relevant information.

### 7.3.1 View:
The search functionality view is responsible for providing users with a user-friendly interface to perform searches. This includes input fields for entering search criteria, search result display, and any additional features that enhance the search experience. The view communicates user input to the controller, which then processes the search query and updates the view with the relevant results.
### 7.3.2 Create:
- *Search Form*
  - *Description:* Allows users to input search criteria such as user names and keywords.
  - *Elements:* Text inputs, dropdowns, or other input fields for specifying search criteria. A submit button to initiate the search.
  - *Actions:* When the user submits the search form, the view sends the search criteria to the controller, which processes the request and queries the model for matching posts.
### 7.3.3 Read:
- *Search Results*
  - *Description:* Displays the search results based on the specified criteria.
  - *Elements:* A list or grid displaying relevant posts that match the search criteria. Each result should provide a summary of the post.
  - *Actions:* Viewing search results doesn't directly interact with the controller but involves fetching and displaying data from the model based on the search criteria.
### 7.3.4 Update:
- *Refine Search Options*
  - *Description:* Allows users to modify their search criteria without starting a new search.
  - *Elements:* Additional controls or filters to refine the ongoing search, such as adjusting timestamps, changing categories, or adding/removing criteria.
  - *Actions:* When the user modifies the search options, the view sends the updated criteria to the controller, which reprocesses the search and
### 7.3.5 Delete:
- **Clear Search Form**
  - *Description:* Enables users to clear the search form and start a new search.
  - *Elements:* A "Clear" or "Reset" button to clear all entered search criteria.
  - *Actions:* Clicking the "Clear" button sends a request to the controller to reset the search criteria, clearing the form and potentially resetting the displayed results.

## 7.4 Front End Design Detail:
### 7.4.1 User Account Management flow system:
![User Account Management Flow system](https://github.com/byui-cse397/2024WinCSE490PCP/blob/Week08/ProjectManagement/Design/Images/Community%20Board%20Front%20End%20Design%20%26%20Flow.png)
### 7.4.2 Content Page Flow System:
![Page Navigation](https://github.com/byui-cse397/2024WinCSE490PCP/blob/Week08/ProjectManagement/Design/Images/Community%20Board%20Front%20End%20Design%20%26%20Flow%20(1).png)

Built on Canva (https://www.canva.com/design/DAF9RvzfjLY/bPRp0hg_JXf9df6RHb-aEQ/edit)

# 8 Development and Runtime Environment Setup
Preparation for implementation includes setting up Android Studio, configuring MySQL, and preparing AWS environments for both development and operational deployment.

# 9. Implementation Planning
- **First Feature Implementation:** Begins with user login due to its central role in user access control.

## User account Creation Process
The plan for implementing the user account creation feature is detailed, referncing the 'createNewUser' method. It includes steps for user input validation, password hashing, logging of keys actions, and data storage in the 'ACCOUNT' table. This process ensures the secure and efficient handling of user registrations. 

- **Classes for Implementation:** Detailed planning for the classes involved in the login feature is required, focusing on MVC implementation across the FE, BE, and DB.

# 10. Password Handling
This secton describes the system's approach to securing user passwords, emphasizing the use of hashing algorithms for password storage. It outlines the criteria for paassword strength and the validation process to ensure user security. 

By incorporating these updates, teh SRS and SDD will accurately reflect the functionalities and design considerations of the 'CreateUser' class, ensuring a comprehensive and clear documentation of the systmes requirements and design. 

# 11. Appendices
Includes installation guides, class diagrams, interface definitions, and detailed instructions tailored to the Android and MySQL setup, ensuring readiness for the project's implementation phase.

