Test Plan
Version: 1.0

Team Name:          Back End
Authors Team Names: 
* [Team Member Names]
* Anita Woodford 

Section 1: Project
Create an application that helps with finding and providing rides

Section 2: Requirements
<List of Requirements>

Section 3: Quality Model
 - [Quality Characteristics mentioned in the SRS]

Section 4: Test Cases
- User Management
- Post
- [Delete User](https://github.com/byui-cse397/2024WinCSE490PCP/blob/Week08/src/Back-End/test/UserDeletion/userDeletionExamples.py)

Section 5: Test Data
[Location of data used for the tests]
- [User Deletion ](https://github.com/byui-cse397/2024WinCSE490PCP/blob/Week08/src/Back-End/test/UserDeletion/userDeletionExamples.py)

Section 6: Test harness
<Any software or setup needed to run the software and tests>



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


