import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_25304_Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            // 원본 값에서 사용한 값*갯수만큼 빼주기
            total -= (val*cnt);
        }
        // 
        
        // 결과 출력
        // 빼서 원본의 값이랑 일치하면 Yes
        if(total==0){
            System.out.println("Yes");
        }
        // 아니면 No
        else System.out.println("No");
        //
    }
}
