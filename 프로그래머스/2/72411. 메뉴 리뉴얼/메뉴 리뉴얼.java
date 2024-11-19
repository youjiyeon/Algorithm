import java.util.*;

class Solution {
    // 메뉴 저장
    Map<String, Integer> map;
    int max;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new LinkedList<>();
        
        for (int i : course) {
            map = new HashMap<>();
            max = 0;
            
            for (String str : orders) {
                char[] c = str.toCharArray();
                Arrays.sort(c);
                str = new String(c);
                
                dfs(str, "", -1, i, 0);
            }
            
            for (String key : map.keySet()) {
                int value = map.get(key);
                if (value >= 2 && max == value) {
                    list.add(key);
                }
            }
        }
        
        Collections.sort(list);
        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
    
    void dfs(String str, String key, int index, int r, int cnt) {
        if (cnt == r) {
            map.put(key, map.getOrDefault(key, 0)+1);
            max = Math.max(max, map.get(key));
        }
        
        for (int i = index+1; i < str.length(); i++) {
            dfs(str, key+str.charAt(i), i, r, cnt+1);
        }
    }
}