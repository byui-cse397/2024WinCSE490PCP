# MySQL Connection libraries
import mysql.connector
from mysql.connector import MySQLConnection

# Test classes
from test_runner import TestRunner
from db_test import DBTest
from example_test_1 import ExampleTest1

# Misc Imports
from typing import List


def create_connection() -> MySQLConnection:
    """
    Establishes a connection to the MySQL database.
    """
    connection = mysql.connector.connect(
        host="localhost", user="linkup-tester", password="tester", database="linkup_db"
    )
    return connection


def close_connection(connection: MySQLConnection):
    """
    Closes the connection to the MySQL database.
    """
    connection.close()


def get_test_list() -> List[DBTest]:
    """
    Create the list of test cases to run from our organized lists. As we create tests
    we'll add them to this method, which will allow us to dictate the tests that we're
    running, how they're classified, and what's going right/wrong.

    View tests should test the way that our database hands information off to backend
    (verify that data looks correct as serialized objects)

    Controller tests should test the way that data moves through our system (verify
    operations to create/read/update/delete are completed successfully)

    Model tests should test the content of our data (like table schemas)
    """
    # VIEW TESTS
    view_tests: List[DBTest] = []

    # CONTROLLER TESTS
    controller_tests: List[DBTest] = []

    # MODEL TESTS
    model_tests: List[DBTest] = [ExampleTest1()]

    test_bases = [view_tests, controller_tests, model_tests]
    combined_tests: List[DBTest] = []
    for test_base in test_bases:
        combined_tests.extend(test_base)

    return combined_tests


def run_tests(connection: MySQLConnection):
    """
    Run our get_test_list specified tests.
    """
    tests = get_test_list()

    tr = TestRunner(tests, connection)
    tr.run_tests()


def main():
    """
    Our program runner, creates a connection to our MySQL DB, then runs the tests
    that we've written
    """
    connection = create_connection()

    run_tests(connection)

    close_connection(connection)


if __name__ == "__main__":
    main()