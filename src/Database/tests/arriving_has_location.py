from mysql.connector import MySQLConnection, Error
from db_test import DBTest
import pdb

class HasArriveLocation(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Arriving table has a 'location' field.
        """
        cursor = connection.cursor()
        try:
            cursor.execute("DESCRIBE Arriving")
            columns = cursor.fetchall()
            
            for column in columns:
                if column[0] == 'location':
                    # 'location' field found
                    return True
            # 'location' field not found
            return False
        except Error:
            # Error occurred
            return False