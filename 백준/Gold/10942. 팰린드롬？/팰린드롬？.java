import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static boolean[][] dp; // s부터 e까지 팰린드롬 유무 저장
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new boolean[N+1][N+1];
        
        // 수열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 팰린드롬 유무 저장 단계
        for (int i = 1; i <= N; i++) {
            dp[i][i]=true;
            if(arr[i]==arr[i-1]){
                dp[i-1][i] = true;
            }
        }

        // i는 s와 e 사이의 거리
        for (int i = 2; i <= N-1; i++) {
            for (int j = 1; j <= N-i; j++) {
                // 양끝값이 같고 그 사이의 값도 팰린드롬이어야 함
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]){
                    dp[j][j+i] = true;
                }
            }
        }
        
        // 홍준이의 질문
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(dp[s][e]) sb.append(1);
            else sb.append(0);

            sb.append("\n");
        }
        
        System.out.println(sb);
    }

}
