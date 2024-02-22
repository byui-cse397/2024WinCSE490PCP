

# Software Requirements Specification
## For Community Board Forum
#### Submitted to: Brother Clements
Department of Computer Science and Engineering: Faculty<BR>
CSE 490 Special Topics<BR>
Winter 2024<BR>
February 02, 2024<BR>
Version 3 <BR>

Abstract<br>
A Software Requirements Specification Document for a Community Board<br>

Team Lead: Darcy Merilan

Team Members:
- Allan Marina,
- Andrew Swayze,
- Anita Woodford,
- Kristina Hayes,
- Nolan Jeppson,


All information in red or says test is for example only I used a final draft from my 472 and 372 class. So, we can have examples to look over.


## Version History
===============
| Date       | Version | Notes                                     |
|------------|---------|-------------------------------------------|
| 02/01/2024 | 1       | - New Document                            |
| 02/02/2024 | 2       | - Added Outline of SRS Used resources     |
|            |         |   - ChatGPT                               |
|            |         |   - Career Onboarding SRS                |
|            |         |   - CSE 472 Scrapbooking SRS             |
|            |         |   - Communicated with Mentor for changes |
|            |         |   - Added notes about information being examples |
| 02/02/2024 | 3       | - Updating Features                       |

# 1. Introduction

The Community Board Forum (hereafter referred to as "the system") is a mobile device application designed to facilitate community engagement and interaction. The system shall provide users with a platform to share information, exchange ideas, and connect with others within their local community or specific interest groups. Users shall be able to post text, images, and multimedia content to the digital bulletin board, similar to a digital bulletin board.

## 1.1. Purpose

### 1.1.1. Core Purpose
The purpose of the system is to create a dynamic and inclusive online environment where users can engage in meaningful interactions and contribute to their communities. The system serves the following core requirements:

### 1.1.2. User Account Management
The system must ensure security by implementing robust authorization, authentication, and access control mechanisms to protect user data and privacy.
### 1.1.2.1 Login
This section of the Software Requirements Specification (SRS) document outlines the detailed requirements for the user login functionality within the university community board application. The purpose of this functionality is to allow users to securely authenticate themselves and gain access to the application's features.

### 1.1.2.1.1 Scope

The user registration and email verification functionality aim to onboard new users to the platform securely and efficiently. It will support the application's overall goal of fostering community engagement and information sharing among university members.

### 1.1.2.1.2 User Needs

Users need a seamless and secure registration process that includes email verification to ensure the security of their accounts and the platform.

### 1.1.2.1.3 Assumptions and Dependencies

- It is assumed that users will provide valid and unique email addresses during the registration process.
- The email verification process depends on a reliable email service provider to send verification emails and handle responses.
- The system depends on secure storage mechanisms for user account information and verification status.

### 1.1.2.1.4 Description and Priority

User registration and email verification are high-priority components of the application, as they form the foundation for user authentication and security. It is essential to ensure a smooth and reliable registration process to onboard users effectively.

### 1.1.2.1.5 Stimulus/Response Sequences (MVC Framework)

- **Stimulus**: User fills out the registration form and submits it in the View.
- **Controller**: Action: Interprets the form input, validates user data, and communicates with the Model.
- **Model**: Processing: Creates a new user record in the database with account details and a unique verification token.
- **Response**: The Model triggers the email service to send a verification email to the user's provided email address.

### 1.1.2.1.6 Functional Requirements (MVC Specifics)

- **FR1**: The Controller shall handle incoming registration requests and validate user input data.
- **FR2**: The Model shall create a new user record in the database with account details and a unique verification token.
- **FR3**: The Model shall trigger the email service to send a verification email to the user's provided email address.
- **FR4**: The View shall display a confirmation message indicating that the registration process is successful and instruct the user to check their email for verification instructions.

### 1.1.2.1.7 User Interfaces (MVC Perspective)

- The View will include a user registration form with fields for user details such as name, email, and password.
- Upon successful registration, the View will display a message prompting the user to check their email for further instructions.

## 1.1.2.1.8 Software Interfaces (MVC Design)

- The Model will interface with the backend database to store user account information and verification status.
- The Controller will facilitate communication between the View and the Model to handle user registration requests and email verification processes.

### 1.1.2.1.9 Performance Requirements (MVC Consideration)

- The MVC architecture shall ensure swift response times for user registration and email verification processes.
- The Model and Controller components will be optimized for efficient data processing and communication.

### 1.1.2.1.10 Design Constraints (MVC Constraints)

- The user registration and email verification functionality must be scalable to accommodate a growing user base.
- The system architecture must be designed to handle potential email service provider changes or updates without impacting functionality.

### 1.1.2.1.11 Other Requirements

- **Security Requirements**: The system shall ensure that user registration and email verification processes are performed securely, with protection against injection attacks and unauthorized access to user data.
- **Maintenance Requirements**: The system shall be designed for easy maintenance and updates, including updating registration and verification algorithms and criteria.
- 

### 1.1.2.2 Registration

