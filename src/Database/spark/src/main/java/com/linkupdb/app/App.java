package com.linkupdb.app;

/**
 * Hello world!
 *
 */
import java.util.Arrays;
import java.util.List;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class App {
  public static void main(String[] args) {
    // Initialize SparkSession
    SparkSession spark =
        SparkSession.builder()
            .appName("SparkDataFrameExample")
            .master("local[*]") // Use local[*] for local testing
            .getOrCreate();

    // Define the schema for the DataFrame
    StructType schema = new StructType(new StructField[] {
        DataTypes.createStructField("Name", DataTypes.StringType, true),
        DataTypes.createStructField("Age", DataTypes.IntegerType, true)});

    // Create a list of rows
    List<Row> data = Arrays.asList(RowFactory.create("John Doe", 30),
                                   RowFactory.create("Jane Doe", 25),
                                   RowFactory.create("Mike Smith", 40));

    // Create a DataFrame using the schema and data
    Dataset<Row> df = spark.createDataFrame(data, schema);

    // Show the DataFrame
    df.show();

    // Stop the SparkSession
    spark.stop();
  }
}
