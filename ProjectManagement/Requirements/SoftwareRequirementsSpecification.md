# Community Board Forum

Software Requirements SpecificationSubmitted to: Brother Clements

Department of Computer Science and Engineering: Faculty

CSE 490 Special Topics

Winter 2024

February 02, 2024

Version 3


Abstract

A Software Requirements Specification Document for a Community Board


Team Lead: Darcy Merilan

Team Members:
Allan Marina,
Andrew Swayze,
Anita Woodford,
Nolan Jeppson,
Kristina Hayes,

All information in red or says test is for example only I used a final draft from my 472 and 372 class. So, we can have examples to look over.


Version History
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

### 1.1.3. Community Posts
Users can create posts to seek or offer rides, promoting transportation assistance within the community. Posts must include attributes like start and stop destinations, description, category, timestamp, rating, and available passenger seats to enable effective communication.

### 1.1.4. Search Functionality
The system must provide users with the ability to search for specific posts based on criteria such as destination, category, and timestamp, facilitating efficient discovery of relevant information.

## 1.2. Scope

### 1.2.1. Description
The system is a digital platform for community engagement, where users can create and join interest-based groups, post text, images, multimedia content, and engage in discussions. The system suggests local events, volunteer opportunities, nearby initiatives, and relevant community activities. It is user-friendly, intuitive, and integrates with social media platforms. Users can organize and personalize their content, and decorate, personalize, and highlight their content. Finally, the community forum preserves and presents community-generated content, fostering a sense of belonging and collective identity among users.

# 1.3. Product Overview

## 1.3.1. Product Perspective Example

### Figure 1.3 Component Diagram

### 1.3.1.1. System Interfaces

These system interfaces collectively facilitate the functionality and interaction within the system, providing users with a seamless and enjoyable experience while engaging with the community forum. 

#### 1.3.1.1.1. SQLite Database Interface

- A SQLite database shall be used to store and retrieve user data.

#### 1.3.1.1.2. User Data Storage Interface

- This interface facilitates the storage and retrieval of the user related information, such as user profile, post, comments, and other community-related data.

### 1.3.1.2. User Authentication Interface 

#### 1.3.1.2.1. Authentication Functionality

- The system shall provide interfaces for user authentication, including login and registration functionalities.

#### 1.3.1.2.2. Secure User Authentication

- This interface allows users to securely authenticate themselves to the system, either by logging in with existing credentials or registering for a new account.

#### 1.3.1.2.3. Graphical User Interface (GUI)

- A Graphical User Interface (GUI) shall be used for user interaction.

#### 1.3.1.2.4. Consistent GUI Appearance

- A Graphical User Interface (GUI) shall have a consistent appearance.

### 1.3.1.3. Community Forum Interface

#### 1.3.1.3.1. Forum Access Interface

- The system shall provide interfaces for accessing the community forum, including viewing, posting, and interacting with forum threads and discussions.

#### 1.3.1.3.1.1. Engaging with Forum Content

- This interface allows users to engage with the community by browsing existing forum topics, creating new posts, replying to threads, and interacting with other users' content.

### 1.3.1.4. Search Interface

- The system shall provide interfaces for searching and filtering forum content based on user-defined criteria.

#### 1.3.1.5. Enhanced Content Discovery

- This interface enables users to find specific topics, posts, or users within the community forum efficiently, enhancing the overall user experience and facilitating content discovery.

### 1.3.1.6. Notification Interface

- The system shall provide interfaces for delivering notifications to users about relevant activities, such as new posts, replies, mentions, or other interactions.

#### 1.3.1.6.1. Keeping Users Informed

- This interface keeps users informed about updates and activities within the community forum, helping them stay engaged and connected with ongoing discussions and events.

### 1.3.1.7. Social Media Interface

- The system shall provide interfaces for integrating with social media platforms, allowing users to share forum content or log in using their social media accounts.

### 1.3.1.8. Hardware Interfaces

#### 1.3.1.8.1. Device Input Interfaces

##### 1.3.1.8.1.1. Keyboard Input

