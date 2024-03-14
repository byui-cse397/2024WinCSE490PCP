package com.linkup.httpsserver;

import java.io.IOException;

public class KeyGen {
  public KeyGen() {
    String[] command = {"keytool",    "-genkey",
                        "-keyalg",    "RSA",
                        "-alias",     "selfsigned",
                        "-keystore",  "keystore.jks",
                        "-storepass", "LinkupDBHTTPSServer",
                        "-validity",  "360",
                        "-keysize",   "2048"};

    ProcessBuilder processBuilder = new ProcessBuilder(command);

    try {
      Process process = processBuilder.start();
      int exitCode = process.waitFor();
      if (exitCode == 0) {
        System.out.println("Key generated successfully.");
      } else {
        System.out.println("Command execution failed with exit code: " +
                           exitCode);
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
