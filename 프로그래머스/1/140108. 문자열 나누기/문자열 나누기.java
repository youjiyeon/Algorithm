class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int n = s.length();
        int idx = 0;
        int main = 0;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (idx == i) {
                main++;
                continue;
            }
            
            if (s.charAt(idx) != s.charAt(i)) {
                diff++;
            }
            else {
                main++;
            }
            
            if (main == diff){
                answer++;
                
                main = 0;
                diff = 0;
                
                idx = i+1;
            }        
        }
        
        if (main != diff) answer++;
        
        return answer;
    }
}