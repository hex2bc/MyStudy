package Algorithm.mooc.pertest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 自测-5 Shuffling Machine
 * https://pintia.cn/problem-sets/17/problems/264
 * Created by hex2bc on 2019/6/14.
 */
public class ShufflingMachine {

    public static void main(String[] args) {
        String[] names = new String[] {
                "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13",
                "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13",
                "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13",
                "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13",
                "J1", "J2"
        };
        Scanner in = new Scanner(System.in);

        int repeat = in.nextInt();
        int[] cards = new int[54];

        for (int i = 0; i < 54; i++) {
            cards[i] = in.nextInt();
        }

        String[] result = new String[54];
        for (int i = 0; i < repeat; i++) {
            int index = 0;
            for (int ex : cards) {
                result[ex - 1] = names[index++];
            }
            names = result.clone();
        }

        for (int j = 0; j < 53; j++) {
            System.out.print(names[j] + ' ');
        }
        System.out.print(names[53]);
    }

    private void genCardName() {
        String[] names = new String[54];
        char[] pre = new char[] {'S', 'H', 'C', 'D', 'J'};
        int c = 0;
        int index = 1;
        for (int j = 0; j < 54; j++) {

            names[j] = "\"" + String.valueOf(pre[c]) + (index ++) + "\"";
            if (index == 14) {
                c++;
                index = 1;
            }
        }
        System.out.println(Arrays.toString(names));
    }
}
