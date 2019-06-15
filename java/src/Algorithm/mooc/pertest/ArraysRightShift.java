package Algorithm.mooc.pertest;

import java.util.Scanner;

/**
 * 自测-3 数组元素循环右移问题
 * https://pintia.cn/problem-sets/17/problems/262
 * Created by hex2bc on 2019/6/14.
 */
public class ArraysRightShift {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int shift = in.nextInt();
        int[] nums = new int[total];
        for (int i = 0; i < total; i++) {
            nums[i] = in.nextInt();
        }
        int[] result = new int[total];
        shift %= total;
        for (int j = 0; j < total; j++) {
            int s = j + shift;
            s %= total;
            result[s] = nums[j];
        }
        for (int k = 0; k < total - 1; k++) {
            System.out.print(result[k] + " ");
        }
        System.out.print(result[total - 1]);
    }
}
