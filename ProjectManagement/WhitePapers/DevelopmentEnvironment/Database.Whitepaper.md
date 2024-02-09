





Database Whitepaper

1-19-24

Joshua Bee, George Krenk, Angela Slinker, Conner Wadsworth, Claudio Inostroza














Executive Summary

- PostgreSQL 
- MariaDB 
- MySQL 
- SQLite  (https://developer.android.com/codelabs/basic-android-kotlin-compose-sql#0)

SQLite, a lightweight and versatile database engine, seamlessly integrates with Android Studio for mobile app development. This compatibility enhances the appeal of both SQLite and Android Studio. PostgreSQL, MariaDB, and MySQL are all better suited to use with a webapp. 

Introduction

In relational database management systems (RDBMS), choosing a database engine can significantly impact the efficiency and scalability of a web application. This exploration delves into three prominent options—PostgreSQL, MariaDB, and MySQL—each supported by the widely used Django framework. As we scrutinize these choices, MySQL emerges as a standout candidate, boasting widespread adoption, a vibrant community, and seamless integration with Django. While PostgreSQL, another Django-supported option, brings robust features to the table, MySQL's distinct advantages become evident in its adaptability across various project scales within the Django ecosystem. Furthermore, MariaDB, with its association with enterprise applications, introduces another layer of consideration. This paper navigates the features and nuances of these database systems, shedding light on MySQL's compelling attributes and its role in optimizing web application development within the Django framework. SQLite works well with Android studio though, so if we are to use android, then SQLite would be the obvious choice. 



Problem Statement 

In the evolving realm of programming languages, developers are presented with a variety of choices, each tailored to specific platforms and functions. This variety, while beneficial, poses a significant challenge in selecting the most suitable language for different development needs. This problem is further compounded by the unique requirements and learning curves associated with each language. From Java's widespread use in Android development to Swift's iOS specificity and Python's cross-platform capabilities, the decision becomes complex, especially for beginners. The challenge lies in balancing the languages' specific strengths with the developer's requirements and skill levels, making it crucial to understand the nuances and applications of each language to make an informed decision. 




Solution Overview

In selecting the optimal database management system for our project, we are considering PostgreSQL, MariaDB, and MySQL, each offering unique benefits and supported by the Django framework. PostgreSQL is known for its advanced features and scalability, making it ideal for complex and large-scale applications. MariaDB, a fork of MySQL, is recognized for its performance and enterprise focus, offering robust features and compatibility. MySQL, popular for its simplicity and wide adoption, is suitable for a broad range of projects, providing a balance between ease of use and functionality. Our choice will be based on the project's specific needs, considering factors such as scale, complexity, and the nature of the data to be managed. The decision aims to leverage the strengths of these systems within the Django framework to ensure efficient and reliable database management for our web application.



Detailed Analysis

- PostgreSQL

PostgreSQL, an open-source relational database management system, stands out for its advanced features, scalability, and commitment to data integrity. With support for diverse data types, powerful indexing, and ACID transactions, PostgreSQL is adept at handling complex queries and large datasets. Its extensibility allows developers to customize functions and data types, ensuring adaptability to project requirements. With robust security measures, advanced replication for high availability, and an active community, PostgreSQL remains a reliable and scalable choice for various applications, including seamless integration with frameworks like Django.

- MariaDB

MariaDB, an open-source relational database management system, is recognized for its performance, scalability, and enterprise-oriented capabilities. Derived from MySQL, MariaDB maintains compatibility while introducing enhancements. It excels in handling large datasets and complex queries, making it suitable for data-intensive applications. MariaDB offers ACID compliance, multi-version concurrency control, and efficient replication for high availability. Its focus on security includes features like role-based access control and encryption support. With an active community and strong support for custom functions and storage engines, MariaDB provides developers with a robust and flexible database solution. Its seamless integration with frameworks like Django further solidifies its position as a reliable choice for diverse projects.

- MySQL

MySQL, an open-source relational database management system well-supported by frameworks like Django, is an excellent choice for small-scale projects due to its simplicity and ease of use. With a focus on accessibility, MySQL provides straightforward configuration and quick setup, making it ideal for developers working on smaller applications with limited complexity. Its compatibility with various programming languages facilitates rapid development, while its efficient performance ensures responsiveness for smaller datasets and workloads. MySQL's popularity and extensive community support also mean easy troubleshooting and a wealth of resources for developers tackling smaller-scale projects. Overall, MySQL's user-friendly nature and community backing make it a particularly advantageous option for streamlined development in a small-scale project context.

Add description (Use chatgpt)

<a name="_@_46d42f5216ce427eb6453fca2f7592d7z"></a>[@Bee, Joshua](mailto:bee25@byui.edu) 

- SQLite

SQLite is a lightweight and versatile database engine widely used in mobile app development, particularly with Android Studio. Its simplicity and seamless integration with Android Studio make it a preferred choice for storing and managing data in Android applications. With SQLite, developers can efficiently create, query, and manipulate databases within their Android projects, facilitating the development of robust and scalable mobile applications. Its compact footprint and compatibility with Android Studio streamline the development process, empowering developers to build high-quality apps with ease.



- Case Studies/Real-World Applications Conner Wadsworth

MySQL is a popular open-source relational database management system. Here are some real-world applications and case studies where MySQL is extensively used:

Facebook

Facebook, one of the largest social media platforms globally, relies on MySQL for managing its vast amount of user data. MySQL is used for storing user profiles, activity logs, and other relational data.

Twitter

Twitter utilizes MySQL for storing and managing tweets, user profiles, and various relational data. MySQL's scalability and performance make it suitable for handling the high volume of tweets generated on the platform.

WordPress

WordPress, a widely used content management system (CMS), relies on MySQL as its default database. MySQL is used to store blog posts, comments, user information, and other content.

YouTube

YouTube, the popular video-sharing platform owned by Google, employs MySQL for managing user data, video metadata, and other relational data. MySQL helps in ensuring data integrity and consistency.

LinkedIn

LinkedIn, a professional networking platform, uses MySQL for storing user profiles, connection data, and other relational information. MySQL's reliability and ACID compliance are important for platforms like LinkedIn.

Uber

Uber, the ride-sharing platform, uses MySQL for various purposes, including managing user accounts, ride data, and transaction information. MySQL's support for complex queries and transactions is valuable for Uber's data needs.

Netflix

Netflix uses MySQL for different aspects of its platform, including customer account management, content metadata, and viewing history. MySQL's reliability and performance contribute to a seamless user experience.


NASA

NASA uses MySQL for managing and analyzing data related to space exploration. MySQL's robustness is crucial for handling scientific data and ensuring data accuracy.

These examples showcase the widespread use of MySQL in various industries, ranging from social media and content management to transportation and space exploration. MySQL's features, such as ease of use, scalability, and reliability, make it a preferred choice for many organizations dealing with relational databases.




Mention the database inspector in android studio ...

<https://developer.android.com/studio/inspect/database>

<a name="_@_857112217c79440fb4e8a687f0d92b6fz"></a>[@Krenk, George](mailto:george1@byui.edu) 

Done.
- Benefits and Advantages

The benefits and advantages of using Python over the other software languages we had on the table is ease of use, cross-platform functionality, and its ability to function on iOS, android, and Windows.

Python’s ease of use is a great benefit to us as that means those who do not have much experience in programming apps will still be able to learn and move ahead with the project. Python’s ease of use also means that digging through the code for bugs or potential updates will be more intuitive.

Python’s cross-platform functionality using BeeWare will be of the most use to us, as we have yet to set in stone exactly what sort of platform our app will be on. Since Python can work on multiple platforms and function on iOS, android, and Windows, it gives us more options for our app.

Android studio provides a powerful tool we can use in debugging our database, the Database Inspector. The Database Inspector allows us to modify and inspect our databases Even while our app is currently running. If we are using Room and our UI observes and uses the database, we will be able to see changes immediately upon making them within the Database Inspector. Within the Database Inspector we can also use previous Querys of our database, allowing us to backtrack should something break within our system. All these tools provide us great flexibility and work within android.

- Conclusion

From everything we researched and discussed, we were able to decide as a group that Python would be the best software to use for our development environment. Its ease of use, cross-platform compatibility, and ability in environments like iOS, android, and Windows makes it an excellent choice for our app.
