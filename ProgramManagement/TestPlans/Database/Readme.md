Test Plan
Version: 1.0

Team Name:          Database
Authors Team Names: 
* Joshua Bee
* Brian Anderson
* Kjellden Knutzen
* Nolan Jeppson
* Claudio Parra

Section 1: Project
Create an application that helps with finding and providing rides

Section 2: Requirements
<List of Requirements>

Section 3: Quality Model
 - [Quality Characteristics mentioned in the SRS]

Section 4: Test Cases
- Account Management
- Post Management
- Forum Management
- Comment Management
- Departing Management
- Arriving Management
- Community Management

Section 5: Test Data
[Database Test folder](https://github.com/byui-cse397/2024WinCSE490PCP/tree/Week08/src/Database) contains init.sql, and many testing files. 

Section 6: Test harness
Our DB test runs in python. We are using MySQL. So you must install both of those in order to test our software. You do need to do `pip install mysql-connector-python` and `pip install termcolor` for our testing to run. Just navigate to the link in section 5, and you will find all the code there. Running init.sql will make sure you have a basic version of the DB on your computer, and then running connector.py will actually run all the tests and show the results in green and red, for pass or fail, thanks to `termcolor`.


Test Procedure Template
Prefix: 
Description:
Pre-requisites:
Category:
Authors:
Requirements/Story:
Test Steps:
  

Types of Unit Tests:
Boundary Edges (0, 1, *, +/-, ^, !, = <>)
Zero, One, Many test (01*)– This type of test checks if the inputs are accepting normal values. 
Zero(0) represent nothing. Nothing is different depending on the desired input(int =0, float=0.0, char=’ ‘ or ‘\t’ or ‘\n’ or 0, string=”” empty string or any single char white space). 
1- One represents the first nominal test, i.e. 1, 2, 3, …n values that should be expected. 
Many(*-regular expression wild card) tests how the program handles multiple types or multiple values.
+/- Plus or minus one – boundary 
Power of 2s - (2^x), ASCII/UNICODE
Not the data: Invalid, Incorrect, garabage
Thresholds – above and below margin of error
Boundary Testing (<>) – This type of test checks where the inputs fail, usually providing different type data, length boundaries, invalid values, etc. The program should be able to handle this.


