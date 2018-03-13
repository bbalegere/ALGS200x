import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] minops = new int[n + 1];
        int[] ops = new int[n + 1];
        minops[0] = 0;
        ops[0] = 0;
        minops[1] = 0;
        ops[1] = 1;

        for (int i = 2; i <= n; i++) {
            minops[i] = minops[i - 1] + 1;
            ops[i] = 1;

            if (i % 3 == 0 && ((minops[i / 3] + 1) < minops[i])) {
                minops[i] = minops[i / 3] + 1;
                ops[i] = 3;
            }
            if (i % 2 == 0 && ((minops[i / 2] + 1) < minops[i])) {
                minops[i] = minops[i / 2] + 1;
                ops[i] = 2;
            }
        }
        List<Integer> sequence = new ArrayList<>();
        while (n >= 1) {
            sequence.add(n);
            if (ops[n] == 2 || ops[n] == 3) {
                n /= ops[n];
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

