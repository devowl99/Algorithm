import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int s, e;

        Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node o) {
            if (this.e == o.e) return Integer.compare(this.s, o.s);
            return Integer.compare(this.e, o.e);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] meetings = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings[i] = new Node(s, e);
        }

        Arrays.sort(meetings);

        int count = 0;
        int lastEnd = 0;

        for (int i = 0; i < N; i++) {
            if (meetings[i].s >= lastEnd) {
                count++;
                lastEnd = meetings[i].e;
            }
        }

        System.out.println(count);
    }
}
