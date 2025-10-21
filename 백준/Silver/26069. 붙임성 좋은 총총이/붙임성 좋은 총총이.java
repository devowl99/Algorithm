import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Set<String> dancers;
    static String p1;
    static String p2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dancers = new HashSet<>();
        dancers.add("ChongChong");

        StringTokenizer st;
        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());

            p1 = st.nextToken();
            p2 = st.nextToken();

            if (dancers.contains(p1)) {
                dancers.add(p2);
            }
            else if (dancers.contains(p2)) {
                dancers.add(p1);
            }
        }

        System.out.println(dancers.size());
    }
}
