import java.io.*;
import java.util.*;

public class Main {
    static boolean firstCase;
    static String str;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 합이 짝수 = 백, 홀수 = 흑
        count = 0;
        for (int i=0; i<8; i++){
            str = br.readLine();
            for (int j=0; j<str.length(); j++){
                if (str.charAt(j) == 'F' && (i+j)%2 == 0){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