This section of the Software Requirements Specification (SRS) document outlines the detailed requirements for the user registration and email verification functionality within the university community board application. The purpose of this feature is to allow users to register for an account on the platform and verify their email addresses to ensure authentication and security.

### 1.1.2.2.1 Scope

The user registration and email verification functionality aim to onboard new users to the platform securely and efficiently. It will support the application's overall goal of fostering community engagement and information sharing among university members.

### 1.1.2.2.2 User Needs

Users need a seamless and secure registration process that includes email verification to ensure the security of their accounts and the platform.

### 1.1.2.2.3 Assumptions and Dependencies

- It is assumed that users will provide valid and unique email addresses during the registration process.
- The email verification process depends on a reliable email service provider to send verification emails and handle responses.
- The system depends on secure storage mechanisms for user account information and verification status.

### 1.1.2.2.4 Description and Priority

User registration and email verification are high-priority components of the application, as they form the foundation for user authentication and security. It is essential to ensure a smooth and reliable registration process to onboard users effectively.

### 1.1.2.2.5 Stimulus/Response Sequences (MVC Framework)

- **Stimulus**: User fills out the registration form and submits it in the View.
- **Controller Action**: Interprets the form input, validates user data, and communicates with the Model.
- **Model Processing**: Creates a new user record in the database with account details and a unique verification token.
- **Response**: The Model triggers the email service to send a verification email to the user's provided email address.

### 1.1.2.2.6 Functional Requirements (MVC Specifics)

- **FR1**: The Controller shall handle incoming registration requests and validate user input data.
- **FR2**: The Model shall create a new user record in the database with account details and a unique verification token.
- **FR3**: The Model shall trigger the email service to send a verification email to the user's provided email address.
- **FR4**: The View shall display a confirmation message indicating that the registration process is successful and instruct the user to check their email for verification instructions.

### 1.1.2.2.7 User Interfaces (MVC Perspective)

- The View will include a user registration form with fields for user details such as name, email, and password.
- Upon successful registration, the View will display a message prompting the user to check their email for further instructions.

### 1.1.2.2.8 Software Interfaces (MVC Design)

- The Model will interface with the backend database to store user account information and verification status.
- The Controller will facilitate communication between the View and the Model to handle user registration requests and email verification processes.

### 1.1.2.2.9 Performance Requirements (MVC Consideration)

- The MVC architecture shall ensure swift response times for user registration and email verification processes.
- The Model and Controller components will be optimized for efficient data processing and communication.

### 1.1.2.2.10 Design Constraints (MVC Constraints)

- The user registration and email verification functionality must be scalable to accommodate a growing user base.
- The system architecture must be designed to handle potential email service provider changes or updates without impacting functionality.

### 1.1.2.2.11 Other Requirements

- **Security Requirements**: The system shall ensure that user registration and email verification processes are performed securely, with protection against injection attacks and unauthorized access to user data.
- **Maintenance Requirements**: The system shall be designed for easy maintenance and updates, including updating registration and verification algorithms and criteria.

### 1.1.2.3 Account Deletion

This section of the Software Requirements Specification (SRS) document outlines the detailed requirements for the user account deletion functionality within the university community board application. The purpose of this functionality is to allow users to securely delete their accounts while preventing unauthorized deletions.

### 1.1.2.3.1 Scope

The user account deletion functionality aims to provide users with a secure method to permanently remove their accounts from the system. It will support the application's overall goal of allowing users to manage their accounts and maintain data privacy.

### 1.1.2.3.2 User Needs

Users need a straightforward and secure process to delete their accounts if they no longer wish to use the application. They expect their account deletion requests to be processed promptly and with proper authentication measures to prevent unauthorized access.

### 1.1.2.3.3 Assumptions and Dependencies

- It is assumed that users will initiate account deletion requests deliberately and to permanently remove their accounts.
- The account deletion functionality depends on robust authentication mechanisms to verify user identity and prevent unauthorized deletions.
- The system relies on secure data deletion protocols to ensure that user data is permanently removed from the system upon account deletion.

### 1.1.2.3.4 Description and Priority

User account deletion is a critical component of the application, prioritized to ensure user privacy and data security. It is essential to provide users with a seamless and secure method to delete their accounts while maintaining the integrity of the system.

### 1.1.2.3.5 Stimulus/Response Sequences (MVC Framework)

- **Stimulus**: User initiates the account deletion process in the View.
- **Controller Action**: Interprets the deletion request and communicates with the Model to process the deletion.
- **Model Processing**: Validates the deletion request and permanently removes user data from the backend database.
- **Response**: The View confirms successful account deletion and provides feedback to the user.

### 1.1.2.3.6 Functional Requirements (MVC Specifics)

- **FR1**: The Controller shall handle incoming account deletion requests and authenticate the user's identity.
- FR2: The Model shall process account deletion requests and permanently remove user data from the backend database.
- **FR3**: The View shall provide a user-friendly interface for users to initiate and confirm account deletion requests.
- **FR4**: The Controller shall enforce security measures to prevent unauthorized account deletions and ensure data integrity.

### 1.1.2.3.7 User Interfaces (MVC Perspective)

