from mysql.connector import MySQLConnection, Error
from db_test import DBTest


class HasPasswordHashField(DBTest):
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Account table has a 'username' field.
        """
        cursor = connection.cursor()
        try:
            cursor.execute("DESCRIBE Account")
            columns = cursor.fetchall()

            for column in columns:
                if column[0] == 'password_hash':
                    # 'username' field found
                    return True
            # 'username' field not found
            return False
        except Error:
            # Error occurred
            return False
