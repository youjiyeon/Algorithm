class Solution {
    public static int n, t, ans;
    public static int[] num;
    public int solution(int[] numbers, int target) {
        ans = 0;
        n = numbers.length;
        t = target;
        num = numbers.clone();
        
        dfs(0,0);
        return ans;
    }
    
    public static void dfs(int cnt, int sum){
        if(cnt==n){
            if(sum==t){
                ans++;
            }
            return;
        }
        
        dfs(cnt+1, sum+num[cnt]);
        dfs(cnt+1, sum-num[cnt]);
    }
}