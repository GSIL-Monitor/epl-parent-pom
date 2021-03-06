package com.interview.socket.server;

import java.net.*;

import java.io.*;

/**
 * socket 服务端
 * 
 * @author Administrator
 * 
 */
public class Server {

  private ServerSocket ss;

  private Socket socket;

  private BufferedReader in;

  private PrintWriter out;

  public Server() {
    try {
      // 在 10000 端口 
      ss = new ServerSocket(10001);
      while (true) {
        socket = ss.accept();
        String RemoteIP = socket.getInetAddress().getHostAddress();
        String RemotePort = ":" + socket.getLocalPort();
        System.out.println("A client come in!IP:" + RemoteIP + RemotePort);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = in.readLine();
        System.out.println("Cleint send is :" + line);
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Your Message Received!");
        out.close();
        in.close();
        socket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
      out.println("wrong");
    }

  }

  public static void main(String[] args) {
    new Server();
  }

};
