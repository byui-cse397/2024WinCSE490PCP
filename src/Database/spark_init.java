package Database;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkMySQLServer {

  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder()
                             .appName("SparkMySQLServer")
                             .config("spark.sql.warehouse.dir", "file:///tmp")
                             .getOrCreate();

    String url =
        "jdbc:mysql://localhost:3306/linkup_db?user=linkup-admin&password=nimda";
    Dataset<Row> df = spark.read()
                          .format("jdbc")
                          .option("url", url)
                          .option("dbtable", "Account")
                          .load();

    df.show();

    new Thread(() -> {
      try (ServerSocket serverSocket = new ServerSocket(4039)) {
        System.out.println("Server started on port 4039");
        while (true) {
          try (Socket clientSocket = serverSocket.accept()) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            String inputLine = in.readLine();
            if ("stop".equalsIgnoreCase(inputLine)) {
              System.out.println("Received stop command. Shutting down...");
              System.exit(0);
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }).start();
  }
}
