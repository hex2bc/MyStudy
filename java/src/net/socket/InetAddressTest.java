package net.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取Internet地址
 * Core java II 3-2
 * Created by hex2bc on 2019/5/21.
 */
public class InetAddressTest {
    public static void main(String[] args) {
        if (args.length > 0) {
            String host = args[0];
            try {
                InetAddress[] addresses = InetAddress.getAllByName(host);
                for (InetAddress a : addresses) {
                    System.out.println(a);
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        } else {
            try {
                InetAddress local = InetAddress.getLocalHost();
                System.out.println(local);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
}
