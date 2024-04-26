import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            String name1 = callings[i];
            int tmp = map.get(name1);
            
            String name2 = players[tmp-1];
            players[tmp-1] = name1;
            players[tmp] = name2;
            
            map.put(name1, tmp-1);
            map.put(name2, tmp);
        }
        
        return players;
    }
}