- Users may use keyboards to input text when creating posts or comments.

##### 1.3.1.8.1.2. Touchscreen Interaction

- Devices with touchscreens allow users to interact with the system interface directly through touch gestures.

##### 1.3.1.8.1.3. Mouse or Trackpad Navigation

- Users on desktop or laptop computers may use a mouse or trackpad to navigate through the system interface and interact with elements.

##### 1.3.1.8.1.4. Audio Input

- Some devices allow users to input audio content, which could be relevant for creating voice-based posts or comments.

### 1.3.1.9. Device Output Interfaces

#### 1.3.1.9.1. Display Interface

- The system interface is typically displayed on screens, such as monitors, laptop displays, mobile device screens, or tablets.

#### 1.3.1.9.1.2. Haptic Feedback

- On mobile devices, haptic feedback may be used to provide tactile notifications or alerts from the system.

# 1.3.1.9. Software Interfaces

## 1.3.1.9.1. Operating Systems Interfaces

- The system interacts with different operating systems, including Windows, macOS, Linux, iOS, and Android, depending on the device used to access the platform.

## 1.3.1.9.2. Web Browser Interfaces

- For web-based versions of the system, the system interfaces with web browsers such as Google Chrome, Mozilla Firefox, Apple Safari, Microsoft Edge, or Opera.

## 1.3.1.9.3. Mobile Application Interfaces

- The system's mobile applications interact with the underlying mobile operating systems (such as iOS for Apple devices and Android for Android devices) to provide a user interface and access device-specific functionalities.

## 1.3.1.9.4. Database Management System (DBMS) Interfaces

- The system interacts with a database management system (such as SQLite, MySQL, PostgreSQL) to store and retrieve data related to user accounts, posts, comments, and other community-related information.

## 1.3.1.9.5. API Interfaces

- The system may provide APIs (Application Programming Interfaces) to allow third-party developers or services to interact with the platform programmatically. This could include APIs for authentication, posting content, retrieving data, or performing other actions.

## 1.3.1.9.6. Social Media Integration Interfaces

- If the system integrates with social media platforms (such as Facebook, Twitter, Instagram), it interacts with their APIs to enable features such as sharing posts, importing contacts, or logging in with social media accounts.

## 1.3.1.9.7. Network Communication Interfaces

- The system communicates over network protocols such as HTTP/HTTPS for web-based interactions, TCP/IP for general network communication, and possibly other protocols for specific functionalities like real-time messaging or notifications.

## 1.3.1.9.8. User Interface Libraries/Frameworks

- The user interface of the system may use software libraries or frameworks (such as React.js, Angular, Vue.js for web interfaces; UIKit for iOS apps; Android SDK for Android apps) to facilitate the development of interactive and responsive interfaces.

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
    3.1.1.1 The system shall ask user to enter password and login.
    3.1.1.2 The system shall allow the user to have access to view the community forum page.
    3.1.1.3 The system shall allow the user to add social media accounts. 
    3.1.1.4 The system shall allow the user to view history of posts and last view items.
    3.1.1.5 The system shall allow user to search for post.

### 3.1.2 Security & Data Collection
    3.1.2.1 The system shall ask user to enter password and login.
    3.1.2.2 The system shall ask the user for two authentications.
    3.1.2.3 The user profile shall have Authorization.

### 3.1.3 Community and Connectivity
    3.1.3.1 The system shall allow users access to the community post page.
    3.1.3.2 The system shall allow users access to the search menu. 
    3.1.3.3 The system shall allow users to post on the forum
    3.1.3.4 The system shall allow users to post an image inside of the post.
    3.1.3.5 The system shall allow previews of the post. 
    3.1.3.6 The system shall automatically add a date and time to all posts.
    3.1.3.7 The system shall allow the user to view ride-share.
    3.1.3.8 The system shall allow the user to view passengers needed. 
    3.1.3.9 The system shall allow the user to view start destinations listed by location. 
    3.1.3.10 The system shall allow the user to view Stop destination 
    3.1.3.11 The system shall allow the user to view the news feed.
    3.1.3.12 The system shall allow post to have Categories.
    3.1.3.13 The system shall allow post to have timestamps. 
    3.1.3.14 The system shall allow post to have ratings. 
    3.1.3.15 The system shall allow post to have passengers

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
    3.2.3.2 The system shall allow the user to navigate between screens without losing the content in the 
            app. 

