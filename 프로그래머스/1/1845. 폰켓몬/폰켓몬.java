import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 최대 N/2
        int answer = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                answer++;
                map.put(nums[i], 1);
            }
        }
        
        return answer > n/2 ? n/2 : answer;
    }
}