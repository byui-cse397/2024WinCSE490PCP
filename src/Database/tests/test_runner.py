from typing import List
from db_test import DBTest
from mysql.connector import MySQLConnection


class TestRunner:
    """
    A class to run a collection of DBTest instances.
    """

    def __init__(self, tests: List[DBTest], connection: MySQLConnection):
        """
        Initializes the TestRunner with a list of DBTest instances.
        """
        self._tests = tests
        self._connection = connection

    def run_tests(self):
        """
        Runs all tests in the list.
        """
        for test in self._tests:
            test.run(self._connection)
