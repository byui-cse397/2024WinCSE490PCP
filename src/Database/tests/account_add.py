from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class accountAddTest(DBTest):
    def _test(self, connection: MySQLConnection):
        """
        This will run a test on adding an account to the Account table
        """
        username = 'BillyBob'
        pwd = 'password'
        hashed = hash(pwd)
        
        cursor = connection.cursor()
        connection.autocommit = False
        try:
            # This test will not pass unless the account_id actually exists in the database

            sql = "INSERT INTO account (username, password_hash) VALUES (%s, %s)"
            val = (username, hashed)
            
            cursor.execute(sql, val)
            connection.commit()
            
            # This just removes the entry right away as to make it so the post table does not get spammed with tests
            sql = f"DELETE FROM account WHERE username='{username}'"
            cursor.execute(sql)
            connection.commit()
            cursor = cursor.fetchall()
            return True

        except Error:
            return False