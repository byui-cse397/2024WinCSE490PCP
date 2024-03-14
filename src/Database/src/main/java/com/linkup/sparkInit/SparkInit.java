package com.linkup.sparkInit;

import java.util.Arrays;
import java.util.List;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class SparkInit {
  public static void main(String[] args) {
    // Initialize SparkSession
    SparkSession spark =
        SparkSession.builder()
            .appName("SparkDataFrameExample")
            .master("local[*]") // Use local[*] for local testing
            .getOrCreate();

    // Establish a connection to the database
    String url = "jdbc:mysql://localhost:3306/linkup_db";
    String user = "linkup-admin";
    String password = "nimda";
    String table = "Account";

    // Load data from the database into a DataFrame
    Dataset<Row> dbDF = spark.read()
                            .format("jdbc")
                            .option("url", url)
                            .option("dbtable", table)
                            .option("user", user)
                            .option("password", password)
                            .load();

    // Show the DataFrame loaded from the database
    dbDF.show();
    // Stop the SparkSession
    spark.stop();
  }
}