- The View will include a dedicated interface for users to initiate account deletion requests, providing clear instructions and confirmation prompts.
- Feedback messages for successful account deletion or error notifications will be displayed within the View.

### 1.1.2.3.8 Software Interfaces (MVC Design)
- The Model will interface with the backend database to retrieve and permanently remove user data upon account deletion.
- The Controller will facilitate communication between the View and the Model to handle account deletion requests and authenticate user identity.

### 1.1.2.3.9 Performance Requirements (MVC Consideration)

- The MVC architecture shall ensure swift response times for account deletion requests and data processing.
- The Model and Controller components will be optimized for efficient data deletion and authentication processes.

### 1.1.2.3.10 Design Constraints (MVC Constraints)

- The user account deletion functionality must be scalable and maintainable within the MVC framework, allowing for future enhancements and updates without compromising system performance or user experience.

### 1.1.2.3.11 Other Requirements

- **Security Requirements**: The system shall ensure that account deletion operations are performed securely, with protection against unauthorized access and data retention.
- **Maintenance Requirements**: The system shall be designed for easy maintenance and updates, including updating account deletion workflows and security 
protocols.

### 1.1.2.4. User Profile Editing

This section of the Software Requirements Specification (SRS) document outlines the detailed requirements for the user profile editing functionality within the university community board application. The purpose of this functionality is to allow users to update their profile information, including personal details and profile pictures, as well as change their password.

### 1.1.2.4.1 Scope

The user profile editing functionality aims to provide users with a convenient and intuitive interface to modify their personal information and update their profile picture. It will support the application's overall goal of enabling users to maintain accurate and up-to-date profiles.

### 1.1.2.4.2 User Needs

Users need a seamless and user-friendly method to edit their profile information, including name, contact information, and profile picture. Additionally, users should be able to change their passwords securely.

### 1.1.2.4.3 Assumptions and Dependencies

- It is assumed that users will provide valid and authorized changes to their profile information and passwords.
- The profile editing functionality depends on secure communication protocols to prevent unauthorized access to user data.
- The system relies on robust authentication mechanisms to verify user identity before allowing profile modifications.

### 1.1.2.4.4 Description and Priority

User profile editing is a high-priority component of the application, as it directly impacts user experience and engagement. It is essential to provide users with a seamless and secure method to update their profile information and manage their account settings.

### 1.1.2.4.5 Stimulus/Response Sequences (MVC Framework)

- **Stimulus**: User inputs profile changes in the View.
- **Controller Action**: Interprets the input and communicates with the Model to process profile updates.
- **Model Processing**: Validates the changes and updates the user profile data in the backend database.
- **Response**: The View confirms successful profile updates and displays any error messages if applicable.

### 1.1.2.4.6 Functional Requirements (MVC Specifics)

- **FR1**: The Controller shall handle incoming profile editing requests and validate user inputs.
- **FR2**: The Model shall process profile changes and update the user profile data in the backend database.
- **FR3**: The View shall provide a user-friendly interface for users to input and submit profile modifications.
- **FR4**: The Controller shall enforce security measures to prevent unauthorized profile edits and ensure data integrity.

### 1.1.2.4.7 User Interfaces (MVC Perspective)

- The View will include forms and fields for users to input their profile changes, including name, contact information, profile picture upload, and password modification.
- Error messages for invalid inputs or failed profile updates will be displayed within the View.

### 1.1.2.4.8 Software Interfaces (MVC Design)

- The Model will interface with the backend database to retrieve and update user profile data.
- The Controller will facilitate communication between the View and the Model to handle 

profile editing requests and processing user inputs.

### 1.1.2.4.9Performance Requirements (MVC Consideration)

- The MVC architecture shall ensure swift response times for profile editing requests and data processing.
- The Model and Controller components will be optimized for efficient data retrieval, validation, and storage.

### 1.1.2.4.10 Design Constraints (MVC Constraints)

- The user profile editing functionality must be scalable and maintainable within the MVC framework, allowing for future enhancements and updates without compromising system performance or user experience.

### 1.1.2.4.11 Other Requirements

- **Security Requirements**: The system shall ensure that profile editing operations are performed 
securely, with protection against unauthorized access and data manipulation.
- **Maintenance Requirements**: The system shall be designed for easy maintenance and updates, including updating profile editing workflows and security protocols. 

### 1.1.3. Community Posts
Users can create posts to seek or offer rides, promoting transportation assistance within the community. Posts must include attributes like start and stop destinations, description, category, timestamp, rating, and available passenger seats to enable effective communication.

### 1.1.4. Search Functionality
The system must provide users with the ability to search for specific posts based on criteria such as destination, category, and timestamp, facilitating efficient discovery of relevant information.
#### Introduction

This section of the Software Requirements Specification (SRS) document outlines the detailed requirements for the search functionality within an application. The purpose of this functionality is to allow users to efficiently locate specific posts based on various criteria such as destination, category, and timestamp.

#### 1.1.4.1 Scope

The search functionality aims to enhance user experience by providing an efficient mechanism to locate specific posts based on predefined criteria. It will support the application's overall goal of facilitating information discovery and engagement among users.

