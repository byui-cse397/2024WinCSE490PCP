package com.linkup.httpsserver;

import java.io.IOException;
import java.util.ArrayList;

public class KeyGen {
  public KeyGen() {
    String password = "LinkupDBHTTPSServer";
    ArrayList<String[]> commands = new ArrayList<String[]>();
    String[] cleanup = {"rm", "keystore.jks"};
    String[] keystore = {
        "keytool",
        "-genkey",
        "-keyalg",
        "RSA",
        "-alias",
        "selfsigned",
        "-keystore",
        "keystore.jks",
        "-storepass",
        password,
        "-validity",
        "360",
        "-keysize",
        "2048",
        "-dname",
        "CN=linkup db, OU=db O=linkup, L=Rexburg, ST=Idaho, C=ID"};

    commands.add(cleanup);
    commands.add(keystore);

    for (String[] command : commands) {
      ProcessBuilder processBuilder = new ProcessBuilder(command);
      try {
        Process process = processBuilder.start();
        int exitCode = process.waitFor();
        if (exitCode != 0) {
          System.out.println("Command execution failed with exit code: " +
                             exitCode);
        }
      } catch (IOException | InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
