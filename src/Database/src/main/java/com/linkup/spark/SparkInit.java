package com.linkup.spark;

import com.linkup.common.XMLParsing.*;
import com.linkup.httpsserver.*;
import java.io.IOException;
import java.util.Map;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkInit {
  /**
   * The entry point for our Database jar.
   * @param args
   *
   */
  public static void main(String[] args) {
    // Initialize SparkSession
    SparkSession spark = SparkSession.builder()
                             .appName("SparkDataFrameExample")
                             .master("local[*]")
                             .getOrCreate();

    String url = "jdbc:mysql://localhost:3306/linkup_db";
    String user = "linkup-admin";
    String password = "nimda";

    String xml_test_query =
        "<query:string>INSERT INTO account (username, password_hash) VALUES ('user01', 'my_strong_password');</query>";
    XMLParser parser = new XMLParser(xml_test_query, null);
    try {
      XMLNode node = parser.parse();
      System.out.println(node.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
    DatabaseManager db = new DatabaseManager(url, user, password);
    try {
      HTTPSServer server = new HTTPSServer(db);
    } catch (Exception e) {
      e.printStackTrace();
    }
    // db.loadTablesSpark(spark);

    // Cleanup
    spark.stop();
    // db.closeConnection();
  }
}
