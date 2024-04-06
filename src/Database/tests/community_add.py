from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class communityAddTest(DBTest):
    def _test(self, connection: MySQLConnection):
        """
        This will run a test on adding an entry to the community table
        """
        community_name = 'Rexburg Community *(&*&#)'
        
        cursor = connection.cursor()
        connection.autocommit = False
        try:
            parent_acc_id = 1 # IMPORTANT: Need a valid Parent Account ID for this to pass
            
            sql = "INSERT INTO community (community_name, parent_account_id) VALUES (%s, %s)"
            val = (community_name, parent_acc_id)
            
            cursor.execute(sql, val)
            connection.commit()
            
            # This just removes the entry right away as to make it so the post table does not get spammed with tests
            sql = f"DELETE FROM community WHERE community_name='{community_name}'"
            cursor.execute(sql)
            connection.commit()
            cursor = cursor.fetchall()
            return True

        except Error:
            return False