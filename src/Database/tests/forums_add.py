from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class forumsAddTest(DBTest):
    def _test(self, connection: MySQLConnection):
        """
        This will run a test on adding an entry to the forums table
        """
        forum_name = 'Tester Forum *(&*&#)'
        
        cursor = connection.cursor()
        connection.autocommit = False
        try:
            post_id = 5 # IMPORTANT: Need a valid Post ID for this to pass
            
            sql = "INSERT INTO forums (forum_name, post_id) VALUES (%s, %s)"
            val = (forum_name, post_id)
            
            cursor.execute(sql, val)
            connection.commit()
            
            # This just removes the entry right away as to make it so the post table does not get spammed with tests
            sql = f"DELETE FROM forums WHERE forum_name='{forum_name}'"
            cursor.execute(sql)
            connection.commit()
            cursor = cursor.fetchall()
            return True

        except Error:
            return False