#### 1.1.4.2 User Needs

Users need to quickly and efficiently find posts relevant to their interests or information needs based on specific criteria like destination, category, and timestamp.

#### 1.1.4.3 Assumptions and Dependencies

- It is assumed that the application has a substantial and diverse set of posts to search from.
- The search functionality depends on a robust database and indexing system for quick retrieval of information.

#### 1.1.4.4 Description and Priority

The search feature is a high-priority component that allows users to find posts based on specific criteria. It is essential for enhancing user satisfaction and engagement with the application.

#### 1.1.4.5 Stimulus/Response Sequences (MVC Framework)

- **Stimulus**: User inputs search criteria in the View.
- **Controller Action**: Interprets the input and communicates with the Model.
- **Model Processing**: Queries the database and retrieves matching posts.
- **Response**: The View updates to display the search results.

#### 1.1.4.6 Functional Requirements (MVC Specifics)

- **FR1**: The Controller shall manage user inputs of one or multiple search criteria.
- **FR2**: The View shall provide real-time suggestions as users type, facilitated by the Controller.
- **FR3**: The Model shall enable sorting of search results, with the View presenting these options.
- **FR4**: The View shall dynamically update search results based on user adjustments, managed by the Controller.

#### 1.1.4.7 User Interfaces (MVC Perspective)

The View will include a prominent search bar and criteria fields, ensuring an intuitive user interface that interacts seamlessly with the Controller for processing and displaying results.

#### 1.1.4.8 Software Interfaces (MVC Design)

- The Model will interface with the backend database and search engine.
- The Controller will facilitate communication between the View and the Model for data retrieval and display.

#### 1.1.4.9 Performance Requirements (MVC Consideration)

The MVC architecture shall ensure swift response times for search queries, with the Model optimized for quick data retrieval, and the View designed for rapid rendering of results.

#### 1.1.4.10 Design Constraints (MVC Constraints)

The search functionality must be scalable and maintainable within the MVC framework, ensuring that each component can evolve to meet growing demands without compromising performance or user experience.

#### 1.1.4.11 Other Requirements

- **Security Requirements**: The system shall ensure that search operations are performed securely, with protection against injection attacks and unauthorized access to user data.
- **Maintenance Requirements**: The system shall be designed for easy maintenance and updates, including updating search algorithms and criteria.




## 1.2. Scope

### 1.2.1. Description
The system is a digital platform for community engagement, where users can create and join interest-based groups, post text, images, multimedia content, and engage in discussions. The system suggests local events, volunteer opportunities, nearby initiatives, and relevant community activities. It is user-friendly, intuitive, and integrates with social media platforms. Users can organize and personalize their content, and decorate, personalize, and highlight their content. Finally, the community forum preserves and presents community-generated content, fostering a sense of belonging and collective identity among users.

# 1.3. Product Overview

## 1.3.1. Product Perspective Example

### Figure 1.3 Component Diagram

### 1.3.1.1. System Interfaces

These system interfaces collectively facilitate the functionality and interaction within the system, providing users with a seamless and enjoyable experience while engaging with the community forum. 

#### 1.3.1.1.1. SQLite Database Interface

  A SQLite database shall be used to store and retrieve user data.

#### 1.3.1.1.2. User Data Storage Interface

  This interface facilitates the storage and retrieval of the user related information, such as user profile, post, comments, and other community-related data.

### 1.3.1.2. User Authentication Interface 

#### 1.3.1.2.1. Authentication Functionality

  The system shall provide interfaces for user authentication, including login and registration functionalities.

#### 1.3.1.2.2. Secure User Authentication

  This interface allows users to securely authenticate themselves to the system, either by logging in with existing credentials or registering for a new account.

#### 1.3.1.2.3. Graphical User Interface (GUI)

  A Graphical User Interface (GUI) shall be used for user interaction.

#### 1.3.1.2.4. Consistent GUI Appearance

  A Graphical User Interface (GUI) shall have a consistent appearance.

### 1.3.1.3. Community Forum Interface

#### 1.3.1.3.1. Forum Access Interface

  The system shall provide interfaces for accessing the community forum, including viewing, posting, and interacting with forum threads and discussions.

##### 1.3.1.3.1.1. Engaging with Forum Content

  This interface allows users to engage with the community by browsing existing forum topics, creating new posts, replying to threads, and interacting with other users' content.

### 1.3.1.4. Search Interface

  The system shall provide interfaces for searching and filtering forum content based on user-defined criteria.

#### 1.3.1.5. Enhanced Content Discovery

  This interface enables users to find specific topics, posts, or users within the community forum efficiently, enhancing the overall user experience and facilitating content discovery.

### 1.3.1.6. Notification Interface

  The system shall provide interfaces for delivering notifications to users about relevant activities, such as new posts, replies, mentions, or other interactions.

#### 1.3.1.6.1. Keeping Users Informed

  This interface keeps users informed about updates and activities within the community forum, helping them stay engaged and connected with ongoing discussions and events.

### 1.3.1.7. Social Media Interface

  The system shall provide interfaces for integrating with social media platforms, allowing users to share forum content or log in using their social media accounts.

