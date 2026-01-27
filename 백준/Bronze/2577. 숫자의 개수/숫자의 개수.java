import java.io.*;
import java.util.*;

public class Main {
    static long A, B, C;
    static long total;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        total = A*B*C;
        String s = String.valueOf(total);
        numbers = new int[10];
        for (int i=0; i<s.length(); i++) {
            numbers[s.charAt(i)-'0'] += 1;
        }

        for (int i: numbers) {
            System.out.println(i);
        }
    }
}
