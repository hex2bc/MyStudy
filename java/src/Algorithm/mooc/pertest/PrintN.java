package Algorithm.mooc.pertest;

/**
 * Created by hex2bc on 2019/6/6.
 */
public class PrintN {
    
    static void printN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
    }

    static void print_n(int N) {
        if (N > 0) {
            print_n(N - 1);
            System.out.print(N + " ");
        }
    }

    public static void main(String[] args) {
        long cur = System.currentTimeMillis();
        print_n(100000);
        System.out.println();
        System.out.println(System.currentTimeMillis() - cur);

        cur = System.currentTimeMillis();
        printN(100000);
        System.out.println();
        System.out.println(System.currentTimeMillis() - cur);
    }
}
