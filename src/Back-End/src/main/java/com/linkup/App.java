package com.linkup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;

public class App {

  public static void main(String[] args) {
    try {
      // Create a trust manager that does not validate certificate chains
      TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager(){
          public X509Certificate[] getAcceptedIssuers(){return null;
    }
    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
  }
};

// Install the all-trusting trust manager
SSLContext sc = SSLContext.getInstance("SSL");
sc.init(null, trustAllCerts, new java.security.SecureRandom());
HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
HostnameVerifier allHostsValid = (hostname, session) -> true;
HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
sendRequest(
    "https://localhost:4039",
    "<query:string>INSERT INTO Account (username, password_hash) VALUES ('user01', 'my_strong_password');</query>");
}
catch (Exception e) {
  e.printStackTrace();
}
}
private static void sendRequest(String urlString, String message)
    throws Exception {
  URL url = new URL(urlString);
  HttpURLConnection conn = (HttpURLConnection)url.openConnection();

  conn.setRequestMethod("POST");
  conn.setDoOutput(true);

  try (OutputStream os = conn.getOutputStream()) {
    byte[] input = message.getBytes("utf-8");
    os.write(input, 0, input.length);
  }
  try (BufferedReader br = new BufferedReader(
           new InputStreamReader(conn.getInputStream(), "utf-8"))) {
    StringBuilder response = new StringBuilder();
    String responseLine = null;
    while ((responseLine = br.readLine()) != null) {
      response.append(responseLine.trim());
    }
    System.out.println(response.toString());
  }

  conn.disconnect();
}
}
