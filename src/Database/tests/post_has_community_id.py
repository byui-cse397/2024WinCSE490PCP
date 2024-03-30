from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class PostHasCommunityId(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Post table has a 'community_id' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Post")
            columns = cursor.fetchall()
            for column in columns:
                if 'community_id' in column:
                    # 'community_id' field found
                    return True
                # 'community_id' field not found
            return False
        except Error:
            # Error occurred
            return False
