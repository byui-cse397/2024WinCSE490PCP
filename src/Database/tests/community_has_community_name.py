from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasCommunityName(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Community table has a 'community_name' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Community")
            columns = cursor.fetchall()
            for column in columns:
                if 'community_name' in column:
                    # 'community_name' field found
                    return True
                # 'community_name' field not found
            return False
        except Error:
            # Error occurred
            return False

