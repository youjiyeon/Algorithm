import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int m = p.length();
        int n = t.length();
        long val = Long.parseLong(p);
        
        for (int i = 0; i < n; i++) {
            String str = "";
            int j = i-1;
            boolean flag = false;
            while (true) {
                j++;
                
                if (j >= n || j >= i+m) break;
                
                if (t.charAt(j) == '0') {
                    if (j == i+(m-1)) {
                        flag = true;
                    }
                    if (!flag) continue;
                }
                else flag = true;
                
                str += t.charAt(j);
            }
            
            if (j==i+m && Long.parseLong(str) <= val) {
                answer++;
                //System.out.println(str);
            }
        }
        
        return answer;
    }
}