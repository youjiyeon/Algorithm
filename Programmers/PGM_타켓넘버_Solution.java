class PGM_타켓넘버_Solution {
    
    public static int answer, val;
    public static int[] nums;
    public int solution(int[] numbers, int target) {
        answer = 0;
        nums = numbers;
        val = target;
        
        dfs(0,0,0);
        
        return answer;
    }
    
    public void dfs(int cnt, int start, int temp){
        
        if(cnt==nums.length){
            if(temp==val){
                answer++;
            }
            return;
        }
        
        
        dfs(cnt+1,start+1,temp+nums[start]);
        dfs(cnt+1,start+1,temp-nums[start]);
        
    }
}