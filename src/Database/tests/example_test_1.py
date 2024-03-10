from mysql.connector import MySQLConnection, Error
from db_test import DBTest


class ExampleTest1(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        This is an example of syntax that we can use to access the DB
        """
        cursor = connection.cursor()
        try:
            cursor.execute("SELECT 1 FROM Account LIMIT 1")
            cursor.fetchall()
            # Yay! Data exists!
            return True
            
        except Error:
            # Oh no! Something went wrong!
            return False