### 1.3.1.8. Hardware Interfaces

#### 1.3.1.8.1. Device Input Interfaces

##### 1.3.1.8.1.1. Keyboard Input

  Users may use keyboards to input text when creating posts or comments.

##### 1.3.1.8.1.2. Touchscreen Interaction

  Devices with touchscreens allow users to interact with the system interface directly through touch gestures.

##### 1.3.1.8.1.3. Mouse or Trackpad Navigation

  Users on desktop or laptop computers may use a mouse or trackpad to navigate through the system interface and interact with elements.

##### 1.3.1.8.1.4. Audio Input

  Some devices allow users to input audio content, which could be relevant for creating voice-based posts or comments.

### 1.3.1.9. Device Output Interfaces

#### 1.3.1.9.1. Display Interface

  The system interface is typically displayed on screens, such as monitors, laptop displays, mobile device screens, or tablets.

#### 1.3.1.9.1.2. Haptic Feedback

  On mobile devices, haptic feedback may be used to provide tactile notifications or alerts from the system.

# 1.3.1.9. Software Interfaces

## 1.3.1.9.1. Operating Systems Interfaces

  The system interacts with different operating systems, including Windows, macOS, Linux, iOS, and Android, depending on the device used to access the platform.

## 1.3.1.9.2. Web Browser Interfaces

  For web-based versions of the system, the system interfaces with web browsers such as Google Chrome, Mozilla Firefox, Apple Safari, Microsoft Edge, or Opera.

## 1.3.1.9.3. Mobile Application Interfaces

  The system's mobile applications interact with the underlying mobile operating systems (such as iOS for Apple devices and Android for Android devices) to provide a user interface and access device-specific functionalities.

## 1.3.1.9.4. Database Management System (DBMS) Interfaces

  The system interacts with a database management system (such as SQLite, MySQL, PostgreSQL) to store and retrieve data related to user accounts, posts, comments, and other community-related information.

## 1.3.1.9.5. API Interfaces

  The system may provide APIs (Application Programming Interfaces) to allow third-party developers or services to interact with the platform programmatically. This could include APIs for authentication, posting content, retrieving data, or performing other actions.

## 1.3.1.9.6. Social Media Integration Interfaces

  If the system integrates with social media platforms (such as Facebook, Twitter, Instagram), it interacts with their APIs to enable features such as sharing posts, importing contacts, or logging in with social media accounts.

## 1.3.1.9.7. Network Communication Interfaces

  The system communicates over network protocols such as HTTP/HTTPS for web-based interactions, TCP/IP for general network communication, and possibly other protocols for specific functionalities like real-time messaging or notifications.

## 1.3.1.9.8. User Interface Libraries/Frameworks

  The user interface of the system may use software libraries or frameworks (such as React.js, Angular, Vue.js for web interfaces; UIKit for iOS apps; Android SDK for Android apps) to facilitate the development of interactive and responsive interfaces.

# 1.4 Definitions

