from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class PostHasContentText(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Post table has a 'content_text' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Post")
            columns = cursor.fetchall()
            for column in columns:
                if 'content_text' in column:
                    # 'content_text' field found
                    return True
                # 'content_text' field not found
            return False
        except Error:
            # Error occurred
            return False

