from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasMessageSenderId(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Messages table has a 'sender_id' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Messages")
            columns = cursor.fetchall()
            for column in columns:
                if 'sender_id' in column:
                    # 'sender_id' field found
                    return True
                # 'sender_id' field not found
            return False
        except Error:
            # Error occurred
            return False

