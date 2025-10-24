import java.io.*;
import java.util.*;

public class Main {
    static String word1;
    static String word2;
    static String ansWord;
    static Map<Character, Integer> map;
    static boolean[] isSelected;
    static int[] nums;
    static boolean ansExist = false;

    static char[] keys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        word1 = st.nextToken();
        word2 = st.nextToken();
        ansWord = st.nextToken();

        map = new HashMap<>();

        for (int i=0; i<word1.length(); i++){
            map.put(word1.charAt(i), -1);
        }
        for (int i=0; i<word2.length(); i++){
            map.put(word2.charAt(i), -1);
        }
        for (int i=0; i<ansWord.length(); i++){
            map.put(ansWord.charAt(i), -1);
        }

        keys = new char[map.size()];
        int i = 0;
        for (char c : map.keySet()){
            keys[i++] = c;
        }

        isSelected = new boolean[10];
        nums = new int[map.size()];
        dfs(0);

        System.out.println(ansExist? "YES" : "NO");
    }

    static void dfs(int depth){
        if (ansExist) return;

        int mapLen = map.size();
        if (depth == mapLen){
            for (int i = 0; i < keys.length; i++)
                map.put(keys[i], nums[i]);
            calculate();
            return;
        }

        for (int i=0; i<10; i++){
            if (isSelected[i]) continue;

            isSelected[i] = true;
            nums[depth] = i;
            dfs(depth+1);
            isSelected[i] = false;
        }
    }

    static void calculate(){
        long num1 = 0;
        for (int i=0; i<word1.length(); i++){
            num1 = num1 * 10 + map.get(word1.charAt(i));
        }

        long num2 = 0;
        for (int i=0; i<word2.length(); i++){
            num2 = num2 * 10 + map.get(word2.charAt(i));
        }

        long num3 = 0;
        for (int i=0; i<ansWord.length(); i++){
            num3 = num3 * 10 + map.get(ansWord.charAt(i));
        }

        if (num1+num2 == num3) ansExist = true;
    }
}
