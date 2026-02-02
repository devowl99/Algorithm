import java.io.*;
import java.util.*;

public class Main {
    static int origin;
    static int n;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        origin = Integer.parseInt(br.readLine());
        n = origin;

        count = 0;
        while (true){
            count++;

            int fir = n/10;
            int sec = n%10;

            n = n%10*10 + (fir+sec)%10;

            if (n == origin) break;
        }

        System.out.println(count);
    }
}
