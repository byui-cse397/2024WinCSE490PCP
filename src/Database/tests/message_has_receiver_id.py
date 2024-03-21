from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasMessageReceiverId(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Messages table has a 'receiver_id' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Messages")
            columns = cursor.fetchall()
            for column in columns:
                if 'receiver_id' in column:
                    # 'receiver_id' field found
                    return True
                # 'receiver_id' field not found
            return False
        except Error:
            # Error occurred
            return False

