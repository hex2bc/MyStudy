package net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Socket 连接，从socket服务器获取时间
 * Core java II 3-1
 * Created by hex2bc on 2019/5/21.
 */
public class SocketTest {

    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 8189)) {
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);
            OutputStream outputStream = s.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }

            Scanner sysIn = new Scanner(System.in);
            while (sysIn.hasNextLine()) {
                out.print(sysIn.nextLine());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
