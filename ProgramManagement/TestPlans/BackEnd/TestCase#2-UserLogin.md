**Backend Test Case**
**Test Case #2 – User Login**

**Objective**: To ensure the login function allows access with valid credentials and restricts access with invalid credentials.

Pre-requisites:

- The application is installed and accessible.
- The tester has valid login credentials (username and password).
- The tester has a set of invalid credentials for negative testing.

Test Data:

- Valid credentials: Username = **validUser**, Password = **validPass123**
- Invalid credentials:
  - Incorrect Username: Username = **invalidUser**, Password = **validPass123**
  - Incorrect Password: Username = **validUser**, Password = **invalidPass123**
  - Empty Username: Username = \`\`, Password = **validPass123**
  - Empty Password: Username = **validUser**, Password = \`\`

Steps:

1. **Launch the application**: Open the app and navigate to the login screen.
2. **Enter valid credentials**: Input the valid username and password into the respective fields.
3. **Submit the credentials**: Click/Tap the "Login" button.
4. **Verify successful login**: Check if the login is successful and the user is directed to the homepage/dashboard.

Expected Result:

- With valid credentials, the user should successfully log in and be redirected to the homepage/dashboard.

Negative Test Scenarios:

1. **Incorrect Username**
    - Repeat steps 1-3 using the "Incorrect Username" test data.
    - Expected: The system should display an error message indicating the username or password is incorrect.
2. **Incorrect Password**
    - Repeat steps 1-3 using the "Incorrect Password" test data.
    - Expected: The system should display an error message indicating the username or password is incorrect.
3. **Empty Username**
    - Repeat steps 1-3 using the "Empty Username" test data.
    - Expected: The system should prevent submission and display an error message indicating the username field cannot be empty.
4. **Empty Password**
    - Repeat steps 1-3 using the "Empty Password" test data.
    - Expected: The system should prevent submission and display an error message indicating the password field cannot be empty.

Post-Conditions:

- If login was successful, log out to return to the login screen for further testing.
- If login failed, clear the input fields before the next test.

**Test Case #3 – Delete User Account**

**Objective:** To verify that the backend system correctly deletes an existing user's account upon request.

**Preconditions:**

1. The backend server is up and running.
2. The user to be deleted exists in the system.
3. The user requesting deletion is authenticated and authorized to delete the account.

**Test Steps:**

1. Start with: The authenticated user has requested account deletion.
2. Actions:

a. Send a DELETE request to the backend API endpoint designated for account deletion.

b. Include the user's unique identifier (userId or username) in the request.

c. Ensure the Backend validates the requestor's permissions to perform account deletion.

d. Backend processes the deletion request and removes the user's data from the database.

e. Backend should revoke any active sessions or tokens associated with the user account.

f. Backend sends a confirmation response to the client upon successful deletion.

Ends with: The user account is no longer present in the system.

**Expected Results:**

1\. The Backend returns a successful response indicating the account has been deleted.

2\. The user's account is no longer retrievable from the database.

3\. The user cannot log in or recover the account post-deletion.

4\. Any subsequent API requests referencing the deleted user should be invalid.

**Postconditions:**

1. Verify that the user's data does not exist in any part of the system.
2. Ensure that any personal data is purged in compliance with data protection regulations.

**Notes:**

1. Ensure that deletion is permanent and meets all regulatory compliance requirements.
2. Test for potential cascading effects on related data, such as posts or comments made by the user.
3. Check for proper error handling and messaging when deletion is impossible (e.g., due to pending operations).

**Test Data:**

1. Use an account earmarked for deletion with no dependencies that would prevent its removal.

**Test Environment:**

1. A test environment that mimics the production environment but does not affect live user data.
2. A backend environment that is configured for testing with mock data for deletion.

**References:**

1. API documentation for the account deletion endpoint.
2. Backend logic implementation for the delete operation.
3. Data retention and deletion policies.
