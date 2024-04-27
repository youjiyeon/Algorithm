import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int n = name.length;
        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int t = photo.length;
        int[] answer = new int[t];
        for (int i = 0; i < t; i++) {
            int tmp = 0;
            for (int j = 0; j < photo[i].length; j++) {
                tmp += map.getOrDefault(photo[i][j], 0);
            }
            answer[i] = tmp;
        }
        return answer;
    }
}