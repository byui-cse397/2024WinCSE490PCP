from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasForumName(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Forum table has a 'forum_name' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Forums")
            columns = cursor.fetchall()
            for column in columns:
                if 'forum_name' in column:
                    # 'forum_name' field found
                    return True
                # 'forum_name' field not found
            return False
        except Error:
            # Error occurred
            return False

