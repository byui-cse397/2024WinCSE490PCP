package com.linkup.database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;

public class HTTPSConnector {
  private SSLContext sc;
  private URI host;

  public String sendRequest(String message) {
    try {
      HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
      HostnameVerifier allHostsValid = (hostname, session) -> true;
      HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
      return send(host.toURL(), message);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  private String send(URL url, String message) throws Exception {
    StringBuilder response;
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();

    conn.setRequestMethod("POST");
    conn.setDoOutput(true);

    try (OutputStream os = conn.getOutputStream()) {
      byte[] input = message.getBytes("utf-8");
      os.write(input, 0, input.length);
    }
    try (BufferedReader br = new BufferedReader(
             new InputStreamReader(conn.getInputStream(), "utf-8"))) {
      response = new StringBuilder();
      String responseLine = null;
      while ((responseLine = br.readLine()) != null) {
        response.append(responseLine.trim());
      }
    }

    conn.disconnect();
    return response.toString();
  }

  public HTTPSConnector(String host) throws URISyntaxException {
    try {
      this.host = new URI(host);
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
this.sc = sc;
}
catch (NoSuchAlgorithmException e) {
  e.printStackTrace();
}
catch (KeyManagementException e) {
  e.printStackTrace();
}
}
}
