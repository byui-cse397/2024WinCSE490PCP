from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasMessageContent(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Messages table has a 'message_content' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Messages")
            columns = cursor.fetchall()
            for column in columns:
                if 'message_content' in column:
                    # 'message_content' field found
                    return True
                # 'message_content' field not found
            return False
        except Error:
            # Error occurred
            return False

