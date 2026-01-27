import java.io.*;
import java.util.*;

public class Main {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            st.nextToken();
            count++;
        }

        System.out.println(count);
    }
}
