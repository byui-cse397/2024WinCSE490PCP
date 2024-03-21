from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasAccountId(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Post table has a 'account_id' field.
        """
        cursor = connection.cursor()

        try:
            cursor.execute("DESCRIBE Post")
            columns = cursor.fetchall()
            for column in columns:
                if 'accounts_id' in column:
                    # 'account_id' field found
                    return True
                # 'account_id' field not found
            return False
        except Error:
            # Error occurred
            return False

