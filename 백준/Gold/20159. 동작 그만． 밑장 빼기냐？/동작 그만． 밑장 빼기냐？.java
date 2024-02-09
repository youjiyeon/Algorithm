import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []arr = new int[N];
        int []dp = new int[N];
        int []dp2 = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[N-1] = arr[N-1];
        dp[N-2] = arr[N-2];
        for (int i = N-3; i>=0; i--) {
            dp[i] = dp[i+2]+arr[i];
       } // 해당 카드로부터 끝까지 얻을 수 있는 점수
 
        dp2[0] = arr[0];
        dp2[1] = arr[1];
        for (int i = 2; i < N; i++) {
            dp2[i] = dp2[i-2]+arr[i];
       } // 해당카드까지 얻은 점수
 
        long max = Math.max(dp[1],arr[0]+dp[1]-arr[N-1]); // 첫 장과 두 번째 장에서 밑장빼기를 한 경우
 
        for (int i = 2; i < N; i++) { // 3번째 장부터 확인
            if(i%2==0){ // 정훈이의 턴에 밑장 빼기
                max = Math.max(max, dp2[i-2] + dp[i+1]);
            }
            else{ // 상대의 턴에 밑장 빼기
                max = Math.max(max, dp2[i-1] + dp[i]-arr[N-1]);
            }
        }
        long sum = dp[0];
        max = Math.max(sum,max);
 
        bw.write(String.valueOf(max)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}