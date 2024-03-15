from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class postAddToTableTest(DBTest):
    def _test(self, connection: MySQLConnection):
        """
        This will run a test on adding items to a table
        """

        cursor = connection.cursor()

        try:
            # uncomment this to add the test user 
            # sql = "INSERT INTO account (id, username, password_hash) VALUES (%s, %s, %s)"
            # val = (12345, "John", "Testing123")
            # cursor.execute(sql, val)

            # connection.commit()

            sql = "INSERT INTO post (content_text, account_id, post_time) VALUES (%s, %s, NOW())"
            val = ("We are learning how to code", 12345)
            
            cursor.execute(sql, val)
            connection.commit()

            # This just removes the post right away as to make it so the post table does not get spammed with tests
            sql = "DELETE FROM post WHERE content_text = 'We are learning how to code' AND account_id = 12345"
            cursor.execute(sql)
            connection.commit()
            cursor = cursor.fetchall()
            return True

        except Error:
            return False