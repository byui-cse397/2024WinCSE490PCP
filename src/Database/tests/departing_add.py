from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class departingAddTest(DBTest):
    def _test(self, connection: MySQLConnection):
        """
        This will run a test on adding an entry to the Departing table
        """
        location_text = 'Rexburg, ID'
        
        cursor = connection.cursor()
        connection.autocommit = False
        try:
            post_id = 5 # IMPORTANT: Need a valid Post ID for this to pass
            
            sql = "INSERT INTO departing (location_text, post_id) VALUES (%s, %s)"
            val = (location_text, post_id)
            
            cursor.execute(sql, val)
            connection.commit()
            
            # This just removes the entry right away as to make it so the post table does not get spammed with tests
            sql = f"DELETE FROM departing WHERE location_text='{location_text}'"
            cursor.execute(sql)
            connection.commit()
            cursor = cursor.fetchall()
            return True

        except Error:
            return False