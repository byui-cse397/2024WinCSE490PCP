from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasCommunityId(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Community table has a 'id' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Community")
            columns = cursor.fetchall()
            for column in columns:
                if 'id' in column:
                    # 'id' field found
                    return True
                # 'id' field not found
            return False
        except Error:
            # Error occurred
            return False

