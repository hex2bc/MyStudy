package android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * telnet 发送命令执行adb
 * ( sleep 5; echo "push"; sleep 30; ) | telnet 127.0.0.1 8189
 * Created by hex2bc on 2019/5/22.
 */
public class AdbServer {

    static String ADB_PATH = "c:WINDOWS\\system32\\adb ";

    static String[] cmds = {
            ADB_PATH + "root",
            ADB_PATH + "remount",
            ADB_PATH + "push Y:\\code\\6580\\alps\\out\\target\\product\\aeon6580_weg_l_l19" +
                    "\\system\\priv-app\\SystemUI\\SystemUI.apk " +
                    "/system/priv-app/SystemUI/SystemUI.apk",
            ADB_PATH + "reboot"
    };

    public static void main(String[] args) {
        adbSocketServer();
    }

    private static void adbSocketServer() {
        try {
            int i = 1;
            ServerSocket s = new ServerSocket(8189);
            while (true) {
                Socket incoming = s.accept();
                Runnable r = new AdbConnectThread(incoming);
                Thread t = new Thread(r);
                t.start();
                System.out.println("connect index:" + i);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected synchronized static void runShellCommand(String command, PrintWriter print) throws Exception {
        Process p = null;
        Scanner out = null;
        Scanner err = null;
        try {
            p = Runtime.getRuntime().exec(command);

            StringBuilder outStr = new StringBuilder();
            StringBuilder errStr = new StringBuilder();
            out = new Scanner(p.getInputStream());
            err = new Scanner(p.getErrorStream());
            boolean read = true;
            while (read) {
                if (out.hasNextLine()) {
                    outStr.append(out.nextLine());
                    outStr.append("\n");
                } else if (err.hasNextLine()) {
                    errStr.append(err.nextLine());
                    errStr.append("\n");
                } else {
                    read = false;
                }
            }
            System.out.println(command);
            print.println(command);
            if (outStr.length() > 0) {
                System.out.println(outStr.toString());
                print.println(outStr.toString());
            }
            if (errStr.length() > 0) {
                System.out.println(errStr.toString());
                print.println(errStr.toString());
            }
        } finally {
            if (p != null) {
                int status = p.waitFor();
                if (status != 0) {
                    throw new RuntimeException(
                            String.format("Run shell command: %s, status: %s", command, status));
                }
                p.destroy();
                p = null;
            }
            if (out != null) {
                out.close();
            }
            if (err != null) {
                err.close();
            }
        }
    }

    static class AdbConnectThread implements Runnable {

        private Socket mIncoming;

        public AdbConnectThread(Socket i) {
            mIncoming = i;
        }

        @Override
        public void run() {
            InputStream inputStream = null;
            PrintWriter out = null;
            OutputStream outputStream = null;
            try {
                inputStream = mIncoming.getInputStream();
                outputStream = mIncoming.getOutputStream();
                Scanner in = new Scanner(inputStream);
                out = new PrintWriter(outputStream, true);
                out.println("Connect success ...");
                System.out.println(mIncoming.getInetAddress() + " connect");
                boolean done = false;
                while (!done && in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println("receive:" + line);
                    if (line.trim().equals("BYE")) {
                        done = true;
                    } else if (line.trim().equals("push")) {
                        try {
                            for (String cmd : cmds) {
                                runShellCommand(cmd, out);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            runShellCommand(ADB_PATH + "shell " + line.trim(), out);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
