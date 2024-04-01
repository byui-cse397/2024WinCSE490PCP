from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasCommentText(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Comments table has a 'comment_text' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Comments")
            columns = cursor.fetchall()
            for column in columns:
                if 'comment_text' in column:
                    # 'comment_text' field found
                    return True
                # 'comment_text' field not found
            return False
        except Error:
            # Error occurred
            return False

