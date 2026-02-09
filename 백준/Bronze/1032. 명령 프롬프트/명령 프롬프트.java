import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] strArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        strArr = new String[N];
        for (int n=0; n<N; n++){
            strArr[n] = br.readLine();
        }

        for (int n=1; n<N; n++){
            for (int i=0; i<strArr[0].length(); i++){
                if (strArr[0].charAt(i) != strArr[n].charAt(i)){
                    if (strArr[0].charAt(i) != '?'){
                        char[] arr = strArr[0].toCharArray();
                        arr[i] = '?';
                        strArr[0] = new String(arr);
                    }
                }
            }
        }

        System.out.println(strArr[0]);
    }
}
