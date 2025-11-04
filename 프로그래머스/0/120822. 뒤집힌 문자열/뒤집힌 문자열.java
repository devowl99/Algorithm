import java.util.*;

class Solution {
    static List<Character> list;
    
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        list = new ArrayList<>();
        for (int i=0; i<my_string.length(); i++){
            list.add(my_string.charAt(i));
        }
        
        Collections.reverse(list);
        for (char c: list){
            sb.append(c);
        }
        
        return sb.toString();
    }
}