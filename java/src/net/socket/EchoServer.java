package net.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket 连接，从socket服务器获取时间
 * Core java II 3-3
 * Created by hex2bc on 2019/5/21.
 */
public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8189);
            try (Socket incoming = s.accept()){
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                try (Scanner in = new Scanner(inputStream)){
                    PrintWriter out = new PrintWriter(outputStream, true);
                    out.println("hello! Enter BYE to exit.");
                    System.out.println(incoming.getInetAddress() + " connect");
                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        System.out.println("receive:" + line);
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE"))
                            done = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
