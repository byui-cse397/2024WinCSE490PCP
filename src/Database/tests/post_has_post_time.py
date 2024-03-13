from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasPostTime(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Post table has a 'post_time' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Post")
            columns = cursor.fetchall()
            for column in columns:
                if 'post_time' in column:
                    # 'post_time' field found
                    return True
                # 'post_time' field not found
            return False
        except Error:
            # Error occurred
            return False

