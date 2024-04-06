from mysql.connector import MySQLConnection, Error
from db_test import DBTest
import time
import datetime

class messagesAddTest(DBTest):
    def _test(self, connection: MySQLConnection):
        """
        This will run a test on adding an entry to the messages table
        """
        message_content = 'This is a test for messaging .... &^$&#'
        timestamp = datetime.datetime.fromtimestamp(time.time()).strftime('%Y-%m-%d %H:%M:%S')
        sender = 1
        receiver = 1

        cursor = connection.cursor()
        connection.autocommit = False
        try:
            
            sql = "INSERT INTO messages (message_content, message_time, sender_id, receiver_id) VALUES (%s, %s, %s, %s)"
            val = (message_content, timestamp, sender, receiver)
            
            cursor.execute(sql, val)
            connection.commit()
            
            # This just removes the entry right away as to make it so the post table does not get spammed with tests
            sql = f"DELETE FROM messages WHERE message_content='{message_content}'"
            cursor.execute(sql)
            connection.commit()
            cursor = cursor.fetchall()
            return True

        except Error:
            return False