### 3.2.4 Storage
    3.2.4.1 The system shall store the characters and dates in the cache to allow the user to return to 
            the app. 

## 3.3 Usability Requirements

### 3.3.1 Onboarding Tutorial
- 3.3.1.1 After initially logging into the system, the user shall see a tutorial. 

### 3.3.2 Post Editing
- 3.3.2.1 Test
- 3.3.2.2 Test

### 3.3.3 Social Media
- 3.3.3.1 The system shall be able to link to a user’s social media accounts such as Facebook and Instagram. 

### 3.3.4 Sharing
- 3.3.4.1 The system shall have the ability to share post by MMS. 

### 3.3.5 Organization
- 3.3.5.1 When using List View mode, posts shall be automatically organized by date. 

## 3.4 Interface Requirements

### 3.4.1 Menu
- 3.4.1.1 The system shall provide a menu to post 
- 3.4.1.2 The system shall display a menu on the screen with options to post an to social media.  
- 3.4.1.3 The menu items for social media are 
  - 3.4.1.3.1 Twitter 
  - 3.4.1.3.2 Snapchat 
  - 3.4.1.3.3 Facebook (M_P I)
  - 3.4.1.3.4 Text Message (M_P I)
    - 3.4.1.3.4.1 Public (H_P)
    - 3.4.1.3.4.2 Private (H_P)
    - 3.4.1.3.4.3 Password from the login of the system, as well as a code, is sent to associated links (phone # or email), to incorporate a two-step verification of the user. (M_P)

### 3.4.2 System
- 3.4.2.1 The system shall use the Operating System’s API 
- 3.4.2.2 The system shall allow the user to manually or automatically tag the location 

### 3.4.3 Profile Page
- 3.4.3.1 The system shall give access through the menu to the user’s Profile Page 
- 3.4.3.2 Within the user’s Profile Page, the user shall be able to navigate to Privacy Settings 
- 3.4.3.3 Within the user’s Profile Page, the user shall be able to navigate Personal Identifying information 
- 3.4.3.4 Test

## 3.5 Menu Template

### 3.5.1 The system has a menu
- 3.5.2 Test
  - 3.5.2.1 Test
- 3.5.3 The system shall allow the user to remove a post. (L_P)
  - 3.5.3.1 The Menu Options allow the user to delete the post on a more options menu or a separate delete button on the corner of the post. 
  - 3.5.3.2 The post Menu Options shall allow the user 
    - 3.5.3.2.1 The Template Menu Options allow the user to upload post  using a button on the system’s main menu, allowing quick access to post templates. (H_P)

## 3.6 Menu Social Media/Sharing
- 3.6.1 The user shall be able to tap on a social media icon to post the adventure/entry to other top social media platforms. (M_P)
  - 3.6.1.1 The user shall be able to post entries to social media only after successfully logging into the system and linking their social media accounts to the system. (H_P)
  - 3.6.1.2 The social media accounts accessible through the system include Facebook, Instagram, Pinterest, and Twitter. (M_P)

## 3.7 Logical Database Requirements

### 3.7.1 Each post hall have a date associated with it. (R) 
- 3.7.1.1 Each post shall have a default date when added to the system. (R)
- 3.7.1.2 The default date shall be the date that the post is imported into the system. (R)

# 4 Verification

## 4.1 Functions

### 4.1.1 User Friendly Customization
- 4.1.1.1 If the system allows the user to enter password and login, it passes verification; otherwise, it fails verification.
- 4.1.1.2 If the system allows access to view the community forum page it passes verification; otherwise, it fails verification.
- 4.1.1.3 If the system allows the user to add social media accounts it passes verification; otherwise, it fails verification.
- 4.1.1.4 
- 4.1.1.5 If the system allows the user to view history of posts and last view items it passes verification; otherwise, it fails verification.
- 4.1.1.6 If the system allows the user to search for post it passes verification; otherwise, it fails verification.

### 4.1.2 Security & Data Collection
- 4.1.2.1 If the system asks the user to enter password and login it passes verification; otherwise, it fails verification.
- 4.1.2.2 If the system asks the user for two authentications it passes verification; otherwise, it fails verification.
- 4.1.2.3 If the system gives the user authorization it passes verification; otherwise, it fails verification.

### 4.1.3 Communication and Connectivity
- 4.1.3.1 If the system allows users access to the community post page it passes verification; otherwise, it fails verification.
- 4.1.3.2 If the system allows users access to the search menu it passes verification; otherwise, it fails verification.
- 4.1.3.3 If the system allows users to post on the forum it passes verification; otherwise, it fails verification.
- 4.1.3.4 If the system allows users to post an image inside of the post it passes verification; otherwise, it fails verification.
- 4.1.3.5 If the system allows previews of the post, it passes verification; otherwise, it fails verification.
- 4.1.3.6 If the system automatically adds a date and time to all posts, it passes verification; otherwise, it fails verification.
- 4.1.3.7 If the system allows the user to view ride-share it passes verification; otherwise, it fails verification.
- 4.1.3.8 If the system allows the user to view passengers needed it passes verification; otherwise, it fails verification.
- 4.1.3.9 If the system allows the user to view start destinations listed by location it passes verification; otherwise, it fails verification.
- 4.1.3.10 If the system allows the user to view Stop destination it passes verification; otherwise


# 4 Verification

## 4.1.4 Content Management
- If the system provides content management functionalities, it passes verification; otherwise, it fails verification.

## 4.2 Performance Requirements

### 4.2.1 Logon
- If the user can toggle between screens during login, it passes verification; otherwise, it fails verification. 

### 4.2.2 System Background
- If the system runs in the background as specified, it passes verification; otherwise, it fails verification.

### 4.2.3 Interface
- If the system interface meets the specified requirements, it passes verification; otherwise, it fails verification.

### 4.2.4 Storage
- If the system stores characters and dates in the cache as specified, it passes verification; otherwise, it fails verification.

## 4.3 Usability Requirements

### 4.3.1 Onboarding Tutorial
- If the onboarding tutorial functionality is implemented as specified, it passes verification; otherwise, it fails verification.

### 4.3.2 Post
- If the system provides necessary functionalities for creating, editing, and managing posts, it passes verification; otherwise, it fails verification.

### 4.3.3 Social Media
- If the system allows users to link their social media accounts and share posts, it passes verification; otherwise, it fails verification.

### 4.3.4 Sharing
- If the system enables users to share posts via various methods such as MMS or social media platforms, it passes verification; otherwise, it fails verification.

### 4.3.5 Organization
- If the system provides features for organizing posts by date, category, or other criteria, it passes verification; otherwise, it fails verification.

## 4.4 Interface Requirements

### 4.4.1 Menu
- If the system provides a menu to post, it passes verification; otherwise, it fails verification.
- If the system provides a pop-up menu with options to post, it passes verification; otherwise, it fails verification.

### 4.4.2 System
- If the system utilizes the Operating System's map API for directions and pin locations, it passes verification; otherwise, it fails verification.

### 4.4.3 Profile Page
- If the system allows access to the profile page as specified, it passes verification; otherwise, it fails verification.
- If the system allows navigation to various sections of the profile page as specified, it passes verification; otherwise, it fails verification.

## 4.5 Menu Search
- If the system provides a menu for search functionality, it passes verification; otherwise, it fails verification.
- If the system provides a way to display search results, it passes verification; otherwise, it fails verification.

## 4.6 Menu Social Media/Sharing
- If the system allows users to share posts on social media platforms as specified, it passes verification; otherwise, it fails verification.

## 4.7 Logical Database Requirements

- If the logical database meets the specified requirements for data organization, storage, and retrieval, it passes verification; otherwise, it fails verification.

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

