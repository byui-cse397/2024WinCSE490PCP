# Community Board Application
SRS Document – Version 1 

# All information on here is for example only I used a final draft from my 472 and 372 class. So, we can have examples to look over.  

Title: Software Requirements Specification
Submitted to: Brother Clements
Department of Computer Science and Engineering: Faculty
CSE 490 Special Topics
Winter 2024
February 02, 2024

Team Lead: Darcy Merilan
Team Members:
Allan Marina
Andrew Swayze
Anita Woodford
Nolan Jeppson
Kristina Hayes



# Version History

| **Date** | **Version** | **Notes** |
| --- | --- | --- |
|
 |
 |


# Table of Contents

[Version History 1](#_Toc157752537)
[Table of Contents 2](#_Toc157752538)
[1.Introduction 3](#_Toc157752539)
[1.1.Purpose 3](#_Toc157752540)
[1.2.Scope 3](#_Toc157752541)
[1.3.Product Overview 4](#_Toc157752542)
[1.3.1.Product Perspective Example 4](#_Toc157752543)
[1.3.1.1.System Interfaces 4](#_Toc157752544)
[1.3.1.2.User Interfaces 4](#_Toc157752545)
[1.3.1.3.Hardware Interfaces 5](#_Toc157752546)
[1.3.1.4.Software Interfaces 5](#_Toc157752547)
[1.3.1.5.Communications Interfaces 5](#_Toc157752548)
[1.3.1.6.Memory 5](#_Toc157752549)
[1.3.1.7.Operations 5](#_Toc157752550)
[1.3.1.8.Site Adaptation Requirements 5](#_Toc157752551)
[1.3.1.9.Interfaces with Services 5](#_Toc157752552)
[1.3.2.Product Functions 5](#_Toc157752553)
[1.3.3.User Characteristics 5](#_Toc157752554)
[1.3.4.Limitations 6](#_Toc157752555)
[1.4.Definitions 9](#_Toc157752556)
[2.References 17](#_Toc157752557)
[3.Requirements 18](#_Toc157752558)
[3.1.Functions 18](#_Toc157752559)
[3.1.1.Community Forum 18](#_Toc157752560)
[3.1.2.Login / Registration 18](#_Toc157752561)
[3.1.3.User Profile / Accounts 18](#_Toc157752562)
[3.1.4.Post / Commenting 18](#_Toc157752563)
[3.1.5.Search 19](#_Toc157752564)
[3.1.6.Messages 19](#_Toc157752565)
[3.1.7.Local Business Directory 19](#_Toc157752566)
[3.1.8.Timeline / Calendar 19](#_Toc157752567)
[3.1.9.Post / Comments 19](#_Toc157752568)
[3.2.Performance Requirements 20](#_Toc157752569)
[3.3.Usability Requirements 20](#_Toc157752570)
[3.4.Interface Requirements 21](#_Toc157752571)
[3.5.Menu Template 22](#_Toc157752572)
[3.6.Menu Social Media/Sharing 23](#_Toc157752573)
[3.7.Logical Database Requirements 23](#_Toc157752574)
[3.8.Design Constraints 23](#_Toc157752575)
[3.9.Software System Attributes 23](#_Toc157752576)
[3.10.Supporting Information 23](#_Toc157752577)
[4.Verification 24](#_Toc157752578)
[4.1.Functions 24](#_Toc157752579)
[4.2.Performance Requirements 26](#_Toc157752580)
[4.3.Usability Requirements 27](#_Toc157752581)
[4.4.Interface Requirements 29](#_Toc157752582)
[4.5.Menu Template 30](#_Toc157752583)
[4.6.Menu Social Media/Sharing 31](#_Toc157752584)
[4.7.Logical Database Requirements 31](#_Toc157752585)
[4.8.Design Constraints 31](#_Toc157752586)
[4.9.Software System Attributes 31](#_Toc157752587)
[4.10.Supporting Information 31](#_Toc157752588)
[5.Appendices 32](#_Toc157752589)
[5.1.Assumptions and Dependencies 32](#_Toc157752590)
[5.2.Acronyms and Abbreviations 32](#_Toc157752591)
[5.3.Priority Table 33](#_Toc157752592)

.
# 1. Introduction
The "Community Forum Application " (hereafter referred to as "the system") is a mobile device application designed to facilitate community engagement and interaction. The system shall provide users with a platform to share information, exchange ideas, and connect with others within their local community or specific interest groups. Users shall be able to post text, images, and multimedia content to the community board, similar to a digital bulletin board.
## 1.1 Purpose
1.1.1 	The purpose of the "Community Forum Application" is to create a dynamic and inclusive online environment where users can engage in meaningful interactions and contribute to their communities. The system serves the following core requirements.  Aw added
1.1.2.	User Account Management: The system must ensure security by implementing robust authorization, authentication, and access control mechanisms to protect user data and privacy. Aw added 
1.1.3.	Community Posts: Users can create posts to seek or offer rides, promoting transportation assistance within the community. Posts must include attributes like start and stop destinations, description, category, timestamp, rating, and available passenger seats to enable effective communication. 
1.1.4.	Search Functionality: The system must provide users with the ability to search for specific posts based on criteria such as destination, category, and timestamp, facilitating efficient discovery of relevant information.

## 1.2.	Scope
1.2.1.	The "system is a digital platform for community engagement, where users can create and join interest-based groups, post text, images, multimedia content, and engage in discussions. The system suggests local events, volunteer opportunities, nearby initiatives and relevant community activities. It is user-friendly, intuitive, and integrates with social media platforms. Users can organize and personalize their content, and decorate, personalize, and highlight their content. Finally, the community forum preserves and presents community-generated content, fostering a sense of belonging and collective identity among users. Aw added

## Product Overview

    1.
### Product Perspective Example

![](RackMultipart20240202-1-wrw5fm_html_b3976cc290226705.png)

Figure 1.3 Component Diagram

      1.
#### System Interfaces Example 
        1. A NoSQL database shall be used to store and retrieve user data.
        2. Google and/or Apple Maps API shall provide reliable data to the user.
        3. Android and iOS file systems, printing, and cloud services shall be used to the best of their ability in their respective operating system environments to provide the user with a quality user experience.
      2.
#### User Interfaces Example 

        1. A Graphical User Interface (GUI) shall be used for user interaction.
        2. A Graphical User Interface (GUI) shall have a consistent appearance.
        3. A GUI shall help the user understand how to upload an post, edit an post, share an post, and add map objects.
      3.
#### Hardware Interfaces Example 

        1. Test
      4.
#### Software Interfaces Example 

        1. Test
        2. Test
        3. Test
        4. Test
        5. Test
      5.
#### Communications Interfaces Example 

        1. Test
      6.
#### Memory Example 

        1. Test
      7.
#### Operations Example 

        1. Test
      8.
#### Site Adaptation Requirements Example 

        1. Test
      9.
#### Interfaces with Services Example 

        1. Test
    1.
### Product Functions Example 

        1. Test
        2. Test
    2.
### User Characteristics Example 

        1. Test
        2. Test
        3. Test
        4. Test

### Limitations Example 
      1. Regulatory requirements and policies
        1. N/A
      2. Hardware limitations
        1. The client devices supported shall be Android or iOS smartphones and tablets.
        2. The device's touchscreen shall be used to register user input.
        3. The device's storage shall store the app's related information.
 
        4. Test
      3. Interfaces to other applications
        1. Android and iOS file systems, printing, and cloud services shall be used to the best of their ability in their respective operating system environments to provide the user with a quality user experience.
        2. External websites shall be accessed through their API to fulfill the functionality of the required features in the system.

     
 
      4. Signal handshake protocols
        1. TCP/IP and HTTP protocols shall be used to access email, SMS protocols, and social media accounts securely.
 
  
## 1.4 Definitions
|              Term              |                                                                                                                                            Definition                                                                                                                                            |   |
|:------------------------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|---|
|         Authorization          | The process of determining whether a user has permission to access specific resources or perform certain actions within the application, typically based on user roles and permissions.                                                                                                          |   |
| All posts                      | Display all posts in a roll, based on the time of the post.                                                                                                                                                                                                                                      |   |
| Android                        | A popular operating system, or the software that supports a computer’s basic functions, that is common among phone brands such as Samsung and Google.                                                                                                                                            |   |
| Access Control                 | The mechanism for enforcing policies that dictate which users are granted access to specific resources or functionalities within the application, ensuring security and data privacy.                                                                                                            |   |
| API                            | Application Programming Interface is the part of a program a company wants to be accessible for public use.                                                                                                                                                                                      |   |
| Authentication                 | The security clearance to access private information or privileges.                                                                                                                                                                                                                              |   |
| Button                         | A GUI element that triggers a software event such as page navigation or item interaction.                                                                                                                                                                                                        |   |
| Categorize                     | To group according to specified criteria, such as geographic area.                                                                                                                                                                                                                               |   |
| Censor_Posts                   | A function that automatically detects inappropriate posts and does not permit them to be uploaded.                                                                                                                                                                                               |   |
| Cloud sync                     | To select manual/auto-sync and select a cloud storage provider.                                                                                                                                                                                                                                  |   |
| Connection                     | A connection provided by an Internet Service Provider that enables individual computers or other hardware components, either individually or registered within a Local Area Network, to exchange data over the public Internet [4].                                                              |   |
| Content Value                  | Enables users to share information they consider of value to their social media platform.                                                                                                                                                                                                        |   |
| CPU Power                      | How much processing ability a device has for carrying out functions. Many modern mobile devices have the CPU power to simultaneously carry out many complex functions. The functionality includes running several programs in the background.                                                    |   |
| Crash                          | When a software application completely stops working as intended. Usually results in a frozen screen/device or an automatic exit from the application.                                                                                                                                           |   |
| Credentials                    | A username and password pair, allowing access to a secure account.                                                                                                                                                                                                                               |   |
| Data Collection                | A result of data received as varied forms of elicitations.                                                                                                                                                                                                                                       |   |
| Database                       | An organized collection of structured information, or data, typically stored electronically in a computer system.                                                                                                                                                                                |   |
| Delete                         | To remove or erase an item.                                                                                                                                                                                                                                                                      |   |
| Display                        | To present a specific application interface.                                                                                                                                                                                                                                                     |   |
| Edit                           | Opens other options to modify the post, add tags, notes, backgrounds, borders, and decoration.                                                                                                                                                                                                   |   |
| Edit_Posts                     | A function allowing the user to edit their posts.                                                                                                                                                                                                                                                |   |
| Entry                          | User entered data that that a user creates for a specific location the user has visited.                                                                                                                                                                                                         |   |
| Entry Tags                     | A mention of an individual in an entry.                                                                                                                                                                                                                                                          |   |
| Failed                         | To be unsuccessful in achieving one's goal in the verification process.                                                                                                                                                                                                                          |   |
| Feasible                       | A metric that measures the possibility of achieving something.                                                                                                                                                                                                                                   |   |
| Filter                         | The ability to limit entries based on specified criteria.                                                                                                                                                                                                                                        |   |
| Filtered by Date               | Enabling a user to refine days of a month by removing specific days.                                                                                                                                                                                                                             |   |
| Follow / Following / Follower  | In social media, a follower is someone who has subscribed to an account in which they can receive all the updates. It refers to a user who consciously chooses to see another user’s posts in their newsfeed [6].                                                                                |   |
| FPS                            | Frames per second. A measurement of how many image frames a screen displays every second. Higher fps means smoother motions on the screen.                                                                                                                                                       |   |
| Functionality                  | A capability operation that runs on a program or application.                                                                                                                                                                                                                                    |   |
| Google Photos                  | An application provided by Google Store that organizes a user’s images and videos.                                                                                                                                                                                                               |   |
| Google Store                   | A retail service provided by Google.                                                                                                                                                                                                                                                             |   |
| Graphical User Interface (GUI) | A form of interface that focuses on user interaction with graphical components (icons, dropdowns, etc.) to allow the user to interact with electrical devices.                                                                                                                                   |   |
| High Priority                  | Great importance                                                                                                                                                                                                                                                                                 |   |
| Hover                          | To let one's cursor stay on a particular spot on the screen for any length of time.                                                                                                                                                                                                              |   |
| Icon                           | A graphic symbol that represents something like a command on the website.                                                                                                                                                                                                                        |   |
| Image                          | A photograph, drawing, or clipart.                                                                                                                                                                                                                                                               |   |
| Implemented                    | To carry something into effect.                                                                                                                                                                                                                                                                  |   |
| Import                         | To convert a file to the format required by the system and store the file on the mobile device where it is accessible within the system, to upload the file to the system’s back end, and to insert the necessary reference data into the database to be able to access the file.                |   |
| Integration Testing            | A particular form of software testing that includes distinct units, modules, or components of a software.                                                                                                                                                                                        |   |
| Integration Tests              | A series of tests, written with code, that is used to verify the functionality of a particular feature.                                                                                                                                                                                          |   |
| iOS                            | A popular operating system specifically developed and maintained by Apple Inc.                                                                                                                                                                                                                   |   |
| Key Feature                    | A critical characteristic.                                                                                                                                                                                                                                                                       |   |
| Key Requirement                | The established conditions, specifications, objective, or goal.                                                                                                                                                                                                                                  |   |
| Limit_Data                     | A function limiting the amount of data worth of texts a user can upload.                                                                                                                                                                                                                         |   |
| Linked                         | An established connection between two devices.                                                                                                                                                                                                                                                   |   |
| Linking                        | To establish a connection between two devices.                                                                                                                                                                                                                                                   |   |
| Login                          | The user must provide a username and password to access the system.                                                                                                                                                                                                                              |   |
| Menu                           | A series of linked items that serve to foster website navigation between the different pages or sections of a site                                                                                                                                                                               |   |
| NoSQL Database                 | A technology used to save memory/data simplistically without the use of a programming language known as SQL.                                                                                                                                                                                     |   |
| Notes                          | A feature in the system that allows a user to record and save a message.                                                                                                                                                                                                                         |   |
| Operating System               | Provides common services and basic functions to a device, such as scheduling tasks and executing applications.                                                                                                                                                                                   |   |
| Parties                        | An individual(s) or group(s) of people that could potentially view and interact with a user’s posts: other users, general viewers on the internet, and even bots or other entities that do not represent the user.                                                                               |   |
| Passes                         | The results of the verification process were met.                                                                                                                                                                                                                                                |   |
| Password                       | The combination of letters, numbers, or symbols a user must present for security purposes.                                                                                                                                                                                                       |   |
| People / Person                | People could refer to human beings or specific animals, such as pets.                                                                                                                                                                                                                            |   |
| Passenger Seats                | The number of available seats offered by users in community posts seeking or offering rides, indicating the capacity for passengers in transportation arrangements.                                                                                                                              |   |
| Post                           | To publish content on a public platform.                                                                                                                                                                                                                                                         |   |
| Preview                        | A preliminary view of entries.                                                                                                                                                                                                                                                                   |   |
| Print                          | To select a printing vendor to enable book options.                                                                                                                                                                                                                                              |   |
| Prototype                      | A preliminary model of the system.                                                                                                                                                                                                                                                               |   |
| Required Function              | An essential capability.                                                                                                                                                                                                                                                                         |   |
| Save                           | Allows saving the post in the app.                                                                                                                                                                                                                                                               |   |
| Select                         | To select an post to enable it to be edited.                                                                                                                                                                                                                                                     |   |
| Series of entries              | Many recorded events for a specific location the user has visited.                                                                                                                                                                                                                               |   |
| Share                          | To allow sharing of the post (social media, mail, message, etc).                                                                                                                                                                                                                                 |   |
| Share_Post                     | A function that posts the user’s post and personal description to social medial                                                                                                                                                                                                                  |   |
| Simplified Database            | A basic set of structured data.                                                                                                                                                                                                                                                                  |   |
| Social Media Account           | An application that allows people to create and share information.                                                                                                                                                                                                                               |   |
| Social Media Platform          | A technology that allows people or groups of people to interact.                                                                                                                                                                                                                                 |   |
| Span of Time                   | A period of time in which something happens. Specifically, this will be used to find certain travel events.                                                                                                                                                                                      |   |
|                                |                                                                                                                                                                                                                                                                                                  |   |
| Supporting Cause               | Agreeing with an idea or goal among people.                                                                                                                                                                                                                                                      |   |
| System                         | All components/parts of the application.                                                                                                                                                                                                                                                         |   |
| Tag                            | A label attached to some aspect of an entry for the purposes of searching for that entry. For instance, a tag might be a person’s name in an post.                                                                                                                                               |   |
|                                |                                                                                                                                                                                                                                                                                                  |   |
| Timeline                       | A graphic representation of the passage of time from a list of events.                                                                                                                                                                                                                           |   |
| Tutorial / Onboarding          | A series of images and/or text that teach the user how to use the desired software.                                                                                                                                                                                                              |   |
| Upload                         | To transfer (data) from one computer to another, typically to one that is larger or remote from the user or functioning as a server [10].                                                                                                                                                        |   |
| Upload_images                  | A function allowing the user to import their images into the system.                                                                                                                                                                                                                             |   |
| Uploading                      | Sharing a file with a remote server through an internet connection.                                                                                                                                                                                                                              |   |
| Usability                      | A metric that measures the quality of characteristics.                                                                                                                                                                                                                                           |   |
| User                           | An individual using the system.                                                                                                                                                                                                                                                                  |   |
| User Networking                | The sharing of information among people with common interests.                                                                                                                                                                                                                                   |   |
| Username                       | Each user has a unique name for identification purposes.                                                                                                                                                                                                                                         |   |
|                                |                                                                                                                                                                                                                                                                                                  |   |
| View (and Organize)            | To view individual posts/videos/sound clips.                                                                                                                                                                                                                                                     |   |
|  Community Forum Application   | The mobile device application designed to facilitate community engagement and interaction, allowing users to share information, exchange ideas, and connect with others within their local community or specific interest groups.                                                                |   |
| Geotagged Posts and Events     | Posts and events within the application tagged with geographical coordinates, allowing users to view and interact with location-based content on a mapping interface                                                                                                                             |   |
|        NoSQL Database          | A type of database management system that provides a mechanism for storage and retrieval of user data within the system, offering flexibility and scalability compared to traditional relational databases.                                                                                      |   |
|              Posts             | Messages or announcements created by users within the application to seek or offer rides, promoting transportation assistance within the community. These posts include attributes such as start and stop destinations, description, category, timestamp, rating, and available passenger seats. |   |
| Digital Bulletin Board         | A virtual platform within the application where users can post text, images, multimedia content, and announcements, similar to a traditional bulletin board used for communication and information sharing.                                                                                      |   |
|                                |                                                                                                                                                                                                                                                                                                  |   |
|                                |                                                                                                                                                                                                                                                                                                  |   |
| Search                         | The feature enabling users to search for specific posts based on criteria such as destination, category, and timestamp, facilitating efficient discovery of relevant information within the community.                                                                                           |   |
| SMS Sharing                    | The option within the system to share selected posts via text messages for communication purposes, utilizing the Short Message Service (SMS) to exchange short text messages between mobile devices.                                                                                             |   |
|                                |                                                                                                                                                                                                                                                                                                  |   |
| User Account Management        | The functionality responsible for managing user accounts within the system, including processes related to authorization, authentication, and access control to protect user data and privacy.                                                                                                   |   |
|                                |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
# References

  1. "Manage your app's memory | Android Developers," Android Developers, 2022. https://developer.android.com/topic/performance/memory (Accessed: 25-Jun-2022).
  2. "Apple Developer Documentation," Apple.com, 2022. https://developer.apple.com/documentation/metrickit/improving\_your\_app\_s\_performance/reducing\_your\_app\_s\_memory\_use (Accessed: 25-Jun-2022).
  3. "Internet Connection Definition," Law Insider. https://www.lawinsider.com/dictionary/internet-connection (Accessed: 25-Jun-2022).
  4. "What is a Follower? Social Media Marketing Definitions," SocialBee. https://socialbee.io/glossary/follower/ (Accessed: 25-Jun-2022).
  5. "Definition of resize - iDigitalPhoto Dictionary," www.idigitalphoto.com. http://www.idigitalphoto.com/dictionary/resize (Accessed: 25-Jun-2022).
  6. "Skewed - Definition, Meaning & Synonyms," Vocabulary.com. https://www.vocabulary.com/dictionary/skewed (Accessed: 25-Jun-2022).
  7. Brigham Young University of Idaho CSE 430 SRS Document Submitted 2022
  8. Brigham Young University of Idaho CSE 472 SRS Document Submitted 2022
  9. Brigham Young University of Idaho CSE 372 SRS Document Submitted 2022
  10. "OpenAI" is the author, "2024" is the year, "ChatGPT - The AI language model by OpenAI" is the title of the webpage, and "[https://openai.com/chatgpt](https://openai.com/chatgpt)"

1.
# 3 Requirements
  ## 3.1.	Functions
  ### 3.1.1.	User Profile aw added
  3.1.1.1.	The user profile shall have security awadded
  3.1.1.2.	The user profile shall have Authorization aw added
  3.1.1.3.	The user profie shall have Authentication aw added
  3.1.1.4.	The user profile shall have  Access aw added
  3.1.1.5   The system shall ask for the login and password in the social media environment
  3.1.1.6   The system shall ask to confirm before posting on social media.
  ### 3.1.2.	Login / Registration 
  3.1.2.1.	The system shall ask for the login and password in the social media environment 
  3.1.2.2.	The system shall ask to confirm before posting on social media. 
  ### 3.1.3.	Community Post – AW 
  3.1.3.1.	The Community Post shall show rides needed aw added 
  3.1.3.2.	The Community Post shall show passengers needed aw added
  3.1.3.3.	The community post shall have start Destinations
  3.1.3.4.	The Community post shall have Stop destination aw added 
  3.1.3.5.	The Community post shall have a description 
  3.1.3.6.	The community post shall have Categories
  3.1.3.7.	The community post shall have timestamps. 
  3.1.3.8.	The community post shall have ratings 
  3.1.3.9.	The community post shall have passengers
  ### 3.1.4.	Search 
  3.1.4.1.	A menu to retrieve and search for post 
  3.1.4.2.	The system shall have access to the menu and allow users to access the 
  3.1.4.3.	The system shall allow users to search for categories, rides, and post. 
  ### 3.1.5  Messages EXample
  3.1.5.1	test
  3.1.6.	Reviews
  3.1.6.1.	test
  3.1.8.	Timeline / Calendar EXample
  3.1.8.1.	The system shall include a timeline. 
  3.1.8.2.	The timeline shall allow the user to see posts, locations, and dates of a series of entries that occur within the start and ending time of the timeline
  3.1.8.3.	The information for each entry displayed on the timeline shall include location, notes, and people involved. 
### Community Forum
      1. test
      2. test
      3. test
      4. test
      5. test
      6. test
      7. test
      8. test
### Post / Commenting
      1. test
      2. test
      3. test
        1. test
        2. test
        3. test
        4. test
      4. test
      5. test
      6. test
    5.
### Timeline / Calendar
      1. The system shall include a timeline.
      2. The timeline shall allow the user to see posts, locations, and dates of a series of entries that occur within the start and ending time of the timeline
      3. The information for each entry displayed on the timeline shall include location, notes, and people involved.
      4. test
      5. test
      6. test
      7. test
      8. test
  2.
## Performance Requirements Example 
    1. Logon
      1. The user shall be able to toggle between screens.
    2. System Background
      1. The system shall run in the background
    3. Interface
      1. The system shall allow the use of the home button and freeze the state in the app.
      2. The system shall allow the user to navigate between screens without losing the content in the app.
    4. Storage
      1. The system shall store the characters and dates in the cache to allow the user to return to the app.
  3.
## Usability Requirements EXample 
    1. Onboarding Tutorial
      1. After initially logging into the system, the user shall see a tutorial.
      2. test
      3. test
      4. test
    2. test
      1. test
      2. test
      3. test
        1. test
        2. test
      4. test
    3. Post Editing
      1. test
      2. Test
      3. test
      4. test
    4. Social Media
      1. The system shall be able to link to a user's social media accounts such as Facebook and Instagram.
      2. test
    5. Sharing
      1. The system shall have the ability to share post by MMS.
      2. test
    6. Organization
      1. When using List View mode, posts shall be automatically organized by date.
  4.
## Interface Requirements Example 
    1. Menu
      1. The system shall provide a menu to post
      2. The system shall display a menu on the screen with options to post an to social media.
      3. test
      4. The menu items for social media are
        1. Twitter
        2. Snapchat
        3. Facebook (M\_P I)
        4. Text Message (M\_P I)
      5. test
        1. test
        2. test
        3. test
      6. test
        1. test
          1. Public (H\_P)
          2. Private (H\_P)
          3. Password from the login of the system, as well as a code, is sent to associated links (phone # or email), to incorporate a two-step verification of the user. (M\_P)
    2. System
      1. The system shall use the Operating System's API
      2. The system shall allow the user to manually or automatically tag the location
    3. Profile Page
      1. The system shall give access through the menu to the user's Profile Page
      2. Within the user's Profile Page, the user shall be able to navigate to Privacy Settings
      3. Within the user's Profile Page, the user shall be able to navigate Personal Identifying information
      4. test
      5. est
      6. test
  5.
## Menu Template Example 
    1. The system has a menu
    2. test
      1. test
      2. test
      3. test
    3. The system shall allow the user to remove a post. (L\_P)
      1. The Menu Options allow the user to delete the post on a more options menu or a separate delete button on the corner of the post.
      2. The post Menu Options shall allow the user
        1. The Template Menu Options allow the user to upload post using a button on the system's main menu, allowing quick access to post templates. (H\_P)
  6.
## Menu Social Media/Sharing Example 

    1. The user shall be able to tap on a social media icon to post the adventure/entry to other top social media platforms. (M\_P)
      1. The user shall be able to post entries to social media only after successfully logging into the system and linking their social media accounts to the system. (H\_P)
      2. The social media accounts accessible through the system include Facebook, Instagram, Pinterest, and Twitter. (M\_P)
    2. The system shall allow the user to follow others' scrapbooks. (L\_P)
  7.
## Logical Database Requirements Example 

    1. Each post hall have a date associated with it. (R)
      1. Each post shall have a default date when added to the system. (R)
      2. The default date shall be the date that the post is imported into the system. (R)

# 4 Verification Example 

## 4.1.	Functions Example 
### 4.1.1.	User Profile  Example 
4.1.1.1.	test
4.1.1.2.	test
4.1.1.3.	test
4.1.1.4.	test
4.1.1.5.	test
4.1.1.6.	If the system allows users to save their favorite post , it passes verification; otherwise, it fails verification. 
4.1.1.7.	If the system enables users to upload 
4.1.1.8.	If the system allows the user to import a 
4.1.1.9.	If the system allows support 
4.1.1.10.	 If the system allows the user to comment 
4.1.1.11.	If the system will enable edits 
4.1.1.12.	
### 4.1.2.	Login / Registration Example 

4.1.2.1.	If the system asks for the login and password in the social media environment, it passes verification; otherwise, it fails verification. (H_P)
4.1.2.2.	If the system asks to confirm before posting on social media, it passes verification; otherwise, it fails verification. (M_P) 
### 4.1.3.	Community Post  Example 
4.1.3.1.	test
4.1.3.2.	test
4.1.4.	Search 
4.1.4.1.	test
4.1.4.2.	test
4.1.4.3.	test
4.1.4.4.	test
### 4.1.5.	Messages Example 
4.1.5.1.	If the system allows the user 
4.1.5.2.	If the system allows the user to 
4.1.5.3.	If the system displays 
4.1.5.4.	If the system allows the user to 
### 4.1.6.	Interface Example 
4.1.6.1.	If the system allows the user to go to a page that the user expects to see, it passes verification; otherwise, it fails verification 
4.1.6.2.	If the system authorizes the user to 
4.1.6.3.	If the system accesses Google Apple API to provide reliable 
### 4.1.7.	Timeline / Calendar Example 
4.1.7.1.	If the vertical timeline displays dates and allows the user to access the post and events linked to a particular date, it passes verification; otherwise, it fails verification. (H_P, R, V_I)
4.1.7.2.	If the user can create multiple entries for a single date, then the system passes verification; otherwise, it fails verification. (H_P, R)
4.1.7.3.	If the system allows the user to see the People, Notes, and Location categories for an entry or displays 
4.1.7.4.	If the system allows the user to enter a set of times to review all the information, the system passes verification; otherwise, it fails verification. (M_P)
4.1.7.5.	If the system allows a user to pick specific entries to be shown on the timeline, then it passes verification; otherwise, it fails verification. (L_P)
4.1.7.6.	If the system allows the user to restrict which entry categories are displayed on the timeline, then it passes verification; otherwise, it fails verification. (L_P)
## 4.2.	Performance Requirements Example 
### 4.2.1.	Logon Example 
4.2.1.1.	If the user toggles between screens, it passes verification; otherwise, it fails verification. 
4.2.2.	System Background
4.2.2.1.	If the system runs in the background, it passes verification; otherwise, it fails verification (M_P)	
### 4.2.3.	Interface Example 
4.2.3.1.	If the system allows the use of the home button and freezes the state in the app, it passes verification; otherwise, it fails verification. 
4.2.3.2.	If the system allows the user to navigate between screens without losing the app’s content, it passes verification; otherwise, it fails verification. (R) 
### 4.2.4.	Storage Example 
4.2.4.1.	If the system stores the characters and dates in the cache to allow the user to return to the app, it passes verification; otherwise, it fails verification. (R) 
## 4.3.	Usability Requirements Example 
### 4.3.1.	Onboarding Tutorial Example 
4.3.1.1.	If the screen displays a tutorial after the user initially logs into the system, then the system passes verification; otherwise, it fails verification.
4.3.1.2.	If the tutorial starts immediately after a splash screen and has anywhere from 3 to 5 pages that show the user how to use the system, then the tutorial passes verification; otherwise, it fails verification.
4.3.1.3.	If the tutorial has 3-5 screens that include a combination of text, images, and animations, then the tutorial passes verification; otherwise, it fails verification.
4.3.1.4.	If the system does not show the tutorial to the user after the initial login unless the user downloads the system anew or accesses the tutorial from the settings tab, then the system passes verification; otherwise, it fails verification.
### 4.3.2.	test Example 
4.3.2.1.	test
4.3.2.2.	Verification passes if the system has created a saved collection gallery of post or examples of templates the user can access and modify. (H_P)
### 4.3.3.	post Example 
4.3.3.1.	test
4.3.3.2.	If the system displays the edited post to the user after each edit, it passes verification; otherwise, it fails verification. (H, I)
4.3.3.3.	If the system allows the user to save or discard the edited post after editing, it passes verification; otherwise, it fails verification. (H_P, H, I)
4.3.3.4.	If the system allows the user to add text with font, color, weight, and size options, it passes verification; otherwise, it fails verification. (H_P, I)
4.3.3.5.	If the system allows the user to add nested images (stickers) onto the post, it passes verification; otherwise, it fails verification. (H_P, I)
4.3.3.6.	If the system allows the users the option to change the date of the post, it passes verification; otherwise, it fails.  (H_P, H)

### 4.3.4.	Social Media Example 
4.3.4.1.	If the system allows the user to link to the user’s social media accounts, such as Facebook and Instagram, it passes verification; otherwise, it fails verification. (M_P)
4.3.4.2.	If the system allows the user to post one or more images to the user’s linked social media accounts, it passes verification; otherwise, it fails verification. (H_P)
### 4.3.5.	Sharing Example 
4.3.5.1.	If the system allows the user to send an MMS message with an post, then it passes the verification; otherwise, it fails the verification. (H_P)
4.3.5.2.	If the system includes a link with an invitation to view/download the system when sending an post via MMS, then it passes the verification; otherwise, it fails the verification. (H_P)
### 4.3.6.	Organization Example 
4.3.6.1.	If posts are automatically organized by date when the system is in List View mode, then it passes the verification; otherwise, it fails the verification. (H_P)
## 4.4.	Interface Requirements Example 
### 4.4.1.	Menu Example 
4.4.1.1.	If the system provides a menu to post 
4.4.1.2.	If the system provides a pop-up menu with options to post 
4.4.1.3.	If the system provides a menu giving many options for posting on social media, it passes verification; otherwise, it fails verification. (M_P I)
4.4.1.4.	If the menu item for social media is displayed, it passes verification; otherwise, it fails verification.  (M_P I) 
4.4.1.4.1.	If Twitter shows up on the menu, it passes verification; otherwise, it fails verification. (M_P I)
4.4.1.4.2.	If Snapchat shows up on the menu, it passes verification; otherwise, it fails verification.  (M_P I)
4.4.1.4.3.	If Facebook shows up on the menu, it passes verification; otherwise, it fails verification.  (M_P I)
4.4.1.4.4.	If Text Message shows up on the menu, it passes verification; otherwise, it fails verification. (M_P I)’
4.4.1.5.	If the system provides a way to post within the app on a menu, it passes verification; otherwise, it fails verification.  (H_P)
4.4.1.5.1.	If a menu pops up with a message for permission to post on the app, it passes verification; otherwise, it fails verification. (M_P I) 
4.4.1.5.2.	If a menu showcasing a draft of the user’s description shall pop up before the user can send it to the user’s social media, it passes verification; otherwise, it fails verification. (M_P I)
4.4.1.5.3.	If the system allows the user to tag people in the post, it passes verification; otherwise, it fails verification. (M_P)
4.4.1.6.	If a social media menu requires a two-step security option to post an post, it passes verification; otherwise, it fails verification. (H_P)
4.4.1.6.1.	If the following items are on the social media menu, they pass verification; otherwise, they fail verification. (H_P)
4.4.1.6.1.1.	If the system displays the Public option on the list, it passes verification; otherwise, it fails.  (H_P)
4.4.1.6.1.2.	If the system displays the Private option on the list, it passes verification; otherwise, it fails (H_P)
4.4.1.6.1.3.	If the system requires a password from the login of the system, as well as a code is sent to associated links (phone # or email) to incorporate a two-step verification of the user, it passes verification; otherwise, it fails verification. (M_P) 
4.4.1.7.	If the system allows users to see the local restaurants then it passes the verification, Otherwise, it fails the verification. (M_P) 
### 4.4.2.	System Example 
4.4.2.1.	It passes verification if the system uses the Operating System’s map API for directions and pin locations. Otherwise, it fails verification. (M_P)
4.4.2.2.	Paste Here
### 4.4.3.	Profile Page Example 
4.4.3.1.	 If the system allows the user to access Profile Page through the menu, it passes verification. Otherwise, it fails verification. (H_P)
4.4.3.2.	 If the system allows the user to navigate to the privacy settings on the profile page, it passes verification. Otherwise, it fails verification. (M_P)  
4.4.3.3.	If the system allows the user to navigate their personal identifying information, it passes verification. Otherwise, it fails verification. (H_P) 
4.4.3.4.	 If the system allows the user to navigate to their locational settings, it passes verification. Otherwise, it fails verification (H_P) 
4.4.3.5.	If the system provides a way to navigate the termination of services page, it passes verification. Otherwise, it fails verification. (H_P) 
4.4.3.6.	If the system provides a way to navigate to the profile page, it passes verification. Otherwise, it fails verification. (H_P) 
## 4.5.	Menu Template Example 
4.5.1.	If the system provides a menu with different template options, it passes verification. Otherwise, it fails verification. (M_P) 
4.5.2.	If the system provides a way to display the following galleries in the menu, it passes verification. Otherwise, it fails verification.  (L_P)
4.5.2.1.	If the first category of templates saves templates, it passes verification. Otherwise, it fails verification.
4.5.2.2.	If the second category of templates is popular templates. It passes verification. Otherwise, it fails verification. 
4.5.2.3.	If the third category lists all available templates. It passes verification. Otherwise, it fails verification. 
4.5.3.	 If the system allows the user to remove a template from the template gallery. It passes verification. Otherwise, it fails verification. (L_P) 
4.5.3.1.	 If the Template Menu Options allow the user to delete the template on a more options menu or a separate delete button on the corner of the template, it passes verification. Otherwise, it fails verification. (L_P)
4.5.3.2.	If the Template Menu Options shall allow the user to select uploaded templates, it passes verification. Otherwise, it fails verification. (L_P)
4.5.3.2.1.	A template using a button on the system’s main menu, allowing quick access to uploaded templates, passes verification. Otherwise, it fails verification. (H_P) 
## 4.6.	Menu Social Media/Sharing Example 
4.6.1.	If the user is unable to post the adventure/entry to other top social media platforms when they tap on a social media icon, the system fails. (M_P)
4.6.1.1.	test
4.6.1.2.	test
4.6.2.	test
## 4.7.	Logical Database Requirements Example 
4.7.1.	test
4.7.2.	test
4.7.3.	test
## 4.8.	Design Constraints Example 
4.8.1.	N/A
## 4.9.	Software System Attributes Example 
4.9.1.	N/A
## 4.10.	Supporting Information Example 
4.10.1.	N/A 
# 5.	Appendices
##5.1.	Assumptions and Dependencies
5.1.1.	N/A
## 5.2.	Acronyms and Abbreviations

# Appendices

  1.
## Assumptions and Dependencies

    1. N/A
  2.
## Acronyms and Abbreviations

| **Acronym / Abbreviation** | **Full Form** |
| --- | --- |
| **API** | Application Programming Interface |
| --- | --- |
| **CPU** | Central Processing Unit |
| **GUI** | Graphical User Interface |
| **HTTP** | Hypertext Transfer Protocol |
| **iOS** | iPhone Operating System |
| **MMS** | Multimedia messaging Service |
| **N/A** | Not Applicable |
| **NoSQL** | Non-SQL (Structured Query Language) database |
| **SMS** | Simple Messaging Service |
| **SQL** | Structured Query Language |
| **SRS** | Software/Systems Requirement Specification |
| **TCP/IP** | Transmission Control Protocol/Internet Protocol |

  3.
## Priority Table

| **Tag** | **Variable** | **Description** |
| --- | --- | --- |
| **H** | Helpful | Requirements that at least 75% of users surveyed scored a 4 or a 5. (Scale 1-5, with 5 being the most helpful.) |
| --- | --- | --- |
| **H\_P** | High Priority | Features that should be implemented first. |
| **I** | Important | Requirement: At least 75% of users surveyed scored a four or a 5. (Scale 1-5, with 5 being the most important.) |
| **L\_P** | Low Priority | Features implemented last. |
| **M\_P** | Medium Priority | Features implemented next. |
| **N\_H** | Not Helpful | Requirements that less than 75% of users surveyed scored a 4 or a 5. (Scale 1-5, with 5 being the most helpful.) |
| **N\_I** | Not Important | Requirements less than 75% of users surveyed scored a 4 or a 5. (Scale 1-5, with 5 being the most important.) |
| **OPT** | Optional | Optional requirement. Nice, but not necessary. |
| **PLAT** | Platform | Special considerations or limitations regarding the platform the system is being developed for. |
| **PUR** | Purpose | Requirement related to the purpose of the system. |
| **R** | Required | Required for the system to function. |
| **V\_H** | Very Helpful | Requirements that at least 75% of users surveyed scored a 5. (Scale 1-5, with 5 being the most helpful.) |
| **V\_I** | Very Important | Requirements: At least 75% of users surveyed scored a 5. (Scale of 1-5, with 5 being the most important.) |
