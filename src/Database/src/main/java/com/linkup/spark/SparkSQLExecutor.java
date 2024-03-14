package com.linkup.spark;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkSQLExecutor {

  private SparkSession spark;

  public SparkSQLExecutor(SparkSession spark) { this.spark = spark; }

  /**
   * Executes a SQL query on a Spark Dataset.
   *
   * @param sqlQuery The SQL query to execute.
   * @param spark The SparkSession instance.
   * @param datasets A map of table names to Spark Datasets.
   * @return The result of the query as a Dataset<Row>.
   */
  public static Dataset<Row> executeQuery(String sqlQuery, SparkSession spark,
                                          Map<String, Dataset<Row>> datasets) {
    String tableName = extractTableName(sqlQuery);
    if (!datasets.containsKey(tableName)) {
      throw new IllegalArgumentException(
          "Table name not found in datasets map: " + tableName);
    }

    Dataset<Row> dataset = datasets.get(tableName);
    return dataset.sqlContext().sql(sqlQuery);
  }

  /**
   * Extracts the table name from a SQL query.
   *
   * @param sqlQuery The SQL query.
   * @return The extracted table name.
   */
  private static String extractTableName(String sqlQuery) {
    // Regex to extract the table name following the "FROM" keyword
    Pattern pattern =
        Pattern.compile("\\bFROM\\s+(\\w+)", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(sqlQuery);

    if (matcher.find()) {
      return matcher.group(1);
    } else {
      throw new IllegalArgumentException("Table name not found in SQL query: " +
                                         sqlQuery);
    }
  }

  /**
   * Extracts the table name from a SQL query.
   *
   * @param sqlQuery The SQL query.
   * @return The extracted table name.
   */
  public String executeQuery(String query) {
    if (query.trim().toUpperCase().startsWith("SELECT")) {
      // Execute the SELECT query and return the DataFrame as a string
      Dataset<Row> result = spark.sql(query);
      return datasetToString(result);
    } else {
      // Execute the non-SELECT query and return the number of rows affected as
      // a string
      StringBuilder sb = new StringBuilder();
      long numRows = spark.sql(query).count();
      sb.append("<rowsAffected>")
          .append(String.valueOf(numRows))
          .append("</rowsAffected>");
      return sb.toString();
    }
  }

  private static String datasetToString(Dataset<Row> dataset) {
    StringBuilder sb = new StringBuilder();
    for (Row row : dataset.collectAsList()) {
      sb.append("<row>");
      for (int i = 0; i < row.size(); i++) {
        String columnName = dataset.columns()[i];
        Object value = row.get(i);
        String valueType = value.getClass().getSimpleName().toLowerCase();
        sb.append("<")
            .append(columnName)
            .append(":")
            .append(valueType)
            .append(">")
            .append(value.toString())
            .append("</")
            .append(columnName)
            .append(":")
            .append(valueType)
            .append(">");
      }
      sb.append("</row>");
    }
    return sb.toString();
  }
}
