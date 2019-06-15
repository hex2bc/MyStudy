package Algorithm.mooc.pertest;

import java.util.Scanner;

/**
 * 自测-1 打印沙漏
 * https://pintia.cn/problem-sets/17/problems/260
 * Created by hex2bc on 2019/6/13.
 */
public class PrintSandClock {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String b = in.next();
        printSand(a, b.charAt(0));
    }

    public static void printSand(int total, char c) {
        int stars = 1;
        int index = 0;
        while (stars <= total) {
            index ++;
            stars += (2 * index + 1) * 2;
        }
        int lines = (2 * (index - 1) + 1);

        int starPerLine = lines;
        int count = 0;
        for (int i = 1; i <= lines; i++) {
            System.out.print(fillString(starPerLine, c));
            count += starPerLine;
            System.out.println();
            if (i >= (lines / 2) + 1) {
                starPerLine += 2;
            } else {
                starPerLine -= 2;
            }
            if ((lines - starPerLine) / 2 > 0)
                System.out.print(fillString((lines - starPerLine) / 2, ' '));
        }
        System.out.println(total - count);
    }

    private static char[] fillString(int i, char c) {
        char[] ch = new char[i];
        for (int j = 0; j < i; j++) {
            ch[j] = c;
        }
        return ch;
    }
}
