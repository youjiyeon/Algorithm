import java.util.*;
class Solution {
    static String[] arr = {"A","E","I","O","U"};
    static Map<String, Integer> map;
    static int cnt = 1;
    public int solution(String word) {
        map = new HashMap<>();
        
        for (int i = 0; i < 5; i++) {
            make(arr[i], 1);
        }
        
        return map.get(word);
    }
    
    static void make(String base, int depth){
        map.put(base, cnt++);
        if(depth == 5){
            return;
        }
        for(int i = 0 ; i < 5; ++i)
            make(base + arr[i], depth + 1);
    }
}