from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasDepartPostId(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Departing table has a 'post_id' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Departing")
            columns = cursor.fetchall()
            for column in columns:
                if 'post_id' in column:
                    # 'post_id' field found
                    return True
                # 'post_id' field not found
            return False
        except Error:
            # Error occurred
            return False