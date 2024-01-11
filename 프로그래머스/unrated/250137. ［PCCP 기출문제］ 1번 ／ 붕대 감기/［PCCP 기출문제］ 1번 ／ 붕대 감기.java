class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int len = attacks.length;
        //System.out.println(len);
        int idx = 0;
        int tmp = health;
        int cnt = 0;
        int time = 0;
        
        while(tmp>0){
            if(time==attacks[idx][0]){
                tmp-=attacks[idx][1];
                idx++;
                cnt = 0;
                
                if(idx==len)
                    break;
                if(tmp<=0)
                    break;
            }
            
            else{
                cnt++;
                if (tmp+bandage[1]>health){
                    tmp=health;
                }
                else
                    tmp+=bandage[1];
                
                if (bandage[0]==cnt){
                    if (tmp+bandage[2]>health){
                        tmp = health;
                    }
                    else
                        tmp+=bandage[2];
                    cnt = 0;
                }
            }
            time++;
        }
        
        
        return tmp<=0 ? -1 : tmp;
    }
}