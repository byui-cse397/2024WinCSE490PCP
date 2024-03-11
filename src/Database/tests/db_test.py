from mysql.connector import MySQLConnection
from termcolor import colored
import abc


class DBTest(abc.ABC):
    """
    Abstract base class for database tests.
    """

    @abc.abstractmethod
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Abstract method to be implemented by subclasses.
        Should return True if the test passes, False otherwise.
        """
        pass

    def run(self, connection: MySQLConnection) -> None:
        """
        Runs the test and prints the result.
        """
        result = self._test(connection)
        if result:
            print(colored(f"{self.__class__.__name__} passed the test.", "green"))
        else:
            print(colored(f"{self.__class__.__name__} failed the test.", "red"))
