from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasMessageTime(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Messages table has a 'message_time' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Messages")
            columns = cursor.fetchall()
            for column in columns:
                if 'message_time' in column:
                    # 'message_time' field found
                    return True
                # 'message_time' field not found
            return False
        except Error:
            # Error occurred
            return False

