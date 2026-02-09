import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            nums[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        System.out.println(nums[0]*nums[N-1]);
    }
}
