package Algorithm.mooc.pertest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 自测-4 Have Fun with Numbers
 * https://pintia.cn/problem-sets/17/problems/263
 * Created by hex2bc on 2019/6/14.
 */
public class FunNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.next();
        char[] cNum = num.toCharArray();
        char[] result = new char[cNum.length];
        int flag = 0;
        for (int i = cNum.length - 1; i >= 0; i--) {
            int n = (cNum[i] - 48) * 2 + flag;
            if (n > 9) {
                flag = 1;
                n -= 10;
            } else {
                flag  = 0;
            }
            result[i] = (char) (n + 48);
        }
        char[] copy = result.clone();
        Arrays.sort(cNum);
        Arrays.sort(copy);
        if (flag == 0 && String.valueOf(cNum).equals(String.valueOf(copy))) {
            System.out.println("Yes");
            System.out.print(result);
        } else {
            System.out.println("No");
            if (flag == 1)
                System.out.print('1');
            System.out.print(result);
        }
    }
}
