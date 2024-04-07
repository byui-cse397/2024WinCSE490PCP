package com.linkup.spark;

import com.linkup.httpsserver.*;
import org.apache.spark.sql.SparkSession;

public class SparkInit {
  /**
   * The entry point for our Database jar.
   * @param args
   *
   */
  public static void main(String[] args) {
    // Initialize SparkSession
    /*
    SparkSession spark = SparkSession.builder()
                             .appName("SparkDataFrameExample")
                             .master("local[*]")
                             .getOrCreate();
    */

    String url = "jdbc:mysql://localhost:3306/linkup_db";
    String user = "linkup-admin";
    String password = "nimda";

    DatabaseManager db = new DatabaseManager(url, user, password);
    try {
      HTTPSServer server = new HTTPSServer(db);
    } catch (Exception e) {
      e.printStackTrace();
    }
    // db.loadTablesSpark(spark);

    // Cleanup
    /*
    spark.stop();
    */
    // db.closeConnection();
  }
}
