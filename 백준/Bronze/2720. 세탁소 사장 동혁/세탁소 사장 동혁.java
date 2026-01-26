import java.io.*;

public class Main {
    static int T;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(N/25).append(" ");
            sb.append((N%25)/10).append(" ");
            sb.append(((N%25)%10)/5).append(" ");
            sb.append(((N%25)%10)%5).append("\n");
        }
        System.out.println(sb);
    }
}