| Term                      | Definition                                                                                                                                                  |
|---------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Authorization             | The process of determining whether a user has permission to access specific resources or perform certain actions within the application.                       |
| All posts                 | Display all posts in a roll, based on the time of the post.                                                                                                 |
| Android                   | A popular operating system, common among phone brands such as Samsung and Google.                                                                           |
| Access Control            | The mechanism for enforcing policies that dictate which users are granted access to specific resources or functionalities within the application.               |
| API                       | Application Programming Interface is the part of a program a company wants to be accessible for public use.                                                |
| Authentication            | The security clearance to access private information or privileges.                                                                                         |
| Button                    | A GUI element that triggers a software event such as page navigation or item interaction.                                                                    |
| Censor_Posts              | A function that automatically detects inappropriate posts and does not permit them to be uploaded.                                                          |
| Cloud sync                | To select manual/auto-sync and select a cloud storage provider.                                                                                              |
| Connection                | A connection provided by an Internet Service Provider that enables individual computers or other hardware components to exchange data over the public Internet. |
| Content Value             | Enables users to share information they consider valuable to their social media platform.                                                                    |
| Community Forum Application | The mobile device application designed to facilitate community engagement and interaction, allowing users to share information, exchange ideas, and connect with others within their local community or specific interest groups. |
| Crash                     | When a software application completely stops working as intended.                                                                                            |
| Credentials               | A username and password pair, allowing access to a secure account.                                                                                            |
| Digital Bulletin Board    | A virtual platform in the application where users can post text, images, multimedia content, and announcements, like a traditional bulletin board for communication and information sharing. |
| Data Collection           | A result of data received in various forms of elicitations.                                                                                                  |
| Database                  | An organized collection of structured information, typically stored electronically in a computer system.                                                   |
| Delete                    | To remove or erase an item.                                                                                                                                  |
| Display                   | To present a specific application interface.                                                                                                                 |
| Edit                      | Opens other options to modify the post, add tags, notes, backgrounds, borders, and decoration.                                                              |
| Edit_Posts                | A function allowing the user to edit their posts.                                                                                                             |
| Entry                     | User-entered data that a user creates for a specific location the user has visited.                                                                           |
| Failed                    | To be unsuccessful in achieving one's goal in the verification process.                                                                                       |
| Feasible                  | A metric that measures the possibility of achieving something.                                                                                                 |
| Filter                    | The ability to limit entries based on specified criteria.                                                                                                      |
| Filtered by Date          | Enabling a user to refine days of a month by removing specific days.                                                                                          |
| Follow / Following / Follower | In social media, a follower is someone who has subscribed to an account in which they can receive all the updates. It refers to a user who consciously chooses to see another user’s posts in their newsfeed. |
| Functionality             | A capability operation that runs on a program or application.                                                                                                 |
| Google Photos             | An application provided by Google Store that organizes a user’s images and videos.                                                                            |
| Google Store              | A retail service provided by Google.                                                                                                                          |
| Graphical User Interface (GUI) | A form of interface that focuses on user interaction with graphical components (icons, dropdowns, etc.) to allow the user to interact with electrical devices. |
| High Priority             | Great importance.                                                                                                                                            |
| Hover                     | To let one's cursor stay on a particular spot on the screen for any length of time.                                                                           |
| Icon                      | A graphic symbol that represents something like a command on the website.                                                                                     |
| Image                     | A photograph, drawing, or clipart.                                                                                                                            |
| iOS                       | A popular operating system specifically developed and maintained by Apple Inc.                                                                                 |
| Key Feature               | A critical characteristic.                                                                                                                                    |
| Key Requirement           | The established conditions, specifications, objective, or goal.                                                                                               |
| Limit_Data                | A function limiting the amount of data worth of texts a user can upload.                                                                                      |
| Linked                    | An established connection between two devices.                                                                                                                |
| Linking                   | To establish a connection between two devices.                                                                                                                |
| Geotagged Posts and Events | Posts and events within the application tagged with geographical coordinates, allowing users to view and interact with location-based content on a mapping interface. |
| Login                     | The user must provide a username and password to access the system.                                                                                            |
| Menu                      | A series of linked items that serve to foster website navigation between the different pages or sections of a site.                                            |
| Operating System          | Provides common services and basic functions to a device, such as scheduling tasks and executing applications.                                               |
| Posts                     | Messages or announcements created by users within the application to seek or offer rides, promoting transportation assistance within the community. These posts include attributes such as start and stop destinations, description, category, timestamp, rating, and available passenger seats. |
| Passenger Seats           | The number of available seats offered by users in community posts seeking or offering rides, indicating the capacity for passengers in transportation arrangements. |
| Post                      | To publish content on a public platform.                                                                                                                      |
| Print                     | To select a printing vendor to enable book options.                                                                                                            |
| Prototype                 | A preliminary model of the system.                                                                                                                            |
| Required Function         | An essential capability.                                                                                                                                      |
| Save                      | Allows saving the post in the app.                                                                                                                            |
| Select                    | To select a post to enable it to be edited.                                                                                                                   |
| Share                     | To allow sharing of the post (social media, mail, message, etc).                                                                                               |
| Share_Post                | A function that posts the user’s post and personal description to social media.                                                                                |
| Social Media Account      | An application that allows people to create and share information.                                                                                             |
| Social Media Platform     | A technology that allows people or groups of people to interact.                                                                                               |
| Span of Time              | A period of time in which something happens. Specifically, this will be used to find certain travel events.                                                   |
| Supporting Cause          | Agreeing with an idea or goal among people.                                                                                                                   |
| System                    | All components/parts of the application.                                                                                                                      |
| Search                    | The feature enabling users to search for specific posts based on criteria such as destination, category, and timestamp, facilitating efficient discovery of relevant information within the community. |
| SMS Sharing               | The option within the system to share selected posts via text messages for communication purposes, utilizing the Short Message Service (SMS) to exchange short text messages between mobile devices. |
| Tag                       | A label attached to some aspect of an entry for the purposes of searching for that entry. For instance, a tag might be a person’s name in a post.             |
| Timeline                  | A graphic representation of the passage of time from a list of events.                                                                                         |
| Tutorial / Onboarding     | A series of images and/or text that teach the user how to use the desired software.                                                                            |
| Upload                    | To transfer (data

# 2 References
2.1 Brigham Young University of Idaho CSE 430 SRS Document Submitted 2022

2.2 Brigham Young University of Idaho CSE 472 SRS Document Submitted 2022

2.3 Brigham Young University of Idaho CSE 372 SRS Document Submitted 2022

2.4 OpenAI, "ChatGPT - The AI language model by OpenAI", 2024, [Webpage](https://openai.com/chatgpt)

2.5 IEEE Standard for Software Requirements Specification (IEEE Std 830-1998)

2.6 CSE 490 Special Topics - SW Architecture

# 3 Requirements

## 3.1 Functions

### 3.1.1 User Friendly Customization 
3.1.1.1 The system shall ask user to enter password and login.<br>
3.1.1.2 The system shall allow the user to have access to view the community forum page.<br>
3.1.1.3 The system shall allow the user to add social media accounts. <br>
3.1.1.4 The system shall allow the user to view history of posts and last view items.<br>
3.1.1.5 The system shall allow user to search for post.<br>

### 3.1.2 Security & Data Collection
3.1.2.1 The system shall ask user to enter password and login.<br>
3.1.2.2 The system shall ask the user for two authentications.<br>
3.1.2.3 The user profile shall have Authorization.<br>

### 3.1.3 Community and Connectivity
3.1.3.1 The system shall allow users access to the community post page.<br>
3.1.3.2 The system shall allow users access to the search menu. <br>
3.1.3.3 The system shall allow users to post on the forum<br>
3.1.3.4 The system shall allow users to post an image inside of the post.<br>
3.1.3.5 The system shall allow previews of the post. <br>
3.1.3.6 The system shall automatically add a date and time to all posts.<br>
3.1.3.7 The system shall allow the user to view ride-share.<br>
3.1.3.8 The system shall allow the user to view passengers needed. <br>
3.1.3.9 The system shall allow the user to view start destinations listed by location. <br>
3.1.3.10 The system shall allow the user to view Stop destination <br>
3.1.3.11 The system shall allow the user to view the news feed.<br>
3.1.3.12 The system shall allow post to have Categories.<br>
3.1.3.13 The system shall allow post to have timestamps. <br>
3.1.3.14 The system shall allow post to have ratings. <br>
3.1.3.15 The system shall allow post to have passengers<br>
### 3.1.4 Content Management 
 3.1.4.1 The system shall allow the user to view a search menu.
 3.1.4.2 The system shall allow the user to retrieve and search for a post.  
 3.1.4.3 The system shall allow users to search for categories. 
 3.1.4.4 The system shall allow users to search for rides.
 3.1.4.5 The system shall allow users to search for people.

## 3.2 Performance Requirements

### 3.2.1 Login
3.2.1.1 The user shall be able to toggle between screens. 

### 3.2.2 System Background
3.2.2.1 The system shall run in the background 

### 3.2.3 Interface
3.2.3.1 The system shall allow the use of the home button and freeze the state in the app. 
3.2.3.2 The system shall allow the user to navigate between screens without losing the content in the app. 

### 3.2.4 Storage
3.2.4.1 The system shall store the characters and dates in the cache to allow the user to return to the app. 

## 3.3 Usability Requirements

### 3.3.1 Onboarding Tutorial
3.3.1.1 After initially logging into the system, the user shall see a tutorial. 

### 3.3.2 Post Editing

### 3.3.3 Social Media
3.3.3.1 The system shall be able to link to a user’s social media accounts such as Facebook and Instagram. 

### 3.3.4 Sharing
3.3.4.1 The system shall have the ability to share post by MMS. 

### 3.3.5 Organization
3.3.5.1 When using List View mode, posts shall be automatically organized by date. 

## 3.4 Interface Requirements

### 3.4.1 Menu
3.4.1.1 The system shall provide a menu to post 
3.4.1.2 The system shall display a menu on the screen with options to post an to social media.  
3.4.1.3 The menu items for social media are 

### 3.4.2 System
  3.4.2.1 The system shall use the Operating System’s API 
  3.4.2.2 The system shall allow the user to manually or automatically tag the location 

### 3.4.3 Profile Page
  3.4.3.1 The system shall give access through the menu to the user’s Profile Page  
  3.4.3.2 Within the user’s Profile Page, the user shall be able to navigate to Privacy Settings  
  3.4.3.3 Within the user’s Profile Page, the user shall be able to navigate Personal Identifying information  
  3.4.3.4 Test  

## 3.5 Menu Template

### 3.5.1 The system has a menu
  3.5.2 Test
    3.5.2.1 Test
  3.5.3 The system shall allow the user to remove a post. (L_P)
    3.5.3.1 The Menu Options allow the user to delete the post on a more options menu or a separate delete button on the corner of the post. 
    3.5.3.2 The post Menu Options shall allow the user 
    3.5.3.2.1 The Template Menu Options allow the user to upload post  using a button on the system’s main menu, allowing quick access to post templates. (H_P)

## 3.6 Menu Social Media/Sharing
  3.6.1 
      3.6.1.1 
      3.6.1.2 

## 3.7 Logical Database Requirements

### 3.7.1 Each post hall have a date associated with it. (R) 
      3.7.1.1 
      3.7.1.2

# 4 Verification

## 4.1 Functions

### 4.1.1 User Friendly Customization
4.1.1.1 If the system allows the user to enter password and login, it passes verificatiootherwise, it fails verification.<br>
4.1.1.2 If the system allows access to view the community forum page it passes verificatiootherwise, it fails verification.<br>
4.1.1.3 If the system allows the user to add social media accounts it passes verificatiootherwise, it fails verification.<br>
4.1.1.4 
4.1.1.5 If the system allows the user to view history of posts and last view items it passverification; otherwise, it fails verification.<br>
4.1.1.6 If the system allows the user to search for post it passes verification; otherwise, it faiverification.<br>

### 4.1.2 Security & Data Collection
4.1.2.1 If the system asks the user to enter password and login it passes verification; otherwi
it fails verification.<br>
4.1.2.2 If the system asks the user for two authentications it passes verification; otherwise,
fails verification.<br>
4.1.2.3 If the system gives the user authorization it passes verification; otherwise, it fa
verificati<br>

### 4.1.3 Communication and Connectivity
4.1.3.1 If the system allows users access to the community post page it passes verification; otherwise, it fails verification.<br>
4.1.3.2 If the system allows users access to the search menu it passes verification; otherwise, it fails verification.<br>
4.1.3.3 If the system allows users to post on the forum it passes verification; otherwise, it fails verification.<br>
4.1.3.4 If the system allows users to post an image inside of the post it passes verification; otherwise, it fails verification.<br>
4.1.3.5 If the system allows previews of the post, it passes verification; otherwise, it fails verification.<br>
4.1.3.6 If the system automatically adds a date and time to all posts, it passes verification; otherwise, it fails verification.<br>
4.1.3.7 If the system allows the user to view ride-share it passes verification; otherwise, it fails verification.<br>
4.1.3.8 If the system allows the user to view passengers needed it passes verification; otherwise, it fails verification.<br>
4.1.3.9 If the system allows the user to view start destinations listed by location it passes verification; otherwise, it fails verification.<br>
4.1.3.10 If the system allows the user to view Stop destination it passes verification; otherwise<br>


# 4 Verification

## 4.1.4 Content Management
  If the system provides content management functionalities, it passes verification; otherwise, it fails verification.

## 4.2 Performance Requirements

### 4.2.1 Logon
  If the user can toggle between screens during login, it passes verification; otherwise, it fails verification. 

### 4.2.2 System Background
  If the system runs in the background as specified, it passes verification; otherwise, it fails verification.

### 4.2.3 Interface
  If the system interface meets the specified requirements, it passes verification; otherwise, it fails verification.

### 4.2.4 Storage
  If the system stores characters and dates in the cache as specified, it passes verification; otherwise, it fails verification.

## 4.3 Usability Requirements

### 4.3.1 Onboarding Tutorial
  If the onboarding tutorial functionality is implemented as specified, it passes verification; otherwise, it fails verification.

### 4.3.2 Post
  If the system provides necessary functionalities for creating, editing, and managing posts, it passes verification; otherwise, it fails verification.

### 4.3.3 Social Media
  If the system allows users to link their social media accounts and share posts, it passes verification; otherwise, it fails verification.

### 4.3.4 Sharing
  If the system enables users to share posts via various methods such as MMS or social media platforms, it passes verification; otherwise, it fails verification.

### 4.3.5 Organization
  If the system provides features for organizing posts by date, category, or other criteria, it passes verification; otherwise, it fails verification.

### 4.3.6 Recommendations
  If the system provides relevant user recommendations from user interactions such as posts, or other relevant interactions it passes verification; otherwise, it fails verification.

## 4.4 Interface Requirements

### 4.4.1 Menu
  If the system provides a menu to post, it passes verification; otherwise, it fails verification.<br>
  If the system provides a pop-up menu with options to post, it passes verification; otherwise, it fails verification.<br>

### 4.4.2 System
  If the system utilizes the Operating System's map API for directions and pin locations, it passes verification; otherwise, it fails verification.<br>

### 4.4.3 Profile Page
  If the system allows access to the profile page as specified, it passes verification; otherwise, it fails verification.<br>
  If the system allows navigation to various sections of the profile page as specified, it passes verification; otherwise, it fails verification.<br>

## 4.5 Menu Search
  If the system provides a menu for search functionality, it passes verification; otherwise, it fails verification.<br>
  If the system provides a way to display search results, it passes verification; otherwise, it fails verification.<br>

## 4.6 Menu Social Media/Sharing
  If the system allows users to share posts on social media platforms as specified, it passes verification; otherwise, it fails verification.

## 4.7 Logical Database Requirements

  If the logical database meets the specified requirements for data organization, storage, and retrieval, it passes verification; otherwise, it fails verification.

## 5 Appendices

### 5.1 Acronyms and Abbreviations

| Acronym / Abbreviation | Full Form                                        |
|-------------------------|--------------------------------------------------|
| API                     | Application Programming Interface                |
| CPU                     | Central Processing Unit                          |
| GUI                     | Graphical User Interface                         |
| HTTP                    | Hypertext Transfer Protocol                      |
| iOS                     | iPhone Operating System                          |
| MMS                     | Multimedia Messaging Service                      |
| N/A                     | Not Applicable                                   |
| NoSQL                   | Non-SQL (Structured Query Language) database    |
| SMS                     | Simple Messaging Service                         |
| SQL                     | Structured Query Language                        |
| SRS                     | Software/Systems Requirement Specification       |
| TCP/IP                  | Transmission Control Protocol/Internet Protocol  |


## 5.2 Priority Table

| Priority | Description                      |
|----------|----------------------------------|
| H_P      | High Priority                   |
| M_P      | Medium Priority                 |
| L_P      | Low Priority                    |
| N/A      | Not Applicable                  |

