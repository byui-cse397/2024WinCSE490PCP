package com.linkup.spark;

import com.linkup.XMLParsing.XMLNode;
import com.linkup.XMLParsing.XMLParser;
import com.linkup.httpsserver.*;
import java.io.IOException;
import java.util.Map;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkInit {
  public static void main(String[] args) {
    // Initialize SparkSession
    SparkSession spark = SparkSession.builder()
                             .appName("SparkDataFrameExample")
                             .master("local[*]")
                             .getOrCreate();

    String url = "jdbc:mysql://localhost:3306/linkup_db";
    String user = "linkup-admin";
    String password = "nimda";

    String xml_test =
        "<table:parent><row:parent><column1:int>1</column1><column2:string>Hello</column2></row><row:parent><column1:int>2</column1><column2:string>World</column2></row></table>";
    System.out.println("Starting XML parsing");
    XMLParser parser = new XMLParser(xml_test, null);
    try {
      XMLNode node = parser.parse();
      System.out.println(node.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
    // KeyGen setupKeys = new KeyGen();
    // DatabaseManager db = new DatabaseManager(url, user, password);
    // db.loadTablesSpark(spark);

    // Cleanup
    spark.stop();
    // db.closeConnection();
  }
}
