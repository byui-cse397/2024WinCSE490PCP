package com.linkup.spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class DatabaseManager {
  private String url;
  private String user;
  private String password;
  private Connection sqlConnection;

  public DatabaseManager(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
    try {
      Connection connection =
          DriverManager.getConnection(this.url, this.user, this.password);
      this.sqlConnection = connection;
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void loadTablesSpark(SparkSession spark) {
    this.url = "jdbc:mysql://localhost:3306/your_database";
    this.user = "your_username";
    this.password = "your_password";

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SHOW TABLES");

      while (rs.next()) {
        String tableName = rs.getString(1);
        Dataset<Row> df = spark.read()
                              .format("jdbc")
                              .option("url", url)
                              .option("dbtable", tableName)
                              .option("user", user)
                              .option("password", password)
                              .load();

        df.createOrReplaceTempView(tableName);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public String executeQueryJDBC(String query) throws SQLException {
    if (query.trim().toUpperCase().startsWith("SELECT")) {
      try (Statement statement = this.sqlConnection.createStatement();
           ResultSet resultSet = statement.executeQuery(query)) {
        return resultSetToString(resultSet);
      }
    } else {
      try (Statement statement = this.sqlConnection.createStatement()) {
        int rowsAffected = statement.executeUpdate(query);
        return "<rowsChanged>" + String.valueOf(rowsAffected) +
            "</rowsChanged>";
      }
    }
  }

  private static String resultSetToString(ResultSet resultSet)
      throws SQLException {
    StringBuilder sb = new StringBuilder();
    ResultSetMetaData metaData = resultSet.getMetaData();
    int columnCount = metaData.getColumnCount();

    while (resultSet.next()) {
      sb.append("<row>");
      for (int i = 1; i <= columnCount; i++) {
        String columnName = metaData.getColumnName(i);
        Object value = resultSet.getObject(i);
        String valueType = value == null
                               ? "null"
                               : value.getClass().getSimpleName().toLowerCase();
        sb.append("<")
            .append(columnName)
            .append(":")
            .append(valueType)
            .append(">")
            .append(value == null ? "null" : value.toString())
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

  public void closeConnection() {
    try {
      this.sqlConnection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
