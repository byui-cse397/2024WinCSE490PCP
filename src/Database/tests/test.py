import mysql.connector
from mysql.connector import MySQLConnection, Error
from db_test import DBTest

class HasContentText():
    def _test(self, connection: MySQLConnection) -> bool:
        """
        Verify if the Post table has a 'content_text' field.
        """
        cursor = connection.cursor()
        cursor.reset()
        try:
            cursor.execute("DESCRIBE Post")
            columns = cursor.fetchall()

            for column in columns:
                if column[1] == 'content_text':
                    # 'content_text' field found
                    return True
            # 'content_text' field not found
            return False
        except Error:
            # Error occurred
            return False

# Configuration (replace with your actual credentials)
db_config = {
    'user': 'your_username', 
    'password': 'your_password', 
    'host': 'your_database_host', 
    'database': 'linkup_db'
}


def create_connection() -> MySQLConnection:
    """
    Establishes a connection to the MySQL database.
    """
    connection = mysql.connector.connect(
        host="localhost", user="linkup-admin", password="nimda", database="linkup_db"
    )
    return connection # type: ignore

# Test function
if __name__ == '__main__':
    try:
        cnx = create_connection()
        # cnx = mysql.connector.connect(**db_config)
        tester = HasContentText()
        result = tester._test(cnx)
        print("Result:", result)
    except mysql.connector.Error as err:
        print("Error:", err)
    finally:
        if cnx.is_connected():
            cnx.close()
